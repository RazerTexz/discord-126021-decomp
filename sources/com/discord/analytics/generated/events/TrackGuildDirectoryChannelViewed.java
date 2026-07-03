package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDirectoryChannelViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDirectoryChannelViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long directoryChannelId = null;
    private final Long directoryGuildId = null;
    private final Long primaryCategoryId = null;
    private final transient String analyticsSchemaTypeName = "guild_directory_channel_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDirectoryChannelViewed)) {
            return false;
        }
        TrackGuildDirectoryChannelViewed trackGuildDirectoryChannelViewed = (TrackGuildDirectoryChannelViewed) other;
        return C12238m.areEqual(this.directoryChannelId, trackGuildDirectoryChannelViewed.directoryChannelId) && C12238m.areEqual(this.directoryGuildId, trackGuildDirectoryChannelViewed.directoryGuildId) && C12238m.areEqual(this.primaryCategoryId, trackGuildDirectoryChannelViewed.primaryCategoryId);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.directoryGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.primaryCategoryId;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDirectoryChannelViewed(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", directoryGuildId=");
        sbM833U.append(this.directoryGuildId);
        sbM833U.append(", primaryCategoryId=");
        return C1643a.m819G(sbM833U, this.primaryCategoryId, ")");
    }
}
