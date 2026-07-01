package b.i.a.f.i.b;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j8 implements Runnable {
    public final /* synthetic */ i3 j;
    public final /* synthetic */ k8 k;

    public j8(k8 k8Var, i3 i3Var) {
        this.k = k8Var;
        this.j = i3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.k) {
            this.k.j = false;
            if (!this.k.l.B()) {
                this.k.l.g().n.a("Connected to service");
                q7 q7Var = this.k.l;
                i3 i3Var = this.j;
                q7Var.b();
                Objects.requireNonNull(i3Var, "null reference");
                q7Var.d = i3Var;
                q7Var.F();
                q7Var.H();
            }
        }
    }
}
