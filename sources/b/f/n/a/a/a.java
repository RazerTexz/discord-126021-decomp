package b.f.n.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: BetterImageSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends ReplacementSpan {
    public int j;
    public int k;
    public Rect l;
    public final int m;
    public final Paint$FontMetricsInt n = new Paint$FontMetricsInt();
    public final Drawable o;

    public a(Drawable drawable, int i) {
        this.o = drawable;
        this.m = i;
        b();
    }

    public final int a(Paint$FontMetricsInt paint$FontMetricsInt) {
        int i = this.m;
        if (i == 0) {
            return paint$FontMetricsInt.descent - this.k;
        }
        if (i != 2) {
            return -this.k;
        }
        int i2 = paint$FontMetricsInt.descent;
        int i3 = paint$FontMetricsInt.ascent;
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
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint$FontMetricsInt paint$FontMetricsInt) {
        b();
        if (paint$FontMetricsInt == null) {
            return this.j;
        }
        int iA = a(paint$FontMetricsInt);
        int i3 = this.k + iA;
        if (iA < paint$FontMetricsInt.ascent) {
            paint$FontMetricsInt.ascent = iA;
        }
        if (iA < paint$FontMetricsInt.top) {
            paint$FontMetricsInt.top = iA;
        }
        if (i3 > paint$FontMetricsInt.descent) {
            paint$FontMetricsInt.descent = i3;
        }
        if (i3 > paint$FontMetricsInt.bottom) {
            paint$FontMetricsInt.bottom = i3;
        }
        return this.j;
    }
}
