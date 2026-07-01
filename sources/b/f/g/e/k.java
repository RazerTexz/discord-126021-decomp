package b.f.g.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: RoundedBitmapDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends n {
    public final Paint M;
    public final Paint N;
    public final Bitmap O;
    public WeakReference<Bitmap> P;

    public k(Resources resources, Bitmap bitmap, Paint paint) {
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
        paint3.setStyle(Paint$Style.STROKE);
    }

    @Override // b.f.g.e.n
    @VisibleForTesting
    public boolean d() {
        return super.d() && this.O != null;
    }

    @Override // b.f.g.e.n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b.f.j.r.b.b();
        if (!(super.d() && this.O != null)) {
            super.draw(canvas);
            b.f.j.r.b.b();
            return;
        }
        h();
        g();
        WeakReference<Bitmap> weakReference = this.P;
        if (weakReference == null || weakReference.get() != this.O) {
            this.P = new WeakReference<>(this.O);
            Paint paint = this.M;
            Bitmap bitmap = this.O;
            Shader$TileMode shader$TileMode = Shader$TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, shader$TileMode, shader$TileMode));
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
            this.N.setColor(b.c.a.a0.d.m1(this.p, this.M.getAlpha()));
            canvas.drawPath(this.q, this.N);
        }
        canvas.restoreToCount(iSave);
        b.f.j.r.b.b();
    }

    @Override // b.f.g.e.n, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.j.setAlpha(i);
        if (i != this.M.getAlpha()) {
            this.M.setAlpha(i);
            this.j.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.n, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
        this.M.setColorFilter(colorFilter);
    }
}
