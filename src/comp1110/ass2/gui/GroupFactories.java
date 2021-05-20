package comp1110.ass2.gui;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * @author Mukund Balaji Srinivas
 **/
public class GroupFactories extends Pane {
    public static final int MARGIN = 50;
    public int nFacs;
    public ArrayList<Integer> gaps = new ArrayList<>();
    public ArrayList<Factory> factories = new ArrayList<>();

    public GroupFactories(int nFacs) {
        this.nFacs = nFacs;
        gaps.set(0, 50);
        for (int i = 1; i < nFacs; i++) {
            gaps.add(gaps.get(i - 1) + 150);
        }
        Factory t;
        for (int i = 0; i < nFacs; i++) {
            t = new Factory(gaps.get(i),MARGIN);
            factories.add(t);
        }
        this.getChildren().addAll(factories);
    }
}
