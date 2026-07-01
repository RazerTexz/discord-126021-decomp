package b.f.n.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.f.n.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: BetterImageSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class BetterImageSpan extends ReplacementSpan {
    public int j;
    public int k;
    public Rect l;
    public final int m;
    public final Paint.FontMetricsInt n = new Paint.FontMetricsInt();
    public final Drawable o;

    public BetterImageSpan(Drawable drawable, int i) {
        this.o = drawable;
        this.m = i;
        b();
    }

    public final int a(Paint.FontMetricsInt fontMetricsInt) {
        int i = this.m;
        if (i == 0) {
            return fontMetricsInt.descent - this.k;
        }
        if (i != 2) {
            return -this.k;
        }
        int i2 = fontMetricsInt.descent;
        int i3 = fontMetricsInt.ascent;
        return (((i2 - i3) - this.k) / 2) + i3;
    }

    public void b() {
        Rect bounds = this.o.getBounds();
        this.l = bounds;
        this.j = bounds.width();
        this.k = this.l.height();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetricsInt(this.n);
        int iA = a(this.n) + i4;
        canvas.translate(f, iA);
        this.o.draw(canvas);
        canvas.translate(-f, -iA);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        b();
        if (fontMetricsInt == null) {
            return this.j;
        }
        int iA = a(fontMetricsInt);
        int i3 = this.k + iA;
        if (iA < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = iA;
        }
        if (iA < fontMetricsInt.top) {
            fontMetricsInt.top = iA;
        }
        if (i3 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i3;
        }
        if (i3 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i3;
        }
        return this.j;
    }
}
