package com.discord.stores;

import com.discord.api.application.Application;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication extends StoreV2 {
    private final HashMap<Long, Application> applications;
    private final HashSet<Long> applicationsLoading;
    private HashMap<Long, Application> applicationsSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreApplication.kt */
        public static final class C00761 extends Lambda implements Function1<List<? extends Application>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplication.kt */
            public static final class C00771 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00771(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object next;
                    StoreApplication.this.applicationsLoading.remove(Long.valueOf(AnonymousClass1.this.$appId));
                    Iterator it = this.$results.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!(((Application) next).getId() == AnonymousClass1.this.$appId));
                    Application application = (Application) next;
                    if (application != null) {
                        StoreApplication.this.applications.put(Long.valueOf(AnonymousClass1.this.$appId), application);
                        StoreApplication.this.markChanged();
                    }
                }
            }

            public C00761() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
                invoke2((List<Application>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Application> list) {
                Intrinsics3.checkNotNullParameter(list, "results");
                StoreApplication.this.dispatcher.schedule(new C00771(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplication.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplication.kt */
            public static final class C00781 extends Lambda implements Function0<Unit> {
                public C00781() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplication.this.applicationsLoading.remove(Long.valueOf(AnonymousClass1.this.$appId));
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
                StoreApplication.this.dispatcher.schedule(new C00781());
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
            if (StoreApplication.this.applications.containsKey(Long.valueOf(this.$appId)) || StoreApplication.this.applicationsLoading.contains(Long.valueOf(this.$appId))) {
                return;
            }
            StoreApplication.this.applicationsLoading.add(Long.valueOf(this.$appId));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getApplications(this.$appId), false, 1, null), (Class<?>) StoreApplication.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C00761());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$observeApplication$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Application> {
        public final /* synthetic */ Long $appId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$appId = l;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Application invoke() {
            return (Application) StoreApplication.this.applicationsSnapshot.get(this.$appId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$observeApplications$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Application>> {
        public final /* synthetic */ Collection $applicationIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Collection collection) {
            super(0);
            this.$applicationIds = collection;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Application> invoke() {
            HashMap map = StoreApplication.this.applicationsSnapshot;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.$applicationIds.contains(Long.valueOf(((Number) entry.getKey()).longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    public StoreApplication(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.applications = new HashMap<>();
        this.applicationsLoading = new HashSet<>();
        this.applicationsSnapshot = new HashMap<>();
    }

    public final void fetchIfNonexisting(long appId) {
        this.dispatcher.schedule(new AnonymousClass1(appId));
    }

    public final Observable<Application> observeApplication(Long appId) {
        if (appId != null) {
            fetchIfNonexisting(appId.longValue());
            return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(appId), 14, null);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(null)");
        return scalarSynchronousObservable;
    }

    public final Observable<Map<Long, Application>> observeApplications(Collection<Long> applicationIds) {
        Intrinsics3.checkNotNullParameter(applicationIds, "applicationIds");
        Observable<Map<Long, Application>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(applicationIds), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.applicationsSnapshot = new HashMap<>(this.applications);
    }
}
