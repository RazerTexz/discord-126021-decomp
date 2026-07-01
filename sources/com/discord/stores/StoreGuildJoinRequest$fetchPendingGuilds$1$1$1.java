package com.discord.stores;

import com.discord.api.guild.Guild;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildJoinRequest$fetchPendingGuilds$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $results;
    public final /* synthetic */ StoreGuildJoinRequest$fetchPendingGuilds$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildJoinRequest$fetchPendingGuilds$1$1$1(StoreGuildJoinRequest$fetchPendingGuilds$1$1 storeGuildJoinRequest$fetchPendingGuilds$1$1, List list) {
        super(0);
        this.this$0 = storeGuildJoinRequest$fetchPendingGuilds$1$1;
        this.$results = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        for (Guild guild : this.$results) {
            StoreGuildJoinRequest.access$getPendingGuilds$p(this.this$0.this$0.this$0).put(Long.valueOf(guild.getId()), new com.discord.models.guild.Guild(guild));
        }
        this.this$0.this$0.this$0.markChanged();
    }
}
