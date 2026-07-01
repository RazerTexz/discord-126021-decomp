package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities extends StoreV2 {
    private ModelUserAffinities affinities;
    private ModelUserAffinities affinitiesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    public /* synthetic */ StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ ModelUserAffinities access$getAffinitiesSnapshot$p(StoreUserAffinities storeUserAffinities) {
        return storeUserAffinities.affinitiesSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserAffinities storeUserAffinities) {
        return storeUserAffinities.dispatcher;
    }

    public static final /* synthetic */ void access$handleUserAffinitiesFetchSuccess(StoreUserAffinities storeUserAffinities, ModelUserAffinities modelUserAffinities) {
        storeUserAffinities.handleUserAffinitiesFetchSuccess(modelUserAffinities);
    }

    public static final /* synthetic */ void access$setAffinitiesSnapshot$p(StoreUserAffinities storeUserAffinities, ModelUserAffinities modelUserAffinities) {
        storeUserAffinities.affinitiesSnapshot = modelUserAffinities;
    }

    @StoreThread
    private final void fetchUserAffinities() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getUserAffinities(), false, 1, null), StoreUserAffinities.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserAffinities$fetchUserAffinities$1(this), 62, (Object) null);
    }

    @StoreThread
    private final void handleUserAffinitiesFetchSuccess(ModelUserAffinities affinities) {
        this.affinities = affinities;
        markChanged();
    }

    private final Observable<ModelUserAffinities> observeUserAffinities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserAffinities$observeUserAffinities$1(this), 14, null);
    }

    @StoreThread
    public final void handleConnectionOpen() {
        fetchUserAffinities();
    }

    public final Observable<List<Long>> observeAffinityUserIds() {
        Observable<List<Long>> observableR = observeUserAffinities().G(StoreUserAffinities$observeAffinityUserIds$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeUserAffinities()\n…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.affinitiesSnapshot = new ModelUserAffinities(u.toList(this.affinities.getUserAffinities()), u.toList(this.affinities.getInverseUserAffinities()));
    }

    public StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.affinities = new ModelUserAffinities(n.emptyList(), n.emptyList());
        this.affinitiesSnapshot = new ModelUserAffinities(n.emptyList(), n.emptyList());
    }
}
