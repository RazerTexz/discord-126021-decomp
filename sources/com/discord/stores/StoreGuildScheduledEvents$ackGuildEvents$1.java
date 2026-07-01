package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$ackGuildEvents$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildScheduledEvent $mostRecentEvent;
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$ackGuildEvents$1(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        super(1);
        this.this$0 = storeGuildScheduledEvents;
        this.$mostRecentEvent = guildScheduledEvent;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r4) {
        StoreGuildScheduledEvents.access$getLastAckedGuildScheduledEventIds$p(this.this$0).put(Long.valueOf(this.$guildId), Long.valueOf(this.$mostRecentEvent.getId()));
    }
}
