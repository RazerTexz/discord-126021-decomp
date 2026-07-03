package com.discord.widgets.servers.guildboost;

import androidx.annotation.MainThread;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostTransferInProgressViewModel extends AbstractC0859d0<ViewState> {
    private final long boostId;
    private Subscription guildBoostingSubscription;
    private final long previousGuildId;
    private final RestAPI restAPI;
    private final long slotId;
    private final StoreGuildBoost storeGuildBoost;
    private final long targetGuildId;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$2 */
    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final class C95012 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C95012() {
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
            GuildBoostTransferInProgressViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildBoost.State guildBoostState;
        private final Guild previousGuild;
        private final Guild targetGuild;

        public StoreState(Guild guild, Guild guild2, StoreGuildBoost.State state) {
            C12238m.checkNotNullParameter(state, "guildBoostState");
            this.previousGuild = guild;
            this.targetGuild = guild2;
            this.guildBoostState = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Guild guild2, StoreGuildBoost.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.previousGuild;
            }
            if ((i & 2) != 0) {
                guild2 = storeState.targetGuild;
            }
            if ((i & 4) != 0) {
                state = storeState.guildBoostState;
            }
            return storeState.copy(guild, guild2, state);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getPreviousGuild() {
            return this.previousGuild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getTargetGuild() {
            return this.targetGuild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final StoreState copy(Guild previousGuild, Guild targetGuild, StoreGuildBoost.State guildBoostState) {
            C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
            return new StoreState(previousGuild, targetGuild, guildBoostState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.previousGuild, storeState.previousGuild) && C12238m.areEqual(this.targetGuild, storeState.targetGuild) && C12238m.areEqual(this.guildBoostState, storeState.guildBoostState);
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final Guild getPreviousGuild() {
            return this.previousGuild;
        }

        public final Guild getTargetGuild() {
            return this.targetGuild;
        }

        public int hashCode() {
            Guild guild = this.previousGuild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Guild guild2 = this.targetGuild;
            int iHashCode2 = (iHashCode + (guild2 != null ? guild2.hashCode() : 0)) * 31;
            StoreGuildBoost.State state = this.guildBoostState;
            return iHashCode2 + (state != null ? state.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(previousGuild=");
            sbM833U.append(this.previousGuild);
            sbM833U.append(", targetGuild=");
            sbM833U.append(this.targetGuild);
            sbM833U.append(", guildBoostState=");
            sbM833U.append(this.guildBoostState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
        public static final class ErrorLoading extends ViewState {
            public static final ErrorLoading INSTANCE = new ErrorLoading();

            private ErrorLoading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
        public static final class ErrorTransfer extends ViewState {
            public static final ErrorTransfer INSTANCE = new ErrorTransfer();

            private ErrorTransfer() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
        public static final /* data */ class PostTransfer extends ViewState {
            private final Guild targetGuild;
            private final int targetGuildSubscriptionCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PostTransfer(Guild guild, int i) {
                super(null);
                C12238m.checkNotNullParameter(guild, "targetGuild");
                this.targetGuild = guild;
                this.targetGuildSubscriptionCount = i;
            }

            public static /* synthetic */ PostTransfer copy$default(PostTransfer postTransfer, Guild guild, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guild = postTransfer.targetGuild;
                }
                if ((i2 & 2) != 0) {
                    i = postTransfer.targetGuildSubscriptionCount;
                }
                return postTransfer.copy(guild, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            public final PostTransfer copy(Guild targetGuild, int targetGuildSubscriptionCount) {
                C12238m.checkNotNullParameter(targetGuild, "targetGuild");
                return new PostTransfer(targetGuild, targetGuildSubscriptionCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PostTransfer)) {
                    return false;
                }
                PostTransfer postTransfer = (PostTransfer) other;
                return C12238m.areEqual(this.targetGuild, postTransfer.targetGuild) && this.targetGuildSubscriptionCount == postTransfer.targetGuildSubscriptionCount;
            }

            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            public int hashCode() {
                Guild guild = this.targetGuild;
                return ((guild != null ? guild.hashCode() : 0) * 31) + this.targetGuildSubscriptionCount;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("PostTransfer(targetGuild=");
                sbM833U.append(this.targetGuild);
                sbM833U.append(", targetGuildSubscriptionCount=");
                return C1643a.m814B(sbM833U, this.targetGuildSubscriptionCount, ")");
            }
        }

        /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
        public static final /* data */ class PreTransfer extends ViewState {
            private final boolean isTransferInProgress;
            private final Guild previousGuild;
            private final Guild targetGuild;
            private final int targetGuildSubscriptionCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PreTransfer(Guild guild, Guild guild2, int i, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(guild, "previousGuild");
                C12238m.checkNotNullParameter(guild2, "targetGuild");
                this.previousGuild = guild;
                this.targetGuild = guild2;
                this.targetGuildSubscriptionCount = i;
                this.isTransferInProgress = z2;
            }

            public static /* synthetic */ PreTransfer copy$default(PreTransfer preTransfer, Guild guild, Guild guild2, int i, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guild = preTransfer.previousGuild;
                }
                if ((i2 & 2) != 0) {
                    guild2 = preTransfer.targetGuild;
                }
                if ((i2 & 4) != 0) {
                    i = preTransfer.targetGuildSubscriptionCount;
                }
                if ((i2 & 8) != 0) {
                    z2 = preTransfer.isTransferInProgress;
                }
                return preTransfer.copy(guild, guild2, i, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getPreviousGuild() {
                return this.previousGuild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsTransferInProgress() {
                return this.isTransferInProgress;
            }

            public final PreTransfer copy(Guild previousGuild, Guild targetGuild, int targetGuildSubscriptionCount, boolean isTransferInProgress) {
                C12238m.checkNotNullParameter(previousGuild, "previousGuild");
                C12238m.checkNotNullParameter(targetGuild, "targetGuild");
                return new PreTransfer(previousGuild, targetGuild, targetGuildSubscriptionCount, isTransferInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PreTransfer)) {
                    return false;
                }
                PreTransfer preTransfer = (PreTransfer) other;
                return C12238m.areEqual(this.previousGuild, preTransfer.previousGuild) && C12238m.areEqual(this.targetGuild, preTransfer.targetGuild) && this.targetGuildSubscriptionCount == preTransfer.targetGuildSubscriptionCount && this.isTransferInProgress == preTransfer.isTransferInProgress;
            }

            public final Guild getPreviousGuild() {
                return this.previousGuild;
            }

            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            public int hashCode() {
                Guild guild = this.previousGuild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                Guild guild2 = this.targetGuild;
                int iHashCode2 = (((iHashCode + (guild2 != null ? guild2.hashCode() : 0)) * 31) + this.targetGuildSubscriptionCount) * 31;
                boolean z2 = this.isTransferInProgress;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode2 + r1;
            }

            public final boolean isTransferInProgress() {
                return this.isTransferInProgress;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("PreTransfer(previousGuild=");
                sbM833U.append(this.previousGuild);
                sbM833U.append(", targetGuild=");
                sbM833U.append(this.targetGuild);
                sbM833U.append(", targetGuildSubscriptionCount=");
                sbM833U.append(this.targetGuildSubscriptionCount);
                sbM833U.append(", isTransferInProgress=");
                return C1643a.m827O(sbM833U, this.isTransferInProgress, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$2 */
    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final class C95032 extends AbstractC12240o implements Function1<Error, Unit> {
        public C95032() {
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
            GuildBoostTransferInProgressViewModel.this.handleGuildBoostingError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$3 */
    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final class C95043 extends AbstractC12240o implements Function1<List<? extends ModelAppliedGuildBoost>, Unit> {
        public C95043() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelAppliedGuildBoost> list) {
            invoke2((List<ModelAppliedGuildBoost>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelAppliedGuildBoost> list) {
            GuildBoostTransferInProgressViewModel.this.handleGuildBoostingCompleted();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observable2;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildBoost guildBoosts = (i & 32) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost;
        if ((i & 64) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableM11075i = Observable.m11075i(companion.getGuilds().observeGuild(j3), companion.getGuilds().observeGuild(j4), StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null), new Func3<Guild, Guild, StoreGuildBoost.State, StoreState>() { // from class: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel.1
                @Override // p658rx.functions.Func3
                public final StoreState call(Guild guild, Guild guild2, StoreGuildBoost.State state) {
                    C12238m.checkNotNullExpressionValue(state, "guildBoostState");
                    return new StoreState(guild, guild2, state);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…guildBoostState\n    )\n  }");
            observable2 = observableM11075i;
        } else {
            observable2 = observable;
        }
        this(j, j2, j3, j4, api, guildBoosts, observable2);
    }

    @MainThread
    private final void handleGuildBoostingCompleted() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState instanceof ViewState.PreTransfer) {
            ViewState.PreTransfer preTransfer = (ViewState.PreTransfer) viewStateRequireViewState;
            viewStateRequireViewState = new ViewState.PostTransfer(preTransfer.getTargetGuild(), preTransfer.getTargetGuildSubscriptionCount());
        }
        updateViewState(viewStateRequireViewState);
    }

    @MainThread
    private final void handleGuildBoostingError() {
        updateViewState(ViewState.ErrorTransfer.INSTANCE);
    }

    @MainThread
    private final void handleGuildBoostingStarted() {
        Object objCopy$default = (ViewState) requireViewState();
        if (objCopy$default instanceof ViewState.PreTransfer) {
            objCopy$default = ViewState.PreTransfer.copy$default((ViewState.PreTransfer) objCopy$default, null, null, 0, true, 7, null);
        }
        updateViewState(objCopy$default);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int size;
        if (storeState.getPreviousGuild() == null || storeState.getTargetGuild() == null) {
            updateViewState(ViewState.ErrorLoading.INSTANCE);
            return;
        }
        if (storeState.getGuildBoostState() instanceof StoreGuildBoost.State.Loaded) {
            Collection<ModelGuildBoostSlot> collectionValues = ((StoreGuildBoost.State.Loaded) storeState.getGuildBoostState()).getBoostSlotMap().values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                ModelAppliedGuildBoost premiumGuildSubscription = ((ModelGuildBoostSlot) obj).getPremiumGuildSubscription();
                if (premiumGuildSubscription != null && premiumGuildSubscription.getGuildId() == this.targetGuildId) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        updateViewState(new ViewState.PreTransfer(storeState.getPreviousGuild(), storeState.getTargetGuild(), size, false));
    }

    public final long getBoostId() {
        return this.boostId;
    }

    public final long getPreviousGuildId() {
        return this.previousGuildId;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final long getSlotId() {
        return this.slotId;
    }

    public final StoreGuildBoost getStoreGuildBoost() {
        return this.storeGuildBoost;
    }

    public final long getTargetGuildId() {
        return this.targetGuildId;
    }

    @Override // p007b.p008a.p018d.AbstractC0859d0, androidx.view.ViewModel
    public void onCleared() {
        Subscription subscription = this.guildBoostingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onCleared();
    }

    @MainThread
    public final void transferGuildBoost() {
        handleGuildBoostingStarted();
        Observable<R> observableM11082A = this.restAPI.unsubscribeToGuild(this.previousGuildId, this.boostId).m11082A(new InterfaceC12589b<Void, Observable<? extends List<? extends ModelAppliedGuildBoost>>>() { // from class: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel.transferGuildBoost.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends List<ModelAppliedGuildBoost>> call(Void r6) {
                return GuildBoostTransferInProgressViewModel.this.getRestAPI().subscribeToGuild(GuildBoostTransferInProgressViewModel.this.getTargetGuildId(), new RestAPIParams.GuildBoosting(C12145m.listOf(Long.valueOf(GuildBoostTransferInProgressViewModel.this.getSlotId()))));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "restAPI\n        .unsubsc…              )\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null), this, null, 2, null), (Class<?>) GuildBoostTransferInProgressViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C95032()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95043());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.slotId = j;
        this.boostId = j2;
        this.previousGuildId = j3;
        this.targetGuildId = j4;
        this.restAPI = restAPI;
        this.storeGuildBoost = storeGuildBoost;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildBoostTransferInProgressViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95012());
    }
}
