package com.discord.api.guildscheduledevent;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.type == guildScheduledEventBroadcastBody.type && C12238m.areEqual(this.entityId, guildScheduledEventBroadcastBody.entityId);
    }

    public int hashCode() {
        int i = this.type * 31;
        Long l = this.entityId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventBroadcastBody(type=");
        sbM833U.append(this.type);
        sbM833U.append(", entityId=");
        return C1643a.m819G(sbM833U, this.entityId, ")");
    }
}
