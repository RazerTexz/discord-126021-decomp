package p007b.p483p.p484a;

import android.view.View;
import p007b.p483p.p484a.ViewOnTouchListenerC5282l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.p.a.a */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5271a implements ViewOnTouchListenerC5282l.a {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ViewOnClickListenerC5272b f14338j;

    public C5271a(ViewOnClickListenerC5272b viewOnClickListenerC5272b) {
        this.f14338j = viewOnClickListenerC5272b;
    }

    @Override // p007b.p483p.p484a.ViewOnTouchListenerC5282l.a
    /* JADX INFO: renamed from: a */
    public void mo7463a(View view, boolean z2) {
        C12238m.checkNotNullParameter(view, "view");
    }

    @Override // p007b.p483p.p484a.ViewOnTouchListenerC5282l.a
    /* JADX INFO: renamed from: b */
    public boolean mo7464b() {
        return true;
    }

    @Override // p007b.p483p.p484a.ViewOnTouchListenerC5282l.a
    public void onDismiss(View view) {
        C12238m.checkNotNullParameter(view, "view");
        ViewOnClickListenerC5272b viewOnClickListenerC5272b = this.f14338j;
        viewOnClickListenerC5272b.clearAnimation();
        viewOnClickListenerC5272b.setVisibility(8);
        viewOnClickListenerC5272b.postDelayed(new RunnableC5275e(viewOnClickListenerC5272b), 100);
    }
}
