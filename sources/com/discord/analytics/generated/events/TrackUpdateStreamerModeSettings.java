package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUpdateStreamerModeSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateStreamerModeSettings implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean automatic = null;
    private final Boolean disableNotifications = null;
    private final Boolean disableSounds = null;
    private final Boolean enabled = null;
    private final Boolean hideInstantInvites = null;
    private final Boolean hidePersonalInfo = null;
    private final transient String analyticsSchemaTypeName = "update_streamer_mode_settings";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateStreamerModeSettings)) {
            return false;
        }
        TrackUpdateStreamerModeSettings trackUpdateStreamerModeSettings = (TrackUpdateStreamerModeSettings) other;
        return C12238m.areEqual(this.automatic, trackUpdateStreamerModeSettings.automatic) && C12238m.areEqual(this.disableNotifications, trackUpdateStreamerModeSettings.disableNotifications) && C12238m.areEqual(this.disableSounds, trackUpdateStreamerModeSettings.disableSounds) && C12238m.areEqual(this.enabled, trackUpdateStreamerModeSettings.enabled) && C12238m.areEqual(this.hideInstantInvites, trackUpdateStreamerModeSettings.hideInstantInvites) && C12238m.areEqual(this.hidePersonalInfo, trackUpdateStreamerModeSettings.hidePersonalInfo);
    }

    public int hashCode() {
        Boolean bool = this.automatic;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.disableNotifications;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.disableSounds;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hideInstantInvites;
        int iHashCode5 = (iHashCode4 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hidePersonalInfo;
        return iHashCode5 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUpdateStreamerModeSettings(automatic=");
        sbM833U.append(this.automatic);
        sbM833U.append(", disableNotifications=");
        sbM833U.append(this.disableNotifications);
        sbM833U.append(", disableSounds=");
        sbM833U.append(this.disableSounds);
        sbM833U.append(", enabled=");
        sbM833U.append(this.enabled);
        sbM833U.append(", hideInstantInvites=");
        sbM833U.append(this.hideInstantInvites);
        sbM833U.append(", hidePersonalInfo=");
        return C1643a.m816D(sbM833U, this.hidePersonalInfo, ")");
    }
}
