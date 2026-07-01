package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEvent {
    private final Boolean isEveryoneRoleVisible = null;
    private final Boolean associatedToDirectoryChannel = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildScheduledEvent)) {
            return false;
        }
        TrackGuildScheduledEvent trackGuildScheduledEvent = (TrackGuildScheduledEvent) other;
        return m.areEqual(this.isEveryoneRoleVisible, trackGuildScheduledEvent.isEveryoneRoleVisible) && m.areEqual(this.associatedToDirectoryChannel, trackGuildScheduledEvent.associatedToDirectoryChannel);
    }

    public int hashCode() {
        Boolean bool = this.isEveryoneRoleVisible;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.associatedToDirectoryChannel;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildScheduledEvent(isEveryoneRoleVisible=");
        sbU.append(this.isEveryoneRoleVisible);
        sbU.append(", associatedToDirectoryChannel=");
        return a.D(sbU, this.associatedToDirectoryChannel, ")");
    }
}
