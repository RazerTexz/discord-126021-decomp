package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.f0._Sequences2;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel {
    public static final GuildIdsWithActiveEventsModel INSTANCE = new GuildIdsWithActiveEventsModel();

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StoreGuildScheduledEvents $storeGuildScheduledEvents;

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
        public static final class C02941 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Boolean> {
            public static final C02941 INSTANCE = new C02941();

            public C02941() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                List<GuildScheduledEvent> value = entry.getValue();
                if (!(value instanceof Collection) || !value.isEmpty()) {
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        if (((GuildScheduledEvent) it.next()).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Long> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Long.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                Intrinsics3.checkNotNullParameter(entry, "entry");
                return entry.getKey().longValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreGuildScheduledEvents storeGuildScheduledEvents) {
            super(0);
            this.$storeGuildScheduledEvents = storeGuildScheduledEvents;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(this.$storeGuildScheduledEvents.getAllGuildScheduledEvents()), C02941.INSTANCE), AnonymousClass2.INSTANCE));
        }
    }

    private GuildIdsWithActiveEventsModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithActiveEventsModel guildIdsWithActiveEventsModel, StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
        }
        if ((i & 2) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return guildIdsWithActiveEventsModel.observe(storeGuildScheduledEvents, observationDeck);
    }

    public final Observable<Set<Long>> observe(StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildScheduledEvents}, false, null, null, new AnonymousClass1(storeGuildScheduledEvents), 14, null);
    }
}
