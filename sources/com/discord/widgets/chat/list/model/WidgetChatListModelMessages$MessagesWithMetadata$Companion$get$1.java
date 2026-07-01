package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.t.h0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreMessageState$State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages$ThreadState>, WidgetChatListModelMessages$MessagesWithMetadata> {
    public final /* synthetic */ List $messages;

    public WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$1(List list) {
        this.$messages = list;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChatListModelMessages$MessagesWithMetadata call(Map<Long, ? extends StoreMessageState$State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages$ThreadState> map3) {
        return call2((Map<Long, StoreMessageState$State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages$ThreadState>) map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModelMessages$MessagesWithMetadata call2(Map<Long, StoreMessageState$State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages$ThreadState> map3) {
        List list = this.$messages;
        m.checkNotNullExpressionValue(map, "messageState");
        m.checkNotNullExpressionValue(map2, "messageThreads");
        m.checkNotNullExpressionValue(map3, "threadCountsAndLatestMessages");
        return new WidgetChatListModelMessages$MessagesWithMetadata(list, map, map2, map3, h0.emptyMap(), h0.emptyMap());
    }
}
