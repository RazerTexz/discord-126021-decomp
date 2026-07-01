package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat$AnimationDrawableTransition extends AnimatedStateListDrawableCompat$Transition {
    private final ObjectAnimator mAnim;
    private final boolean mHasReversibleFlag;

    public AnimatedStateListDrawableCompat$AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
        super(null);
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z2 ? numberOfFrames - 1 : 0;
        int i2 = z2 ? 0 : numberOfFrames - 1;
        AnimatedStateListDrawableCompat$FrameInterpolator animatedStateListDrawableCompat$FrameInterpolator = new AnimatedStateListDrawableCompat$FrameInterpolator(animationDrawable, z2);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
        objectAnimatorOfInt.setAutoCancel(true);
        objectAnimatorOfInt.setDuration(animatedStateListDrawableCompat$FrameInterpolator.getTotalDuration());
        objectAnimatorOfInt.setInterpolator(animatedStateListDrawableCompat$FrameInterpolator);
        this.mHasReversibleFlag = z3;
        this.mAnim = objectAnimatorOfInt;
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public boolean canReverse() {
        return this.mHasReversibleFlag;
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void reverse() {
        this.mAnim.reverse();
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void start() {
        this.mAnim.start();
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void stop() {
        this.mAnim.cancel();
    }
}
