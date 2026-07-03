package com.discord.api.thread;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ThreadMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadMetadata {
    private final String archiveTimestamp;
    private final boolean archived;
    private final int autoArchiveDuration;
    private final boolean locked;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getArchiveTimestamp() {
        return this.archiveTimestamp;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getArchived() {
        return this.archived;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMetadata)) {
            return false;
        }
        ThreadMetadata threadMetadata = (ThreadMetadata) other;
        return this.archived == threadMetadata.archived && C12238m.areEqual(this.archiveTimestamp, threadMetadata.archiveTimestamp) && this.autoArchiveDuration == threadMetadata.autoArchiveDuration && this.locked == threadMetadata.locked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.archived;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.archiveTimestamp;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.autoArchiveDuration) * 31;
        boolean z3 = this.locked;
        return iHashCode + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThreadMetadata(archived=");
        sbM833U.append(this.archived);
        sbM833U.append(", archiveTimestamp=");
        sbM833U.append(this.archiveTimestamp);
        sbM833U.append(", autoArchiveDuration=");
        sbM833U.append(this.autoArchiveDuration);
        sbM833U.append(", locked=");
        return C1643a.m827O(sbM833U, this.locked, ")");
    }
}
