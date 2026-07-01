package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventLocationInfo$ExternalLocation extends GuildScheduledEventLocationInfo {
    private final String location;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventLocationInfo$ExternalLocation(String str) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        this.location = str;
    }

    public static /* synthetic */ GuildScheduledEventLocationInfo$ExternalLocation copy$default(GuildScheduledEventLocationInfo$ExternalLocation guildScheduledEventLocationInfo$ExternalLocation, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildScheduledEventLocationInfo$ExternalLocation.location;
        }
        return guildScheduledEventLocationInfo$ExternalLocation.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final GuildScheduledEventLocationInfo$ExternalLocation copy(String location) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return new GuildScheduledEventLocationInfo$ExternalLocation(location);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventLocationInfo$ExternalLocation) && m.areEqual(this.location, ((GuildScheduledEventLocationInfo$ExternalLocation) other).location);
        }
        return true;
    }

    public final String getLocation() {
        return this.location;
    }

    public int hashCode() {
        String str = this.location;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("ExternalLocation(location="), this.location, ")");
    }
}
