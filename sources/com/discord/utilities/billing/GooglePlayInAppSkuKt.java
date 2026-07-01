package com.discord.utilities.billing;

import com.discord.models.domain.ModelSkuKt;
import d0.t.n;
import java.util.List;

/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayInAppSkuKt {
    private static final List<GooglePlayInAppSku> premiumGifts;
    private static final GooglePlayInAppSku premiumTier1Month;
    private static final GooglePlayInAppSku premiumTier1Year;
    private static final GooglePlayInAppSku premiumTier2Month;
    private static final GooglePlayInAppSku premiumTier2Year;

    static {
        InAppSkuType inAppSkuType = InAppSkuType.PREMIUM_GIFT;
        Long lValueOf = Long.valueOf(ModelSkuKt.PREMIUM_TIER_1_SKU_ID);
        GooglePlayInAppSku googlePlayInAppSku = new GooglePlayInAppSku("premium_month_tier_1", inAppSkuType, null, lValueOf, 4, null);
        premiumTier1Month = googlePlayInAppSku;
        GooglePlayInAppSku googlePlayInAppSku2 = new GooglePlayInAppSku("premium_year_tier_1", inAppSkuType, null, lValueOf, 4, null);
        premiumTier1Year = googlePlayInAppSku2;
        Long lValueOf2 = Long.valueOf(ModelSkuKt.PREMIUM_TIER_2_SKU_ID);
        GooglePlayInAppSku googlePlayInAppSku3 = new GooglePlayInAppSku("premium_month_tier_2", inAppSkuType, null, lValueOf2, 4, null);
        premiumTier2Month = googlePlayInAppSku3;
        GooglePlayInAppSku googlePlayInAppSku4 = new GooglePlayInAppSku("premium_year_tier_2", inAppSkuType, null, lValueOf2, 4, null);
        premiumTier2Year = googlePlayInAppSku4;
        premiumGifts = n.listOf((Object[]) new GooglePlayInAppSku[]{googlePlayInAppSku, googlePlayInAppSku2, googlePlayInAppSku3, googlePlayInAppSku4});
    }

    public static final List<GooglePlayInAppSku> getPremiumGifts() {
        return premiumGifts;
    }

    public static final GooglePlayInAppSku getPremiumTier1Month() {
        return premiumTier1Month;
    }

    public static final GooglePlayInAppSku getPremiumTier1Year() {
        return premiumTier1Year;
    }

    public static final GooglePlayInAppSku getPremiumTier2Month() {
        return premiumTier2Month;
    }

    public static final GooglePlayInAppSku getPremiumTier2Year() {
        return premiumTier2Year;
    }
}
