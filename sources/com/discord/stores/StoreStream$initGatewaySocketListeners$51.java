package com.discord.stores;

import com.discord.api.emoji.GuildEmojisUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$51 extends k implements Function1<GuildEmojisUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$51(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleEmojiUpdate", "handleEmojiUpdate(Lcom/discord/api/emoji/GuildEmojisUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildEmojisUpdate guildEmojisUpdate) {
        invoke2(guildEmojisUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildEmojisUpdate guildEmojisUpdate) {
        m.checkNotNullParameter(guildEmojisUpdate, "p1");
        StoreStream.access$handleEmojiUpdate((StoreStream) this.receiver, guildEmojisUpdate);
    }
}
