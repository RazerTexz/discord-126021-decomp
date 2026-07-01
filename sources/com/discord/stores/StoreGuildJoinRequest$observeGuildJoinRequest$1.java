package com.discord.stores;

import com.discord.api.guildjoinrequest.GuildJoinRequest;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildJoinRequest$observeGuildJoinRequest$1 extends o implements Function0<GuildJoinRequest> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildJoinRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildJoinRequest$observeGuildJoinRequest$1(StoreGuildJoinRequest storeGuildJoinRequest, long j) {
        super(0);
        this.this$0 = storeGuildJoinRequest;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildJoinRequest invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildJoinRequest invoke() {
        return (GuildJoinRequest) StoreGuildJoinRequest.access$getGuildJoinRequestsSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
    }
}
