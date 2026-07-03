package p007b.p109f.p192n.p193a.p194a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.f.n.a.a.a */
/* JADX INFO: compiled from: BetterImageSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2064a extends ReplacementSpan {

    /* JADX INFO: renamed from: j */
    public int f4359j;

    /* JADX INFO: renamed from: k */
    public int f4360k;

    /* JADX INFO: renamed from: l */
    public Rect f4361l;

    /* JADX INFO: renamed from: m */
    public final int f4362m;

    /* JADX INFO: renamed from: n */
    public final Paint.FontMetricsInt f4363n = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: o */
    public final Drawable f4364o;

    public C2064a(Drawable drawable, int i) {
        this.f4364o = drawable;
        this.f4362m = i;
        m1592b();
    }

    /* JADX INFO: renamed from: a */
    public final int m1591a(Paint.FontMetricsInt fontMetricsInt) {
        int i = this.f4362m;
        if (i == 0) {
            return fontMetricsInt.descent - this.f4360k;
        }
        if (i != 2) {
            return -this.f4360k;
        }
        int i2 = fontMetricsInt.descent;
        int i3 = fontMetricsInt.ascent;
        return (((i2 - i3) - this.f4360k) / 2) + i3;
    }

    /* JADX INFO: renamed from: b */
    public void m1592b() {
        Rect bounds = this.f4364o.getBounds();
        this.f4361l = bounds;
        this.f4359j = bounds.width();
        this.f4360k = this.f4361l.height();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetricsInt(this.f4363n);
        int iM1591a = m1591a(this.f4363n) + i4;
        canvas.translate(f, iM1591a);
        this.f4364o.draw(canvas);
        canvas.translate(-f, -iM1591a);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        m1592b();
        if (fontMetricsInt == null) {
            return this.f4359j;
        }
        int iM1591a = m1591a(fontMetricsInt);
        int i3 = this.f4360k + iM1591a;
        if (iM1591a < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = iM1591a;
        }
        if (iM1591a < fontMetricsInt.top) {
            fontMetricsInt.top = iM1591a;
        }
        if (i3 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i3;
        }
        if (i3 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i3;
        }
        return this.f4359j;
    }
}
