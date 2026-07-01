package com.discord.stores;

import com.discord.api.sticker.GuildStickersUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$52 extends k implements Function1<GuildStickersUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$52(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleStickersUpdate", "handleStickersUpdate(Lcom/discord/api/sticker/GuildStickersUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildStickersUpdate guildStickersUpdate) {
        invoke2(guildStickersUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildStickersUpdate guildStickersUpdate) {
        m.checkNotNullParameter(guildStickersUpdate, "p1");
        StoreStream.access$handleStickersUpdate((StoreStream) this.receiver, guildStickersUpdate);
    }
}
