package com.discord.stores;

import com.discord.api.role.GuildRoleUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$8 extends k implements Function1<GuildRoleUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$8(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildRoleUpdate", "handleGuildRoleUpdate(Lcom/discord/api/role/GuildRoleUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleUpdate guildRoleUpdate) {
        invoke2(guildRoleUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleUpdate guildRoleUpdate) {
        m.checkNotNullParameter(guildRoleUpdate, "p1");
        StoreStream.access$handleGuildRoleUpdate((StoreStream) this.receiver, guildRoleUpdate);
    }
}
