package animacao;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Fish extends Group{
	
	private static final String fish1_ = Main.class.getResource("Fish-1.gif").toExternalForm();
	private static final String fish2_ = Main.class.getResource("Fish-2.gif").toExternalForm();
	Image fish1 = new Image(fish1_);
    Image fish2 = new Image(fish2_);
	
    ArrayList<Rectangle> fishes1 = new ArrayList<Rectangle>();
    ArrayList<Rectangle> fishes2 = new ArrayList<Rectangle>();
 
    public Fish(int number) {

    	for (int i = 0; i < number; i++) {
    		//insert blue fish
    		Rectangle a = new Rectangle(150, 150);
        	a.setFill(new ImagePattern(fish1, 0, 0, 1, 1, true));
        	a.setRotate(180);
        	this.getChildren().add(a);
    		this.fishes1.add(a);
    		
    		//insert gold fish
    		Rectangle b = new Rectangle(150, 150);
        	b.setFill(new ImagePattern(fish2, 0, 0, 1, 1, true));
        	this.getChildren().add(b);
    		this.fishes2.add(b);
    	}
    }
}
