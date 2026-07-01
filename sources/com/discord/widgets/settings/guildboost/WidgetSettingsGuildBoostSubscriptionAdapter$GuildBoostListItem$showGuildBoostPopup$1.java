package com.discord.widgets.settings.guildboost;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import com.discord.models.domain.ModelAppliedGuildBoost;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$1 implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem $data;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$1(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem, WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem) {
        this.this$0 = widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem;
        this.$data = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ModelAppliedGuildBoost premiumGuildSubscription = this.$data.getBoostSlot().getPremiumGuildSubscription();
        if (premiumGuildSubscription == null) {
            return true;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter.access$getTransferListener$p(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(this.$data.getBoostSlot(), Long.valueOf(premiumGuildSubscription.getGuildId()));
        return true;
    }
}
