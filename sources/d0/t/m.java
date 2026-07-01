package d0.t;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z2) {
        d0.z.d.m.checkNotNullParameter(tArr, "$this$copyToArrayOfAny");
        if (z2 && d0.z.d.m.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        d0.z.d.m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        d0.z.d.m.checkNotNullExpressionValue(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        d0.z.d.m.checkNotNullParameter(iterable, "$this$shuffled");
        List<T> mutableList = u.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }
}
