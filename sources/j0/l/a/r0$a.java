package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0$a implements Action0 {
    public final /* synthetic */ r0 j;

    public r0$a(r0 r0Var) {
        this.j = r0Var;
    }

    @Override // rx.functions.Action0
    public void call() {
        r0 r0Var = this.j;
        if (r0Var.j) {
            return;
        }
        r0Var.j = true;
        r0Var.l.onCompleted();
    }
}
