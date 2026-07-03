package com.discord.api.stageinstance;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.id == stageInstance.id && this.guildId == stageInstance.guildId && this.channelId == stageInstance.channelId && C12238m.areEqual(this.topic, stageInstance.topic) && C12238m.areEqual(this.privacyLevel, stageInstance.privacyLevel) && C12238m.areEqual(this.inviteCode, stageInstance.inviteCode);
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
        StringBuilder sbM833U = C1643a.m833U("StageInstance(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", topic=");
        sbM833U.append(this.topic);
        sbM833U.append(", privacyLevel=");
        sbM833U.append(this.privacyLevel);
        sbM833U.append(", inviteCode=");
        return C1643a.m822J(sbM833U, this.inviteCode, ")");
    }
}
