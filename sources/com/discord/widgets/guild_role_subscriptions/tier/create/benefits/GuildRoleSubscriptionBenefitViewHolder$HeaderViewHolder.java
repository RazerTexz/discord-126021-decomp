package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.widget.LinearLayout;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
    private final ViewGuildRoleSubscriptionSectionHeaderItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder(ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionSectionHeaderItemBinding, "binding");
        LinearLayout linearLayout = viewGuildRoleSubscriptionSectionHeaderItemBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = viewGuildRoleSubscriptionSectionHeaderItemBinding;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
    public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        this.binding.f2198b.setText(((GuildRoleSubscriptionBenefitAdapterItem$Header) benefitAdapterItem).getType() == GuildRoleSubscriptionBenefitType.CHANNEL ? 2131890675 : 2131890646);
    }
}
