package structvisualizer;

/*
 * ListValuesFactory   3/13/16, 21:34
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;



/**
 * <what class do>
 *
 * @see
 *
 * @author Kyrylo Havrylenko
 *
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
    private static final ObservableList<String> methodsSet = FXCollections.observableArrayList (
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
            Types.STRING
    );

    /**
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
     * @return
     */
    public static ObservableList<String> getCollectionOptions() {
        return collectionOptions;
    }

    /**
     * getter
     * @return
     */
    public static ObservableList<String> getTypesOptions() {
        return types;
    }
}
