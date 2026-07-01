package com.discord.stores;

import com.discord.api.guild.Guild;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$6 extends k implements Function1<Guild, Unit> {
    public StoreStream$initGatewaySocketListeners$6(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildUpdate", "handleGuildUpdate(Lcom/discord/api/guild/Guild;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "p1");
        StoreStream.access$handleGuildUpdate((StoreStream) this.receiver, guild);
    }
}
