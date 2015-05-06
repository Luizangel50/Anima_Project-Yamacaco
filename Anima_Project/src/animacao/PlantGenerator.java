package animacao;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import static animacao.Util.addChildToParent;


class PlantGenerator {

    Group content;
    private final int numBlades;

    public PlantGenerator(Group content, int numBlades) {
        this.content = content;
        this.numBlades = numBlades;
    }

    public List<Blade> generateGrass() {


        List<Blade> grass = new ArrayList<Blade>(numBlades);
        for (int i = 0; i < numBlades; i++) {

            final Blade blade = new Blade();
            grass.add(blade);

            addChildToParent(content, blade);
        }
        return grass;
    }
}
