package defpackage;

import android.view.View;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class d implements View.OnClickListener {
    public static final d j = new d(0);
    public static final d k = new d(1);
    public static final d l = new d(2);
    public static final d m = new d(3);
    public final /* synthetic */ int n;

    public d(int i) {
        this.n = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.n;
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            throw null;
        }
    }
}
