package b.a.a.b;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class c$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public c$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            ((c) this.k).dismiss();
        } else if (i == 1) {
            c.g((c) this.k);
        } else {
            if (i != 2) {
                throw null;
            }
            c.g((c) this.k);
        }
    }
}
