package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalActionWatchTogether.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionWatchTogether implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final Boolean isHost = null;
    private final CharSequence remoteType = null;
    private final CharSequence hostType = null;
    private final CharSequence searchType = null;
    private final CharSequence via = null;
    private final Long orderCurrent = null;
    private final Long orderSelected = null;
    private final CharSequence trackingId = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_watch_together";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionWatchTogether)) {
            return false;
        }
        TrackActivityInternalActionWatchTogether trackActivityInternalActionWatchTogether = (TrackActivityInternalActionWatchTogether) other;
        return m.areEqual(this.actionName, trackActivityInternalActionWatchTogether.actionName) && m.areEqual(this.isHost, trackActivityInternalActionWatchTogether.isHost) && m.areEqual(this.remoteType, trackActivityInternalActionWatchTogether.remoteType) && m.areEqual(this.hostType, trackActivityInternalActionWatchTogether.hostType) && m.areEqual(this.searchType, trackActivityInternalActionWatchTogether.searchType) && m.areEqual(this.via, trackActivityInternalActionWatchTogether.via) && m.areEqual(this.orderCurrent, trackActivityInternalActionWatchTogether.orderCurrent) && m.areEqual(this.orderSelected, trackActivityInternalActionWatchTogether.orderSelected) && m.areEqual(this.trackingId, trackActivityInternalActionWatchTogether.trackingId);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isHost;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.remoteType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.hostType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.searchType;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.via;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.orderCurrent;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.orderSelected;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.trackingId;
        return iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalActionWatchTogether(actionName=");
        sbU.append(this.actionName);
        sbU.append(", isHost=");
        sbU.append(this.isHost);
        sbU.append(", remoteType=");
        sbU.append(this.remoteType);
        sbU.append(", hostType=");
        sbU.append(this.hostType);
        sbU.append(", searchType=");
        sbU.append(this.searchType);
        sbU.append(", via=");
        sbU.append(this.via);
        sbU.append(", orderCurrent=");
        sbU.append(this.orderCurrent);
        sbU.append(", orderSelected=");
        sbU.append(this.orderSelected);
        sbU.append(", trackingId=");
        return a.E(sbU, this.trackingId, ")");
    }
}
