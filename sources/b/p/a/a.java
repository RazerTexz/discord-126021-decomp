package b.p.a;

import android.view.View;

/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements l$a {
    public final /* synthetic */ b j;

    public a(b bVar) {
        this.j = bVar;
    }

    @Override // b.p.a.l$a
    public void a(View view, boolean z2) {
        d0.z.d.m.checkNotNullParameter(view, "view");
    }

    @Override // b.p.a.l$a
    public boolean b() {
        return true;
    }

    @Override // b.p.a.l$a
    public void onDismiss(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        b bVar = this.j;
        bVar.clearAnimation();
        bVar.setVisibility(8);
        bVar.postDelayed(new e(bVar), 100);
    }
}
