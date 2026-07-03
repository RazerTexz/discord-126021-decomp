package com.discord.utilities.animations;

import com.airbnb.lottie.LottieAnimationView;
import com.discord.stores.StoreStream;
import kotlin.ranges.IntRange;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LottieAnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LottieAnimationUtilsKt {
    public static final void loopFrom(LottieAnimationView lottieAnimationView, int i, IntRange intRange, boolean z2) {
        C12238m.checkNotNullParameter(lottieAnimationView, "$this$loopFrom");
        C12238m.checkNotNullParameter(intRange, "loopFrames");
        if (z2) {
            lottieAnimationView.setFrame(i);
            lottieAnimationView.m7493c();
        } else {
            lottieAnimationView.f14526p.f2371l.f2293j.add(new LoopAnimationListener(lottieAnimationView, i, intRange));
        }
    }

    public static /* synthetic */ void loopFrom$default(LottieAnimationView lottieAnimationView, int i, IntRange intRange, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
        }
        loopFrom(lottieAnimationView, i, intRange, z2);
    }
}
