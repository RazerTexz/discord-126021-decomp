package p007b.p437j.p438a;

import android.app.Dialog;

/* JADX INFO: renamed from: b.j.a.b */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5066b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C5067c f13581j;

    public RunnableC5066b(C5067c c5067c) {
        this.f13581j = c5067c;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5067c c5067c = this.f13581j;
        if (c5067c.f13585m) {
            c5067c.f13589q.animate().alpha(0.0f).setDuration(200L);
            return;
        }
        Dialog dialog = c5067c.getDialog();
        if (dialog != null) {
            dialog.getWindow().addFlags(2);
        }
    }
}
