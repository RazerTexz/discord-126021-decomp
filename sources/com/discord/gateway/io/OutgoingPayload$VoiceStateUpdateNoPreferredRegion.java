package com.discord.gateway.io;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutgoingPayload$VoiceStateUpdateNoPreferredRegion extends OutgoingPayload {
    private final Long channelId;
    private final Long guildId;
    private final boolean selfDeaf;
    private final boolean selfMute;
    private final boolean selfVideo;

    public OutgoingPayload$VoiceStateUpdateNoPreferredRegion(Long l, Long l2, boolean z2, boolean z3, boolean z4) {
        super(null);
        this.guildId = l;
        this.channelId = l2;
        this.selfMute = z2;
        this.selfDeaf = z3;
        this.selfVideo = z4;
    }

    public static /* synthetic */ OutgoingPayload$VoiceStateUpdateNoPreferredRegion copy$default(OutgoingPayload$VoiceStateUpdateNoPreferredRegion outgoingPayload$VoiceStateUpdateNoPreferredRegion, Long l, Long l2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            l = outgoingPayload$VoiceStateUpdateNoPreferredRegion.guildId;
        }
        if ((i & 2) != 0) {
            l2 = outgoingPayload$VoiceStateUpdateNoPreferredRegion.channelId;
        }
        Long l3 = l2;
        if ((i & 4) != 0) {
            z2 = outgoingPayload$VoiceStateUpdateNoPreferredRegion.selfMute;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = outgoingPayload$VoiceStateUpdateNoPreferredRegion.selfDeaf;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = outgoingPayload$VoiceStateUpdateNoPreferredRegion.selfVideo;
        }
        return outgoingPayload$VoiceStateUpdateNoPreferredRegion.copy(l, l3, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelfMute() {
        return this.selfMute;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSelfDeaf() {
        return this.selfDeaf;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getSelfVideo() {
        return this.selfVideo;
    }

    public final OutgoingPayload$VoiceStateUpdateNoPreferredRegion copy(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo) {
        return new OutgoingPayload$VoiceStateUpdateNoPreferredRegion(guildId, channelId, selfMute, selfDeaf, selfVideo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutgoingPayload$VoiceStateUpdateNoPreferredRegion)) {
            return false;
        }
        OutgoingPayload$VoiceStateUpdateNoPreferredRegion outgoingPayload$VoiceStateUpdateNoPreferredRegion = (OutgoingPayload$VoiceStateUpdateNoPreferredRegion) other;
        return m.areEqual(this.guildId, outgoingPayload$VoiceStateUpdateNoPreferredRegion.guildId) && m.areEqual(this.channelId, outgoingPayload$VoiceStateUpdateNoPreferredRegion.channelId) && this.selfMute == outgoingPayload$VoiceStateUpdateNoPreferredRegion.selfMute && this.selfDeaf == outgoingPayload$VoiceStateUpdateNoPreferredRegion.selfDeaf && this.selfVideo == outgoingPayload$VoiceStateUpdateNoPreferredRegion.selfVideo;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final boolean getSelfDeaf() {
        return this.selfDeaf;
    }

    public final boolean getSelfMute() {
        return this.selfMute;
    }

    public final boolean getSelfVideo() {
        return this.selfVideo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        boolean z2 = this.selfMute;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.selfDeaf;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.selfVideo;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceStateUpdateNoPreferredRegion(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", selfMute=");
        sbU.append(this.selfMute);
        sbU.append(", selfDeaf=");
        sbU.append(this.selfDeaf);
        sbU.append(", selfVideo=");
        return a.O(sbU, this.selfVideo, ")");
    }
}
