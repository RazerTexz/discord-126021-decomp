package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout$OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$2 implements TabLayout$OnTabSelectedListener {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    public WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$2(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabReselected(TabLayout$Tab tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabSelected(TabLayout$Tab tab) {
        if (tab != null) {
            int position = tab.getPosition();
            MaterialButton materialButton = WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getBinding$p(this.this$0).f;
            m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsGu…ubscriptionEditTierDelete");
            materialButton.setVisibility(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getAdapter$p(this.this$0).isDetailsTab(position) ? 0 : 8);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout$Tab tab) {
    }
}
