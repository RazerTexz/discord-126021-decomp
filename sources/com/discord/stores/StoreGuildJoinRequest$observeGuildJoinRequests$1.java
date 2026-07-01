package com.discord.stores;

import com.discord.api.guildjoinrequest.GuildJoinRequest;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildJoinRequest$observeGuildJoinRequests$1 extends o implements Function0<Map<Long, ? extends GuildJoinRequest>> {
    public final /* synthetic */ StoreGuildJoinRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildJoinRequest$observeGuildJoinRequests$1(StoreGuildJoinRequest storeGuildJoinRequest) {
        super(0);
        this.this$0 = storeGuildJoinRequest;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends GuildJoinRequest> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends GuildJoinRequest> invoke2() {
        return StoreGuildJoinRequest.access$getGuildJoinRequestsSnapshot$p(this.this$0);
    }
}
