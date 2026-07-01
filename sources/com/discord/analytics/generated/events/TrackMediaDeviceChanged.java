package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackMediaDeviceChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMediaDeviceChanged implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence deviceFromName = null;
    private final CharSequence deviceToName = null;
    private final CharSequence deviceType = null;
    private final Boolean deviceIsCertified = null;
    private final transient String analyticsSchemaTypeName = "media_device_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMediaDeviceChanged)) {
            return false;
        }
        TrackMediaDeviceChanged trackMediaDeviceChanged = (TrackMediaDeviceChanged) other;
        return Intrinsics3.areEqual(this.deviceFromName, trackMediaDeviceChanged.deviceFromName) && Intrinsics3.areEqual(this.deviceToName, trackMediaDeviceChanged.deviceToName) && Intrinsics3.areEqual(this.deviceType, trackMediaDeviceChanged.deviceType) && Intrinsics3.areEqual(this.deviceIsCertified, trackMediaDeviceChanged.deviceIsCertified);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceFromName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deviceToName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.deviceType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.deviceIsCertified;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMediaDeviceChanged(deviceFromName=");
        sbU.append(this.deviceFromName);
        sbU.append(", deviceToName=");
        sbU.append(this.deviceToName);
        sbU.append(", deviceType=");
        sbU.append(this.deviceType);
        sbU.append(", deviceIsCertified=");
        return outline.D(sbU, this.deviceIsCertified, ")");
    }
}
