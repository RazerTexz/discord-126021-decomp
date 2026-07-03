package p007b.p485q.p486a.p490k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.q.a.k.a */
/* JADX INFO: compiled from: FastBitmapDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5301a extends Drawable {

    /* JADX INFO: renamed from: b */
    public Bitmap f14436b;

    /* JADX INFO: renamed from: d */
    public int f14438d;

    /* JADX INFO: renamed from: e */
    public int f14439e;

    /* JADX INFO: renamed from: a */
    public final Paint f14435a = new Paint(2);

    /* JADX INFO: renamed from: c */
    public int f14437c = 255;

    public C5301a(Bitmap bitmap) {
        this.f14436b = bitmap;
        if (bitmap != null) {
            this.f14438d = bitmap.getWidth();
            this.f14439e = this.f14436b.getHeight();
        } else {
            this.f14439e = 0;
            this.f14438d = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f14436b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f14436b, (Rect) null, getBounds(), this.f14435a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f14437c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14439e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14438d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f14439e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f14438d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f14437c = i;
        this.f14435a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14435a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f14435a.setFilterBitmap(z2);
    }
}
