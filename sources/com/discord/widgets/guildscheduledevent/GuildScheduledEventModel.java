package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.restapi.RestAPIParams$CreateGuildScheduledEventBody;
import com.discord.restapi.RestAPIParams$UpdateGuildScheduledEventBody;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventModel implements Serializable {
    private final Boolean broadcastToDirectoryChannels;
    private final Long channelId;
    private final Long creatorId;
    private final String description;
    private final GuildScheduledEventPickerDate endDate;
    private final GuildScheduledEventPickerTime endTime;
    private final GuildScheduledEventEntityMetadata entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final long guildId;
    private final String name;
    private final GuildScheduledEventPickerDate startDate;
    private final GuildScheduledEventPickerTime startTime;
    private final Integer userCount;

    public GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDate guildScheduledEventPickerDate, GuildScheduledEventPickerTime guildScheduledEventPickerTime, GuildScheduledEventPickerDate guildScheduledEventPickerDate2, GuildScheduledEventPickerTime guildScheduledEventPickerTime2, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool) {
        m.checkNotNullParameter(guildScheduledEventPickerDate, "startDate");
        m.checkNotNullParameter(guildScheduledEventPickerTime, "startTime");
        m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        this.guildId = j;
        this.name = str;
        this.channelId = l;
        this.creatorId = l2;
        this.startDate = guildScheduledEventPickerDate;
        this.startTime = guildScheduledEventPickerTime;
        this.endDate = guildScheduledEventPickerDate2;
        this.endTime = guildScheduledEventPickerTime2;
        this.description = str2;
        this.entityType = guildScheduledEventEntityType;
        this.entityMetadata = guildScheduledEventEntityMetadata;
        this.userCount = num;
        this.broadcastToDirectoryChannels = bool;
    }

    public static /* synthetic */ GuildScheduledEventModel copy$default(GuildScheduledEventModel guildScheduledEventModel, long j, String str, Long l, Long l2, GuildScheduledEventPickerDate guildScheduledEventPickerDate, GuildScheduledEventPickerTime guildScheduledEventPickerTime, GuildScheduledEventPickerDate guildScheduledEventPickerDate2, GuildScheduledEventPickerTime guildScheduledEventPickerTime2, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, Object obj) {
        return guildScheduledEventModel.copy((i & 1) != 0 ? guildScheduledEventModel.guildId : j, (i & 2) != 0 ? guildScheduledEventModel.name : str, (i & 4) != 0 ? guildScheduledEventModel.channelId : l, (i & 8) != 0 ? guildScheduledEventModel.creatorId : l2, (i & 16) != 0 ? guildScheduledEventModel.startDate : guildScheduledEventPickerDate, (i & 32) != 0 ? guildScheduledEventModel.startTime : guildScheduledEventPickerTime, (i & 64) != 0 ? guildScheduledEventModel.endDate : guildScheduledEventPickerDate2, (i & 128) != 0 ? guildScheduledEventModel.endTime : guildScheduledEventPickerTime2, (i & 256) != 0 ? guildScheduledEventModel.description : str2, (i & 512) != 0 ? guildScheduledEventModel.entityType : guildScheduledEventEntityType, (i & 1024) != 0 ? guildScheduledEventModel.entityMetadata : guildScheduledEventEntityMetadata, (i & 2048) != 0 ? guildScheduledEventModel.userCount : num, (i & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : bool);
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
    public final GuildScheduledEventPickerDate getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GuildScheduledEventPickerTime getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildScheduledEventPickerDate getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GuildScheduledEventPickerTime getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventModel copy(long guildId, String name, Long channelId, Long creatorId, GuildScheduledEventPickerDate startDate, GuildScheduledEventPickerTime startTime, GuildScheduledEventPickerDate endDate, GuildScheduledEventPickerTime endTime, String description, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Integer userCount, Boolean broadcastToDirectoryChannels) {
        m.checkNotNullParameter(startDate, "startDate");
        m.checkNotNullParameter(startTime, "startTime");
        m.checkNotNullParameter(entityType, "entityType");
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
        return this.guildId == guildScheduledEventModel.guildId && m.areEqual(this.name, guildScheduledEventModel.name) && m.areEqual(this.channelId, guildScheduledEventModel.channelId) && m.areEqual(this.creatorId, guildScheduledEventModel.creatorId) && m.areEqual(this.startDate, guildScheduledEventModel.startDate) && m.areEqual(this.startTime, guildScheduledEventModel.startTime) && m.areEqual(this.endDate, guildScheduledEventModel.endDate) && m.areEqual(this.endTime, guildScheduledEventModel.endTime) && m.areEqual(this.description, guildScheduledEventModel.description) && m.areEqual(this.entityType, guildScheduledEventModel.entityType) && m.areEqual(this.entityMetadata, guildScheduledEventModel.entityMetadata) && m.areEqual(this.userCount, guildScheduledEventModel.userCount) && m.areEqual(this.broadcastToDirectoryChannels, guildScheduledEventModel.broadcastToDirectoryChannels);
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

    public final GuildScheduledEventPickerDate getEndDate() {
        return this.endDate;
    }

    public final GuildScheduledEventPickerTime getEndTime() {
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

    public final GuildScheduledEventPickerDate getStartDate() {
        return this.startDate;
    }

    public final GuildScheduledEventPickerTime getStartTime() {
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
        GuildScheduledEventPickerDate guildScheduledEventPickerDate = this.startDate;
        int iHashCode4 = (iHashCode3 + (guildScheduledEventPickerDate != null ? guildScheduledEventPickerDate.hashCode() : 0)) * 31;
        GuildScheduledEventPickerTime guildScheduledEventPickerTime = this.startTime;
        int iHashCode5 = (iHashCode4 + (guildScheduledEventPickerTime != null ? guildScheduledEventPickerTime.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDate guildScheduledEventPickerDate2 = this.endDate;
        int iHashCode6 = (iHashCode5 + (guildScheduledEventPickerDate2 != null ? guildScheduledEventPickerDate2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerTime guildScheduledEventPickerTime2 = this.endTime;
        int iHashCode7 = (iHashCode6 + (guildScheduledEventPickerTime2 != null ? guildScheduledEventPickerTime2.hashCode() : 0)) * 31;
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

    public final RestAPIParams$CreateGuildScheduledEventBody toCreateRequestBody() {
        GuildScheduledEventPickerTime guildScheduledEventPickerTime;
        String str = this.name;
        String utcDateString = null;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        String utcDateString2 = guildScheduledEventPickerDateTime.toUtcDateString(this.startDate, this.startTime);
        GuildScheduledEventPickerDate guildScheduledEventPickerDate = this.endDate;
        if (guildScheduledEventPickerDate != null && (guildScheduledEventPickerTime = this.endTime) != null) {
            utcDateString = guildScheduledEventPickerDateTime.toUtcDateString(guildScheduledEventPickerDate, guildScheduledEventPickerTime);
        }
        return new RestAPIParams$CreateGuildScheduledEventBody(str, this.description, StageInstancePrivacyLevel.GUILD_ONLY, utcDateString2, utcDateString, this.channelId, this.entityType, this.entityMetadata, this.broadcastToDirectoryChannels);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventModel(guildId=");
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
        return a.D(sbU, this.broadcastToDirectoryChannels, ")");
    }

    public final RestAPIParams$UpdateGuildScheduledEventBody toUpdateRequestBody(GuildScheduledEvent currentEvent) {
        GuildScheduledEventPickerTime guildScheduledEventPickerTime;
        m.checkNotNullParameter(currentEvent, "currentEvent");
        String str = this.name;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        long millis = guildScheduledEventPickerDateTime.toMillis(this.startDate, this.startTime);
        GuildScheduledEventPickerDate guildScheduledEventPickerDate = this.endDate;
        Long lValueOf = (guildScheduledEventPickerDate == null || (guildScheduledEventPickerTime = this.endTime) == null) ? null : Long.valueOf(guildScheduledEventPickerDateTime.toMillis(guildScheduledEventPickerDate, guildScheduledEventPickerTime));
        Long l = this.channelId;
        NullSerializable nullSerializable$b = l != null ? new NullSerializable$b(l) : new NullSerializable$a(null, 1);
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        NullSerializable nullSerializable$a = (guildScheduledEventEntityMetadata == null || guildScheduledEventEntityMetadata.b()) ? new NullSerializable$a(null, 1) : new NullSerializable$b(this.entityMetadata);
        String str2 = this.description;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = StageInstancePrivacyLevel.GUILD_ONLY;
        String uTCDateTime$default = currentEvent.getScheduledStartTime().getDateTimeMillis() == millis ? null : TimeUtils.toUTCDateTime$default(Long.valueOf(millis), null, 2, null);
        UtcDateTime scheduledEndTime = currentEvent.getScheduledEndTime();
        return new RestAPIParams$UpdateGuildScheduledEventBody(str, str2, stageInstancePrivacyLevel, uTCDateTime$default, m.areEqual(scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, lValueOf) ? null : TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null), nullSerializable$b, this.entityType, nullSerializable$a, null, this.broadcastToDirectoryChannels, 256, null);
    }

    public /* synthetic */ GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDate guildScheduledEventPickerDate, GuildScheduledEventPickerTime guildScheduledEventPickerTime, GuildScheduledEventPickerDate guildScheduledEventPickerDate2, GuildScheduledEventPickerTime guildScheduledEventPickerTime2, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, l, l2, guildScheduledEventPickerDate, guildScheduledEventPickerTime, guildScheduledEventPickerDate2, guildScheduledEventPickerTime2, str2, guildScheduledEventEntityType, guildScheduledEventEntityMetadata, num, (i & 4096) != 0 ? null : bool);
    }
}
