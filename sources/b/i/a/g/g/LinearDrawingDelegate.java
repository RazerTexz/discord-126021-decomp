package b.i.a.g.g;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* JADX INFO: renamed from: b.i.a.g.g.h, reason: use source file name */
/* JADX INFO: compiled from: LinearDrawingDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    public float c;
    public float d;
    public float e;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.c = 300.0f;
    }

    public static void f(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z2, RectF rectF) {
        canvas.save();
        canvas.translate(f3, 0.0f);
        if (!z2) {
            canvas.rotate(180.0f);
        }
        float f4 = ((-f) / 2.0f) + f2;
        float f5 = (f / 2.0f) - f2;
        canvas.drawRect(-f2, f4, 0.0f, f5, paint);
        canvas.save();
        canvas.translate(0.0f, f4);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f5);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }

    @Override // b.i.a.g.g.DrawingDelegate
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Rect clipBounds = canvas.getClipBounds();
        this.c = clipBounds.width();
        float f2 = ((LinearProgressIndicatorSpec) this.a).trackThickness;
        canvas.translate(clipBounds.width() / 2.0f, Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.a).trackThickness) / 2.0f) + (clipBounds.height() / 2.0f));
        if (((LinearProgressIndicatorSpec) this.a).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f1622b.isShowing() && ((LinearProgressIndicatorSpec) this.a).showAnimationBehavior == 1) || (this.f1622b.isHiding() && ((LinearProgressIndicatorSpec) this.a).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f1622b.isShowing() || this.f1622b.isHiding()) {
            canvas.translate(0.0f, ((f - 1.0f) * ((LinearProgressIndicatorSpec) this.a).trackThickness) / 2.0f);
        }
        float f3 = this.c;
        canvas.clipRect((-f3) / 2.0f, (-f2) / 2.0f, f3 / 2.0f, f2 / 2.0f);
        S s2 = this.a;
        this.d = ((LinearProgressIndicatorSpec) s2).trackThickness * f;
        this.e = ((LinearProgressIndicatorSpec) s2).trackCornerRadius * f;
    }

    @Override // b.i.a.g.g.DrawingDelegate
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @ColorInt int i) {
        if (f == f2) {
            return;
        }
        float f3 = this.c;
        float f4 = this.e;
        float f5 = ((-f3) / 2.0f) + f4;
        float f6 = f3 - (f4 * 2.0f);
        float f7 = (f * f6) + f5;
        float f8 = (f6 * f2) + f5;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i);
        float f9 = this.d;
        canvas.drawRect(f7, (-f9) / 2.0f, f8, f9 / 2.0f, paint);
        float f10 = this.e;
        float f11 = -f10;
        RectF rectF = new RectF(f11, f11, f10, f10);
        f(canvas, paint, this.d, this.e, f7, true, rectF);
        f(canvas, paint, this.d, this.e, f8, false, rectF);
    }

    @Override // b.i.a.g.g.DrawingDelegate
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.a).trackColor, this.f1622b.getAlpha());
        float f = ((-this.c) / 2.0f) + this.e;
        float f2 = -f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        float f3 = this.d;
        canvas.drawRect(f, (-f3) / 2.0f, f2, f3 / 2.0f, paint);
        float f4 = this.e;
        float f5 = -f4;
        RectF rectF = new RectF(f5, f5, f4, f4);
        f(canvas, paint, this.d, this.e, f, true, rectF);
        f(canvas, paint, this.d, this.e, f2, false, rectF);
    }

    @Override // b.i.a.g.g.DrawingDelegate
    public int d() {
        return ((LinearProgressIndicatorSpec) this.a).trackThickness;
    }

    @Override // b.i.a.g.g.DrawingDelegate
    public int e() {
        return -1;
    }
}
