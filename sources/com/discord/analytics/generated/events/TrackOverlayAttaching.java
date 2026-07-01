package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayAttaching.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayAttaching implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence directxVersion = null;
    private final CharSequence gameName = null;
    private final CharSequence gpuInfo = null;
    private final CharSequence osName = null;
    private final CharSequence overlaySession = null;
    private final CharSequence module = null;
    private final transient String analyticsSchemaTypeName = "overlay_attaching";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayAttaching)) {
            return false;
        }
        TrackOverlayAttaching trackOverlayAttaching = (TrackOverlayAttaching) other;
        return Intrinsics3.areEqual(this.directxVersion, trackOverlayAttaching.directxVersion) && Intrinsics3.areEqual(this.gameName, trackOverlayAttaching.gameName) && Intrinsics3.areEqual(this.gpuInfo, trackOverlayAttaching.gpuInfo) && Intrinsics3.areEqual(this.osName, trackOverlayAttaching.osName) && Intrinsics3.areEqual(this.overlaySession, trackOverlayAttaching.overlaySession) && Intrinsics3.areEqual(this.module, trackOverlayAttaching.module);
    }

    public int hashCode() {
        CharSequence charSequence = this.directxVersion;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gpuInfo;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.osName;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.overlaySession;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.module;
        return iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayAttaching(directxVersion=");
        sbU.append(this.directxVersion);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gpuInfo=");
        sbU.append(this.gpuInfo);
        sbU.append(", osName=");
        sbU.append(this.osName);
        sbU.append(", overlaySession=");
        sbU.append(this.overlaySession);
        sbU.append(", module=");
        return outline.E(sbU, this.module, ")");
    }
}
