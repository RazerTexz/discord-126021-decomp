package com.discord.widgets.directories;

import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryGuild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoryEntryData {
    private final DirectoryEntryGuild entry;
    private final boolean hasEditPermissions;
    private final boolean hasJoinedGuild;

    public DirectoryEntryData(DirectoryEntryGuild directoryEntryGuild, boolean z2, boolean z3) {
        m.checkNotNullParameter(directoryEntryGuild, "entry");
        this.entry = directoryEntryGuild;
        this.hasJoinedGuild = z2;
        this.hasEditPermissions = z3;
    }

    public static /* synthetic */ DirectoryEntryData copy$default(DirectoryEntryData directoryEntryData, DirectoryEntryGuild directoryEntryGuild, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryGuild = directoryEntryData.entry;
        }
        if ((i & 2) != 0) {
            z2 = directoryEntryData.hasJoinedGuild;
        }
        if ((i & 4) != 0) {
            z3 = directoryEntryData.hasEditPermissions;
        }
        return directoryEntryData.copy(directoryEntryGuild, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DirectoryEntryGuild getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasJoinedGuild() {
        return this.hasJoinedGuild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasEditPermissions() {
        return this.hasEditPermissions;
    }

    public final DirectoryEntryData copy(DirectoryEntryGuild entry, boolean hasJoinedGuild, boolean hasEditPermissions) {
        m.checkNotNullParameter(entry, "entry");
        return new DirectoryEntryData(entry, hasJoinedGuild, hasEditPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryData)) {
            return false;
        }
        DirectoryEntryData directoryEntryData = (DirectoryEntryData) other;
        return m.areEqual(this.entry, directoryEntryData.entry) && this.hasJoinedGuild == directoryEntryData.hasJoinedGuild && this.hasEditPermissions == directoryEntryData.hasEditPermissions;
    }

    public final DirectoryEntryGuild getEntry() {
        return this.entry;
    }

    public final boolean getHasEditPermissions() {
        return this.hasEditPermissions;
    }

    public final boolean getHasJoinedGuild() {
        return this.hasJoinedGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        DirectoryEntryGuild directoryEntryGuild = this.entry;
        int iHashCode = (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0) * 31;
        boolean z2 = this.hasJoinedGuild;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.hasEditPermissions;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryEntryData(entry=");
        sbU.append(this.entry);
        sbU.append(", hasJoinedGuild=");
        sbU.append(this.hasJoinedGuild);
        sbU.append(", hasEditPermissions=");
        return a.O(sbU, this.hasEditPermissions, ")");
    }
}
