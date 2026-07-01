package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Iterator;

/* JADX INFO: renamed from: d0.t.p, reason: use source file name */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Iterators7 extends Iterables2 {
    public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> it) {
        Intrinsics3.checkNotNullParameter(it, "$this$withIndex");
        return new Iterators3(it);
    }
}
