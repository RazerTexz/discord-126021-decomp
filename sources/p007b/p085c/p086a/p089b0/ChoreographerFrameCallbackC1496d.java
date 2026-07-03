package p007b.p085c.p086a.p089b0;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1505d;

/* JADX INFO: renamed from: b.c.a.b0.d */
/* JADX INFO: compiled from: LottieValueAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class ChoreographerFrameCallbackC1496d extends AbstractC1493a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: s */
    @Nullable
    public C1505d f2304s;

    /* JADX INFO: renamed from: l */
    public float f2297l = 1.0f;

    /* JADX INFO: renamed from: m */
    public boolean f2298m = false;

    /* JADX INFO: renamed from: n */
    public long f2299n = 0;

    /* JADX INFO: renamed from: o */
    public float f2300o = 0.0f;

    /* JADX INFO: renamed from: p */
    public int f2301p = 0;

    /* JADX INFO: renamed from: q */
    public float f2302q = -2.1474836E9f;

    /* JADX INFO: renamed from: r */
    public float f2303r = 2.1474836E9f;

    /* JADX INFO: renamed from: t */
    @VisibleForTesting
    public boolean f2305t = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        Iterator<Animator.AnimatorListener> it = this.f2294k.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
        m648m();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        m647l();
        C1505d c1505d = this.f2304s;
        if (c1505d == null || !this.f2305t) {
            return;
        }
        long j2 = this.f2299n;
        float fAbs = (j2 != 0 ? j - j2 : 0L) / ((1.0E9f / c1505d.f2348m) / Math.abs(this.f2297l));
        float f = this.f2300o;
        if (m646k()) {
            fAbs = -fAbs;
        }
        float f2 = f + fAbs;
        this.f2300o = f2;
        float fM645j = m645j();
        float fM644i = m644i();
        PointF pointF = C1498f.f2308a;
        boolean z2 = !(f2 >= fM645j && f2 <= fM644i);
        this.f2300o = C1498f.m652b(this.f2300o, m645j(), m644i());
        this.f2299n = j;
        m638f();
        if (z2) {
            if (getRepeatCount() == -1 || this.f2301p < getRepeatCount()) {
                Iterator<Animator.AnimatorListener> it = this.f2294k.iterator();
                while (it.hasNext()) {
                    it.next().onAnimationRepeat(this);
                }
                this.f2301p++;
                if (getRepeatMode() == 2) {
                    this.f2298m = !this.f2298m;
                    this.f2297l = -this.f2297l;
                } else {
                    this.f2300o = m646k() ? m644i() : m645j();
                }
                this.f2299n = j;
            } else {
                this.f2300o = this.f2297l < 0.0f ? m645j() : m644i();
                m648m();
                m637b(m646k());
            }
        }
        if (this.f2304s != null) {
            float f3 = this.f2300o;
            if (f3 < this.f2302q || f3 > this.f2303r) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f2302q), Float.valueOf(this.f2303r), Float.valueOf(this.f2300o)));
            }
        }
        C1500c.m663a("LottieValueAnimator#doFrame");
    }

    @MainThread
    /* JADX INFO: renamed from: g */
    public void m642g() {
        m648m();
        m637b(m646k());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, m75to = 1.0d)
    public float getAnimatedFraction() {
        float fM645j;
        float fM644i;
        float fM645j2;
        if (this.f2304s == null) {
            return 0.0f;
        }
        if (m646k()) {
            fM645j = m644i() - this.f2300o;
            fM644i = m644i();
            fM645j2 = m645j();
        } else {
            fM645j = this.f2300o - m645j();
            fM644i = m644i();
            fM645j2 = m645j();
        }
        return fM645j / (fM644i - fM645j2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m643h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        C1505d c1505d = this.f2304s;
        if (c1505d == null) {
            return 0L;
        }
        return (long) c1505d.m670b();
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    /* JADX INFO: renamed from: h */
    public float m643h() {
        C1505d c1505d = this.f2304s;
        if (c1505d == null) {
            return 0.0f;
        }
        float f = this.f2300o;
        float f2 = c1505d.f2346k;
        return (f - f2) / (c1505d.f2347l - f2);
    }

    /* JADX INFO: renamed from: i */
    public float m644i() {
        C1505d c1505d = this.f2304s;
        if (c1505d == null) {
            return 0.0f;
        }
        float f = this.f2303r;
        return f == 2.1474836E9f ? c1505d.f2347l : f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f2305t;
    }

    /* JADX INFO: renamed from: j */
    public float m645j() {
        C1505d c1505d = this.f2304s;
        if (c1505d == null) {
            return 0.0f;
        }
        float f = this.f2302q;
        return f == -2.1474836E9f ? c1505d.f2346k : f;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m646k() {
        return this.f2297l < 0.0f;
    }

    /* JADX INFO: renamed from: l */
    public void m647l() {
        if (this.f2305t) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    /* JADX INFO: renamed from: m */
    public void m648m() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.f2305t = false;
    }

    /* JADX INFO: renamed from: n */
    public void m649n(float f) {
        if (this.f2300o == f) {
            return;
        }
        this.f2300o = C1498f.m652b(f, m645j(), m644i());
        this.f2299n = 0L;
        m638f();
    }

    /* JADX INFO: renamed from: o */
    public void m650o(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        C1505d c1505d = this.f2304s;
        float f3 = c1505d == null ? -3.4028235E38f : c1505d.f2346k;
        float f4 = c1505d == null ? Float.MAX_VALUE : c1505d.f2347l;
        this.f2302q = C1498f.m652b(f, f3, f4);
        this.f2303r = C1498f.m652b(f2, f3, f4);
        m649n((int) C1498f.m652b(this.f2300o, f, f2));
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f2298m) {
            return;
        }
        this.f2298m = false;
        this.f2297l = -this.f2297l;
    }
}
