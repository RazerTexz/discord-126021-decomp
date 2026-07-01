package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.value, trackNotifyStreamSettingUpdate.value) && m.areEqual(this.prechecked, trackNotifyStreamSettingUpdate.prechecked);
    }

    public int hashCode() {
        Boolean bool = this.value;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.prechecked;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNotifyStreamSettingUpdate(value=");
        sbU.append(this.value);
        sbU.append(", prechecked=");
        return a.D(sbU, this.prechecked, ")");
    }
}
