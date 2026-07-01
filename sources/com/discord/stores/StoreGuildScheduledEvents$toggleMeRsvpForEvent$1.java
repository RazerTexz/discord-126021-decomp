package com.discord.stores;

import android.content.Context;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$toggleMeRsvpForEvent$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $eventId;
    public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
    public final /* synthetic */ GuildScheduledEvent $storeEvent;
    public final /* synthetic */ StoreGuildScheduledEvents this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$toggleMeRsvpForEvent$1(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j, GuildScheduledEvent guildScheduledEvent2) {
        super(0);
        this.this$0 = storeGuildScheduledEvents;
        this.$guildScheduledEvent = guildScheduledEvent;
        this.$eventId = j;
        this.$storeEvent = guildScheduledEvent2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.isMeRsvpedToEvent(this.$guildScheduledEvent.getGuildId(), this.$eventId)) {
            StoreGuildScheduledEvents storeGuildScheduledEvents = this.this$0;
            StoreGuildScheduledEvents.access$processRsvpDelete(storeGuildScheduledEvents, this.$storeEvent, StoreGuildScheduledEvents.access$getUserStore$p(storeGuildScheduledEvents).getMeSnapshot().getId());
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteGuildScheduledEventRsvp(this.$storeEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$1(this), (Function0) null, (Function0) null, new StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$2(this), 54, (Object) null);
        } else {
            StoreGuildScheduledEvents storeGuildScheduledEvents2 = this.this$0;
            StoreGuildScheduledEvents.access$processRsvpCreate(storeGuildScheduledEvents2, this.$storeEvent, StoreGuildScheduledEvents.access$getUserStore$p(storeGuildScheduledEvents2).getMeSnapshot().getId());
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createGuildScheduledEventRsvp(this.$guildScheduledEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$3(this), (Function0) null, (Function0) null, new StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$4(this), 54, (Object) null);
        }
    }
}
