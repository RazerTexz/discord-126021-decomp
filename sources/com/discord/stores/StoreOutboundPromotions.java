package com.discord.stores;

import android.content.SharedPreferences;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.premium.OutboundPromosPreviewFeatureFlag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions extends StoreV2 {
    private static final String CONSUMED_ENTITLEMENT_PROMO_ID = "CONSUMED_ENTITLEMENT_CODE";
    private static final String LATEST_SEEN_PROMO_DATE = "LATEST_SEEN_PROMO_DATE";
    private static final long NO_PROMO_ID = -1;
    private static final long NO_SEEN_PROMO_DATE = -1;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final OutboundPromosPreviewFeatureFlag previewFeatureFlag;
    private final RestAPI restAPI;
    private State state;
    private State stateSnapshot;

    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
        public static final class Failed extends State {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
        public static final /* data */ class Loaded extends State {
            private final int unseenCount;
            private final List<OutboundPromotion> validActivePromotions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<OutboundPromotion> list, int i) {
                super(null);
                C12238m.checkNotNullParameter(list, "validActivePromotions");
                this.validActivePromotions = list;
                this.unseenCount = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = loaded.validActivePromotions;
                }
                if ((i2 & 2) != 0) {
                    i = loaded.unseenCount;
                }
                return loaded.copy(list, i);
            }

            public final List<OutboundPromotion> component1() {
                return this.validActivePromotions;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getUnseenCount() {
                return this.unseenCount;
            }

            public final Loaded copy(List<OutboundPromotion> validActivePromotions, int unseenCount) {
                C12238m.checkNotNullParameter(validActivePromotions, "validActivePromotions");
                return new Loaded(validActivePromotions, unseenCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.validActivePromotions, loaded.validActivePromotions) && this.unseenCount == loaded.unseenCount;
            }

            public final int getUnseenCount() {
                return this.unseenCount;
            }

            public final List<OutboundPromotion> getValidActivePromotions() {
                return this.validActivePromotions;
            }

            public int hashCode() {
                List<OutboundPromotion> list = this.validActivePromotions;
                return ((list != null ? list.hashCode() : 0) * 31) + this.unseenCount;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(validActivePromotions=");
                sbM833U.append(this.validActivePromotions);
                sbM833U.append(", unseenCount=");
                return C1643a.m814B(sbM833U, this.unseenCount, ")");
            }

            @Override // com.discord.stores.StoreOutboundPromotions.State
            public Loaded deepCopy() {
                return copy$default(this, new ArrayList(this.validActivePromotions), 0, 2, null);
            }
        }

        /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public State deepCopy() {
            return this;
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$markSeen$1 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63191 extends AbstractC12240o implements Function0<Unit> {
        public C63191() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<OutboundPromotion> validActivePromotions;
            State state = StoreOutboundPromotions.this.state;
            Object next = null;
            if (!(state instanceof State.Loaded)) {
                state = null;
            }
            State.Loaded loaded = (State.Loaded) state;
            if (loaded == null || (validActivePromotions = loaded.getValidActivePromotions()) == null) {
                return;
            }
            Iterator<T> it = validActivePromotions.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    UtcDateTime startDate = ((OutboundPromotion) next).getStartDate();
                    do {
                        Object next2 = it.next();
                        UtcDateTime startDate2 = ((OutboundPromotion) next2).getStartDate();
                        if (startDate.compareTo(startDate2) < 0) {
                            next = next2;
                            startDate = startDate2;
                        }
                    } while (it.hasNext());
                }
            }
            OutboundPromotion outboundPromotion = (OutboundPromotion) next;
            if (outboundPromotion != null) {
                SharedPreferences.Editor editorEdit = StoreOutboundPromotions.this.getPrefs().edit();
                C12238m.checkNotNullExpressionValue(editorEdit, "editor");
                editorEdit.putLong(StoreOutboundPromotions.LATEST_SEEN_PROMO_DATE, outboundPromotion.getStartDate().getDateTimeMillis());
                editorEdit.apply();
                StoreOutboundPromotions storeOutboundPromotions = StoreOutboundPromotions.this;
                storeOutboundPromotions.state = new State.Loaded(validActivePromotions, storeOutboundPromotions.getUnseenCount(validActivePromotions));
                StoreOutboundPromotions.this.markChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$observeState$1 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63201 extends AbstractC12240o implements Function0<State> {
        public C63201() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreOutboundPromotions.this.getStateSnapshot();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$observeUnseenCount$1 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63211 extends AbstractC12240o implements Function0<Integer> {
        public C63211() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return StoreOutboundPromotions.this.getUnseenCount();
        }
    }

    public /* synthetic */ StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(outboundPromosPreviewFeatureFlag, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public final Observable<ClaimedOutboundPromotion> claimOutboundPromotion(long promotionId) {
        return this.restAPI.claimOutboundPromotion(promotionId);
    }

    public final Observable<List<ClaimedOutboundPromotion>> fetchClaimedOutboundPromotions() {
        return this.restAPI.getClaimedOutboundPromotions();
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    public final int getUnseenCount() {
        State stateSnapshot = getStateSnapshot();
        if (!(stateSnapshot instanceof State.Loaded)) {
            stateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) stateSnapshot;
        if (loaded != null) {
            return loaded.getUnseenCount();
        }
        return 0;
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload readyPayload) {
        C12238m.checkNotNullParameter(readyPayload, "readyPayload");
        UserUtils userUtils = UserUtils.INSTANCE;
        User me2 = readyPayload.getMe();
        C12238m.checkNotNullExpressionValue(me2, "readyPayload.me");
        if (!userUtils.isPremiumTier2(new MeUser(me2))) {
            this.state = new State.Loaded(C12147n.emptyList(), 0);
            markChanged();
            return;
        }
        this.state = State.Loading.INSTANCE;
        markChanged();
        RestAPI restAPI = this.restAPI;
        Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(this.previewFeatureFlag.isEnabled() ? restAPI.getAllPreviewPromotions() : restAPI.getAllActiveOutboundPromotions(), false, 1, null).m11082A(new InterfaceC12589b<List<? extends OutboundPromotion>, Observable<? extends List<? extends OutboundPromotion>>>() { // from class: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends List<? extends OutboundPromotion>> call(List<? extends OutboundPromotion> list) {
                return call2((List<OutboundPromotion>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends List<OutboundPromotion>> call2(final List<OutboundPromotion> list) {
                if (this.this$0.getPrefs().contains("CONSUMED_ENTITLEMENT_CODE")) {
                    return Observable.m11060D(new Callable<List<? extends OutboundPromotion>>() { // from class: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2.1
                        @Override // java.util.concurrent.Callable
                        public final List<? extends OutboundPromotion> call() {
                            long j = StoreOutboundPromotions$handleConnectionOpen$2.this.this$0.getPrefs().getLong("CONSUMED_ENTITLEMENT_CODE", -1L);
                            List list2 = list;
                            ArrayList arrayListM840a0 = C1643a.m840a0(list2, "activePromos");
                            for (T t : list2) {
                                if (((OutboundPromotion) t).getId() != j) {
                                    arrayListM840a0.add(t);
                                }
                            }
                            return arrayListM840a0;
                        }
                    });
                }
                C12238m.checkNotNullExpressionValue(list, "activePromos");
                return list.isEmpty() ^ true ? ObservableExtensionsKt.restSubscribeOn$default(this.this$0.restAPI.getMyEntitlements(521842831262875670L, false), false, 1, null).m11083G(new InterfaceC12589b<List<? extends ModelEntitlement>, Long>() { // from class: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Long call(List<? extends ModelEntitlement> list2) {
                        return call2((List<ModelEntitlement>) list2);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Long call2(List<ModelEntitlement> list2) {
                        T next;
                        Long promotionId;
                        ModelEntitlement modelEntitlement;
                        C12238m.checkNotNullExpressionValue(list2, "entitlements");
                        Iterator<T> it = list2.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = (T) null;
                                break;
                            }
                            next = it.next();
                            modelEntitlement = (ModelEntitlement) next;
                        } while (!(C12238m.areEqual(modelEntitlement.getConsumed(), Boolean.TRUE) && modelEntitlement.getPromotionId() != null));
                        ModelEntitlement modelEntitlement2 = next;
                        return Long.valueOf((modelEntitlement2 == null || (promotionId = modelEntitlement2.getPromotionId()) == null) ? -1L : promotionId.longValue());
                    }
                }).m11115u(new Action1<Long>() { // from class: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2.3
                    @Override // p658rx.functions.Action1
                    public final void call(Long l) {
                        SharedPreferences.Editor editorEdit = StoreOutboundPromotions$handleConnectionOpen$2.this.this$0.getPrefs().edit();
                        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
                        C12238m.checkNotNullExpressionValue(l, "consumedPromoId");
                        editorEdit.putLong("CONSUMED_ENTITLEMENT_CODE", l.longValue());
                        editorEdit.apply();
                    }
                }).m11083G(new InterfaceC12589b<Long, List<? extends OutboundPromotion>>() { // from class: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2.4
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final List<OutboundPromotion> call(Long l) {
                        List list2 = list;
                        ArrayList arrayListM840a0 = C1643a.m840a0(list2, "activePromos");
                        for (T t : list2) {
                            if (l == null || ((OutboundPromotion) t).getId() != l.longValue()) {
                                arrayListM840a0.add(t);
                            }
                        }
                        return arrayListM840a0;
                    }
                }) : new C12721k(list);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "restAPI.run {\n        if…            }\n          }");
        ObservableExtensionsKt.appSubscribe(observableM11082A, (Class<?>) StoreOutboundPromotions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new StoreOutboundPromotions$handleConnectionOpen$3(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new StoreOutboundPromotions$handleConnectionOpen$4(this));
    }

    public final void markSeen() {
        this.dispatcher.schedule(new C63191());
    }

    public final Observable<State> observeState() {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63201(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Integer> observeUnseenCount() {
        Observable<Integer> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63211(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
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
                C12147n.throwCountOverflow();
            }
        }
        return i;
    }

    public StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(outboundPromosPreviewFeatureFlag, "previewFeatureFlag");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.previewFeatureFlag = outboundPromosPreviewFeatureFlag;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
