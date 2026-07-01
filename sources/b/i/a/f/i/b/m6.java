package b.i.a.f.i.b;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m6 implements Runnable {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ c6 k;

    public m6(c6 c6Var, AtomicReference atomicReference) {
        this.k = c6Var;
        this.j = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.j) {
            try {
                AtomicReference atomicReference = this.j;
                c6 c6Var = this.k;
                c cVar = c6Var.a.h;
                n3 n3VarO = c6Var.o();
                n3VarO.t();
                String str = n3VarO.c;
                Objects.requireNonNull(cVar);
                j3<String> j3Var = p.L;
                atomicReference.set(str == null ? j3Var.a(null) : j3Var.a(cVar.c.h(str, j3Var.f1539b)));
                this.j.notify();
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
