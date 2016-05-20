package structvisualizer.valuefactories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import structvisualizer.animatecollections.animatemethods.MethodsForSearch;
import structvisualizer.data.Collections;
import structvisualizer.data.Methods;
import structvisualizer.data.Types;


/**
 * Factory for combobox values in javafx app and also for animation API
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class ListValuesFactory {

    private static final ObservableList<String> collectionOptions = FXCollections.observableArrayList(
            Collections.ARRAY_LIST,
//            Collections.HASH_MAP,
            Collections.STACK
//            Collections.SET
    );

    /**
     *
     */
    private static final ObservableList<String> methodsArrayList = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.ADD,
            Methods.CLEAR,
            Methods.CONTAINS,
            Methods.REMOVE,
            Methods.CLONE,
            Methods.GET,
            Methods.SET,
            Methods.GET_INDEX,
            Methods.SORT,
            Methods.SUBLIST
    );
    private static final ObservableList<String> methodsStack = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.PEEK,
            Methods.POP,
            Methods.PUSH,
            Methods.SEARCH
    );
    private static final ObservableList<String> methodsHashMap = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.CONTAINS_KEY,
            Methods.CONTAINS_VALUE,
            Methods.GET,
            Methods.PUT,
            Methods.REMOVE,
            Methods.REPLACE,
            Methods.VALUES
    );
    private static final ObservableList<String> methodsSet = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.ADD,
            Methods.CLEAR,
            Methods.CONTAINS,
            Methods.REMOVE
    );
    private static final ObservableList<String> types = FXCollections.observableArrayList(
            Types.INT,
            Types.STRING,
            Types.SOME_CLASS,
            Types.CUSTOM
    );

    private static final ObservableList<String> needsInput = FXCollections.observableArrayList(
            Methods.CONTAINS,
            Methods.GET,
            Methods.GET_INDEX,
            Methods.REMOVE,
            Methods.SET,
            Methods.SUBLIST,
            Methods.SEARCH
    );

    /**
     * @see MethodsForSearch
     * @see structvisualizer.animatecollections.animatemethods.arraylist.Sublist
     * @return list of MethodsForSearch classes and Arraylist.Sublist
     */
    public static ObservableList<String> getNeedsInput() {
        return needsInput;
    }

    /**
     * getter
     *
     * @param collection string with name of collection
     * @return ObservableList<String> of methods for INPUT collection-type
     */
    public static ObservableList<String> getMethodsValues(String collection) {
        switch (collection) {
            case Collections.ARRAY_LIST:
                return methodsArrayList;
//            case Collections.HASH_MAP:
//                return methodsHashMap;
            case Collections.STACK:
                return methodsStack;
//            case Collections.SET:
//                return methodsSet;
            default:
                return FXCollections.emptyObservableList();

        }
    }

    /**
     * getter
     *
     * @return
     */
    public static ObservableList<String> getCollectionOptions() {
        return collectionOptions;
    }

    /**
     * getter
     *
     * @return
     */
    public static ObservableList<String> getTypesOptions() {
        return types;
    }
}
