package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$observeGuildScheduledEvent$1 extends o implements Function0<GuildScheduledEvent> {
    public final /* synthetic */ Long $eventId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$observeGuildScheduledEvent$1(StoreGuildScheduledEvents storeGuildScheduledEvents, Long l, Long l2) {
        super(0);
        this.this$0 = storeGuildScheduledEvents;
        this.$eventId = l;
        this.$guildId = l2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEvent invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEvent invoke() {
        Long l = this.$eventId;
        if (l != null) {
            return this.this$0.findEventFromStore(l.longValue(), this.$guildId);
        }
        return null;
    }
}
