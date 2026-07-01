package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.o;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2 extends o implements Function0<GuildRoleSubscriptionTierBenefitListType> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierBenefitListType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitListType invoke() {
        Serializable serializable = this.this$0.requireArguments().getSerializable(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE);
        if (!(serializable instanceof GuildRoleSubscriptionTierBenefitListType)) {
            serializable = null;
        }
        GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType = (GuildRoleSubscriptionTierBenefitListType) serializable;
        return guildRoleSubscriptionTierBenefitListType != null ? guildRoleSubscriptionTierBenefitListType : GuildRoleSubscriptionTierBenefitListType.ALL;
    }
}
