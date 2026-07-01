package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessageReplies$MessageState;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2<T, R> implements b<List<? extends Message>, Observable<? extends WidgetChatListModelMessages$MessagesWithMetadata>> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2(Channel channel) {
        this.$channel = channel;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelMessages$MessagesWithMetadata> call2(List<Message> list) {
        k kVar = new k(list);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Map<Long, StoreMessageState$State>> messageState = storeStream$Companion.getMessageState().getMessageState();
        StoreChannels channels = storeStream$Companion.getChannels();
        m.checkNotNullExpressionValue(list, "messages");
        Observable<Map<Long, Channel>> observableObserveThreadsFromMessages = channels.observeThreadsFromMessages(list);
        Observable<Map<Long, StoreThreadMessages$ThreadState>> observableObserveThreadCountAndLatestMessage = storeStream$Companion.getThreadMessages().observeThreadCountAndLatestMessage();
        Observable<Map<Long, StoreMessageReplies$MessageState>> observableObserveMessageReferencesForChannel = storeStream$Companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getId());
        Observable<Map<Long, StoreMessageReplies$MessageState>> observableObserveMessageReferencesForChannel2 = storeStream$Companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getParentId());
        WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 widgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 = WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1.INSTANCE;
        Object widgetChatListModelMessages$sam$rx_functions_Func6$0 = widgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1;
        if (widgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 != null) {
            widgetChatListModelMessages$sam$rx_functions_Func6$0 = new WidgetChatListModelMessages$sam$rx_functions_Func6$0(widgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1);
        }
        return Observable.f(kVar, messageState, observableObserveThreadsFromMessages, observableObserveThreadCountAndLatestMessage, observableObserveMessageReferencesForChannel, observableObserveMessageReferencesForChannel2, (Func6) widgetChatListModelMessages$sam$rx_functions_Func6$0);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelMessages$MessagesWithMetadata> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }
}
