package com.discord.api.guildscheduledevent;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventEntityMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventEntityMetadata$Companion {
    public GuildScheduledEventEntityMetadata$Companion() {
    }

    public final GuildScheduledEventEntityMetadata a(GuildScheduledEventEntityType entityType, String location) {
        m.checkNotNullParameter(entityType, "entityType");
        return entityType.ordinal() != 3 ? new GuildScheduledEventEntityMetadata(null, 1) : new GuildScheduledEventEntityMetadata(location);
    }

    public GuildScheduledEventEntityMetadata$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
