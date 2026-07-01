package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildRoleSubscriptionTierBenefitViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        GuildRoleSubscriptionBenefitType.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = GuildRoleSubscriptionBenefitType.CHANNEL;
        iArr[guildRoleSubscriptionBenefitType.ordinal()] = 1;
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = GuildRoleSubscriptionBenefitType.INTANGIBLE;
        iArr[guildRoleSubscriptionBenefitType2.ordinal()] = 2;
        GuildRoleSubscriptionBenefitType.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[guildRoleSubscriptionBenefitType.ordinal()] = 1;
        iArr2[guildRoleSubscriptionBenefitType2.ordinal()] = 2;
    }
}
