package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierBenefit$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        GuildRoleSubscriptionBenefitType.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[GuildRoleSubscriptionBenefitType.CHANNEL.ordinal()] = 1;
        iArr[GuildRoleSubscriptionBenefitType.INTANGIBLE.ordinal()] = 2;
        iArr[GuildRoleSubscriptionBenefitType.UNKNOWN.ordinal()] = 3;
    }
}
