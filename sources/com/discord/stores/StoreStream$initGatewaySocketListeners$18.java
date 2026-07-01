package com.discord.stores;

import com.discord.api.guildmember.GuildMemberRemove;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$18 extends k implements Function1<GuildMemberRemove, Unit> {
    public StoreStream$initGatewaySocketListeners$18(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildMemberRemove", "handleGuildMemberRemove(Lcom/discord/api/guildmember/GuildMemberRemove;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildMemberRemove guildMemberRemove) {
        invoke2(guildMemberRemove);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildMemberRemove guildMemberRemove) {
        m.checkNotNullParameter(guildMemberRemove, "p1");
        StoreStream.access$handleGuildMemberRemove((StoreStream) this.receiver, guildMemberRemove);
    }
}
