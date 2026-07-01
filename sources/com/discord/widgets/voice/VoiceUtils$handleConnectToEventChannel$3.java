package com.discord.widgets.voice;

import b.c.a.a0.d;
import com.discord.api.channel.Channel;
import com.discord.app.AppPermissionsRequests;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils$handleConnectToEventChannel$3 extends o implements Function0<Unit> {
    public final /* synthetic */ AppPermissionsRequests $appPermissionsRequests;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Function0 $onEventStarted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUtils$handleConnectToEventChannel$3(AppPermissionsRequests appPermissionsRequests, Channel channel, Function0 function0) {
        super(0);
        this.$appPermissionsRequests = appPermissionsRequests;
        this.$channel = channel;
        this.$onEventStarted = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d.S1(this.$appPermissionsRequests, null, new VoiceUtils$handleConnectToEventChannel$3$1(this), 1, null);
    }
}
