package p007b.p483p.p484a;

import android.view.ViewGroup;

/* JADX INFO: renamed from: b.p.a.h */
/* JADX INFO: compiled from: Alerter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC5278h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ViewGroup f14365j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C5279i f14366k;

    public RunnableC5278h(ViewGroup viewGroup, C5279i c5279i) {
        this.f14365j = viewGroup;
        this.f14366k = c5279i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14365j.addView(this.f14366k.f14368b);
    }
}
