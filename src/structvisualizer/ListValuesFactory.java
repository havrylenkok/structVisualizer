package structvisualizer;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;


/**
 * Factory for combobox values in javafx app and also for animation API
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class ListValuesFactory {

    private static final ObservableList<String> collectionOptions = FXCollections.observableArrayList(
            Collections.ARRAY_LIST,
            Collections.HASH_MAP,
            Collections.STACK,
            Collections.SET
    );

    private static final ObservableList<String> methodsArrayList = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.ADD,
            Methods.CLEAR,
            Methods.CONTAINS,
            Methods.EQUALS,
            Methods.IS_EMPTY,
            Methods.REMOVE,
            Methods.SIZE,
            Methods.CLONE,
            Methods.GET,
            Methods.SET,
            Methods.GET_INDEX,
            Methods.SORT,
            Methods.SUBLIST
    );
    private static final ObservableList<String> methodsStack = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.IS_EMPTY,
            Methods.PEEK,
            Methods.POP,
            Methods.PUSH,
            Methods.SEARCH
    );
    private static final ObservableList<String> methodsHashMap = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.CLEAR,
            Methods.CLONE,
            Methods.CONTAINS_KEY,
            Methods.CONTAINS_VALUE,
            Methods.GET,
            Methods.IS_EMPTY,
            Methods.PUT,
            Methods.REMOVE,
            Methods.REPLACE,
            Methods.SIZE,
            Methods.VALUES
    );
    private static final ObservableList<String> methodsSet = FXCollections.observableArrayList(
            Methods.CONSTRUCT,
            Methods.ADD,
            Methods.CLEAR,
            Methods.CONTAINS,
            Methods.EQUALS,
            Methods.IS_EMPTY,
            Methods.SIZE,
            Methods.REMOVE
    );
    private static final ObservableList<String> types = FXCollections.observableArrayList(
            Types.INT,
            Types.STRING,
            Types.SOME_CLASS,
            Types.CUSTOM
    );

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
            case Collections.HASH_MAP:
                return methodsHashMap;
            case Collections.STACK:
                return methodsStack;
            case Collections.SET:
                return methodsSet;
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
