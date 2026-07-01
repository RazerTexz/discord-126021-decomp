package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierAdapter extends FragmentStateAdapter {
    public static final ServerSettingsGuildRoleSubscriptionEditTierAdapter$Companion Companion = new ServerSettingsGuildRoleSubscriptionEditTierAdapter$Companion(null);
    private static final int TIER_BENEFITS_POSITION = 2;
    private static final int TIER_DESIGN_POSITION = 1;
    private static final int TIER_DETAILS_POSITION = 0;
    private final long guildId;
    private int pageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierAdapter(Fragment fragment, long j) {
        super(fragment);
        m.checkNotNullParameter(fragment, "fragment");
        this.guildId = j;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return WidgetGuildRoleSubscriptionTierDetails.Companion.newInstance(true);
        }
        if (position == 1) {
            return WidgetGuildRoleSubscriptionTierDesign.Companion.newInstance(true);
        }
        if (position == 2) {
            return WidgetGuildRoleSubscriptionTierBenefits.Companion.newInstance(this.guildId, GuildRoleSubscriptionTierBenefitListType.ALL, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount, reason: from getter */
    public int getPageSize() {
        return this.pageSize;
    }

    public final int getTabStringResId(int position) {
        if (position == 0) {
            return 2131891417;
        }
        if (position == 1) {
            return 2131891416;
        }
        if (position == 2) {
            return 2131891415;
        }
        throw new IllegalArgumentException();
    }

    public final boolean isDetailsTab(int position) {
        return position == 0;
    }

    public final void setPageSize(int pageSize) {
        if (this.pageSize == pageSize) {
            return;
        }
        this.pageSize = pageSize;
        notifyDataSetChanged();
    }
}
