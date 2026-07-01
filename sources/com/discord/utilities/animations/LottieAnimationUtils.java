package com.discord.utilities.animations;

import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieAnimationView;
import d0.z.d.Intrinsics3;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: com.discord.utilities.animations.LoopAnimationListener, reason: use source file name */
/* JADX INFO: compiled from: LottieAnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LottieAnimationUtils implements ValueAnimator.AnimatorUpdateListener {
    private final LottieAnimationView animationView;
    private final Ranges2 loopFrames;
    private final int triggerFrame;

    public LottieAnimationUtils(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2) {
        Intrinsics3.checkNotNullParameter(lottieAnimationView, "animationView");
        Intrinsics3.checkNotNullParameter(ranges2, "loopFrames");
        this.animationView = lottieAnimationView;
        this.triggerFrame = i;
        this.loopFrames = ranges2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (this.animationView.getFrame() >= this.triggerFrame) {
            LottieAnimationView lottieAnimationView = this.animationView;
            lottieAnimationView.p.p(this.loopFrames.getFirst(), this.loopFrames.getLast());
            this.animationView.p.l.j.remove(this);
        }
    }
}
