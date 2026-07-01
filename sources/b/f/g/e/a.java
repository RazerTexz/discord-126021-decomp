package b.f.g.e;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: ArrayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {
    public final /* synthetic */ int j;
    public final /* synthetic */ b k;

    public a(b bVar, int i) {
        this.k = bVar;
        this.j = i;
    }

    @Override // b.f.g.e.d
    public Drawable g(Drawable drawable) {
        return this.k.c(this.j, drawable);
    }

    @Override // b.f.g.e.d
    public Drawable l() {
        return this.k.a(this.j);
    }
}
