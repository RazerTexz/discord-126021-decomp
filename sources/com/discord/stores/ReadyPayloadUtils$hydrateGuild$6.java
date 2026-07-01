package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ReadyPayloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReadyPayloadUtils$hydrateGuild$6 extends o implements Function2<Channel, Channel, Channel> {
    public static final ReadyPayloadUtils$hydrateGuild$6 INSTANCE = new ReadyPayloadUtils$hydrateGuild$6();

    public ReadyPayloadUtils$hydrateGuild$6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Channel invoke(Channel channel, Channel channel2) {
        return invoke2(channel, channel2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Channel invoke2(Channel channel, Channel channel2) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channel2, "channelUpdate");
        return ReadyPayloadUtils.access$hydrate(ReadyPayloadUtils.INSTANCE, channel, channel2);
    }
}
