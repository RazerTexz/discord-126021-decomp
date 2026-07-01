package b.a.j;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import com.discord.floating_view_manager.FloatingViewGravity;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements View$OnLayoutChangeListener {
    public final /* synthetic */ a j;
    public final /* synthetic */ View k;
    public final /* synthetic */ View l;
    public final /* synthetic */ FloatingViewGravity m;
    public final /* synthetic */ int n;
    public final /* synthetic */ int o;

    public c(a aVar, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.j = aVar;
        this.k = view;
        this.l = view2;
        this.m = floatingViewGravity;
        this.n = i;
        this.o = i2;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        a.a(this.j, this.l, this.k, this.m, this.n, this.o);
        this.l.setVisibility(0);
    }
}
