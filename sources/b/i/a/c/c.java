package b.i.a.c;

import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ t0$a j;
    public final /* synthetic */ int k;

    public /* synthetic */ c(t0$a t0_a, int i) {
        this.j = t0_a;
        this.k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t0$a t0_a = this.j;
        int i = this.k;
        t0 t0Var = t0_a.k;
        Objects.requireNonNull(t0Var);
        if (i == -3 || i == -2) {
            if (i != -2) {
                b.i.a.c.t2.o oVar = t0Var.d;
                if (!(oVar != null && oVar.k == 1)) {
                    t0Var.d(3);
                    return;
                }
            }
            t0Var.b(0);
            t0Var.d(2);
            return;
        }
        if (i == -1) {
            t0Var.b(-1);
            t0Var.a();
        } else if (i != 1) {
            b.d.b.a.a.g0(38, "Unknown focus change type: ", i, "AudioFocusManager");
        } else {
            t0Var.d(1);
            t0Var.b(1);
        }
    }
}
