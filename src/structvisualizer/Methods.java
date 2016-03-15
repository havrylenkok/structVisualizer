package structvisualizer;
 /*
 * Methods   3/15/16, 16:12
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

/**
 * Enum interface with strings for animation API and comboboxes in GUI javafx
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public interface Methods {
    final String CONSTRUCT = "()";
    final String ADD = "add(E e)";
    final String CLEAR = "clear()";
    final String CONTAINS = "contains()";
    final String EQUALS = "O.equals(O o)";
    final String IS_EMPTY = "isEmpty()";
    final String REMOVE = "remove(E e)";
    final String SIZE = "size()";
    final String CLONE = "clone()";
    final String GET = "get(int index)";
    final String SET = "set()"; // TODO: params
    final String GET_INDEX = "getIndex()"; // TODO: params
    final String SORT = "sort()";
    final String SUBLIST = "sublist()";
    final String PEEK = "peek()";
    final String POP = "pop()"; // TODO: params
    final String PUSH = "push()"; // TODO: params
    final String SEARCH = "search()"; // TODO: params
    final String CONTAINS_KEY = "containsKey()"; // TODO: params
    final String CONTAINS_VALUE = "containsValue()"; // TODO: params
    final String REPLACE = "replace()"; // TODO: params
    final String VALUES = "values()"; // TODO: params
    final String PUT = "put()"; // TODO: params

}
