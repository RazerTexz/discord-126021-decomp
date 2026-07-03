package com.discord.stores;

import com.discord.api.application.ApplicationAsset;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreApplicationAssets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationAssets extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
    private final HashSet<Long> embeddedAppBackgroundsLoading;
    private Map<Long, ApplicationAsset> embeddedAppBackgroundsSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1 */
    /* JADX INFO: compiled from: StoreApplicationAssets.kt */
    public static final class C56971 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationAssets.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<List<? extends ApplicationAsset>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplicationAssets.kt */
            public static final class C132471 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ List $applicationAssets;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132471(List list) {
                    super(0);
                    this.$applicationAssets = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.this.embeddedAppBackgroundsLoading.remove(Long.valueOf(C56971.this.$appId));
                    C56971 c56971 = C56971.this;
                    StoreApplicationAssets.this.handleApplicationAssets(c56971.$appId, this.$applicationAssets);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApplicationAsset> list) {
                invoke2((List<ApplicationAsset>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApplicationAsset> list) {
                C12238m.checkNotNullParameter(list, "applicationAssets");
                StoreApplicationAssets.this.dispatcher.schedule(new C132471(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationAssets.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreApplicationAssets.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.this.embeddedAppBackgroundsLoading.remove(Long.valueOf(C56971.this.$appId));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "it");
                StoreApplicationAssets.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56971(long j) {
            super(0);
            this.$appId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplicationAssets.this.embeddedAppBackgrounds.containsKey(Long.valueOf(this.$appId)) || StoreApplicationAssets.this.embeddedAppBackgroundsLoading.contains(Long.valueOf(this.$appId))) {
                return;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationAssets.this.restApi.getApplicationAssets(this.$appId), false, 1, null), (Class<?>) StoreApplicationAssets.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$observeEmbeddedAppBackgrounds$1 */
    /* JADX INFO: compiled from: StoreApplicationAssets.kt */
    public static final class C56981 extends AbstractC12240o implements Function0<Map<Long, ? extends ApplicationAsset>> {
        public C56981() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends ApplicationAsset> invoke() {
            return StoreApplicationAssets.this.getEmbeddedAppBackgrounds();
        }
    }

    public /* synthetic */ StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
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
        } while (!C12238m.areEqual(((ApplicationAsset) next).getName(), "embedded_background"));
        ApplicationAsset applicationAsset = (ApplicationAsset) next;
        if (applicationAsset != null) {
            this.embeddedAppBackgrounds.put(Long.valueOf(applicationId), applicationAsset);
            markChanged();
        }
    }

    public final void fetchIfNonExisting(long appId) {
        this.dispatcher.schedule(new C56971(appId));
    }

    public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
        return this.embeddedAppBackgroundsSnapshot;
    }

    public final Observable<Map<Long, ApplicationAsset>> observeEmbeddedAppBackgrounds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56981(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.embeddedAppBackgroundsSnapshot = new HashMap(this.embeddedAppBackgrounds);
    }

    public StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.embeddedAppBackgrounds = new LinkedHashMap();
        this.embeddedAppBackgroundsLoading = new HashSet<>();
        this.embeddedAppBackgroundsSnapshot = C12136h0.emptyMap();
    }
}
