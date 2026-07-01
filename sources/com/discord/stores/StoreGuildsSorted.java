package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.o;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted extends StoreV2 {
    private final Dispatcher dispatcher;
    private final List<StoreGuildsSorted$Entry> entries;
    private List<? extends StoreGuildsSorted$Entry> entriesSnapshot;
    private final StoreGuilds guildStore;
    private final StoreLurking lurkingGuildStore;
    private final ObservationDeck observationDeck;
    private final List<ModelGuildFolder> positions;

    public StoreGuildsSorted(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreLurking storeLurking) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeGuilds, "guildStore");
        m.checkNotNullParameter(storeLurking, "lurkingGuildStore");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.guildStore = storeGuilds;
        this.lurkingGuildStore = storeLurking;
        this.entries = new ArrayList();
        this.entriesSnapshot = n.emptyList();
        this.positions = new ArrayList();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildsSorted storeGuildsSorted) {
        return storeGuildsSorted.dispatcher;
    }

    public static final /* synthetic */ void access$handleNewPositionsFromUser(StoreGuildsSorted storeGuildsSorted, List list) {
        storeGuildsSorted.handleNewPositionsFromUser(list);
    }

    public static final /* synthetic */ void access$handleNewState(StoreGuildsSorted storeGuildsSorted, StoreGuildsSorted$State storeGuildsSorted$State) {
        storeGuildsSorted.handleNewState(storeGuildsSorted$State);
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
                this.positions.add(0, new ModelGuildFolder(null, d0.t.m.listOf(Long.valueOf(guild.getId())), null, null, 8, null));
            }
        }
        int i = 0;
        for (Object obj : this.positions) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
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
            this.positions.add(0, new ModelGuildFolder(null, d0.t.m.listOf(Long.valueOf(((Number) it3.next()).longValue())), null, null, 8, null));
        }
        r.removeAll((List) this.positions, (Function1) StoreGuildsSorted$ensureValidPositions$6.INSTANCE);
    }

    @StoreThread
    private final void handleNewPositionsFromUser(List<? extends StoreGuildsSorted$Entry> guildPositions) {
        this.positions.clear();
        List<ModelGuildFolder> list = this.positions;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(guildPositions, 10));
        Iterator<T> it = guildPositions.iterator();
        while (it.hasNext()) {
            arrayList.add(((StoreGuildsSorted$Entry) it.next()).asModelGuildFolder());
        }
        list.addAll(arrayList);
        ensureValidPositions();
        rebuildSortedGuilds();
    }

    @StoreThread
    private final void handleNewState(StoreGuildsSorted$State state) {
        updatePositions(state);
        ensureValidPositions();
        rebuildSortedGuilds();
    }

    private final Observable<StoreGuildsSorted$State> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<StoreGuildsSorted$State> observableH = Observable.h(storeStream$Companion.getGuilds().observeGuilds(), storeStream$Companion.getUserGuildSettings().observeMutedGuildIds().G(StoreGuildsSorted$observeStores$1.INSTANCE), storeStream$Companion.getGuilds().observeJoinedAt(), storeStream$Companion.getUserSettings().observeGuildFolders(), StoreGuildsSorted$observeStores$2.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…lds, joinedAt, folders) }");
        return observableH;
    }

    @StoreThread
    private final void rebuildSortedGuilds() {
        this.entries.clear();
        for (ModelGuildFolder modelGuildFolder : this.positions) {
            Long id2 = modelGuildFolder.getId();
            if (id2 != null) {
                long jLongValue = id2.longValue();
                List<Long> guildIds = modelGuildFolder.getGuildIds();
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(guildIds, 10));
                Iterator<T> it = guildIds.iterator();
                while (it.hasNext()) {
                    Guild guild = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it.next()).longValue()));
                    m.checkNotNull(guild);
                    arrayList.add(guild);
                }
                this.entries.add(new StoreGuildsSorted$Entry$Folder(jLongValue, arrayList, modelGuildFolder.getColor(), modelGuildFolder.getName()));
            } else {
                Guild guild2 = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(u.first((List) modelGuildFolder.getGuildIds()));
                m.checkNotNull(guild2);
                this.entries.add(new StoreGuildsSorted$Entry$SingletonGuild(guild2));
            }
        }
        markChanged();
    }

    @StoreThread
    private final void updatePositions(StoreGuildsSorted$State state) {
        this.positions.clear();
        Map<Long, Guild> guildsInternal$app_productionGoogleRelease = this.guildStore.getGuildsInternal$app_productionGoogleRelease();
        if (!state.getUserSettingsGuildPositions().isEmpty()) {
            this.positions.addAll(state.getUserSettingsGuildPositions());
            return;
        }
        List<ModelGuildFolder> list = this.positions;
        List listSortedWith = u.sortedWith(guildsInternal$app_productionGoogleRelease.keySet(), new StoreGuildsSorted$updatePositions$1(state, guildsInternal$app_productionGoogleRelease));
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelGuildFolder(null, d0.t.m.listOf(Long.valueOf(((Number) it.next()).longValue())), null, null, 8, null));
        }
        list.addAll(arrayList);
    }

    public final List<StoreGuildsSorted$Entry> getEntries() {
        return this.entriesSnapshot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedHashMap<Long, Guild> getOrderedGuilds() {
        LinkedHashMap<Long, Guild> linkedHashMap = new LinkedHashMap<>();
        for (StoreGuildsSorted$Entry storeGuildsSorted$Entry : getEntries()) {
            if (storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$SingletonGuild) {
                StoreGuildsSorted$Entry$SingletonGuild storeGuildsSorted$Entry$SingletonGuild = (StoreGuildsSorted$Entry$SingletonGuild) storeGuildsSorted$Entry;
                linkedHashMap.put(Long.valueOf(storeGuildsSorted$Entry$SingletonGuild.getGuild().getId()), storeGuildsSorted$Entry$SingletonGuild.getGuild());
            } else if (storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$Folder) {
                for (Object obj : ((StoreGuildsSorted$Entry$Folder) storeGuildsSorted$Entry).getGuilds()) {
                    linkedHashMap.put(Long.valueOf(((Guild) obj).getId()), obj);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.leadingEdgeThrottle(ObservableExtensionsKt.computationLatest(observeStores()), 1L, TimeUnit.SECONDS), StoreGuildsSorted.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuildsSorted$init$1(this), 62, (Object) null);
    }

    public final Observable<List<StoreGuildsSorted$Entry>> observeEntries() {
        Observable<List<StoreGuildsSorted$Entry>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildsSorted$observeEntries$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<LinkedHashMap<Long, Guild>> observeOrderedGuilds() {
        Observable<LinkedHashMap<Long, Guild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildsSorted$observeOrderedGuilds$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setPositions(List<? extends StoreGuildsSorted$Entry> guildPositions) {
        m.checkNotNullParameter(guildPositions, "guildPositions");
        this.dispatcher.schedule(new StoreGuildsSorted$setPositions$1(this, guildPositions));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.entriesSnapshot = new ArrayList(this.entries);
    }
}
