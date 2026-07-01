package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventExternalLocationParser$Cache {
    private final String location;
    private final CharSequence output;

    public GuildScheduledEventExternalLocationParser$Cache(String str, CharSequence charSequence) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(charSequence, "output");
        this.location = str;
        this.output = charSequence;
    }

    public static /* synthetic */ GuildScheduledEventExternalLocationParser$Cache copy$default(GuildScheduledEventExternalLocationParser$Cache guildScheduledEventExternalLocationParser$Cache, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildScheduledEventExternalLocationParser$Cache.location;
        }
        if ((i & 2) != 0) {
            charSequence = guildScheduledEventExternalLocationParser$Cache.output;
        }
        return guildScheduledEventExternalLocationParser$Cache.copy(str, charSequence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getOutput() {
        return this.output;
    }

    public final GuildScheduledEventExternalLocationParser$Cache copy(String location, CharSequence output) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(output, "output");
        return new GuildScheduledEventExternalLocationParser$Cache(location, output);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventExternalLocationParser$Cache)) {
            return false;
        }
        GuildScheduledEventExternalLocationParser$Cache guildScheduledEventExternalLocationParser$Cache = (GuildScheduledEventExternalLocationParser$Cache) other;
        return m.areEqual(this.location, guildScheduledEventExternalLocationParser$Cache.location) && m.areEqual(this.output, guildScheduledEventExternalLocationParser$Cache.output);
    }

    public final String getLocation() {
        return this.location;
    }

    public final CharSequence getOutput() {
        return this.output;
    }

    public int hashCode() {
        String str = this.location;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        CharSequence charSequence = this.output;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Cache(location=");
        sbU.append(this.location);
        sbU.append(", output=");
        return a.E(sbU, this.output, ")");
    }
}
