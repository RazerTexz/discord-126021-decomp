package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.applicationId, trackActivityUpdated.applicationId) && C12238m.areEqual(this.hasMatchSecret, trackActivityUpdated.hasMatchSecret) && C12238m.areEqual(this.hasSpectateSecret, trackActivityUpdated.hasSpectateSecret) && C12238m.areEqual(this.hasJoinSecret, trackActivityUpdated.hasJoinSecret) && C12238m.areEqual(this.hasImages, trackActivityUpdated.hasImages) && C12238m.areEqual(this.partyMax, trackActivityUpdated.partyMax) && C12238m.areEqual(this.partyId, trackActivityUpdated.partyId) && C12238m.areEqual(this.platform, trackActivityUpdated.platform) && C12238m.areEqual(this.partyPlatform, trackActivityUpdated.partyPlatform) && C12238m.areEqual(this.trackId, trackActivityUpdated.trackId) && C12238m.areEqual(this.type, trackActivityUpdated.type) && C12238m.areEqual(this.activitySessionId, trackActivityUpdated.activitySessionId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityUpdated(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", hasMatchSecret=");
        sbM833U.append(this.hasMatchSecret);
        sbM833U.append(", hasSpectateSecret=");
        sbM833U.append(this.hasSpectateSecret);
        sbM833U.append(", hasJoinSecret=");
        sbM833U.append(this.hasJoinSecret);
        sbM833U.append(", hasImages=");
        sbM833U.append(this.hasImages);
        sbM833U.append(", partyMax=");
        sbM833U.append(this.partyMax);
        sbM833U.append(", partyId=");
        sbM833U.append(this.partyId);
        sbM833U.append(", platform=");
        sbM833U.append(this.platform);
        sbM833U.append(", partyPlatform=");
        sbM833U.append(this.partyPlatform);
        sbM833U.append(", trackId=");
        sbM833U.append(this.trackId);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", activitySessionId=");
        return C1643a.m817E(sbM833U, this.activitySessionId, ")");
    }
}
