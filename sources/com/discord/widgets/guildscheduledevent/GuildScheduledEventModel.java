package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventModel implements Serializable {
    private final Boolean broadcastToDirectoryChannels;
    private final Long channelId;
    private final Long creatorId;
    private final String description;
    private final GuildScheduledEventPickerDateTime2 endDate;
    private final GuildScheduledEventPickerDateTime3 endTime;
    private final GuildScheduledEventEntityMetadata entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final long guildId;
    private final String name;
    private final GuildScheduledEventPickerDateTime2 startDate;
    private final GuildScheduledEventPickerDateTime3 startTime;
    private final Integer userCount;

    public GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime4, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime5, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventPickerDateTime2, "startDate");
        Intrinsics3.checkNotNullParameter(guildScheduledEventPickerDateTime3, "startTime");
        Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        this.guildId = j;
        this.name = str;
        this.channelId = l;
        this.creatorId = l2;
        this.startDate = guildScheduledEventPickerDateTime2;
        this.startTime = guildScheduledEventPickerDateTime3;
        this.endDate = guildScheduledEventPickerDateTime4;
        this.endTime = guildScheduledEventPickerDateTime5;
        this.description = str2;
        this.entityType = guildScheduledEventEntityType;
        this.entityMetadata = guildScheduledEventEntityMetadata;
        this.userCount = num;
        this.broadcastToDirectoryChannels = bool;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getUserCount() {
        return this.userCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getCreatorId() {
        return this.creatorId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildScheduledEventPickerDateTime2 getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GuildScheduledEventPickerDateTime3 getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildScheduledEventPickerDateTime2 getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GuildScheduledEventPickerDateTime3 getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventModel copy(long guildId, String name, Long channelId, Long creatorId, GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime, GuildScheduledEventPickerDateTime2 endDate, GuildScheduledEventPickerDateTime3 endTime, String description, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Integer userCount, Boolean broadcastToDirectoryChannels) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        Intrinsics3.checkNotNullParameter(entityType, "entityType");
        return new GuildScheduledEventModel(guildId, name, channelId, creatorId, startDate, startTime, endDate, endTime, description, entityType, entityMetadata, userCount, broadcastToDirectoryChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventModel)) {
            return false;
        }
        GuildScheduledEventModel guildScheduledEventModel = (GuildScheduledEventModel) other;
        return this.guildId == guildScheduledEventModel.guildId && Intrinsics3.areEqual(this.name, guildScheduledEventModel.name) && Intrinsics3.areEqual(this.channelId, guildScheduledEventModel.channelId) && Intrinsics3.areEqual(this.creatorId, guildScheduledEventModel.creatorId) && Intrinsics3.areEqual(this.startDate, guildScheduledEventModel.startDate) && Intrinsics3.areEqual(this.startTime, guildScheduledEventModel.startTime) && Intrinsics3.areEqual(this.endDate, guildScheduledEventModel.endDate) && Intrinsics3.areEqual(this.endTime, guildScheduledEventModel.endTime) && Intrinsics3.areEqual(this.description, guildScheduledEventModel.description) && Intrinsics3.areEqual(this.entityType, guildScheduledEventModel.entityType) && Intrinsics3.areEqual(this.entityMetadata, guildScheduledEventModel.entityMetadata) && Intrinsics3.areEqual(this.userCount, guildScheduledEventModel.userCount) && Intrinsics3.areEqual(this.broadcastToDirectoryChannels, guildScheduledEventModel.broadcastToDirectoryChannels);
    }

    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventPickerDateTime2 getEndDate() {
        return this.endDate;
    }

    public final GuildScheduledEventPickerDateTime3 getEndTime() {
        return this.endTime;
    }

    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getName() {
        return this.name;
    }

    public final GuildScheduledEventPickerDateTime2 getStartDate() {
        return this.startDate;
    }

    public final GuildScheduledEventPickerDateTime3 getStartTime() {
        return this.startTime;
    }

    public final Integer getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.name;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.channelId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.creatorId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.startDate;
        int iHashCode4 = (iHashCode3 + (guildScheduledEventPickerDateTime2 != null ? guildScheduledEventPickerDateTime2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3 = this.startTime;
        int iHashCode5 = (iHashCode4 + (guildScheduledEventPickerDateTime3 != null ? guildScheduledEventPickerDateTime3.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime4 = this.endDate;
        int iHashCode6 = (iHashCode5 + (guildScheduledEventPickerDateTime4 != null ? guildScheduledEventPickerDateTime4.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime5 = this.endTime;
        int iHashCode7 = (iHashCode6 + (guildScheduledEventPickerDateTime5 != null ? guildScheduledEventPickerDateTime5.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode8 = (iHashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
        int iHashCode9 = (iHashCode8 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        int iHashCode10 = (iHashCode9 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
        Integer num = this.userCount;
        int iHashCode11 = (iHashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.broadcastToDirectoryChannels;
        return iHashCode11 + (bool != null ? bool.hashCode() : 0);
    }

    public final RestAPIParams.CreateGuildScheduledEventBody toCreateRequestBody() {
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3;
        String str = this.name;
        String utcDateString = null;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        String utcDateString2 = guildScheduledEventPickerDateTime.toUtcDateString(this.startDate, this.startTime);
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.endDate;
        if (guildScheduledEventPickerDateTime2 != null && (guildScheduledEventPickerDateTime3 = this.endTime) != null) {
            utcDateString = guildScheduledEventPickerDateTime.toUtcDateString(guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3);
        }
        return new RestAPIParams.CreateGuildScheduledEventBody(str, this.description, StageInstancePrivacyLevel.GUILD_ONLY, utcDateString2, utcDateString, this.channelId, this.entityType, this.entityMetadata, this.broadcastToDirectoryChannels);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventModel(guildId=");
        sbU.append(this.guildId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", creatorId=");
        sbU.append(this.creatorId);
        sbU.append(", startDate=");
        sbU.append(this.startDate);
        sbU.append(", startTime=");
        sbU.append(this.startTime);
        sbU.append(", endDate=");
        sbU.append(this.endDate);
        sbU.append(", endTime=");
        sbU.append(this.endTime);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", entityType=");
        sbU.append(this.entityType);
        sbU.append(", entityMetadata=");
        sbU.append(this.entityMetadata);
        sbU.append(", userCount=");
        sbU.append(this.userCount);
        sbU.append(", broadcastToDirectoryChannels=");
        return outline.D(sbU, this.broadcastToDirectoryChannels, ")");
    }

    public final RestAPIParams.UpdateGuildScheduledEventBody toUpdateRequestBody(GuildScheduledEvent currentEvent) {
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3;
        Intrinsics3.checkNotNullParameter(currentEvent, "currentEvent");
        String str = this.name;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        long millis = guildScheduledEventPickerDateTime.toMillis(this.startDate, this.startTime);
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.endDate;
        Long lValueOf = (guildScheduledEventPickerDateTime2 == null || (guildScheduledEventPickerDateTime3 = this.endTime) == null) ? null : Long.valueOf(guildScheduledEventPickerDateTime.toMillis(guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3));
        Long l = this.channelId;
        NullSerializable bVar = l != null ? new NullSerializable.b(l) : new NullSerializable.a(null, 1);
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        NullSerializable aVar = (guildScheduledEventEntityMetadata == null || guildScheduledEventEntityMetadata.b()) ? new NullSerializable.a(null, 1) : new NullSerializable.b(this.entityMetadata);
        String str2 = this.description;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = StageInstancePrivacyLevel.GUILD_ONLY;
        String uTCDateTime$default = currentEvent.getScheduledStartTime().getDateTimeMillis() == millis ? null : TimeUtils.toUTCDateTime$default(Long.valueOf(millis), null, 2, null);
        UtcDateTime scheduledEndTime = currentEvent.getScheduledEndTime();
        return new RestAPIParams.UpdateGuildScheduledEventBody(str, str2, stageInstancePrivacyLevel, uTCDateTime$default, Intrinsics3.areEqual(scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, lValueOf) ? null : TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null), bVar, this.entityType, aVar, null, this.broadcastToDirectoryChannels, 256, null);
    }

    public /* synthetic */ GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime4, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime5, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, l, l2, guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3, guildScheduledEventPickerDateTime4, guildScheduledEventPickerDateTime5, str2, guildScheduledEventEntityType, guildScheduledEventEntityMetadata, num, (i & 4096) != 0 ? null : bool);
    }
}
