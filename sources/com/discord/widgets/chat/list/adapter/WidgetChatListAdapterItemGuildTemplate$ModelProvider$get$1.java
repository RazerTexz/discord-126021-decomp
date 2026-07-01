package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1 implements Action0 {
    public final /* synthetic */ GuildTemplateEntry $item;

    public WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1(GuildTemplateEntry guildTemplateEntry) {
        this.$item = guildTemplateEntry;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreStream.Companion.getGuildTemplates().maybeInitTemplateState(this.$item.getGuildTemplateCode());
    }
}
