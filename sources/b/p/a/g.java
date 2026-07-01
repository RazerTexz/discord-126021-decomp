package b.p.a;

import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: Alerter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ b j;

    public g(b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.j;
        if (bVar != null) {
            ViewParent parent = bVar.getParent();
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
