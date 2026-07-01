package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;

/* JADX INFO: compiled from: RoundedNinePatchDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends n {
    public o(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // b.f.g.e.n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b.f.j.r.b.b();
        if (!d()) {
            super.draw(canvas);
            b.f.j.r.b.b();
            return;
        }
        h();
        g();
        canvas.clipPath(this.n);
        super.draw(canvas);
        b.f.j.r.b.b();
    }
}
