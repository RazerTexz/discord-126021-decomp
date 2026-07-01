package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessagesLoader$ChannelLoadedState;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelTop$Companion$get$1<T, R> implements b<StoreMessagesLoader$ChannelLoadedState, Observable<? extends WidgetChatListModelTop>> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModelTop$Companion$get$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelTop> call(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return call2(storeMessagesLoader$ChannelLoadedState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelTop> call2(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        Observable kVar;
        if (storeMessagesLoader$ChannelLoadedState.isOldestMessagesLoaded()) {
            kVar = WidgetChatListModelTop$Companion.access$getWelcomeEntry(WidgetChatListModelTop.Companion, this.$channel);
        } else {
            kVar = (storeMessagesLoader$ChannelLoadedState.isTouchedSinceLastJump() || !storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded()) ? new k(new LoadingEntry()) : new k(new SpacerEntry(this.$channel.getId()));
        }
        return kVar.G(WidgetChatListModelTop$Companion$get$1$1.INSTANCE);
    }
}
