package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventMeUser;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelPayload;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUser;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents extends StoreV2 {
    public static final long FETCH_GUILD_EVENTS_THRESHOLD = 1800000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final HashMap<Long, HashMap<Long, GuildScheduledEventUser>> guildScheduledEventUsers;
    private final HashMap<Long, Set<Long>> guildScheduledEventUsersFetches;
    private Map<Long, ? extends Map<Long, GuildScheduledEventUser>> guildScheduledEventUsersSnapshot;
    private final HashMap<Long, List<GuildScheduledEvent>> guildScheduledEvents;
    private final HashMap<Long, Long> guildScheduledEventsFetchTimestamps;
    private Map<Long, ? extends List<GuildScheduledEvent>> guildScheduledEventsSnapshot;
    private final StoreGuilds guildsStore;
    private boolean isFetchingGuildScheduledEventUsers;
    private boolean isGuildScheduledEventUsersError;
    private final HashMap<Long, Long> lastAckedGuildScheduledEventIds;
    private final HashMap<Long, Set<Long>> meGuildScheduledEventIds;
    private Map<Long, ? extends Set<Long>> meGuildScheduledEventIdsSnapshot;
    private final HashSet<Long> meGuildScheduledEventsFetches;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final HashSet<Long> rsvpsAwaitingNetwork;
    private HashSet<Long> rsvpsAwaitingSnapshot;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$ackGuildEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildScheduledEvent $mostRecentEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEvent guildScheduledEvent, long j) {
            super(1);
            this.$mostRecentEvent = guildScheduledEvent;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            StoreGuildScheduledEvents.this.lastAckedGuildScheduledEventIds.put(Long.valueOf(this.$guildId), Long.valueOf(this.$mostRecentEvent.getId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildScheduledEvent>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class C01271 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $events;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01271(List list) {
                super(0);
                this.$events = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildScheduledEvents.this.guildScheduledEvents.put(Long.valueOf(AnonymousClass1.this.$guildId), _Collections.toMutableList((Collection) this.$events));
                StoreGuildScheduledEvents.this.guildScheduledEventsFetchTimestamps.put(Long.valueOf(AnonymousClass1.this.$guildId), Long.valueOf(StoreGuildScheduledEvents.this.clock.currentTimeMillis()));
                StoreGuildScheduledEvents.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEvent> list) {
            invoke2((List<GuildScheduledEvent>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<GuildScheduledEvent> list) {
            Intrinsics3.checkNotNullParameter(list, "events");
            StoreGuildScheduledEvents.this.dispatcher.schedule(new C01271(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class C01281 extends Lambda implements Function1<Error, Unit> {
            public C01281() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreGuildScheduledEvents.this.handleFetchRsvpUsersFailure();
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ApiGuildScheduledEventUser>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
            public static final class C01291 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $apiGuildScheduledEventUsers;

                /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
                public static final class C01301 extends Lambda implements Function1<ApiGuildScheduledEventUser, GuildScheduledEventUser> {
                    public C01301() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final GuildScheduledEventUser invoke(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
                        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUser, "apiEventUser");
                        return GuildScheduledEventUser.INSTANCE.from(apiGuildScheduledEventUser, AnonymousClass1.this.$guildId);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01291(List list) {
                    super(0);
                    this.$apiGuildScheduledEventUsers = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreGuildScheduledEvents.this.userStore.handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers);
                    StoreGuildScheduledEvents.this.guildsStore.handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers, AnonymousClass1.this.$guildId);
                    HashMap map = (HashMap) StoreGuildScheduledEvents.this.guildScheduledEventUsers.get(Long.valueOf(AnonymousClass1.this.$eventId));
                    if (map == null) {
                        map = new HashMap();
                    }
                    for (GuildScheduledEventUser guildScheduledEventUser : _Sequences2.mapNotNull(_Collections.asSequence(this.$apiGuildScheduledEventUsers), new C01301())) {
                        map.put(Long.valueOf(guildScheduledEventUser.getUser().getId()), guildScheduledEventUser);
                    }
                    StoreGuildScheduledEvents.this.guildScheduledEventUsers.put(Long.valueOf(AnonymousClass1.this.$eventId), map);
                    Set linkedHashSet = (Set) StoreGuildScheduledEvents.this.guildScheduledEventUsersFetches.get(Long.valueOf(AnonymousClass1.this.$guildId));
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(Long.valueOf(AnonymousClass1.this.$eventId));
                    StoreGuildScheduledEvents.this.guildScheduledEventUsersFetches.put(Long.valueOf(AnonymousClass1.this.$guildId), linkedHashSet);
                    StoreGuildScheduledEvents.this.isFetchingGuildScheduledEventUsers = false;
                    StoreGuildScheduledEvents.this.isGuildScheduledEventUsersError = false;
                    StoreGuildScheduledEvents.this.markChanged();
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApiGuildScheduledEventUser> list) {
                invoke2((List<ApiGuildScheduledEventUser>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApiGuildScheduledEventUser> list) {
                Intrinsics3.checkNotNullParameter(list, "apiGuildScheduledEventUsers");
                StoreGuildScheduledEvents.this.dispatcher.schedule(new C01291(list));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
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
            Set setEmptySet = (Set) StoreGuildScheduledEvents.this.guildScheduledEventUsersFetches.get(Long.valueOf(this.$guildId));
            if (setEmptySet == null) {
                setEmptySet = Sets5.emptySet();
            }
            if (setEmptySet.contains(Long.valueOf(this.$eventId))) {
                return;
            }
            StoreGuildScheduledEvents.this.isFetchingGuildScheduledEventUsers = true;
            StoreGuildScheduledEvents.this.isGuildScheduledEventUsersError = false;
            StoreGuildScheduledEvents.this.markChanged();
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildScheduledEventUsers(this.$guildId, this.$eventId, 100, true, true), false, 1, null), (Class<?>) StoreGuildScheduledEvents.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C01281()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildScheduledEventMeUser>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class C01311 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $eventUsers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01311(List list) {
                super(0);
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
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((GuildScheduledEventMeUser) it.next()).getGuildScheduledEventId()));
                }
                StoreGuildScheduledEvents.this.meGuildScheduledEventIds.put(Long.valueOf(AnonymousClass1.this.$guildId), _Collections.toMutableSet(arrayList));
                StoreGuildScheduledEvents.this.meGuildScheduledEventsFetches.add(Long.valueOf(AnonymousClass1.this.$guildId));
                StoreGuildScheduledEvents.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEventMeUser> list) {
            invoke2((List<GuildScheduledEventMeUser>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<GuildScheduledEventMeUser> list) {
            Intrinsics3.checkNotNullParameter(list, "eventUsers");
            StoreGuildScheduledEvents.this.dispatcher.schedule(new C01311(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$handleFetchRsvpUsersFailure$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildScheduledEvents.this.isFetchingGuildScheduledEventUsers = false;
            StoreGuildScheduledEvents.this.isGuildScheduledEventUsersError = true;
            StoreGuildScheduledEvents.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$observeGuildScheduledEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<GuildScheduledEvent> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2) {
            super(0);
            this.$eventId = l;
            this.$guildId = l2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildScheduledEvent invoke() {
            Long l = this.$eventId;
            if (l != null) {
                return StoreGuildScheduledEvents.this.findEventFromStore(l.longValue(), this.$guildId);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$observeGuildScheduledEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends GuildScheduledEvent>> {
        public final /* synthetic */ boolean $filterInaccessible;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$guildId = j;
            this.$filterInaccessible = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends GuildScheduledEvent> invoke() {
            return StoreGuildScheduledEvents.this.getGuildScheduledEvents(this.$guildId, this.$filterInaccessible);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ GuildScheduledEvent $storeEvent;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class C01321 extends Lambda implements Function1<Error, Unit> {
            public C01321() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                storeGuildScheduledEvents.processRsvpCreate(storeGuildScheduledEvents.findEventFromStore(anonymousClass1.$storeEvent), StoreGuildScheduledEvents.this.userStore.getMeSnapshot().getId());
                StoreGuildScheduledEvents.this.rsvpsAwaitingNetwork.remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                StoreGuildScheduledEvents.this.rsvpsAwaitingNetwork.remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                storeGuildScheduledEvents.processRsvpDelete(storeGuildScheduledEvents.findEventFromStore(anonymousClass1.$storeEvent), StoreGuildScheduledEvents.this.userStore.getMeSnapshot().getId());
                StoreGuildScheduledEvents.this.rsvpsAwaitingNetwork.remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<Unit, Unit> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics3.checkNotNullParameter(unit, "it");
                StoreGuildScheduledEvents.this.rsvpsAwaitingNetwork.remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEvent guildScheduledEvent, long j, GuildScheduledEvent guildScheduledEvent2) {
            super(0);
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
            if (StoreGuildScheduledEvents.this.isMeRsvpedToEvent(this.$guildScheduledEvent.getGuildId(), this.$eventId)) {
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                storeGuildScheduledEvents.processRsvpDelete(this.$storeEvent, storeGuildScheduledEvents.userStore.getMeSnapshot().getId());
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildScheduledEventRsvp(this.$storeEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), (Class<?>) StoreGuildScheduledEvents.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C01321()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
                return;
            }
            StoreGuildScheduledEvents storeGuildScheduledEvents2 = StoreGuildScheduledEvents.this;
            storeGuildScheduledEvents2.processRsvpCreate(this.$storeEvent, storeGuildScheduledEvents2.userStore.getMeSnapshot().getId());
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createGuildScheduledEventRsvp(this.$guildScheduledEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), (Class<?>) StoreGuildScheduledEvents.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        }
    }

    public StoreGuildScheduledEvents(Dispatcher dispatcher, ObservationDeck observationDeck, StorePermissions storePermissions, StoreUser storeUser, StoreGuilds storeGuilds, Clock clock, StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.clock = clock;
        this.experimentsStore = storeExperiments;
        this.guildScheduledEvents = new HashMap<>();
        this.guildScheduledEventsSnapshot = Maps6.emptyMap();
        this.lastAckedGuildScheduledEventIds = new HashMap<>();
        this.guildScheduledEventsFetchTimestamps = new HashMap<>();
        this.meGuildScheduledEventIds = new HashMap<>();
        this.meGuildScheduledEventIdsSnapshot = Maps6.emptyMap();
        this.meGuildScheduledEventsFetches = new HashSet<>();
        this.rsvpsAwaitingNetwork = new HashSet<>();
        this.rsvpsAwaitingSnapshot = new HashSet<>();
        this.guildScheduledEventUsers = new HashMap<>();
        this.guildScheduledEventUsersSnapshot = Maps6.emptyMap();
        this.guildScheduledEventUsersFetches = new HashMap<>();
    }

    @Store3
    private final void addMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        if (!this.meGuildScheduledEventIds.containsKey(Long.valueOf(guildId))) {
            this.meGuildScheduledEventIds.put(Long.valueOf(guildId), Sets5.mutableSetOf(Long.valueOf(guildScheduledEventId)));
            return;
        }
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.add(Long.valueOf(guildScheduledEventId));
        }
    }

    @Store3
    private final void addUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        GuildMember member;
        if (userId == this.userStore.getMeSnapshot().getId() && !isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            addMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map == null) {
            map = new HashMap<>();
        }
        User user = this.userStore.getUsers(CollectionsJVM.listOf(Long.valueOf(userId)), false).get(Long.valueOf(userId));
        if (user != null && (member = this.guildsStore.getMember(guildId, userId)) != null) {
            map.put(Long.valueOf(userId), new GuildScheduledEventUser(user, member, guildScheduledEventId));
        }
        this.guildScheduledEventUsers.put(Long.valueOf(guildScheduledEventId), map);
    }

    private final GuildScheduledEvent findEventFromStore(GuildScheduledEvent event) {
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(event.getId(), Long.valueOf(event.getGuildId()));
        return guildScheduledEventFindEventFromStore != null ? guildScheduledEventFindEventFromStore : event;
    }

    public static /* synthetic */ GuildScheduledEvent findEventFromStore$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return storeGuildScheduledEvents.findEventFromStore(j, l);
    }

    public static /* synthetic */ List getGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.getGuildScheduledEvents(j, z2);
    }

    private final void handleFetchRsvpUsersFailure() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public static /* synthetic */ Observable observeGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.observeGuildScheduledEvents(j, z2);
    }

    private final void processGuildScheduledEventCreateOrUpdate(GuildScheduledEvent guildScheduledEvent) {
        int i;
        GuildScheduledEvent guildScheduledEvent2;
        GuildScheduledEvent guildScheduledEventA = guildScheduledEvent;
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null) {
            i = -1;
            break;
        }
        Iterator<GuildScheduledEvent> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getId() == guildScheduledEvent.getId()) {
                i = i2;
                break;
            }
            i2++;
        }
        if (this.guildScheduledEvents.get(Long.valueOf(guildId)) == null) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), Collections2.mutableListOf(guildScheduledEventA));
        } else if (i == -1) {
            List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list2 != null) {
                list2.add(guildScheduledEventA);
            }
        } else {
            List<GuildScheduledEvent> list3 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            Integer userCount = (list3 == null || (guildScheduledEvent2 = list3.get(i)) == null) ? null : guildScheduledEvent2.getUserCount();
            if (guildScheduledEvent.getUserCount() == null) {
                guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, userCount, null, null, 229375);
            }
            List<GuildScheduledEvent> list4 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list4 != null) {
                list4.set(i, guildScheduledEventA);
            }
        }
        markChanged();
    }

    @Store3
    private final void processRsvpCreate(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            return;
        }
        this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
        addUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
        Integer userCount = guildScheduledEvent.getUserCount();
        GuildScheduledEvent guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf((userCount != null ? userCount.intValue() : 0) + 1), null, null, 229375);
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEventA.getGuildId()));
        if (list != null) {
            Intrinsics3.checkNotNullExpressionValue(list, "eventList");
            Iterator<GuildScheduledEvent> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == id2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1) {
                list.set(i, guildScheduledEventA);
            } else {
                list.add(guildScheduledEventA);
            }
        } else {
            this.guildScheduledEvents.put(Long.valueOf(guildScheduledEvent.getGuildId()), Collections2.mutableListOf(guildScheduledEventA));
        }
        markChanged();
    }

    @Store3
    private final void processRsvpDelete(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId != this.userStore.getMeSnapshot().getId() || isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
            removeUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
            List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
            if (list != null) {
                Intrinsics3.checkNotNullExpressionValue(list, "eventList");
                Iterator<GuildScheduledEvent> it = list.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else {
                        if (it.next().getId() == id2) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                Integer numValueOf = Integer.valueOf(i);
                if (!(numValueOf.intValue() != -1)) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    Integer userCount = guildScheduledEvent.getUserCount();
                    list.set(iIntValue, GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(_Ranges.coerceAtLeast(0, userCount != null ? userCount.intValue() - 1 : 0)), null, null, 229375));
                }
            }
            markChanged();
        }
    }

    @Store3
    private final void removeMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.remove(Long.valueOf(guildScheduledEventId));
        }
    }

    @Store3
    private final void removeUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            removeMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map != null) {
            map.remove(Long.valueOf(userId));
        }
    }

    public final void ackGuildEvents(long guildId) {
        Object next;
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long id2 = ((GuildScheduledEvent) next).getId();
                do {
                    Object next2 = it.next();
                    long id3 = ((GuildScheduledEvent) next2).getId();
                    if (id2 < id3) {
                        next = next2;
                        id2 = id3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
        if (guildScheduledEvent != null) {
            Long l = this.lastAckedGuildScheduledEventIds.get(Long.valueOf(guildId));
            if (l == null || l.longValue() < guildScheduledEvent.getId()) {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postGuildFeatureAck(guildId, 1, guildScheduledEvent.getId(), new RestAPIParams.GuildFeatureAck(Boolean.FALSE, 0)), false, 1, null), (117 & 1) != 0 ? null : null, "REST: guildFeatureAck", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(guildScheduledEvent, guildId), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
            }
        }
    }

    public final void addGuildScheduledEventFromInvite(GuildScheduledEvent guildScheduledEvent) {
        int i;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null) {
            i = -1;
            break;
        }
        Iterator<GuildScheduledEvent> it = list.iterator();
        i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().getId() == guildScheduledEvent.getId()) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (i == -1 && !this.guildScheduledEvents.containsKey(Long.valueOf(guildId))) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), Collections2.mutableListOf(guildScheduledEvent));
        } else if (i == -1) {
            ((List) Maps6.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).add(guildScheduledEvent);
        } else {
            ((List) Maps6.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).set(i, guildScheduledEvent);
        }
        if (guildScheduledEvent.getUserRsvp() != null) {
            addMeRsvpForEvent(guildId, guildScheduledEvent.getId());
        }
        markChanged();
    }

    @Store3
    public final void addMeRsvpsForEvent(List<Tuples2<Long, Long>> events) {
        Intrinsics3.checkNotNullParameter(events, "events");
        Iterator<T> it = events.iterator();
        while (it.hasNext()) {
            Tuples2 tuples2 = (Tuples2) it.next();
            addMeRsvpForEvent(((Number) tuples2.getFirst()).longValue(), ((Number) tuples2.getSecond()).longValue());
        }
        markChanged();
    }

    public final void fetchGuildScheduledEventUserCounts(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Long l = this.guildScheduledEventsFetchTimestamps.get(Long.valueOf(guildId));
        if (l == null || this.clock.currentTimeMillis() - l.longValue() >= FETCH_GUILD_EVENTS_THRESHOLD) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildScheduledEvents(guildId, true), false, 1, null), (Class<?>) StoreGuildScheduledEvents.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId));
        }
    }

    public final void fetchGuildScheduledEventUsers(long guildId, long eventId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, eventId));
    }

    public final void fetchMeGuildScheduledEvents(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if ((list == null || list.isEmpty()) || this.meGuildScheduledEventsFetches.contains(Long.valueOf(guildId))) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getMeGuildScheduledEvents(guildId), false, 1, null), (Class<?>) StoreGuildScheduledEvents.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId));
    }

    public final GuildScheduledEvent getActiveEventForChannel(Long guildId, Long channelId) {
        Object obj = null;
        if (guildId == null || channelId == null) {
            return null;
        }
        for (Object obj2 : getGuildScheduledEvents$default(this, guildId.longValue(), false, 2, null)) {
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj2;
            if (Intrinsics3.areEqual(guildScheduledEvent.getChannelId(), channelId) && guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = obj2;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }

    public final Map<Long, List<GuildScheduledEvent>> getAllGuildScheduledEvents() {
        return this.guildScheduledEventsSnapshot;
    }

    public final Map<Long, GuildScheduledEventUser> getGuildScheduledEventUsers(long eventId) {
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(eventId));
        return map != null ? map : Maps6.emptyMap();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    public final List<GuildScheduledEvent> getGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        Map<Long, Long> permissionsByChannel = this.permissionsStore.getPermissionsByChannel();
        List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId));
        if (list == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj;
            boolean zCan = false;
            if (!filterInaccessible) {
                zCan = true;
            } else if (guildScheduledEvent.getStatus() != GuildScheduledEventStatus.COMPLETED) {
                if (guildScheduledEvent.getChannelId() == null) {
                    zCan = true;
                } else {
                    Long l = permissionsByChannel.get(guildScheduledEvent.getChannelId());
                    if (l != null) {
                        zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(l.longValue()));
                    }
                }
            }
            if (zCan) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean getIsFetchingGuildScheduledEventUsers() {
        return this.isFetchingGuildScheduledEventUsers;
    }

    public final boolean getIsGuildScheduledEventUsersError() {
        return this.isGuildScheduledEventUsersError;
    }

    public final Set<Long> getMeGuildScheduledEventIds(long guildId) {
        Set<Long> set = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        return set != null ? set : Sets5.emptySet();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.guildScheduledEventsFetchTimestamps.clear();
        this.meGuildScheduledEventsFetches.clear();
        this.guildScheduledEventUsersFetches.clear();
        this.guildScheduledEvents.clear();
        this.meGuildScheduledEventIds.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            List<GuildScheduledEvent> listO = ((Guild) it.next()).o();
            if (listO != null) {
                Iterator<T> it2 = listO.iterator();
                while (it2.hasNext()) {
                    processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it2.next());
                }
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildScheduledEvent> listO = guild.o();
        if (listO != null) {
            Iterator<T> it = listO.iterator();
            while (it.hasNext()) {
                processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it.next());
            }
        }
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        this.guildScheduledEvents.remove(Long.valueOf(guildId));
        this.guildScheduledEventsFetchTimestamps.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventIds.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventsFetches.remove(Long.valueOf(guildId));
        this.guildScheduledEventUsersFetches.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handleGuildScheduledEventCreate(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @Store3
    public final void handleGuildScheduledEventDelete(GuildScheduledEvent guildScheduledEvent) {
        List<GuildScheduledEvent> list;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
        if (list2 != null) {
            Iterator<GuildScheduledEvent> it = list2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == guildScheduledEvent.getId()) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1 && (list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()))) != null) {
                list.remove(i);
            }
            removeMeRsvpForEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getId());
            markChanged();
        }
    }

    @Store3
    public final void handleGuildScheduledEventUpdate(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @Store3
    public final void handleGuildScheduledEventUserAdd(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpCreate(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    @Store3
    public final void handleGuildScheduledEventUserRemove(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpDelete(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    public final boolean isMeRsvpedToEvent(long guildId, long guildScheduledEventId) {
        Set<Long> setEmptySet = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        return setEmptySet.contains(Long.valueOf(guildScheduledEventId));
    }

    public final Observable<GuildScheduledEvent> observeGuildScheduledEvent(Long eventId, Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(eventId, guildId), 14, null);
    }

    public final Observable<List<GuildScheduledEvent>> observeGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, filterInaccessible), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildScheduledEventsSnapshot = new HashMap(this.guildScheduledEvents);
        this.meGuildScheduledEventIdsSnapshot = new HashMap(this.meGuildScheduledEventIds);
        this.guildScheduledEventUsersSnapshot = new HashMap(this.guildScheduledEventUsers);
        this.rsvpsAwaitingSnapshot.clear();
    }

    public final void toggleMeRsvpForEvent(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(guildScheduledEvent);
        long id2 = guildScheduledEventFindEventFromStore.getId();
        if (this.rsvpsAwaitingNetwork.contains(Long.valueOf(id2)) || this.rsvpsAwaitingSnapshot.contains(Long.valueOf(id2))) {
            return;
        }
        this.rsvpsAwaitingNetwork.add(Long.valueOf(id2));
        this.dispatcher.schedule(new AnonymousClass1(guildScheduledEvent, id2, guildScheduledEventFindEventFromStore));
    }

    public final GuildScheduledEvent findEventFromStore(long eventId, Long guildId) {
        GuildScheduledEvent guildScheduledEvent;
        Object next;
        Object obj = null;
        if (guildId != null) {
            List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId.longValue()));
            if (list != null) {
                Iterator<T> it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(eventId == ((GuildScheduledEvent) next).getId()));
                guildScheduledEvent = (GuildScheduledEvent) next;
            } else {
                guildScheduledEvent = null;
            }
            if (guildScheduledEvent != null) {
                return guildScheduledEvent;
            }
        }
        for (Object obj2 : Iterables2.flatten(this.guildScheduledEventsSnapshot.values())) {
            if (eventId == ((GuildScheduledEvent) obj2).getId()) {
                obj = obj2;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }
}
