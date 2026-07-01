package com.discord.stores;

import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.Success;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$fetchGuildScheduledEventsForChannel$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ RestCallState $response;
    public final /* synthetic */ StoreDirectories$fetchGuildScheduledEventsForChannel$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$fetchGuildScheduledEventsForChannel$1$1(StoreDirectories$fetchGuildScheduledEventsForChannel$1 storeDirectories$fetchGuildScheduledEventsForChannel$1, RestCallState restCallState) {
        super(0);
        this.this$0 = storeDirectories$fetchGuildScheduledEventsForChannel$1;
        this.$response = restCallState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreDirectories.access$getDirectoryGuildScheduledEventsMap$p(this.this$0.this$0).put(Long.valueOf(this.this$0.$channelId), this.$response);
        RestCallState restCallState = this.$response;
        if (restCallState instanceof Success) {
            Iterable iterable = (Iterable) ((Success) restCallState).invoke();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                GuildScheduledEvent guildScheduledEvent = ((DirectoryEntryEvent) it.next()).getGuildScheduledEvent();
                if (!(guildScheduledEvent.getUserRsvp() != null)) {
                    guildScheduledEvent = null;
                }
                Pair pair = guildScheduledEvent != null ? d0.o.to(Long.valueOf(guildScheduledEvent.getGuildId()), Long.valueOf(guildScheduledEvent.getId())) : null;
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            StoreDirectories.access$getGuildScheduledEventsStore$p(this.this$0.this$0).addMeRsvpsForEvent(arrayList);
        }
        this.this$0.this$0.markChanged();
    }
}
