package d0.u;

import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: d0.u.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class C0420a<T> implements Comparator {
        public final /* synthetic */ Function1[] j;

        public C0420a(Function1[] function1Arr) {
            this.j = function1Arr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.access$compareValuesByImpl(t, t2, this.j);
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator j;
        public final /* synthetic */ Comparator k;

        public b(Comparator comparator, Comparator comparator2) {
            this.j = comparator;
            this.k = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.j.compare(t, t2);
            return iCompare != 0 ? iCompare : this.k.compare(t, t2);
        }
    }

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
        Intrinsics3.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new C0420a(function1Arr);
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
        Intrinsics3.checkNotNullParameter(comparator, "$this$then");
        Intrinsics3.checkNotNullParameter(comparator2, "comparator");
        return new b(comparator, comparator2);
    }
}
