package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$handleFetchRsvpUsersFailure$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$handleFetchRsvpUsersFailure$1(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(0);
        this.this$0 = storeGuildScheduledEvents;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(this.this$0, false);
        StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(this.this$0, true);
        this.this$0.markChanged();
    }
}
