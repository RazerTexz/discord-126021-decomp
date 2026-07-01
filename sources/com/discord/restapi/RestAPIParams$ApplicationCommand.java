package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.commands.ApplicationCommandData;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ApplicationCommand {
    private final String applicationId;
    private final String channelId;
    private final ApplicationCommandData data;
    private final String guildId;
    private final String nonce;
    private final String sessionId;
    private final long type;

    public RestAPIParams$ApplicationCommand(long j, String str, String str2, String str3, ApplicationCommandData applicationCommandData, String str4, String str5) {
        m.checkNotNullParameter(str, "channelId");
        m.checkNotNullParameter(str2, "applicationId");
        m.checkNotNullParameter(applicationCommandData, "data");
        m.checkNotNullParameter(str5, "nonce");
        this.type = j;
        this.channelId = str;
        this.applicationId = str2;
        this.guildId = str3;
        this.data = applicationCommandData;
        this.sessionId = str4;
        this.nonce = str5;
    }

    public static /* synthetic */ RestAPIParams$ApplicationCommand copy$default(RestAPIParams$ApplicationCommand restAPIParams$ApplicationCommand, long j, String str, String str2, String str3, ApplicationCommandData applicationCommandData, String str4, String str5, int i, Object obj) {
        return restAPIParams$ApplicationCommand.copy((i & 1) != 0 ? restAPIParams$ApplicationCommand.type : j, (i & 2) != 0 ? restAPIParams$ApplicationCommand.channelId : str, (i & 4) != 0 ? restAPIParams$ApplicationCommand.applicationId : str2, (i & 8) != 0 ? restAPIParams$ApplicationCommand.guildId : str3, (i & 16) != 0 ? restAPIParams$ApplicationCommand.data : applicationCommandData, (i & 32) != 0 ? restAPIParams$ApplicationCommand.sessionId : str4, (i & 64) != 0 ? restAPIParams$ApplicationCommand.nonce : str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ApplicationCommandData getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public final RestAPIParams$ApplicationCommand copy(long type, String channelId, String applicationId, String guildId, ApplicationCommandData data, String sessionId, String nonce) {
        m.checkNotNullParameter(channelId, "channelId");
        m.checkNotNullParameter(applicationId, "applicationId");
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(nonce, "nonce");
        return new RestAPIParams$ApplicationCommand(type, channelId, applicationId, guildId, data, sessionId, nonce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ApplicationCommand)) {
            return false;
        }
        RestAPIParams$ApplicationCommand restAPIParams$ApplicationCommand = (RestAPIParams$ApplicationCommand) other;
        return this.type == restAPIParams$ApplicationCommand.type && m.areEqual(this.channelId, restAPIParams$ApplicationCommand.channelId) && m.areEqual(this.applicationId, restAPIParams$ApplicationCommand.applicationId) && m.areEqual(this.guildId, restAPIParams$ApplicationCommand.guildId) && m.areEqual(this.data, restAPIParams$ApplicationCommand.data) && m.areEqual(this.sessionId, restAPIParams$ApplicationCommand.sessionId) && m.areEqual(this.nonce, restAPIParams$ApplicationCommand.nonce);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final ApplicationCommandData getData() {
        return this.data;
    }

    public final String getGuildId() {
        return this.guildId;
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
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.channelId;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.applicationId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ApplicationCommandData applicationCommandData = this.data;
        int iHashCode4 = (iHashCode3 + (applicationCommandData != null ? applicationCommandData.hashCode() : 0)) * 31;
        String str4 = this.sessionId;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nonce;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationCommand(type=");
        sbU.append(this.type);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", nonce=");
        return a.J(sbU, this.nonce, ")");
    }
}
