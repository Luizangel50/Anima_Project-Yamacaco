package animacao;

import static java.lang.Math.random;
import java.util.List;
import javafx.animation.*;
import javafx.util.Duration;

public class Animator implements Runnable {

    public static final Duration GRASS_BECOME_GREEN_DURATION = Duration.seconds(5);
    public static final Duration GRASS_BECOME_YELLOW_DURATION = Duration.seconds(5);
    public static final Duration FISH_GET_ANIMATED = Duration.seconds(5);
    private FishGenerator fishGenerator;
    private PlantGenerator plantGenerator;
    private FishAnimation fishAnimation;

    Animator(FishGenerator fishGenerator, PlantGenerator plantGenerator) {
        this.fishGenerator = fishGenerator;
        this.plantGenerator = plantGenerator;
    }

    @Override
    public void run() {

        Fish fish = fishGenerator.generateFish();
        List<Blade> grass = plantGenerator.generateGrass();

        final Transition all = new ParallelTransition(new PlantAnimation(grass), new SequentialTransition(seasonsAnimation(fish, grass)));
        fishAnimation = new FishAnimation(fish);
        fishAnimation.start();
        all.play();

    }

    @SuppressWarnings("deprecation")
	private Transition seasonsAnimation(final Fish fish, final List<Blade> grass) {

        Transition spring = animateSpring(grass);
        Transition autumn = animateAutumn(grass);
        return SequentialTransitionBuilder.create().children(spring, autumn).cycleCount(Animation.INDEFINITE).build();
    }

    @SuppressWarnings("deprecation")
	private Transition animateSpring(List<Blade> grass) {
        ParallelTransition springAnimation = new ParallelTransition();
        for (final Blade blade : grass) {
            //grass become green
            springAnimation.getChildren().add(FillTransitionBuilder.create().shape(blade).toValue(blade.SPRING_COLOR).duration(GRASS_BECOME_GREEN_DURATION).build());
        }
        
        return springAnimation;
    }

    @SuppressWarnings("deprecation")
	private Transition animateAutumn(List<Blade> grass) {
        ParallelTransition autumn = new ParallelTransition();

        //Grass animation
        ParallelTransition grassBecomeYellowAnimation = new ParallelTransition();
        for (final Blade blade : grass) {
            //become yellow            
            final FillTransition toYellow = FillTransitionBuilder.create().shape(blade).toValue(blade.AUTUMN_COLOR).delay(Duration.seconds(1 * random())).duration(GRASS_BECOME_YELLOW_DURATION).build();
            grassBecomeYellowAnimation.getChildren().add(toYellow);
        }

        autumn.getChildren().addAll(grassBecomeYellowAnimation);
        return autumn;
    }
    
}
