package com.discord.stores;

import com.discord.api.application.ApplicationAsset;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreApplicationAssets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationAssets extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
    private final HashSet<Long> embeddedAppBackgroundsLoading;
    private Map<Long, ApplicationAsset> embeddedAppBackgroundsSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationAssets.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreApplicationAssets.kt */
        public static final class C00791 extends Lambda implements Function1<List<? extends ApplicationAsset>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplicationAssets.kt */
            public static final class C00801 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $applicationAssets;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00801(List list) {
                    super(0);
                    this.$applicationAssets = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.this.embeddedAppBackgroundsLoading.remove(Long.valueOf(AnonymousClass1.this.$appId));
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreApplicationAssets.this.handleApplicationAssets(anonymousClass1.$appId, this.$applicationAssets);
                }
            }

            public C00791() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApplicationAsset> list) {
                invoke2((List<ApplicationAsset>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApplicationAsset> list) {
                Intrinsics3.checkNotNullParameter(list, "applicationAssets");
                StoreApplicationAssets.this.dispatcher.schedule(new C00801(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationAssets.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplicationAssets.kt */
            public static final class C00811 extends Lambda implements Function0<Unit> {
                public C00811() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.this.embeddedAppBackgroundsLoading.remove(Long.valueOf(AnonymousClass1.this.$appId));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreApplicationAssets.this.dispatcher.schedule(new C00811());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$appId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplicationAssets.this.embeddedAppBackgrounds.containsKey(Long.valueOf(this.$appId)) || StoreApplicationAssets.this.embeddedAppBackgroundsLoading.contains(Long.valueOf(this.$appId))) {
                return;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationAssets.this.restApi.getApplicationAssets(this.$appId), false, 1, null), (Class<?>) StoreApplicationAssets.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C00791());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationAssets$observeEmbeddedAppBackgrounds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationAssets.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ApplicationAsset>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends ApplicationAsset> invoke() {
            return StoreApplicationAssets.this.getEmbeddedAppBackgrounds();
        }
    }

    public /* synthetic */ StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    @Store3
    private final void handleApplicationAssets(long applicationId, List<ApplicationAsset> appAssets) {
        Object next;
        Iterator<T> it = appAssets.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics3.areEqual(((ApplicationAsset) next).getName(), "embedded_background"));
        ApplicationAsset applicationAsset = (ApplicationAsset) next;
        if (applicationAsset != null) {
            this.embeddedAppBackgrounds.put(Long.valueOf(applicationId), applicationAsset);
            markChanged();
        }
    }

    public final void fetchIfNonExisting(long appId) {
        this.dispatcher.schedule(new AnonymousClass1(appId));
    }

    public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
        return this.embeddedAppBackgroundsSnapshot;
    }

    public final Observable<Map<Long, ApplicationAsset>> observeEmbeddedAppBackgrounds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.embeddedAppBackgroundsSnapshot = new HashMap(this.embeddedAppBackgrounds);
    }

    public StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.embeddedAppBackgrounds = new LinkedHashMap();
        this.embeddedAppBackgroundsLoading = new HashSet<>();
        this.embeddedAppBackgroundsSnapshot = Maps6.emptyMap();
    }
}
