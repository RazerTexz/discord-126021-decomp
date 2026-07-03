package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.enabled, trackPoggermodeSettingsUpdated.enabled) && C12238m.areEqual(this.combosEnabled, trackPoggermodeSettingsUpdated.combosEnabled) && C12238m.areEqual(this.combosRequiredCount, trackPoggermodeSettingsUpdated.combosRequiredCount) && C12238m.areEqual(this.screenshakeEnabled, trackPoggermodeSettingsUpdated.screenshakeEnabled) && C12238m.areEqual(this.shakeIntensity, trackPoggermodeSettingsUpdated.shakeIntensity) && C12238m.areEqual(this.screenshakeEnabledLocations, trackPoggermodeSettingsUpdated.screenshakeEnabledLocations) && C12238m.areEqual(this.confettiEnabled, trackPoggermodeSettingsUpdated.confettiEnabled) && C12238m.areEqual(this.confettiSize, trackPoggermodeSettingsUpdated.confettiSize) && C12238m.areEqual(this.confettiCount, trackPoggermodeSettingsUpdated.confettiCount) && C12238m.areEqual(this.confettiEnabledLocations, trackPoggermodeSettingsUpdated.confettiEnabledLocations);
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
        StringBuilder sbM833U = C1643a.m833U("TrackPoggermodeSettingsUpdated(enabled=");
        sbM833U.append(this.enabled);
        sbM833U.append(", combosEnabled=");
        sbM833U.append(this.combosEnabled);
        sbM833U.append(", combosRequiredCount=");
        sbM833U.append(this.combosRequiredCount);
        sbM833U.append(", screenshakeEnabled=");
        sbM833U.append(this.screenshakeEnabled);
        sbM833U.append(", shakeIntensity=");
        sbM833U.append(this.shakeIntensity);
        sbM833U.append(", screenshakeEnabledLocations=");
        sbM833U.append(this.screenshakeEnabledLocations);
        sbM833U.append(", confettiEnabled=");
        sbM833U.append(this.confettiEnabled);
        sbM833U.append(", confettiSize=");
        sbM833U.append(this.confettiSize);
        sbM833U.append(", confettiCount=");
        sbM833U.append(this.confettiCount);
        sbM833U.append(", confettiEnabledLocations=");
        return C1643a.m824L(sbM833U, this.confettiEnabledLocations, ")");
    }
}
