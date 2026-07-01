package com.discord.api.premium;


/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PremiumTierTypeAdapter$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        PremiumTier.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY.ordinal()] = 1;
        iArr[PremiumTier.TIER_1.ordinal()] = 2;
        iArr[PremiumTier.TIER_2.ordinal()] = 3;
        iArr[PremiumTier.TIER_0.ordinal()] = 4;
        iArr[PremiumTier.NONE.ordinal()] = 5;
    }
}
