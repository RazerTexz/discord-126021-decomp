package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class Transition$2 extends AnimatorListenerAdapter {
    public final /* synthetic */ Transition this$0;
    public final /* synthetic */ ArrayMap val$runningAnimators;

    public Transition$2(Transition transition, ArrayMap arrayMap) {
        this.this$0 = transition;
        this.val$runningAnimators = arrayMap;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.val$runningAnimators.remove(animator);
        this.this$0.mCurrentAnimators.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.this$0.mCurrentAnimators.add(animator);
    }
}
