package com.discord.widgets.guildscheduledevent;

import com.discord.stores.StoreGuildScheduledEvents;
import d0.f0.q;
import d0.t.i0;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel$observe$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ StoreGuildScheduledEvents $storeGuildScheduledEvents;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIdsWithActiveEventsModel$observe$1(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(0);
        this.$storeGuildScheduledEvents = storeGuildScheduledEvents;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        return q.toSet(q.map(q.filter(i0.asSequence(this.$storeGuildScheduledEvents.getAllGuildScheduledEvents()), GuildIdsWithActiveEventsModel$observe$1$1.INSTANCE), GuildIdsWithActiveEventsModel$observe$1$2.INSTANCE));
    }
}
