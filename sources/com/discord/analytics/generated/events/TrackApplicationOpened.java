package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationOpened implements AnalyticsSchema, TrackBaseReceiver, TrackAfCardReceiver, TrackAfGameReceiver, TrackLocationMetadataReceiver {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence type = null;
    private final CharSequence source = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final CharSequence partyId = null;
    private final Long otherUserId = null;
    private final Long messageId = null;
    private final Long numLauncherApplications = null;
    private final CharSequence distributor = null;
    private final CharSequence listSort = null;
    private final Long listIndex = null;
    private final transient String analyticsSchemaTypeName = "application_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationOpened)) {
            return false;
        }
        TrackApplicationOpened trackApplicationOpened = (TrackApplicationOpened) other;
        return C12238m.areEqual(this.type, trackApplicationOpened.type) && C12238m.areEqual(this.source, trackApplicationOpened.source) && C12238m.areEqual(this.applicationId, trackApplicationOpened.applicationId) && C12238m.areEqual(this.applicationName, trackApplicationOpened.applicationName) && C12238m.areEqual(this.partyId, trackApplicationOpened.partyId) && C12238m.areEqual(this.otherUserId, trackApplicationOpened.otherUserId) && C12238m.areEqual(this.messageId, trackApplicationOpened.messageId) && C12238m.areEqual(this.numLauncherApplications, trackApplicationOpened.numLauncherApplications) && C12238m.areEqual(this.distributor, trackApplicationOpened.distributor) && C12238m.areEqual(this.listSort, trackApplicationOpened.listSort) && C12238m.areEqual(this.listIndex, trackApplicationOpened.listIndex);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.partyId;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l2 = this.otherUserId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numLauncherApplications;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.distributor;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.listSort;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l5 = this.listIndex;
        return iHashCode10 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationOpened(type=");
        sbM833U.append(this.type);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", partyId=");
        sbM833U.append(this.partyId);
        sbM833U.append(", otherUserId=");
        sbM833U.append(this.otherUserId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", numLauncherApplications=");
        sbM833U.append(this.numLauncherApplications);
        sbM833U.append(", distributor=");
        sbM833U.append(this.distributor);
        sbM833U.append(", listSort=");
        sbM833U.append(this.listSort);
        sbM833U.append(", listIndex=");
        return C1643a.m819G(sbM833U, this.listIndex, ")");
    }
}
