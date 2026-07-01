package b.p.a;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ b j;

    public e(b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.j.getParent() != null) {
                try {
                    ViewParent parent = this.j.getParent();
                    if (parent == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    ((ViewGroup) parent).removeView(this.j);
                    j onHideListener$alerter_release = this.j.getOnHideListener$alerter_release();
                    if (onHideListener$alerter_release != null) {
                        onHideListener$alerter_release.onHide();
                    }
                } catch (Exception unused) {
                    Log.e(getClass().getSimpleName(), "Cannot remove from parent layout");
                }
            }
        } catch (Exception e) {
            Log.e(e.class.getSimpleName(), Log.getStackTraceString(e));
        }
    }
}
