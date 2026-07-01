package com.discord.models.application;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Unread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Unread$Marker {
    private final long channelId;
    private final Long messageId;

    public Unread$Marker(long j, Long l) {
        this.channelId = j;
        this.messageId = l;
    }

    public static /* synthetic */ Unread$Marker copy$default(Unread$Marker unread$Marker, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = unread$Marker.channelId;
        }
        if ((i & 2) != 0) {
            l = unread$Marker.messageId;
        }
        return unread$Marker.copy(j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getMessageId() {
        return this.messageId;
    }

    public final Unread$Marker copy(long channelId, Long messageId) {
        return new Unread$Marker(channelId, messageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Unread$Marker)) {
            return false;
        }
        Unread$Marker unread$Marker = (Unread$Marker) other;
        return this.channelId == unread$Marker.channelId && m.areEqual(this.messageId, unread$Marker.messageId);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        Long l = this.messageId;
        return iA + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Marker(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        return a.G(sbU, this.messageId, ")");
    }

    public Unread$Marker() {
        this(0L, 0L);
    }

    public Unread$Marker(long j, long j2, Long l) {
        this(j, (l == null || l.longValue() != j2) ? Long.valueOf(j2) : null);
    }
}
