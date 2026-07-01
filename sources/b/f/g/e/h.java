package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: MatrixDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends g {
    public int n;
    public int o;

    @Override // b.f.g.e.g, b.f.g.e.e0
    public void d(Matrix matrix) {
        n(matrix);
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n != this.k.getIntrinsicWidth() || this.o != this.k.getIntrinsicHeight()) {
            p();
        }
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // b.f.g.e.g
    public Drawable o(Drawable drawable) {
        Drawable drawableO = super.o(drawable);
        p();
        return drawableO;
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        p();
    }

    public final void p() {
        Drawable drawable = this.k;
        Rect bounds = getBounds();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.n = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.o = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
        } else {
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
    }
}
