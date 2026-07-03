package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.directoryChannelId, trackDirectoryEntry.directoryChannelId) && C12238m.areEqual(this.directoryGuildId, trackDirectoryEntry.directoryGuildId) && C12238m.areEqual(this.entityId, trackDirectoryEntry.entityId) && C12238m.areEqual(this.authorId, trackDirectoryEntry.authorId) && C12238m.areEqual(this.entityType, trackDirectoryEntry.entityType) && C12238m.areEqual(this.createdAt, trackDirectoryEntry.createdAt) && C12238m.areEqual(this.primaryCategoryId, trackDirectoryEntry.primaryCategoryId) && C12238m.areEqual(this.entryDescription, trackDirectoryEntry.entryDescription);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDirectoryEntry(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", directoryGuildId=");
        sbM833U.append(this.directoryGuildId);
        sbM833U.append(", entityId=");
        sbM833U.append(this.entityId);
        sbM833U.append(", authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", primaryCategoryId=");
        sbM833U.append(this.primaryCategoryId);
        sbM833U.append(", entryDescription=");
        return C1643a.m817E(sbM833U, this.entryDescription, ")");
    }
}
