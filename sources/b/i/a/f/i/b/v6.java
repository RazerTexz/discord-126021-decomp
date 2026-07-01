package b.i.a.f.i.b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v6 implements Runnable {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ c6 k;

    public v6(c6 c6Var, AtomicReference atomicReference) {
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
                atomicReference.set(Double.valueOf(cVar.r(n3VarO.c, p.O)));
                this.j.notify();
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
