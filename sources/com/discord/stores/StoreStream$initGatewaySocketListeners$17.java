package com.discord.stores;

import com.discord.api.guildmember.GuildMembersChunk;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$17 extends k implements Function1<GuildMembersChunk, Unit> {
    public StoreStream$initGatewaySocketListeners$17(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildMembersChunk", "handleGuildMembersChunk(Lcom/discord/api/guildmember/GuildMembersChunk;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildMembersChunk guildMembersChunk) {
        invoke2(guildMembersChunk);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildMembersChunk guildMembersChunk) {
        m.checkNotNullParameter(guildMembersChunk, "p1");
        StoreStream.access$handleGuildMembersChunk((StoreStream) this.receiver, guildMembersChunk);
    }
}
