package b.a.d;

import b.a.d.o;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t<T, R> implements Func1<T, Observable<? extends T>> {
    public final /* synthetic */ o.d j;

    public t(o.d dVar) {
        this.j = dVar;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        if (((Boolean) this.j.j.invoke(obj)).booleanValue()) {
            return new ScalarSynchronousObservable(obj);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(this.j.k);
        o.d dVar = this.j;
        return scalarSynchronousObservable.q(dVar.l, dVar.m);
    }
}
