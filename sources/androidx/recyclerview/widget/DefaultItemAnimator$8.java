package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator$8 extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ DefaultItemAnimator$ChangeInfo val$changeInfo;
    public final /* synthetic */ View val$newView;
    public final /* synthetic */ ViewPropertyAnimator val$newViewAnimation;

    public DefaultItemAnimator$8(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.this$0 = defaultItemAnimator;
        this.val$changeInfo = defaultItemAnimator$ChangeInfo;
        this.val$newViewAnimation = viewPropertyAnimator;
        this.val$newView = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.val$newViewAnimation.setListener(null);
        this.val$newView.setAlpha(1.0f);
        this.val$newView.setTranslationX(0.0f);
        this.val$newView.setTranslationY(0.0f);
        this.this$0.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
        this.this$0.mChangeAnimations.remove(this.val$changeInfo.newHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.this$0.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
    }
}
