package com.discord.widgets.guild_role_subscriptions.tier;

import android.widget.LinearLayout;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanDetailsReviewBinding;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder extends GuildRoleSubscriptionTierViewHolder {
    private final ViewGuildRoleSubscriptionPlanDetailsReviewBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder(ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionPlanDetailsReviewBinding, "binding");
        LinearLayout linearLayout = viewGuildRoleSubscriptionPlanDetailsReviewBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = viewGuildRoleSubscriptionPlanDetailsReviewBinding;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ViewGuildRoleSubscriptionPlanDetailsReviewBinding getBinding() {
        return this.binding;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder copy$default(GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder guildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder, ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding, int i, Object obj) {
        if ((i & 1) != 0) {
            viewGuildRoleSubscriptionPlanDetailsReviewBinding = guildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder.binding;
        }
        return guildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder.copy(viewGuildRoleSubscriptionPlanDetailsReviewBinding);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
    public void bind(GuildRoleSubscriptionTierAdapterItem item) {
        m.checkNotNullParameter(item, "item");
        GuildRoleSubscriptionTierAdapterItem$PlanDetails guildRoleSubscriptionTierAdapterItem$PlanDetails = (GuildRoleSubscriptionTierAdapterItem$PlanDetails) item;
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionPlanReviewDescription");
        textView.setText(guildRoleSubscriptionTierAdapterItem$PlanDetails.getDescription());
        SimpleDraweeView simpleDraweeView = this.binding.f2196b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionPlanReviewCoverImage");
        MGImages.setImage$default(simpleDraweeView, guildRoleSubscriptionTierAdapterItem$PlanDetails.getCoverImage(), 0, 0, false, null, null, 124, null);
    }

    public final GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder copy(ViewGuildRoleSubscriptionPlanDetailsReviewBinding binding) {
        m.checkNotNullParameter(binding, "binding");
        return new GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder(binding);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder) && m.areEqual(this.binding, ((GuildRoleSubscriptionTierViewHolder$PlanDetailsViewHolder) other).binding);
        }
        return true;
    }

    public int hashCode() {
        ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding = this.binding;
        if (viewGuildRoleSubscriptionPlanDetailsReviewBinding != null) {
            return viewGuildRoleSubscriptionPlanDetailsReviewBinding.hashCode();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ViewHolder
    public String toString() {
        StringBuilder sbU = a.U("PlanDetailsViewHolder(binding=");
        sbU.append(this.binding);
        sbU.append(")");
        return sbU.toString();
    }
}
