package com.discord.api.guildscheduledevent;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventBroadcast.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildScheduledEventBroadcast {
    private final boolean canBroadcast;
    private final Boolean hasBroadcast;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getCanBroadcast() {
        return this.canBroadcast;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Boolean getHasBroadcast() {
        return this.hasBroadcast;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventBroadcast)) {
            return false;
        }
        GuildScheduledEventBroadcast guildScheduledEventBroadcast = (GuildScheduledEventBroadcast) other;
        return this.canBroadcast == guildScheduledEventBroadcast.canBroadcast && C12238m.areEqual(this.hasBroadcast, guildScheduledEventBroadcast.hasBroadcast);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.canBroadcast;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Boolean bool = this.hasBroadcast;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventBroadcast(canBroadcast=");
        sbM833U.append(this.canBroadcast);
        sbM833U.append(", hasBroadcast=");
        return C1643a.m816D(sbM833U, this.hasBroadcast, ")");
    }
}
