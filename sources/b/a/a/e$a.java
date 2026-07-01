package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class e$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public e$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i != 0) {
            if (i != 1) {
                throw null;
            }
            ((e) this.k).dismiss();
        } else {
            View$OnClickListener view$OnClickListener = ((e) this.k).positiveClickListener;
            if (view$OnClickListener != null) {
                view$OnClickListener.onClick(view);
            }
            ((e) this.k).dismiss();
        }
    }
}
