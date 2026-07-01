package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventBroadcastBody, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventBroadcast.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildScheduledEventBroadcast2 {
    private final Long entityId;
    private final int type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventBroadcast2)) {
            return false;
        }
        GuildScheduledEventBroadcast2 guildScheduledEventBroadcast2 = (GuildScheduledEventBroadcast2) other;
        return this.type == guildScheduledEventBroadcast2.type && Intrinsics3.areEqual(this.entityId, guildScheduledEventBroadcast2.entityId);
    }

    public int hashCode() {
        int i = this.type * 31;
        Long l = this.entityId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventBroadcastBody(type=");
        sbU.append(this.type);
        sbU.append(", entityId=");
        return outline.G(sbU, this.entityId, ")");
    }
}
