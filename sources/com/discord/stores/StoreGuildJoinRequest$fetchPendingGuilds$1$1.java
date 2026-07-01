package com.discord.stores;

import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildJoinRequest$fetchPendingGuilds$1$1 extends o implements Function1<List<? extends Guild>, Unit> {
    public final /* synthetic */ StoreGuildJoinRequest$fetchPendingGuilds$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildJoinRequest$fetchPendingGuilds$1$1(StoreGuildJoinRequest$fetchPendingGuilds$1 storeGuildJoinRequest$fetchPendingGuilds$1) {
        super(1);
        this.this$0 = storeGuildJoinRequest$fetchPendingGuilds$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Guild> list) {
        invoke2((List<Guild>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Guild> list) {
        m.checkNotNullParameter(list, "results");
        StoreGuildJoinRequest.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildJoinRequest$fetchPendingGuilds$1$1$1(this, list));
    }
}
