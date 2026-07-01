package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$74 extends k implements Function1<GuildScheduledEvent, Unit> {
    public StoreStream$initGatewaySocketListeners$74(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildScheduledEventDelete", "handleGuildScheduledEventDelete(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
        invoke2(guildScheduledEvent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "p1");
        StoreStream.access$handleGuildScheduledEventDelete((StoreStream) this.receiver, guildScheduledEvent);
    }
}
