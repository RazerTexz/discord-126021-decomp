package com.discord.widgets.chat.list.model;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies$MessageState;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelMessages$MessagesWithMetadata {
    public static final WidgetChatListModelMessages$MessagesWithMetadata$Companion Companion = new WidgetChatListModelMessages$MessagesWithMetadata$Companion(null);
    private final Map<Long, StoreMessageReplies$MessageState> messageReplyState;
    private final Map<Long, StoreMessageState$State> messageState;
    private final Map<Long, Channel> messageThreads;
    private final List<Message> messages;
    private final Map<Long, StoreMessageReplies$MessageState> parentChannelMessageReplyState;
    private final Map<Long, StoreThreadMessages$ThreadState> threadCountsAndLatestMessages;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModelMessages$MessagesWithMetadata(List<Message> list, Map<Long, StoreMessageState$State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages$ThreadState> map3, Map<Long, ? extends StoreMessageReplies$MessageState> map4, Map<Long, ? extends StoreMessageReplies$MessageState> map5) {
        m.checkNotNullParameter(list, "messages");
        m.checkNotNullParameter(map, "messageState");
        m.checkNotNullParameter(map2, "messageThreads");
        m.checkNotNullParameter(map3, "threadCountsAndLatestMessages");
        m.checkNotNullParameter(map4, "messageReplyState");
        m.checkNotNullParameter(map5, "parentChannelMessageReplyState");
        this.messages = list;
        this.messageState = map;
        this.messageThreads = map2;
        this.threadCountsAndLatestMessages = map3;
        this.messageReplyState = map4;
        this.parentChannelMessageReplyState = map5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListModelMessages$MessagesWithMetadata copy$default(WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, List list, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetChatListModelMessages$MessagesWithMetadata.messages;
        }
        if ((i & 2) != 0) {
            map = widgetChatListModelMessages$MessagesWithMetadata.messageState;
        }
        Map map6 = map;
        if ((i & 4) != 0) {
            map2 = widgetChatListModelMessages$MessagesWithMetadata.messageThreads;
        }
        Map map7 = map2;
        if ((i & 8) != 0) {
            map3 = widgetChatListModelMessages$MessagesWithMetadata.threadCountsAndLatestMessages;
        }
        Map map8 = map3;
        if ((i & 16) != 0) {
            map4 = widgetChatListModelMessages$MessagesWithMetadata.messageReplyState;
        }
        Map map9 = map4;
        if ((i & 32) != 0) {
            map5 = widgetChatListModelMessages$MessagesWithMetadata.parentChannelMessageReplyState;
        }
        return widgetChatListModelMessages$MessagesWithMetadata.copy(list, map6, map7, map8, map9, map5);
    }

    public final List<Message> component1() {
        return this.messages;
    }

    public final Map<Long, StoreMessageState$State> component2() {
        return this.messageState;
    }

    public final Map<Long, Channel> component3() {
        return this.messageThreads;
    }

    public final Map<Long, StoreThreadMessages$ThreadState> component4() {
        return this.threadCountsAndLatestMessages;
    }

    public final Map<Long, StoreMessageReplies$MessageState> component5() {
        return this.messageReplyState;
    }

    public final Map<Long, StoreMessageReplies$MessageState> component6() {
        return this.parentChannelMessageReplyState;
    }

    public final WidgetChatListModelMessages$MessagesWithMetadata copy(List<Message> messages, Map<Long, StoreMessageState$State> messageState, Map<Long, Channel> messageThreads, Map<Long, StoreThreadMessages$ThreadState> threadCountsAndLatestMessages, Map<Long, ? extends StoreMessageReplies$MessageState> messageReplyState, Map<Long, ? extends StoreMessageReplies$MessageState> parentChannelMessageReplyState) {
        m.checkNotNullParameter(messages, "messages");
        m.checkNotNullParameter(messageState, "messageState");
        m.checkNotNullParameter(messageThreads, "messageThreads");
        m.checkNotNullParameter(threadCountsAndLatestMessages, "threadCountsAndLatestMessages");
        m.checkNotNullParameter(messageReplyState, "messageReplyState");
        m.checkNotNullParameter(parentChannelMessageReplyState, "parentChannelMessageReplyState");
        return new WidgetChatListModelMessages$MessagesWithMetadata(messages, messageState, messageThreads, threadCountsAndLatestMessages, messageReplyState, parentChannelMessageReplyState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModelMessages$MessagesWithMetadata)) {
            return false;
        }
        WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata = (WidgetChatListModelMessages$MessagesWithMetadata) other;
        return m.areEqual(this.messages, widgetChatListModelMessages$MessagesWithMetadata.messages) && m.areEqual(this.messageState, widgetChatListModelMessages$MessagesWithMetadata.messageState) && m.areEqual(this.messageThreads, widgetChatListModelMessages$MessagesWithMetadata.messageThreads) && m.areEqual(this.threadCountsAndLatestMessages, widgetChatListModelMessages$MessagesWithMetadata.threadCountsAndLatestMessages) && m.areEqual(this.messageReplyState, widgetChatListModelMessages$MessagesWithMetadata.messageReplyState) && m.areEqual(this.parentChannelMessageReplyState, widgetChatListModelMessages$MessagesWithMetadata.parentChannelMessageReplyState);
    }

    public final Map<Long, StoreMessageReplies$MessageState> getMessageReplyState() {
        return this.messageReplyState;
    }

    public final Map<Long, StoreMessageState$State> getMessageState() {
        return this.messageState;
    }

    public final Map<Long, Channel> getMessageThreads() {
        return this.messageThreads;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final Map<Long, StoreMessageReplies$MessageState> getParentChannelMessageReplyState() {
        return this.parentChannelMessageReplyState;
    }

    public final Map<Long, StoreThreadMessages$ThreadState> getThreadCountsAndLatestMessages() {
        return this.threadCountsAndLatestMessages;
    }

    public int hashCode() {
        List<Message> list = this.messages;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Map<Long, StoreMessageState$State> map = this.messageState;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Channel> map2 = this.messageThreads;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, StoreThreadMessages$ThreadState> map3 = this.threadCountsAndLatestMessages;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, StoreMessageReplies$MessageState> map4 = this.messageReplyState;
        int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, StoreMessageReplies$MessageState> map5 = this.parentChannelMessageReplyState;
        return iHashCode5 + (map5 != null ? map5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MessagesWithMetadata(messages=");
        sbU.append(this.messages);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", messageThreads=");
        sbU.append(this.messageThreads);
        sbU.append(", threadCountsAndLatestMessages=");
        sbU.append(this.threadCountsAndLatestMessages);
        sbU.append(", messageReplyState=");
        sbU.append(this.messageReplyState);
        sbU.append(", parentChannelMessageReplyState=");
        return a.M(sbU, this.parentChannelMessageReplyState, ")");
    }
}
