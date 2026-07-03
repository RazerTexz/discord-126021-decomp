package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12138i0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel {
    public static final GuildIdsWithActiveEventsModel INSTANCE = new GuildIdsWithActiveEventsModel();

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1 */
    /* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
    public static final class C88091 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StoreGuildScheduledEvents $storeGuildScheduledEvents;

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                C12238m.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
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
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Long> {
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
                C12238m.checkNotNullParameter(entry, "entry");
                return entry.getKey().longValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88091(StoreGuildScheduledEvents storeGuildScheduledEvents) {
            super(0);
            this.$storeGuildScheduledEvents = storeGuildScheduledEvents;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return C12078q.toSet(C12078q.map(C12078q.filter(C12138i0.asSequence(this.$storeGuildScheduledEvents.getAllGuildScheduledEvents()), AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
        }
    }

    private GuildIdsWithActiveEventsModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithActiveEventsModel guildIdsWithActiveEventsModel, StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
        }
        if ((i & 2) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return guildIdsWithActiveEventsModel.observe(storeGuildScheduledEvents, observationDeck);
    }

    public final Observable<Set<Long>> observe(StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildScheduledEvents}, false, null, null, new C88091(storeGuildScheduledEvents), 14, null);
    }
}
