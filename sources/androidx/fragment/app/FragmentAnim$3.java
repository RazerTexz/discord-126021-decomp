package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class FragmentAnim$3 extends AnimatorListenerAdapter {
    public final /* synthetic */ FragmentTransition$Callback val$callback;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;
    public final /* synthetic */ CancellationSignal val$signal;
    public final /* synthetic */ View val$viewToAnimate;

    public FragmentAnim$3(ViewGroup viewGroup, View view, Fragment fragment, FragmentTransition$Callback fragmentTransition$Callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$fragment = fragment;
        this.val$callback = fragmentTransition$Callback;
        this.val$signal = cancellationSignal;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$viewToAnimate);
        Animator animator2 = this.val$fragment.getAnimator();
        this.val$fragment.setAnimator(null);
        if (animator2 == null || this.val$container.indexOfChild(this.val$viewToAnimate) >= 0) {
            return;
        }
        this.val$callback.onComplete(this.val$fragment, this.val$signal);
    }
}
