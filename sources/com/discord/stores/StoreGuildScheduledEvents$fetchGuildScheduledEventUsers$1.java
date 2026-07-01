package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n0;
import d0.z.d.o;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $eventId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, long j2) {
        super(0);
        this.this$0 = storeGuildScheduledEvents;
        this.$guildId = j;
        this.$eventId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Set setEmptySet = (Set) StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(this.this$0).get(Long.valueOf(this.$guildId));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        if (setEmptySet.contains(Long.valueOf(this.$eventId))) {
            return;
        }
        StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(this.this$0, true);
        StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(this.this$0, false);
        this.this$0.markChanged();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getGuildScheduledEventUsers(this.$guildId, this.$eventId, 100, true, true), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$1(this), (Function0) null, (Function0) null, new StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2(this), 54, (Object) null);
    }
}
