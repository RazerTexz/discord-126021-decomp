package p686z;

/* JADX INFO: renamed from: z.h */
/* JADX INFO: compiled from: TaskCompletionSource.java */
/* JADX INFO: loaded from: classes.dex */
public class C13203h<TResult> {

    /* JADX INFO: renamed from: a */
    public final C13202g<TResult> f27990a = new C13202g<>();

    /* JADX INFO: renamed from: a */
    public void m11374a() {
        if (!this.f27990a.m11372g()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11375b(Exception exc) {
        boolean z2;
        C13202g<TResult> c13202g = this.f27990a;
        synchronized (c13202g.f27983g) {
            z2 = false;
            if (!c13202g.f27984h) {
                c13202g.f27984h = true;
                c13202g.f27987k = exc;
                c13202g.f27988l = false;
                c13202g.f27983g.notifyAll();
                c13202g.m11371f();
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    /* JADX INFO: renamed from: c */
    public void m11376c(TResult tresult) {
        if (!this.f27990a.m11373h(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
