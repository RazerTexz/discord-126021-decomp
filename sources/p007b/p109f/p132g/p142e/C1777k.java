package p007b.p109f.p132g.p142e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.e.k */
/* JADX INFO: compiled from: RoundedBitmapDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1777k extends AbstractC1780n {

    /* JADX INFO: renamed from: M */
    public final Paint f3370M;

    /* JADX INFO: renamed from: N */
    public final Paint f3371N;

    /* JADX INFO: renamed from: O */
    public final Bitmap f3372O;

    /* JADX INFO: renamed from: P */
    public WeakReference<Bitmap> f3373P;

    public C1777k(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.f3370M = paint2;
        Paint paint3 = new Paint(1);
        this.f3371N = paint3;
        this.f3372O = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // p007b.p109f.p132g.p142e.AbstractC1780n
    @VisibleForTesting
    /* JADX INFO: renamed from: d */
    public boolean mo1113d() {
        return super.mo1113d() && this.f3372O != null;
    }

    @Override // p007b.p109f.p132g.p142e.AbstractC1780n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C2030b.m1527b();
        if (!(super.mo1113d() && this.f3372O != null)) {
            super.draw(canvas);
            C2030b.m1527b();
            return;
        }
        m1117h();
        m1116g();
        WeakReference<Bitmap> weakReference = this.f3373P;
        if (weakReference == null || weakReference.get() != this.f3372O) {
            this.f3373P = new WeakReference<>(this.f3372O);
            Paint paint = this.f3370M;
            Bitmap bitmap = this.f3372O;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.f3423o = true;
        }
        if (this.f3423o) {
            this.f3370M.getShader().setLocalMatrix(this.f3412G);
            this.f3423o = false;
        }
        this.f3370M.setFilterBitmap(this.f3415J);
        int iSave = canvas.save();
        canvas.concat(this.f3409D);
        canvas.drawPath(this.f3422n, this.f3370M);
        float f = this.f3421m;
        if (f > 0.0f) {
            this.f3371N.setStrokeWidth(f);
            this.f3371N.setColor(C1460d.m545m1(this.f3424p, this.f3370M.getAlpha()));
            canvas.drawPath(this.f3425q, this.f3371N);
        }
        canvas.restoreToCount(iSave);
        C2030b.m1527b();
    }

    @Override // p007b.p109f.p132g.p142e.AbstractC1780n, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3418j.setAlpha(i);
        if (i != this.f3370M.getAlpha()) {
            this.f3370M.setAlpha(i);
            this.f3418j.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.AbstractC1780n, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3418j.setColorFilter(colorFilter);
        this.f3370M.setColorFilter(colorFilter);
    }
}
