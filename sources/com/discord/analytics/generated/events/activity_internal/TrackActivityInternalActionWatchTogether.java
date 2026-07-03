package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.actionName, trackActivityInternalActionWatchTogether.actionName) && C12238m.areEqual(this.isHost, trackActivityInternalActionWatchTogether.isHost) && C12238m.areEqual(this.remoteType, trackActivityInternalActionWatchTogether.remoteType) && C12238m.areEqual(this.hostType, trackActivityInternalActionWatchTogether.hostType) && C12238m.areEqual(this.searchType, trackActivityInternalActionWatchTogether.searchType) && C12238m.areEqual(this.via, trackActivityInternalActionWatchTogether.via) && C12238m.areEqual(this.orderCurrent, trackActivityInternalActionWatchTogether.orderCurrent) && C12238m.areEqual(this.orderSelected, trackActivityInternalActionWatchTogether.orderSelected) && C12238m.areEqual(this.trackingId, trackActivityInternalActionWatchTogether.trackingId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalActionWatchTogether(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", isHost=");
        sbM833U.append(this.isHost);
        sbM833U.append(", remoteType=");
        sbM833U.append(this.remoteType);
        sbM833U.append(", hostType=");
        sbM833U.append(this.hostType);
        sbM833U.append(", searchType=");
        sbM833U.append(this.searchType);
        sbM833U.append(", via=");
        sbM833U.append(this.via);
        sbM833U.append(", orderCurrent=");
        sbM833U.append(this.orderCurrent);
        sbM833U.append(", orderSelected=");
        sbM833U.append(this.orderSelected);
        sbM833U.append(", trackingId=");
        return C1643a.m817E(sbM833U, this.trackingId, ")");
    }
}
