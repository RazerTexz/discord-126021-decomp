package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0$c implements Action0 {
    public final /* synthetic */ Object j;
    public final /* synthetic */ r0 k;

    public r0$c(r0 r0Var, Object obj) {
        this.k = r0Var;
        this.j = obj;
    }

    @Override // rx.functions.Action0
    public void call() {
        r0 r0Var = this.k;
        if (r0Var.j) {
            return;
        }
        r0Var.l.onNext(this.j);
    }
}
