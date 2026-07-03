package p007b.p483p.p484a;

import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: b.p.a.g */
/* JADX INFO: compiled from: Alerter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC5277g implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ViewOnClickListenerC5272b f14364j;

    public RunnableC5277g(ViewOnClickListenerC5272b viewOnClickListenerC5272b) {
        this.f14364j = viewOnClickListenerC5272b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnClickListenerC5272b viewOnClickListenerC5272b = this.f14364j;
        if (viewOnClickListenerC5272b != null) {
            ViewParent parent = viewOnClickListenerC5272b.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.f14364j);
            }
        }
    }
}
