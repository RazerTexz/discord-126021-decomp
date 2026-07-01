package b.a.y;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l$a implements Animator$AnimatorListener {
    public final /* synthetic */ l a;

    public l$a(l lVar) {
        this.a = lVar;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animator");
        this.a.getOnDialogClosed().invoke(this.a);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animator");
    }
}
