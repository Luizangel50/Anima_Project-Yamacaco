package animacao;

import javafx.scene.Group;
import static animacao.Util.addChildToParent;
import java.util.Random;;

public class FishGenerator {

    //public static final int FISH_NUMBER = 5;
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 500;
    public Group content;
    public int numberFishes;
    private Random gerador = new Random();

    public FishGenerator(Group content, int numberFishes) {
        this.content = content;
        this.numberFishes = numberFishes;
    }

    public Fish generateFish() {
        Fish fish = new Fish(numberFishes);
        addChildToParent(content, fish);

        for (int i = 0; i < numberFishes; i++) {
        	fish.fishes1.get(i).setLayoutX(gerador.nextInt(SCENE_WIDTH));
        	fish.fishes1.get(i).setLayoutY(SCENE_HEIGHT/2 - i*50);
        	
        	fish.fishes2.get(i).setLayoutX(-gerador.nextInt(SCENE_WIDTH));
        	fish.fishes2.get(i).setLayoutY(SCENE_HEIGHT/2 - i*50);
        }
        
        return fish;
    }

}
