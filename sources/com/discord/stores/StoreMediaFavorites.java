package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.persister.Persister;
import d0.e0.c;
import d0.t.n0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites extends StoreV2 {
    public static final StoreMediaFavorites$Companion Companion = new StoreMediaFavorites$Companion(null);
    public static final String FAVORITES_CACHE_KEY = "STORE_FAVORITES";
    private final Dispatcher dispatcher;
    private final Set<StoreMediaFavorites$Favorite> favorites;
    private Set<? extends StoreMediaFavorites$Favorite> favoritesSnapshot;
    private final ObservationDeck observationDeck;
    private final Persister<Set<StoreMediaFavorites$Favorite>> persister;

    public /* synthetic */ StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? new Persister(FAVORITES_CACHE_KEY, n0.emptySet()) : persister);
    }

    public static final /* synthetic */ Set access$getFavorites$p(StoreMediaFavorites storeMediaFavorites) {
        return storeMediaFavorites.favorites;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getFavorites$default(StoreMediaFavorites storeMediaFavorites, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = StoreMediaFavorites$Favorite.Companion.getAllTypes();
        }
        return storeMediaFavorites.getFavorites(set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable observeFavorites$default(StoreMediaFavorites storeMediaFavorites, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = StoreMediaFavorites$Favorite.Companion.getAllTypes();
        }
        return storeMediaFavorites.observeFavorites(set);
    }

    public final void addFavorite(StoreMediaFavorites$Favorite favorite) {
        m.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new StoreMediaFavorites$addFavorite$1(this, favorite));
    }

    public final Set<StoreMediaFavorites$Favorite> getFavorites(Set<? extends c<? extends StoreMediaFavorites$Favorite>> types) {
        m.checkNotNullParameter(types, "types");
        Set<? extends StoreMediaFavorites$Favorite> set = this.favoritesSnapshot;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (types.contains(a0.getOrCreateKotlinClass(((StoreMediaFavorites$Favorite) obj).getClass()))) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public final Observable<Set<StoreMediaFavorites$Favorite>> observeFavorites(Set<? extends c<? extends StoreMediaFavorites$Favorite>> types) {
        m.checkNotNullParameter(types, "types");
        Observable<Set<StoreMediaFavorites$Favorite>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMediaFavorites$observeFavorites$1(this, types), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeFavorite(StoreMediaFavorites$Favorite favorite) {
        m.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new StoreMediaFavorites$removeFavorite$1(this, favorite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashSet hashSet = new HashSet(this.favorites);
        this.favoritesSnapshot = hashSet;
        this.persister.set(hashSet, true);
    }

    public StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister<Set<StoreMediaFavorites$Favorite>> persister) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(persister, "persister");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.persister = persister;
        Set<StoreMediaFavorites$Favorite> set = persister.get();
        this.favoritesSnapshot = set;
        this.favorites = u.toMutableSet(set);
    }
}
