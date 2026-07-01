package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies$MessageState;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 extends k implements Function6<List<? extends Message>, Map<Long, ? extends StoreMessageState$State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages$ThreadState>, Map<Long, ? extends StoreMessageReplies$MessageState>, Map<Long, ? extends StoreMessageReplies$MessageState>, WidgetChatListModelMessages$MessagesWithMetadata> {
    public static final WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 INSTANCE = new WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1();

    public WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1() {
        super(6, WidgetChatListModelMessages$MessagesWithMetadata.class, "<init>", "<init>(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ WidgetChatListModelMessages$MessagesWithMetadata invoke(List<? extends Message> list, Map<Long, ? extends StoreMessageState$State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages$ThreadState> map3, Map<Long, ? extends StoreMessageReplies$MessageState> map4, Map<Long, ? extends StoreMessageReplies$MessageState> map5) {
        return invoke2((List<Message>) list, (Map<Long, StoreMessageState$State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages$ThreadState>) map3, map4, map5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChatListModelMessages$MessagesWithMetadata invoke2(List<Message> list, Map<Long, StoreMessageState$State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages$ThreadState> map3, Map<Long, ? extends StoreMessageReplies$MessageState> map4, Map<Long, ? extends StoreMessageReplies$MessageState> map5) {
        m.checkNotNullParameter(list, "p1");
        m.checkNotNullParameter(map, "p2");
        m.checkNotNullParameter(map2, "p3");
        m.checkNotNullParameter(map3, "p4");
        m.checkNotNullParameter(map4, "p5");
        m.checkNotNullParameter(map5, "p6");
        return new WidgetChatListModelMessages$MessagesWithMetadata(list, map, map2, map3, map4, map5);
    }
}
