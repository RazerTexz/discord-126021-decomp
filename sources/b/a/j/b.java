package b.a.j;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.discord.floating_view_manager.FloatingViewGravity;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ FloatingViewManager j;
    public final /* synthetic */ View k;
    public final /* synthetic */ View l;
    public final /* synthetic */ FloatingViewGravity m;
    public final /* synthetic */ int n;
    public final /* synthetic */ int o;

    /* JADX INFO: compiled from: View.kt */
    public static final class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics3.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            b bVar = b.this;
            FloatingViewManager.a(bVar.j, bVar.l, bVar.k, bVar.m, bVar.n, bVar.o);
            b.this.l.setVisibility(0);
        }
    }

    public b(FloatingViewManager floatingViewManager, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.j = floatingViewManager;
        this.k = view;
        this.l = view2;
        this.m = floatingViewGravity;
        this.n = i;
        this.o = i2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        View view2 = this.k;
        if (!ViewCompat.isLaidOut(view2) || view2.isLayoutRequested()) {
            view2.addOnLayoutChangeListener(new a());
        } else {
            FloatingViewManager.a(this.j, this.l, this.k, this.m, this.n, this.o);
            this.l.setVisibility(0);
        }
    }
}
