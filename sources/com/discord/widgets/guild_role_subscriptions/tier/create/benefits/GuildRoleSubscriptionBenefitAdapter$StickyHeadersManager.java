package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.utilities.views.StickyHeaderItemDecoration$LayoutManager;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager {
    private final View currentStickyHeaderView;
    private final GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder stickyHeaderHolder;

    public GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…          false\n        )");
        GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder guildRoleSubscriptionBenefitViewHolder$HeaderViewHolder = new GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
        this.stickyHeaderHolder = guildRoleSubscriptionBenefitViewHolder$HeaderViewHolder;
        View view = guildRoleSubscriptionBenefitViewHolder$HeaderViewHolder.itemView;
        m.checkNotNullExpressionValue(view, "stickyHeaderHolder.itemView");
        this.currentStickyHeaderView = view;
    }

    public final View getCurrentStickyHeaderView() {
        return this.currentStickyHeaderView;
    }

    public final GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder getStickyHeaderHolder() {
        return this.stickyHeaderHolder;
    }

    public final void layoutViews(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        StickyHeaderItemDecoration$LayoutManager.layoutHeaderView(recyclerView, this.currentStickyHeaderView);
    }
}
