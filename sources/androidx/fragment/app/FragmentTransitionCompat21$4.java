package androidx.fragment.app;

import android.transition.Transition;
import android.transition.Transition$TransitionListener;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionCompat21$4 implements Transition$TransitionListener {
    public final /* synthetic */ FragmentTransitionCompat21 this$0;
    public final /* synthetic */ Runnable val$transitionCompleteRunnable;

    public FragmentTransitionCompat21$4(FragmentTransitionCompat21 fragmentTransitionCompat21, Runnable runnable) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$transitionCompleteRunnable = runnable;
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionEnd(Transition transition) {
        this.val$transitionCompleteRunnable.run();
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionStart(Transition transition) {
    }
}
