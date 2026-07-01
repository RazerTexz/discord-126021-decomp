package b.i.a.f.i.b;

import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u8 implements Runnable {
    public final /* synthetic */ k9 j;
    public final /* synthetic */ Runnable k;

    public u8(k9 k9Var, Runnable runnable) {
        this.j = k9Var;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.R();
        k9 k9Var = this.j;
        Runnable runnable = this.k;
        k9Var.U();
        if (k9Var.o == null) {
            k9Var.o = new ArrayList();
        }
        k9Var.o.add(runnable);
        this.j.Q();
    }
}
