package com.discord.widgets.settings.premium;

import com.discord.utilities.billing.GooglePlaySku$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChoosePlan$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        GooglePlaySku$Type.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[GooglePlaySku$Type.PREMIUM_TIER_1.ordinal()] = 1;
        iArr[GooglePlaySku$Type.PREMIUM_TIER_2.ordinal()] = 2;
        iArr[GooglePlaySku$Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD.ordinal()] = 3;
        iArr[GooglePlaySku$Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD.ordinal()] = 4;
        iArr[GooglePlaySku$Type.PREMIUM_GUILD.ordinal()] = 5;
    }
}
