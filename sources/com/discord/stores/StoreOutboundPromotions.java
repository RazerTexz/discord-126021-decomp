package com.discord.stores;

import android.content.Context;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.api.user.User;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.premium.OutboundPromosPreviewFeatureFlag;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions extends StoreV2 {
    private static final String CONSUMED_ENTITLEMENT_PROMO_ID = "CONSUMED_ENTITLEMENT_CODE";
    public static final StoreOutboundPromotions$Companion Companion = new StoreOutboundPromotions$Companion(null);
    private static final String LATEST_SEEN_PROMO_DATE = "LATEST_SEEN_PROMO_DATE";
    private static final long NO_PROMO_ID = -1;
    private static final long NO_SEEN_PROMO_DATE = -1;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final OutboundPromosPreviewFeatureFlag previewFeatureFlag;
    private final RestAPI restAPI;
    private StoreOutboundPromotions$State state;
    private StoreOutboundPromotions$State stateSnapshot;

    public /* synthetic */ StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(outboundPromosPreviewFeatureFlag, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.restAPI;
    }

    public static final /* synthetic */ StoreOutboundPromotions$State access$getState$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.state;
    }

    public static final /* synthetic */ int access$getUnseenCount(StoreOutboundPromotions storeOutboundPromotions, List list) {
        return storeOutboundPromotions.getUnseenCount(list);
    }

    public static final /* synthetic */ void access$setState$p(StoreOutboundPromotions storeOutboundPromotions, StoreOutboundPromotions$State storeOutboundPromotions$State) {
        storeOutboundPromotions.state = storeOutboundPromotions$State;
    }

    public final Observable<ClaimedOutboundPromotion> claimOutboundPromotion(long promotionId) {
        return this.restAPI.claimOutboundPromotion(promotionId);
    }

    public final Observable<List<ClaimedOutboundPromotion>> fetchClaimedOutboundPromotions() {
        return this.restAPI.getClaimedOutboundPromotions();
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final StoreOutboundPromotions$State getStateSnapshot() {
        return this.stateSnapshot;
    }

    public final int getUnseenCount() {
        StoreOutboundPromotions$State stateSnapshot = getStateSnapshot();
        if (!(stateSnapshot instanceof StoreOutboundPromotions$State$Loaded)) {
            stateSnapshot = null;
        }
        StoreOutboundPromotions$State$Loaded storeOutboundPromotions$State$Loaded = (StoreOutboundPromotions$State$Loaded) stateSnapshot;
        if (storeOutboundPromotions$State$Loaded != null) {
            return storeOutboundPromotions$State$Loaded.getUnseenCount();
        }
        return 0;
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload readyPayload) {
        m.checkNotNullParameter(readyPayload, "readyPayload");
        UserUtils userUtils = UserUtils.INSTANCE;
        User me2 = readyPayload.getMe();
        m.checkNotNullExpressionValue(me2, "readyPayload.me");
        if (!userUtils.isPremiumTier2(new MeUser(me2))) {
            this.state = new StoreOutboundPromotions$State$Loaded(n.emptyList(), 0);
            markChanged();
            return;
        }
        this.state = StoreOutboundPromotions$State$Loading.INSTANCE;
        markChanged();
        RestAPI restAPI = this.restAPI;
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(this.previewFeatureFlag.isEnabled() ? restAPI.getAllPreviewPromotions() : restAPI.getAllActiveOutboundPromotions(), false, 1, null).A(new StoreOutboundPromotions$handleConnectionOpen$2(this));
        m.checkNotNullExpressionValue(observableA, "restAPI.run {\n        if…            }\n          }");
        ObservableExtensionsKt.appSubscribe$default(observableA, StoreOutboundPromotions.class, (Context) null, (Function1) null, new StoreOutboundPromotions$handleConnectionOpen$3(this), (Function0) null, (Function0) null, new StoreOutboundPromotions$handleConnectionOpen$4(this), 54, (Object) null);
    }

    public final void markSeen() {
        this.dispatcher.schedule(new StoreOutboundPromotions$markSeen$1(this));
    }

    public final Observable<StoreOutboundPromotions$State> observeState() {
        Observable<StoreOutboundPromotions$State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreOutboundPromotions$observeState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeUnseenCount() {
        Observable<Integer> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreOutboundPromotions$observeUnseenCount$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.stateSnapshot = this.state.deepCopy();
    }

    private final int getUnseenCount(List<OutboundPromotion> promos) {
        long j = getPrefs().getLong(LATEST_SEEN_PROMO_DATE, -1L);
        if ((promos instanceof Collection) && promos.isEmpty()) {
            return 0;
        }
        Iterator<T> it = promos.iterator();
        int i = 0;
        while (it.hasNext()) {
            if ((((OutboundPromotion) it.next()).getStartDate().getDateTimeMillis() > j) && (i = i + 1) < 0) {
                n.throwCountOverflow();
            }
        }
        return i;
    }

    public StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(outboundPromosPreviewFeatureFlag, "previewFeatureFlag");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.previewFeatureFlag = outboundPromosPreviewFeatureFlag;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        StoreOutboundPromotions$State$Loading storeOutboundPromotions$State$Loading = StoreOutboundPromotions$State$Loading.INSTANCE;
        this.state = storeOutboundPromotions$State$Loading;
        this.stateSnapshot = storeOutboundPromotions$State$Loading;
    }
}
