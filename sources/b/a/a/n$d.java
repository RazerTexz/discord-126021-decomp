package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n$d implements View$OnClickListener {
    public final /* synthetic */ n j;

    public n$d(n nVar) {
        this.j = nVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.dismiss();
    }
}
