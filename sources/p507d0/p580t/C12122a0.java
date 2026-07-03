package p507d0.p580t;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.a0 */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12122a0<T> implements Iterable<C12168z<? extends T>>, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public final Function0<Iterator<T>> f25172j;

    /* JADX WARN: Multi-variable type inference failed */
    public C12122a0(Function0<? extends Iterator<? extends T>> function0) {
        C12238m.checkNotNullParameter(function0, "iteratorFactory");
        this.f25172j = function0;
    }

    @Override // java.lang.Iterable
    public Iterator<C12168z<T>> iterator() {
        return new C12124b0(this.f25172j.invoke());
    }
}
