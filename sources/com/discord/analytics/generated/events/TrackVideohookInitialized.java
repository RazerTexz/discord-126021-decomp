package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVideohookInitialized.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideohookInitialized implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.backend, trackVideohookInitialized.backend) && C12238m.areEqual(this.format, trackVideohookInitialized.format) && C12238m.areEqual(this.framebufferFormat, trackVideohookInitialized.framebufferFormat) && C12238m.areEqual(this.sampleCount, trackVideohookInitialized.sampleCount) && C12238m.areEqual(this.success, trackVideohookInitialized.success) && C12238m.areEqual(this.reinitialization, trackVideohookInitialized.reinitialization) && C12238m.areEqual(this.soundshareSession, trackVideohookInitialized.soundshareSession) && C12238m.areEqual(this.shareGameName, trackVideohookInitialized.shareGameName) && C12238m.areEqual(this.shareGameId, trackVideohookInitialized.shareGameId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVideohookInitialized(backend=");
        sbM833U.append(this.backend);
        sbM833U.append(", format=");
        sbM833U.append(this.format);
        sbM833U.append(", framebufferFormat=");
        sbM833U.append(this.framebufferFormat);
        sbM833U.append(", sampleCount=");
        sbM833U.append(this.sampleCount);
        sbM833U.append(", success=");
        sbM833U.append(this.success);
        sbM833U.append(", reinitialization=");
        sbM833U.append(this.reinitialization);
        sbM833U.append(", soundshareSession=");
        sbM833U.append(this.soundshareSession);
        sbM833U.append(", shareGameName=");
        sbM833U.append(this.shareGameName);
        sbM833U.append(", shareGameId=");
        return C1643a.m819G(sbM833U, this.shareGameId, ")");
    }
}
