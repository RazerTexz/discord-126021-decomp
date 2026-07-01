package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.g.e.c, reason: use source file name */
/* JADX INFO: compiled from: AutoRotateDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable {
    public int n;
    public boolean o;

    @VisibleForTesting
    public float p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoRotateDrawable(Drawable drawable, int i) {
        super(drawable);
        Objects.requireNonNull(drawable);
        this.p = 0.0f;
        this.q = false;
        this.n = i;
        this.o = true;
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right;
        int i2 = bounds.left;
        int i3 = i - i2;
        int i4 = bounds.bottom;
        int i5 = bounds.top;
        int i6 = i4 - i5;
        float f = this.p;
        if (!this.o) {
            f = 360.0f - f;
        }
        canvas.rotate(f, (i3 / 2) + i2, (i6 / 2) + i5);
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restoreToCount(iSave);
        if (this.q) {
            return;
        }
        this.q = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.q = false;
        this.p += (int) ((20.0f / this.n) * 360.0f);
        invalidateSelf();
    }
}
