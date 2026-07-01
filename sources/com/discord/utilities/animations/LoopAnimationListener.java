package com.discord.utilities.animations;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import com.airbnb.lottie.LottieAnimationView;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LottieAnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LoopAnimationListener implements ValueAnimator$AnimatorUpdateListener {
    private final LottieAnimationView animationView;
    private final IntRange loopFrames;
    private final int triggerFrame;

    public LoopAnimationListener(LottieAnimationView lottieAnimationView, int i, IntRange intRange) {
        m.checkNotNullParameter(lottieAnimationView, "animationView");
        m.checkNotNullParameter(intRange, "loopFrames");
        this.animationView = lottieAnimationView;
        this.triggerFrame = i;
        this.loopFrames = intRange;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (this.animationView.getFrame() >= this.triggerFrame) {
            LottieAnimationView lottieAnimationView = this.animationView;
            lottieAnimationView.p.p(this.loopFrames.getFirst(), this.loopFrames.getLast());
            this.animationView.p.l.j.remove(this);
        }
    }
}
