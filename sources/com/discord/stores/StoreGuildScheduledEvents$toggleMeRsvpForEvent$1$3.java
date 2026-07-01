package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreGuildScheduledEvents$toggleMeRsvpForEvent$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$3(StoreGuildScheduledEvents$toggleMeRsvpForEvent$1 storeGuildScheduledEvents$toggleMeRsvpForEvent$1) {
        super(1);
        this.this$0 = storeGuildScheduledEvents$toggleMeRsvpForEvent$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreGuildScheduledEvents$toggleMeRsvpForEvent$1 storeGuildScheduledEvents$toggleMeRsvpForEvent$1 = this.this$0;
        StoreGuildScheduledEvents storeGuildScheduledEvents = storeGuildScheduledEvents$toggleMeRsvpForEvent$1.this$0;
        StoreGuildScheduledEvents.access$processRsvpDelete(storeGuildScheduledEvents, StoreGuildScheduledEvents.access$findEventFromStore(storeGuildScheduledEvents, storeGuildScheduledEvents$toggleMeRsvpForEvent$1.$storeEvent), StoreGuildScheduledEvents.access$getUserStore$p(this.this$0.this$0).getMeSnapshot().getId());
        StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(this.this$0.this$0).remove(Long.valueOf(this.this$0.$eventId));
    }
}
