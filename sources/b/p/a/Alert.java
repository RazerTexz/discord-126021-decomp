package b.p.a;

import android.view.View;
import b.p.a.SwipeDismissTouchListener;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.p.a.a, reason: use source file name */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alert implements SwipeDismissTouchListener.a {
    public final /* synthetic */ Alert2 j;

    public Alert(Alert2 alert2) {
        this.j = alert2;
    }

    @Override // b.p.a.SwipeDismissTouchListener.a
    public void a(View view, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    @Override // b.p.a.SwipeDismissTouchListener.a
    public boolean b() {
        return true;
    }

    @Override // b.p.a.SwipeDismissTouchListener.a
    public void onDismiss(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Alert2 alert2 = this.j;
        alert2.clearAnimation();
        alert2.setVisibility(8);
        alert2.postDelayed(new Alert5(alert2), 100);
    }
}
