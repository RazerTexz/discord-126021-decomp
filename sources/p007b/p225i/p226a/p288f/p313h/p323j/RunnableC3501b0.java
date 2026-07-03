package p007b.p225i.p226a.p288f.p313h.p323j;

import android.os.Looper;

/* JADX INFO: renamed from: b.i.a.f.h.j.b0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3501b0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AbstractC3498a0 f9673j;

    public RunnableC3501b0(AbstractC3498a0 abstractC3498a0) {
        this.f9673j = abstractC3498a0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f9673j.f9663b.m4452d().m3968a(this);
            return;
        }
        boolean zM4419d = this.f9673j.m4419d();
        this.f9673j.f9665d = 0L;
        if (zM4419d) {
            this.f9673j.mo4418c();
        }
    }
}
