package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDiscoveryReported.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryReported implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence reportType = null;
    private final CharSequence reportSubType = null;
    private final Long reasonEnum = null;
    private final Long reportId = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_reported";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryReported)) {
            return false;
        }
        TrackGuildDiscoveryReported trackGuildDiscoveryReported = (TrackGuildDiscoveryReported) other;
        return C12238m.areEqual(this.reportType, trackGuildDiscoveryReported.reportType) && C12238m.areEqual(this.reportSubType, trackGuildDiscoveryReported.reportSubType) && C12238m.areEqual(this.reasonEnum, trackGuildDiscoveryReported.reasonEnum) && C12238m.areEqual(this.reportId, trackGuildDiscoveryReported.reportId);
    }

    public int hashCode() {
        CharSequence charSequence = this.reportType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.reportSubType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.reasonEnum;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.reportId;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDiscoveryReported(reportType=");
        sbM833U.append(this.reportType);
        sbM833U.append(", reportSubType=");
        sbM833U.append(this.reportSubType);
        sbM833U.append(", reasonEnum=");
        sbM833U.append(this.reasonEnum);
        sbM833U.append(", reportId=");
        return C1643a.m819G(sbM833U, this.reportId, ")");
    }
}
