package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.c1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3283c1 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ LifecycleCallback f9357j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f9358k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ FragmentC3286d1 f9359l;

    public RunnableC3283c1(FragmentC3286d1 fragmentC3286d1, LifecycleCallback lifecycleCallback, String str) {
        this.f9359l = fragmentC3286d1;
        this.f9357j = lifecycleCallback;
        this.f9358k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentC3286d1 fragmentC3286d1 = this.f9359l;
        if (fragmentC3286d1.f9365l > 0) {
            LifecycleCallback lifecycleCallback = this.f9357j;
            Bundle bundle = fragmentC3286d1.f9366m;
            lifecycleCallback.mo4116e(bundle != null ? bundle.getBundle(this.f9358k) : null);
        }
        if (this.f9359l.f9365l >= 2) {
            this.f9357j.mo4059i();
        }
        if (this.f9359l.f9365l >= 3) {
            this.f9357j.mo4058g();
        }
        if (this.f9359l.f9365l >= 4) {
            this.f9357j.mo4060j();
        }
        if (this.f9359l.f9365l >= 5) {
            this.f9357j.mo4063f();
        }
    }
}
