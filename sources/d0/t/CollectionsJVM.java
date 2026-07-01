package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.t.m, reason: use source file name */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CollectionsJVM {
    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$copyToArrayOfAny");
        if (z2 && Intrinsics3.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics3.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics3.checkNotNullExpressionValue(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$shuffled");
        List<T> mutableList = _Collections.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }
}
