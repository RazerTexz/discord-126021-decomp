package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationSettingsUpdated implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Boolean hiddenEnabled = null;
    private final Boolean overlayDisabled = null;
    private final Boolean privateEnabled = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final Long skuId = null;
    private final CharSequence launcherPlatform = null;
    private final transient String analyticsSchemaTypeName = "application_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationSettingsUpdated)) {
            return false;
        }
        TrackApplicationSettingsUpdated trackApplicationSettingsUpdated = (TrackApplicationSettingsUpdated) other;
        return Intrinsics3.areEqual(this.hiddenEnabled, trackApplicationSettingsUpdated.hiddenEnabled) && Intrinsics3.areEqual(this.overlayDisabled, trackApplicationSettingsUpdated.overlayDisabled) && Intrinsics3.areEqual(this.privateEnabled, trackApplicationSettingsUpdated.privateEnabled) && Intrinsics3.areEqual(this.applicationId, trackApplicationSettingsUpdated.applicationId) && Intrinsics3.areEqual(this.applicationName, trackApplicationSettingsUpdated.applicationName) && Intrinsics3.areEqual(this.skuId, trackApplicationSettingsUpdated.skuId) && Intrinsics3.areEqual(this.launcherPlatform, trackApplicationSettingsUpdated.launcherPlatform);
    }

    public int hashCode() {
        Boolean bool = this.hiddenEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.overlayDisabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.privateEnabled;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode5 = (iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.skuId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.launcherPlatform;
        return iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationSettingsUpdated(hiddenEnabled=");
        sbU.append(this.hiddenEnabled);
        sbU.append(", overlayDisabled=");
        sbU.append(this.overlayDisabled);
        sbU.append(", privateEnabled=");
        sbU.append(this.privateEnabled);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", launcherPlatform=");
        return outline.E(sbU, this.launcherPlatform, ")");
    }
}
