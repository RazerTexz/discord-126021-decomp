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

/* JADX INFO: compiled from: TrackStageInstanceStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageInstanceStarted implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long stageInstanceId = null;
    private final CharSequence topic = null;
    private final Long privacyLevel = null;
    private final Long numParticipants = null;
    private final Long updaterId = null;
    private final Long guildScheduledEventId = null;
    private final Long totalUniqueListeners = null;
    private final Long maxConcurrentListeners = null;
    private final Long totalUniqueSpeakers = null;
    private final Long maxConcurrentSpeakers = null;
    private final Boolean sendStartNotification = null;
    private final transient String analyticsSchemaTypeName = "stage_instance_started";

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
        if (!(other instanceof TrackStageInstanceStarted)) {
            return false;
        }
        TrackStageInstanceStarted trackStageInstanceStarted = (TrackStageInstanceStarted) other;
        return Intrinsics3.areEqual(this.stageInstanceId, trackStageInstanceStarted.stageInstanceId) && Intrinsics3.areEqual(this.topic, trackStageInstanceStarted.topic) && Intrinsics3.areEqual(this.privacyLevel, trackStageInstanceStarted.privacyLevel) && Intrinsics3.areEqual(this.numParticipants, trackStageInstanceStarted.numParticipants) && Intrinsics3.areEqual(this.updaterId, trackStageInstanceStarted.updaterId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackStageInstanceStarted.guildScheduledEventId) && Intrinsics3.areEqual(this.totalUniqueListeners, trackStageInstanceStarted.totalUniqueListeners) && Intrinsics3.areEqual(this.maxConcurrentListeners, trackStageInstanceStarted.maxConcurrentListeners) && Intrinsics3.areEqual(this.totalUniqueSpeakers, trackStageInstanceStarted.totalUniqueSpeakers) && Intrinsics3.areEqual(this.maxConcurrentSpeakers, trackStageInstanceStarted.maxConcurrentSpeakers) && Intrinsics3.areEqual(this.sendStartNotification, trackStageInstanceStarted.sendStartNotification);
    }

    public int hashCode() {
        Long l = this.stageInstanceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.topic;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.privacyLevel;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numParticipants;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.updaterId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildScheduledEventId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.totalUniqueListeners;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.maxConcurrentListeners;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.totalUniqueSpeakers;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.maxConcurrentSpeakers;
        int iHashCode10 = (iHashCode9 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool = this.sendStartNotification;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageInstanceStarted(stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", numParticipants=");
        sbU.append(this.numParticipants);
        sbU.append(", updaterId=");
        sbU.append(this.updaterId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", totalUniqueListeners=");
        sbU.append(this.totalUniqueListeners);
        sbU.append(", maxConcurrentListeners=");
        sbU.append(this.maxConcurrentListeners);
        sbU.append(", totalUniqueSpeakers=");
        sbU.append(this.totalUniqueSpeakers);
        sbU.append(", maxConcurrentSpeakers=");
        sbU.append(this.maxConcurrentSpeakers);
        sbU.append(", sendStartNotification=");
        return outline.D(sbU, this.sendStartNotification, ")");
    }
}
