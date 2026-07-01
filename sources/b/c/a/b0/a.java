package b.c.a.b0;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.os.Build$VERSION;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: BaseLottieAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ValueAnimator {
    public final Set<ValueAnimator$AnimatorUpdateListener> j = new CopyOnWriteArraySet();
    public final Set<Animator$AnimatorListener> k = new CopyOnWriteArraySet();

    @Override // android.animation.Animator
    public void addListener(Animator$AnimatorListener animator$AnimatorListener) {
        this.k.add(animator$AnimatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator$AnimatorUpdateListener valueAnimator$AnimatorUpdateListener) {
        this.j.add(valueAnimator$AnimatorUpdateListener);
    }

    public void b(boolean z2) {
        for (Animator$AnimatorListener animator$AnimatorListener : this.k) {
            if (Build$VERSION.SDK_INT >= 26) {
                animator$AnimatorListener.onAnimationEnd(this, z2);
            } else {
                animator$AnimatorListener.onAnimationEnd(this);
            }
        }
    }

    public void f() {
        Iterator<ValueAnimator$AnimatorUpdateListener> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.k.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.j.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator$AnimatorListener animator$AnimatorListener) {
        this.k.remove(animator$AnimatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator$AnimatorUpdateListener valueAnimator$AnimatorUpdateListener) {
        this.j.remove(valueAnimator$AnimatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public /* bridge */ /* synthetic */ Animator setDuration(long j) {
        setDuration(j);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
