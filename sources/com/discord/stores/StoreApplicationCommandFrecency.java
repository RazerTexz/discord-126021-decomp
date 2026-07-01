package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.applicationcommands.ApplicationCommandFrecencyTracker;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.s;
import d0.g0.w;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreApplicationCommandFrecency.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommandFrecency extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ApplicationCommandFrecencyTracker frecency;
    private final Persister<ApplicationCommandFrecencyTracker> frecencyCache;
    private final ObservationDeck observationDeck;
    private Map<Long, List<String>> topCommandIds;
    private Map<Long, ? extends List<String>> topCommandIdsSnapshot;

    public /* synthetic */ StoreApplicationCommandFrecency(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ List access$getAllTopCommandIds(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Long l) {
        return storeApplicationCommandFrecency.getAllTopCommandIds(l);
    }

    public static final /* synthetic */ ApplicationCommandFrecencyTracker access$getFrecency$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return storeApplicationCommandFrecency.frecency;
    }

    public static final /* synthetic */ Persister access$getFrecencyCache$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return storeApplicationCommandFrecency.frecencyCache;
    }

    public static final /* synthetic */ String access$getKey(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Long l, String str) {
        return storeApplicationCommandFrecency.getKey(l, str);
    }

    public static final /* synthetic */ Map access$getTopCommandIds$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return storeApplicationCommandFrecency.topCommandIds;
    }

    public static final /* synthetic */ void access$setTopCommandIds$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Map map) {
        storeApplicationCommandFrecency.topCommandIds = map;
    }

    private final List<String> getAllTopCommandIds(Long guildId) {
        Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null);
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = sortedKeys$default.iterator();
        while (true) {
            boolean zAreEqual = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (guildId == null) {
                zAreEqual = !w.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null);
            } else if (w.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                zAreEqual = m.areEqual((String) w.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).get(1), String.valueOf(guildId.longValue()));
            }
            if (zAreEqual) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (String str2 : arrayList) {
            if (w.contains$default((CharSequence) str2, (CharSequence) ":", false, 2, (Object) null)) {
                str2 = (String) w.split$default((CharSequence) str2, new String[]{":"}, false, 0, 6, (Object) null).get(0);
            }
            arrayList2.add(str2);
        }
        return arrayList2;
    }

    private final String getKey(Long guildId, String commandId) {
        if (guildId == null) {
            return commandId;
        }
        return commandId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + guildId;
    }

    public final List<String> getTopCommandIds(Long guildId) {
        List<String> list = this.topCommandIdsSnapshot.get(Long.valueOf(guildId != null ? guildId.longValue() : 0L));
        return list != null ? list : n.emptyList();
    }

    @StoreThread
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final Observable<List<String>> observeTopCommandIds(Long guildId) {
        Observable<List<String>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationCommandFrecency$observeTopCommandIds$1(this, guildId), 14, null).T(getTopCommandIds(guildId));
        m.checkNotNullExpressionValue(observableT, "observationDeck.connectR…etTopCommandIds(guildId))");
        return observableT;
    }

    public final void onCommandUsed(Long guildId, String commandId) {
        m.checkNotNullParameter(commandId, "commandId");
        this.dispatcher.schedule(new StoreApplicationCommandFrecency$onCommandUsed$1(this, guildId, commandId));
    }

    public final void populateStore() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null)) {
            if (w.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                List listSplit$default = w.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                Long longOrNull = s.toLongOrNull((String) listSplit$default.get(1));
                long jLongValue = longOrNull != null ? longOrNull.longValue() : 0L;
                String str2 = (String) listSplit$default.get(0);
                List arrayList = (List) linkedHashMap.get(Long.valueOf(jLongValue));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(Long.valueOf(jLongValue), arrayList);
                }
                arrayList.add(str2);
            } else {
                List arrayList2 = (List) linkedHashMap.get(0L);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(0L, arrayList2);
                }
                arrayList2.add(str);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(map$Entry.getKey(), u.toList((Iterable) map$Entry.getValue()));
        }
        this.topCommandIds = h0.toMutableMap(linkedHashMap2);
        this.topCommandIdsSnapshot = linkedHashMap;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        this.topCommandIdsSnapshot = new HashMap(this.topCommandIds);
    }

    public StoreApplicationCommandFrecency(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        Persister<ApplicationCommandFrecencyTracker> persister = new Persister<>("CACHE_KEY_APPLICATION_COMMANDS", new ApplicationCommandFrecencyTracker(0, 0, 3, null));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.topCommandIds = new LinkedHashMap();
        this.topCommandIdsSnapshot = h0.emptyMap();
        populateStore();
    }
}
