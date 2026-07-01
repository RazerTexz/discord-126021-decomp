package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSoundshareEnable.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundshareEnable implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long statusCode = null;
    private final CharSequence message = null;
    private final transient String analyticsSchemaTypeName = "soundshare_enable";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundshareEnable)) {
            return false;
        }
        TrackSoundshareEnable trackSoundshareEnable = (TrackSoundshareEnable) other;
        return Intrinsics3.areEqual(this.statusCode, trackSoundshareEnable.statusCode) && Intrinsics3.areEqual(this.message, trackSoundshareEnable.message);
    }

    public int hashCode() {
        Long l = this.statusCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.message;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSoundshareEnable(statusCode=");
        sbU.append(this.statusCode);
        sbU.append(", message=");
        return outline.E(sbU, this.message, ")");
    }
}
