package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackPoggermodeSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPoggermodeSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final Boolean combosEnabled = null;
    private final Long combosRequiredCount = null;
    private final Boolean screenshakeEnabled = null;
    private final Long shakeIntensity = null;
    private final List<CharSequence> screenshakeEnabledLocations = null;
    private final Boolean confettiEnabled = null;
    private final Long confettiSize = null;
    private final Long confettiCount = null;
    private final List<CharSequence> confettiEnabledLocations = null;
    private final transient String analyticsSchemaTypeName = "poggermode_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPoggermodeSettingsUpdated)) {
            return false;
        }
        TrackPoggermodeSettingsUpdated trackPoggermodeSettingsUpdated = (TrackPoggermodeSettingsUpdated) other;
        return m.areEqual(this.enabled, trackPoggermodeSettingsUpdated.enabled) && m.areEqual(this.combosEnabled, trackPoggermodeSettingsUpdated.combosEnabled) && m.areEqual(this.combosRequiredCount, trackPoggermodeSettingsUpdated.combosRequiredCount) && m.areEqual(this.screenshakeEnabled, trackPoggermodeSettingsUpdated.screenshakeEnabled) && m.areEqual(this.shakeIntensity, trackPoggermodeSettingsUpdated.shakeIntensity) && m.areEqual(this.screenshakeEnabledLocations, trackPoggermodeSettingsUpdated.screenshakeEnabledLocations) && m.areEqual(this.confettiEnabled, trackPoggermodeSettingsUpdated.confettiEnabled) && m.areEqual(this.confettiSize, trackPoggermodeSettingsUpdated.confettiSize) && m.areEqual(this.confettiCount, trackPoggermodeSettingsUpdated.confettiCount) && m.areEqual(this.confettiEnabledLocations, trackPoggermodeSettingsUpdated.confettiEnabledLocations);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.combosEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.combosRequiredCount;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool3 = this.screenshakeEnabled;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.shakeIntensity;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<CharSequence> list = this.screenshakeEnabledLocations;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool4 = this.confettiEnabled;
        int iHashCode7 = (iHashCode6 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l3 = this.confettiSize;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.confettiCount;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.confettiEnabledLocations;
        return iHashCode9 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPoggermodeSettingsUpdated(enabled=");
        sbU.append(this.enabled);
        sbU.append(", combosEnabled=");
        sbU.append(this.combosEnabled);
        sbU.append(", combosRequiredCount=");
        sbU.append(this.combosRequiredCount);
        sbU.append(", screenshakeEnabled=");
        sbU.append(this.screenshakeEnabled);
        sbU.append(", shakeIntensity=");
        sbU.append(this.shakeIntensity);
        sbU.append(", screenshakeEnabledLocations=");
        sbU.append(this.screenshakeEnabledLocations);
        sbU.append(", confettiEnabled=");
        sbU.append(this.confettiEnabled);
        sbU.append(", confettiSize=");
        sbU.append(this.confettiSize);
        sbU.append(", confettiCount=");
        sbU.append(this.confettiCount);
        sbU.append(", confettiEnabledLocations=");
        return a.L(sbU, this.confettiEnabledLocations, ")");
    }
}
