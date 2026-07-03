package p507d0.p580t;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.m */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12145m {
    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z2) {
        C12238m.checkNotNullParameter(tArr, "$this$copyToArrayOfAny");
        if (z2 && C12238m.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        C12238m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        C12238m.checkNotNullExpressionValue(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$shuffled");
        List<T> mutableList = C12163u.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }
}
