package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.g.e.c */
/* JADX INFO: compiled from: AutoRotateDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC1764c extends C1772g implements Runnable {

    /* JADX INFO: renamed from: n */
    public int f3335n;

    /* JADX INFO: renamed from: o */
    public boolean f3336o;

    /* JADX INFO: renamed from: p */
    @VisibleForTesting
    public float f3337p;

    /* JADX INFO: renamed from: q */
    public boolean f3338q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunnableC1764c(Drawable drawable, int i) {
        super(drawable);
        Objects.requireNonNull(drawable);
        this.f3337p = 0.0f;
        this.f3338q = false;
        this.f3335n = i;
        this.f3336o = true;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right;
        int i2 = bounds.left;
        int i3 = i - i2;
        int i4 = bounds.bottom;
        int i5 = bounds.top;
        int i6 = i4 - i5;
        float f = this.f3337p;
        if (!this.f3336o) {
            f = 360.0f - f;
        }
        canvas.rotate(f, (i3 / 2) + i2, (i6 / 2) + i5);
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restoreToCount(iSave);
        if (this.f3338q) {
            return;
        }
        this.f3338q = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3338q = false;
        this.f3337p += (int) ((20.0f / this.f3335n) * 360.0f);
        invalidateSelf();
    }
}
