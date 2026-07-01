package b.p.a;

import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: b.p.a.g, reason: use source file name */
/* JADX INFO: compiled from: Alerter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alerter implements Runnable {
    public final /* synthetic */ Alert2 j;

    public Alerter(Alert2 alert2) {
        this.j = alert2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Alert2 alert2 = this.j;
        if (alert2 != null) {
            ViewParent parent = alert2.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.j);
            }
        }
    }
}
