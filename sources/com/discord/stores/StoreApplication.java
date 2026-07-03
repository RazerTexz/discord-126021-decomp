package com.discord.stores;

import com.discord.api.application.Application;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
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
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication extends StoreV2 {
    private final HashMap<Long, Application> applications;
    private final HashSet<Long> applicationsLoading;
    private HashMap<Long, Application> applicationsSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1 */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class C56941 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplication.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<List<? extends Application>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplication.kt */
            public static final class C132461 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132461(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object next;
                    StoreApplication.this.applicationsLoading.remove(Long.valueOf(C56941.this.$appId));
                    Iterator it = this.$results.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!(((Application) next).getId() == C56941.this.$appId));
                    Application application = (Application) next;
                    if (application != null) {
                        StoreApplication.this.applications.put(Long.valueOf(C56941.this.$appId), application);
                        StoreApplication.this.markChanged();
                    }
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
                invoke2((List<Application>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Application> list) {
                C12238m.checkNotNullParameter(list, "results");
                StoreApplication.this.dispatcher.schedule(new C132461(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplication.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreApplication.kt */
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
                    StoreApplication.this.applicationsLoading.remove(Long.valueOf(C56941.this.$appId));
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
                StoreApplication.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56941(long j) {
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
            if (StoreApplication.this.applications.containsKey(Long.valueOf(this.$appId)) || StoreApplication.this.applicationsLoading.contains(Long.valueOf(this.$appId))) {
                return;
            }
            StoreApplication.this.applicationsLoading.add(Long.valueOf(this.$appId));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getApplications(this.$appId), false, 1, null), (Class<?>) StoreApplication.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$observeApplication$1 */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class C56951 extends AbstractC12240o implements Function0<Application> {
        public final /* synthetic */ Long $appId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56951(Long l) {
            super(0);
            this.$appId = l;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Application invoke() {
            return (Application) StoreApplication.this.applicationsSnapshot.get(this.$appId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$observeApplications$1 */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class C56961 extends AbstractC12240o implements Function0<Map<Long, ? extends Application>> {
        public final /* synthetic */ Collection $applicationIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56961(Collection collection) {
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
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.applications = new HashMap<>();
        this.applicationsLoading = new HashSet<>();
        this.applicationsSnapshot = new HashMap<>();
    }

    public final void fetchIfNonexisting(long appId) {
        this.dispatcher.schedule(new C56941(appId));
    }

    public final Observable<Application> observeApplication(Long appId) {
        if (appId != null) {
            fetchIfNonexisting(appId.longValue());
            return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56951(appId), 14, null);
        }
        C12721k c12721k = new C12721k(null);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable\n          .just(null)");
        return c12721k;
    }

    public final Observable<Map<Long, Application>> observeApplications(Collection<Long> applicationIds) {
        C12238m.checkNotNullParameter(applicationIds, "applicationIds");
        Observable<Map<Long, Application>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56961(applicationIds), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.applicationsSnapshot = new HashMap<>(this.applications);
    }
}
