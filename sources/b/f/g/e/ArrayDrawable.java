package b.f.g.e;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.f.g.e.a, reason: use source file name */
/* JADX INFO: compiled from: ArrayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class ArrayDrawable implements DrawableParent {
    public final /* synthetic */ int j;
    public final /* synthetic */ ArrayDrawable2 k;

    public ArrayDrawable(ArrayDrawable2 arrayDrawable2, int i) {
        this.k = arrayDrawable2;
        this.j = i;
    }

    @Override // b.f.g.e.DrawableParent
    public Drawable g(Drawable drawable) {
        return this.k.c(this.j, drawable);
    }

    @Override // b.f.g.e.DrawableParent
    public Drawable l() {
        return this.k.a(this.j);
    }
}
