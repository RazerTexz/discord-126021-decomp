package com.discord.stores;

import d0.t.u;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $events;
    public final /* synthetic */ StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1$1(StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1 storeGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1, List list) {
        super(0);
        this.this$0 = storeGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1;
        this.$events = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildScheduledEvents.access$getGuildScheduledEvents$p(this.this$0.this$0).put(Long.valueOf(this.this$0.$guildId), u.toMutableList((Collection) this.$events));
        StoreGuildScheduledEvents.access$getGuildScheduledEventsFetchTimestamps$p(this.this$0.this$0).put(Long.valueOf(this.this$0.$guildId), Long.valueOf(StoreGuildScheduledEvents.access$getClock$p(this.this$0.this$0).currentTimeMillis()));
        this.this$0.this$0.markChanged();
    }
}
