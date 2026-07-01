package com.discord.widgets.guild_role_subscriptions.tier;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierViewHolder$BenefitViewHolder extends GuildRoleSubscriptionTierViewHolder {
    private final GuildRoleSubscriptionBenefitItemView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierViewHolder$BenefitViewHolder(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView) {
        super(guildRoleSubscriptionBenefitItemView, null);
        m.checkNotNullParameter(guildRoleSubscriptionBenefitItemView, "view");
        this.view = guildRoleSubscriptionBenefitItemView;
        guildRoleSubscriptionBenefitItemView.setPadding(0, 0, 0, 0);
        guildRoleSubscriptionBenefitItemView.setBackground(null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final GuildRoleSubscriptionBenefitItemView getView() {
        return this.view;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierViewHolder$BenefitViewHolder copy$default(GuildRoleSubscriptionTierViewHolder$BenefitViewHolder guildRoleSubscriptionTierViewHolder$BenefitViewHolder, GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionBenefitItemView = guildRoleSubscriptionTierViewHolder$BenefitViewHolder.view;
        }
        return guildRoleSubscriptionTierViewHolder$BenefitViewHolder.copy(guildRoleSubscriptionBenefitItemView);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
    public void bind(GuildRoleSubscriptionTierAdapterItem item) {
        m.checkNotNullParameter(item, "item");
        if (item instanceof GuildRoleSubscriptionTierAdapterItem$BenefitItem) {
            this.view.configureUI(((GuildRoleSubscriptionTierAdapterItem$BenefitItem) item).getBenefit());
        } else if (item instanceof GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem) {
            GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView = this.view;
            String string = guildRoleSubscriptionBenefitItemView.getContext().getString(2131890678);
            m.checkNotNullExpressionValue(string, "view.context.getString(R…re_server_access_benefit)");
            guildRoleSubscriptionBenefitItemView.configureUI(string, 2131231892, (String) null);
        }
    }

    public final GuildRoleSubscriptionTierViewHolder$BenefitViewHolder copy(GuildRoleSubscriptionBenefitItemView view) {
        m.checkNotNullParameter(view, "view");
        return new GuildRoleSubscriptionTierViewHolder$BenefitViewHolder(view);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionTierViewHolder$BenefitViewHolder) && m.areEqual(this.view, ((GuildRoleSubscriptionTierViewHolder$BenefitViewHolder) other).view);
        }
        return true;
    }

    public int hashCode() {
        GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView = this.view;
        if (guildRoleSubscriptionBenefitItemView != null) {
            return guildRoleSubscriptionBenefitItemView.hashCode();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ViewHolder
    public String toString() {
        StringBuilder sbU = a.U("BenefitViewHolder(view=");
        sbU.append(this.view);
        sbU.append(")");
        return sbU.toString();
    }
}
