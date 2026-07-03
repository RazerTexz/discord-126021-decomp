package com.discord.stores;

import com.discord.models.domain.ModelLibraryApplication;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreLibrary.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLibrary extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ModelLibraryApplication> libraryApplicationSnapshot;
    private final Map<Long, ModelLibraryApplication> libraryApplications;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreLibrary$fetchApplications$1 */
    /* JADX INFO: compiled from: StoreLibrary.kt */
    public static final class C61401 extends AbstractC12240o implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreLibrary$fetchApplications$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreLibrary.kt */
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
                StoreLibrary.this.libraryApplications.clear();
                StoreLibrary.this.markChanged();
            }
        }

        public C61401() {
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
            StoreLibrary.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLibrary$fetchApplications$2 */
    /* JADX INFO: compiled from: StoreLibrary.kt */
    public static final class C61412 extends AbstractC12240o implements Function1<List<? extends ModelLibraryApplication>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreLibrary$fetchApplications$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreLibrary.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $libraryApps;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$libraryApps = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap map = new HashMap();
                for (ModelLibraryApplication modelLibraryApplication : this.$libraryApps) {
                    map.put(Long.valueOf(modelLibraryApplication.getSkuId()), modelLibraryApplication);
                }
                StoreLibrary.this.libraryApplications.clear();
                StoreLibrary.this.libraryApplications.putAll(map);
                StoreLibrary.this.markChanged();
            }
        }

        public C61412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelLibraryApplication> list) {
            invoke2((List<ModelLibraryApplication>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelLibraryApplication> list) {
            C12238m.checkNotNullParameter(list, "libraryApps");
            StoreLibrary.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLibrary$observeApplications$1 */
    /* JADX INFO: compiled from: StoreLibrary.kt */
    public static final class C61421 extends AbstractC12240o implements Function0<Map<Long, ? extends ModelLibraryApplication>> {
        public C61421() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends ModelLibraryApplication> invoke() {
            return StoreLibrary.this.libraryApplicationSnapshot;
        }
    }

    public /* synthetic */ StoreLibrary(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void fetchApplications() {
        if (this.libraryApplicationSnapshot != null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getLibrary(), false, 1, null), (Class<?>) StoreLibrary.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C61401()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61412());
    }

    public final Map<Long, ModelLibraryApplication> getApplications() {
        return this.libraryApplicationSnapshot;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Observable<Map<Long, ModelLibraryApplication>> observeApplications() {
        fetchApplications();
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61421(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.libraryApplicationSnapshot = new HashMap(this.libraryApplications);
    }

    public StoreLibrary(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.libraryApplications = new LinkedHashMap();
    }
}
