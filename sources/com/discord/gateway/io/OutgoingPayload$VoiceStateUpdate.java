package com.discord.gateway.io;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutgoingPayload$VoiceStateUpdate extends OutgoingPayload {
    private final Long channelId;
    private final Long guildId;
    private final String preferredRegion;
    private final boolean selfDeaf;
    private final boolean selfMute;
    private final boolean selfVideo;

    public /* synthetic */ OutgoingPayload$VoiceStateUpdate(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2, z2, z3, z4, (i & 32) != 0 ? null : str);
    }

    public static /* synthetic */ OutgoingPayload$VoiceStateUpdate copy$default(OutgoingPayload$VoiceStateUpdate outgoingPayload$VoiceStateUpdate, Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = outgoingPayload$VoiceStateUpdate.guildId;
        }
        if ((i & 2) != 0) {
            l2 = outgoingPayload$VoiceStateUpdate.channelId;
        }
        Long l3 = l2;
        if ((i & 4) != 0) {
            z2 = outgoingPayload$VoiceStateUpdate.selfMute;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = outgoingPayload$VoiceStateUpdate.selfDeaf;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = outgoingPayload$VoiceStateUpdate.selfVideo;
        }
        boolean z7 = z4;
        if ((i & 32) != 0) {
            str = outgoingPayload$VoiceStateUpdate.preferredRegion;
        }
        return outgoingPayload$VoiceStateUpdate.copy(l, l3, z5, z6, z7, str);
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPreferredRegion() {
        return this.preferredRegion;
    }

    public final OutgoingPayload$VoiceStateUpdate copy(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion) {
        return new OutgoingPayload$VoiceStateUpdate(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutgoingPayload$VoiceStateUpdate)) {
            return false;
        }
        OutgoingPayload$VoiceStateUpdate outgoingPayload$VoiceStateUpdate = (OutgoingPayload$VoiceStateUpdate) other;
        return m.areEqual(this.guildId, outgoingPayload$VoiceStateUpdate.guildId) && m.areEqual(this.channelId, outgoingPayload$VoiceStateUpdate.channelId) && this.selfMute == outgoingPayload$VoiceStateUpdate.selfMute && this.selfDeaf == outgoingPayload$VoiceStateUpdate.selfDeaf && this.selfVideo == outgoingPayload$VoiceStateUpdate.selfVideo && m.areEqual(this.preferredRegion, outgoingPayload$VoiceStateUpdate.preferredRegion);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getPreferredRegion() {
        return this.preferredRegion;
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
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        boolean z2 = this.selfMute;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.selfDeaf;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.selfVideo;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        String str = this.preferredRegion;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceStateUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", selfMute=");
        sbU.append(this.selfMute);
        sbU.append(", selfDeaf=");
        sbU.append(this.selfDeaf);
        sbU.append(", selfVideo=");
        sbU.append(this.selfVideo);
        sbU.append(", preferredRegion=");
        return a.J(sbU, this.preferredRegion, ")");
    }

    public OutgoingPayload$VoiceStateUpdate(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str) {
        super(null);
        this.guildId = l;
        this.channelId = l2;
        this.selfMute = z2;
        this.selfDeaf = z3;
        this.selfVideo = z4;
        this.preferredRegion = str;
    }
}
