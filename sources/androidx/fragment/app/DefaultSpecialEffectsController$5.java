package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal$OnCancelListener;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$5 implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$AnimationInfo val$animationInfo;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ View val$viewToAnimate;

    public DefaultSpecialEffectsController$5(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, ViewGroup viewGroup, DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$viewToAnimate = view;
        this.val$container = viewGroup;
        this.val$animationInfo = defaultSpecialEffectsController$AnimationInfo;
    }

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    public void onCancel() {
        this.val$viewToAnimate.clearAnimation();
        this.val$container.endViewTransition(this.val$viewToAnimate);
        this.val$animationInfo.completeSpecialEffect();
    }
}
