package lombok.patcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/patcher/Symbols.SCL.lombok */
public class Symbols {
    private static final ThreadLocal<LinkedList<String>> stack = new Symbols$1();

    private Symbols() {
    }

    public static void push(String symbol) {
        stack.get().addFirst(symbol);
    }

    public static void pop() {
        stack.get().poll();
    }

    public static boolean isEmpty() {
        return stack.get().isEmpty();
    }

    public static int size() {
        return stack.get().size();
    }

    public static boolean hasSymbol(String symbol) {
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        return stack.get().contains(symbol);
    }

    public static boolean hasTail(String symbol) {
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        return symbol.equals(stack.get().peek());
    }

    public static List<String> getCopy() {
        return new ArrayList(stack.get());
    }
}
