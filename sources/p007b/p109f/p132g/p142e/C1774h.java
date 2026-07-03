package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.f.g.e.h */
/* JADX INFO: compiled from: MatrixDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1774h extends C1772g {

    /* JADX INFO: renamed from: n */
    public int f3363n;

    /* JADX INFO: renamed from: o */
    public int f3364o;

    @Override // p007b.p109f.p132g.p142e.C1772g, p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: d */
    public void mo1096d(Matrix matrix) {
        m1103n(matrix);
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3363n != this.f3360k.getIntrinsicWidth() || this.f3364o != this.f3360k.getIntrinsicHeight()) {
            m1105p();
        }
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // p007b.p109f.p132g.p142e.C1772g
    /* JADX INFO: renamed from: o */
    public Drawable mo1104o(Drawable drawable) {
        Drawable drawableMo1104o = super.mo1104o(drawable);
        m1105p();
        return drawableMo1104o;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        m1105p();
    }

    /* JADX INFO: renamed from: p */
    public final void m1105p() {
        Drawable drawable = this.f3360k;
        Rect bounds = getBounds();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.f3363n = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f3364o = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
        } else {
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
    }
}
