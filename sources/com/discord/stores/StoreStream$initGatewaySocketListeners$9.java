package com.discord.stores;

import com.discord.api.role.GuildRoleDelete;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$9 extends k implements Function1<GuildRoleDelete, Unit> {
    public StoreStream$initGatewaySocketListeners$9(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildRoleDelete", "handleGuildRoleDelete(Lcom/discord/api/role/GuildRoleDelete;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleDelete guildRoleDelete) {
        invoke2(guildRoleDelete);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleDelete guildRoleDelete) {
        m.checkNotNullParameter(guildRoleDelete, "p1");
        StoreStream.access$handleGuildRoleDelete((StoreStream) this.receiver, guildRoleDelete);
    }
}
