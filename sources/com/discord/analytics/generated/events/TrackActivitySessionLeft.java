package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackActivitySessionLeft.channelId) && C12238m.areEqual(this.guildId, trackActivitySessionLeft.guildId) && C12238m.areEqual(this.mediaSessionId, trackActivitySessionLeft.mediaSessionId) && C12238m.areEqual(this.activitySessionId, trackActivitySessionLeft.activitySessionId) && C12238m.areEqual(this.applicationId, trackActivitySessionLeft.applicationId) && C12238m.areEqual(this.durationMs, trackActivitySessionLeft.durationMs);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivitySessionLeft(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", activitySessionId=");
        sbM833U.append(this.activitySessionId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", durationMs=");
        return C1643a.m819G(sbM833U, this.durationMs, ")");
    }
}
