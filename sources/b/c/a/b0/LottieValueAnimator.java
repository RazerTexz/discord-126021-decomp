package b.c.a.b0;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.c.a.L;
import b.c.a.LottieComposition;
import java.util.Iterator;

/* JADX INFO: renamed from: b.c.a.b0.d, reason: use source file name */
/* JADX INFO: compiled from: LottieValueAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public LottieComposition f344s;
    public float l = 1.0f;
    public boolean m = false;
    public long n = 0;
    public float o = 0.0f;
    public int p = 0;
    public float q = -2.1474836E9f;
    public float r = 2.1474836E9f;

    @VisibleForTesting
    public boolean t = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        Iterator<Animator.AnimatorListener> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
        m();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        l();
        LottieComposition lottieComposition = this.f344s;
        if (lottieComposition == null || !this.t) {
            return;
        }
        long j2 = this.n;
        float fAbs = (j2 != 0 ? j - j2 : 0L) / ((1.0E9f / lottieComposition.m) / Math.abs(this.l));
        float f = this.o;
        if (k()) {
            fAbs = -fAbs;
        }
        float f2 = f + fAbs;
        this.o = f2;
        float fJ = j();
        float fI = i();
        PointF pointF = MiscUtils.a;
        boolean z2 = !(f2 >= fJ && f2 <= fI);
        this.o = MiscUtils.b(this.o, j(), i());
        this.n = j;
        f();
        if (z2) {
            if (getRepeatCount() == -1 || this.p < getRepeatCount()) {
                Iterator<Animator.AnimatorListener> it = this.k.iterator();
                while (it.hasNext()) {
                    it.next().onAnimationRepeat(this);
                }
                this.p++;
                if (getRepeatMode() == 2) {
                    this.m = !this.m;
                    this.l = -this.l;
                } else {
                    this.o = k() ? i() : j();
                }
                this.n = j;
            } else {
                this.o = this.l < 0.0f ? j() : i();
                m();
                b(k());
            }
        }
        if (this.f344s != null) {
            float f3 = this.o;
            if (f3 < this.q || f3 > this.r) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.q), Float.valueOf(this.r), Float.valueOf(this.o)));
            }
        }
        L.a("LottieValueAnimator#doFrame");
    }

    @MainThread
    public void g() {
        m();
        b(k());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float fJ;
        float fI;
        float fJ2;
        if (this.f344s == null) {
            return 0.0f;
        }
        if (k()) {
            fJ = i() - this.o;
            fI = i();
            fJ2 = j();
        } else {
            fJ = this.o - j();
            fI = i();
            fJ2 = j();
        }
        return fJ / (fI - fJ2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.f344s;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.b();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float h() {
        LottieComposition lottieComposition = this.f344s;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.o;
        float f2 = lottieComposition.k;
        return (f - f2) / (lottieComposition.l - f2);
    }

    public float i() {
        LottieComposition lottieComposition = this.f344s;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.r;
        return f == 2.1474836E9f ? lottieComposition.l : f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.t;
    }

    public float j() {
        LottieComposition lottieComposition = this.f344s;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.q;
        return f == -2.1474836E9f ? lottieComposition.k : f;
    }

    public final boolean k() {
        return this.l < 0.0f;
    }

    public void l() {
        if (this.t) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void m() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.t = false;
    }

    public void n(float f) {
        if (this.o == f) {
            return;
        }
        this.o = MiscUtils.b(f, j(), i());
        this.n = 0L;
        f();
    }

    public void o(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        LottieComposition lottieComposition = this.f344s;
        float f3 = lottieComposition == null ? -3.4028235E38f : lottieComposition.k;
        float f4 = lottieComposition == null ? Float.MAX_VALUE : lottieComposition.l;
        this.q = MiscUtils.b(f, f3, f4);
        this.r = MiscUtils.b(f2, f3, f4);
        n((int) MiscUtils.b(this.o, f, f2));
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.m) {
            return;
        }
        this.m = false;
        this.l = -this.l;
    }
}
