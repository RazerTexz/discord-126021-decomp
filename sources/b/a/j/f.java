package b.a.j;

import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import com.discord.floating_view_manager.FloatingViewGravity;

/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ a j;
    public final /* synthetic */ View k;
    public final /* synthetic */ View l;
    public final /* synthetic */ FloatingViewGravity m;
    public final /* synthetic */ int n;
    public final /* synthetic */ int o;

    public f(a aVar, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.j = aVar;
        this.k = view;
        this.l = view2;
        this.m = floatingViewGravity;
        this.n = i;
        this.o = i2;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public final boolean onPreDraw() {
        a.a(this.j, this.k, this.l, this.m, this.n, this.o);
        return true;
    }
}
