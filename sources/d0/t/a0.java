package d0.t;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0<T> implements Iterable<z<? extends T>>, d0.z.d.g0.a {
    public final Function0<Iterator<T>> j;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Function0<? extends Iterator<? extends T>> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "iteratorFactory");
        this.j = function0;
    }

    @Override // java.lang.Iterable
    public Iterator<z<T>> iterator() {
        return new b0(this.j.invoke());
    }
}
