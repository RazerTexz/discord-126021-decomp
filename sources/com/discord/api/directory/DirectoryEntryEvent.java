package com.discord.api.directory;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: DirectoryEntryGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DirectoryEntryEvent {
    private final long authorId;
    private final UtcDateTime createdAt;
    private final String description;
    private final long directoryChannelId;
    private final long entityId;
    private final GuildScheduledEvent guildScheduledEvent;
    private final int primaryCategoryId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryEvent)) {
            return false;
        }
        DirectoryEntryEvent directoryEntryEvent = (DirectoryEntryEvent) other;
        return this.directoryChannelId == directoryEntryEvent.directoryChannelId && this.entityId == directoryEntryEvent.entityId && this.authorId == directoryEntryEvent.authorId && m.areEqual(this.description, directoryEntryEvent.description) && this.primaryCategoryId == directoryEntryEvent.primaryCategoryId && m.areEqual(this.createdAt, directoryEntryEvent.createdAt) && m.areEqual(this.guildScheduledEvent, directoryEntryEvent.guildScheduledEvent);
    }

    public int hashCode() {
        long j = this.directoryChannelId;
        long j2 = this.entityId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.authorId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.description;
        int iHashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.primaryCategoryId) * 31;
        UtcDateTime utcDateTime = this.createdAt;
        int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryEntryEvent(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", entityId=");
        sbU.append(this.entityId);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
