package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$voiceStateUpdate$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ String $preferredRegion;
    public final /* synthetic */ boolean $selfDeaf;
    public final /* synthetic */ boolean $selfMute;
    public final /* synthetic */ boolean $selfVideo;
    public final /* synthetic */ boolean $shouldIncludePreferredRegion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$voiceStateUpdate$1(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, boolean z5) {
        super(1);
        this.$guildId = l;
        this.$channelId = l2;
        this.$selfMute = z2;
        this.$selfDeaf = z3;
        this.$selfVideo = z4;
        this.$preferredRegion = str;
        this.$shouldIncludePreferredRegion = z5;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        gatewaySocket.voiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion, this.$shouldIncludePreferredRegion);
    }
}
