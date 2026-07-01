package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVideohookInitialized.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideohookInitialized implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long backend = null;
    private final Long format = null;
    private final Long framebufferFormat = null;
    private final Long sampleCount = null;
    private final Boolean success = null;
    private final Boolean reinitialization = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final transient String analyticsSchemaTypeName = "videohook_initialized";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideohookInitialized)) {
            return false;
        }
        TrackVideohookInitialized trackVideohookInitialized = (TrackVideohookInitialized) other;
        return Intrinsics3.areEqual(this.backend, trackVideohookInitialized.backend) && Intrinsics3.areEqual(this.format, trackVideohookInitialized.format) && Intrinsics3.areEqual(this.framebufferFormat, trackVideohookInitialized.framebufferFormat) && Intrinsics3.areEqual(this.sampleCount, trackVideohookInitialized.sampleCount) && Intrinsics3.areEqual(this.success, trackVideohookInitialized.success) && Intrinsics3.areEqual(this.reinitialization, trackVideohookInitialized.reinitialization) && Intrinsics3.areEqual(this.soundshareSession, trackVideohookInitialized.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackVideohookInitialized.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackVideohookInitialized.shareGameId);
    }

    public int hashCode() {
        Long l = this.backend;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.format;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.framebufferFormat;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.sampleCount;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.success;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.reinitialization;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.soundshareSession;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.shareGameName;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l5 = this.shareGameId;
        return iHashCode8 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideohookInitialized(backend=");
        sbU.append(this.backend);
        sbU.append(", format=");
        sbU.append(this.format);
        sbU.append(", framebufferFormat=");
        sbU.append(this.framebufferFormat);
        sbU.append(", sampleCount=");
        sbU.append(this.sampleCount);
        sbU.append(", success=");
        sbU.append(this.success);
        sbU.append(", reinitialization=");
        sbU.append(this.reinitialization);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        return outline.G(sbU, this.shareGameId, ")");
    }
}
