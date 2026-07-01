package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        l lVar = this.a;
        if (lVar.m) {
            lVar.g.setRepeatCount(-1);
            l lVar2 = this.a;
            lVar2.n.onAnimationEnd(lVar2.a);
            this.a.m = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        l lVar = this.a;
        lVar.j = (lVar.j + 1) % lVar.i.indicatorColors.length;
        lVar.k = true;
    }
}
