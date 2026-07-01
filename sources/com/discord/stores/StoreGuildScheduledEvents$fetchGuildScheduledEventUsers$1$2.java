package com.discord.stores;

import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2 extends o implements Function1<List<? extends ApiGuildScheduledEventUser>, Unit> {
    public final /* synthetic */ StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2(StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1 storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1) {
        super(1);
        this.this$0 = storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApiGuildScheduledEventUser> list) {
        invoke2((List<ApiGuildScheduledEventUser>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ApiGuildScheduledEventUser> list) {
        m.checkNotNullParameter(list, "apiGuildScheduledEventUsers");
        StoreGuildScheduledEvents.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1(this, list));
    }
}
