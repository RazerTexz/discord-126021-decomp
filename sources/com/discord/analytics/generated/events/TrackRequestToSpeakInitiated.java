package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRequestToSpeakInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRequestToSpeakInitiated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence topic = null;
    private final Long requestToSpeakState = null;
    private final CharSequence mediaSessionId = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "request_to_speak_initiated";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackRequestToSpeakInitiated)) {
            return false;
        }
        TrackRequestToSpeakInitiated trackRequestToSpeakInitiated = (TrackRequestToSpeakInitiated) other;
        return C12238m.areEqual(this.topic, trackRequestToSpeakInitiated.topic) && C12238m.areEqual(this.requestToSpeakState, trackRequestToSpeakInitiated.requestToSpeakState) && C12238m.areEqual(this.mediaSessionId, trackRequestToSpeakInitiated.mediaSessionId) && C12238m.areEqual(this.stageInstanceId, trackRequestToSpeakInitiated.stageInstanceId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRequestToSpeakInitiated(topic=");
        sbM833U.append(this.topic);
        sbM833U.append(", requestToSpeakState=");
        sbM833U.append(this.requestToSpeakState);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", stageInstanceId=");
        return C1643a.m819G(sbM833U, this.stageInstanceId, ")");
    }
}
