package p007b.p008a.p026j;

import android.view.View;
import android.view.ViewTreeObserver;
import com.discord.floating_view_manager.FloatingViewGravity;

/* JADX INFO: renamed from: b.a.j.f */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC1105f implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1100a f1477j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ View f1478k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ View f1479l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ FloatingViewGravity f1480m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ int f1481n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ int f1482o;

    public ViewTreeObserverOnPreDrawListenerC1105f(C1100a c1100a, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.f1477j = c1100a;
        this.f1478k = view;
        this.f1479l = view2;
        this.f1480m = floatingViewGravity;
        this.f1481n = i;
        this.f1482o = i2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        C1100a.m207a(this.f1477j, this.f1478k, this.f1479l, this.f1480m, this.f1481n, this.f1482o);
        return true;
    }
}
