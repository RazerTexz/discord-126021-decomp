package com.discord.widgets.user.presence;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: ModelStageRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStageRichPresence {
    public static final ModelStageRichPresence$Companion Companion = new ModelStageRichPresence$Companion(null);
    private final long audienceSize;
    private final long channelId;
    private final String guildIcon;
    private final long guildId;
    private final boolean guildIsPartnered;
    private final boolean guildIsVerified;
    private final String guildName;
    private final Set<Long> knownUserIds;
    private final long speakerCount;
    private final Set<Long> speakerIds;
    private final long stageInstanceId;
    private final String topic;
    private final boolean userIsSpeaker;

    public ModelStageRichPresence(long j, long j2, boolean z2, long j3, boolean z3, boolean z4, String str, String str2, String str3, Set<Long> set, Set<Long> set2, long j4, long j5) {
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        m.checkNotNullParameter(set, "knownUserIds");
        m.checkNotNullParameter(set2, "speakerIds");
        this.channelId = j;
        this.stageInstanceId = j2;
        this.userIsSpeaker = z2;
        this.guildId = j3;
        this.guildIsPartnered = z3;
        this.guildIsVerified = z4;
        this.guildName = str;
        this.guildIcon = str2;
        this.topic = str3;
        this.knownUserIds = set;
        this.speakerIds = set2;
        this.speakerCount = j4;
        this.audienceSize = j5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStageRichPresence copy$default(ModelStageRichPresence modelStageRichPresence, long j, long j2, boolean z2, long j3, boolean z3, boolean z4, String str, String str2, String str3, Set set, Set set2, long j4, long j5, int i, Object obj) {
        return modelStageRichPresence.copy((i & 1) != 0 ? modelStageRichPresence.channelId : j, (i & 2) != 0 ? modelStageRichPresence.stageInstanceId : j2, (i & 4) != 0 ? modelStageRichPresence.userIsSpeaker : z2, (i & 8) != 0 ? modelStageRichPresence.guildId : j3, (i & 16) != 0 ? modelStageRichPresence.guildIsPartnered : z3, (i & 32) != 0 ? modelStageRichPresence.guildIsVerified : z4, (i & 64) != 0 ? modelStageRichPresence.guildName : str, (i & 128) != 0 ? modelStageRichPresence.guildIcon : str2, (i & 256) != 0 ? modelStageRichPresence.topic : str3, (i & 512) != 0 ? modelStageRichPresence.knownUserIds : set, (i & 1024) != 0 ? modelStageRichPresence.speakerIds : set2, (i & 2048) != 0 ? modelStageRichPresence.speakerCount : j4, (i & 4096) != 0 ? modelStageRichPresence.audienceSize : j5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final Set<Long> component10() {
        return this.knownUserIds;
    }

    public final Set<Long> component11() {
        return this.speakerIds;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getAudienceSize() {
        return this.audienceSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getGuildIcon() {
        return this.guildIcon;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public final ModelStageRichPresence copy(long channelId, long stageInstanceId, boolean userIsSpeaker, long guildId, boolean guildIsPartnered, boolean guildIsVerified, String guildName, String guildIcon, String topic, Set<Long> knownUserIds, Set<Long> speakerIds, long speakerCount, long audienceSize) {
        m.checkNotNullParameter(guildName, "guildName");
        m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        m.checkNotNullParameter(knownUserIds, "knownUserIds");
        m.checkNotNullParameter(speakerIds, "speakerIds");
        return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, guildName, guildIcon, topic, knownUserIds, speakerIds, speakerCount, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStageRichPresence)) {
            return false;
        }
        ModelStageRichPresence modelStageRichPresence = (ModelStageRichPresence) other;
        return this.channelId == modelStageRichPresence.channelId && this.stageInstanceId == modelStageRichPresence.stageInstanceId && this.userIsSpeaker == modelStageRichPresence.userIsSpeaker && this.guildId == modelStageRichPresence.guildId && this.guildIsPartnered == modelStageRichPresence.guildIsPartnered && this.guildIsVerified == modelStageRichPresence.guildIsVerified && m.areEqual(this.guildName, modelStageRichPresence.guildName) && m.areEqual(this.guildIcon, modelStageRichPresence.guildIcon) && m.areEqual(this.topic, modelStageRichPresence.topic) && m.areEqual(this.knownUserIds, modelStageRichPresence.knownUserIds) && m.areEqual(this.speakerIds, modelStageRichPresence.speakerIds) && this.speakerCount == modelStageRichPresence.speakerCount && this.audienceSize == modelStageRichPresence.audienceSize;
    }

    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getGuildIcon() {
        return this.guildIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final Set<Long> getKnownUserIds() {
        return this.knownUserIds;
    }

    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    public final Set<Long> getSpeakerIds() {
        return this.speakerIds;
    }

    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        int iA = (b.a(this.stageInstanceId) + (b.a(this.channelId) * 31)) * 31;
        boolean z2 = this.userIsSpeaker;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iA2 = (b.a(this.guildId) + ((iA + r0) * 31)) * 31;
        boolean z3 = this.guildIsPartnered;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i = (iA2 + r1) * 31;
        boolean z4 = this.guildIsVerified;
        int i2 = (i + (z4 ? 1 : z4)) * 31;
        String str = this.guildName;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.guildIcon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.topic;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Set<Long> set = this.knownUserIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.speakerIds;
        return b.a(this.audienceSize) + ((b.a(this.speakerCount) + ((iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelStageRichPresence(channelId=");
        sbU.append(this.channelId);
        sbU.append(", stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", userIsSpeaker=");
        sbU.append(this.userIsSpeaker);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildIsPartnered=");
        sbU.append(this.guildIsPartnered);
        sbU.append(", guildIsVerified=");
        sbU.append(this.guildIsVerified);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildIcon=");
        sbU.append(this.guildIcon);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", knownUserIds=");
        sbU.append(this.knownUserIds);
        sbU.append(", speakerIds=");
        sbU.append(this.speakerIds);
        sbU.append(", speakerCount=");
        sbU.append(this.speakerCount);
        sbU.append(", audienceSize=");
        return a.C(sbU, this.audienceSize, ")");
    }
}
