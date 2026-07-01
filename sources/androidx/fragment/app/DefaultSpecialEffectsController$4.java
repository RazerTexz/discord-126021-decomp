package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$4 implements Animation$AnimationListener {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$AnimationInfo val$animationInfo;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ View val$viewToAnimate;

    public DefaultSpecialEffectsController$4(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$animationInfo = defaultSpecialEffectsController$AnimationInfo;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.val$container.post(new DefaultSpecialEffectsController$4$1(this));
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
