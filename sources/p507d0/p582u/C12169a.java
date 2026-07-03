package p507d0.p582u;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.u.a */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12169a {

    /* JADX INFO: renamed from: d0.u.a$a */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Function1[] f25226j;

        public a(Function1[] function1Arr) {
            this.f25226j = function1Arr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return C12169a.access$compareValuesByImpl(t, t2, this.f25226j);
        }
    }

    /* JADX INFO: renamed from: d0.u.a$b */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Comparator f25227j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Comparator f25228k;

        public b(Comparator comparator, Comparator comparator2) {
            this.f25227j = comparator;
            this.f25228k = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f25227j.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f25228k.compare(t, t2);
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
        C12238m.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new a(function1Arr);
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
        return C12171c.f25229j;
    }

    public static final <T> Comparator<T> then(Comparator<T> comparator, Comparator<? super T> comparator2) {
        C12238m.checkNotNullParameter(comparator, "$this$then");
        C12238m.checkNotNullParameter(comparator2, "comparator");
        return new b(comparator, comparator2);
    }
}
