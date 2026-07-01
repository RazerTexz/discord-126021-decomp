package com.discord.widgets.servers.guildboost;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams$GuildBoosting;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuildBoost$State$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostInProgressViewModel extends d0<GuildBoostInProgressViewModel$ViewState> {
    private Subscription guildBoostSubscription;
    private final long guildId;
    private final StoreGuildBoost storeGuildBoost;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildBoostInProgressViewModel(long j, StoreGuildBoost storeGuildBoost, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeGuildBoost = (i & 2) != 0 ? StoreStream.Companion.getGuildBoosts() : storeGuildBoost;
        if ((i & 4) != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = Observable.j(storeStream$Companion.getGuilds().observeGuild(j), StoreGuildBoost.observeGuildBoostState$default(storeStream$Companion.getGuildBoosts(), null, 1, null), GuildBoostInProgressViewModel$1.INSTANCE);
            m.checkNotNullExpressionValue(observable, "Observable.combineLatest…guild, guildBoostState) }");
        }
        this(j, storeGuildBoost, observable);
    }

    public static final /* synthetic */ Subscription access$getGuildBoostSubscription$p(GuildBoostInProgressViewModel guildBoostInProgressViewModel) {
        return guildBoostInProgressViewModel.guildBoostSubscription;
    }

    public static final /* synthetic */ void access$handleGuildBoostingCompleted(GuildBoostInProgressViewModel guildBoostInProgressViewModel) {
        guildBoostInProgressViewModel.handleGuildBoostingCompleted();
    }

    public static final /* synthetic */ void access$handleGuildBoostingError(GuildBoostInProgressViewModel guildBoostInProgressViewModel) {
        guildBoostInProgressViewModel.handleGuildBoostingError();
    }

    public static final /* synthetic */ void access$handleStoreState(GuildBoostInProgressViewModel guildBoostInProgressViewModel, GuildBoostInProgressViewModel$StoreState guildBoostInProgressViewModel$StoreState) {
        guildBoostInProgressViewModel.handleStoreState(guildBoostInProgressViewModel$StoreState);
    }

    public static final /* synthetic */ void access$setGuildBoostSubscription$p(GuildBoostInProgressViewModel guildBoostInProgressViewModel, Subscription subscription) {
        guildBoostInProgressViewModel.guildBoostSubscription = subscription;
    }

    @MainThread
    private final void handleGuildBoostingCompleted() {
        GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewState$Loaded;
        this.storeGuildBoost.fetchUserGuildBoostState();
        GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewStateRequireViewState = requireViewState();
        if (guildBoostInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostInProgressViewModel$ViewState$Uninitialized) {
            guildBoostInProgressViewModel$ViewState$Loaded = new GuildBoostInProgressViewModel$ViewState$Uninitialized(GuildBoostInProgressViewModel$GuildBoostState.COMPLETED);
        } else {
            if (!(guildBoostInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostInProgressViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            GuildBoostInProgressViewModel$ViewState$Loaded guildBoostInProgressViewModel$ViewState$Loaded2 = (GuildBoostInProgressViewModel$ViewState$Loaded) guildBoostInProgressViewModel$ViewStateRequireViewState;
            guildBoostInProgressViewModel$ViewState$Loaded = new GuildBoostInProgressViewModel$ViewState$Loaded(GuildBoostInProgressViewModel$GuildBoostState.COMPLETED, guildBoostInProgressViewModel$ViewState$Loaded2.getGuild(), guildBoostInProgressViewModel$ViewState$Loaded2.getSubscriptionCount(), true);
        }
        updateViewState(guildBoostInProgressViewModel$ViewState$Loaded);
    }

    @MainThread
    private final void handleGuildBoostingError() {
        GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewState$Loaded;
        GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewStateRequireViewState = requireViewState();
        if (guildBoostInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostInProgressViewModel$ViewState$Uninitialized) {
            guildBoostInProgressViewModel$ViewState$Loaded = new GuildBoostInProgressViewModel$ViewState$Uninitialized(GuildBoostInProgressViewModel$GuildBoostState.ERROR);
        } else {
            if (!(guildBoostInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostInProgressViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            GuildBoostInProgressViewModel$ViewState$Loaded guildBoostInProgressViewModel$ViewState$Loaded2 = (GuildBoostInProgressViewModel$ViewState$Loaded) guildBoostInProgressViewModel$ViewStateRequireViewState;
            guildBoostInProgressViewModel$ViewState$Loaded = new GuildBoostInProgressViewModel$ViewState$Loaded(GuildBoostInProgressViewModel$GuildBoostState.ERROR, guildBoostInProgressViewModel$ViewState$Loaded2.getGuild(), guildBoostInProgressViewModel$ViewState$Loaded2.getSubscriptionCount(), false, 8, null);
        }
        updateViewState(guildBoostInProgressViewModel$ViewState$Loaded);
    }

    @MainThread
    private final void handleGuildBoostingStarted() {
        GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewState$Loaded;
        GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewStateRequireViewState = requireViewState();
        if (guildBoostInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostInProgressViewModel$ViewState$Uninitialized) {
            guildBoostInProgressViewModel$ViewState$Loaded = new GuildBoostInProgressViewModel$ViewState$Uninitialized(GuildBoostInProgressViewModel$GuildBoostState.CALL_IN_PROGRESS);
        } else {
            if (!(guildBoostInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostInProgressViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            GuildBoostInProgressViewModel$ViewState$Loaded guildBoostInProgressViewModel$ViewState$Loaded2 = (GuildBoostInProgressViewModel$ViewState$Loaded) guildBoostInProgressViewModel$ViewStateRequireViewState;
            guildBoostInProgressViewModel$ViewState$Loaded = new GuildBoostInProgressViewModel$ViewState$Loaded(GuildBoostInProgressViewModel$GuildBoostState.CALL_IN_PROGRESS, guildBoostInProgressViewModel$ViewState$Loaded2.getGuild(), guildBoostInProgressViewModel$ViewState$Loaded2.getSubscriptionCount(), false, 8, null);
        }
        updateViewState(guildBoostInProgressViewModel$ViewState$Loaded);
    }

    @MainThread
    private final void handleStoreState(GuildBoostInProgressViewModel$StoreState storeState) {
        int size;
        if (storeState.getGuildBoostState() instanceof StoreGuildBoost$State$Loaded) {
            Collection<ModelGuildBoostSlot> collectionValues = ((StoreGuildBoost$State$Loaded) storeState.getGuildBoostState()).getBoostSlotMap().values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                ModelAppliedGuildBoost premiumGuildSubscription = ((ModelGuildBoostSlot) obj).getPremiumGuildSubscription();
                Long lValueOf = premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null;
                Guild guild = storeState.getGuild();
                if (m.areEqual(lValueOf, guild != null ? Long.valueOf(guild.getId()) : null)) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        updateViewState(new GuildBoostInProgressViewModel$ViewState$Loaded(requireViewState().getGuildBoostState(), storeState.getGuild(), size, false, 8, null));
    }

    public final StoreGuildBoost getStoreGuildBoost() {
        return this.storeGuildBoost;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().subscribeToGuild(guildId, new RestAPIParams$GuildBoosting(d0.t.m.listOf(Long.valueOf(slotId)))), false, 1, null), this, null, 2, null), StoreGuildBoost.class, (Context) null, new GuildBoostInProgressViewModel$subscribeToGuildBoost$1(this), new GuildBoostInProgressViewModel$subscribeToGuildBoost$2(this), (Function0) null, (Function0) null, new GuildBoostInProgressViewModel$subscribeToGuildBoost$3(this), 50, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel(long j, StoreGuildBoost storeGuildBoost, Observable<GuildBoostInProgressViewModel$StoreState> observable) {
        super(new GuildBoostInProgressViewModel$ViewState$Uninitialized(GuildBoostInProgressViewModel$GuildBoostState.NOT_IN_PROGRESS));
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildBoost = storeGuildBoost;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildBoostInProgressViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostInProgressViewModel$2(this), 62, (Object) null);
    }
}
