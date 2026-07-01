package b.f.g.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.j.r.FrescoSystrace;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: b.f.g.e.k, reason: use source file name */
/* JADX INFO: compiled from: RoundedBitmapDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class RoundedBitmapDrawable2 extends RoundedDrawable {
    public final Paint M;
    public final Paint N;
    public final Bitmap O;
    public WeakReference<Bitmap> P;

    public RoundedBitmapDrawable2(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.M = paint2;
        Paint paint3 = new Paint(1);
        this.N = paint3;
        this.O = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // b.f.g.e.RoundedDrawable
    @VisibleForTesting
    public boolean d() {
        return super.d() && this.O != null;
    }

    @Override // b.f.g.e.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        FrescoSystrace.b();
        if (!(super.d() && this.O != null)) {
            super.draw(canvas);
            FrescoSystrace.b();
            return;
        }
        h();
        g();
        WeakReference<Bitmap> weakReference = this.P;
        if (weakReference == null || weakReference.get() != this.O) {
            this.P = new WeakReference<>(this.O);
            Paint paint = this.M;
            Bitmap bitmap = this.O;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.o = true;
        }
        if (this.o) {
            this.M.getShader().setLocalMatrix(this.G);
            this.o = false;
        }
        this.M.setFilterBitmap(this.J);
        int iSave = canvas.save();
        canvas.concat(this.D);
        canvas.drawPath(this.n, this.M);
        float f = this.m;
        if (f > 0.0f) {
            this.N.setStrokeWidth(f);
            this.N.setColor(AnimatableValueParser.m1(this.p, this.M.getAlpha()));
            canvas.drawPath(this.q, this.N);
        }
        canvas.restoreToCount(iSave);
        FrescoSystrace.b();
    }

    @Override // b.f.g.e.RoundedDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.j.setAlpha(i);
        if (i != this.M.getAlpha()) {
            this.M.setAlpha(i);
            this.j.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.RoundedDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
        this.M.setColorFilter(colorFilter);
    }
}
