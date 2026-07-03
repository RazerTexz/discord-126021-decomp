package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSoundshareFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundshareFailed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long soundshareFailureCode = null;
    private final CharSequence soundshareFailureReason = null;
    private final Boolean soundshareFailureWillRetry = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final transient String analyticsSchemaTypeName = "soundshare_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundshareFailed)) {
            return false;
        }
        TrackSoundshareFailed trackSoundshareFailed = (TrackSoundshareFailed) other;
        return C12238m.areEqual(this.soundshareFailureCode, trackSoundshareFailed.soundshareFailureCode) && C12238m.areEqual(this.soundshareFailureReason, trackSoundshareFailed.soundshareFailureReason) && C12238m.areEqual(this.soundshareFailureWillRetry, trackSoundshareFailed.soundshareFailureWillRetry) && C12238m.areEqual(this.soundshareSession, trackSoundshareFailed.soundshareSession) && C12238m.areEqual(this.shareGameName, trackSoundshareFailed.shareGameName) && C12238m.areEqual(this.shareGameId, trackSoundshareFailed.shareGameId);
    }

    public int hashCode() {
        Long l = this.soundshareFailureCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.soundshareFailureReason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.soundshareFailureWillRetry;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.soundshareSession;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.shareGameName;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.shareGameId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSoundshareFailed(soundshareFailureCode=");
        sbM833U.append(this.soundshareFailureCode);
        sbM833U.append(", soundshareFailureReason=");
        sbM833U.append(this.soundshareFailureReason);
        sbM833U.append(", soundshareFailureWillRetry=");
        sbM833U.append(this.soundshareFailureWillRetry);
        sbM833U.append(", soundshareSession=");
        sbM833U.append(this.soundshareSession);
        sbM833U.append(", shareGameName=");
        sbM833U.append(this.shareGameName);
        sbM833U.append(", shareGameId=");
        return C1643a.m819G(sbM833U, this.shareGameId, ")");
    }
}
