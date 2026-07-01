package b.k.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.k.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: AlphaPatternDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class AlphaPatternDrawable extends Drawable {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f1898b = new Paint();
    public Paint c = new Paint();
    public Paint d = new Paint();
    public int e;
    public int f;
    public Bitmap g;

    public AlphaPatternDrawable(int i) {
        this.a = 10;
        this.a = i;
        this.c.setColor(-1);
        this.d.setColor(-3421237);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.g;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.g, (Rect) null, getBounds(), this.f1898b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        this.e = (int) Math.ceil(rect.width() / this.a);
        this.f = (int) Math.ceil(iHeight / this.a);
        if (getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        this.g = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.g);
        Rect rect2 = new Rect();
        boolean z2 = true;
        for (int i = 0; i <= this.f; i++) {
            boolean z3 = z2;
            for (int i2 = 0; i2 <= this.e; i2++) {
                int i3 = this.a;
                int i4 = i * i3;
                rect2.top = i4;
                int i5 = i2 * i3;
                rect2.left = i5;
                rect2.bottom = i4 + i3;
                rect2.right = i5 + i3;
                canvas.drawRect(rect2, z3 ? this.c : this.d);
                z3 = !z3;
            }
            z2 = !z2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }
}
