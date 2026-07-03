package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.enabled, trackOverlaySettingsUpdated.enabled) && C12238m.areEqual(this.notificationsEnabled, trackOverlaySettingsUpdated.notificationsEnabled) && C12238m.areEqual(this.notificationsPosition, trackOverlaySettingsUpdated.notificationsPosition) && C12238m.areEqual(this.textNotificationsMode, trackOverlaySettingsUpdated.textNotificationsMode) && C12238m.areEqual(this.hotkey, trackOverlaySettingsUpdated.hotkey) && C12238m.areEqual(this.textActivationHotkey, trackOverlaySettingsUpdated.textActivationHotkey) && C12238m.areEqual(this.textOpacitySlider, trackOverlaySettingsUpdated.textOpacitySlider);
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
        StringBuilder sbM833U = C1643a.m833U("TrackOverlaySettingsUpdated(enabled=");
        sbM833U.append(this.enabled);
        sbM833U.append(", notificationsEnabled=");
        sbM833U.append(this.notificationsEnabled);
        sbM833U.append(", notificationsPosition=");
        sbM833U.append(this.notificationsPosition);
        sbM833U.append(", textNotificationsMode=");
        sbM833U.append(this.textNotificationsMode);
        sbM833U.append(", hotkey=");
        sbM833U.append(this.hotkey);
        sbM833U.append(", textActivationHotkey=");
        sbM833U.append(this.textActivationHotkey);
        sbM833U.append(", textOpacitySlider=");
        return C1643a.m819G(sbM833U, this.textOpacitySlider, ")");
    }
}
