package com.discord.widgets.chat.list;

import com.discord.C5419R;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.stores.StoreChannelFollowerStats;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialogViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private final long messageId;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$1 */
    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static final class C79461 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C79461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            PublishActionDialogViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeChannelFollowerStatsStoreState(long channelId, StoreChannelFollowerStats storeChannelFollowerStats) {
            Observable<StoreState> observableM11112r = storeChannelFollowerStats.observeChannelFollowerStats(channelId).m11083G(new InterfaceC12589b<ModelChannelFollowerStats, StoreState>() { // from class: com.discord.widgets.chat.list.PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final PublishActionDialogViewModel.StoreState call(ModelChannelFollowerStats modelChannelFollowerStats) {
                    return new PublishActionDialogViewModel.StoreState(modelChannelFollowerStats);
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "storeChannelFollowerStat…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
        public static final /* data */ class Failure extends Event {
            private final int failureMessageStringRes;

            public Failure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = failure.failureMessageStringRes;
                }
                return failure.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final Failure copy(int failureMessageStringRes) {
                return new Failure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && this.failureMessageStringRes == ((Failure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Failure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
        public static final /* data */ class Success extends Event {
            private final int successMessageStringRes;

            public Success(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.successMessageStringRes;
                }
                return success.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final Success copy(int successMessageStringRes) {
                return new Success(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && this.successMessageStringRes == ((Success) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Success(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static final class StoreState {
        private final ModelChannelFollowerStats followerStats;

        public StoreState(ModelChannelFollowerStats modelChannelFollowerStats) {
            this.followerStats = modelChannelFollowerStats;
        }

        public final ModelChannelFollowerStats getFollowerStats() {
            return this.followerStats;
        }
    }

    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
        public static final /* data */ class LoadedHasFollowers extends ViewState {
            private final ModelChannelFollowerStats followerStats;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadedHasFollowers(ModelChannelFollowerStats modelChannelFollowerStats) {
                super(null);
                C12238m.checkNotNullParameter(modelChannelFollowerStats, "followerStats");
                this.followerStats = modelChannelFollowerStats;
            }

            public static /* synthetic */ LoadedHasFollowers copy$default(LoadedHasFollowers loadedHasFollowers, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelChannelFollowerStats = loadedHasFollowers.followerStats;
                }
                return loadedHasFollowers.copy(modelChannelFollowerStats);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelChannelFollowerStats getFollowerStats() {
                return this.followerStats;
            }

            public final LoadedHasFollowers copy(ModelChannelFollowerStats followerStats) {
                C12238m.checkNotNullParameter(followerStats, "followerStats");
                return new LoadedHasFollowers(followerStats);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LoadedHasFollowers) && C12238m.areEqual(this.followerStats, ((LoadedHasFollowers) other).followerStats);
                }
                return true;
            }

            public final ModelChannelFollowerStats getFollowerStats() {
                return this.followerStats;
            }

            public int hashCode() {
                ModelChannelFollowerStats modelChannelFollowerStats = this.followerStats;
                if (modelChannelFollowerStats != null) {
                    return modelChannelFollowerStats.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LoadedHasFollowers(followerStats=");
                sbM833U.append(this.followerStats);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
        public static final class LoadedNoFollowers extends ViewState {
            public static final LoadedNoFollowers INSTANCE = new LoadedNoFollowers();

            private LoadedNoFollowers() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$publishMessage$1 */
    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static final class C79481 extends AbstractC12240o implements Function1<Void, Unit> {
        public C79481() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            PublishActionDialogViewModel.this.emitSuccessActionEvent();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$publishMessage$2 */
    /* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
    public static final class C79492 extends AbstractC12240o implements Function1<Error, Unit> {
        public C79492() {
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
            PublishActionDialogViewModel.this.emitFailureEvent();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreChannelFollowerStats channelFollowerStats = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelFollowerStats() : storeChannelFollowerStats;
        this(j, j2, api, channelFollowerStats, (i & 16) != 0 ? INSTANCE.observeChannelFollowerStatsStoreState(j2, channelFollowerStats) : observable);
    }

    private final void emitFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.Failure(C5419R.string.default_failure_to_perform_action_message));
    }

    private final void emitSuccessActionEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.Success(C5419R.string.message_published));
    }

    private final void handleStoreState(StoreState storeState) {
        Integer guildsFollowing;
        ModelChannelFollowerStats followerStats = storeState.getFollowerStats();
        int iIntValue = (followerStats == null || (guildsFollowing = followerStats.getGuildsFollowing()) == null) ? 0 : guildsFollowing.intValue();
        if ((followerStats != null ? followerStats.getGuildsFollowing() : null) == null || iIntValue <= 0) {
            updateViewState(ViewState.LoadedNoFollowers.INSTANCE);
        } else {
            updateViewState(new ViewState.LoadedHasFollowers(followerStats));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void publishMessage() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.crosspostMessage(this.channelId, Long.valueOf(this.messageId)), false, 1, null), this, null, 2, null), (Class<?>) PublishActionDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C79492()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79481());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(storeChannelFollowerStats, "storeChannelFollowerStats");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.messageId = j;
        this.channelId = j2;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.m11133k0();
        storeChannelFollowerStats.fetchChannelFollowerStats(j2);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) PublishActionDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79461());
    }
}
