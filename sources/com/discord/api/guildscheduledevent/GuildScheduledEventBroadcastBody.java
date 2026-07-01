package com.discord.api.guildscheduledevent;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventBroadcast.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildScheduledEventBroadcastBody {
    private final Long entityId;
    private final int type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventBroadcastBody)) {
            return false;
        }
        GuildScheduledEventBroadcastBody guildScheduledEventBroadcastBody = (GuildScheduledEventBroadcastBody) other;
        return this.type == guildScheduledEventBroadcastBody.type && m.areEqual(this.entityId, guildScheduledEventBroadcastBody.entityId);
    }

    public int hashCode() {
        int i = this.type * 31;
        Long l = this.entityId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventBroadcastBody(type=");
        sbU.append(this.type);
        sbU.append(", entityId=");
        return a.G(sbU, this.entityId, ")");
    }
}
