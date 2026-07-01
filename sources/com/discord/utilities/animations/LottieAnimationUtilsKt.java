package com.discord.utilities.animations;

import com.airbnb.lottie.LottieAnimationView;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LottieAnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LottieAnimationUtilsKt {
    public static final void loopFrom(LottieAnimationView lottieAnimationView, int i, IntRange intRange, boolean z2) {
        m.checkNotNullParameter(lottieAnimationView, "$this$loopFrom");
        m.checkNotNullParameter(intRange, "loopFrames");
        if (z2) {
            lottieAnimationView.setFrame(i);
            lottieAnimationView.c();
        } else {
            lottieAnimationView.p.l.j.add(new LoopAnimationListener(lottieAnimationView, i, intRange));
        }
    }

    public static /* synthetic */ void loopFrom$default(LottieAnimationView lottieAnimationView, int i, IntRange intRange, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = StoreStream.Companion.getAccessibility().getReducedMotionEnabled();
        }
        loopFrom(lottieAnimationView, i, intRange, z2);
    }
}
