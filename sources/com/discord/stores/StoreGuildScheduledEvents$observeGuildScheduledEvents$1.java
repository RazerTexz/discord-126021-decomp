package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$observeGuildScheduledEvents$1 extends o implements Function0<List<? extends GuildScheduledEvent>> {
    public final /* synthetic */ boolean $filterInaccessible;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$observeGuildScheduledEvents$1(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2) {
        super(0);
        this.this$0 = storeGuildScheduledEvents;
        this.$guildId = j;
        this.$filterInaccessible = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends GuildScheduledEvent> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends GuildScheduledEvent> invoke2() {
        return this.this$0.getGuildScheduledEvents(this.$guildId, this.$filterInaccessible);
    }
}
