package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import d0.z.d.Lambda;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$benefitType$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit3 extends Lambda implements Function0<GuildRoleSubscriptionBenefitType> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit3(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionBenefitType invoke() {
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra("INTENT_EXTRA_BENEFIT_TYPE");
        if (!(serializableExtra instanceof GuildRoleSubscriptionBenefitType)) {
            serializableExtra = null;
        }
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = (GuildRoleSubscriptionBenefitType) serializableExtra;
        return guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType : GuildRoleSubscriptionBenefitType.UNKNOWN;
    }
}
