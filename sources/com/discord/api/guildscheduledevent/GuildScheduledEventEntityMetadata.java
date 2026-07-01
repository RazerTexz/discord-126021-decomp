package com.discord.api.guildscheduledevent;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: GuildScheduledEventEntityMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildScheduledEventEntityMetadata implements Serializable {
    public static final GuildScheduledEventEntityMetadata$Companion Companion = new GuildScheduledEventEntityMetadata$Companion(null);
    private final String location;

    public GuildScheduledEventEntityMetadata() {
        this.location = null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final boolean b() {
        return this.location == null;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventEntityMetadata) && m.areEqual(this.location, ((GuildScheduledEventEntityMetadata) other).location);
        }
        return true;
    }

    public int hashCode() {
        String str = this.location;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("GuildScheduledEventEntityMetadata(location="), this.location, ")");
    }

    public GuildScheduledEventEntityMetadata(String str) {
        this.location = str;
    }

    public GuildScheduledEventEntityMetadata(String str, int i) {
        int i2 = i & 1;
        this.location = null;
    }
}
