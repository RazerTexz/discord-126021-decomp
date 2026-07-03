package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSoundshareAttached.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundshareAttached implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final transient String analyticsSchemaTypeName = "soundshare_attached";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundshareAttached)) {
            return false;
        }
        TrackSoundshareAttached trackSoundshareAttached = (TrackSoundshareAttached) other;
        return C12238m.areEqual(this.soundshareSession, trackSoundshareAttached.soundshareSession) && C12238m.areEqual(this.shareGameName, trackSoundshareAttached.shareGameName) && C12238m.areEqual(this.shareGameId, trackSoundshareAttached.shareGameId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSoundshareAttached(soundshareSession=");
        sbM833U.append(this.soundshareSession);
        sbM833U.append(", shareGameName=");
        sbM833U.append(this.shareGameName);
        sbM833U.append(", shareGameId=");
        return C1643a.m819G(sbM833U, this.shareGameId, ")");
    }
}
