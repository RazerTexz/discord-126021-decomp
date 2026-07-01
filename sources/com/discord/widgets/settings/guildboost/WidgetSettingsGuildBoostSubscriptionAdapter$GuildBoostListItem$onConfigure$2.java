package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$Item $data;
    public final /* synthetic */ boolean $hasCooldown;
    public final /* synthetic */ boolean $isActiveGuildBoost;
    public final /* synthetic */ ModelGuildBoostSlot $slot;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem, boolean z2, boolean z3, WidgetSettingsGuildBoostSubscriptionAdapter$Item widgetSettingsGuildBoostSubscriptionAdapter$Item, ModelGuildBoostSlot modelGuildBoostSlot) {
        this.this$0 = widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem;
        this.$isActiveGuildBoost = z2;
        this.$hasCooldown = z3;
        this.$data = widgetSettingsGuildBoostSubscriptionAdapter$Item;
        this.$slot = modelGuildBoostSlot;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (!this.$isActiveGuildBoost && !this.$hasCooldown) {
            WidgetSettingsGuildBoostSubscriptionAdapter.access$getSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$slot.getId()));
            return;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem = this.this$0;
        m.checkNotNullExpressionValue(view, "view");
        WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.access$showGuildBoostPopup(widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem, view, this.$hasCooldown, WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.access$getAdapter$p(this.this$0)), WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.access$getAdapter$p(this.this$0)), (WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem) this.$data);
    }
}
