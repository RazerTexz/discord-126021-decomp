package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.applicationId, trackAnalyticsDataQueried.applicationId) && C12238m.areEqual(this.guildId, trackAnalyticsDataQueried.guildId) && C12238m.areEqual(this.tableName, trackAnalyticsDataQueried.tableName) && C12238m.areEqual(this.dateRangeStart, trackAnalyticsDataQueried.dateRangeStart) && C12238m.areEqual(this.dateRangeEnd, trackAnalyticsDataQueried.dateRangeEnd) && C12238m.areEqual(this.interval, trackAnalyticsDataQueried.interval) && C12238m.areEqual(this.responseIsSuccessful, trackAnalyticsDataQueried.responseIsSuccessful) && C12238m.areEqual(this.responseHasData, trackAnalyticsDataQueried.responseHasData);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAnalyticsDataQueried(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", tableName=");
        sbM833U.append(this.tableName);
        sbM833U.append(", dateRangeStart=");
        sbM833U.append(this.dateRangeStart);
        sbM833U.append(", dateRangeEnd=");
        sbM833U.append(this.dateRangeEnd);
        sbM833U.append(", interval=");
        sbM833U.append(this.interval);
        sbM833U.append(", responseIsSuccessful=");
        sbM833U.append(this.responseIsSuccessful);
        sbM833U.append(", responseHasData=");
        return C1643a.m816D(sbM833U, this.responseHasData, ")");
    }
}
