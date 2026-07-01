package com.discord.stores;

import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplicationCommandsQuery$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ String $query;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestApplicationCommandsQuery$1(StoreApplicationCommands storeApplicationCommands, Long l, String str) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$guildId = l;
        this.$query = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(this.this$0);
        StoreApplicationCommands.access$setQueryNonce$p(this.this$0, strAccess$generateNonce);
        if (!m.areEqual(StoreApplicationCommands.access$getQueryGuildId$p(this.this$0), this.$guildId)) {
            StoreApplicationCommands.access$getQueryCommands$p(this.this$0).clear();
            this.this$0.markChanged(StoreApplicationCommands.Companion.getQueryCommandsUpdate());
        }
        StoreApplicationCommands.access$setQueryGuildId$p(this.this$0, this.$guildId);
        StoreApplicationCommands.access$setQuery$p(this.this$0, this.$query);
        Long l = this.$guildId;
        if (l == null || l.longValue() <= 0) {
            StoreApplicationCommands.access$handleQueryCommandsUpdate(this.this$0, n.emptyList());
        } else {
            StoreGatewayConnection.requestApplicationCommands$default(StoreApplicationCommands.access$getStoreGatewayConnection$p(this.this$0), this.$guildId.longValue(), strAccess$generateNonce, false, this.$query, null, 20, null, 80, null);
        }
    }
}
