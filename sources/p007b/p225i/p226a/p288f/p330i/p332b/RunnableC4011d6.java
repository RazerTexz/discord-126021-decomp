package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.d6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4011d6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f10661j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f10662k;

    public RunnableC4011d6(C3999c6 c3999c6, AtomicReference atomicReference) {
        this.f10662k = c3999c6;
        this.f10661j = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10661j) {
            try {
                AtomicReference atomicReference = this.f10661j;
                C3999c6 c3999c6 = this.f10662k;
                C3992c c3992c = c3999c6.f11202a.f11260h;
                C4124n3 c4124n3M5970o = c3999c6.m5970o();
                c4124n3M5970o.m5497t();
                String str = c4124n3M5970o.f10979c;
                Objects.requireNonNull(c3992c);
                atomicReference.set(Boolean.valueOf(c3992c.m5532u(str, C4142p.f11040K)));
                this.f10661j.notify();
            } catch (Throwable th) {
                this.f10661j.notify();
                throw th;
            }
        }
    }
}
