package com.discord.stores;

import com.discord.models.domain.ModelGuildIntegration;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
        public static final /* synthetic */ class C01171 extends FunctionReferenceImpl implements Function0<Unit> {
            public C01171(StoreGuildIntegrations storeGuildIntegrations) {
                super(0, storeGuildIntegrations, StoreGuildIntegrations.class, "handleIntegrationScreenClosed", "handleIntegrationScreenClosed()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((StoreGuildIntegrations) this.receiver).handleIntegrationScreenClosed();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreGuildIntegrations.this.dispatcher.schedule(new C01171(StoreGuildIntegrations.this));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreGuildIntegrations.this.closeIntegrationScreenSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenOpened$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildIntegrations.this.handleIntegrationScreenOpened(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelGuildIntegration>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
        public static final class C01181 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $integrations;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01181(List list) {
                super(0);
                this.$integrations = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildIntegrations.this.handleIntegrationsLoaded(anonymousClass1.$guildId, this.$integrations);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildIntegration> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelGuildIntegration> list) {
            Intrinsics3.checkNotNullParameter(list, "integrations");
            StoreGuildIntegrations.this.dispatcher.schedule(new C01181(list));
        }
    }

    public StoreGuildIntegrations(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.allIntegrations = new HashMap<>();
        this.integrationsSubject = BehaviorSubject.l0(new HashMap());
    }

    @Store3
    private final void handleIntegrationScreenClosed() {
        this.isOnIntegrationsScreen = false;
    }

    @Store3
    private final void handleIntegrationScreenOpened(long guildId) {
        if (this.isOnIntegrationsScreen) {
            return;
        }
        this.isOnIntegrationsScreen = true;
        requestGuildIntegrations(guildId);
    }

    @Store3
    private final void handleIntegrationsLoaded(long guildId, List<? extends ModelGuildIntegration> integrations) {
        HashMap<Long, Map<Long, ModelGuildIntegration>> map = this.allIntegrations;
        Long lValueOf = Long.valueOf(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(integrations, 10)), 16));
        for (Object obj : integrations) {
            linkedHashMap.put(Long.valueOf(((ModelGuildIntegration) obj).getId()), obj);
        }
        map.put(lValueOf, linkedHashMap);
        this.integrationsSubject.onNext(new HashMap(this.allIntegrations));
    }

    private final void requestGuildIntegrations(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildIntegrations(guildId), false, 1, null), (Class<?>) StoreGuildIntegrations.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId));
    }

    public final Observable<Map<Long, ModelGuildIntegration>> get(final long guildId) {
        Observable<Map<Long, ModelGuildIntegration>> observableR = this.integrationsSubject.G(new Func1<Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>>, Map<Long, ? extends ModelGuildIntegration>>() { // from class: com.discord.stores.StoreGuildIntegrations.get.1
            @Override // j0.k.Func1
            public final Map<Long, ModelGuildIntegration> call(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
                return (Map) map.get(Long.valueOf(guildId));
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "integrationsSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleUpdate(ModelGuildIntegration.Update update) {
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
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableD0, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final synchronized void onIntegrationScreenOpened(long guildId) {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Observable<ModelGuildIntegration> get(long guildId, final long integrationId) {
        Observable<ModelGuildIntegration> observableR = get(guildId).G(new Func1<Map<Long, ? extends ModelGuildIntegration>, ModelGuildIntegration>() { // from class: com.discord.stores.StoreGuildIntegrations.get.2
            @Override // j0.k.Func1
            public final ModelGuildIntegration call(Map<Long, ? extends ModelGuildIntegration> map) {
                if (map != null) {
                    return map.get(Long.valueOf(integrationId));
                }
                return null;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "get(guildId)\n          .…  .distinctUntilChanged()");
        return observableR;
    }
}
