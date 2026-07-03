package com.discord.stores;

import com.discord.models.domain.ModelGuildIntegration;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildIntegrations {
    private final HashMap<Long, Map<Long, ModelGuildIntegration>> allIntegrations;
    private Subscription closeIntegrationScreenSubscription;
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, Map<Long, ModelGuildIntegration>>> integrationsSubject;
    private boolean isOnIntegrationsScreen;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1 */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class C60241 extends AbstractC12240o implements Function1<Long, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
        public static final /* synthetic */ class AnonymousClass1 extends C12236k implements Function0<Unit> {
            public AnonymousClass1(StoreGuildIntegrations storeGuildIntegrations) {
                super(0, storeGuildIntegrations, StoreGuildIntegrations.class, "handleIntegrationScreenClosed", "handleIntegrationScreenClosed()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((StoreGuildIntegrations) this.receiver).handleIntegrationScreenClosed();
            }
        }

        public C60241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreGuildIntegrations.this.dispatcher.schedule(new AnonymousClass1(StoreGuildIntegrations.this));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$2 */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class C60252 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C60252() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            StoreGuildIntegrations.this.closeIntegrationScreenSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenOpened$1 */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class C60261 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60261(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildIntegrations.this.handleIntegrationScreenOpened(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1 */
    /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
    public static final class C60271 extends AbstractC12240o implements Function1<List<? extends ModelGuildIntegration>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildIntegrations.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $integrations;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$integrations = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60271 c60271 = C60271.this;
                StoreGuildIntegrations.this.handleIntegrationsLoaded(c60271.$guildId, this.$integrations);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60271(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildIntegration> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelGuildIntegration> list) {
            C12238m.checkNotNullParameter(list, "integrations");
            StoreGuildIntegrations.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    public StoreGuildIntegrations(Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.allIntegrations = new HashMap<>();
        this.integrationsSubject = BehaviorSubject.m11130l0(new HashMap());
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(integrations, 10)), 16));
        for (Object obj : integrations) {
            linkedHashMap.put(Long.valueOf(((ModelGuildIntegration) obj).getId()), obj);
        }
        map.put(lValueOf, linkedHashMap);
        this.integrationsSubject.onNext(new HashMap(this.allIntegrations));
    }

    private final void requestGuildIntegrations(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildIntegrations(guildId), false, 1, null), (Class<?>) StoreGuildIntegrations.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60271(guildId));
    }

    public final Observable<Map<Long, ModelGuildIntegration>> get(final long guildId) {
        Observable<Map<Long, ModelGuildIntegration>> observableM11112r = this.integrationsSubject.m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>>, Map<Long, ? extends ModelGuildIntegration>>() { // from class: com.discord.stores.StoreGuildIntegrations.get.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Map<Long, ModelGuildIntegration> call(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
                return (Map) map.get(Long.valueOf(guildId));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "integrationsSubject\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @StoreThread
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
        Observable<Long> observableM11068d0 = Observable.m11068d0(1000L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableM11068d0, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C60252()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60241());
    }

    public final synchronized void onIntegrationScreenOpened(long guildId) {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.dispatcher.schedule(new C60261(guildId));
    }

    public final Observable<ModelGuildIntegration> get(long guildId, final long integrationId) {
        Observable<ModelGuildIntegration> observableM11112r = get(guildId).m11083G(new InterfaceC12589b<Map<Long, ? extends ModelGuildIntegration>, ModelGuildIntegration>() { // from class: com.discord.stores.StoreGuildIntegrations.get.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final ModelGuildIntegration call(Map<Long, ? extends ModelGuildIntegration> map) {
                if (map != null) {
                    return map.get(Long.valueOf(integrationId));
                }
                return null;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "get(guildId)\n          .…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
