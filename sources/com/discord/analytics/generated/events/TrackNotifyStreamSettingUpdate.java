package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNotifyStreamSettingUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotifyStreamSettingUpdate implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean value = null;
    private final Boolean prechecked = null;
    private final transient String analyticsSchemaTypeName = "notify_stream_setting_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotifyStreamSettingUpdate)) {
            return false;
        }
        TrackNotifyStreamSettingUpdate trackNotifyStreamSettingUpdate = (TrackNotifyStreamSettingUpdate) other;
        return C12238m.areEqual(this.value, trackNotifyStreamSettingUpdate.value) && C12238m.areEqual(this.prechecked, trackNotifyStreamSettingUpdate.prechecked);
    }

    public int hashCode() {
        Boolean bool = this.value;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.prechecked;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNotifyStreamSettingUpdate(value=");
        sbM833U.append(this.value);
        sbM833U.append(", prechecked=");
        return C1643a.m816D(sbM833U, this.prechecked, ")");
    }
}
