package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
    private final GuildRoleSubscriptionBenefitAdapter$Listener listener;
    private final GuildRoleSubscriptionBenefitItemView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView, GuildRoleSubscriptionBenefitAdapter$Listener guildRoleSubscriptionBenefitAdapter$Listener) {
        super(guildRoleSubscriptionBenefitItemView, null);
        m.checkNotNullParameter(guildRoleSubscriptionBenefitItemView, "view");
        m.checkNotNullParameter(guildRoleSubscriptionBenefitAdapter$Listener, "listener");
        this.view = guildRoleSubscriptionBenefitItemView;
        this.listener = guildRoleSubscriptionBenefitAdapter$Listener;
    }

    public static final /* synthetic */ GuildRoleSubscriptionBenefitAdapter$Listener access$getListener$p(GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder guildRoleSubscriptionBenefitViewHolder$ItemViewHolder) {
        return guildRoleSubscriptionBenefitViewHolder$ItemViewHolder.listener;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
    public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        this.itemView.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder$configure$1(this, benefitAdapterItem));
        if (!(benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem$BenefitItem)) {
            benefitAdapterItem = null;
        }
        GuildRoleSubscriptionBenefitAdapterItem$BenefitItem guildRoleSubscriptionBenefitAdapterItem$BenefitItem = (GuildRoleSubscriptionBenefitAdapterItem$BenefitItem) benefitAdapterItem;
        if (guildRoleSubscriptionBenefitAdapterItem$BenefitItem != null) {
            this.view.configureUI(guildRoleSubscriptionBenefitAdapterItem$BenefitItem.getBenefit());
        }
    }
}
