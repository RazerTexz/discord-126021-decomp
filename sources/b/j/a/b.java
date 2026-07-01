package b.j.a;

import android.app.Dialog;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Runnable {
    public final /* synthetic */ c j;

    public b(c cVar) {
        this.j = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.j;
        if (cVar.m) {
            cVar.q.animate().alpha(0.0f).setDuration(200L);
            return;
        }
        Dialog dialog = cVar.getDialog();
        if (dialog != null) {
            dialog.getWindow().addFlags(2);
        }
    }
}
