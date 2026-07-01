package b.f.j.a.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.a.AnimatedDrawableFrameInfo;
import b.f.j.a.a.AnimatedImage;
import b.f.j.a.a.AnimatedImageFrame;
import b.f.j.a.a.AnimatedImageResult;
import b.f.j.a.d.AnimatedDrawableUtil;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.a.c.a, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawableBackendImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    public final AnimatedDrawableUtil a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatedImageResult f548b;
    public final AnimatedImage c;
    public final Rect d;
    public final int[] e;
    public final AnimatedDrawableFrameInfo[] f;
    public final Rect g = new Rect();
    public final Rect h = new Rect();
    public final boolean i;
    public Bitmap j;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect, boolean z2) {
        this.a = animatedDrawableUtil;
        this.f548b = animatedImageResult;
        AnimatedImage animatedImage = animatedImageResult.a;
        this.c = animatedImage;
        int[] iArrI = animatedImage.i();
        this.e = iArrI;
        Objects.requireNonNull(animatedDrawableUtil);
        for (int i = 0; i < iArrI.length; i++) {
            if (iArrI[i] < 11) {
                iArrI[i] = 100;
            }
        }
        AnimatedDrawableUtil animatedDrawableUtil2 = this.a;
        int[] iArr = this.e;
        Objects.requireNonNull(animatedDrawableUtil2);
        for (int i2 : iArr) {
        }
        AnimatedDrawableUtil animatedDrawableUtil3 = this.a;
        int[] iArr2 = this.e;
        Objects.requireNonNull(animatedDrawableUtil3);
        int[] iArr3 = new int[iArr2.length];
        int i3 = 0;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr3[i4] = i3;
            i3 += iArr2[i4];
        }
        this.d = a(this.c, rect);
        this.i = z2;
        this.f = new AnimatedDrawableFrameInfo[this.c.a()];
        for (int i5 = 0; i5 < this.c.a(); i5++) {
            this.f[i5] = this.c.g(i5);
        }
    }

    public static Rect a(AnimatedImage animatedImage, Rect rect) {
        return rect == null ? new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight()) : new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    public int b() {
        return this.c.a();
    }

    public final synchronized Bitmap c(int i, int i2) {
        Bitmap bitmap = this.j;
        if (bitmap != null && (bitmap.getWidth() < i || this.j.getHeight() < i2)) {
            synchronized (this) {
                Bitmap bitmap2 = this.j;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.j = null;
                }
            }
        }
        if (this.j == null) {
            this.j = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.j.eraseColor(0);
        return this.j;
    }

    public void d(int i, Canvas canvas) {
        AnimatedImageFrame animatedImageFrameE = this.c.e(i);
        try {
            if (animatedImageFrameE.getWidth() > 0 && animatedImageFrameE.getHeight() > 0) {
                if (this.c.f()) {
                    f(canvas, animatedImageFrameE);
                } else {
                    e(canvas, animatedImageFrameE);
                }
            }
        } finally {
            animatedImageFrameE.dispose();
        }
    }

    public final void e(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int width;
        int height;
        int iB;
        int iC;
        if (this.i) {
            float fMax = Math.max(animatedImageFrame.getWidth() / Math.min(animatedImageFrame.getWidth(), canvas.getWidth()), animatedImageFrame.getHeight() / Math.min(animatedImageFrame.getHeight(), canvas.getHeight()));
            width = (int) (animatedImageFrame.getWidth() / fMax);
            height = (int) (animatedImageFrame.getHeight() / fMax);
            iB = (int) (animatedImageFrame.b() / fMax);
            iC = (int) (animatedImageFrame.c() / fMax);
        } else {
            width = animatedImageFrame.getWidth();
            height = animatedImageFrame.getHeight();
            iB = animatedImageFrame.b();
            iC = animatedImageFrame.c();
        }
        synchronized (this) {
            Bitmap bitmapC = c(width, height);
            this.j = bitmapC;
            animatedImageFrame.a(width, height, bitmapC);
            canvas.save();
            canvas.translate(iB, iC);
            canvas.drawBitmap(this.j, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    public final void f(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double dWidth = ((double) this.d.width()) / ((double) this.c.getWidth());
        double dHeight = ((double) this.d.height()) / ((double) this.c.getHeight());
        int iRound = (int) Math.round(((double) animatedImageFrame.getWidth()) * dWidth);
        int iRound2 = (int) Math.round(((double) animatedImageFrame.getHeight()) * dHeight);
        int iB = (int) (((double) animatedImageFrame.b()) * dWidth);
        int iC = (int) (((double) animatedImageFrame.c()) * dHeight);
        synchronized (this) {
            int iWidth = this.d.width();
            int iHeight = this.d.height();
            c(iWidth, iHeight);
            Bitmap bitmap = this.j;
            if (bitmap != null) {
                animatedImageFrame.a(iRound, iRound2, bitmap);
            }
            this.g.set(0, 0, iWidth, iHeight);
            this.h.set(iB, iC, iWidth + iB, iHeight + iC);
            Bitmap bitmap2 = this.j;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.g, this.h, (Paint) null);
            }
        }
    }
}
