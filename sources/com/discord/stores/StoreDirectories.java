package com.discord.stores;

import android.content.Context;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionDirectoryGuildEntryDelete;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryType;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories extends StoreV2 {
    private static final String DISCORD_HUB_VERIFICATION_CLICKED_KEY = "hub_verification_clicked_key";
    private static final String GUILD_SCHEDULED_EVENTS_HEADER_DISMISSED = "guild_scheduled_events_header_dismissed";
    private static final String HUB_NAME_PROMPT = "hub_name_prompt";
    private Map<Long, RestCallState<List<DirectoryEntryGuild>>> directoriesMap;
    private Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> directoriesMapSnapshot;
    private Map<Long, RestCallState<List<DirectoryEntryEvent>>> directoryGuildScheduledEventsMap;
    private Map<Long, ? extends RestCallState<? extends List<DirectoryEntryEvent>>> directoryGuildScheduledEventsMapSnapshot;
    private final Persister<Boolean> discordHubClickedPersister;
    private final Dispatcher dispatcher;
    private Map<Long, RestCallState<Map<Integer, Integer>>> entryCountMap;
    private Map<Long, ? extends RestCallState<? extends Map<Integer, Integer>>> entryCountMapSnapshot;
    private final Persister<Boolean> guildScheduledEventsHeaderDismissed;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StoreGuilds guildStore;
    private final Persister<Set<Long>> hubNamePromptPersister;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$addServerToDirectory$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58651 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58651(long j, DirectoryEntryGuild directoryEntryGuild) {
            super(0);
            this.$channelId = j;
            this.$directoryEntry = directoryEntryGuild;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = StoreDirectories.this.directoriesMap;
            Long lValueOf = Long.valueOf(this.$channelId);
            RestCallState restCallState = (RestCallState) StoreDirectories.this.directoriesMap.get(Long.valueOf(this.$channelId));
            List<DirectoryEntryGuild> listEmptyList = restCallState != null ? (List) restCallState.invoke() : null;
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listEmptyList, 10));
            boolean z2 = false;
            for (DirectoryEntryGuild directoryEntryGuild : listEmptyList) {
                if (directoryEntryGuild.getGuild().getId() == this.$directoryEntry.getGuild().getId()) {
                    z2 = true;
                    directoryEntryGuild = this.$directoryEntry;
                }
                arrayList.add(directoryEntryGuild);
            }
            map.put(lValueOf, new Success(C12163u.plus((Collection) arrayList, (Iterable) C12147n.listOfNotNull(z2 ? null : this.$directoryEntry))));
            StoreDirectories.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$2 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58682 extends AbstractC12240o implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreDirectories.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ RestCallState $entriesResponse;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestCallState restCallState) {
                super(0);
                this.$entriesResponse = restCallState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreDirectories.this.directoriesMap.put(Long.valueOf(C58682.this.$channelId), this.$entriesResponse);
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58682(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "entriesResponse");
            StoreDirectories.this.dispatcher.schedule(new AnonymousClass1(restCallState));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$fetchEntryCountsForChannel$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58691 extends AbstractC12240o implements Function1<RestCallState<? extends Map<Integer, ? extends Integer>>, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$fetchEntryCountsForChannel$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreDirectories.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ RestCallState $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestCallState restCallState) {
                super(0);
                this.$response = restCallState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreDirectories.this.entryCountMap.put(Long.valueOf(C58691.this.$channelId), this.$response);
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58691(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Map<Integer, ? extends Integer>> restCallState) {
            invoke2((RestCallState<? extends Map<Integer, Integer>>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends Map<Integer, Integer>> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "response");
            StoreDirectories.this.dispatcher.schedule(new AnonymousClass1(restCallState));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$fetchGuildScheduledEventsForChannel$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58701 extends AbstractC12240o implements Function1<RestCallState<? extends List<? extends DirectoryEntryEvent>>, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$fetchGuildScheduledEventsForChannel$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreDirectories.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ RestCallState $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestCallState restCallState) {
                super(0);
                this.$response = restCallState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreDirectories.this.directoryGuildScheduledEventsMap.put(Long.valueOf(C58701.this.$channelId), this.$response);
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
                        Pair pairM10073to = guildScheduledEvent != null ? C12116o.m10073to(Long.valueOf(guildScheduledEvent.getGuildId()), Long.valueOf(guildScheduledEvent.getId())) : null;
                        if (pairM10073to != null) {
                            arrayList.add(pairM10073to);
                        }
                    }
                    StoreDirectories.this.guildScheduledEventsStore.addMeRsvpsForEvent(arrayList);
                }
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58701(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryEvent>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryEvent>>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryEvent>> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "response");
            StoreDirectories.this.dispatcher.schedule(new AnonymousClass1(restCallState));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$init$2 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58722 extends AbstractC12240o implements Function1<Set<? extends Long>, Unit> {
        public C58722() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            Set set2 = (Set) StoreDirectories.this.hubNamePromptPersister.get();
            Persister persister = StoreDirectories.this.hubNamePromptPersister;
            ArrayList arrayList = new ArrayList();
            for (Object obj : set2) {
                if (set.contains(Long.valueOf(((Number) obj).longValue()))) {
                    arrayList.add(obj);
                }
            }
            Persister.set$default(persister, C12163u.toSet(arrayList), false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$observeDirectories$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58731 extends AbstractC12240o implements Function0<Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>>> {
        public C58731() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> invoke() {
            return StoreDirectories.this.directoriesMapSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$observeDirectoriesForChannel$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58741 extends AbstractC12240o implements Function0<RestCallState<? extends List<? extends DirectoryEntryGuild>>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58741(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final RestCallState<? extends List<? extends DirectoryEntryGuild>> invoke() {
            return (RestCallState) StoreDirectories.this.directoriesMapSnapshot.get(Long.valueOf(this.$channelId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$observeDirectoryGuildScheduledEvents$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58751 extends AbstractC12240o implements Function0<Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryEvent>>>> {
        public C58751() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryEvent>>> invoke() {
            return StoreDirectories.this.directoryGuildScheduledEventsMapSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$removeServerFromDirectory$1 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58761 extends AbstractC12240o implements Function1<DirectoryEntryGuild, TrackNetworkMetadataReceiver> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58761(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(DirectoryEntryGuild directoryEntryGuild) {
            return new TrackNetworkActionDirectoryGuildEntryDelete(Long.valueOf(this.$channelId), Long.valueOf(this.$guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$removeServerFromDirectory$2 */
    /* JADX INFO: compiled from: StoreDirectories.kt */
    public static final class C58772 extends AbstractC12240o implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreDirectories$removeServerFromDirectory$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreDirectories.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = StoreDirectories.this.directoriesMap;
                Long lValueOf = Long.valueOf(C58772.this.$channelId);
                RestCallState restCallState = (RestCallState) StoreDirectories.this.directoriesMap.get(Long.valueOf(C58772.this.$channelId));
                List listEmptyList = restCallState != null ? (List) restCallState.invoke() : null;
                if (listEmptyList == null) {
                    listEmptyList = C12147n.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : listEmptyList) {
                    GuildPreview guild = ((DirectoryEntryGuild) obj).getGuild();
                    if (guild == null || guild.getId() != C58772.this.$guildId) {
                        arrayList.add(obj);
                    }
                }
                map.put(lValueOf, new Success(arrayList));
                StoreDirectories.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58772(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
            invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "request");
            if (restCallState instanceof Success) {
                StoreDirectories.this.dispatcher.schedule(new AnonymousClass1());
            }
        }
    }

    public /* synthetic */ StoreDirectories(Dispatcher dispatcher, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildScheduledEvents storeGuildScheduledEvents, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, storeGuilds, storeGuildScheduledEvents, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public final void addServerToDirectory(long channelId, DirectoryEntryGuild directoryEntry) {
        C12238m.checkNotNullParameter(directoryEntry, "directoryEntry");
        this.dispatcher.schedule(new C58651(channelId, directoryEntry));
    }

    public final void fetchDirectoriesForChannel(long channelId) {
        Observable<R> observableM11083G = this.restApi.getDirectoryEntries(channelId).m11083G(new InterfaceC12589b<List<? extends DirectoryEntryGuild>, List<? extends DirectoryEntryGuild>>() { // from class: com.discord.stores.StoreDirectories.fetchDirectoriesForChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends DirectoryEntryGuild> call(List<? extends DirectoryEntryGuild> list) {
                return call2((List<DirectoryEntryGuild>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<DirectoryEntryGuild> call2(List<DirectoryEntryGuild> list) {
                C12238m.checkNotNullExpressionValue(list, "entries");
                return C12163u.sortedWith(list, new Comparator() { // from class: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$1$$special$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Integer approximateMemberCount = ((DirectoryEntryGuild) t2).getGuild().getApproximateMemberCount();
                        Integer numValueOf = Integer.valueOf(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
                        Integer approximateMemberCount2 = ((DirectoryEntryGuild) t).getGuild().getApproximateMemberCount();
                        return C12169a.compareValues(numValueOf, Integer.valueOf(approximateMemberCount2 != null ? approximateMemberCount2.intValue() : 0));
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "restApi\n        .getDire…imateMemberCount ?: 0 } }");
        RestCallStateKt.executeRequest(observableM11083G, new C58682(channelId));
    }

    public final void fetchEntryCountsForChannel(long channelId) {
        RestCallStateKt.executeRequest(this.restApi.getEntryCounts(channelId), new C58691(channelId));
    }

    public final void fetchGuildScheduledEventsForChannel(long guildId, long channelId) {
        if (GrowthTeamFeatures.INSTANCE.hubEventsEnabled(guildId, false)) {
            RestCallStateKt.executeRequest(this.restApi.getDirectoryGuildScheduledEvents(channelId, DirectoryEntryType.GuildScheduledEvent.getKey()), new C58701(channelId));
        }
    }

    public final boolean getAndSetSeenNamePrompt(long guildId) {
        boolean zContains = this.hubNamePromptPersister.get().contains(Long.valueOf(guildId));
        Persister<Set<Long>> persister = this.hubNamePromptPersister;
        persister.set(C12150o0.plus(persister.get(), Long.valueOf(guildId)), true);
        return zContains;
    }

    public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesForChannel(long channelId) {
        return (RestCallState) this.directoriesMapSnapshot.get(Long.valueOf(channelId));
    }

    public final RestCallState<Map<Integer, Integer>> getEntryCountsForChannel(long channelId) {
        return (RestCallState) this.entryCountMapSnapshot.get(Long.valueOf(channelId));
    }

    public final RestCallState<List<DirectoryEntryEvent>> getGuildScheduledEventsForChannel(long channelId) {
        return (RestCallState) this.directoryGuildScheduledEventsMapSnapshot.get(Long.valueOf(channelId));
    }

    public final boolean getGuildScheduledEventsHeaderDismissed() {
        return this.guildScheduledEventsHeaderDismissed.get().booleanValue();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.guildStore.observeGuilds(), 1L, TimeUnit.SECONDS)).m11083G(new InterfaceC12589b<Map<Long, ? extends Guild>, Set<? extends Long>>() { // from class: com.discord.stores.StoreDirectories.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
                return call2((Map<Long, Guild>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(Map<Long, Guild> map) {
                Collection<Guild> collectionValues = map.values();
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (((Guild) t).isHub()) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((Guild) it.next()).getId()));
                }
                return C12163u.toSet(arrayList2);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "guildStore\n        .obse…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) StoreDirectories.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C58722());
    }

    public final void markDiscordHubClicked() {
        this.discordHubClickedPersister.set(Boolean.TRUE, true);
    }

    public final void markGuildScheduledEventsHeaderDismissed() {
        this.guildScheduledEventsHeaderDismissed.set(Boolean.TRUE, true);
    }

    public final Observable<Map<Long, RestCallState<List<DirectoryEntryGuild>>>> observeDirectories() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58731(), 14, null);
    }

    public final Observable<RestCallState<List<DirectoryEntryGuild>>> observeDirectoriesForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58741(channelId), 14, null);
    }

    public final Observable<Map<Long, RestCallState<List<DirectoryEntryEvent>>>> observeDirectoryGuildScheduledEvents() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58751(), 14, null);
    }

    public final Observable<Boolean> observeDiscordHubClicked() {
        Observable<Boolean> observableM11112r = this.discordHubClickedPersister.getObservable().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "discordHubClickedPersist…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void removeServerFromDirectory(long channelId, long guildId) {
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restApi.removeServerFromHub(channelId, guildId), new C58761(channelId, guildId)), new C58772(channelId, guildId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        this.directoriesMapSnapshot = new HashMap(this.directoriesMap);
        this.entryCountMapSnapshot = new HashMap(this.entryCountMap);
        this.directoryGuildScheduledEventsMapSnapshot = new HashMap(this.directoryGuildScheduledEventsMap);
    }

    public StoreDirectories(Dispatcher dispatcher, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildScheduledEvents storeGuildScheduledEvents, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeGuilds, "guildStore");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        C12238m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildStore = storeGuilds;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.restApi = restAPI;
        this.directoriesMapSnapshot = C12136h0.emptyMap();
        this.directoriesMap = new LinkedHashMap();
        this.entryCountMapSnapshot = C12136h0.emptyMap();
        this.entryCountMap = new LinkedHashMap();
        this.directoryGuildScheduledEventsMapSnapshot = C12136h0.emptyMap();
        this.directoryGuildScheduledEventsMap = new LinkedHashMap();
        Boolean bool = Boolean.FALSE;
        this.discordHubClickedPersister = new Persister<>(DISCORD_HUB_VERIFICATION_CLICKED_KEY, bool);
        this.guildScheduledEventsHeaderDismissed = new Persister<>(GUILD_SCHEDULED_EVENTS_HEADER_DISMISSED, bool);
        this.hubNamePromptPersister = new Persister<>(HUB_NAME_PROMPT, C12148n0.emptySet());
    }
}
