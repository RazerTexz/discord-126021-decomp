package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackGuildScheduledEvent;
import com.discord.analytics.generated.traits.TrackGuildScheduledEventReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildScheduledEventCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventCreated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackGuildScheduledEventReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackGuildScheduledEvent trackGuildScheduledEvent;
    private final Long guildScheduledEventId = null;
    private final CharSequence name = null;
    private final Long startTime = null;
    private final Long endTime = null;
    private final List<Long> skuIds = null;
    private final Long guildScheduledEventStatus = null;
    private final Long privacyLevel = null;
    private final Long guildScheduledEventEntityType = null;
    private final CharSequence guildScheduledEventExternalLocation = null;
    private final Long guildScheduledEventInterestedCount = null;
    private final CharSequence description = null;
    private final Long updaterId = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_created";

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
        if (!(other instanceof TrackGuildScheduledEventCreated)) {
            return false;
        }
        TrackGuildScheduledEventCreated trackGuildScheduledEventCreated = (TrackGuildScheduledEventCreated) other;
        return C12238m.areEqual(this.guildScheduledEventId, trackGuildScheduledEventCreated.guildScheduledEventId) && C12238m.areEqual(this.name, trackGuildScheduledEventCreated.name) && C12238m.areEqual(this.startTime, trackGuildScheduledEventCreated.startTime) && C12238m.areEqual(this.endTime, trackGuildScheduledEventCreated.endTime) && C12238m.areEqual(this.skuIds, trackGuildScheduledEventCreated.skuIds) && C12238m.areEqual(this.guildScheduledEventStatus, trackGuildScheduledEventCreated.guildScheduledEventStatus) && C12238m.areEqual(this.privacyLevel, trackGuildScheduledEventCreated.privacyLevel) && C12238m.areEqual(this.guildScheduledEventEntityType, trackGuildScheduledEventCreated.guildScheduledEventEntityType) && C12238m.areEqual(this.guildScheduledEventExternalLocation, trackGuildScheduledEventCreated.guildScheduledEventExternalLocation) && C12238m.areEqual(this.guildScheduledEventInterestedCount, trackGuildScheduledEventCreated.guildScheduledEventInterestedCount) && C12238m.areEqual(this.description, trackGuildScheduledEventCreated.description) && C12238m.areEqual(this.updaterId, trackGuildScheduledEventCreated.updaterId);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.name;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.startTime;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.endTime;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.skuIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Long l4 = this.guildScheduledEventStatus;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.privacyLevel;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildScheduledEventEntityType;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildScheduledEventExternalLocation;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.guildScheduledEventInterestedCount;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.description;
        int iHashCode11 = (iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l8 = this.updaterId;
        return iHashCode11 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildScheduledEventCreated(guildScheduledEventId=");
        sbM833U.append(this.guildScheduledEventId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", startTime=");
        sbM833U.append(this.startTime);
        sbM833U.append(", endTime=");
        sbM833U.append(this.endTime);
        sbM833U.append(", skuIds=");
        sbM833U.append(this.skuIds);
        sbM833U.append(", guildScheduledEventStatus=");
        sbM833U.append(this.guildScheduledEventStatus);
        sbM833U.append(", privacyLevel=");
        sbM833U.append(this.privacyLevel);
        sbM833U.append(", guildScheduledEventEntityType=");
        sbM833U.append(this.guildScheduledEventEntityType);
        sbM833U.append(", guildScheduledEventExternalLocation=");
        sbM833U.append(this.guildScheduledEventExternalLocation);
        sbM833U.append(", guildScheduledEventInterestedCount=");
        sbM833U.append(this.guildScheduledEventInterestedCount);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", updaterId=");
        return C1643a.m819G(sbM833U, this.updaterId, ")");
    }
}
