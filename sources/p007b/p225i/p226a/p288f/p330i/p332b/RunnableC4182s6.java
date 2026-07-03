package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.s6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4182s6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f11203j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f11204k;

    public RunnableC4182s6(C3999c6 c3999c6, AtomicReference atomicReference) {
        this.f11204k = c3999c6;
        this.f11203j = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11203j) {
            try {
                AtomicReference atomicReference = this.f11203j;
                C3999c6 c3999c6 = this.f11204k;
                C3992c c3992c = c3999c6.f11202a.f11260h;
                C4124n3 c4124n3M5970o = c3999c6.m5970o();
                c4124n3M5970o.m5497t();
                atomicReference.set(Integer.valueOf(c3992c.m5528q(c4124n3M5970o.f10979c, C4142p.f11046N)));
                this.f11203j.notify();
            } catch (Throwable th) {
                this.f11203j.notify();
                throw th;
            }
        }
    }
}
