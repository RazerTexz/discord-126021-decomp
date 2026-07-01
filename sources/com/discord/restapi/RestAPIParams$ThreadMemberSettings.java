package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelMuteConfig;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ThreadMemberSettings {
    private final Integer flags;
    private final ModelMuteConfig muteConfig;
    private final Boolean muted;

    public RestAPIParams$ThreadMemberSettings() {
        this(null, null, null, 7, null);
    }

    public RestAPIParams$ThreadMemberSettings(Integer num, Boolean bool, ModelMuteConfig modelMuteConfig) {
        this.flags = num;
        this.muted = bool;
        this.muteConfig = modelMuteConfig;
    }

    public static /* synthetic */ RestAPIParams$ThreadMemberSettings copy$default(RestAPIParams$ThreadMemberSettings restAPIParams$ThreadMemberSettings, Integer num, Boolean bool, ModelMuteConfig modelMuteConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            num = restAPIParams$ThreadMemberSettings.flags;
        }
        if ((i & 2) != 0) {
            bool = restAPIParams$ThreadMemberSettings.muted;
        }
        if ((i & 4) != 0) {
            modelMuteConfig = restAPIParams$ThreadMemberSettings.muteConfig;
        }
        return restAPIParams$ThreadMemberSettings.copy(num, bool, modelMuteConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getMuted() {
        return this.muted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public final RestAPIParams$ThreadMemberSettings copy(Integer flags, Boolean muted, ModelMuteConfig muteConfig) {
        return new RestAPIParams$ThreadMemberSettings(flags, muted, muteConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ThreadMemberSettings)) {
            return false;
        }
        RestAPIParams$ThreadMemberSettings restAPIParams$ThreadMemberSettings = (RestAPIParams$ThreadMemberSettings) other;
        return m.areEqual(this.flags, restAPIParams$ThreadMemberSettings.flags) && m.areEqual(this.muted, restAPIParams$ThreadMemberSettings.muted) && m.areEqual(this.muteConfig, restAPIParams$ThreadMemberSettings.muteConfig);
    }

    public final Integer getFlags() {
        return this.flags;
    }

    public final ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public final Boolean getMuted() {
        return this.muted;
    }

    public int hashCode() {
        Integer num = this.flags;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Boolean bool = this.muted;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        ModelMuteConfig modelMuteConfig = this.muteConfig;
        return iHashCode2 + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadMemberSettings(flags=");
        sbU.append(this.flags);
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", muteConfig=");
        sbU.append(this.muteConfig);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ RestAPIParams$ThreadMemberSettings(Integer num, Boolean bool, ModelMuteConfig modelMuteConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : modelMuteConfig);
    }
}
