package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Boolean hasMatchSecret = null;
    private final Boolean hasSpectateSecret = null;
    private final Boolean hasJoinSecret = null;
    private final Boolean hasImages = null;
    private final Long partyMax = null;
    private final CharSequence partyId = null;
    private final CharSequence platform = null;
    private final CharSequence partyPlatform = null;
    private final CharSequence trackId = null;
    private final Long type = null;
    private final CharSequence activitySessionId = null;
    private final transient String analyticsSchemaTypeName = "activity_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityUpdated)) {
            return false;
        }
        TrackActivityUpdated trackActivityUpdated = (TrackActivityUpdated) other;
        return m.areEqual(this.applicationId, trackActivityUpdated.applicationId) && m.areEqual(this.hasMatchSecret, trackActivityUpdated.hasMatchSecret) && m.areEqual(this.hasSpectateSecret, trackActivityUpdated.hasSpectateSecret) && m.areEqual(this.hasJoinSecret, trackActivityUpdated.hasJoinSecret) && m.areEqual(this.hasImages, trackActivityUpdated.hasImages) && m.areEqual(this.partyMax, trackActivityUpdated.partyMax) && m.areEqual(this.partyId, trackActivityUpdated.partyId) && m.areEqual(this.platform, trackActivityUpdated.platform) && m.areEqual(this.partyPlatform, trackActivityUpdated.partyPlatform) && m.areEqual(this.trackId, trackActivityUpdated.trackId) && m.areEqual(this.type, trackActivityUpdated.type) && m.areEqual(this.activitySessionId, trackActivityUpdated.activitySessionId);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.hasMatchSecret;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasSpectateSecret;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasJoinSecret;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasImages;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l2 = this.partyMax;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.partyId;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.platform;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.partyPlatform;
        int iHashCode9 = (iHashCode8 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.trackId;
        int iHashCode10 = (iHashCode9 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.type;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.activitySessionId;
        return iHashCode11 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityUpdated(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", hasMatchSecret=");
        sbU.append(this.hasMatchSecret);
        sbU.append(", hasSpectateSecret=");
        sbU.append(this.hasSpectateSecret);
        sbU.append(", hasJoinSecret=");
        sbU.append(this.hasJoinSecret);
        sbU.append(", hasImages=");
        sbU.append(this.hasImages);
        sbU.append(", partyMax=");
        sbU.append(this.partyMax);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", platform=");
        sbU.append(this.platform);
        sbU.append(", partyPlatform=");
        sbU.append(this.partyPlatform);
        sbU.append(", trackId=");
        sbU.append(this.trackId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", activitySessionId=");
        return a.E(sbU, this.activitySessionId, ")");
    }
}
