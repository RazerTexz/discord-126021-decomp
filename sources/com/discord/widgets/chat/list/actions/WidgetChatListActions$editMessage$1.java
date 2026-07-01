package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import j0.k.b;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$editMessage$1<T, R> implements b<Map<Long, ? extends Channel>, Observable<? extends CharSequence>> {
    public final /* synthetic */ Message $message;

    public WidgetChatListActions$editMessage$1(Message message) {
        this.$message = message;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends CharSequence> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends CharSequence> call2(Map<Long, Channel> map) {
        Channel channel = map.get(Long.valueOf(this.$message.getChannelId()));
        long guildId = channel != null ? channel.getGuildId() : 0L;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(storeStream$Companion.getUsers().observeAllUsers(), storeStream$Companion.getGuilds().observeGuilds(), StoreEmoji.getEmojiSet$default(storeStream$Companion.getEmojis(), guildId, this.$message.getChannelId(), false, false, 12, null), new WidgetChatListActions$editMessage$1$1(this, guildId, map));
    }
}
