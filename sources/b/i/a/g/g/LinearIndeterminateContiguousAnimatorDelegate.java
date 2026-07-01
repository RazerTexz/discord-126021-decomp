package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.i, reason: use source file name */
/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class LinearIndeterminateContiguousAnimatorDelegate extends AnimatorListenerAdapter {
    public final /* synthetic */ LinearIndeterminateContiguousAnimatorDelegate2 a;

    public LinearIndeterminateContiguousAnimatorDelegate(LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2) {
        this.a = linearIndeterminateContiguousAnimatorDelegate2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2 = this.a;
        linearIndeterminateContiguousAnimatorDelegate2.h = (linearIndeterminateContiguousAnimatorDelegate2.h + 1) % linearIndeterminateContiguousAnimatorDelegate2.g.indicatorColors.length;
        linearIndeterminateContiguousAnimatorDelegate2.i = true;
    }
}
