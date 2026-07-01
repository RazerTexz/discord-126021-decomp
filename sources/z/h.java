package z;

/* JADX INFO: compiled from: TaskCompletionSource.java */
/* JADX INFO: loaded from: classes.dex */
public class h<TResult> {
    public final g<TResult> a = new g<>();

    public void a() {
        if (!this.a.g()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void b(Exception exc) {
        boolean z2;
        g<TResult> gVar = this.a;
        synchronized (gVar.g) {
            z2 = false;
            if (!gVar.h) {
                gVar.h = true;
                gVar.k = exc;
                gVar.l = false;
                gVar.g.notifyAll();
                gVar.f();
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void c(TResult tresult) {
        if (!this.a.h(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
