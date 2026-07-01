package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ModalInteraction {
    private final long applicationId;
    private final long channelId;
    private final RestAPIParams$ModalInteractionData data;
    private final Long guildId;
    private final Long messageId;
    private final long nonce;
    private final String sessionId;
    private final long type;

    public RestAPIParams$ModalInteraction(long j, long j2, Long l, long j3, Long l2, String str, long j4, RestAPIParams$ModalInteractionData restAPIParams$ModalInteractionData) {
        m.checkNotNullParameter(restAPIParams$ModalInteractionData, "data");
        this.type = j;
        this.applicationId = j2;
        this.messageId = l;
        this.channelId = j3;
        this.guildId = l2;
        this.sessionId = str;
        this.nonce = j4;
        this.data = restAPIParams$ModalInteractionData;
    }

    public static /* synthetic */ RestAPIParams$ModalInteraction copy$default(RestAPIParams$ModalInteraction restAPIParams$ModalInteraction, long j, long j2, Long l, long j3, Long l2, String str, long j4, RestAPIParams$ModalInteractionData restAPIParams$ModalInteractionData, int i, Object obj) {
        return restAPIParams$ModalInteraction.copy((i & 1) != 0 ? restAPIParams$ModalInteraction.type : j, (i & 2) != 0 ? restAPIParams$ModalInteraction.applicationId : j2, (i & 4) != 0 ? restAPIParams$ModalInteraction.messageId : l, (i & 8) != 0 ? restAPIParams$ModalInteraction.channelId : j3, (i & 16) != 0 ? restAPIParams$ModalInteraction.guildId : l2, (i & 32) != 0 ? restAPIParams$ModalInteraction.sessionId : str, (i & 64) != 0 ? restAPIParams$ModalInteraction.nonce : j4, (i & 128) != 0 ? restAPIParams$ModalInteraction.data : restAPIParams$ModalInteractionData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final RestAPIParams$ModalInteractionData getData() {
        return this.data;
    }

    public final RestAPIParams$ModalInteraction copy(long type, long applicationId, Long messageId, long channelId, Long guildId, String sessionId, long nonce, RestAPIParams$ModalInteractionData data) {
        m.checkNotNullParameter(data, "data");
        return new RestAPIParams$ModalInteraction(type, applicationId, messageId, channelId, guildId, sessionId, nonce, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ModalInteraction)) {
            return false;
        }
        RestAPIParams$ModalInteraction restAPIParams$ModalInteraction = (RestAPIParams$ModalInteraction) other;
        return this.type == restAPIParams$ModalInteraction.type && this.applicationId == restAPIParams$ModalInteraction.applicationId && m.areEqual(this.messageId, restAPIParams$ModalInteraction.messageId) && this.channelId == restAPIParams$ModalInteraction.channelId && m.areEqual(this.guildId, restAPIParams$ModalInteraction.guildId) && m.areEqual(this.sessionId, restAPIParams$ModalInteraction.sessionId) && this.nonce == restAPIParams$ModalInteraction.nonce && m.areEqual(this.data, restAPIParams$ModalInteraction.data);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final RestAPIParams$ModalInteractionData getData() {
        return this.data;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final long getNonce() {
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
        long j2 = this.applicationId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Long l = this.messageId;
        int iHashCode = l != null ? l.hashCode() : 0;
        long j3 = this.channelId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (i2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.sessionId;
        int iHashCode3 = str != null ? str.hashCode() : 0;
        long j4 = this.nonce;
        int i3 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        RestAPIParams$ModalInteractionData restAPIParams$ModalInteractionData = this.data;
        return i3 + (restAPIParams$ModalInteractionData != null ? restAPIParams$ModalInteractionData.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModalInteraction(type=");
        sbU.append(this.type);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
