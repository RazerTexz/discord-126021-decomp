package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.applicationcommands.ApplicationCommandFrecencyTracker;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommandFrecency$observeTopCommandIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommandFrecency.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends String>> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends String> invoke() {
            return StoreApplicationCommandFrecency.this.getTopCommandIds(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommandFrecency$onCommandUsed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommandFrecency.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $commandId;
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, String str) {
            super(0);
            this.$guildId = l;
            this.$commandId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FrecencyTracker.track$default(StoreApplicationCommandFrecency.this.frecency, StoreApplicationCommandFrecency.this.getKey(this.$guildId, this.$commandId), 0L, 2, null);
            StoreApplicationCommandFrecency.this.frecencyCache.set(StoreApplicationCommandFrecency.this.frecency, true);
            Map map = StoreApplicationCommandFrecency.this.topCommandIds;
            Long l = this.$guildId;
            map.put(Long.valueOf(l != null ? l.longValue() : 0L), StoreApplicationCommandFrecency.this.getAllTopCommandIds(this.$guildId));
            StoreApplicationCommandFrecency storeApplicationCommandFrecency = StoreApplicationCommandFrecency.this;
            storeApplicationCommandFrecency.markChanged(storeApplicationCommandFrecency);
        }
    }

    public /* synthetic */ StoreApplicationCommandFrecency(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
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
                zAreEqual = !Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null);
            } else if (Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                zAreEqual = Intrinsics3.areEqual((String) Strings4.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).get(1), String.valueOf(guildId.longValue()));
            }
            if (zAreEqual) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (String str2 : arrayList) {
            if (Strings4.contains$default((CharSequence) str2, (CharSequence) ":", false, 2, (Object) null)) {
                str2 = (String) Strings4.split$default((CharSequence) str2, new String[]{":"}, false, 0, 6, (Object) null).get(0);
            }
            arrayList2.add(str2);
        }
        return arrayList2;
    }

    private final String getKey(Long guildId, String commandId) {
        if (guildId == null) {
            return commandId;
        }
        return commandId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + guildId;
    }

    public final List<String> getTopCommandIds(Long guildId) {
        List<String> list = this.topCommandIdsSnapshot.get(Long.valueOf(guildId != null ? guildId.longValue() : 0L));
        return list != null ? list : Collections2.emptyList();
    }

    @Store3
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final Observable<List<String>> observeTopCommandIds(Long guildId) {
        Observable<List<String>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).T(getTopCommandIds(guildId));
        Intrinsics3.checkNotNullExpressionValue(observableT, "observationDeck.connectR…etTopCommandIds(guildId))");
        return observableT;
    }

    public final void onCommandUsed(Long guildId, String commandId) {
        Intrinsics3.checkNotNullParameter(commandId, "commandId");
        this.dispatcher.schedule(new AnonymousClass1(guildId, commandId));
    }

    public final void populateStore() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null)) {
            if (Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                List listSplit$default = Strings4.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                Long longOrNull = StringNumberConversions.toLongOrNull((String) listSplit$default.get(1));
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
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), _Collections.toList((Iterable) entry.getValue()));
        }
        this.topCommandIds = Maps6.toMutableMap(linkedHashMap2);
        this.topCommandIdsSnapshot = linkedHashMap;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        this.topCommandIdsSnapshot = new HashMap(this.topCommandIds);
    }

    public StoreApplicationCommandFrecency(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        Persister<ApplicationCommandFrecencyTracker> persister = new Persister<>("CACHE_KEY_APPLICATION_COMMANDS", new ApplicationCommandFrecencyTracker(0, 0, 3, null));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.topCommandIds = new LinkedHashMap();
        this.topCommandIdsSnapshot = Maps6.emptyMap();
        populateStore();
    }
}
