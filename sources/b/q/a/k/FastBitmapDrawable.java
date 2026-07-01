package b.q.a.k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.q.a.k.a, reason: use source file name */
/* JADX INFO: compiled from: FastBitmapDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class FastBitmapDrawable extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f1984b;
    public int d;
    public int e;
    public final Paint a = new Paint(2);
    public int c = 255;

    public FastBitmapDrawable(Bitmap bitmap) {
        this.f1984b = bitmap;
        if (bitmap != null) {
            this.d = bitmap.getWidth();
            this.e = this.f1984b.getHeight();
        } else {
            this.e = 0;
            this.d = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1984b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f1984b, (Rect) null, getBounds(), this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c = i;
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.a.setFilterBitmap(z2);
    }
}
