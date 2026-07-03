package com.discord.stores;

import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserAffinity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities extends StoreV2 {
    private ModelUserAffinities affinities;
    private ModelUserAffinities affinitiesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1 */
    /* JADX INFO: compiled from: StoreUserAffinities.kt */
    public static final class C65581 extends AbstractC12240o implements Function1<ModelUserAffinities, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserAffinities.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ModelUserAffinities $affinities;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelUserAffinities modelUserAffinities) {
                super(0);
                this.$affinities = modelUserAffinities;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserAffinities.this.handleUserAffinitiesFetchSuccess(this.$affinities);
            }
        }

        public C65581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserAffinities modelUserAffinities) {
            invoke2(modelUserAffinities);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserAffinities modelUserAffinities) {
            C12238m.checkNotNullParameter(modelUserAffinities, "affinities");
            StoreUserAffinities.this.dispatcher.schedule(new AnonymousClass1(modelUserAffinities));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserAffinities$observeUserAffinities$1 */
    /* JADX INFO: compiled from: StoreUserAffinities.kt */
    public static final class C65601 extends AbstractC12240o implements Function0<ModelUserAffinities> {
        public C65601() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelUserAffinities invoke() {
            return StoreUserAffinities.this.affinitiesSnapshot;
        }
    }

    public /* synthetic */ StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void fetchUserAffinities() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserAffinities(), false, 1, null), (Class<?>) StoreUserAffinities.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65581());
    }

    @StoreThread
    private final void handleUserAffinitiesFetchSuccess(ModelUserAffinities affinities) {
        this.affinities = affinities;
        markChanged();
    }

    private final Observable<ModelUserAffinities> observeUserAffinities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65601(), 14, null);
    }

    @StoreThread
    public final void handleConnectionOpen() {
        fetchUserAffinities();
    }

    public final Observable<List<Long>> observeAffinityUserIds() {
        Observable<List<Long>> observableM11112r = observeUserAffinities().m11083G(new InterfaceC12589b<ModelUserAffinities, List<? extends Long>>() { // from class: com.discord.stores.StoreUserAffinities.observeAffinityUserIds.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<Long> call(ModelUserAffinities modelUserAffinities) {
                List<ModelUserAffinity> userAffinities = modelUserAffinities.getUserAffinities();
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(userAffinities, 10));
                Iterator<T> it = userAffinities.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ModelUserAffinity) it.next()).getUserId()));
                }
                return arrayList;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeUserAffinities()\n…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.affinitiesSnapshot = new ModelUserAffinities(C12163u.toList(this.affinities.getUserAffinities()), C12163u.toList(this.affinities.getInverseUserAffinities()));
    }

    public StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.affinities = new ModelUserAffinities(C12147n.emptyList(), C12147n.emptyList());
        this.affinitiesSnapshot = new ModelUserAffinities(C12147n.emptyList(), C12147n.emptyList());
    }
}
