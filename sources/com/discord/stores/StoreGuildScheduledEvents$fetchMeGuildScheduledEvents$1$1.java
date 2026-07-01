package com.discord.stores;

import com.discord.api.guildscheduledevent.GuildScheduledEventMeUser;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $eventUsers;
    public final /* synthetic */ StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1$1(StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1 storeGuildScheduledEvents$fetchMeGuildScheduledEvents$1, List list) {
        super(0);
        this.this$0 = storeGuildScheduledEvents$fetchMeGuildScheduledEvents$1;
        this.$eventUsers = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List list = this.$eventUsers;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((GuildScheduledEventMeUser) it.next()).getGuildScheduledEventId()));
        }
        StoreGuildScheduledEvents.access$getMeGuildScheduledEventIds$p(this.this$0.this$0).put(Long.valueOf(this.this$0.$guildId), u.toMutableSet(arrayList));
        StoreGuildScheduledEvents.access$getMeGuildScheduledEventsFetches$p(this.this$0.this$0).add(Long.valueOf(this.this$0.$guildId));
        this.this$0.this$0.markChanged();
    }
}
