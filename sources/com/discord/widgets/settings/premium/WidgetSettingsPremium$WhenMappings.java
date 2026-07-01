package com.discord.widgets.settings.premium;

import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.ModelSubscription$Status;
import com.discord.models.domain.premium.SubscriptionPlanType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPremium$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4;
    public static final /* synthetic */ int[] $EnumSwitchMapping$5;

    static {
        SubscriptionInterval.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[SubscriptionInterval.YEARLY.ordinal()] = 1;
        iArr[SubscriptionInterval.MONTHLY.ordinal()] = 2;
        SubscriptionPlanType.values();
        int[] iArr2 = new int[17];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[SubscriptionPlanType.PREMIUM_MONTH_LEGACY.ordinal()] = 1;
        iArr2[SubscriptionPlanType.PREMIUM_YEAR_LEGACY.ordinal()] = 2;
        ModelSubscription$Status.values();
        int[] iArr3 = new int[6];
        $EnumSwitchMapping$2 = iArr3;
        ModelSubscription$Status modelSubscription$Status = ModelSubscription$Status.PAST_DUE;
        iArr3[modelSubscription$Status.ordinal()] = 1;
        ModelSubscription$Status modelSubscription$Status2 = ModelSubscription$Status.ACCOUNT_HOLD;
        iArr3[modelSubscription$Status2.ordinal()] = 2;
        ModelSubscription$Status.values();
        int[] iArr4 = new int[6];
        $EnumSwitchMapping$3 = iArr4;
        iArr4[modelSubscription$Status.ordinal()] = 1;
        iArr4[modelSubscription$Status2.ordinal()] = 2;
        ModelSubscription$Status.values();
        int[] iArr5 = new int[6];
        $EnumSwitchMapping$4 = iArr5;
        iArr5[ModelSubscription$Status.ACTIVE.ordinal()] = 1;
        iArr5[ModelSubscription$Status.CANCELED.ordinal()] = 2;
        iArr5[modelSubscription$Status.ordinal()] = 3;
        iArr5[modelSubscription$Status2.ordinal()] = 4;
        SubscriptionPlanType.values();
        int[] iArr6 = new int[17];
        $EnumSwitchMapping$5 = iArr6;
        iArr6[SubscriptionPlanType.PREMIUM_MONTH_TIER_1.ordinal()] = 1;
        iArr6[SubscriptionPlanType.PREMIUM_YEAR_TIER_1.ordinal()] = 2;
        iArr6[SubscriptionPlanType.PREMIUM_MONTH_TIER_2.ordinal()] = 3;
        iArr6[SubscriptionPlanType.PREMIUM_3_MONTH_TIER_2.ordinal()] = 4;
        iArr6[SubscriptionPlanType.PREMIUM_6_MONTH_TIER_2.ordinal()] = 5;
        iArr6[SubscriptionPlanType.PREMIUM_YEAR_TIER_2.ordinal()] = 6;
    }
}
