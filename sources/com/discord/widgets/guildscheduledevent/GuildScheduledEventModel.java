package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.time.TimeUtils;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(guildScheduledEventPickerDate, "startDate");
        C12238m.checkNotNullParameter(guildScheduledEventPickerTime, "startTime");
        C12238m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
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
        C12238m.checkNotNullParameter(startDate, "startDate");
        C12238m.checkNotNullParameter(startTime, "startTime");
        C12238m.checkNotNullParameter(entityType, "entityType");
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
        return this.guildId == guildScheduledEventModel.guildId && C12238m.areEqual(this.name, guildScheduledEventModel.name) && C12238m.areEqual(this.channelId, guildScheduledEventModel.channelId) && C12238m.areEqual(this.creatorId, guildScheduledEventModel.creatorId) && C12238m.areEqual(this.startDate, guildScheduledEventModel.startDate) && C12238m.areEqual(this.startTime, guildScheduledEventModel.startTime) && C12238m.areEqual(this.endDate, guildScheduledEventModel.endDate) && C12238m.areEqual(this.endTime, guildScheduledEventModel.endTime) && C12238m.areEqual(this.description, guildScheduledEventModel.description) && C12238m.areEqual(this.entityType, guildScheduledEventModel.entityType) && C12238m.areEqual(this.entityMetadata, guildScheduledEventModel.entityMetadata) && C12238m.areEqual(this.userCount, guildScheduledEventModel.userCount) && C12238m.areEqual(this.broadcastToDirectoryChannels, guildScheduledEventModel.broadcastToDirectoryChannels);
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
        int iM3a = C0002b.m3a(this.guildId) * 31;
        String str = this.name;
        int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
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

    public final RestAPIParams.CreateGuildScheduledEventBody toCreateRequestBody() {
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
        return new RestAPIParams.CreateGuildScheduledEventBody(str, this.description, StageInstancePrivacyLevel.GUILD_ONLY, utcDateString2, utcDateString, this.channelId, this.entityType, this.entityMetadata, this.broadcastToDirectoryChannels);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventModel(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", creatorId=");
        sbM833U.append(this.creatorId);
        sbM833U.append(", startDate=");
        sbM833U.append(this.startDate);
        sbM833U.append(", startTime=");
        sbM833U.append(this.startTime);
        sbM833U.append(", endDate=");
        sbM833U.append(this.endDate);
        sbM833U.append(", endTime=");
        sbM833U.append(this.endTime);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", entityMetadata=");
        sbM833U.append(this.entityMetadata);
        sbM833U.append(", userCount=");
        sbM833U.append(this.userCount);
        sbM833U.append(", broadcastToDirectoryChannels=");
        return C1643a.m816D(sbM833U, this.broadcastToDirectoryChannels, ")");
    }

    public final RestAPIParams.UpdateGuildScheduledEventBody toUpdateRequestBody(GuildScheduledEvent currentEvent) {
        GuildScheduledEventPickerTime guildScheduledEventPickerTime;
        C12238m.checkNotNullParameter(currentEvent, "currentEvent");
        String str = this.name;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        long millis = guildScheduledEventPickerDateTime.toMillis(this.startDate, this.startTime);
        GuildScheduledEventPickerDate guildScheduledEventPickerDate = this.endDate;
        Long lValueOf = (guildScheduledEventPickerDate == null || (guildScheduledEventPickerTime = this.endTime) == null) ? null : Long.valueOf(guildScheduledEventPickerDateTime.toMillis(guildScheduledEventPickerDate, guildScheduledEventPickerTime));
        Long l = this.channelId;
        NullSerializable c5566b = l != null ? new NullSerializable.C5566b(l) : new NullSerializable.C5565a(null, 1);
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        NullSerializable c5565a = (guildScheduledEventEntityMetadata == null || guildScheduledEventEntityMetadata.m7991b()) ? new NullSerializable.C5565a(null, 1) : new NullSerializable.C5566b(this.entityMetadata);
        String str2 = this.description;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = StageInstancePrivacyLevel.GUILD_ONLY;
        String uTCDateTime$default = currentEvent.getScheduledStartTime().getDateTimeMillis() == millis ? null : TimeUtils.toUTCDateTime$default(Long.valueOf(millis), null, 2, null);
        UtcDateTime scheduledEndTime = currentEvent.getScheduledEndTime();
        return new RestAPIParams.UpdateGuildScheduledEventBody(str, str2, stageInstancePrivacyLevel, uTCDateTime$default, C12238m.areEqual(scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, lValueOf) ? null : TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null), c5566b, this.entityType, c5565a, null, this.broadcastToDirectoryChannels, 256, null);
    }

    public /* synthetic */ GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDate guildScheduledEventPickerDate, GuildScheduledEventPickerTime guildScheduledEventPickerTime, GuildScheduledEventPickerDate guildScheduledEventPickerDate2, GuildScheduledEventPickerTime guildScheduledEventPickerTime2, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, l, l2, guildScheduledEventPickerDate, guildScheduledEventPickerTime, guildScheduledEventPickerDate2, guildScheduledEventPickerTime2, str2, guildScheduledEventEntityType, guildScheduledEventEntityMetadata, num, (i & 4096) != 0 ? null : bool);
    }
}
