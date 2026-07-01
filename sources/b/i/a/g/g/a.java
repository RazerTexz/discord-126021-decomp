package b.i.a.g.g;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* JADX INFO: compiled from: CircularDrawingDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f<CircularProgressIndicatorSpec> {
    public int c;
    public float d;
    public float e;
    public float f;

    public a(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.c = 1;
    }

    @Override // b.i.a.g.g.f
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        S s2 = this.a;
        float f2 = (((CircularProgressIndicatorSpec) s2).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s2).indicatorInset;
        canvas.translate(f2, f2);
        canvas.rotate(-90.0f);
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        S s3 = this.a;
        this.c = ((CircularProgressIndicatorSpec) s3).indicatorDirection == 0 ? 1 : -1;
        this.d = ((CircularProgressIndicatorSpec) s3).trackThickness * f;
        this.e = ((CircularProgressIndicatorSpec) s3).trackCornerRadius * f;
        this.f = (((CircularProgressIndicatorSpec) s3).indicatorSize - ((CircularProgressIndicatorSpec) s3).trackThickness) / 2.0f;
        if ((this.f1622b.isShowing() && ((CircularProgressIndicatorSpec) this.a).showAnimationBehavior == 2) || (this.f1622b.isHiding() && ((CircularProgressIndicatorSpec) this.a).hideAnimationBehavior == 1)) {
            this.f = (((1.0f - f) * ((CircularProgressIndicatorSpec) this.a).trackThickness) / 2.0f) + this.f;
        } else if ((this.f1622b.isShowing() && ((CircularProgressIndicatorSpec) this.a).showAnimationBehavior == 1) || (this.f1622b.isHiding() && ((CircularProgressIndicatorSpec) this.a).hideAnimationBehavior == 2)) {
            this.f -= ((1.0f - f) * ((CircularProgressIndicatorSpec) this.a).trackThickness) / 2.0f;
        }
    }

    @Override // b.i.a.g.g.f
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @ColorInt int i) {
        if (f == f2) {
            return;
        }
        paint.setStyle(Paint$Style.STROKE);
        paint.setStrokeCap(Paint$Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.d);
        float f3 = this.c;
        float f4 = f * 360.0f * f3;
        if (f2 < f) {
            f2 += 1.0f;
        }
        float f5 = (f2 - f) * 360.0f * f3;
        float f6 = this.f;
        float f7 = -f6;
        canvas.drawArc(new RectF(f7, f7, f6, f6), f4, f5, false, paint);
        if (this.e <= 0.0f || Math.abs(f5) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint$Style.FILL);
        float f8 = this.e;
        float f9 = -f8;
        RectF rectF = new RectF(f9, f9, f8, f8);
        f(canvas, paint, this.d, this.e, f4, true, rectF);
        f(canvas, paint, this.d, this.e, f4 + f5, false, rectF);
    }

    @Override // b.i.a.g.g.f
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.a).trackColor, this.f1622b.getAlpha());
        paint.setStyle(Paint$Style.STROKE);
        paint.setStrokeCap(Paint$Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        paint.setStrokeWidth(this.d);
        float f = this.f;
        float f2 = -f;
        canvas.drawArc(new RectF(f2, f2, f, f), 0.0f, 360.0f, false, paint);
    }

    @Override // b.i.a.g.g.f
    public int d() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.a;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    @Override // b.i.a.g.g.f
    public int e() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.a;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    public final void f(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z2, RectF rectF) {
        float f4 = z2 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f3);
        float f5 = f / 2.0f;
        float f6 = f4 * f2;
        canvas.drawRect((this.f - f5) + f2, Math.min(0.0f, this.c * f6), (this.f + f5) - f2, Math.max(0.0f, f6 * this.c), paint);
        canvas.translate((this.f - f5) + f2, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f4) * 90.0f * this.c, true, paint);
        canvas.translate(f - (f2 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f4 * 90.0f * this.c, true, paint);
        canvas.restore();
    }
}
