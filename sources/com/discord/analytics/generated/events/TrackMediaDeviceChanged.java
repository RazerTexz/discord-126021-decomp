package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMediaDeviceChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMediaDeviceChanged implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.deviceFromName, trackMediaDeviceChanged.deviceFromName) && C12238m.areEqual(this.deviceToName, trackMediaDeviceChanged.deviceToName) && C12238m.areEqual(this.deviceType, trackMediaDeviceChanged.deviceType) && C12238m.areEqual(this.deviceIsCertified, trackMediaDeviceChanged.deviceIsCertified);
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
        StringBuilder sbM833U = C1643a.m833U("TrackMediaDeviceChanged(deviceFromName=");
        sbM833U.append(this.deviceFromName);
        sbM833U.append(", deviceToName=");
        sbM833U.append(this.deviceToName);
        sbM833U.append(", deviceType=");
        sbM833U.append(this.deviceType);
        sbM833U.append(", deviceIsCertified=");
        return C1643a.m816D(sbM833U, this.deviceIsCertified, ")");
    }
}
