package com.discord.stores;

import com.discord.api.guildjoinrequest.GuildJoinRequestCreateOrUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$15 extends k implements Function1<GuildJoinRequestCreateOrUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$15(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildJoinRequestCreateOrUpdate", "handleGuildJoinRequestCreateOrUpdate(Lcom/discord/api/guildjoinrequest/GuildJoinRequestCreateOrUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildJoinRequestCreateOrUpdate guildJoinRequestCreateOrUpdate) {
        invoke2(guildJoinRequestCreateOrUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildJoinRequestCreateOrUpdate guildJoinRequestCreateOrUpdate) {
        m.checkNotNullParameter(guildJoinRequestCreateOrUpdate, "p1");
        ((StoreStream) this.receiver).handleGuildJoinRequestCreateOrUpdate(guildJoinRequestCreateOrUpdate);
    }
}
