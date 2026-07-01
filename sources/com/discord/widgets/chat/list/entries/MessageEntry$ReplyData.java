package com.discord.widgets.chat.list.entries;

import b.d.b.a.a;
import com.discord.stores.StoreMessageReplies$MessageState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageEntry$ReplyData {
    private final boolean isRepliedUserBlocked;
    private final MessageEntry messageEntry;
    private final StoreMessageReplies$MessageState messageState;

    public MessageEntry$ReplyData(StoreMessageReplies$MessageState storeMessageReplies$MessageState, MessageEntry messageEntry, boolean z2) {
        m.checkNotNullParameter(storeMessageReplies$MessageState, "messageState");
        this.messageState = storeMessageReplies$MessageState;
        this.messageEntry = messageEntry;
        this.isRepliedUserBlocked = z2;
    }

    public static /* synthetic */ MessageEntry$ReplyData copy$default(MessageEntry$ReplyData messageEntry$ReplyData, StoreMessageReplies$MessageState storeMessageReplies$MessageState, MessageEntry messageEntry, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeMessageReplies$MessageState = messageEntry$ReplyData.messageState;
        }
        if ((i & 2) != 0) {
            messageEntry = messageEntry$ReplyData.messageEntry;
        }
        if ((i & 4) != 0) {
            z2 = messageEntry$ReplyData.isRepliedUserBlocked;
        }
        return messageEntry$ReplyData.copy(storeMessageReplies$MessageState, messageEntry, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreMessageReplies$MessageState getMessageState() {
        return this.messageState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MessageEntry getMessageEntry() {
        return this.messageEntry;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsRepliedUserBlocked() {
        return this.isRepliedUserBlocked;
    }

    public final MessageEntry$ReplyData copy(StoreMessageReplies$MessageState messageState, MessageEntry messageEntry, boolean isRepliedUserBlocked) {
        m.checkNotNullParameter(messageState, "messageState");
        return new MessageEntry$ReplyData(messageState, messageEntry, isRepliedUserBlocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntry$ReplyData)) {
            return false;
        }
        MessageEntry$ReplyData messageEntry$ReplyData = (MessageEntry$ReplyData) other;
        return m.areEqual(this.messageState, messageEntry$ReplyData.messageState) && m.areEqual(this.messageEntry, messageEntry$ReplyData.messageEntry) && this.isRepliedUserBlocked == messageEntry$ReplyData.isRepliedUserBlocked;
    }

    public final MessageEntry getMessageEntry() {
        return this.messageEntry;
    }

    public final StoreMessageReplies$MessageState getMessageState() {
        return this.messageState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        StoreMessageReplies$MessageState storeMessageReplies$MessageState = this.messageState;
        int iHashCode = (storeMessageReplies$MessageState != null ? storeMessageReplies$MessageState.hashCode() : 0) * 31;
        MessageEntry messageEntry = this.messageEntry;
        int iHashCode2 = (iHashCode + (messageEntry != null ? messageEntry.hashCode() : 0)) * 31;
        boolean z2 = this.isRepliedUserBlocked;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isRepliedUserBlocked() {
        return this.isRepliedUserBlocked;
    }

    public String toString() {
        StringBuilder sbU = a.U("ReplyData(messageState=");
        sbU.append(this.messageState);
        sbU.append(", messageEntry=");
        sbU.append(this.messageEntry);
        sbU.append(", isRepliedUserBlocked=");
        return a.O(sbU, this.isRepliedUserBlocked, ")");
    }

    public /* synthetic */ MessageEntry$ReplyData(StoreMessageReplies$MessageState storeMessageReplies$MessageState, MessageEntry messageEntry, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMessageReplies$MessageState, messageEntry, (i & 4) != 0 ? false : z2);
    }
}
