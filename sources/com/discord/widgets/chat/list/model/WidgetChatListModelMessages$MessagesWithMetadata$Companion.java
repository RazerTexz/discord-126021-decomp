package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$MessagesWithMetadata$Companion {
    private WidgetChatListModelMessages$MessagesWithMetadata$Companion() {
    }

    public final Observable<WidgetChatListModelMessages$MessagesWithMetadata> get(List<Message> messages) {
        m.checkNotNullParameter(messages, "messages");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetChatListModelMessages$MessagesWithMetadata> observableI = Observable.i(storeStream$Companion.getMessageState().getMessageState(), storeStream$Companion.getChannels().observeThreadsFromMessages(messages), storeStream$Companion.getThreadMessages().observeThreadCountAndLatestMessage(), new WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$1(messages));
        m.checkNotNullExpressionValue(observableI, "Observable\n            .…          )\n            }");
        return observableI;
    }

    public /* synthetic */ WidgetChatListModelMessages$MessagesWithMetadata$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Observable<WidgetChatListModelMessages$MessagesWithMetadata> get(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Observable observableY = StoreStream.Companion.getMessages().observeMessagesForChannel(channel.getId()).Y(new WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2(channel));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        )\n              }");
        return observableY;
    }
}
