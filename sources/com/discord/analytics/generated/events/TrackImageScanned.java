package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackImageScanned.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImageScanned implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence scanUuid = null;
    private final CharSequence provider = null;
    private final CharSequence safeSearchAdultLikelihood = null;
    private final CharSequence safeSearchMedicalLikelihood = null;
    private final CharSequence safeSearchRacyLikelihood = null;
    private final CharSequence safeSearchSpoofLikelihood = null;
    private final CharSequence safeSearchViolenceLikelihood = null;
    private final Float openNsfwSfw = null;
    private final Float openNsfwNsfw = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "image_scanned";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackImageScanned)) {
            return false;
        }
        TrackImageScanned trackImageScanned = (TrackImageScanned) other;
        return m.areEqual(this.scanUuid, trackImageScanned.scanUuid) && m.areEqual(this.provider, trackImageScanned.provider) && m.areEqual(this.safeSearchAdultLikelihood, trackImageScanned.safeSearchAdultLikelihood) && m.areEqual(this.safeSearchMedicalLikelihood, trackImageScanned.safeSearchMedicalLikelihood) && m.areEqual(this.safeSearchRacyLikelihood, trackImageScanned.safeSearchRacyLikelihood) && m.areEqual(this.safeSearchSpoofLikelihood, trackImageScanned.safeSearchSpoofLikelihood) && m.areEqual(this.safeSearchViolenceLikelihood, trackImageScanned.safeSearchViolenceLikelihood) && m.areEqual(this.openNsfwSfw, trackImageScanned.openNsfwSfw) && m.areEqual(this.openNsfwNsfw, trackImageScanned.openNsfwNsfw) && m.areEqual(this.guildId, trackImageScanned.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.scanUuid;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.provider;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.safeSearchAdultLikelihood;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.safeSearchMedicalLikelihood;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.safeSearchRacyLikelihood;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.safeSearchSpoofLikelihood;
        int iHashCode6 = (iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.safeSearchViolenceLikelihood;
        int iHashCode7 = (iHashCode6 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Float f = this.openNsfwSfw;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.openNsfwNsfw;
        int iHashCode9 = (iHashCode8 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        return iHashCode9 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackImageScanned(scanUuid=");
        sbU.append(this.scanUuid);
        sbU.append(", provider=");
        sbU.append(this.provider);
        sbU.append(", safeSearchAdultLikelihood=");
        sbU.append(this.safeSearchAdultLikelihood);
        sbU.append(", safeSearchMedicalLikelihood=");
        sbU.append(this.safeSearchMedicalLikelihood);
        sbU.append(", safeSearchRacyLikelihood=");
        sbU.append(this.safeSearchRacyLikelihood);
        sbU.append(", safeSearchSpoofLikelihood=");
        sbU.append(this.safeSearchSpoofLikelihood);
        sbU.append(", safeSearchViolenceLikelihood=");
        sbU.append(this.safeSearchViolenceLikelihood);
        sbU.append(", openNsfwSfw=");
        sbU.append(this.openNsfwSfw);
        sbU.append(", openNsfwNsfw=");
        sbU.append(this.openNsfwNsfw);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }
}
