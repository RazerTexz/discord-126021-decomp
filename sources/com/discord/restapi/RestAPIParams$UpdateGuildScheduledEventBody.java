package com.discord.restapi;

import androidx.media.AudioAttributesCompat;
import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UpdateGuildScheduledEventBody {
    private final Boolean broadcastToDirectoryChannels;
    private final NullSerializable<Long> channelId;
    private final String description;
    private final NullSerializable<GuildScheduledEventEntityMetadata> entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final String name;
    private final StageInstancePrivacyLevel privacyLevel;
    private final String scheduledEndTime;
    private final String scheduledStartTime;
    private final GuildScheduledEventStatus status;

    public RestAPIParams$UpdateGuildScheduledEventBody() {
        this(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
    }

    public RestAPIParams$UpdateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable<Long> nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable<GuildScheduledEventEntityMetadata> nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool) {
        this.name = str;
        this.description = str2;
        this.privacyLevel = stageInstancePrivacyLevel;
        this.scheduledStartTime = str3;
        this.scheduledEndTime = str4;
        this.channelId = nullSerializable;
        this.entityType = guildScheduledEventEntityType;
        this.entityMetadata = nullSerializable2;
        this.status = guildScheduledEventStatus;
        this.broadcastToDirectoryChannels = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$UpdateGuildScheduledEventBody copy$default(RestAPIParams$UpdateGuildScheduledEventBody restAPIParams$UpdateGuildScheduledEventBody, String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool, int i, Object obj) {
        return restAPIParams$UpdateGuildScheduledEventBody.copy((i & 1) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.name : str, (i & 2) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.description : str2, (i & 4) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.privacyLevel : stageInstancePrivacyLevel, (i & 8) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.scheduledStartTime : str3, (i & 16) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.scheduledEndTime : str4, (i & 32) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.channelId : nullSerializable, (i & 64) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.entityType : guildScheduledEventEntityType, (i & 128) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.entityMetadata : nullSerializable2, (i & 256) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.status : guildScheduledEventStatus, (i & 512) != 0 ? restAPIParams$UpdateGuildScheduledEventBody.broadcastToDirectoryChannels : bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getScheduledStartTime() {
        return this.scheduledStartTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getScheduledEndTime() {
        return this.scheduledEndTime;
    }

    public final NullSerializable<Long> component6() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    public final NullSerializable<GuildScheduledEventEntityMetadata> component8() {
        return this.entityMetadata;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final GuildScheduledEventStatus getStatus() {
        return this.status;
    }

    public final RestAPIParams$UpdateGuildScheduledEventBody copy(String name, String description, StageInstancePrivacyLevel privacyLevel, String scheduledStartTime, String scheduledEndTime, NullSerializable<Long> channelId, GuildScheduledEventEntityType entityType, NullSerializable<GuildScheduledEventEntityMetadata> entityMetadata, GuildScheduledEventStatus status, Boolean broadcastToDirectoryChannels) {
        return new RestAPIParams$UpdateGuildScheduledEventBody(name, description, privacyLevel, scheduledStartTime, scheduledEndTime, channelId, entityType, entityMetadata, status, broadcastToDirectoryChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$UpdateGuildScheduledEventBody)) {
            return false;
        }
        RestAPIParams$UpdateGuildScheduledEventBody restAPIParams$UpdateGuildScheduledEventBody = (RestAPIParams$UpdateGuildScheduledEventBody) other;
        return m.areEqual(this.name, restAPIParams$UpdateGuildScheduledEventBody.name) && m.areEqual(this.description, restAPIParams$UpdateGuildScheduledEventBody.description) && m.areEqual(this.privacyLevel, restAPIParams$UpdateGuildScheduledEventBody.privacyLevel) && m.areEqual(this.scheduledStartTime, restAPIParams$UpdateGuildScheduledEventBody.scheduledStartTime) && m.areEqual(this.scheduledEndTime, restAPIParams$UpdateGuildScheduledEventBody.scheduledEndTime) && m.areEqual(this.channelId, restAPIParams$UpdateGuildScheduledEventBody.channelId) && m.areEqual(this.entityType, restAPIParams$UpdateGuildScheduledEventBody.entityType) && m.areEqual(this.entityMetadata, restAPIParams$UpdateGuildScheduledEventBody.entityMetadata) && m.areEqual(this.status, restAPIParams$UpdateGuildScheduledEventBody.status) && m.areEqual(this.broadcastToDirectoryChannels, restAPIParams$UpdateGuildScheduledEventBody.broadcastToDirectoryChannels);
    }

    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    public final NullSerializable<Long> getChannelId() {
        return this.channelId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final NullSerializable<GuildScheduledEventEntityMetadata> getEntityMetadata() {
        return this.entityMetadata;
    }

    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    public final String getName() {
        return this.name;
    }

    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    public final String getScheduledEndTime() {
        return this.scheduledEndTime;
    }

    public final String getScheduledStartTime() {
        return this.scheduledStartTime;
    }

    public final GuildScheduledEventStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
        int iHashCode3 = (iHashCode2 + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
        String str3 = this.scheduledStartTime;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.scheduledEndTime;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        NullSerializable<Long> nullSerializable = this.channelId;
        int iHashCode6 = (iHashCode5 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
        int iHashCode7 = (iHashCode6 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
        NullSerializable<GuildScheduledEventEntityMetadata> nullSerializable2 = this.entityMetadata;
        int iHashCode8 = (iHashCode7 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        GuildScheduledEventStatus guildScheduledEventStatus = this.status;
        int iHashCode9 = (iHashCode8 + (guildScheduledEventStatus != null ? guildScheduledEventStatus.hashCode() : 0)) * 31;
        Boolean bool = this.broadcastToDirectoryChannels;
        return iHashCode9 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdateGuildScheduledEventBody(name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", scheduledStartTime=");
        sbU.append(this.scheduledStartTime);
        sbU.append(", scheduledEndTime=");
        sbU.append(this.scheduledEndTime);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", entityType=");
        sbU.append(this.entityType);
        sbU.append(", entityMetadata=");
        sbU.append(this.entityMetadata);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", broadcastToDirectoryChannels=");
        return a.D(sbU, this.broadcastToDirectoryChannels, ")");
    }

    public /* synthetic */ RestAPIParams$UpdateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : stageInstancePrivacyLevel, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? null : guildScheduledEventEntityType, (i & 128) != 0 ? null : nullSerializable2, (i & 256) != 0 ? null : guildScheduledEventStatus, (i & 512) == 0 ? bool : null);
    }
}
