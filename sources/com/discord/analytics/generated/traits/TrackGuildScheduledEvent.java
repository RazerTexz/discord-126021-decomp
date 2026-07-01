package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.isEveryoneRoleVisible, trackGuildScheduledEvent.isEveryoneRoleVisible) && Intrinsics3.areEqual(this.associatedToDirectoryChannel, trackGuildScheduledEvent.associatedToDirectoryChannel);
    }

    public int hashCode() {
        Boolean bool = this.isEveryoneRoleVisible;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.associatedToDirectoryChannel;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildScheduledEvent(isEveryoneRoleVisible=");
        sbU.append(this.isEveryoneRoleVisible);
        sbU.append(", associatedToDirectoryChannel=");
        return outline.D(sbU, this.associatedToDirectoryChannel, ")");
    }
}
