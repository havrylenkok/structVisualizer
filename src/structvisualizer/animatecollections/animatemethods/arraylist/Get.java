package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * GetIndex   3/29/16, 16:30
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import static structvisualizer.animatecollections.animatemethods.arraylist.Construct.createArrayList;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Get extends AnimateMethod implements MethodsForSearch {
    Object indexOf;
    int index;

    public Get(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        this.indexOf = indexOf;
        this.index = index;
    }

    @Override
    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
        GetIndex searchObj = new GetIndex(canvasPane, type, customClass, indexOf,
                                          index);
        searchObj.animateSearch(redRectangle, fromX, fromY, toX, toY, canvas);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {

//        ArrayList<StackPane> rectangles = createArrayList(type);
//        canvasPane.getChildren().addAll(rectangles);
//        AnimateMethod.setTooltip(rectangles, type, customClass);
//
//        StackPane sp = newStackPane(0, 0, canvasPane, data.getHightlightColor());
//
//        double finalX = 0;
//        if(type == Types.INT) finalX += data.getWidth();
//        for(int i = 0; i < data.getNumOfStackPanes(); i++) {
//            String text = rectangles.get(i).getChildren().get(1).toString();
//            // indexOf - VALUE OF ELEMENT WHAT WE LOOKING FOR
//            if(!text.substring(11, 12).equals(indexOf)) {
//                finalX += data.getWidth();
//            }
//        }
//        animateSearch(sp, 0, 0, finalX, 0, canvasPane);
        Set.searchForElement(this, type, canvasPane, customClass, indexOf, index);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.get(" + index + ")\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        results = "The value is " + indexOf;
        return results;
    }
}
