package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackLfgDirectoryViewed.channelId) && C12238m.areEqual(this.guildId, trackLfgDirectoryViewed.guildId) && C12238m.areEqual(this.numGroupsTotal, trackLfgDirectoryViewed.numGroupsTotal) && C12238m.areEqual(this.numGroupsOpen, trackLfgDirectoryViewed.numGroupsOpen) && C12238m.areEqual(this.numGroupsFull, trackLfgDirectoryViewed.numGroupsFull);
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
        StringBuilder sbM833U = C1643a.m833U("TrackLfgDirectoryViewed(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", numGroupsTotal=");
        sbM833U.append(this.numGroupsTotal);
        sbM833U.append(", numGroupsOpen=");
        sbM833U.append(this.numGroupsOpen);
        sbM833U.append(", numGroupsFull=");
        return C1643a.m819G(sbM833U, this.numGroupsFull, ")");
    }
}
