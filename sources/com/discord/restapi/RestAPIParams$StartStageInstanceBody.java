package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$StartStageInstanceBody {
    private final long channelId;
    private final String guildScheduledEventId;
    private final StageInstancePrivacyLevel privacyLevel;
    private final boolean sendStartNotification;
    private final String topic;

    public RestAPIParams$StartStageInstanceBody(long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        m.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
        this.channelId = j;
        this.topic = str;
        this.privacyLevel = stageInstancePrivacyLevel;
        this.sendStartNotification = z2;
        this.guildScheduledEventId = str2;
    }

    public static /* synthetic */ RestAPIParams$StartStageInstanceBody copy$default(RestAPIParams$StartStageInstanceBody restAPIParams$StartStageInstanceBody, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = restAPIParams$StartStageInstanceBody.channelId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = restAPIParams$StartStageInstanceBody.topic;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            stageInstancePrivacyLevel = restAPIParams$StartStageInstanceBody.privacyLevel;
        }
        StageInstancePrivacyLevel stageInstancePrivacyLevel2 = stageInstancePrivacyLevel;
        if ((i & 8) != 0) {
            z2 = restAPIParams$StartStageInstanceBody.sendStartNotification;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            str2 = restAPIParams$StartStageInstanceBody.guildScheduledEventId;
        }
        return restAPIParams$StartStageInstanceBody.copy(j2, str3, stageInstancePrivacyLevel2, z3, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSendStartNotification() {
        return this.sendStartNotification;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final RestAPIParams$StartStageInstanceBody copy(long channelId, String topic, StageInstancePrivacyLevel privacyLevel, boolean sendStartNotification, String guildScheduledEventId) {
        m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        m.checkNotNullParameter(privacyLevel, "privacyLevel");
        return new RestAPIParams$StartStageInstanceBody(channelId, topic, privacyLevel, sendStartNotification, guildScheduledEventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$StartStageInstanceBody)) {
            return false;
        }
        RestAPIParams$StartStageInstanceBody restAPIParams$StartStageInstanceBody = (RestAPIParams$StartStageInstanceBody) other;
        return this.channelId == restAPIParams$StartStageInstanceBody.channelId && m.areEqual(this.topic, restAPIParams$StartStageInstanceBody.topic) && m.areEqual(this.privacyLevel, restAPIParams$StartStageInstanceBody.privacyLevel) && this.sendStartNotification == restAPIParams$StartStageInstanceBody.sendStartNotification && m.areEqual(this.guildScheduledEventId, restAPIParams$StartStageInstanceBody.guildScheduledEventId);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    public final boolean getSendStartNotification() {
        return this.sendStartNotification;
    }

    public final String getTopic() {
        return this.topic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.topic;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
        int iHashCode2 = (iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
        boolean z2 = this.sendStartNotification;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (iHashCode2 + r0) * 31;
        String str2 = this.guildScheduledEventId;
        return i2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StartStageInstanceBody(channelId=");
        sbU.append(this.channelId);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", sendStartNotification=");
        sbU.append(this.sendStartNotification);
        sbU.append(", guildScheduledEventId=");
        return a.J(sbU, this.guildScheduledEventId, ")");
    }

    public /* synthetic */ RestAPIParams$StartStageInstanceBody(long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, stageInstancePrivacyLevel, z2, (i & 16) != 0 ? null : str2);
    }
}
