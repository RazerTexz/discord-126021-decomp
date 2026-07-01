package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0$b implements Action0 {
    public final /* synthetic */ Throwable j;
    public final /* synthetic */ r0 k;

    public r0$b(r0 r0Var, Throwable th) {
        this.k = r0Var;
        this.j = th;
    }

    @Override // rx.functions.Action0
    public void call() {
        r0 r0Var = this.k;
        if (r0Var.j) {
            return;
        }
        r0Var.j = true;
        r0Var.l.onError(this.j);
        this.k.k.unsubscribe();
    }
}
