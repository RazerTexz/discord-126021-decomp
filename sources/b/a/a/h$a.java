package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class h$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public h$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            h.g((h) this.k, false);
        } else {
            if (i != 1) {
                throw null;
            }
            h.g((h) this.k, true);
        }
    }
}
