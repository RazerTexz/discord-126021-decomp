package com.discord.stores;

import com.discord.widgets.guildscheduledevent.GuildScheduledEventUser;
import d0.f0.q;
import d0.t.u;
import d0.z.d.o;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $apiGuildScheduledEventUsers;
    public final /* synthetic */ StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1(StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2 storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2, List list) {
        super(0);
        this.this$0 = storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2;
        this.$apiGuildScheduledEventUsers = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildScheduledEvents.access$getUserStore$p(this.this$0.this$0.this$0).handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers);
        StoreGuildScheduledEvents.access$getGuildsStore$p(this.this$0.this$0.this$0).handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers, this.this$0.this$0.$guildId);
        HashMap map = (HashMap) StoreGuildScheduledEvents.access$getGuildScheduledEventUsers$p(this.this$0.this$0.this$0).get(Long.valueOf(this.this$0.this$0.$eventId));
        if (map == null) {
            map = new HashMap();
        }
        for (GuildScheduledEventUser guildScheduledEventUser : q.mapNotNull(u.asSequence(this.$apiGuildScheduledEventUsers), new StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1$1(this))) {
            map.put(Long.valueOf(guildScheduledEventUser.getUser().getId()), guildScheduledEventUser);
        }
        StoreGuildScheduledEvents.access$getGuildScheduledEventUsers$p(this.this$0.this$0.this$0).put(Long.valueOf(this.this$0.this$0.$eventId), map);
        Set linkedHashSet = (Set) StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(this.this$0.this$0.this$0).get(Long.valueOf(this.this$0.this$0.$guildId));
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
        }
        linkedHashSet.add(Long.valueOf(this.this$0.this$0.$eventId));
        StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(this.this$0.this$0.this$0).put(Long.valueOf(this.this$0.this$0.$guildId), linkedHashSet);
        StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(this.this$0.this$0.this$0, false);
        StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(this.this$0.this$0.this$0, false);
        this.this$0.this$0.this$0.markChanged();
    }
}
