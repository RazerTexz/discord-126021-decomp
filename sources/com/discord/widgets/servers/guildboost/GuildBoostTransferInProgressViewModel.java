package com.discord.widgets.servers.guildboost;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostTransferInProgressViewModel extends AppViewModel<ViewState> {
    private final long boostId;
    private Subscription guildBoostingSubscription;
    private final long previousGuildId;
    private final RestAPI restAPI;
    private final long slotId;
    private final StoreGuildBoost storeGuildBoost;
    private final long targetGuildId;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildBoostTransferInProgressViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildBoost.State guildBoostState;
        private final Guild previousGuild;
        private final Guild targetGuild;

        public StoreState(Guild guild, Guild guild2, StoreGuildBoost.State state) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
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
            Intrinsics3.checkNotNullParameter(guildBoostState, "guildBoostState");
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
            return Intrinsics3.areEqual(this.previousGuild, storeState.previousGuild) && Intrinsics3.areEqual(this.targetGuild, storeState.targetGuild) && Intrinsics3.areEqual(this.guildBoostState, storeState.guildBoostState);
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
            StringBuilder sbU = outline.U("StoreState(previousGuild=");
            sbU.append(this.previousGuild);
            sbU.append(", targetGuild=");
            sbU.append(this.targetGuild);
            sbU.append(", guildBoostState=");
            sbU.append(this.guildBoostState);
            sbU.append(")");
            return sbU.toString();
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
                Intrinsics3.checkNotNullParameter(guild, "targetGuild");
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
                Intrinsics3.checkNotNullParameter(targetGuild, "targetGuild");
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
                return Intrinsics3.areEqual(this.targetGuild, postTransfer.targetGuild) && this.targetGuildSubscriptionCount == postTransfer.targetGuildSubscriptionCount;
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
                StringBuilder sbU = outline.U("PostTransfer(targetGuild=");
                sbU.append(this.targetGuild);
                sbU.append(", targetGuildSubscriptionCount=");
                return outline.B(sbU, this.targetGuildSubscriptionCount, ")");
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
                Intrinsics3.checkNotNullParameter(guild, "previousGuild");
                Intrinsics3.checkNotNullParameter(guild2, "targetGuild");
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
                Intrinsics3.checkNotNullParameter(previousGuild, "previousGuild");
                Intrinsics3.checkNotNullParameter(targetGuild, "targetGuild");
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
                return Intrinsics3.areEqual(this.previousGuild, preTransfer.previousGuild) && Intrinsics3.areEqual(this.targetGuild, preTransfer.targetGuild) && this.targetGuildSubscriptionCount == preTransfer.targetGuildSubscriptionCount && this.isTransferInProgress == preTransfer.isTransferInProgress;
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
                StringBuilder sbU = outline.U("PreTransfer(previousGuild=");
                sbU.append(this.previousGuild);
                sbU.append(", targetGuild=");
                sbU.append(this.targetGuild);
                sbU.append(", targetGuildSubscriptionCount=");
                sbU.append(this.targetGuildSubscriptionCount);
                sbU.append(", isTransferInProgress=");
                return outline.O(sbU, this.isTransferInProgress, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
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
            GuildBoostTransferInProgressViewModel.this.handleGuildBoostingError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$3, reason: invalid class name */
    /* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelAppliedGuildBoost>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelAppliedGuildBoost> list) {
            invoke2((List<ModelAppliedGuildBoost>) list);
            return Unit.a;
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
            Observable observableI = Observable.i(companion.getGuilds().observeGuild(j3), companion.getGuilds().observeGuild(j4), StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null), new Func3<Guild, Guild, StoreGuildBoost.State, StoreState>() { // from class: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel.1
                @Override // rx.functions.Func3
                public final StoreState call(Guild guild, Guild guild2, StoreGuildBoost.State state) {
                    Intrinsics3.checkNotNullExpressionValue(state, "guildBoostState");
                    return new StoreState(guild, guild2, state);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…guildBoostState\n    )\n  }");
            observable2 = observableI;
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

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
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
        Observable<R> observableA = this.restAPI.unsubscribeToGuild(this.previousGuildId, this.boostId).A(new Func1<Void, Observable<? extends List<? extends ModelAppliedGuildBoost>>>() { // from class: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel.transferGuildBoost.1
            @Override // j0.k.Func1
            public final Observable<? extends List<ModelAppliedGuildBoost>> call(Void r6) {
                return GuildBoostTransferInProgressViewModel.this.getRestAPI().subscribeToGuild(GuildBoostTransferInProgressViewModel.this.getTargetGuildId(), new RestAPIParams.GuildBoosting(CollectionsJVM.listOf(Long.valueOf(GuildBoostTransferInProgressViewModel.this.getSlotId()))));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "restAPI\n        .unsubsc…              )\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), this, null, 2, null), (Class<?>) GuildBoostTransferInProgressViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.slotId = j;
        this.boostId = j2;
        this.previousGuildId = j3;
        this.targetGuildId = j4;
        this.restAPI = restAPI;
        this.storeGuildBoost = storeGuildBoost;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildBoostTransferInProgressViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
