package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivitySessionLeft.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivitySessionLeft implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence activitySessionId = null;
    private final Long applicationId = null;
    private final Long durationMs = null;
    private final transient String analyticsSchemaTypeName = "activity_session_left";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivitySessionLeft)) {
            return false;
        }
        TrackActivitySessionLeft trackActivitySessionLeft = (TrackActivitySessionLeft) other;
        return Intrinsics3.areEqual(this.channelId, trackActivitySessionLeft.channelId) && Intrinsics3.areEqual(this.guildId, trackActivitySessionLeft.guildId) && Intrinsics3.areEqual(this.mediaSessionId, trackActivitySessionLeft.mediaSessionId) && Intrinsics3.areEqual(this.activitySessionId, trackActivitySessionLeft.activitySessionId) && Intrinsics3.areEqual(this.applicationId, trackActivitySessionLeft.applicationId) && Intrinsics3.areEqual(this.durationMs, trackActivitySessionLeft.durationMs);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.mediaSessionId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.activitySessionId;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.durationMs;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivitySessionLeft(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", activitySessionId=");
        sbU.append(this.activitySessionId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", durationMs=");
        return outline.G(sbU, this.durationMs, ")");
    }
}
