package androidx.transition;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet$TransitionSetListener extends TransitionListenerAdapter {
    public TransitionSet mTransitionSet;

    public TransitionSet$TransitionSetListener(TransitionSet transitionSet) {
        this.mTransitionSet = transitionSet;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        TransitionSet transitionSet = this.mTransitionSet;
        int i = transitionSet.mCurrentListeners - 1;
        transitionSet.mCurrentListeners = i;
        if (i == 0) {
            transitionSet.mStarted = false;
            transitionSet.end();
        }
        transition.removeListener(this);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
        TransitionSet transitionSet = this.mTransitionSet;
        if (transitionSet.mStarted) {
            return;
        }
        transitionSet.start();
        this.mTransitionSet.mStarted = true;
    }
}
