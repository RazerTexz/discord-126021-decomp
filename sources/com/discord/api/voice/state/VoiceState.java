package com.discord.api.voice.state;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: VoiceState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VoiceState {
    private final Long channelId;
    private final boolean deaf;
    private final long guildId;
    private final GuildMember member;
    private final boolean mute;
    private final UtcDateTime requestToSpeakTimestamp;
    private final boolean selfDeaf;
    private final boolean selfMute;
    private final boolean selfStream;
    private final boolean selfVideo;
    private final String sessionId;
    private final boolean suppress;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getDeaf() {
        return this.deaf;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getMute() {
        return this.mute;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceState)) {
            return false;
        }
        VoiceState voiceState = (VoiceState) other;
        return this.userId == voiceState.userId && this.suppress == voiceState.suppress && Intrinsics3.areEqual(this.sessionId, voiceState.sessionId) && this.selfMute == voiceState.selfMute && this.selfDeaf == voiceState.selfDeaf && this.selfVideo == voiceState.selfVideo && this.selfStream == voiceState.selfStream && this.mute == voiceState.mute && this.guildId == voiceState.guildId && this.deaf == voiceState.deaf && Intrinsics3.areEqual(this.member, voiceState.member) && Intrinsics3.areEqual(this.requestToSpeakTimestamp, voiceState.requestToSpeakTimestamp) && Intrinsics3.areEqual(this.channelId, voiceState.channelId);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final UtcDateTime getRequestToSpeakTimestamp() {
        return this.requestToSpeakTimestamp;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getSelfDeaf() {
        return this.selfDeaf;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getSelfMute() {
        return this.selfMute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.suppress;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (i + r0) * 31;
        String str = this.sessionId;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.selfMute;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i3 = (iHashCode + r1) * 31;
        boolean z4 = this.selfDeaf;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i4 = (i3 + r2) * 31;
        boolean z5 = this.selfVideo;
        ?? r3 = z5;
        if (z5) {
            r3 = 1;
        }
        int i5 = (i4 + r3) * 31;
        boolean z6 = this.selfStream;
        ?? r4 = z6;
        if (z6) {
            r4 = 1;
        }
        int i6 = (i5 + r4) * 31;
        boolean z7 = this.mute;
        ?? r5 = z7;
        if (z7) {
            r5 = 1;
        }
        long j2 = this.guildId;
        int i7 = (((i6 + r5) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        boolean z8 = this.deaf;
        int i8 = (i7 + (z8 ? 1 : z8)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode2 = (i8 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
        int iHashCode3 = (iHashCode2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        Long l = this.channelId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getSelfStream() {
        return this.selfStream;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getSelfVideo() {
        return this.selfVideo;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final boolean getSuppress() {
        return this.suppress;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public String toString() {
        StringBuilder sbU = outline.U("VoiceState(userId=");
        sbU.append(this.userId);
        sbU.append(", suppress=");
        sbU.append(this.suppress);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", selfMute=");
        sbU.append(this.selfMute);
        sbU.append(", selfDeaf=");
        sbU.append(this.selfDeaf);
        sbU.append(", selfVideo=");
        sbU.append(this.selfVideo);
        sbU.append(", selfStream=");
        sbU.append(this.selfStream);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", deaf=");
        sbU.append(this.deaf);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", requestToSpeakTimestamp=");
        sbU.append(this.requestToSpeakTimestamp);
        sbU.append(", channelId=");
        return outline.G(sbU, this.channelId, ")");
    }
}
