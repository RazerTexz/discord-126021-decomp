package com.discord.utilities.premium;

import com.discord.api.premium.PremiumTier;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.premium.PremiumUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PremiumUtils3 {
    public static final boolean grantsAccessToCustomTagAndAnimatedAvatarFeatures(PremiumTier premiumTier) {
        Intrinsics3.checkNotNullParameter(premiumTier, "$this$grantsAccessToCustomTagAndAnimatedAvatarFeatures");
        return premiumTier == PremiumTier.TIER_1 || premiumTier == PremiumTier.TIER_2;
    }

    public static final boolean grantsAccessToPremiumStickers(PremiumTier premiumTier) {
        Intrinsics3.checkNotNullParameter(premiumTier, "$this$grantsAccessToPremiumStickers");
        return premiumTier == PremiumTier.TIER_2 || premiumTier == PremiumTier.TIER_0;
    }
}
