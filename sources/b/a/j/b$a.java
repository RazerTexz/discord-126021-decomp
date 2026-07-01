package b.a.j;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$a implements View$OnLayoutChangeListener {
    public final /* synthetic */ b j;

    public b$a(b bVar) {
        this.j = bVar;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        b bVar = this.j;
        a.a(bVar.j, bVar.l, bVar.k, bVar.m, bVar.n, bVar.o);
        this.j.l.setVisibility(0);
    }
}
