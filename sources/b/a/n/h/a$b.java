package b.a.n.h;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import d0.z.d.m;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$b implements Animator$AnimatorListener {
    public final /* synthetic */ a a;

    public a$b(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.a.setVisibility(4);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }
}
