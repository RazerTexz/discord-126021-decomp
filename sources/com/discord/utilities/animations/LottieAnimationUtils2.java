package com.discord.utilities.animations;

import com.airbnb.lottie.LottieAnimationView;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: com.discord.utilities.animations.LottieAnimationUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: LottieAnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LottieAnimationUtils2 {
    public static final void loopFrom(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2, boolean z2) {
        Intrinsics3.checkNotNullParameter(lottieAnimationView, "$this$loopFrom");
        Intrinsics3.checkNotNullParameter(ranges2, "loopFrames");
        if (z2) {
            lottieAnimationView.setFrame(i);
            lottieAnimationView.c();
        } else {
            lottieAnimationView.p.l.j.add(new LottieAnimationUtils(lottieAnimationView, i, ranges2));
        }
    }

    public static /* synthetic */ void loopFrom$default(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
        }
        loopFrom(lottieAnimationView, i, ranges2, z2);
    }
}
