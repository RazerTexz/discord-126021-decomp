package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: renamed from: b.f.g.e.i */
/* JADX INFO: compiled from: OrientedDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1775i extends C1772g {

    /* JADX INFO: renamed from: n */
    @VisibleForTesting
    public final Matrix f3365n;

    /* JADX INFO: renamed from: o */
    public int f3366o;

    /* JADX INFO: renamed from: p */
    public int f3367p;

    /* JADX INFO: renamed from: q */
    public final Matrix f3368q;

    /* JADX INFO: renamed from: r */
    public final RectF f3369r;

    public C1775i(Drawable drawable, int i, int i2) {
        super(drawable);
        this.f3368q = new Matrix();
        this.f3369r = new RectF();
        this.f3365n = new Matrix();
        this.f3366o = i - (i % 90);
        this.f3367p = (i2 < 0 || i2 > 8) ? 0 : i2;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: d */
    public void mo1096d(Matrix matrix) {
        m1103n(matrix);
        if (this.f3365n.isIdentity()) {
            return;
        }
        matrix.preConcat(this.f3365n);
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        if (this.f3366o <= 0 && ((i = this.f3367p) == 0 || i == 1)) {
            Drawable drawable = this.f3360k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        int iSave = canvas.save();
        canvas.concat(this.f3365n);
        Drawable drawable2 = this.f3360k;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.f3367p;
        return (i == 5 || i == 7 || this.f3366o % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.f3367p;
        return (i == 5 || i == 7 || this.f3366o % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i;
        Drawable drawable = this.f3360k;
        int i2 = this.f3366o;
        if (i2 <= 0 && ((i = this.f3367p) == 0 || i == 1)) {
            drawable.setBounds(rect);
            return;
        }
        int i3 = this.f3367p;
        if (i3 == 2) {
            this.f3365n.setScale(-1.0f, 1.0f);
        } else if (i3 == 7) {
            this.f3365n.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.f3365n.postScale(-1.0f, 1.0f);
        } else if (i3 == 4) {
            this.f3365n.setScale(1.0f, -1.0f);
        } else if (i3 != 5) {
            this.f3365n.setRotate(i2, rect.centerX(), rect.centerY());
        } else {
            this.f3365n.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.f3365n.postScale(1.0f, -1.0f);
        }
        this.f3368q.reset();
        this.f3365n.invert(this.f3368q);
        this.f3369r.set(rect);
        this.f3368q.mapRect(this.f3369r);
        RectF rectF = this.f3369r;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}
