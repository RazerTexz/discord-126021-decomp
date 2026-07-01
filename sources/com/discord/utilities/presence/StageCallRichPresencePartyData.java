package com.discord.utilities.presence;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: ActivityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageCallRichPresencePartyData {
    private final long audienceSize;
    private final long channelId;
    private final long guildId;
    private final boolean guildIsPartnered;
    private final boolean guildIsVerified;
    private final long speakerCount;
    private final long stageInstanceId;
    private final boolean userIsSpeaker;

    public StageCallRichPresencePartyData(long j, long j2, boolean z2, long j3, boolean z3, boolean z4, long j4, long j5) {
        this.stageInstanceId = j;
        this.channelId = j2;
        this.userIsSpeaker = z2;
        this.guildId = j3;
        this.guildIsPartnered = z3;
        this.guildIsVerified = z4;
        this.speakerCount = j4;
        this.audienceSize = j5;
    }

    public static /* synthetic */ StageCallRichPresencePartyData copy$default(StageCallRichPresencePartyData stageCallRichPresencePartyData, long j, long j2, boolean z2, long j3, boolean z3, boolean z4, long j4, long j5, int i, Object obj) {
        return stageCallRichPresencePartyData.copy((i & 1) != 0 ? stageCallRichPresencePartyData.stageInstanceId : j, (i & 2) != 0 ? stageCallRichPresencePartyData.channelId : j2, (i & 4) != 0 ? stageCallRichPresencePartyData.userIsSpeaker : z2, (i & 8) != 0 ? stageCallRichPresencePartyData.guildId : j3, (i & 16) != 0 ? stageCallRichPresencePartyData.guildIsPartnered : z3, (i & 32) != 0 ? stageCallRichPresencePartyData.guildIsVerified : z4, (i & 64) != 0 ? stageCallRichPresencePartyData.speakerCount : j4, (i & 128) != 0 ? stageCallRichPresencePartyData.audienceSize : j5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
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
    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final StageCallRichPresencePartyData copy(long stageInstanceId, long channelId, boolean userIsSpeaker, long guildId, boolean guildIsPartnered, boolean guildIsVerified, long speakerCount, long audienceSize) {
        return new StageCallRichPresencePartyData(stageInstanceId, channelId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, speakerCount, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallRichPresencePartyData)) {
            return false;
        }
        StageCallRichPresencePartyData stageCallRichPresencePartyData = (StageCallRichPresencePartyData) other;
        return this.stageInstanceId == stageCallRichPresencePartyData.stageInstanceId && this.channelId == stageCallRichPresencePartyData.channelId && this.userIsSpeaker == stageCallRichPresencePartyData.userIsSpeaker && this.guildId == stageCallRichPresencePartyData.guildId && this.guildIsPartnered == stageCallRichPresencePartyData.guildIsPartnered && this.guildIsVerified == stageCallRichPresencePartyData.guildIsVerified && this.speakerCount == stageCallRichPresencePartyData.speakerCount && this.audienceSize == stageCallRichPresencePartyData.audienceSize;
    }

    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final long getChannelId() {
        return this.channelId;
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

    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.stageInstanceId) * 31)) * 31;
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
        return b.a(this.audienceSize) + ((b.a(this.speakerCount) + ((i + (z4 ? 1 : z4)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("StageCallRichPresencePartyData(stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", userIsSpeaker=");
        sbU.append(this.userIsSpeaker);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildIsPartnered=");
        sbU.append(this.guildIsPartnered);
        sbU.append(", guildIsVerified=");
        sbU.append(this.guildIsVerified);
        sbU.append(", speakerCount=");
        sbU.append(this.speakerCount);
        sbU.append(", audienceSize=");
        return a.C(sbU, this.audienceSize, ")");
    }
}
