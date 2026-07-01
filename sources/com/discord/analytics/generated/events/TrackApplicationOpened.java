package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.type, trackApplicationOpened.type) && m.areEqual(this.source, trackApplicationOpened.source) && m.areEqual(this.applicationId, trackApplicationOpened.applicationId) && m.areEqual(this.applicationName, trackApplicationOpened.applicationName) && m.areEqual(this.partyId, trackApplicationOpened.partyId) && m.areEqual(this.otherUserId, trackApplicationOpened.otherUserId) && m.areEqual(this.messageId, trackApplicationOpened.messageId) && m.areEqual(this.numLauncherApplications, trackApplicationOpened.numLauncherApplications) && m.areEqual(this.distributor, trackApplicationOpened.distributor) && m.areEqual(this.listSort, trackApplicationOpened.listSort) && m.areEqual(this.listIndex, trackApplicationOpened.listIndex);
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
        StringBuilder sbU = a.U("TrackApplicationOpened(type=");
        sbU.append(this.type);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", numLauncherApplications=");
        sbU.append(this.numLauncherApplications);
        sbU.append(", distributor=");
        sbU.append(this.distributor);
        sbU.append(", listSort=");
        sbU.append(this.listSort);
        sbU.append(", listIndex=");
        return a.G(sbU, this.listIndex, ")");
    }
}
