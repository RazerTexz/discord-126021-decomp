package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: CameraCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j$c implements View$OnClickListener {
    public final /* synthetic */ j j;

    public j$c(j jVar) {
        this.j = jVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.dismiss();
    }
}
