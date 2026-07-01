package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivitySessionLeft.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivitySessionLeft implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.channelId, trackActivitySessionLeft.channelId) && m.areEqual(this.guildId, trackActivitySessionLeft.guildId) && m.areEqual(this.mediaSessionId, trackActivitySessionLeft.mediaSessionId) && m.areEqual(this.activitySessionId, trackActivitySessionLeft.activitySessionId) && m.areEqual(this.applicationId, trackActivitySessionLeft.applicationId) && m.areEqual(this.durationMs, trackActivitySessionLeft.durationMs);
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
        StringBuilder sbU = a.U("TrackActivitySessionLeft(channelId=");
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
        return a.G(sbU, this.durationMs, ")");
    }
}
