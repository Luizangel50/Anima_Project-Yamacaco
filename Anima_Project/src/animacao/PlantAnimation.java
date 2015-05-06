package animacao;

import static java.lang.Math.PI;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.Duration;

class PlantAnimation extends Transition {

    final private Duration animationTime = Duration.seconds(6);
    final private DoubleProperty phase = new SimpleDoubleProperty(0);

    public PlantAnimation(List<Blade> blades) {

        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        setCycleDuration(animationTime);
        for (Blade blade : blades) {
            blade.phase.bind(phase);
        }
    }

    @Override
    protected void interpolate(double frac) {
        phase.set(frac*2*PI);
    }
}
