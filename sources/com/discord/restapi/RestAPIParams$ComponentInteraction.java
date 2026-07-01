package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ComponentInteraction {
    private final long applicationId;
    private final long channelId;
    private final RestAPIParams$ComponentInteractionData data;
    private final Long guildId;
    private final Long messageFlags;
    private final long messageId;
    private final String nonce;
    private final String sessionId;
    private final long type;

    public RestAPIParams$ComponentInteraction(long j, long j2, long j3, Long l, long j4, Long l2, RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData, String str, String str2) {
        m.checkNotNullParameter(restAPIParams$ComponentInteractionData, "data");
        m.checkNotNullParameter(str2, "nonce");
        this.type = j;
        this.channelId = j2;
        this.applicationId = j3;
        this.guildId = l;
        this.messageId = j4;
        this.messageFlags = l2;
        this.data = restAPIParams$ComponentInteractionData;
        this.sessionId = str;
        this.nonce = str2;
    }

    public static /* synthetic */ RestAPIParams$ComponentInteraction copy$default(RestAPIParams$ComponentInteraction restAPIParams$ComponentInteraction, long j, long j2, long j3, Long l, long j4, Long l2, RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData, String str, String str2, int i, Object obj) {
        return restAPIParams$ComponentInteraction.copy((i & 1) != 0 ? restAPIParams$ComponentInteraction.type : j, (i & 2) != 0 ? restAPIParams$ComponentInteraction.channelId : j2, (i & 4) != 0 ? restAPIParams$ComponentInteraction.applicationId : j3, (i & 8) != 0 ? restAPIParams$ComponentInteraction.guildId : l, (i & 16) != 0 ? restAPIParams$ComponentInteraction.messageId : j4, (i & 32) != 0 ? restAPIParams$ComponentInteraction.messageFlags : l2, (i & 64) != 0 ? restAPIParams$ComponentInteraction.data : restAPIParams$ComponentInteractionData, (i & 128) != 0 ? restAPIParams$ComponentInteraction.sessionId : str, (i & 256) != 0 ? restAPIParams$ComponentInteraction.nonce : str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getMessageFlags() {
        return this.messageFlags;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RestAPIParams$ComponentInteractionData getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public final RestAPIParams$ComponentInteraction copy(long type, long channelId, long applicationId, Long guildId, long messageId, Long messageFlags, RestAPIParams$ComponentInteractionData data, String sessionId, String nonce) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(nonce, "nonce");
        return new RestAPIParams$ComponentInteraction(type, channelId, applicationId, guildId, messageId, messageFlags, data, sessionId, nonce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ComponentInteraction)) {
            return false;
        }
        RestAPIParams$ComponentInteraction restAPIParams$ComponentInteraction = (RestAPIParams$ComponentInteraction) other;
        return this.type == restAPIParams$ComponentInteraction.type && this.channelId == restAPIParams$ComponentInteraction.channelId && this.applicationId == restAPIParams$ComponentInteraction.applicationId && m.areEqual(this.guildId, restAPIParams$ComponentInteraction.guildId) && this.messageId == restAPIParams$ComponentInteraction.messageId && m.areEqual(this.messageFlags, restAPIParams$ComponentInteraction.messageFlags) && m.areEqual(this.data, restAPIParams$ComponentInteraction.data) && m.areEqual(this.sessionId, restAPIParams$ComponentInteraction.sessionId) && m.areEqual(this.nonce, restAPIParams$ComponentInteraction.nonce);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final RestAPIParams$ComponentInteractionData getData() {
        return this.data;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getMessageFlags() {
        return this.messageFlags;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.type;
        long j2 = this.channelId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.applicationId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Long l = this.guildId;
        int iHashCode = l != null ? l.hashCode() : 0;
        long j4 = this.messageId;
        int i3 = (((i2 + iHashCode) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        Long l2 = this.messageFlags;
        int iHashCode2 = (i3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData = this.data;
        int iHashCode3 = (iHashCode2 + (restAPIParams$ComponentInteractionData != null ? restAPIParams$ComponentInteractionData.hashCode() : 0)) * 31;
        String str = this.sessionId;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.nonce;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ComponentInteraction(type=");
        sbU.append(this.type);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageFlags=");
        sbU.append(this.messageFlags);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", nonce=");
        return a.J(sbU, this.nonce, ")");
    }
}
