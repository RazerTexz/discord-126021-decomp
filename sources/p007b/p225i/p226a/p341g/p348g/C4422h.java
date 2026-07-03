package p007b.p225i.p226a.p341g.p348g;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* JADX INFO: renamed from: b.i.a.g.g.h */
/* JADX INFO: compiled from: LinearDrawingDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4422h extends AbstractC4420f<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c */
    public float f11739c;

    /* JADX INFO: renamed from: d */
    public float f11740d;

    /* JADX INFO: renamed from: e */
    public float f11741e;

    public C4422h(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f11739c = 300.0f;
    }

    /* JADX INFO: renamed from: f */
    public static void m6131f(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z2, RectF rectF) {
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

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: a */
    public void mo6117a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        Rect clipBounds = canvas.getClipBounds();
        this.f11739c = clipBounds.width();
        float f2 = ((LinearProgressIndicatorSpec) this.f11734a).trackThickness;
        canvas.translate(clipBounds.width() / 2.0f, Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f11734a).trackThickness) / 2.0f) + (clipBounds.height() / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f11734a).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f11735b.isShowing() && ((LinearProgressIndicatorSpec) this.f11734a).showAnimationBehavior == 1) || (this.f11735b.isHiding() && ((LinearProgressIndicatorSpec) this.f11734a).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f11735b.isShowing() || this.f11735b.isHiding()) {
            canvas.translate(0.0f, ((f - 1.0f) * ((LinearProgressIndicatorSpec) this.f11734a).trackThickness) / 2.0f);
        }
        float f3 = this.f11739c;
        canvas.clipRect((-f3) / 2.0f, (-f2) / 2.0f, f3 / 2.0f, f2 / 2.0f);
        S s2 = this.f11734a;
        this.f11740d = ((LinearProgressIndicatorSpec) s2).trackThickness * f;
        this.f11741e = ((LinearProgressIndicatorSpec) s2).trackCornerRadius * f;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: b */
    public void mo6118b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2, @ColorInt int i) {
        if (f == f2) {
            return;
        }
        float f3 = this.f11739c;
        float f4 = this.f11741e;
        float f5 = ((-f3) / 2.0f) + f4;
        float f6 = f3 - (f4 * 2.0f);
        float f7 = (f * f6) + f5;
        float f8 = (f6 * f2) + f5;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i);
        float f9 = this.f11740d;
        canvas.drawRect(f7, (-f9) / 2.0f, f8, f9 / 2.0f, paint);
        float f10 = this.f11741e;
        float f11 = -f10;
        RectF rectF = new RectF(f11, f11, f10, f10);
        m6131f(canvas, paint, this.f11740d, this.f11741e, f7, true, rectF);
        m6131f(canvas, paint, this.f11740d, this.f11741e, f8, false, rectF);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: c */
    public void mo6119c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.f11734a).trackColor, this.f11735b.getAlpha());
        float f = ((-this.f11739c) / 2.0f) + this.f11741e;
        float f2 = -f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        float f3 = this.f11740d;
        canvas.drawRect(f, (-f3) / 2.0f, f2, f3 / 2.0f, paint);
        float f4 = this.f11741e;
        float f5 = -f4;
        RectF rectF = new RectF(f5, f5, f4, f4);
        m6131f(canvas, paint, this.f11740d, this.f11741e, f, true, rectF);
        m6131f(canvas, paint, this.f11740d, this.f11741e, f2, false, rectF);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: d */
    public int mo6120d() {
        return ((LinearProgressIndicatorSpec) this.f11734a).trackThickness;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4420f
    /* JADX INFO: renamed from: e */
    public int mo6121e() {
        return -1;
    }
}
