package androidx.transition;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet$1 extends TransitionListenerAdapter {
    public final /* synthetic */ TransitionSet this$0;
    public final /* synthetic */ Transition val$nextTransition;

    public TransitionSet$1(TransitionSet transitionSet, Transition transition) {
        this.this$0 = transitionSet;
        this.val$nextTransition = transition;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        this.val$nextTransition.runAnimators();
        transition.removeListener(this);
    }
}
