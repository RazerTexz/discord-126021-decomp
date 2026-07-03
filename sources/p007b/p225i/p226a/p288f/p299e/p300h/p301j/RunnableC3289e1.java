package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.e1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3289e1 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ LifecycleCallback f9368j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f9369k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C3292f1 f9370l;

    public RunnableC3289e1(C3292f1 c3292f1, LifecycleCallback lifecycleCallback, String str) {
        this.f9370l = c3292f1;
        this.f9368j = lifecycleCallback;
        this.f9369k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3292f1 c3292f1 = this.f9370l;
        if (c3292f1.f9374l > 0) {
            LifecycleCallback lifecycleCallback = this.f9368j;
            Bundle bundle = c3292f1.f9375m;
            lifecycleCallback.mo4116e(bundle != null ? bundle.getBundle(this.f9369k) : null);
        }
        if (this.f9370l.f9374l >= 2) {
            this.f9368j.mo4059i();
        }
        if (this.f9370l.f9374l >= 3) {
            this.f9368j.mo4058g();
        }
        if (this.f9370l.f9374l >= 4) {
            this.f9368j.mo4060j();
        }
        if (this.f9370l.f9374l >= 5) {
            this.f9368j.mo4063f();
        }
    }
}
