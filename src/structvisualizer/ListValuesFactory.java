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
            "()",
            "add(E e)",
            "clear",
            "contains(Object o)",
            "equals(Object o)",
            "isEmpty()",
            "remove(Object o)",
            "size()",
            "clone()",
            "get(int index)",
            "set(int ind, E el",
            "indexOf(Object o)",
            "sort(Comparator c)",
            "subList(int fromInd, int toInd)"
            );
    private static final ObservableList<String> methodsStack = FXCollections.observableArrayList(
            "()",
            "empty()",
            "peek()",
            "pop()",
            "push(E item)",
            "search(Object o)"
    );
    private static final ObservableList<String> methodsHashMap = FXCollections.observableArrayList(
            "()",
            "clear()",
            "clone()",
            "containsKey(Object ket)",
            "containsValue(Object val)",
            "get(Object key",
            "isEmpty()",
            "put(K key, V val)",
            "remove (Object key",
            "replace(K key, V val)",
            "size()",
            "values()"
    );
    private static final ObservableList<String> methodsSet = FXCollections.observableArrayList (
            "()",
            "add(E e)",
            "clear()",
            "contains(Object o)",
            "contains(Object o)",
            "equals(Object o",
            "isEmpty()",
            "size()",
            "remove(Object o"
    );
    private static final ObservableList<String> types = FXCollections.observableArrayList(
            "Integer",
            "String"
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
