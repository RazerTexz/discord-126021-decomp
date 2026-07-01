package com.discord.widgets.guild_role_subscriptions;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RoleSubscriptionsLinkingUtil$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        RoleSubscriptionsLinkingUtil$HandoffEligibility.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[RoleSubscriptionsLinkingUtil$HandoffEligibility.UNKNOWN_GUILD.ordinal()] = 1;
        iArr[RoleSubscriptionsLinkingUtil$HandoffEligibility.INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS.ordinal()] = 2;
        iArr[RoleSubscriptionsLinkingUtil$HandoffEligibility.INELIGIBLE_FOR_MOBILE_WEB_PURCHASE.ordinal()] = 3;
        iArr[RoleSubscriptionsLinkingUtil$HandoffEligibility.ELIGIBLE.ordinal()] = 4;
    }
}
