package com.discord.utilities.animations;

import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.ranges.IntRange;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LottieAnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LoopAnimationListener implements ValueAnimator.AnimatorUpdateListener {
    private final LottieAnimationView animationView;
    private final IntRange loopFrames;
    private final int triggerFrame;

    public LoopAnimationListener(LottieAnimationView lottieAnimationView, int i, IntRange intRange) {
        C12238m.checkNotNullParameter(lottieAnimationView, "animationView");
        C12238m.checkNotNullParameter(intRange, "loopFrames");
        this.animationView = lottieAnimationView;
        this.triggerFrame = i;
        this.loopFrames = intRange;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (this.animationView.getFrame() >= this.triggerFrame) {
            LottieAnimationView lottieAnimationView = this.animationView;
            lottieAnimationView.f14526p.m696p(this.loopFrames.getFirst(), this.loopFrames.getLast());
            this.animationView.f14526p.f2371l.f2293j.remove(this);
        }
    }
}
