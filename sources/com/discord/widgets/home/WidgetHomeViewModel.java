package com.discord.widgets.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.user.NsfwAllowance;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$a;
import com.discord.panels.PanelState$c;
import com.discord.panels.PanelState$d;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuildWelcomeScreens$State;
import com.discord.stores.StoreGuildWelcomeScreens$State$Loaded;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.ChannelOnboardingManager;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet;
import com.discord.widgets.playstation.PlaystationUpsellManager;
import com.discord.widgets.servers.guild_role_subscription.upsell.GuildRoleSubscriptionOnboardingUpsellManager;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel extends d0<WidgetHomeViewModel$ViewState> {
    public static final WidgetHomeViewModel$Companion Companion = new WidgetHomeViewModel$Companion(null);
    private final ChannelOnboardingManager channelOnboardingManager;
    private final Clock clock;
    private final PublishSubject<WidgetHomeViewModel$Event> eventSubject;
    private final GuildRoleSubscriptionOnboardingUpsellManager guildRoleSubscriptionsUpsellManager;
    private final PlaystationUpsellManager playstationUpsellManager;
    private PanelState previousLeftPanelState;
    private final SharedPreferences sharedPreferences;
    private final StoreExperiments storeExperiments;
    private final StoreGuildWelcomeScreens storeGuildWelcomeScreens;
    private final StoreNavigation storeNavigation;
    private final StoreUser storeUser;
    private boolean wasThreadPeek;
    private WidgetHomeModel widgetHomeModel;

    public WidgetHomeViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHomeViewModel(StoreNavigation storeNavigation, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, Observable observable, Observable observable2, ChannelOnboardingManager channelOnboardingManager, SharedPreferences sharedPreferences, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        StoreNavigation navigation = (i & 1) != 0 ? StoreStream.Companion.getNavigation() : storeNavigation;
        StoreGuildWelcomeScreens guildWelcomeScreens = (i & 2) != 0 ? StoreStream.Companion.getGuildWelcomeScreens() : storeGuildWelcomeScreens;
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreUser users = (i & 32) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        if ((i & 64) != 0) {
            WidgetHomeViewModel$Companion widgetHomeViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStoreState = WidgetHomeViewModel$Companion.access$observeStoreState(widgetHomeViewModel$Companion, guilds, storeStream$Companion.getGuildSelected(), navigation, storeStream$Companion.getLurking(), users, guildWelcomeScreens, storeStream$Companion.getChannelsSelected(), experiments, storeStream$Companion.getPermissions(), storeStream$Companion.getUserConnections(), storeStream$Companion.getGuildsNsfw());
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(navigation, guildWelcomeScreens, experiments, guilds, permissions, users, observableAccess$observeStoreState, (i & 128) != 0 ? navigation.getNavigationPanelAction() : observable2, (i & 256) != 0 ? new ChannelOnboardingManager() : channelOnboardingManager, (i & 512) != 0 ? SharedPreferencesProvider.INSTANCE.get() : sharedPreferences, (i & 1024) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ void access$handleNavDrawerAction(WidgetHomeViewModel widgetHomeViewModel, StoreNavigation$PanelAction storeNavigation$PanelAction) {
        widgetHomeViewModel.handleNavDrawerAction(storeNavigation$PanelAction);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetHomeViewModel widgetHomeViewModel, WidgetHomeViewModel$StoreState widgetHomeViewModel$StoreState) {
        widgetHomeViewModel.handleStoreState(widgetHomeViewModel$StoreState);
    }

    @MainThread
    private final void emitAnimatePeekIn() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$AnimatePeekIn.INSTANCE);
    }

    @MainThread
    private final void emitAnimatePeekOut() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$AnimatePeekOut.INSTANCE);
    }

    @MainThread
    private final void emitClosePanelsEvent() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$ClosePanels.INSTANCE);
    }

    @MainThread
    private final void emitShowChannelOnboardingSheet() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$ShowChannelOnboardingSheet.INSTANCE);
    }

    @MainThread
    private final void emitShowGuildEventUpsell(long guildId) {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetHomeViewModel$Event$ShowGuildEventUpsell(guildId));
    }

    @MainThread
    private final void emitShowGuildRoleSubscriptionUpsell(long guildId) {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell(guildId));
    }

    @MainThread
    private final void emitShowPlaystationUpsell() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$ShowPlaystationUpsell.INSTANCE);
    }

    @MainThread
    private final void emitShowWelcomeSheet(long guildId) {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetHomeViewModel$Event$ShowGuildWelcomeSheet(guildId));
    }

    @MainThread
    private final void emitUnlockLeftPanelEvent() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$UnlockLeftPanel.INSTANCE);
    }

    @MainThread
    private final void handleNavDrawerAction(StoreNavigation$PanelAction navPanelAction) {
        int iOrdinal = navPanelAction.ordinal();
        if (iOrdinal == 1) {
            emitOpenLeftPanelEvent();
        } else if (iOrdinal == 2) {
            emitClosePanelsEvent();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            emitUnlockLeftPanelEvent();
        }
    }

    @MainThread
    private final void handleStoreState(WidgetHomeViewModel$StoreState storeState) {
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState rightPanelState = storeState.getRightPanelState();
        long guildId = storeState.getGuildInfo().getGuildId();
        boolean zIsLurking = storeState.getGuildInfo().isLurking();
        StoreGuildWelcomeScreens$State welcomeScreenState = storeState.getGuildInfo().getWelcomeScreenState();
        boolean zIsNewUser = UserUtils.INSTANCE.isNewUser(storeState.getMe(), this.clock);
        updateViewState(new WidgetHomeViewModel$ViewState(leftPanelState, rightPanelState, storeState.getGuildInfo().isNsfwUnconsented(), storeState.isChannelNsfw(), storeState.getNsfwAllowed(), storeState.getGuildId()));
        if (zIsLurking && !this.storeGuildWelcomeScreens.hasWelcomeScreenBeenSeen(guildId)) {
            if (welcomeScreenState instanceof StoreGuildWelcomeScreens$State$Loaded) {
                emitShowWelcomeSheet(guildId);
            } else if (welcomeScreenState == null) {
                this.storeGuildWelcomeScreens.fetchIfNonexisting(guildId);
            }
        }
        if (shouldShowChannelOnboardingSheet(this.previousLeftPanelState, leftPanelState, guildId, zIsNewUser)) {
            emitShowChannelOnboardingSheet();
        } else if (shouldShowGuildEventUpsell(storeState.getGuildInfo().getCanManageEvents(), storeState.isInEventsUpsellExperiment())) {
            SharedPreferences$Editor sharedPreferences$EditorEdit = this.sharedPreferences.edit();
            m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
            sharedPreferences$EditorEdit.putBoolean(WidgetGuildScheduledEventUpsellBottomSheet.GUILD_EVENT_UPSELL_CACHE_KEY, true);
            sharedPreferences$EditorEdit.apply();
            emitShowGuildEventUpsell(guildId);
        } else if (this.playstationUpsellManager.canShow(storeState.getMe(), storeState.getConnectedAccountsState())) {
            emitShowPlaystationUpsell();
            this.playstationUpsellManager.setHasBeenShown();
        } else if (storeState.getGuildInfo().getGuild() != null && this.guildRoleSubscriptionsUpsellManager.canShow(storeState.getGuildInfo().getGuild())) {
            emitShowGuildRoleSubscriptionUpsell(storeState.getGuildId());
            this.guildRoleSubscriptionsUpsellManager.setHasBeenShown();
        }
        this.previousLeftPanelState = leftPanelState;
        if (storeState.isThreadPeek() && !this.wasThreadPeek) {
            emitAnimatePeekIn();
        }
        if (!storeState.isThreadPeek() && this.wasThreadPeek) {
            emitAnimatePeekOut();
        }
        this.wasThreadPeek = storeState.isThreadPeek();
    }

    private final boolean shouldShowChannelOnboardingSheet(PanelState previousLeftPanelState, PanelState leftPanelState, long guildId, boolean isNewUser) {
        return ((previousLeftPanelState instanceof PanelState$d) && (leftPanelState instanceof PanelState$c)) && ((guildId > 0L ? 1 : (guildId == 0L ? 0 : -1)) != 0) && isNewUser && !this.channelOnboardingManager.hasUserSeenChannelOnboarding();
    }

    private final boolean shouldShowGuildEventUpsell(boolean canManageEvents, boolean isInEventsUpsellExperiment) {
        return canManageEvents && !this.sharedPreferences.getBoolean(WidgetGuildScheduledEventUpsellBottomSheet.GUILD_EVENT_UPSELL_CACHE_KEY, false) && isInEventsUpsellExperiment;
    }

    @MainThread
    public final void emitOpenLeftPanelEvent() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetHomeViewModel$Event$OpenLeftPanel.INSTANCE);
    }

    /* JADX INFO: renamed from: getWidgetHomeModel$app_productionGoogleRelease, reason: from getter */
    public final WidgetHomeModel getWidgetHomeModel() {
        return this.widgetHomeModel;
    }

    public final Observable<WidgetHomeViewModel$Event> observeEvents() {
        PublishSubject<WidgetHomeViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onEndPanelStateChange(PanelState panelState) {
        m.checkNotNullParameter(panelState, "panelState");
        this.storeNavigation.setRightPanelState(panelState);
    }

    public final void onStartPanelStateChange(PanelState panelState) {
        m.checkNotNullParameter(panelState, "panelState");
        this.storeNavigation.setLeftPanelState(panelState);
    }

    public final void setWidgetHomeModel$app_productionGoogleRelease(WidgetHomeModel widgetHomeModel) {
        this.widgetHomeModel = widgetHomeModel;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHomeViewModel(StoreNavigation storeNavigation, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, Observable<WidgetHomeViewModel$StoreState> observable, Observable<StoreNavigation$PanelAction> observable2, ChannelOnboardingManager channelOnboardingManager, SharedPreferences sharedPreferences, Clock clock) {
        m.checkNotNullParameter(storeNavigation, "storeNavigation");
        m.checkNotNullParameter(storeGuildWelcomeScreens, "storeGuildWelcomeScreens");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(observable2, "navPanelActionObservable");
        m.checkNotNullParameter(channelOnboardingManager, "channelOnboardingManager");
        m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        m.checkNotNullParameter(clock, "clock");
        PanelState$a panelState$a = PanelState$a.a;
        super(new WidgetHomeViewModel$ViewState(panelState$a, panelState$a, false, false, NsfwAllowance.UNKNOWN, 0L));
        this.storeNavigation = storeNavigation;
        this.storeGuildWelcomeScreens = storeGuildWelcomeScreens;
        this.storeExperiments = storeExperiments;
        this.storeUser = storeUser;
        this.channelOnboardingManager = channelOnboardingManager;
        this.sharedPreferences = sharedPreferences;
        this.clock = clock;
        this.eventSubject = PublishSubject.k0();
        this.playstationUpsellManager = new PlaystationUpsellManager(sharedPreferences, storeExperiments, clock);
        this.guildRoleSubscriptionsUpsellManager = new GuildRoleSubscriptionOnboardingUpsellManager(sharedPreferences, storePermissions, storeUser, storeExperiments, storeGuilds);
        Observable<WidgetHomeViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetHomeViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHomeViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable2, this, null, 2, null), WidgetHomeViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHomeViewModel$2(this), 62, (Object) null);
    }
}
