package com.discord.utilities.premium;

import com.discord.api.premium.PremiumTier;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PremiumUtilsKt {
    public static final boolean grantsAccessToCustomTagAndAnimatedAvatarFeatures(PremiumTier premiumTier) {
        C12238m.checkNotNullParameter(premiumTier, "$this$grantsAccessToCustomTagAndAnimatedAvatarFeatures");
        return premiumTier == PremiumTier.TIER_1 || premiumTier == PremiumTier.TIER_2;
    }

    public static final boolean grantsAccessToPremiumStickers(PremiumTier premiumTier) {
        C12238m.checkNotNullParameter(premiumTier, "$this$grantsAccessToPremiumStickers");
        return premiumTier == PremiumTier.TIER_2 || premiumTier == PremiumTier.TIER_0;
    }
}
