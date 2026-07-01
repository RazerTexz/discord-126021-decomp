package com.discord.restapi;

import com.discord.models.domain.ModelMuteConfig;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserGuildSettings {
    private final Map<Long, RestAPIParams$UserGuildSettings$ChannelOverride> channelOverrides;
    private final Integer messageNotifications;
    private final Boolean mobilePush;
    private final ModelMuteConfig muteConfig;
    private final Boolean muted;
    private final Integer notifyHighlights;
    private final Boolean suppressEveryone;
    private final Boolean suppressRoles;

    public RestAPIParams$UserGuildSettings() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public RestAPIParams$UserGuildSettings(Boolean bool, Boolean bool2, Boolean bool3, ModelMuteConfig modelMuteConfig, Boolean bool4, Integer num, Map<Long, RestAPIParams$UserGuildSettings$ChannelOverride> map, Integer num2) {
        this.suppressEveryone = bool;
        this.suppressRoles = bool2;
        this.muted = bool3;
        this.muteConfig = modelMuteConfig;
        this.mobilePush = bool4;
        this.messageNotifications = num;
        this.channelOverrides = map;
        this.notifyHighlights = num2;
    }

    public final Map<Long, RestAPIParams$UserGuildSettings$ChannelOverride> getChannelOverrides() {
        return this.channelOverrides;
    }

    public final Integer getMessageNotifications() {
        return this.messageNotifications;
    }

    public final Boolean getMobilePush() {
        return this.mobilePush;
    }

    public final ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public final Boolean getMuted() {
        return this.muted;
    }

    public final Integer getNotifyHighlights() {
        return this.notifyHighlights;
    }

    public final Boolean getSuppressEveryone() {
        return this.suppressEveryone;
    }

    public final Boolean getSuppressRoles() {
        return this.suppressRoles;
    }

    public /* synthetic */ RestAPIParams$UserGuildSettings(Boolean bool, Boolean bool2, Boolean bool3, ModelMuteConfig modelMuteConfig, Boolean bool4, Integer num, Map map, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : modelMuteConfig, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : map, (i & 128) == 0 ? num2 : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RestAPIParams$UserGuildSettings(long j, RestAPIParams$UserGuildSettings$ChannelOverride restAPIParams$UserGuildSettings$ChannelOverride) {
        this(null, null, null, null, null, null, g0.mapOf(o.to(Long.valueOf(j), restAPIParams$UserGuildSettings$ChannelOverride)), null, Opcodes.ATHROW, null);
        m.checkNotNullParameter(restAPIParams$UserGuildSettings$ChannelOverride, "channelOverride");
    }
}
