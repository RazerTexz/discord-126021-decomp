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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostInProgressViewModel extends AbstractC0859d0<ViewState> {
    private Subscription guildBoostSubscription;
    private final long guildId;
    private final StoreGuildBoost storeGuildBoost;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel$2 */
    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public static final class C94942 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C94942() {
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
            GuildBoostInProgressViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public enum GuildBoostState {
        NOT_IN_PROGRESS,
        CALL_IN_PROGRESS,
        COMPLETED,
        ERROR
    }

    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final StoreGuildBoost.State guildBoostState;

        public StoreState(Guild guild, StoreGuildBoost.State state) {
            C12238m.checkNotNullParameter(state, "guildBoostState");
            this.guild = guild;
            this.guildBoostState = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, StoreGuildBoost.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                state = storeState.guildBoostState;
            }
            return storeState.copy(guild, state);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final StoreState copy(Guild guild, StoreGuildBoost.State guildBoostState) {
            C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
            return new StoreState(guild, guildBoostState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.guildBoostState, storeState.guildBoostState);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildBoost.State state = this.guildBoostState;
            return iHashCode + (state != null ? state.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", guildBoostState=");
            sbM833U.append(this.guildBoostState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public static abstract class ViewState {
        private final GuildBoostState guildBoostState;

        /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canShowConfirmationDialog;
            private final Guild guild;
            private final GuildBoostState guildBoostState;
            private final int subscriptionCount;

            public /* synthetic */ Loaded(GuildBoostState guildBoostState, Guild guild, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(guildBoostState, guild, i, (i2 & 8) != 0 ? false : z2);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildBoostState guildBoostState, Guild guild, int i, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guildBoostState = loaded.getGuildBoostState();
                }
                if ((i2 & 2) != 0) {
                    guild = loaded.guild;
                }
                if ((i2 & 4) != 0) {
                    i = loaded.subscriptionCount;
                }
                if ((i2 & 8) != 0) {
                    z2 = loaded.canShowConfirmationDialog;
                }
                return loaded.copy(guildBoostState, guild, i, z2);
            }

            public final GuildBoostState component1() {
                return getGuildBoostState();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getSubscriptionCount() {
                return this.subscriptionCount;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getCanShowConfirmationDialog() {
                return this.canShowConfirmationDialog;
            }

            public final Loaded copy(GuildBoostState guildBoostState, Guild guild, int subscriptionCount, boolean canShowConfirmationDialog) {
                C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
                return new Loaded(guildBoostState, guild, subscriptionCount, canShowConfirmationDialog);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(getGuildBoostState(), loaded.getGuildBoostState()) && C12238m.areEqual(this.guild, loaded.guild) && this.subscriptionCount == loaded.subscriptionCount && this.canShowConfirmationDialog == loaded.canShowConfirmationDialog;
            }

            public final boolean getCanShowConfirmationDialog() {
                return this.canShowConfirmationDialog;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            @Override // com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.ViewState
            public GuildBoostState getGuildBoostState() {
                return this.guildBoostState;
            }

            public final int getSubscriptionCount() {
                return this.subscriptionCount;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            public int hashCode() {
                GuildBoostState guildBoostState = getGuildBoostState();
                int iHashCode = (guildBoostState != null ? guildBoostState.hashCode() : 0) * 31;
                Guild guild = this.guild;
                int iHashCode2 = (((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31) + this.subscriptionCount) * 31;
                boolean z2 = this.canShowConfirmationDialog;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode2 + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(guildBoostState=");
                sbM833U.append(getGuildBoostState());
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", subscriptionCount=");
                sbM833U.append(this.subscriptionCount);
                sbM833U.append(", canShowConfirmationDialog=");
                return C1643a.m827O(sbM833U, this.canShowConfirmationDialog, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(GuildBoostState guildBoostState, Guild guild, int i, boolean z2) {
                super(guildBoostState, null);
                C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
                this.guildBoostState = guildBoostState;
                this.guild = guild;
                this.subscriptionCount = i;
                this.canShowConfirmationDialog = z2;
            }
        }

        /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
        public static final /* data */ class Uninitialized extends ViewState {
            private final GuildBoostState guildBoostState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Uninitialized(GuildBoostState guildBoostState) {
                super(guildBoostState, null);
                C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
                this.guildBoostState = guildBoostState;
            }

            public static /* synthetic */ Uninitialized copy$default(Uninitialized uninitialized, GuildBoostState guildBoostState, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildBoostState = uninitialized.getGuildBoostState();
                }
                return uninitialized.copy(guildBoostState);
            }

            public final GuildBoostState component1() {
                return getGuildBoostState();
            }

            public final Uninitialized copy(GuildBoostState guildBoostState) {
                C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
                return new Uninitialized(guildBoostState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Uninitialized) && C12238m.areEqual(getGuildBoostState(), ((Uninitialized) other).getGuildBoostState());
                }
                return true;
            }

            @Override // com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.ViewState
            public GuildBoostState getGuildBoostState() {
                return this.guildBoostState;
            }

            public int hashCode() {
                GuildBoostState guildBoostState = getGuildBoostState();
                if (guildBoostState != null) {
                    return guildBoostState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Uninitialized(guildBoostState=");
                sbM833U.append(getGuildBoostState());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private ViewState(GuildBoostState guildBoostState) {
            this.guildBoostState = guildBoostState;
        }

        public GuildBoostState getGuildBoostState() {
            return this.guildBoostState;
        }

        public /* synthetic */ ViewState(GuildBoostState guildBoostState, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildBoostState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel$subscribeToGuildBoost$1 */
    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public static final class C94951 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C94951() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            GuildBoostInProgressViewModel.this.guildBoostSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel$subscribeToGuildBoost$2 */
    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public static final class C94962 extends AbstractC12240o implements Function1<Error, Unit> {
        public C94962() {
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
            GuildBoostInProgressViewModel.this.handleGuildBoostingError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel$subscribeToGuildBoost$3 */
    /* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
    public static final class C94973 extends AbstractC12240o implements Function1<List<? extends ModelAppliedGuildBoost>, Unit> {
        public C94973() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelAppliedGuildBoost> list) {
            invoke2((List<ModelAppliedGuildBoost>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelAppliedGuildBoost> list) {
            C12238m.checkNotNullParameter(list, "it");
            GuildBoostInProgressViewModel.this.handleGuildBoostingCompleted();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildBoostInProgressViewModel(long j, StoreGuildBoost storeGuildBoost, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeGuildBoost = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost;
        if ((i & 4) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            observable = Observable.m11076j(companion.getGuilds().observeGuild(j), StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null), new Func2<Guild, StoreGuildBoost.State, StoreState>() { // from class: com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.1
                @Override // p658rx.functions.Func2
                public final StoreState call(Guild guild, StoreGuildBoost.State state) {
                    C12238m.checkNotNullExpressionValue(state, "guildBoostState");
                    return new StoreState(guild, state);
                }
            });
            C12238m.checkNotNullExpressionValue(observable, "Observable.combineLatest…guild, guildBoostState) }");
        }
        this(j, storeGuildBoost, observable);
    }

    @MainThread
    private final void handleGuildBoostingCompleted() {
        ViewState loaded;
        this.storeGuildBoost.fetchUserGuildBoostState();
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState instanceof ViewState.Uninitialized) {
            loaded = new ViewState.Uninitialized(GuildBoostState.COMPLETED);
        } else {
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            ViewState.Loaded loaded2 = (ViewState.Loaded) viewStateRequireViewState;
            loaded = new ViewState.Loaded(GuildBoostState.COMPLETED, loaded2.getGuild(), loaded2.getSubscriptionCount(), true);
        }
        updateViewState(loaded);
    }

    @MainThread
    private final void handleGuildBoostingError() {
        ViewState loaded;
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState instanceof ViewState.Uninitialized) {
            loaded = new ViewState.Uninitialized(GuildBoostState.ERROR);
        } else {
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            ViewState.Loaded loaded2 = (ViewState.Loaded) viewStateRequireViewState;
            loaded = new ViewState.Loaded(GuildBoostState.ERROR, loaded2.getGuild(), loaded2.getSubscriptionCount(), false, 8, null);
        }
        updateViewState(loaded);
    }

    @MainThread
    private final void handleGuildBoostingStarted() {
        ViewState loaded;
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState instanceof ViewState.Uninitialized) {
            loaded = new ViewState.Uninitialized(GuildBoostState.CALL_IN_PROGRESS);
        } else {
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            ViewState.Loaded loaded2 = (ViewState.Loaded) viewStateRequireViewState;
            loaded = new ViewState.Loaded(GuildBoostState.CALL_IN_PROGRESS, loaded2.getGuild(), loaded2.getSubscriptionCount(), false, 8, null);
        }
        updateViewState(loaded);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int size;
        if (storeState.getGuildBoostState() instanceof StoreGuildBoost.State.Loaded) {
            Collection<ModelGuildBoostSlot> collectionValues = ((StoreGuildBoost.State.Loaded) storeState.getGuildBoostState()).getBoostSlotMap().values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                ModelAppliedGuildBoost premiumGuildSubscription = ((ModelGuildBoostSlot) obj).getPremiumGuildSubscription();
                Long lValueOf = premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null;
                Guild guild = storeState.getGuild();
                if (C12238m.areEqual(lValueOf, guild != null ? Long.valueOf(guild.getId()) : null)) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        updateViewState(new ViewState.Loaded(requireViewState().getGuildBoostState(), storeState.getGuild(), size, false, 8, null));
    }

    public final StoreGuildBoost getStoreGuildBoost() {
        return this.storeGuildBoost;
    }

    @Override // p007b.p008a.p018d.AbstractC0859d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        Subscription subscription = this.guildBoostSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @MainThread
    public final void subscribeToGuildBoost(long guildId, long slotId) {
        handleGuildBoostingStarted();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().subscribeToGuild(guildId, new RestAPIParams.GuildBoosting(C12145m.listOf(Long.valueOf(slotId)))), false, 1, null), this, null, 2, null), (Class<?>) StoreGuildBoost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C94951()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C94962()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94973());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel(long j, StoreGuildBoost storeGuildBoost, Observable<StoreState> observable) {
        super(new ViewState.Uninitialized(GuildBoostState.NOT_IN_PROGRESS));
        C12238m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildBoost = storeGuildBoost;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildBoostInProgressViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94942());
    }
}
