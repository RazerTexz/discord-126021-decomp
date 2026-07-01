package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.message.MessageReference;
import com.discord.models.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: StorePendingReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StorePendingReplies$PendingReply {
    private final MessageReference messageReference;
    private final Message originalMessage;
    private boolean shouldMention;
    private final boolean showMentionToggle;

    public StorePendingReplies$PendingReply(MessageReference messageReference, Message message, boolean z2, boolean z3) {
        m.checkNotNullParameter(messageReference, "messageReference");
        m.checkNotNullParameter(message, "originalMessage");
        this.messageReference = messageReference;
        this.originalMessage = message;
        this.shouldMention = z2;
        this.showMentionToggle = z3;
    }

    public static /* synthetic */ StorePendingReplies$PendingReply copy$default(StorePendingReplies$PendingReply storePendingReplies$PendingReply, MessageReference messageReference, Message message, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            messageReference = storePendingReplies$PendingReply.messageReference;
        }
        if ((i & 2) != 0) {
            message = storePendingReplies$PendingReply.originalMessage;
        }
        if ((i & 4) != 0) {
            z2 = storePendingReplies$PendingReply.shouldMention;
        }
        if ((i & 8) != 0) {
            z3 = storePendingReplies$PendingReply.showMentionToggle;
        }
        return storePendingReplies$PendingReply.copy(messageReference, message, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Message getOriginalMessage() {
        return this.originalMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShouldMention() {
        return this.shouldMention;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowMentionToggle() {
        return this.showMentionToggle;
    }

    public final StorePendingReplies$PendingReply copy(MessageReference messageReference, Message originalMessage, boolean shouldMention, boolean showMentionToggle) {
        m.checkNotNullParameter(messageReference, "messageReference");
        m.checkNotNullParameter(originalMessage, "originalMessage");
        return new StorePendingReplies$PendingReply(messageReference, originalMessage, shouldMention, showMentionToggle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StorePendingReplies$PendingReply)) {
            return false;
        }
        StorePendingReplies$PendingReply storePendingReplies$PendingReply = (StorePendingReplies$PendingReply) other;
        return m.areEqual(this.messageReference, storePendingReplies$PendingReply.messageReference) && m.areEqual(this.originalMessage, storePendingReplies$PendingReply.originalMessage) && this.shouldMention == storePendingReplies$PendingReply.shouldMention && this.showMentionToggle == storePendingReplies$PendingReply.showMentionToggle;
    }

    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    public final Message getOriginalMessage() {
        return this.originalMessage;
    }

    public final boolean getShouldMention() {
        return this.shouldMention;
    }

    public final boolean getShowMentionToggle() {
        return this.showMentionToggle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        MessageReference messageReference = this.messageReference;
        int iHashCode = (messageReference != null ? messageReference.hashCode() : 0) * 31;
        Message message = this.originalMessage;
        int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
        boolean z2 = this.shouldMention;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.showMentionToggle;
        return i + (z3 ? 1 : z3);
    }

    public final void setShouldMention(boolean z2) {
        this.shouldMention = z2;
    }

    public String toString() {
        StringBuilder sbU = a.U("PendingReply(messageReference=");
        sbU.append(this.messageReference);
        sbU.append(", originalMessage=");
        sbU.append(this.originalMessage);
        sbU.append(", shouldMention=");
        sbU.append(this.shouldMention);
        sbU.append(", showMentionToggle=");
        return a.O(sbU, this.showMentionToggle, ")");
    }
}
