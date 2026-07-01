package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDirectoryEntry.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDirectoryEntry {
    private final Long directoryChannelId = null;
    private final Long directoryGuildId = null;
    private final Long entityId = null;
    private final Long authorId = null;
    private final Long entityType = null;
    private final Long createdAt = null;
    private final Long primaryCategoryId = null;
    private final CharSequence entryDescription = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDirectoryEntry)) {
            return false;
        }
        TrackDirectoryEntry trackDirectoryEntry = (TrackDirectoryEntry) other;
        return m.areEqual(this.directoryChannelId, trackDirectoryEntry.directoryChannelId) && m.areEqual(this.directoryGuildId, trackDirectoryEntry.directoryGuildId) && m.areEqual(this.entityId, trackDirectoryEntry.entityId) && m.areEqual(this.authorId, trackDirectoryEntry.authorId) && m.areEqual(this.entityType, trackDirectoryEntry.entityType) && m.areEqual(this.createdAt, trackDirectoryEntry.createdAt) && m.areEqual(this.primaryCategoryId, trackDirectoryEntry.primaryCategoryId) && m.areEqual(this.entryDescription, trackDirectoryEntry.entryDescription);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.directoryGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.entityId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.authorId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.entityType;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.createdAt;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.primaryCategoryId;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence = this.entryDescription;
        return iHashCode7 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDirectoryEntry(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", directoryGuildId=");
        sbU.append(this.directoryGuildId);
        sbU.append(", entityId=");
        sbU.append(this.entityId);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
        sbU.append(", entityType=");
        sbU.append(this.entityType);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", entryDescription=");
        return a.E(sbU, this.entryDescription, ")");
    }
}
