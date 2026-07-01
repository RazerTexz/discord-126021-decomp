package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import d0.t.m;
import j0.k.b;
import j0.l.e.k;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$Model$Companion$get$2<T, R> implements b<Pair<? extends Message, ? extends Channel>, Observable<? extends WidgetChatListActions$Model>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ CharSequence $messageContent;
    public final /* synthetic */ int $type;

    public WidgetChatListActions$Model$Companion$get$2(long j, CharSequence charSequence, int i) {
        this.$channelId = j;
        this.$messageContent = charSequence;
        this.$type = i;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListActions$Model> call(Pair<? extends Message, ? extends Channel> pair) {
        return call2((Pair<Message, Channel>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListActions$Model> call2(Pair<Message, Channel> pair) {
        User author;
        Message messageComponent1 = pair.component1();
        Channel channelComponent2 = pair.component2();
        long id2 = (messageComponent1 == null || (author = messageComponent1.getAuthor()) == null) ? 0L : author.getId();
        if (channelComponent2 == null) {
            return new k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.g(storeStream$Companion.getPermissions().observePermissionsForChannel(this.$channelId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getGuilds().observeComputed(channelComponent2.getGuildId(), m.listOf(Long.valueOf(id2))).G(new WidgetChatListActions$Model$Companion$get$2$1(id2)), storeStream$Companion.getGuilds().observeGuild(channelComponent2.getGuildId()).r(), StoreEmoji.getEmojiSet$default(storeStream$Companion.getEmojis(), channelComponent2.getGuildId(), channelComponent2.getId(), false, false, 12, null), new WidgetChatListActions$Model$Companion$get$2$2(this, messageComponent1, channelComponent2));
    }
}
