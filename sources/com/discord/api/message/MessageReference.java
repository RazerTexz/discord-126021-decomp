package com.discord.api.message;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: MessageReference.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageReference {
    private final Long channelId;
    private final Long guildId;
    private final Long messageId;

    public MessageReference(Long l, Long l2, Long l3) {
        this.guildId = l;
        this.channelId = l2;
        this.messageId = l3;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Long getMessageId() {
        return this.messageId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReference)) {
            return false;
        }
        MessageReference messageReference = (MessageReference) other;
        return Intrinsics3.areEqual(this.guildId, messageReference.guildId) && Intrinsics3.areEqual(this.channelId, messageReference.channelId) && Intrinsics3.areEqual(this.messageId, messageReference.messageId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageId;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageReference(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        return outline.G(sbU, this.messageId, ")");
    }
}
