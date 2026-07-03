package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOverlayToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayToggled implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final CharSequence settingType = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "overlay_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayToggled)) {
            return false;
        }
        TrackOverlayToggled trackOverlayToggled = (TrackOverlayToggled) other;
        return C12238m.areEqual(this.enabled, trackOverlayToggled.enabled) && C12238m.areEqual(this.settingType, trackOverlayToggled.settingType) && C12238m.areEqual(this.applicationId, trackOverlayToggled.applicationId) && C12238m.areEqual(this.applicationName, trackOverlayToggled.applicationName);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.settingType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.applicationName;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackOverlayToggled(enabled=");
        sbM833U.append(this.enabled);
        sbM833U.append(", settingType=");
        sbM833U.append(this.settingType);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        return C1643a.m817E(sbM833U, this.applicationName, ")");
    }
}
