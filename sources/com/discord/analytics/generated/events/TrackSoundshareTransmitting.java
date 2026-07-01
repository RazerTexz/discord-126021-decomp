package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSoundshareTransmitting.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundshareTransmitting implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final transient String analyticsSchemaTypeName = "soundshare_transmitting";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundshareTransmitting)) {
            return false;
        }
        TrackSoundshareTransmitting trackSoundshareTransmitting = (TrackSoundshareTransmitting) other;
        return Intrinsics3.areEqual(this.soundshareSession, trackSoundshareTransmitting.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackSoundshareTransmitting.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackSoundshareTransmitting.shareGameId);
    }

    public int hashCode() {
        CharSequence charSequence = this.soundshareSession;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.shareGameName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.shareGameId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSoundshareTransmitting(soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        return outline.G(sbU, this.shareGameId, ")");
    }
}
