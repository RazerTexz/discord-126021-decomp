package com.discord.api.stageinstance;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StageInstance.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageInstance {
    private final long channelId;
    private final long guildId;
    private final long id;
    private final String inviteCode;
    private final StageInstancePrivacyLevel privacyLevel;
    private final String topic;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageInstance)) {
            return false;
        }
        StageInstance stageInstance = (StageInstance) other;
        return this.id == stageInstance.id && this.guildId == stageInstance.guildId && this.channelId == stageInstance.channelId && Intrinsics3.areEqual(this.topic, stageInstance.topic) && Intrinsics3.areEqual(this.privacyLevel, stageInstance.privacyLevel) && Intrinsics3.areEqual(this.inviteCode, stageInstance.inviteCode);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.channelId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.topic;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
        int iHashCode2 = (iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
        String str2 = this.inviteCode;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageInstance(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", inviteCode=");
        return outline.J(sbU, this.inviteCode, ")");
    }
}
