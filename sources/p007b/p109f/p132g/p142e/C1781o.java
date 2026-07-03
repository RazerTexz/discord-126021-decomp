package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.e.o */
/* JADX INFO: compiled from: RoundedNinePatchDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1781o extends AbstractC1780n {
    public C1781o(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // p007b.p109f.p132g.p142e.AbstractC1780n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C2030b.m1527b();
        if (!mo1113d()) {
            super.draw(canvas);
            C2030b.m1527b();
            return;
        }
        m1117h();
        m1116g();
        canvas.clipPath(this.f3422n);
        super.draw(canvas);
        C2030b.m1527b();
    }
}
