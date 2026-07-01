package com.discord.utilities.billing;

import com.discord.models.domain.ModelSku4;
import d0.t.Collections2;
import java.util.List;

/* JADX INFO: renamed from: com.discord.utilities.billing.GooglePlayInAppSkuKt, reason: use source file name */
/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayInAppSku2 {
    private static final List<GooglePlayInAppSku> premiumGifts;
    private static final GooglePlayInAppSku premiumTier1Month;
    private static final GooglePlayInAppSku premiumTier1Year;
    private static final GooglePlayInAppSku premiumTier2Month;
    private static final GooglePlayInAppSku premiumTier2Year;

    static {
        GooglePlayInAppSku4 googlePlayInAppSku4 = GooglePlayInAppSku4.PREMIUM_GIFT;
        Long lValueOf = Long.valueOf(ModelSku4.PREMIUM_TIER_1_SKU_ID);
        GooglePlayInAppSku googlePlayInAppSku = new GooglePlayInAppSku("premium_month_tier_1", googlePlayInAppSku4, null, lValueOf, 4, null);
        premiumTier1Month = googlePlayInAppSku;
        GooglePlayInAppSku googlePlayInAppSku2 = new GooglePlayInAppSku("premium_year_tier_1", googlePlayInAppSku4, null, lValueOf, 4, null);
        premiumTier1Year = googlePlayInAppSku2;
        Long lValueOf2 = Long.valueOf(ModelSku4.PREMIUM_TIER_2_SKU_ID);
        GooglePlayInAppSku googlePlayInAppSku3 = new GooglePlayInAppSku("premium_month_tier_2", googlePlayInAppSku4, null, lValueOf2, 4, null);
        premiumTier2Month = googlePlayInAppSku3;
        GooglePlayInAppSku googlePlayInAppSku5 = new GooglePlayInAppSku("premium_year_tier_2", googlePlayInAppSku4, null, lValueOf2, 4, null);
        premiumTier2Year = googlePlayInAppSku5;
        premiumGifts = Collections2.listOf((Object[]) new GooglePlayInAppSku[]{googlePlayInAppSku, googlePlayInAppSku2, googlePlayInAppSku3, googlePlayInAppSku5});
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
