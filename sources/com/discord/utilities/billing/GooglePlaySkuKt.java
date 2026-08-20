package com.discord.utilities.billing;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GooglePlaySku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlaySkuKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GooglePlaySku.Type.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2.ordinal()] = 1;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1.ordinal()] = 2;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD.ordinal()] = 3;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD.ordinal()] = 4;
            iArr[GooglePlaySku.Type.PREMIUM_GUILD.ordinal()] = 5;
        }
    }

    public static final GooglePlaySku.Section getSection(GooglePlaySku googlePlaySku) {
        C12238m.checkNotNullParameter(googlePlaySku, "$this$getSection");
        int iOrdinal = googlePlaySku.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return GooglePlaySku.Section.PREMIUM;
        }
        if (iOrdinal == 2 || iOrdinal == 3) {
            return GooglePlaySku.Section.PREMIUM_AND_PREMIUM_GUILD;
        }
        if (iOrdinal == 4) {
            return GooglePlaySku.Section.PREMIUM_GUILD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isBundledSku(GooglePlaySku googlePlaySku) {
        C12238m.checkNotNullParameter(googlePlaySku, "$this$isBundledSku");
        return googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
    }

    public static final boolean isTier1(GooglePlaySku googlePlaySku) {
        C12238m.checkNotNullParameter(googlePlaySku, "$this$isTier1");
        return googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
    }

    public static final boolean isTier2(GooglePlaySku googlePlaySku) {
        C12238m.checkNotNullParameter(googlePlaySku, "$this$isTier2");
        return googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_2 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD;
    }
}
