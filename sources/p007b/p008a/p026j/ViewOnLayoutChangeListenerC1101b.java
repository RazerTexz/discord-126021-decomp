package p007b.p008a.p026j;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.discord.floating_view_manager.FloatingViewGravity;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.j.b */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC1101b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1100a f1461j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ View f1462k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ View f1463l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ FloatingViewGravity f1464m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ int f1465n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ int f1466o;

    /* JADX INFO: renamed from: b.a.j.b$a */
    /* JADX INFO: compiled from: View.kt */
    public static final class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C12238m.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            ViewOnLayoutChangeListenerC1101b viewOnLayoutChangeListenerC1101b = ViewOnLayoutChangeListenerC1101b.this;
            C1100a.m207a(viewOnLayoutChangeListenerC1101b.f1461j, viewOnLayoutChangeListenerC1101b.f1463l, viewOnLayoutChangeListenerC1101b.f1462k, viewOnLayoutChangeListenerC1101b.f1464m, viewOnLayoutChangeListenerC1101b.f1465n, viewOnLayoutChangeListenerC1101b.f1466o);
            ViewOnLayoutChangeListenerC1101b.this.f1463l.setVisibility(0);
        }
    }

    public ViewOnLayoutChangeListenerC1101b(C1100a c1100a, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.f1461j = c1100a;
        this.f1462k = view;
        this.f1463l = view2;
        this.f1464m = floatingViewGravity;
        this.f1465n = i;
        this.f1466o = i2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        C12238m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        View view2 = this.f1462k;
        if (!ViewCompat.isLaidOut(view2) || view2.isLayoutRequested()) {
            view2.addOnLayoutChangeListener(new a());
        } else {
            C1100a.m207a(this.f1461j, this.f1463l, this.f1462k, this.f1464m, this.f1465n, this.f1466o);
            this.f1463l.setVisibility(0);
        }
    }
}
