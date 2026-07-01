package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m$c implements View$OnClickListener {
    public final /* synthetic */ m j;

    public m$c(m mVar) {
        this.j = mVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.dismiss();
    }
}
