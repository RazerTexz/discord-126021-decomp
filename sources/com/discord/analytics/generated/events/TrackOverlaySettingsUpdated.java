package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOverlaySettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlaySettingsUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean enabled = null;
    private final Boolean notificationsEnabled = null;
    private final CharSequence notificationsPosition = null;
    private final CharSequence textNotificationsMode = null;
    private final CharSequence hotkey = null;
    private final CharSequence textActivationHotkey = null;
    private final Long textOpacitySlider = null;
    private final transient String analyticsSchemaTypeName = "overlay_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlaySettingsUpdated)) {
            return false;
        }
        TrackOverlaySettingsUpdated trackOverlaySettingsUpdated = (TrackOverlaySettingsUpdated) other;
        return m.areEqual(this.enabled, trackOverlaySettingsUpdated.enabled) && m.areEqual(this.notificationsEnabled, trackOverlaySettingsUpdated.notificationsEnabled) && m.areEqual(this.notificationsPosition, trackOverlaySettingsUpdated.notificationsPosition) && m.areEqual(this.textNotificationsMode, trackOverlaySettingsUpdated.textNotificationsMode) && m.areEqual(this.hotkey, trackOverlaySettingsUpdated.hotkey) && m.areEqual(this.textActivationHotkey, trackOverlaySettingsUpdated.textActivationHotkey) && m.areEqual(this.textOpacitySlider, trackOverlaySettingsUpdated.textOpacitySlider);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.notificationsEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.notificationsPosition;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.textNotificationsMode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.hotkey;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.textActivationHotkey;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.textOpacitySlider;
        return iHashCode6 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackOverlaySettingsUpdated(enabled=");
        sbU.append(this.enabled);
        sbU.append(", notificationsEnabled=");
        sbU.append(this.notificationsEnabled);
        sbU.append(", notificationsPosition=");
        sbU.append(this.notificationsPosition);
        sbU.append(", textNotificationsMode=");
        sbU.append(this.textNotificationsMode);
        sbU.append(", hotkey=");
        sbU.append(this.hotkey);
        sbU.append(", textActivationHotkey=");
        sbU.append(this.textActivationHotkey);
        sbU.append(", textOpacitySlider=");
        return a.G(sbU, this.textOpacitySlider, ")");
    }
}
