package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.m6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4116m6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f10967j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f10968k;

    public RunnableC4116m6(C3999c6 c3999c6, AtomicReference atomicReference) {
        this.f10968k = c3999c6;
        this.f10967j = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10967j) {
            try {
                AtomicReference atomicReference = this.f10967j;
                C3999c6 c3999c6 = this.f10968k;
                C3992c c3992c = c3999c6.f11202a.f11260h;
                C4124n3 c4124n3M5970o = c3999c6.m5970o();
                c4124n3M5970o.m5497t();
                String str = c4124n3M5970o.f10979c;
                Objects.requireNonNull(c3992c);
                C4080j3<String> c4080j3 = C4142p.f11042L;
                atomicReference.set(str == null ? c4080j3.m5693a(null) : c4080j3.m5693a(c3992c.f10580c.mo5500h(str, c4080j3.f10839b)));
                this.f10967j.notify();
            } catch (Throwable th) {
                this.f10967j.notify();
                throw th;
            }
        }
    }
}
