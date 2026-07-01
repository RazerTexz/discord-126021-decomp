package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelGuildIntegration$Update;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildIntegrations {
    private final HashMap<Long, Map<Long, ModelGuildIntegration>> allIntegrations;
    private Subscription closeIntegrationScreenSubscription;
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, Map<Long, ModelGuildIntegration>>> integrationsSubject;
    private boolean isOnIntegrationsScreen;

    public StoreGuildIntegrations(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.allIntegrations = new HashMap<>();
        this.integrationsSubject = BehaviorSubject.l0(new HashMap());
    }

    public static final /* synthetic */ Subscription access$getCloseIntegrationScreenSubscription$p(StoreGuildIntegrations storeGuildIntegrations) {
        return storeGuildIntegrations.closeIntegrationScreenSubscription;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildIntegrations storeGuildIntegrations) {
        return storeGuildIntegrations.dispatcher;
    }

    public static final /* synthetic */ void access$handleIntegrationScreenClosed(StoreGuildIntegrations storeGuildIntegrations) {
        storeGuildIntegrations.handleIntegrationScreenClosed();
    }

    public static final /* synthetic */ void access$handleIntegrationScreenOpened(StoreGuildIntegrations storeGuildIntegrations, long j) {
        storeGuildIntegrations.handleIntegrationScreenOpened(j);
    }

    public static final /* synthetic */ void access$handleIntegrationsLoaded(StoreGuildIntegrations storeGuildIntegrations, long j, List list) {
        storeGuildIntegrations.handleIntegrationsLoaded(j, list);
    }

    public static final /* synthetic */ void access$setCloseIntegrationScreenSubscription$p(StoreGuildIntegrations storeGuildIntegrations, Subscription subscription) {
        storeGuildIntegrations.closeIntegrationScreenSubscription = subscription;
    }

    @StoreThread
    private final void handleIntegrationScreenClosed() {
        this.isOnIntegrationsScreen = false;
    }

    @StoreThread
    private final void handleIntegrationScreenOpened(long guildId) {
        if (this.isOnIntegrationsScreen) {
            return;
        }
        this.isOnIntegrationsScreen = true;
        requestGuildIntegrations(guildId);
    }

    @StoreThread
    private final void handleIntegrationsLoaded(long guildId, List<? extends ModelGuildIntegration> integrations) {
        HashMap<Long, Map<Long, ModelGuildIntegration>> map = this.allIntegrations;
        Long lValueOf = Long.valueOf(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(integrations, 10)), 16));
        for (Object obj : integrations) {
            linkedHashMap.put(Long.valueOf(((ModelGuildIntegration) obj).getId()), obj);
        }
        map.put(lValueOf, linkedHashMap);
        this.integrationsSubject.onNext(new HashMap(this.allIntegrations));
    }

    private final void requestGuildIntegrations(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getGuildIntegrations(guildId), false, 1, null), StoreGuildIntegrations.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuildIntegrations$requestGuildIntegrations$1(this, guildId), 62, (Object) null);
    }

    public final Observable<Map<Long, ModelGuildIntegration>> get(long guildId) {
        Observable<Map<Long, ModelGuildIntegration>> observableR = this.integrationsSubject.G(new StoreGuildIntegrations$get$1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "integrationsSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleUpdate(ModelGuildIntegration$Update update) {
        if (!this.isOnIntegrationsScreen || update == null) {
            return;
        }
        requestGuildIntegrations(update.getGuildId());
    }

    public final synchronized void onIntegrationScreenClosed() {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<Long> observableD0 = Observable.d0(1000L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, getClass(), (Context) null, new StoreGuildIntegrations$onIntegrationScreenClosed$2(this), (Function1) null, (Function0) null, (Function0) null, new StoreGuildIntegrations$onIntegrationScreenClosed$1(this), 58, (Object) null);
    }

    public final synchronized void onIntegrationScreenOpened(long guildId) {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.dispatcher.schedule(new StoreGuildIntegrations$onIntegrationScreenOpened$1(this, guildId));
    }

    public final Observable<ModelGuildIntegration> get(long guildId, long integrationId) {
        Observable<ModelGuildIntegration> observableR = get(guildId).G(new StoreGuildIntegrations$get$2(integrationId)).r();
        m.checkNotNullExpressionValue(observableR, "get(guildId)\n          .…  .distinctUntilChanged()");
        return observableR;
    }
}
