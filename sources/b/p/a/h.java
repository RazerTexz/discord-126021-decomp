package b.p.a;

import android.view.ViewGroup;

/* JADX INFO: compiled from: Alerter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ ViewGroup j;
    public final /* synthetic */ i k;

    public h(ViewGroup viewGroup, i iVar) {
        this.j = viewGroup;
        this.k = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.addView(this.k.f1973b);
    }
}
