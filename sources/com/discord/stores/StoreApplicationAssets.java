package com.discord.stores;

import com.discord.api.application.ApplicationAsset;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreApplicationAssets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationAssets extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
    private final HashSet<Long> embeddedAppBackgroundsLoading;
    private Map<Long, ApplicationAsset> embeddedAppBackgroundsSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    public /* synthetic */ StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.dispatcher;
    }

    public static final /* synthetic */ Map access$getEmbeddedAppBackgrounds$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.embeddedAppBackgrounds;
    }

    public static final /* synthetic */ HashSet access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.embeddedAppBackgroundsLoading;
    }

    public static final /* synthetic */ RestAPI access$getRestApi$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.restApi;
    }

    public static final /* synthetic */ void access$handleApplicationAssets(StoreApplicationAssets storeApplicationAssets, long j, List list) {
        storeApplicationAssets.handleApplicationAssets(j, list);
    }

    @StoreThread
    private final void handleApplicationAssets(long applicationId, List<ApplicationAsset> appAssets) {
        Object next;
        Iterator<T> it = appAssets.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((ApplicationAsset) next).getName(), "embedded_background"));
        ApplicationAsset applicationAsset = (ApplicationAsset) next;
        if (applicationAsset != null) {
            this.embeddedAppBackgrounds.put(Long.valueOf(applicationId), applicationAsset);
            markChanged();
        }
    }

    public final void fetchIfNonExisting(long appId) {
        this.dispatcher.schedule(new StoreApplicationAssets$fetchIfNonExisting$1(this, appId));
    }

    public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
        return this.embeddedAppBackgroundsSnapshot;
    }

    public final Observable<Map<Long, ApplicationAsset>> observeEmbeddedAppBackgrounds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationAssets$observeEmbeddedAppBackgrounds$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.embeddedAppBackgroundsSnapshot = new HashMap(this.embeddedAppBackgrounds);
    }

    public StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.embeddedAppBackgrounds = new LinkedHashMap();
        this.embeddedAppBackgroundsLoading = new HashSet<>();
        this.embeddedAppBackgroundsSnapshot = h0.emptyMap();
    }
}
