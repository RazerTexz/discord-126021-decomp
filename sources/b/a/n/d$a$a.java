package b.a.n;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$a$a implements View$OnLayoutChangeListener {
    public final /* synthetic */ d$a j;
    public final /* synthetic */ View k;

    public d$a$a(d$a d_a, View view) {
        this.j = d_a;
        this.k = view;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        View viewFindViewWithTag = this.k.findViewWithTag(this.j.j.m);
        m.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
        this.j.j.l.b(viewFindViewWithTag);
    }
}
