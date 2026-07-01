package b.a.d;

import rx.Observable;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z<T, R> implements j0.k.b<T, Observable<? extends R>> {
    public final /* synthetic */ a0 j;

    public z(a0 a0Var) {
        this.j = a0Var;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        return ((Boolean) this.j.j.invoke(obj)).booleanValue() ? (Observable) this.j.k.invoke(obj) : (Observable) this.j.l.invoke(obj);
    }
}
