package p007b.p440k.p441a.p442a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.k.a.a.a */
/* JADX INFO: compiled from: AlphaPatternDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5074a extends Drawable {

    /* JADX INFO: renamed from: a */
    public int f13598a;

    /* JADX INFO: renamed from: b */
    public Paint f13599b = new Paint();

    /* JADX INFO: renamed from: c */
    public Paint f13600c = new Paint();

    /* JADX INFO: renamed from: d */
    public Paint f13601d = new Paint();

    /* JADX INFO: renamed from: e */
    public int f13602e;

    /* JADX INFO: renamed from: f */
    public int f13603f;

    /* JADX INFO: renamed from: g */
    public Bitmap f13604g;

    public C5074a(int i) {
        this.f13598a = 10;
        this.f13598a = i;
        this.f13600c.setColor(-1);
        this.f13601d.setColor(-3421237);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f13604g;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f13604g, (Rect) null, getBounds(), this.f13599b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        this.f13602e = (int) Math.ceil(rect.width() / this.f13598a);
        this.f13603f = (int) Math.ceil(iHeight / this.f13598a);
        if (getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        this.f13604g = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f13604g);
        Rect rect2 = new Rect();
        boolean z2 = true;
        for (int i = 0; i <= this.f13603f; i++) {
            boolean z3 = z2;
            for (int i2 = 0; i2 <= this.f13602e; i2++) {
                int i3 = this.f13598a;
                int i4 = i * i3;
                rect2.top = i4;
                int i5 = i2 * i3;
                rect2.left = i5;
                rect2.bottom = i4 + i3;
                rect2.right = i5 + i3;
                canvas.drawRect(rect2, z3 ? this.f13600c : this.f13601d);
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
