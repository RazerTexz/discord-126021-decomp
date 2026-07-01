package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$ChatListState$Companion$get$1<T, R> implements b<Boolean, Observable<? extends WidgetChatListModel$ChatListState>> {
    public final /* synthetic */ long $channelId;

    public WidgetChatListModel$ChatListState$Companion$get$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel$ChatListState> call(Boolean bool) {
        return call(bool.booleanValue());
    }

    public final Observable<? extends WidgetChatListModel$ChatListState> call(boolean z2) {
        return z2 ? StoreStream.Companion.getMessagesLoader().getMessagesLoadedState(this.$channelId).G(WidgetChatListModel$ChatListState$Companion$get$1$1.INSTANCE).r() : new k(WidgetChatListModel$ChatListState.ATTACHED);
    }
}
