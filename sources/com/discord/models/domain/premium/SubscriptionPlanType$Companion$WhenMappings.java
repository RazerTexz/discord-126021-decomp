package com.discord.models.domain.premium;

import com.discord.api.premium.SubscriptionInterval;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SubscriptionPlanType$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        SubscriptionInterval.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[SubscriptionInterval.MONTHLY.ordinal()] = 1;
        iArr[SubscriptionInterval.YEARLY.ordinal()] = 2;
    }
}
