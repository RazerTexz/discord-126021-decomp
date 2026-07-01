package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.k, reason: use source file name */
/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class LinearIndeterminateDisjointAnimatorDelegate extends AnimatorListenerAdapter {
    public final /* synthetic */ LinearIndeterminateDisjointAnimatorDelegate2 a;

    public LinearIndeterminateDisjointAnimatorDelegate(LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2) {
        this.a = linearIndeterminateDisjointAnimatorDelegate2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2 = this.a;
        if (linearIndeterminateDisjointAnimatorDelegate2.m) {
            linearIndeterminateDisjointAnimatorDelegate2.g.setRepeatCount(-1);
            LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate3 = this.a;
            linearIndeterminateDisjointAnimatorDelegate3.n.onAnimationEnd(linearIndeterminateDisjointAnimatorDelegate3.a);
            this.a.m = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2 = this.a;
        linearIndeterminateDisjointAnimatorDelegate2.j = (linearIndeterminateDisjointAnimatorDelegate2.j + 1) % linearIndeterminateDisjointAnimatorDelegate2.i.indicatorColors.length;
        linearIndeterminateDisjointAnimatorDelegate2.k = true;
    }
}
