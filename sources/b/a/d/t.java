package b.a.d;

import rx.Observable;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t<T, R> implements j0.k.b<T, Observable<? extends T>> {
    public final /* synthetic */ o$d j;

    public t(o$d o_d) {
        this.j = o_d;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        if (((Boolean) this.j.j.invoke(obj)).booleanValue()) {
            return new j0.l.e.k(obj);
        }
        j0.l.e.k kVar = new j0.l.e.k(this.j.k);
        o$d o_d = this.j;
        return kVar.q(o_d.l, o_d.m);
    }
}
