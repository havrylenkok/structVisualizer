package structvisualizer.data;

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
    final String SET = "set(int index, E e)";
    final String GET_INDEX = "getIndex(O o)";
    final String SORT = "sort()";
    final String SUBLIST = "sublist(int fr, int to)";
    final String PEEK = "peek()";
    final String POP = "pop()";
    final String PUSH = "push(E e)";
    final String SEARCH = "search(O o)";
    final String CONTAINS_KEY = "containsKey(O key)";
    final String CONTAINS_VALUE = "containsValue(O val)";
    final String REPLACE = "replace(K k, V v)";
    final String VALUES = "values()";
    final String PUT = "put(K k, V v)";

}
