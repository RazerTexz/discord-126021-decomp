package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class Transition$3 extends AnimatorListenerAdapter {
    public final /* synthetic */ Transition this$0;

    public Transition$3(Transition transition) {
        this.this$0 = transition;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.this$0.end();
        animator.removeListener(this);
    }
}
