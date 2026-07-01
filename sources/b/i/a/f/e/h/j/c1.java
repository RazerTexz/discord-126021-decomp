package b.i.a.f.e.h.j;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 implements Runnable {
    public final /* synthetic */ LifecycleCallback j;
    public final /* synthetic */ String k;
    public final /* synthetic */ d1 l;

    public c1(d1 d1Var, LifecycleCallback lifecycleCallback, String str) {
        this.l = d1Var;
        this.j = lifecycleCallback;
        this.k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d1 d1Var = this.l;
        if (d1Var.l > 0) {
            LifecycleCallback lifecycleCallback = this.j;
            Bundle bundle = d1Var.m;
            lifecycleCallback.e(bundle != null ? bundle.getBundle(this.k) : null);
        }
        if (this.l.l >= 2) {
            this.j.i();
        }
        if (this.l.l >= 3) {
            this.j.g();
        }
        if (this.l.l >= 4) {
            this.j.j();
        }
        if (this.l.l >= 5) {
            this.j.f();
        }
    }
}
