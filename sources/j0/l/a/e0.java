package j0.l.a;

import rx.Observable;

/* JADX INFO: compiled from: OnSubscribeSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0<T> implements j0.h$a<T> {
    public final Observable<T> j;

    public e0(Observable<T> observable) {
        this.j = observable;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        j0.i iVar = (j0.i) obj;
        d0 d0Var = new d0(this, iVar);
        iVar.j.a(d0Var);
        this.j.i0(d0Var);
    }
}
