package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSoundshareFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundshareFailed implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.soundshareFailureCode, trackSoundshareFailed.soundshareFailureCode) && Intrinsics3.areEqual(this.soundshareFailureReason, trackSoundshareFailed.soundshareFailureReason) && Intrinsics3.areEqual(this.soundshareFailureWillRetry, trackSoundshareFailed.soundshareFailureWillRetry) && Intrinsics3.areEqual(this.soundshareSession, trackSoundshareFailed.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackSoundshareFailed.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackSoundshareFailed.shareGameId);
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
        StringBuilder sbU = outline.U("TrackSoundshareFailed(soundshareFailureCode=");
        sbU.append(this.soundshareFailureCode);
        sbU.append(", soundshareFailureReason=");
        sbU.append(this.soundshareFailureReason);
        sbU.append(", soundshareFailureWillRetry=");
        sbU.append(this.soundshareFailureWillRetry);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        return outline.G(sbU, this.shareGameId, ")");
    }
}
