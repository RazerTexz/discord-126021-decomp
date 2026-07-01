package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ StoreGuildScheduledEvents$toggleMeRsvpForEvent$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$2(StoreGuildScheduledEvents$toggleMeRsvpForEvent$1 storeGuildScheduledEvents$toggleMeRsvpForEvent$1) {
        super(1);
        this.this$0 = storeGuildScheduledEvents$toggleMeRsvpForEvent$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r3) {
        StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(this.this$0.this$0).remove(Long.valueOf(this.this$0.$eventId));
    }
}
