package com.discord.gateway;

import b.d.b.a.a;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload$VoiceStateUpdate;
import com.discord.gateway.io.OutgoingPayload$VoiceStateUpdateNoPreferredRegion;
import com.discord.gateway.opcodes.Opcode;
import com.discord.utilities.logging.Logger;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$voiceStateUpdate$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ String $preferredRegion;
    public final /* synthetic */ boolean $selfDeaf;
    public final /* synthetic */ boolean $selfMute;
    public final /* synthetic */ boolean $selfVideo;
    public final /* synthetic */ boolean $shouldIncludePreferredRegion;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$voiceStateUpdate$1(GatewaySocket gatewaySocket, Long l, Long l2, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$guildId = l;
        this.$channelId = l2;
        this.$selfMute = z2;
        this.$selfDeaf = z3;
        this.$preferredRegion = str;
        this.$shouldIncludePreferredRegion = z4;
        this.$selfVideo = z5;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GatewaySocket$Companion gatewaySocket$Companion = GatewaySocket.Companion;
        Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(this.this$0);
        StringBuilder sbU = a.U("Sending voice state update for guild [");
        sbU.append(this.$guildId);
        sbU.append("] and channel [");
        sbU.append(this.$channelId);
        sbU.append("]. ");
        sbU.append("Muted: ");
        sbU.append(this.$selfMute);
        sbU.append(", deafened: ");
        sbU.append(this.$selfDeaf);
        sbU.append(", preferredRegion: ");
        sbU.append(this.$preferredRegion);
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
        GatewaySocket.send$default(this.this$0, new Outgoing(Opcode.VOICE_STATE_UPDATE, this.$shouldIncludePreferredRegion ? new OutgoingPayload$VoiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion) : new OutgoingPayload$VoiceStateUpdateNoPreferredRegion(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo)), false, null, 6, null);
    }
}
