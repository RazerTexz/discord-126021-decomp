package d0.u;

import d0.z.d.m;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final int access$compareValuesByImpl(Object obj, Object obj2, Function1[] function1Arr) {
        for (Function1 function1 : function1Arr) {
            int iCompareValues = compareValues((Comparable) function1.invoke(obj), (Comparable) function1.invoke(obj2));
            if (iCompareValues != 0) {
                return iCompareValues;
            }
        }
        return 0;
    }

    public static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        m.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new a$a(function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return c.j;
    }

    public static final <T> Comparator<T> then(Comparator<T> comparator, Comparator<? super T> comparator2) {
        m.checkNotNullParameter(comparator, "$this$then");
        m.checkNotNullParameter(comparator2, "comparator");
        return new a$b(comparator, comparator2);
    }
}
