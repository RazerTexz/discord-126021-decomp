package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.LPaint;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.m.h, reason: use source file name */
/* JADX INFO: compiled from: SolidLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class SolidLayer extends BaseLayer2 {
    public final Path A;
    public final Layer2 B;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f442y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float[] f443z;

    public SolidLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
        this.f441x = new RectF();
        LPaint lPaint = new LPaint();
        this.f442y = lPaint;
        this.f443z = new float[8];
        this.A = new Path();
        this.B = layer2;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer2.l);
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        RectF rectF2 = this.f441x;
        Layer2 layer2 = this.B;
        rectF2.set(0.0f, 0.0f, layer2.j, layer2.k);
        this.m.mapRect(this.f441x);
        rectF.set(this.f441x);
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.v.c(t, lottieValueCallback);
        if (t == LottieProperty.C) {
            if (lottieValueCallback == null) {
                this.C = null;
            } else {
                this.C = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            }
        }
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void j(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.B.l);
        if (iAlpha == 0) {
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.v.j;
        int iIntValue = (int) ((((iAlpha / 255.0f) * (baseKeyframeAnimation == null ? 100 : baseKeyframeAnimation.e().intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        this.f442y.setAlpha(iIntValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.C;
        if (baseKeyframeAnimation2 != null) {
            this.f442y.setColorFilter(baseKeyframeAnimation2.e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f443z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Layer2 layer2 = this.B;
            int i2 = layer2.j;
            fArr[2] = i2;
            fArr[3] = 0.0f;
            fArr[4] = i2;
            int i3 = layer2.k;
            fArr[5] = i3;
            fArr[6] = 0.0f;
            fArr[7] = i3;
            matrix.mapPoints(fArr);
            this.A.reset();
            Path path = this.A;
            float[] fArr2 = this.f443z;
            path.moveTo(fArr2[0], fArr2[1]);
            Path path2 = this.A;
            float[] fArr3 = this.f443z;
            path2.lineTo(fArr3[2], fArr3[3]);
            Path path3 = this.A;
            float[] fArr4 = this.f443z;
            path3.lineTo(fArr4[4], fArr4[5]);
            Path path4 = this.A;
            float[] fArr5 = this.f443z;
            path4.lineTo(fArr5[6], fArr5[7]);
            Path path5 = this.A;
            float[] fArr6 = this.f443z;
            path5.lineTo(fArr6[0], fArr6[1]);
            this.A.close();
            canvas.drawPath(this.A, this.f442y);
        }
    }
}
