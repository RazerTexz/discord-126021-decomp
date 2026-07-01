package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPromotedToSpeaker.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPromotedToSpeaker implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence topic = null;
    private final Long requestToSpeakState = null;
    private final CharSequence mediaSessionId = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "promoted_to_speaker";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPromotedToSpeaker)) {
            return false;
        }
        TrackPromotedToSpeaker trackPromotedToSpeaker = (TrackPromotedToSpeaker) other;
        return Intrinsics3.areEqual(this.topic, trackPromotedToSpeaker.topic) && Intrinsics3.areEqual(this.requestToSpeakState, trackPromotedToSpeaker.requestToSpeakState) && Intrinsics3.areEqual(this.mediaSessionId, trackPromotedToSpeaker.mediaSessionId) && Intrinsics3.areEqual(this.stageInstanceId, trackPromotedToSpeaker.stageInstanceId);
    }

    public int hashCode() {
        CharSequence charSequence = this.topic;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.requestToSpeakState;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.stageInstanceId;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPromotedToSpeaker(topic=");
        sbU.append(this.topic);
        sbU.append(", requestToSpeakState=");
        sbU.append(this.requestToSpeakState);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", stageInstanceId=");
        return outline.G(sbU, this.stageInstanceId, ")");
    }
}
