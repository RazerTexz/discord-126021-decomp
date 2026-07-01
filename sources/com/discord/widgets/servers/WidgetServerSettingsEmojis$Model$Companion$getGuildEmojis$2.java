package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreEmojiGuild;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2 implements Action0 {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreEmojiGuild $storeGuildEmoji;

    public WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2(StoreEmojiGuild storeEmojiGuild, long j) {
        this.$storeGuildEmoji = storeEmojiGuild;
        this.$guildId = j;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.$storeGuildEmoji.fetchGuildEmoji(this.$guildId);
    }
}
