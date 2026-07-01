package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$CreateGuildScheduledEventBody {
    private final Boolean broadcastToDirectoryChannels;
    private final Long channelId;
    private final String description;
    private final GuildScheduledEventEntityMetadata entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final String name;
    private final StageInstancePrivacyLevel privacyLevel;
    private final String scheduledEndTime;
    private final String scheduledStartTime;

    public RestAPIParams$CreateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Boolean bool) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
        m.checkNotNullParameter(str3, "scheduledStartTime");
        m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        this.name = str;
        this.description = str2;
        this.privacyLevel = stageInstancePrivacyLevel;
        this.scheduledStartTime = str3;
        this.scheduledEndTime = str4;
        this.channelId = l;
        this.entityType = guildScheduledEventEntityType;
        this.entityMetadata = guildScheduledEventEntityMetadata;
        this.broadcastToDirectoryChannels = bool;
    }

    public static /* synthetic */ RestAPIParams$CreateGuildScheduledEventBody copy$default(RestAPIParams$CreateGuildScheduledEventBody restAPIParams$CreateGuildScheduledEventBody, String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Boolean bool, int i, Object obj) {
        return restAPIParams$CreateGuildScheduledEventBody.copy((i & 1) != 0 ? restAPIParams$CreateGuildScheduledEventBody.name : str, (i & 2) != 0 ? restAPIParams$CreateGuildScheduledEventBody.description : str2, (i & 4) != 0 ? restAPIParams$CreateGuildScheduledEventBody.privacyLevel : stageInstancePrivacyLevel, (i & 8) != 0 ? restAPIParams$CreateGuildScheduledEventBody.scheduledStartTime : str3, (i & 16) != 0 ? restAPIParams$CreateGuildScheduledEventBody.scheduledEndTime : str4, (i & 32) != 0 ? restAPIParams$CreateGuildScheduledEventBody.channelId : l, (i & 64) != 0 ? restAPIParams$CreateGuildScheduledEventBody.entityType : guildScheduledEventEntityType, (i & 128) != 0 ? restAPIParams$CreateGuildScheduledEventBody.entityMetadata : guildScheduledEventEntityMetadata, (i & 256) != 0 ? restAPIParams$CreateGuildScheduledEventBody.broadcastToDirectoryChannels : bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    public final RestAPIParams$CreateGuildScheduledEventBody copy(String name, String description, StageInstancePrivacyLevel privacyLevel, String scheduledStartTime, String scheduledEndTime, Long channelId, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Boolean broadcastToDirectoryChannels) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(privacyLevel, "privacyLevel");
        m.checkNotNullParameter(scheduledStartTime, "scheduledStartTime");
        m.checkNotNullParameter(entityType, "entityType");
        return new RestAPIParams$CreateGuildScheduledEventBody(name, description, privacyLevel, scheduledStartTime, scheduledEndTime, channelId, entityType, entityMetadata, broadcastToDirectoryChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$CreateGuildScheduledEventBody)) {
            return false;
        }
        RestAPIParams$CreateGuildScheduledEventBody restAPIParams$CreateGuildScheduledEventBody = (RestAPIParams$CreateGuildScheduledEventBody) other;
        return m.areEqual(this.name, restAPIParams$CreateGuildScheduledEventBody.name) && m.areEqual(this.description, restAPIParams$CreateGuildScheduledEventBody.description) && m.areEqual(this.privacyLevel, restAPIParams$CreateGuildScheduledEventBody.privacyLevel) && m.areEqual(this.scheduledStartTime, restAPIParams$CreateGuildScheduledEventBody.scheduledStartTime) && m.areEqual(this.scheduledEndTime, restAPIParams$CreateGuildScheduledEventBody.scheduledEndTime) && m.areEqual(this.channelId, restAPIParams$CreateGuildScheduledEventBody.channelId) && m.areEqual(this.entityType, restAPIParams$CreateGuildScheduledEventBody.entityType) && m.areEqual(this.entityMetadata, restAPIParams$CreateGuildScheduledEventBody.entityMetadata) && m.areEqual(this.broadcastToDirectoryChannels, restAPIParams$CreateGuildScheduledEventBody.broadcastToDirectoryChannels);
    }

    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
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
        Long l = this.channelId;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
        int iHashCode7 = (iHashCode6 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        int iHashCode8 = (iHashCode7 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
        Boolean bool = this.broadcastToDirectoryChannels;
        return iHashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CreateGuildScheduledEventBody(name=");
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
        sbU.append(", broadcastToDirectoryChannels=");
        return a.D(sbU, this.broadcastToDirectoryChannels, ")");
    }
}
