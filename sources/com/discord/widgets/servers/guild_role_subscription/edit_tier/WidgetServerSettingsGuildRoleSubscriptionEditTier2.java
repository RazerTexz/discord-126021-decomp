package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierAdapter, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier2 extends FragmentStateAdapter {
    private static final int TIER_BENEFITS_POSITION = 2;
    private static final int TIER_DESIGN_POSITION = 1;
    private static final int TIER_DETAILS_POSITION = 0;
    private final long guildId;
    private int pageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier2(Fragment fragment, long j) {
        super(fragment);
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        this.guildId = j;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return WidgetGuildRoleSubscriptionTierDetails.INSTANCE.newInstance(true);
        }
        if (position == 1) {
            return WidgetGuildRoleSubscriptionTierDesign.INSTANCE.newInstance(true);
        }
        if (position == 2) {
            return WidgetGuildRoleSubscriptionTierBenefits.INSTANCE.newInstance(this.guildId, GuildRoleSubscriptionTierBenefitListType.ALL, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount, reason: from getter */
    public int getPageSize() {
        return this.pageSize;
    }

    public final int getTabStringResId(int position) {
        if (position == 0) {
            return R.string.guild_settings_role_subscription_tier_edit_details_title;
        }
        if (position == 1) {
            return R.string.guild_settings_role_subscription_tier_edit_design_title;
        }
        if (position == 2) {
            return R.string.guild_settings_role_subscription_tier_edit_benefits_title;
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
