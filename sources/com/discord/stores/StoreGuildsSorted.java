package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted extends StoreV2 {
    private final Dispatcher dispatcher;
    private final List<Entry> entries;
    private List<? extends Entry> entriesSnapshot;
    private final StoreGuilds guildStore;
    private final StoreLurking lurkingGuildStore;
    private final ObservationDeck observationDeck;
    private final List<ModelGuildFolder> positions;

    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static abstract class Entry {

        /* JADX INFO: compiled from: StoreGuildsSorted.kt */
        public static final /* data */ class Folder extends Entry {
            private final Integer color;
            private final List<Guild> guilds;
            private final long id;
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(long j, List<Guild> list, Integer num, String str) {
                super(null);
                C12238m.checkNotNullParameter(list, "guilds");
                this.id = j;
                this.guilds = list;
                this.color = num;
                this.name = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Folder copy$default(Folder folder, long j, List list, Integer num, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = folder.id;
                }
                long j2 = j;
                if ((i & 2) != 0) {
                    list = folder.guilds;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    num = folder.color;
                }
                Integer num2 = num;
                if ((i & 8) != 0) {
                    str = folder.name;
                }
                return folder.copy(j2, list2, num2, str);
            }

            @Override // com.discord.stores.StoreGuildsSorted.Entry
            public ModelGuildFolder asModelGuildFolder() {
                Long lValueOf = Long.valueOf(this.id);
                List<Guild> list = this.guilds;
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((Guild) it.next()).getId()));
                }
                return new ModelGuildFolder(lValueOf, arrayList, this.color, this.name);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            public final List<Guild> component2() {
                return this.guilds;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getColor() {
                return this.color;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Folder copy(long id2, List<Guild> guilds, Integer color, String name) {
                C12238m.checkNotNullParameter(guilds, "guilds");
                return new Folder(id2, guilds, color, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Folder)) {
                    return false;
                }
                Folder folder = (Folder) other;
                return this.id == folder.id && C12238m.areEqual(this.guilds, folder.guilds) && C12238m.areEqual(this.color, folder.color) && C12238m.areEqual(this.name, folder.name);
            }

            public final Integer getColor() {
                return this.color;
            }

            public final List<Guild> getGuilds() {
                return this.guilds;
            }

            public final long getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.id) * 31;
                List<Guild> list = this.guilds;
                int iHashCode = (iM3a + (list != null ? list.hashCode() : 0)) * 31;
                Integer num = this.color;
                int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
                String str = this.name;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Folder(id=");
                sbM833U.append(this.id);
                sbM833U.append(", guilds=");
                sbM833U.append(this.guilds);
                sbM833U.append(", color=");
                sbM833U.append(this.color);
                sbM833U.append(", name=");
                return C1643a.m822J(sbM833U, this.name, ")");
            }
        }

        /* JADX INFO: compiled from: StoreGuildsSorted.kt */
        public static final /* data */ class SingletonGuild extends Entry {
            private final Guild guild;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingletonGuild(Guild guild) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
            }

            public static /* synthetic */ SingletonGuild copy$default(SingletonGuild singletonGuild, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = singletonGuild.guild;
                }
                return singletonGuild.copy(guild);
            }

            @Override // com.discord.stores.StoreGuildsSorted.Entry
            public ModelGuildFolder asModelGuildFolder() {
                return new ModelGuildFolder(null, C12145m.listOf(Long.valueOf(this.guild.getId())), null, null, 8, null);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final SingletonGuild copy(Guild guild) {
                C12238m.checkNotNullParameter(guild, "guild");
                return new SingletonGuild(guild);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SingletonGuild) && C12238m.areEqual(this.guild, ((SingletonGuild) other).guild);
                }
                return true;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public int hashCode() {
                Guild guild = this.guild;
                if (guild != null) {
                    return guild.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SingletonGuild(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Entry() {
        }

        public abstract ModelGuildFolder asModelGuildFolder();

        public /* synthetic */ Entry(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static final /* data */ class State {
        private final Map<Long, Long> joinedAt;
        private final Set<Long> mutedGuilds;
        private final List<ModelGuildFolder> userSettingsGuildPositions;

        public State(Set<Long> set, Map<Long, Long> map, List<ModelGuildFolder> list) {
            C12238m.checkNotNullParameter(set, "mutedGuilds");
            C12238m.checkNotNullParameter(map, "joinedAt");
            C12238m.checkNotNullParameter(list, "userSettingsGuildPositions");
            this.mutedGuilds = set;
            this.joinedAt = map;
            this.userSettingsGuildPositions = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.mutedGuilds;
            }
            if ((i & 2) != 0) {
                map = state.joinedAt;
            }
            if ((i & 4) != 0) {
                list = state.userSettingsGuildPositions;
            }
            return state.copy(set, map, list);
        }

        public final Set<Long> component1() {
            return this.mutedGuilds;
        }

        public final Map<Long, Long> component2() {
            return this.joinedAt;
        }

        public final List<ModelGuildFolder> component3() {
            return this.userSettingsGuildPositions;
        }

        public final State copy(Set<Long> mutedGuilds, Map<Long, Long> joinedAt, List<ModelGuildFolder> userSettingsGuildPositions) {
            C12238m.checkNotNullParameter(mutedGuilds, "mutedGuilds");
            C12238m.checkNotNullParameter(joinedAt, "joinedAt");
            C12238m.checkNotNullParameter(userSettingsGuildPositions, "userSettingsGuildPositions");
            return new State(mutedGuilds, joinedAt, userSettingsGuildPositions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return C12238m.areEqual(this.mutedGuilds, state.mutedGuilds) && C12238m.areEqual(this.joinedAt, state.joinedAt) && C12238m.areEqual(this.userSettingsGuildPositions, state.userSettingsGuildPositions);
        }

        public final Map<Long, Long> getJoinedAt() {
            return this.joinedAt;
        }

        public final Set<Long> getMutedGuilds() {
            return this.mutedGuilds;
        }

        public final List<ModelGuildFolder> getUserSettingsGuildPositions() {
            return this.userSettingsGuildPositions;
        }

        public int hashCode() {
            Set<Long> set = this.mutedGuilds;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Long, Long> map = this.joinedAt;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<ModelGuildFolder> list = this.userSettingsGuildPositions;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("State(mutedGuilds=");
            sbM833U.append(this.mutedGuilds);
            sbM833U.append(", joinedAt=");
            sbM833U.append(this.joinedAt);
            sbM833U.append(", userSettingsGuildPositions=");
            return C1643a.m824L(sbM833U, this.userSettingsGuildPositions, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsSorted$ensureValidPositions$6 */
    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static final class C61186 extends AbstractC12240o implements Function1<ModelGuildFolder, Boolean> {
        public static final C61186 INSTANCE = new C61186();

        public C61186() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelGuildFolder modelGuildFolder) {
            return Boolean.valueOf(invoke2(modelGuildFolder));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelGuildFolder modelGuildFolder) {
            C12238m.checkNotNullParameter(modelGuildFolder, "it");
            return modelGuildFolder.getGuildIds().isEmpty();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsSorted$init$1 */
    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static final class C61191 extends AbstractC12240o implements Function1<State, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildsSorted$init$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildsSorted.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ State $state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(State state) {
                super(0);
                this.$state = state;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildsSorted.this.handleNewState(this.$state);
            }
        }

        public C61191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            C12238m.checkNotNullParameter(state, "state");
            StoreGuildsSorted.this.dispatcher.schedule(new AnonymousClass1(state));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsSorted$observeEntries$1 */
    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static final class C61201 extends AbstractC12240o implements Function0<List<? extends Entry>> {
        public C61201() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Entry> invoke() {
            return StoreGuildsSorted.this.getEntries();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsSorted$observeOrderedGuilds$1 */
    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static final class C61211 extends AbstractC12240o implements Function0<LinkedHashMap<Long, Guild>> {
        public C61211() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final LinkedHashMap<Long, Guild> invoke() {
            return StoreGuildsSorted.this.getOrderedGuilds();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsSorted$setPositions$1 */
    /* JADX INFO: compiled from: StoreGuildsSorted.kt */
    public static final class C61241 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $guildPositions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61241(List list) {
            super(0);
            this.$guildPositions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildsSorted.this.handleNewPositionsFromUser(this.$guildPositions);
        }
    }

    public StoreGuildsSorted(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreLurking storeLurking) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeGuilds, "guildStore");
        C12238m.checkNotNullParameter(storeLurking, "lurkingGuildStore");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.guildStore = storeGuilds;
        this.lurkingGuildStore = storeLurking;
        this.entries = new ArrayList();
        this.entriesSnapshot = C12147n.emptyList();
        this.positions = new ArrayList();
    }

    @StoreThread
    private final void ensureValidPositions() {
        Map<Long, Guild> guildsInternal$app_productionGoogleRelease = this.guildStore.getGuildsInternal$app_productionGoogleRelease();
        Set<Long> unavailableGuildsInternal$app_productionGoogleRelease = this.guildStore.getUnavailableGuildsInternal$app_productionGoogleRelease();
        HashSet hashSet = new HashSet();
        Iterator<T> it = this.positions.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((ModelGuildFolder) it.next()).getGuildIds());
        }
        for (Guild guild : guildsInternal$app_productionGoogleRelease.values()) {
            if (!hashSet.contains(Long.valueOf(guild.getId())) && !this.lurkingGuildStore.isLurking$app_productionGoogleRelease(guild)) {
                this.positions.add(0, new ModelGuildFolder(null, C12145m.listOf(Long.valueOf(guild.getId())), null, null, 8, null));
            }
        }
        int i = 0;
        for (Object obj : this.positions) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            ModelGuildFolder modelGuildFolder = (ModelGuildFolder) obj;
            List<Long> guildIds = modelGuildFolder.getGuildIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : guildIds) {
                long jLongValue = ((Number) obj2).longValue();
                Guild guild2 = guildsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                if ((!guildsInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) || unavailableGuildsInternal$app_productionGoogleRelease.contains(Long.valueOf(jLongValue)) || guild2 == null || this.lurkingGuildStore.isLurking$app_productionGoogleRelease(guild2)) ? false : true) {
                    arrayList.add(obj2);
                }
            }
            this.positions.set(i, ModelGuildFolder.copy$default(modelGuildFolder, null, arrayList, null, null, 13, null));
            i = i2;
        }
        Set<Long> lurkingGuildIdsSync = this.lurkingGuildStore.getLurkingGuildIdsSync();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = lurkingGuildIdsSync.iterator();
        while (it2.hasNext()) {
            Guild guild3 = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it2.next()).longValue()));
            Long lValueOf = guild3 != null ? Long.valueOf(guild3.getId()) : null;
            if (lValueOf != null) {
                arrayList2.add(lValueOf);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            this.positions.add(0, new ModelGuildFolder(null, C12145m.listOf(Long.valueOf(((Number) it3.next()).longValue())), null, null, 8, null));
        }
        C12160r.removeAll((List) this.positions, (Function1) C61186.INSTANCE);
    }

    @StoreThread
    private final void handleNewPositionsFromUser(List<? extends Entry> guildPositions) {
        this.positions.clear();
        List<ModelGuildFolder> list = this.positions;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(guildPositions, 10));
        Iterator<T> it = guildPositions.iterator();
        while (it.hasNext()) {
            arrayList.add(((Entry) it.next()).asModelGuildFolder());
        }
        list.addAll(arrayList);
        ensureValidPositions();
        rebuildSortedGuilds();
    }

    @StoreThread
    private final void handleNewState(State state) {
        updatePositions(state);
        ensureValidPositions();
        rebuildSortedGuilds();
    }

    private final Observable<State> observeStores() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<State> observableM11073h = Observable.m11073h(companion.getGuilds().observeGuilds(), companion.getUserGuildSettings().observeMutedGuildIds().m11083G(new InterfaceC12589b<List<? extends Long>, Set<? extends Long>>() { // from class: com.discord.stores.StoreGuildsSorted.observeStores.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Set<? extends Long> call(List<? extends Long> list) {
                return call2((List<Long>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(List<Long> list) {
                C12238m.checkNotNullExpressionValue(list, "it");
                return C12163u.toSet(list);
            }
        }), companion.getGuilds().observeJoinedAt(), companion.getUserSettings().observeGuildFolders(), new Func4<Map<Long, ? extends Guild>, Set<? extends Long>, Map<Long, ? extends Long>, List<? extends ModelGuildFolder>, State>() { // from class: com.discord.stores.StoreGuildsSorted.observeStores.2
            @Override // p658rx.functions.Func4
            public /* bridge */ /* synthetic */ State call(Map<Long, ? extends Guild> map, Set<? extends Long> set, Map<Long, ? extends Long> map2, List<? extends ModelGuildFolder> list) {
                return call2((Map<Long, Guild>) map, (Set<Long>) set, (Map<Long, Long>) map2, (List<ModelGuildFolder>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final State call2(Map<Long, Guild> map, Set<Long> set, Map<Long, Long> map2, List<ModelGuildFolder> list) {
                C12238m.checkNotNullExpressionValue(set, "mutedGuilds");
                C12238m.checkNotNullExpressionValue(map2, "joinedAt");
                C12238m.checkNotNullExpressionValue(list, "folders");
                return new State(set, map2, list);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…lds, joinedAt, folders) }");
        return observableM11073h;
    }

    @StoreThread
    private final void rebuildSortedGuilds() {
        this.entries.clear();
        for (ModelGuildFolder modelGuildFolder : this.positions) {
            Long id2 = modelGuildFolder.getId();
            if (id2 != null) {
                long jLongValue = id2.longValue();
                List<Long> guildIds = modelGuildFolder.getGuildIds();
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(guildIds, 10));
                Iterator<T> it = guildIds.iterator();
                while (it.hasNext()) {
                    Guild guild = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it.next()).longValue()));
                    C12238m.checkNotNull(guild);
                    arrayList.add(guild);
                }
                this.entries.add(new Entry.Folder(jLongValue, arrayList, modelGuildFolder.getColor(), modelGuildFolder.getName()));
            } else {
                Guild guild2 = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(C12163u.first((List) modelGuildFolder.getGuildIds()));
                C12238m.checkNotNull(guild2);
                this.entries.add(new Entry.SingletonGuild(guild2));
            }
        }
        markChanged();
    }

    @StoreThread
    private final void updatePositions(final State state) {
        this.positions.clear();
        final Map<Long, Guild> guildsInternal$app_productionGoogleRelease = this.guildStore.getGuildsInternal$app_productionGoogleRelease();
        if (!state.getUserSettingsGuildPositions().isEmpty()) {
            this.positions.addAll(state.getUserSettingsGuildPositions());
            return;
        }
        List<ModelGuildFolder> list = this.positions;
        List listSortedWith = C12163u.sortedWith(guildsInternal$app_productionGoogleRelease.keySet(), new Comparator<Long>() { // from class: com.discord.stores.StoreGuildsSorted.updatePositions.1
            @Override // java.util.Comparator
            public final int compare(Long l, Long l2) {
                String name;
                String name2;
                boolean zContains = state.getMutedGuilds().contains(l);
                if (state.getMutedGuilds().contains(l2) != zContains) {
                    return zContains ? 1 : -1;
                }
                Long l3 = state.getJoinedAt().get(l);
                long jLongValue = l3 != null ? l3.longValue() : Long.MIN_VALUE;
                Long l4 = state.getJoinedAt().get(l);
                long jLongValue2 = l4 != null ? l4.longValue() : Long.MIN_VALUE;
                if (jLongValue != jLongValue2) {
                    return (int) (jLongValue - jLongValue2);
                }
                Guild guild = (Guild) guildsInternal$app_productionGoogleRelease.get(l);
                String str = "";
                if (guild == null || (name = guild.getName()) == null) {
                    name = "";
                }
                Guild guild2 = (Guild) guildsInternal$app_productionGoogleRelease.get(l2);
                if (guild2 != null && (name2 = guild2.getName()) != null) {
                    str = name2;
                }
                return C12103t.compareTo(name, str, false);
            }
        });
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelGuildFolder(null, C12145m.listOf(Long.valueOf(((Number) it.next()).longValue())), null, null, 8, null));
        }
        list.addAll(arrayList);
    }

    public final List<Entry> getEntries() {
        return this.entriesSnapshot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedHashMap<Long, Guild> getOrderedGuilds() {
        LinkedHashMap<Long, Guild> linkedHashMap = new LinkedHashMap<>();
        for (Entry entry : getEntries()) {
            if (entry instanceof Entry.SingletonGuild) {
                Entry.SingletonGuild singletonGuild = (Entry.SingletonGuild) entry;
                linkedHashMap.put(Long.valueOf(singletonGuild.getGuild().getId()), singletonGuild.getGuild());
            } else if (entry instanceof Entry.Folder) {
                for (Object obj : ((Entry.Folder) entry).getGuilds()) {
                    linkedHashMap.put(Long.valueOf(((Guild) obj).getId()), obj);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.leadingEdgeThrottle(ObservableExtensionsKt.computationLatest(observeStores()), 1L, TimeUnit.SECONDS), (Class<?>) StoreGuildsSorted.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61191());
    }

    public final Observable<List<Entry>> observeEntries() {
        Observable<List<Entry>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61201(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<LinkedHashMap<Long, Guild>> observeOrderedGuilds() {
        Observable<LinkedHashMap<Long, Guild>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61211(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void setPositions(List<? extends Entry> guildPositions) {
        C12238m.checkNotNullParameter(guildPositions, "guildPositions");
        this.dispatcher.schedule(new C61241(guildPositions));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.entriesSnapshot = new ArrayList(this.entries);
    }
}
