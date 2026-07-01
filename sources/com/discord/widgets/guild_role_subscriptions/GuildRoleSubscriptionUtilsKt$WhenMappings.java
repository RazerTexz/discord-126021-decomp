package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.PayoutStatus;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildRoleSubscriptionUtilsKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        PayoutStatus.values();
        int[] iArr = new int[14];
        $EnumSwitchMapping$0 = iArr;
        iArr[PayoutStatus.MANUAL.ordinal()] = 1;
        iArr[PayoutStatus.OPEN.ordinal()] = 2;
        iArr[PayoutStatus.PENDING.ordinal()] = 3;
        iArr[PayoutStatus.PROCESSING.ordinal()] = 4;
        iArr[PayoutStatus.SUBMITTED.ordinal()] = 5;
        iArr[PayoutStatus.PENDING_FUNDS.ordinal()] = 6;
        iArr[PayoutStatus.PAID.ordinal()] = 7;
        iArr[PayoutStatus.CANCELED.ordinal()] = 8;
        iArr[PayoutStatus.DEFERRED.ordinal()] = 9;
        iArr[PayoutStatus.DEFERRED_INTERNAL.ordinal()] = 10;
        iArr[PayoutStatus.ERROR.ordinal()] = 11;
        iArr[PayoutStatus.UNKNOWN.ordinal()] = 12;
        iArr[PayoutStatus.REJECTED.ordinal()] = 13;
        iArr[PayoutStatus.RISK_REVIEW.ordinal()] = 14;
        GuildRoleSubscriptionFreeTrialIntervalTypes.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[GuildRoleSubscriptionFreeTrialIntervalTypes.DAILY.ordinal()] = 1;
        iArr2[GuildRoleSubscriptionFreeTrialIntervalTypes.MONTHLY.ordinal()] = 2;
        iArr2[GuildRoleSubscriptionFreeTrialIntervalTypes.YEARLY.ordinal()] = 3;
    }
}
