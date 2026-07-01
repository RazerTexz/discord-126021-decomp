package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUpdateUserSettingsLocal.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateUserSettingsLocal implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean alwaysPreviewVideo = null;
    private final Boolean showSnowsgiving2021 = null;
    private final transient String analyticsSchemaTypeName = "update_user_settings_local";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateUserSettingsLocal)) {
            return false;
        }
        TrackUpdateUserSettingsLocal trackUpdateUserSettingsLocal = (TrackUpdateUserSettingsLocal) other;
        return m.areEqual(this.alwaysPreviewVideo, trackUpdateUserSettingsLocal.alwaysPreviewVideo) && m.areEqual(this.showSnowsgiving2021, trackUpdateUserSettingsLocal.showSnowsgiving2021);
    }

    public int hashCode() {
        Boolean bool = this.alwaysPreviewVideo;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.showSnowsgiving2021;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackUpdateUserSettingsLocal(alwaysPreviewVideo=");
        sbU.append(this.alwaysPreviewVideo);
        sbU.append(", showSnowsgiving2021=");
        return a.D(sbU, this.showSnowsgiving2021, ")");
    }
}
