package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreLibrary.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLibrary extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ModelLibraryApplication> libraryApplicationSnapshot;
    private final Map<Long, ModelLibraryApplication> libraryApplications;
    private final ObservationDeck observationDeck;

    public /* synthetic */ StoreLibrary(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getLibraryApplicationSnapshot$p(StoreLibrary storeLibrary) {
        return storeLibrary.libraryApplicationSnapshot;
    }

    public static final /* synthetic */ Map access$getLibraryApplications$p(StoreLibrary storeLibrary) {
        return storeLibrary.libraryApplications;
    }

    public static final /* synthetic */ void access$setLibraryApplicationSnapshot$p(StoreLibrary storeLibrary, Map map) {
        storeLibrary.libraryApplicationSnapshot = map;
    }

    public final void fetchApplications() {
        if (this.libraryApplicationSnapshot != null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getLibrary(), false, 1, null), StoreLibrary.class, (Context) null, (Function1) null, new StoreLibrary$fetchApplications$1(this), (Function0) null, (Function0) null, new StoreLibrary$fetchApplications$2(this), 54, (Object) null);
    }

    public final Map<Long, ModelLibraryApplication> getApplications() {
        return this.libraryApplicationSnapshot;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Observable<Map<Long, ModelLibraryApplication>> observeApplications() {
        fetchApplications();
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreLibrary$observeApplications$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.libraryApplicationSnapshot = new HashMap(this.libraryApplications);
    }

    public StoreLibrary(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.libraryApplications = new LinkedHashMap();
    }
}
