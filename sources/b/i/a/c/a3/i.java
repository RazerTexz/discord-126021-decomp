package b.i.a.c.a3;

import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ e0 j;

    public /* synthetic */ i(e0 e0Var) {
        this.j = e0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 e0Var = this.j;
        if (e0Var.W) {
            return;
        }
        x$a x_a = e0Var.B;
        Objects.requireNonNull(x_a);
        x_a.a(e0Var);
    }
}
