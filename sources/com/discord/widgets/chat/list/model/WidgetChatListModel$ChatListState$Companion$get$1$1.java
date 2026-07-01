package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessagesLoader$ChannelLoadedState;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$ChatListState$Companion$get$1$1<T, R> implements b<StoreMessagesLoader$ChannelLoadedState, WidgetChatListModel$ChatListState> {
    public static final WidgetChatListModel$ChatListState$Companion$get$1$1 INSTANCE = new WidgetChatListModel$ChatListState$Companion$get$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChatListModel$ChatListState call(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return call2(storeMessagesLoader$ChannelLoadedState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel$ChatListState call2(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return storeMessagesLoader$ChannelLoadedState.getIsTouchedSinceLastJump() ? WidgetChatListModel$ChatListState.DETACHED : WidgetChatListModel$ChatListState.DETACHED_UNTOUCHED;
    }
}
