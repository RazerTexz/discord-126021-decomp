package b.p.a;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: b.p.a.e, reason: use source file name */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alert5 implements Runnable {
    public final /* synthetic */ Alert2 j;

    public Alert5(Alert2 alert2) {
        this.j = alert2;
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
                    OnHideAlertListener onHideListener$alerter_release = this.j.getOnHideListener$alerter_release();
                    if (onHideListener$alerter_release != null) {
                        onHideListener$alerter_release.onHide();
                    }
                } catch (Exception unused) {
                    Log.e(getClass().getSimpleName(), "Cannot remove from parent layout");
                }
            }
        } catch (Exception e) {
            Log.e(Alert5.class.getSimpleName(), Log.getStackTraceString(e));
        }
    }
}
