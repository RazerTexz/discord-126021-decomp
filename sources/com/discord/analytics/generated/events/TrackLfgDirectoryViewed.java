package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLfgDirectoryViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgDirectoryViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final Long numGroupsTotal = null;
    private final Long numGroupsOpen = null;
    private final Long numGroupsFull = null;
    private final transient String analyticsSchemaTypeName = "lfg_directory_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgDirectoryViewed)) {
            return false;
        }
        TrackLfgDirectoryViewed trackLfgDirectoryViewed = (TrackLfgDirectoryViewed) other;
        return m.areEqual(this.channelId, trackLfgDirectoryViewed.channelId) && m.areEqual(this.guildId, trackLfgDirectoryViewed.guildId) && m.areEqual(this.numGroupsTotal, trackLfgDirectoryViewed.numGroupsTotal) && m.areEqual(this.numGroupsOpen, trackLfgDirectoryViewed.numGroupsOpen) && m.areEqual(this.numGroupsFull, trackLfgDirectoryViewed.numGroupsFull);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numGroupsTotal;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numGroupsOpen;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numGroupsFull;
        return iHashCode4 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLfgDirectoryViewed(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", numGroupsTotal=");
        sbU.append(this.numGroupsTotal);
        sbU.append(", numGroupsOpen=");
        sbU.append(this.numGroupsOpen);
        sbU.append(", numGroupsFull=");
        return a.G(sbU, this.numGroupsFull, ")");
    }
}
