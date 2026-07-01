package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAnalyticsDataQueried.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAnalyticsDataQueried implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long guildId = null;
    private final CharSequence tableName = null;
    private final Long dateRangeStart = null;
    private final Long dateRangeEnd = null;
    private final Long interval = null;
    private final Boolean responseIsSuccessful = null;
    private final Boolean responseHasData = null;
    private final transient String analyticsSchemaTypeName = "analytics_data_queried";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAnalyticsDataQueried)) {
            return false;
        }
        TrackAnalyticsDataQueried trackAnalyticsDataQueried = (TrackAnalyticsDataQueried) other;
        return m.areEqual(this.applicationId, trackAnalyticsDataQueried.applicationId) && m.areEqual(this.guildId, trackAnalyticsDataQueried.guildId) && m.areEqual(this.tableName, trackAnalyticsDataQueried.tableName) && m.areEqual(this.dateRangeStart, trackAnalyticsDataQueried.dateRangeStart) && m.areEqual(this.dateRangeEnd, trackAnalyticsDataQueried.dateRangeEnd) && m.areEqual(this.interval, trackAnalyticsDataQueried.interval) && m.areEqual(this.responseIsSuccessful, trackAnalyticsDataQueried.responseIsSuccessful) && m.areEqual(this.responseHasData, trackAnalyticsDataQueried.responseHasData);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.tableName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.dateRangeStart;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.dateRangeEnd;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.interval;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.responseIsSuccessful;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.responseHasData;
        return iHashCode7 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAnalyticsDataQueried(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", tableName=");
        sbU.append(this.tableName);
        sbU.append(", dateRangeStart=");
        sbU.append(this.dateRangeStart);
        sbU.append(", dateRangeEnd=");
        sbU.append(this.dateRangeEnd);
        sbU.append(", interval=");
        sbU.append(this.interval);
        sbU.append(", responseIsSuccessful=");
        sbU.append(this.responseIsSuccessful);
        sbU.append(", responseHasData=");
        return a.D(sbU, this.responseHasData, ")");
    }
}
