package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$2 extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$AnimationInfo val$animationInfo;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ boolean val$isHideOperation;
    public final /* synthetic */ SpecialEffectsController$Operation val$operation;
    public final /* synthetic */ View val$viewToAnimate;

    public DefaultSpecialEffectsController$2(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, boolean z2, SpecialEffectsController$Operation specialEffectsController$Operation, DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$isHideOperation = z2;
        this.val$operation = specialEffectsController$Operation;
        this.val$animationInfo = defaultSpecialEffectsController$AnimationInfo;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$viewToAnimate);
        if (this.val$isHideOperation) {
            this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
        }
        this.val$animationInfo.completeSpecialEffect();
    }
}
