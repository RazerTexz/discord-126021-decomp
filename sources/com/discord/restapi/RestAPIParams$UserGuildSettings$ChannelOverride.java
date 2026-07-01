package com.discord.restapi;

import com.discord.models.domain.ModelMuteConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserGuildSettings$ChannelOverride {
    private final Integer flags;
    private final Integer messageNotifications;
    private final ModelMuteConfig muteConfig;
    private final Boolean muted;

    public RestAPIParams$UserGuildSettings$ChannelOverride(Boolean bool, ModelMuteConfig modelMuteConfig, Integer num, Integer num2) {
        this.muted = bool;
        this.muteConfig = modelMuteConfig;
        this.messageNotifications = num;
        this.flags = num2;
    }

    public final Integer getFlags() {
        return this.flags;
    }

    public final Integer getMessageNotifications() {
        return this.messageNotifications;
    }

    public final ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public final Boolean getMuted() {
        return this.muted;
    }

    public /* synthetic */ RestAPIParams$UserGuildSettings$ChannelOverride(Boolean bool, ModelMuteConfig modelMuteConfig, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, modelMuteConfig, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }

    public RestAPIParams$UserGuildSettings$ChannelOverride(Integer num, Integer num2) {
        this(null, null, num, num2);
    }
}
