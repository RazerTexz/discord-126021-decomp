package com.discord.stores;

import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserAffinity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities extends StoreV2 {
    private ModelUserAffinities affinities;
    private ModelUserAffinities affinitiesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserAffinities.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserAffinities, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreUserAffinities.kt */
        public static final class C01831 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelUserAffinities $affinities;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01831(ModelUserAffinities modelUserAffinities) {
                super(0);
                this.$affinities = modelUserAffinities;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserAffinities.this.handleUserAffinitiesFetchSuccess(this.$affinities);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserAffinities modelUserAffinities) {
            invoke2(modelUserAffinities);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserAffinities modelUserAffinities) {
            Intrinsics3.checkNotNullParameter(modelUserAffinities, "affinities");
            StoreUserAffinities.this.dispatcher.schedule(new C01831(modelUserAffinities));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserAffinities$observeUserAffinities$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserAffinities.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelUserAffinities> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelUserAffinities invoke() {
            return StoreUserAffinities.this.affinitiesSnapshot;
        }
    }

    public /* synthetic */ StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final void fetchUserAffinities() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserAffinities(), false, 1, null), (Class<?>) StoreUserAffinities.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Store3
    private final void handleUserAffinitiesFetchSuccess(ModelUserAffinities affinities) {
        this.affinities = affinities;
        markChanged();
    }

    private final Observable<ModelUserAffinities> observeUserAffinities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Store3
    public final void handleConnectionOpen() {
        fetchUserAffinities();
    }

    public final Observable<List<Long>> observeAffinityUserIds() {
        Observable<List<Long>> observableR = observeUserAffinities().G(new Func1<ModelUserAffinities, List<? extends Long>>() { // from class: com.discord.stores.StoreUserAffinities.observeAffinityUserIds.1
            @Override // j0.k.Func1
            public final List<Long> call(ModelUserAffinities modelUserAffinities) {
                List<ModelUserAffinity> userAffinities = modelUserAffinities.getUserAffinities();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(userAffinities, 10));
                Iterator<T> it = userAffinities.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ModelUserAffinity) it.next()).getUserId()));
                }
                return arrayList;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeUserAffinities()\n…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.affinitiesSnapshot = new ModelUserAffinities(_Collections.toList(this.affinities.getUserAffinities()), _Collections.toList(this.affinities.getInverseUserAffinities()));
    }

    public StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.affinities = new ModelUserAffinities(Collections2.emptyList(), Collections2.emptyList());
        this.affinitiesSnapshot = new ModelUserAffinities(Collections2.emptyList(), Collections2.emptyList());
    }
}
