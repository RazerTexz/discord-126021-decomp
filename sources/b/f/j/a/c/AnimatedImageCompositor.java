package b.f.j.a.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.a.AnimatedDrawableFrameInfo;
import b.f.j.a.a.AnimatedImageResult;
import b.f.j.t.BitmapTransformation;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.a.c.d, reason: use source file name */
/* JADX INFO: compiled from: AnimatedImageCompositor.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedImageCompositor {
    public final AnimatedDrawableBackend a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f551b;
    public final Paint c;

    /* JADX INFO: renamed from: b.f.j.a.c.d$a */
    /* JADX INFO: compiled from: AnimatedImageCompositor.java */
    public interface a {
        void a(int i, Bitmap bitmap);

        CloseableReference<Bitmap> b(int i);
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend animatedDrawableBackend, a aVar) {
        this.a = animatedDrawableBackend;
        this.f551b = aVar;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public final void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        int i = animatedDrawableFrameInfo.a;
        int i2 = animatedDrawableFrameInfo.f543b;
        canvas.drawRect(i, i2, i + animatedDrawableFrameInfo.c, i2 + animatedDrawableFrameInfo.d, this.c);
    }

    public final boolean b(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.a == 0 && animatedDrawableFrameInfo.f543b == 0 && animatedDrawableFrameInfo.c == ((AnimatedDrawableBackendImpl) this.a).d.width() && animatedDrawableFrameInfo.d == ((AnimatedDrawableBackendImpl) this.a).d.height();
    }

    public final boolean c(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo[] animatedDrawableFrameInfoArr = ((AnimatedDrawableBackendImpl) this.a).f;
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = animatedDrawableFrameInfoArr[i];
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = animatedDrawableFrameInfoArr[i - 1];
        if (animatedDrawableFrameInfo.e == 2 && b(animatedDrawableFrameInfo)) {
            return true;
        }
        return animatedDrawableFrameInfo2.f == 2 && b(animatedDrawableFrameInfo2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    public void d(int i, Bitmap bitmap) {
        BitmapTransformation bitmapTransformation;
        int i2;
        Canvas canvas = new Canvas(bitmap);
        int i3 = 0;
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (c(i)) {
            i3 = i;
        } else {
            for (int i4 = i - 1; i4 >= 0; i4--) {
                AnimatedDrawableFrameInfo animatedDrawableFrameInfo = ((AnimatedDrawableBackendImpl) this.a).f[i4];
                int i5 = animatedDrawableFrameInfo.f;
                if (i5 == 1) {
                    i2 = 1;
                } else if (i5 != 2) {
                    i2 = i5 == 3 ? 3 : 4;
                } else if (b(animatedDrawableFrameInfo)) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                int iH = b.c.a.y.b.h(i2);
                if (iH == 0) {
                    AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = ((AnimatedDrawableBackendImpl) this.a).f[i4];
                    CloseableReference<Bitmap> closeableReferenceB = this.f551b.b(i4);
                    if (closeableReferenceB != null) {
                        try {
                            canvas.drawBitmap(closeableReferenceB.u(), 0.0f, 0.0f, (Paint) null);
                            if (animatedDrawableFrameInfo2.f == 2) {
                                a(canvas, animatedDrawableFrameInfo2);
                            }
                            i3 = i4 + 1;
                            closeableReferenceB.close();
                            break;
                        } catch (Throwable th) {
                            closeableReferenceB.close();
                            throw th;
                        }
                    }
                    if (c(i4)) {
                        i3 = i4;
                        break;
                    }
                } else if (iH == 1) {
                    i3 = i4 + 1;
                    break;
                } else {
                    if (iH == 3) {
                        i3 = i4;
                        break;
                    }
                }
            }
        }
        while (i3 < i) {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo3 = ((AnimatedDrawableBackendImpl) this.a).f[i3];
            int i6 = animatedDrawableFrameInfo3.f;
            if (i6 != 3) {
                if (animatedDrawableFrameInfo3.e == 2) {
                    a(canvas, animatedDrawableFrameInfo3);
                }
                ((AnimatedDrawableBackendImpl) this.a).d(i3, canvas);
                this.f551b.a(i3, bitmap);
                if (i6 == 2) {
                    a(canvas, animatedDrawableFrameInfo3);
                }
            }
            i3++;
        }
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo4 = ((AnimatedDrawableBackendImpl) this.a).f[i];
        if (animatedDrawableFrameInfo4.e == 2) {
            a(canvas, animatedDrawableFrameInfo4);
        }
        ((AnimatedDrawableBackendImpl) this.a).d(i, canvas);
        AnimatedImageResult animatedImageResult = ((AnimatedDrawableBackendImpl) this.a).f548b;
        if (animatedImageResult == null || (bitmapTransformation = animatedImageResult.d) == null) {
            return;
        }
        bitmapTransformation.a(bitmap);
    }
}
