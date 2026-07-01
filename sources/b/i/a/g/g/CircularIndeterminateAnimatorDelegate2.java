package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.c, reason: use source file name */
/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class CircularIndeterminateAnimatorDelegate2 extends AnimatorListenerAdapter {
    public final /* synthetic */ CircularIndeterminateAnimatorDelegate3 a;

    public CircularIndeterminateAnimatorDelegate2(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
        this.a = circularIndeterminateAnimatorDelegate3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a();
        CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3 = this.a;
        circularIndeterminateAnimatorDelegate3.p.onAnimationEnd(circularIndeterminateAnimatorDelegate3.a);
    }
}
