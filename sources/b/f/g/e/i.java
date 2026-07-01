package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: OrientedDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends g {

    @VisibleForTesting
    public final Matrix n;
    public int o;
    public int p;
    public final Matrix q;
    public final RectF r;

    public i(Drawable drawable, int i, int i2) {
        super(drawable);
        this.q = new Matrix();
        this.r = new RectF();
        this.n = new Matrix();
        this.o = i - (i % 90);
        this.p = (i2 < 0 || i2 > 8) ? 0 : i2;
    }

    @Override // b.f.g.e.g, b.f.g.e.e0
    public void d(Matrix matrix) {
        n(matrix);
        if (this.n.isIdentity()) {
            return;
        }
        matrix.preConcat(this.n);
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        if (this.o <= 0 && ((i = this.p) == 0 || i == 1)) {
            Drawable drawable = this.k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        int iSave = canvas.save();
        canvas.concat(this.n);
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.p;
        return (i == 5 || i == 7 || this.o % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.p;
        return (i == 5 || i == 7 || this.o % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i;
        Drawable drawable = this.k;
        int i2 = this.o;
        if (i2 <= 0 && ((i = this.p) == 0 || i == 1)) {
            drawable.setBounds(rect);
            return;
        }
        int i3 = this.p;
        if (i3 == 2) {
            this.n.setScale(-1.0f, 1.0f);
        } else if (i3 == 7) {
            this.n.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.n.postScale(-1.0f, 1.0f);
        } else if (i3 == 4) {
            this.n.setScale(1.0f, -1.0f);
        } else if (i3 != 5) {
            this.n.setRotate(i2, rect.centerX(), rect.centerY());
        } else {
            this.n.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.n.postScale(1.0f, -1.0f);
        }
        this.q.reset();
        this.n.invert(this.q);
        this.r.set(rect);
        this.q.mapRect(this.r);
        RectF rectF = this.r;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}
