package com.discord.stores;

import com.discord.api.guildjoinrequest.GuildJoinRequestDelete;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$16 extends k implements Function1<GuildJoinRequestDelete, Unit> {
    public StoreStream$initGatewaySocketListeners$16(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildJoinRequestDelete", "handleGuildJoinRequestDelete(Lcom/discord/api/guildjoinrequest/GuildJoinRequestDelete;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildJoinRequestDelete guildJoinRequestDelete) {
        invoke2(guildJoinRequestDelete);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildJoinRequestDelete guildJoinRequestDelete) {
        m.checkNotNullParameter(guildJoinRequestDelete, "p1");
        ((StoreStream) this.receiver).handleGuildJoinRequestDelete(guildJoinRequestDelete);
    }
}
