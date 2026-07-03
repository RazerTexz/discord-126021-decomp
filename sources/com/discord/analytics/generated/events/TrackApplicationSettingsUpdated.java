package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.hiddenEnabled, trackApplicationSettingsUpdated.hiddenEnabled) && C12238m.areEqual(this.overlayDisabled, trackApplicationSettingsUpdated.overlayDisabled) && C12238m.areEqual(this.privateEnabled, trackApplicationSettingsUpdated.privateEnabled) && C12238m.areEqual(this.applicationId, trackApplicationSettingsUpdated.applicationId) && C12238m.areEqual(this.applicationName, trackApplicationSettingsUpdated.applicationName) && C12238m.areEqual(this.skuId, trackApplicationSettingsUpdated.skuId) && C12238m.areEqual(this.launcherPlatform, trackApplicationSettingsUpdated.launcherPlatform);
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
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationSettingsUpdated(hiddenEnabled=");
        sbM833U.append(this.hiddenEnabled);
        sbM833U.append(", overlayDisabled=");
        sbM833U.append(this.overlayDisabled);
        sbM833U.append(", privateEnabled=");
        sbM833U.append(this.privateEnabled);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", launcherPlatform=");
        return C1643a.m817E(sbM833U, this.launcherPlatform, ")");
    }
}
