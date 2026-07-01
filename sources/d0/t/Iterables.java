package d0.t;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.t.a0, reason: use source file name */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Iterables<T> implements Iterable<IndexedValue<? extends T>>, KMarkers {
    public final Function0<Iterator<T>> j;

    /* JADX WARN: Multi-variable type inference failed */
    public Iterables(Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics3.checkNotNullParameter(function0, "iteratorFactory");
        this.j = function0;
    }

    @Override // java.lang.Iterable
    public Iterator<IndexedValue<T>> iterator() {
        return new Iterators3(this.j.invoke());
    }
}
