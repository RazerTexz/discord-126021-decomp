package com.discord.stores;

import com.discord.api.application.Application;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import j0.l.e.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication extends StoreV2 {
    private final HashMap<Long, Application> applications;
    private final HashSet<Long> applicationsLoading;
    private HashMap<Long, Application> applicationsSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    public StoreApplication(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.applications = new HashMap<>();
        this.applicationsLoading = new HashSet<>();
        this.applicationsSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getApplications$p(StoreApplication storeApplication) {
        return storeApplication.applications;
    }

    public static final /* synthetic */ HashSet access$getApplicationsLoading$p(StoreApplication storeApplication) {
        return storeApplication.applicationsLoading;
    }

    public static final /* synthetic */ HashMap access$getApplicationsSnapshot$p(StoreApplication storeApplication) {
        return storeApplication.applicationsSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplication storeApplication) {
        return storeApplication.dispatcher;
    }

    public static final /* synthetic */ void access$setApplicationsSnapshot$p(StoreApplication storeApplication, HashMap map) {
        storeApplication.applicationsSnapshot = map;
    }

    public final void fetchIfNonexisting(long appId) {
        this.dispatcher.schedule(new StoreApplication$fetchIfNonexisting$1(this, appId));
    }

    public final Observable<Application> observeApplication(Long appId) {
        if (appId != null) {
            fetchIfNonexisting(appId.longValue());
            return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplication$observeApplication$1(this, appId), 14, null);
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable\n          .just(null)");
        return kVar;
    }

    public final Observable<Map<Long, Application>> observeApplications(Collection<Long> applicationIds) {
        m.checkNotNullParameter(applicationIds, "applicationIds");
        Observable<Map<Long, Application>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplication$observeApplications$1(this, applicationIds), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.applicationsSnapshot = new HashMap<>(this.applications);
    }
}
