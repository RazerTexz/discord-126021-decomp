package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest {
    private final long channelId;
    private final long messageId;
    private final MessageReaction reaction;
    private final long userId;

    public WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest(long j, long j2, long j3, MessageReaction messageReaction) {
        m.checkNotNullParameter(messageReaction, "reaction");
        this.userId = j;
        this.channelId = j2;
        this.messageId = j3;
        this.reaction = messageReaction;
    }

    public static /* synthetic */ WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest copy$default(WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest, long j, long j2, long j3, MessageReaction messageReaction, int i, Object obj) {
        return widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.copy((i & 1) != 0 ? widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.userId : j, (i & 2) != 0 ? widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.channelId : j2, (i & 4) != 0 ? widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.messageId : j3, (i & 8) != 0 ? widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.reaction : messageReaction);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MessageReaction getReaction() {
        return this.reaction;
    }

    public final WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest copy(long userId, long channelId, long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        return new WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest(userId, channelId, messageId, reaction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest)) {
            return false;
        }
        WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest = (WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest) other;
        return this.userId == widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.userId && this.channelId == widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.channelId && this.messageId == widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.messageId && m.areEqual(this.reaction, widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest.reaction);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final MessageReaction getReaction() {
        return this.reaction;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iA = (b.a(this.messageId) + ((b.a(this.channelId) + (b.a(this.userId) * 31)) * 31)) * 31;
        MessageReaction messageReaction = this.reaction;
        return iA + (messageReaction != null ? messageReaction.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdateRequest(userId=");
        sbU.append(this.userId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", reaction=");
        sbU.append(this.reaction);
        sbU.append(")");
        return sbU.toString();
    }
}
