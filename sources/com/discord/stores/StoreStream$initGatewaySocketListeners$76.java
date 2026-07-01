package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$76 extends k implements Function1<GuildScheduledEventUserUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$76(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "guildScheduledEventUserRemove", "guildScheduledEventUserRemove(Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        invoke2(guildScheduledEventUserUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        m.checkNotNullParameter(guildScheduledEventUserUpdate, "p1");
        StoreStream.access$guildScheduledEventUserRemove((StoreStream) this.receiver, guildScheduledEventUserUpdate);
    }
}
