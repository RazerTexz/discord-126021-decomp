package b.a.a.a;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$c implements View$OnClickListener {
    public final /* synthetic */ c j;

    public c$c(c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.dismiss();
    }
}
