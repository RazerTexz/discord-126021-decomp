package p007b.p225i.p226a.p341g.p348g;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* JADX INFO: renamed from: b.i.a.g.g.a */
/* JADX INFO: compiled from: CircularDrawingDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4415a extends AbstractC4420f<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c */
    public int f11713c;

    /* JADX INFO: renamed from: d */
    public float f11714d;

    /* JADX INFO: renamed from: e */
    public float f11715e;

    /* JADX INFO: renamed from: f */
    public float f11716f;

    public C4415a(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f11713c = 1;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: a */
    public void mo6117a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        S s2 = this.f11734a;
        float f2 = (((CircularProgressIndicatorSpec) s2).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s2).indicatorInset;
        canvas.translate(f2, f2);
        canvas.rotate(-90.0f);
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        S s3 = this.f11734a;
        this.f11713c = ((CircularProgressIndicatorSpec) s3).indicatorDirection == 0 ? 1 : -1;
        this.f11714d = ((CircularProgressIndicatorSpec) s3).trackThickness * f;
        this.f11715e = ((CircularProgressIndicatorSpec) s3).trackCornerRadius * f;
        this.f11716f = (((CircularProgressIndicatorSpec) s3).indicatorSize - ((CircularProgressIndicatorSpec) s3).trackThickness) / 2.0f;
        if ((this.f11735b.isShowing() && ((CircularProgressIndicatorSpec) this.f11734a).showAnimationBehavior == 2) || (this.f11735b.isHiding() && ((CircularProgressIndicatorSpec) this.f11734a).hideAnimationBehavior == 1)) {
            this.f11716f = (((1.0f - f) * ((CircularProgressIndicatorSpec) this.f11734a).trackThickness) / 2.0f) + this.f11716f;
        } else if ((this.f11735b.isShowing() && ((CircularProgressIndicatorSpec) this.f11734a).showAnimationBehavior == 1) || (this.f11735b.isHiding() && ((CircularProgressIndicatorSpec) this.f11734a).hideAnimationBehavior == 2)) {
            this.f11716f -= ((1.0f - f) * ((CircularProgressIndicatorSpec) this.f11734a).trackThickness) / 2.0f;
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: b */
    public void mo6118b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2, @ColorInt int i) {
        if (f == f2) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.f11714d);
        float f3 = this.f11713c;
        float f4 = f * 360.0f * f3;
        if (f2 < f) {
            f2 += 1.0f;
        }
        float f5 = (f2 - f) * 360.0f * f3;
        float f6 = this.f11716f;
        float f7 = -f6;
        canvas.drawArc(new RectF(f7, f7, f6, f6), f4, f5, false, paint);
        if (this.f11715e <= 0.0f || Math.abs(f5) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f8 = this.f11715e;
        float f9 = -f8;
        RectF rectF = new RectF(f9, f9, f8, f8);
        m6122f(canvas, paint, this.f11714d, this.f11715e, f4, true, rectF);
        m6122f(canvas, paint, this.f11714d, this.f11715e, f4 + f5, false, rectF);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: c */
    public void mo6119c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.f11734a).trackColor, this.f11735b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        paint.setStrokeWidth(this.f11714d);
        float f = this.f11716f;
        float f2 = -f;
        canvas.drawArc(new RectF(f2, f2, f, f), 0.0f, 360.0f, false, paint);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: d */
    public int mo6120d() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f11734a;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: e */
    public int mo6121e() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f11734a;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    /* JADX INFO: renamed from: f */
    public final void m6122f(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z2, RectF rectF) {
        float f4 = z2 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f3);
        float f5 = f / 2.0f;
        float f6 = f4 * f2;
        canvas.drawRect((this.f11716f - f5) + f2, Math.min(0.0f, this.f11713c * f6), (this.f11716f + f5) - f2, Math.max(0.0f, f6 * this.f11713c), paint);
        canvas.translate((this.f11716f - f5) + f2, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f4) * 90.0f * this.f11713c, true, paint);
        canvas.translate(f - (f2 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f4 * 90.0f * this.f11713c, true, paint);
        canvas.restore();
    }
}
