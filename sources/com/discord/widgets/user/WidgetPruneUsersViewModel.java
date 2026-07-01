package com.discord.widgets.user;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams$PruneGuild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel extends d0<WidgetPruneUsersViewModel$ViewState> {
    public static final WidgetPruneUsersViewModel$Companion Companion = new WidgetPruneUsersViewModel$Companion(null);
    private static final WidgetPruneUsersViewModel$PruneDays DEFAULT_DAYS = WidgetPruneUsersViewModel$PruneDays.Thirty;
    private final PublishSubject<WidgetPruneUsersViewModel$Event> eventSubject;
    private final long guildId;
    private final String guildName;
    private Subscription pruneCountRequest;
    private final RestAPI restAPI;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;
    private WidgetPruneUsersViewModel$PruneDays whichPruneDays;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        Observable observableObserveStoreState;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreUser users = (i & 4) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        if ((i & 8) != 0) {
            Guild guild = guilds.getGuilds().get(Long.valueOf(j));
            String name = guild != null ? guild.getName() : null;
            str2 = name == null ? "" : name;
        } else {
            str2 = str;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 32) != 0) {
            WidgetPruneUsersViewModel$Companion widgetPruneUsersViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableObserveStoreState = widgetPruneUsersViewModel$Companion.observeStoreState(j, observationDeck, storeStream$Companion.getPermissions(), storeStream$Companion.getGuilds(), users);
        } else {
            observableObserveStoreState = observable;
        }
        this(j, guilds, users, str2, api, observableObserveStoreState);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.eventSubject;
    }

    public static final /* synthetic */ Subscription access$getPruneCountRequest$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.pruneCountRequest;
    }

    public static final /* synthetic */ void access$getUpdatedPruneCount(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        widgetPruneUsersViewModel.getUpdatedPruneCount();
    }

    public static final /* synthetic */ WidgetPruneUsersViewModel$PruneDays access$getWhichPruneDays$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.whichPruneDays;
    }

    public static final /* synthetic */ void access$pruneInProgress(WidgetPruneUsersViewModel widgetPruneUsersViewModel, boolean z2) {
        widgetPruneUsersViewModel.pruneInProgress(z2);
    }

    public static final /* synthetic */ void access$setPruneCountRequest$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel, Subscription subscription) {
        widgetPruneUsersViewModel.pruneCountRequest = subscription;
    }

    public static final /* synthetic */ void access$setWhichPruneDays$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel, WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays) {
        widgetPruneUsersViewModel.whichPruneDays = widgetPruneUsersViewModel$PruneDays;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetPruneUsersViewModel widgetPruneUsersViewModel, WidgetPruneUsersViewModel$ViewState widgetPruneUsersViewModel$ViewState) {
        widgetPruneUsersViewModel.updateViewState(widgetPruneUsersViewModel$ViewState);
    }

    private final WidgetPruneUsersViewModel$ViewState$Loading getLoadingState() {
        return new WidgetPruneUsersViewModel$ViewState$Loading(this.whichPruneDays, this.guildName);
    }

    private final void getUpdatedPruneCount() {
        updateViewState(getLoadingState());
        Observable observableM = ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPruneCount(this.guildId, this.whichPruneDays.getCount()), false, 1, null).G(WidgetPruneUsersViewModel$getUpdatedPruneCount$1.INSTANCE).G(new WidgetPruneUsersViewModel$getUpdatedPruneCount$2(this)).t(new WidgetPruneUsersViewModel$getUpdatedPruneCount$3(this)).M(WidgetPruneUsersViewModel$getUpdatedPruneCount$4.INSTANCE);
        m.checkNotNullExpressionValue(observableM, "restAPI.getPruneCount(gu…Failed(dismiss = false) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM, this, null, 2, null), WidgetPruneUsersViewModel.class, (Context) null, new WidgetPruneUsersViewModel$getUpdatedPruneCount$5(this), (Function1) null, (Function0) null, (Function0) null, new WidgetPruneUsersViewModel$getUpdatedPruneCount$6(this), 58, (Object) null);
    }

    private final void pruneInProgress(boolean inProgress) {
        WidgetPruneUsersViewModel$ViewState$Loaded widgetPruneUsersViewModel$ViewState$LoadedCopy$default;
        WidgetPruneUsersViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetPruneUsersViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetPruneUsersViewModel$ViewState$Loaded widgetPruneUsersViewModel$ViewState$Loaded = (WidgetPruneUsersViewModel$ViewState$Loaded) viewState;
        if (widgetPruneUsersViewModel$ViewState$Loaded == null || (widgetPruneUsersViewModel$ViewState$LoadedCopy$default = WidgetPruneUsersViewModel$ViewState$Loaded.copy$default(widgetPruneUsersViewModel$ViewState$Loaded, null, 0, inProgress, 3, null)) == null) {
            return;
        }
        updateViewState(widgetPruneUsersViewModel$ViewState$LoadedCopy$default);
    }

    public final Observable<WidgetPruneUsersViewModel$Event> observeEvents() {
        PublishSubject<WidgetPruneUsersViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void pruneClicked() {
        pruneInProgress(true);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.pruneMembers(this.guildId, new RestAPIParams$PruneGuild(Integer.valueOf(this.whichPruneDays.getCount()), Boolean.FALSE)), false, 1, null), this, null, 2, null);
        WidgetPruneUsersViewModel$pruneClicked$1 widgetPruneUsersViewModel$pruneClicked$1 = new WidgetPruneUsersViewModel$pruneClicked$1(this);
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, WidgetPruneUsersViewModel.class, (Context) null, (Function1) null, new WidgetPruneUsersViewModel$pruneClicked$3(this), (Function0) null, new WidgetPruneUsersViewModel$pruneClicked$2(this), widgetPruneUsersViewModel$pruneClicked$1, 22, (Object) null);
    }

    public final void pruneDaysSelected(WidgetPruneUsersViewModel$PruneDays days) {
        m.checkNotNullParameter(days, "days");
        this.whichPruneDays = days;
        getUpdatedPruneCount();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable<WidgetPruneUsersViewModel$StoreData> observable) {
        super(new WidgetPruneUsersViewModel$ViewState$Loading(DEFAULT_DAYS, str));
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeDataObservable");
        this.guildId = j;
        this.storeGuilds = storeGuilds;
        this.storeUsers = storeUser;
        this.guildName = str;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        WidgetPruneUsersViewModel$ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.user.WidgetPruneUsersViewModel.ViewState.Loading");
        this.whichPruneDays = ((WidgetPruneUsersViewModel$ViewState$Loading) viewState).getWhichPruneDays();
        Observable observableR = observable.G(WidgetPruneUsersViewModel$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storeDataObservable\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetPruneUsersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPruneUsersViewModel$2(this), 62, (Object) null);
    }
}
