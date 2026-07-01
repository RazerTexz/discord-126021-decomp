package com.discord.stores;

import com.discord.api.guildmember.GuildMember;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$14 extends k implements Function1<GuildMember, Unit> {
    public StoreStream$initGatewaySocketListeners$14(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildMemberAdd", "handleGuildMemberAdd(Lcom/discord/api/guildmember/GuildMember;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember) {
        invoke2(guildMember);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildMember guildMember) {
        m.checkNotNullParameter(guildMember, "p1");
        StoreStream.access$handleGuildMemberAdd((StoreStream) this.receiver, guildMember);
    }
}
