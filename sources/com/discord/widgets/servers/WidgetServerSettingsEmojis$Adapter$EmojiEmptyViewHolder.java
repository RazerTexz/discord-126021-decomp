package com.discord.widgets.servers;

import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$EmojiEmptyViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsEmojis$Adapter, WidgetServerSettingsEmojis$Item> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Adapter$EmojiEmptyViewHolder(WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter) {
        super(R$layout.widget_server_settings_emojis_empty, widgetServerSettingsEmojis$Adapter);
        m.checkNotNullParameter(widgetServerSettingsEmojis$Adapter, "adapter");
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsEmojis$Item data) {
        m.checkNotNullParameter(data, "data");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsEmojis$Item widgetServerSettingsEmojis$Item) {
        onConfigure2(i, widgetServerSettingsEmojis$Item);
    }
}
