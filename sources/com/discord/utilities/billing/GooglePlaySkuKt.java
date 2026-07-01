package com.discord.utilities.billing;

import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: GooglePlaySku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlaySkuKt {
    public static final GooglePlaySku$Section getSection(GooglePlaySku googlePlaySku) {
        m.checkNotNullParameter(googlePlaySku, "$this$getSection");
        int iOrdinal = googlePlaySku.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return GooglePlaySku$Section.PREMIUM;
        }
        if (iOrdinal == 2 || iOrdinal == 3) {
            return GooglePlaySku$Section.PREMIUM_AND_PREMIUM_GUILD;
        }
        if (iOrdinal == 4) {
            return GooglePlaySku$Section.PREMIUM_GUILD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isBundledSku(GooglePlaySku googlePlaySku) {
        m.checkNotNullParameter(googlePlaySku, "$this$isBundledSku");
        return googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD || googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
    }

    public static final boolean isTier1(GooglePlaySku googlePlaySku) {
        m.checkNotNullParameter(googlePlaySku, "$this$isTier1");
        return googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
    }

    public static final boolean isTier2(GooglePlaySku googlePlaySku) {
        m.checkNotNullParameter(googlePlaySku, "$this$isTier2");
        return googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_2 || googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD;
    }
}
