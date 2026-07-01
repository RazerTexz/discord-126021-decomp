package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1 extends o implements Function1<List<? extends GuildScheduledEvent>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1(StoreGuildScheduledEvents storeGuildScheduledEvents, long j) {
        super(1);
        this.this$0 = storeGuildScheduledEvents;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEvent> list) {
        invoke2((List<GuildScheduledEvent>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<GuildScheduledEvent> list) {
        m.checkNotNullParameter(list, "events");
        StoreGuildScheduledEvents.access$getDispatcher$p(this.this$0).schedule(new StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1$1(this, list));
    }
}
