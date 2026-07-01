package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UpdateStageInstanceBody {
    private final StageInstancePrivacyLevel privacyLevel;
    private final String topic;

    public RestAPIParams$UpdateStageInstanceBody() {
        this(null, null, 3, null);
    }

    public RestAPIParams$UpdateStageInstanceBody(String str, StageInstancePrivacyLevel stageInstancePrivacyLevel) {
        this.topic = str;
        this.privacyLevel = stageInstancePrivacyLevel;
    }

    public static /* synthetic */ RestAPIParams$UpdateStageInstanceBody copy$default(RestAPIParams$UpdateStageInstanceBody restAPIParams$UpdateStageInstanceBody, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$UpdateStageInstanceBody.topic;
        }
        if ((i & 2) != 0) {
            stageInstancePrivacyLevel = restAPIParams$UpdateStageInstanceBody.privacyLevel;
        }
        return restAPIParams$UpdateStageInstanceBody.copy(str, stageInstancePrivacyLevel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    public final RestAPIParams$UpdateStageInstanceBody copy(String topic, StageInstancePrivacyLevel privacyLevel) {
        return new RestAPIParams$UpdateStageInstanceBody(topic, privacyLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$UpdateStageInstanceBody)) {
            return false;
        }
        RestAPIParams$UpdateStageInstanceBody restAPIParams$UpdateStageInstanceBody = (RestAPIParams$UpdateStageInstanceBody) other;
        return m.areEqual(this.topic, restAPIParams$UpdateStageInstanceBody.topic) && m.areEqual(this.privacyLevel, restAPIParams$UpdateStageInstanceBody.privacyLevel);
    }

    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    public final String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        String str = this.topic;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
        return iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdateStageInstanceBody(topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ RestAPIParams$UpdateStageInstanceBody(String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : stageInstancePrivacyLevel);
    }
}
