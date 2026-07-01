package com.discord.utilities.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RingAnimator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RingAnimator {
    private final ObjectAnimator fadeAnim;
    private boolean isAnimating;
    private final Function0<Boolean> ringingPredicate;
    private final View view;

    public RingAnimator(View view, Function0<Boolean> function0) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(function0, "ringingPredicate");
        this.view = view;
        this.ringingPredicate = function0;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.1f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.discord.utilities.anim.RingAnimator$$special$$inlined$apply$lambda$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics3.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics3.checkNotNullParameter(animator, "animator");
                this.this$0.isAnimating = false;
                this.this$0.onUpdate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics3.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics3.checkNotNullParameter(animator, "animator");
            }
        });
        this.fadeAnim = objectAnimatorOfFloat;
    }

    public final View getView() {
        return this.view;
    }

    public final void onUpdate() {
        boolean zBooleanValue = this.ringingPredicate.invoke().booleanValue();
        boolean z2 = this.isAnimating;
        if (!z2 && zBooleanValue) {
            this.isAnimating = true;
            this.fadeAnim.start();
        } else {
            if (!z2 || zBooleanValue) {
                return;
            }
            this.fadeAnim.cancel();
            ObjectAnimator objectAnimator = this.fadeAnim;
            Intrinsics3.checkNotNullExpressionValue(objectAnimator, "fadeAnim");
            objectAnimator.setDuration(0L);
        }
    }
}
