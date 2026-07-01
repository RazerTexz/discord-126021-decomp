package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$1(StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1 storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1) {
        super(1);
        this.this$0 = storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreGuildScheduledEvents.access$handleFetchRsvpUsersFailure(this.this$0.this$0);
    }
}
