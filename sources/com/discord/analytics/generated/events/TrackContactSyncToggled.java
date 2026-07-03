package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackContactSyncToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackContactSyncToggled implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean isEnabled = null;
    private final Boolean amDiscoverableEmail = null;
    private final Boolean amDiscoverablePhone = null;
    private final transient String analyticsSchemaTypeName = "contact_sync_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackContactSyncToggled)) {
            return false;
        }
        TrackContactSyncToggled trackContactSyncToggled = (TrackContactSyncToggled) other;
        return C12238m.areEqual(this.isEnabled, trackContactSyncToggled.isEnabled) && C12238m.areEqual(this.amDiscoverableEmail, trackContactSyncToggled.amDiscoverableEmail) && C12238m.areEqual(this.amDiscoverablePhone, trackContactSyncToggled.amDiscoverablePhone);
    }

    public int hashCode() {
        Boolean bool = this.isEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.amDiscoverableEmail;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.amDiscoverablePhone;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackContactSyncToggled(isEnabled=");
        sbM833U.append(this.isEnabled);
        sbM833U.append(", amDiscoverableEmail=");
        sbM833U.append(this.amDiscoverableEmail);
        sbM833U.append(", amDiscoverablePhone=");
        return C1643a.m816D(sbM833U, this.amDiscoverablePhone, ")");
    }
}
