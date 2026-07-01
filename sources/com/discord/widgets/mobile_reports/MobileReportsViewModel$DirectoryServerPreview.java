package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$DirectoryServerPreview {
    private final DirectoryEntryGuild directoryEntry;
    private final Guild hub;

    public MobileReportsViewModel$DirectoryServerPreview(Guild guild, DirectoryEntryGuild directoryEntryGuild) {
        m.checkNotNullParameter(guild, "hub");
        m.checkNotNullParameter(directoryEntryGuild, "directoryEntry");
        this.hub = guild;
        this.directoryEntry = directoryEntryGuild;
    }

    public static /* synthetic */ MobileReportsViewModel$DirectoryServerPreview copy$default(MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview, Guild guild, DirectoryEntryGuild directoryEntryGuild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = mobileReportsViewModel$DirectoryServerPreview.hub;
        }
        if ((i & 2) != 0) {
            directoryEntryGuild = mobileReportsViewModel$DirectoryServerPreview.directoryEntry;
        }
        return mobileReportsViewModel$DirectoryServerPreview.copy(guild, directoryEntryGuild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getHub() {
        return this.hub;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DirectoryEntryGuild getDirectoryEntry() {
        return this.directoryEntry;
    }

    public final MobileReportsViewModel$DirectoryServerPreview copy(Guild hub, DirectoryEntryGuild directoryEntry) {
        m.checkNotNullParameter(hub, "hub");
        m.checkNotNullParameter(directoryEntry, "directoryEntry");
        return new MobileReportsViewModel$DirectoryServerPreview(hub, directoryEntry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$DirectoryServerPreview)) {
            return false;
        }
        MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview = (MobileReportsViewModel$DirectoryServerPreview) other;
        return m.areEqual(this.hub, mobileReportsViewModel$DirectoryServerPreview.hub) && m.areEqual(this.directoryEntry, mobileReportsViewModel$DirectoryServerPreview.directoryEntry);
    }

    public final DirectoryEntryGuild getDirectoryEntry() {
        return this.directoryEntry;
    }

    public final Guild getHub() {
        return this.hub;
    }

    public int hashCode() {
        Guild guild = this.hub;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        DirectoryEntryGuild directoryEntryGuild = this.directoryEntry;
        return iHashCode + (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryServerPreview(hub=");
        sbU.append(this.hub);
        sbU.append(", directoryEntry=");
        sbU.append(this.directoryEntry);
        sbU.append(")");
        return sbU.toString();
    }
}
