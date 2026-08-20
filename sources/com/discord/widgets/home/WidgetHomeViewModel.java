package com.discord.widgets.home;

import android.content.SharedPreferences;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.ChannelOnboardingManager;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet;
import com.discord.widgets.playstation.PlaystationUpsellManager;
import com.discord.widgets.servers.guild_role_subscription.upsell.GuildRoleSubscriptionOnboardingUpsellManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func5;
import p658rx.functions.Func8;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ChannelOnboardingManager channelOnboardingManager;
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
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

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeViewModel$1 */
    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final class C89791 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C89791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetHomeViewModel widgetHomeViewModel = WidgetHomeViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetHomeViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeViewModel$2 */
    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final class C89802 extends AbstractC12240o implements Function1<StoreNavigation.PanelAction, Unit> {
        public C89802() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.PanelAction panelAction) {
            invoke2(panelAction);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNavigation.PanelAction panelAction) {
            C12238m.checkNotNullParameter(panelAction, "panelAction");
            WidgetHomeViewModel.this.handleNavDrawerAction(panelAction);
        }
    }

    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreNavigation storeNavigation, final StoreLurking storeLurking, StoreUser storeUser, final StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, final StorePermissions storePermissions, StoreUserConnections storeUserConnections, final StoreGuildsNsfw storeGuildsNsfw) {
            Observable<StoreState> observableM11067d = Observable.m11067d(storeNavigation.observeLeftPanelState(), storeNavigation.observeRightPanelState(), storeGuildSelected.observeSelectedGuildId().m11099Y(new InterfaceC12589b<Long, Observable<? extends GuildInfo>>() { // from class: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetHomeViewModel.GuildInfo> call(final Long l) {
                    StoreGuilds storeGuilds2 = storeGuilds;
                    C12238m.checkNotNullExpressionValue(l, "selectedGuildId");
                    return Observable.m11072g(storeGuilds2.observeGuild(l.longValue()), storeLurking.isLurkingObs(l.longValue()), storeGuildWelcomeScreens.observeGuildWelcomeScreen(l.longValue()), storePermissions.observePermissionsForGuild(l.longValue()), storeGuildsNsfw.observeIsGuildNsfwGateAgreed(l.longValue()), new Func5<Guild, Boolean, StoreGuildWelcomeScreens.State, Long, Boolean, WidgetHomeViewModel.GuildInfo>() { // from class: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1.1
                        @Override // p658rx.functions.Func5
                        public final WidgetHomeViewModel.GuildInfo call(Guild guild, Boolean bool, StoreGuildWelcomeScreens.State state, Long l2, Boolean bool2) {
                            Long l3 = l;
                            C12238m.checkNotNullExpressionValue(l3, "selectedGuildId");
                            long jLongValue = l3.longValue();
                            C12238m.checkNotNullExpressionValue(bool, "isLurking");
                            return new WidgetHomeViewModel.GuildInfo(jLongValue, guild, bool.booleanValue(), state, !bool2.booleanValue(), l2 != null ? PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l2.longValue())) : false);
                        }
                    });
                }
            }), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeResolvedSelectedChannel(), storeExperiments.observeUserExperiment("2021-09_events_upsell", false), storeUserConnections.observeConnectedAccounts(), storeExperiments.observeUserExperiment("2021-12_connected_accounts_playstation", false), new Func8<PanelState, PanelState, GuildInfo, MeUser, StoreChannelsSelected.ResolvedSelectedChannel, Experiment, StoreUserConnections.State, Experiment, StoreState>() { // from class: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func8
                public final WidgetHomeViewModel.StoreState call(PanelState panelState, PanelState panelState2, WidgetHomeViewModel.GuildInfo guildInfo, MeUser meUser, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Experiment experiment, StoreUserConnections.State state, Experiment experiment2) {
                    Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
                    boolean z2 = maybeChannel != null && maybeChannel.getNsfw();
                    NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
                    if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel)) {
                        resolvedSelectedChannel = null;
                    }
                    StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
                    boolean z3 = (channel != null ? channel.getPeekParent() : null) != null;
                    C12238m.checkNotNullExpressionValue(panelState, "leftPanelState");
                    C12238m.checkNotNullExpressionValue(panelState2, "rightPanelState");
                    C12238m.checkNotNullExpressionValue(guildInfo, "guildInfo");
                    C12238m.checkNotNullExpressionValue(meUser, "me");
                    boolean z4 = experiment != null && experiment.getBucket() == 1;
                    long guildId = guildInfo.getGuildId();
                    C12238m.checkNotNullExpressionValue(state, "connectedAccounts");
                    return new WidgetHomeViewModel.StoreState(panelState, panelState2, guildInfo, meUser, z3, z4, z2, nsfwAllowance, guildId, state);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11067d, "Observable.combineLatest…counts,\n        )\n      }");
            return observableM11067d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class AnimatePeekIn extends Event {
            public static final AnimatePeekIn INSTANCE = new AnimatePeekIn();

            private AnimatePeekIn() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class AnimatePeekOut extends Event {
            public static final AnimatePeekOut INSTANCE = new AnimatePeekOut();

            private AnimatePeekOut() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class ClosePanels extends Event {
            public static final ClosePanels INSTANCE = new ClosePanels();

            private ClosePanels() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class OpenLeftPanel extends Event {
            public static final OpenLeftPanel INSTANCE = new OpenLeftPanel();

            private OpenLeftPanel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class ShowChannelOnboardingSheet extends Event {
            public static final ShowChannelOnboardingSheet INSTANCE = new ShowChannelOnboardingSheet();

            private ShowChannelOnboardingSheet() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final /* data */ class ShowGuildEventUpsell extends Event {
            private final long guildId;

            public ShowGuildEventUpsell(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ ShowGuildEventUpsell copy$default(ShowGuildEventUpsell showGuildEventUpsell, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showGuildEventUpsell.guildId;
                }
                return showGuildEventUpsell.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final ShowGuildEventUpsell copy(long guildId) {
                return new ShowGuildEventUpsell(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowGuildEventUpsell) && this.guildId == ((ShowGuildEventUpsell) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return C0002b.m3a(this.guildId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("ShowGuildEventUpsell(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final /* data */ class ShowGuildRoleSubscriptionUpsell extends Event {
            private final long guildId;

            public ShowGuildRoleSubscriptionUpsell(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ ShowGuildRoleSubscriptionUpsell copy$default(ShowGuildRoleSubscriptionUpsell showGuildRoleSubscriptionUpsell, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showGuildRoleSubscriptionUpsell.guildId;
                }
                return showGuildRoleSubscriptionUpsell.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final ShowGuildRoleSubscriptionUpsell copy(long guildId) {
                return new ShowGuildRoleSubscriptionUpsell(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowGuildRoleSubscriptionUpsell) && this.guildId == ((ShowGuildRoleSubscriptionUpsell) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return C0002b.m3a(this.guildId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("ShowGuildRoleSubscriptionUpsell(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final /* data */ class ShowGuildWelcomeSheet extends Event {
            private final long guildId;

            public ShowGuildWelcomeSheet(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ ShowGuildWelcomeSheet copy$default(ShowGuildWelcomeSheet showGuildWelcomeSheet, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showGuildWelcomeSheet.guildId;
                }
                return showGuildWelcomeSheet.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final ShowGuildWelcomeSheet copy(long guildId) {
                return new ShowGuildWelcomeSheet(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowGuildWelcomeSheet) && this.guildId == ((ShowGuildWelcomeSheet) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return C0002b.m3a(this.guildId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("ShowGuildWelcomeSheet(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class ShowPlaystationUpsell extends Event {
            public static final ShowPlaystationUpsell INSTANCE = new ShowPlaystationUpsell();

            private ShowPlaystationUpsell() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
        public static final class UnlockLeftPanel extends Event {
            public static final UnlockLeftPanel INSTANCE = new UnlockLeftPanel();

            private UnlockLeftPanel() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final /* data */ class GuildInfo {
        private final boolean canManageEvents;
        private final Guild guild;
        private final long guildId;
        private final boolean isLurking;
        private final boolean isNsfwUnconsented;
        private final StoreGuildWelcomeScreens.State welcomeScreenState;

        public GuildInfo(long j, Guild guild, boolean z2, StoreGuildWelcomeScreens.State state, boolean z3, boolean z4) {
            this.guildId = j;
            this.guild = guild;
            this.isLurking = z2;
            this.welcomeScreenState = state;
            this.isNsfwUnconsented = z3;
            this.canManageEvents = z4;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsLurking() {
            return this.isLurking;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreGuildWelcomeScreens.State getWelcomeScreenState() {
            return this.welcomeScreenState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final GuildInfo copy(long guildId, Guild guild, boolean isLurking, StoreGuildWelcomeScreens.State welcomeScreenState, boolean isNsfwUnconsented, boolean canManageEvents) {
            return new GuildInfo(guildId, guild, isLurking, welcomeScreenState, isNsfwUnconsented, canManageEvents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildInfo)) {
                return false;
            }
            GuildInfo guildInfo = (GuildInfo) other;
            return this.guildId == guildInfo.guildId && C12238m.areEqual(this.guild, guildInfo.guild) && this.isLurking == guildInfo.isLurking && C12238m.areEqual(this.welcomeScreenState, guildInfo.welcomeScreenState) && this.isNsfwUnconsented == guildInfo.isNsfwUnconsented && this.canManageEvents == guildInfo.canManageEvents;
        }

        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final StoreGuildWelcomeScreens.State getWelcomeScreenState() {
            return this.welcomeScreenState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            Guild guild = this.guild;
            int iHashCode = (iM3a + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isLurking;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            StoreGuildWelcomeScreens.State state = this.welcomeScreenState;
            int iHashCode2 = (i + (state != null ? state.hashCode() : 0)) * 31;
            boolean z3 = this.isNsfwUnconsented;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (iHashCode2 + r2) * 31;
            boolean z4 = this.canManageEvents;
            return i2 + (z4 ? 1 : z4);
        }

        public final boolean isLurking() {
            return this.isLurking;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildInfo(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", isLurking=");
            sbM833U.append(this.isLurking);
            sbM833U.append(", welcomeScreenState=");
            sbM833U.append(this.welcomeScreenState);
            sbM833U.append(", isNsfwUnconsented=");
            sbM833U.append(this.isNsfwUnconsented);
            sbM833U.append(", canManageEvents=");
            return C1643a.m827O(sbM833U, this.canManageEvents, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreUserConnections.State connectedAccountsState;
        private final long guildId;
        private final GuildInfo guildInfo;
        private final boolean isChannelNsfw;
        private final boolean isInEventsUpsellExperiment;
        private final boolean isThreadPeek;
        private final PanelState leftPanelState;
        private final MeUser me;
        private final NsfwAllowance nsfwAllowed;
        private final PanelState rightPanelState;

        public StoreState(PanelState panelState, PanelState panelState2, GuildInfo guildInfo, MeUser meUser, boolean z2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, long j, StoreUserConnections.State state) {
            C12238m.checkNotNullParameter(panelState, "leftPanelState");
            C12238m.checkNotNullParameter(panelState2, "rightPanelState");
            C12238m.checkNotNullParameter(guildInfo, "guildInfo");
            C12238m.checkNotNullParameter(meUser, "me");
            C12238m.checkNotNullParameter(state, "connectedAccountsState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.guildInfo = guildInfo;
            this.me = meUser;
            this.isThreadPeek = z2;
            this.isInEventsUpsellExperiment = z3;
            this.isChannelNsfw = z4;
            this.nsfwAllowed = nsfwAllowance;
            this.guildId = j;
            this.connectedAccountsState = state;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final StoreUserConnections.State getConnectedAccountsState() {
            return this.connectedAccountsState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsThreadPeek() {
            return this.isThreadPeek;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsInEventsUpsellExperiment() {
            return this.isInEventsUpsellExperiment;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final StoreState copy(PanelState leftPanelState, PanelState rightPanelState, GuildInfo guildInfo, MeUser me2, boolean isThreadPeek, boolean isInEventsUpsellExperiment, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId, StoreUserConnections.State connectedAccountsState) {
            C12238m.checkNotNullParameter(leftPanelState, "leftPanelState");
            C12238m.checkNotNullParameter(rightPanelState, "rightPanelState");
            C12238m.checkNotNullParameter(guildInfo, "guildInfo");
            C12238m.checkNotNullParameter(me2, "me");
            C12238m.checkNotNullParameter(connectedAccountsState, "connectedAccountsState");
            return new StoreState(leftPanelState, rightPanelState, guildInfo, me2, isThreadPeek, isInEventsUpsellExperiment, isChannelNsfw, nsfwAllowed, guildId, connectedAccountsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.leftPanelState, storeState.leftPanelState) && C12238m.areEqual(this.rightPanelState, storeState.rightPanelState) && C12238m.areEqual(this.guildInfo, storeState.guildInfo) && C12238m.areEqual(this.me, storeState.me) && this.isThreadPeek == storeState.isThreadPeek && this.isInEventsUpsellExperiment == storeState.isInEventsUpsellExperiment && this.isChannelNsfw == storeState.isChannelNsfw && C12238m.areEqual(this.nsfwAllowed, storeState.nsfwAllowed) && this.guildId == storeState.guildId && C12238m.areEqual(this.connectedAccountsState, storeState.connectedAccountsState);
        }

        public final StoreUserConnections.State getConnectedAccountsState() {
            return this.connectedAccountsState;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final GuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            GuildInfo guildInfo = this.guildInfo;
            int iHashCode3 = (iHashCode2 + (guildInfo != null ? guildInfo.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            boolean z2 = this.isThreadPeek;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode4 + r2) * 31;
            boolean z3 = this.isInEventsUpsellExperiment;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.isChannelNsfw;
            int i3 = (i2 + (z4 ? 1 : z4)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            int iM3a = (C0002b.m3a(this.guildId) + ((i3 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31)) * 31;
            StoreUserConnections.State state = this.connectedAccountsState;
            return iM3a + (state != null ? state.hashCode() : 0);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isInEventsUpsellExperiment() {
            return this.isInEventsUpsellExperiment;
        }

        public final boolean isThreadPeek() {
            return this.isThreadPeek;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(leftPanelState=");
            sbM833U.append(this.leftPanelState);
            sbM833U.append(", rightPanelState=");
            sbM833U.append(this.rightPanelState);
            sbM833U.append(", guildInfo=");
            sbM833U.append(this.guildInfo);
            sbM833U.append(", me=");
            sbM833U.append(this.me);
            sbM833U.append(", isThreadPeek=");
            sbM833U.append(this.isThreadPeek);
            sbM833U.append(", isInEventsUpsellExperiment=");
            sbM833U.append(this.isInEventsUpsellExperiment);
            sbM833U.append(", isChannelNsfw=");
            sbM833U.append(this.isChannelNsfw);
            sbM833U.append(", nsfwAllowed=");
            sbM833U.append(this.nsfwAllowed);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", connectedAccountsState=");
            sbM833U.append(this.connectedAccountsState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final /* data */ class ViewState {
        private final long guildId;
        private final boolean isChannelNsfw;
        private final boolean isNsfwUnconsented;
        private final PanelState leftPanelState;
        private final NsfwAllowance nsfwAllowed;
        private final PanelState rightPanelState;

        public ViewState(PanelState panelState, PanelState panelState2, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j) {
            C12238m.checkNotNullParameter(panelState, "leftPanelState");
            C12238m.checkNotNullParameter(panelState2, "rightPanelState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.isNsfwUnconsented = z2;
            this.isChannelNsfw = z3;
            this.nsfwAllowed = nsfwAllowance;
            this.guildId = j;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, PanelState panelState, PanelState panelState2, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                panelState = viewState.leftPanelState;
            }
            if ((i & 2) != 0) {
                panelState2 = viewState.rightPanelState;
            }
            PanelState panelState3 = panelState2;
            if ((i & 4) != 0) {
                z2 = viewState.isNsfwUnconsented;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                z3 = viewState.isChannelNsfw;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                nsfwAllowance = viewState.nsfwAllowed;
            }
            NsfwAllowance nsfwAllowance2 = nsfwAllowance;
            if ((i & 32) != 0) {
                j = viewState.guildId;
            }
            return viewState.copy(panelState, panelState3, z4, z5, nsfwAllowance2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final ViewState copy(PanelState leftPanelState, PanelState rightPanelState, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId) {
            C12238m.checkNotNullParameter(leftPanelState, "leftPanelState");
            C12238m.checkNotNullParameter(rightPanelState, "rightPanelState");
            return new ViewState(leftPanelState, rightPanelState, isNsfwUnconsented, isChannelNsfw, nsfwAllowed, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.leftPanelState, viewState.leftPanelState) && C12238m.areEqual(this.rightPanelState, viewState.rightPanelState) && this.isNsfwUnconsented == viewState.isNsfwUnconsented && this.isChannelNsfw == viewState.isChannelNsfw && C12238m.areEqual(this.nsfwAllowed, viewState.nsfwAllowed) && this.guildId == viewState.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            boolean z2 = this.isNsfwUnconsented;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            boolean z3 = this.isChannelNsfw;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            return C0002b.m3a(this.guildId) + ((i2 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(leftPanelState=");
            sbM833U.append(this.leftPanelState);
            sbM833U.append(", rightPanelState=");
            sbM833U.append(this.rightPanelState);
            sbM833U.append(", isNsfwUnconsented=");
            sbM833U.append(this.isNsfwUnconsented);
            sbM833U.append(", isChannelNsfw=");
            sbM833U.append(this.isChannelNsfw);
            sbM833U.append(", nsfwAllowed=");
            sbM833U.append(this.nsfwAllowed);
            sbM833U.append(", guildId=");
            return C1643a.m815C(sbM833U, this.guildId, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreNavigation.PanelAction.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreNavigation.PanelAction.OPEN.ordinal()] = 1;
            iArr[StoreNavigation.PanelAction.CLOSE.ordinal()] = 2;
            iArr[StoreNavigation.PanelAction.UNLOCK_LEFT.ordinal()] = 3;
            iArr[StoreNavigation.PanelAction.NOOP.ordinal()] = 4;
        }
    }

    public WidgetHomeViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHomeViewModel(StoreNavigation storeNavigation, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, Observable observable, Observable observable2, ChannelOnboardingManager channelOnboardingManager, SharedPreferences sharedPreferences, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState;
        StoreNavigation navigation = (i & 1) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        StoreGuildWelcomeScreens guildWelcomeScreens = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildWelcomeScreens() : storeGuildWelcomeScreens;
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        if ((i & 64) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(guilds, companion2.getGuildSelected(), navigation, companion2.getLurking(), users, guildWelcomeScreens, companion2.getChannelsSelected(), experiments, companion2.getPermissions(), companion2.getUserConnections(), companion2.getGuildsNsfw());
        } else {
            observableObserveStoreState = observable;
        }
        this(navigation, guildWelcomeScreens, experiments, guilds, permissions, users, observableObserveStoreState, (i & 128) != 0 ? navigation.getNavigationPanelAction() : observable2, (i & 256) != 0 ? new ChannelOnboardingManager() : channelOnboardingManager, (i & 512) != 0 ? SharedPreferencesProvider.INSTANCE.get() : sharedPreferences, (i & 1024) != 0 ? ClockFactory.get() : clock);
    }

    @MainThread
    private final void emitAnimatePeekIn() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.AnimatePeekIn.INSTANCE);
    }

    @MainThread
    private final void emitAnimatePeekOut() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.AnimatePeekOut.INSTANCE);
    }

    @MainThread
    private final void emitClosePanelsEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ClosePanels.INSTANCE);
    }

    @MainThread
    private final void emitShowChannelOnboardingSheet() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowChannelOnboardingSheet.INSTANCE);
    }

    @MainThread
    private final void emitShowGuildEventUpsell(long guildId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowGuildEventUpsell(guildId));
    }

    @MainThread
    private final void emitShowGuildRoleSubscriptionUpsell(long guildId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowGuildRoleSubscriptionUpsell(guildId));
    }

    @MainThread
    private final void emitShowPlaystationUpsell() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowPlaystationUpsell.INSTANCE);
    }

    @MainThread
    private final void emitShowWelcomeSheet(long guildId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowGuildWelcomeSheet(guildId));
    }

    @MainThread
    private final void emitUnlockLeftPanelEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.UnlockLeftPanel.INSTANCE);
    }

    @MainThread
    private final void handleNavDrawerAction(StoreNavigation.PanelAction navPanelAction) {
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
    private final void handleStoreState(StoreState storeState) {
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState rightPanelState = storeState.getRightPanelState();
        long guildId = storeState.getGuildInfo().getGuildId();
        boolean zIsLurking = storeState.getGuildInfo().isLurking();
        StoreGuildWelcomeScreens.State welcomeScreenState = storeState.getGuildInfo().getWelcomeScreenState();
        boolean zIsNewUser = UserUtils.INSTANCE.isNewUser(storeState.getMe(), this.clock);
        updateViewState(new ViewState(leftPanelState, rightPanelState, storeState.getGuildInfo().isNsfwUnconsented(), storeState.isChannelNsfw(), storeState.getNsfwAllowed(), storeState.getGuildId()));
        if (zIsLurking && !this.storeGuildWelcomeScreens.hasWelcomeScreenBeenSeen(guildId)) {
            if (welcomeScreenState instanceof StoreGuildWelcomeScreens.State.Loaded) {
                emitShowWelcomeSheet(guildId);
            } else if (welcomeScreenState == null) {
                this.storeGuildWelcomeScreens.fetchIfNonexisting(guildId);
            }
        }
        if (shouldShowChannelOnboardingSheet(this.previousLeftPanelState, leftPanelState, guildId, zIsNewUser)) {
            emitShowChannelOnboardingSheet();
        } else if (shouldShowGuildEventUpsell(storeState.getGuildInfo().getCanManageEvents(), storeState.isInEventsUpsellExperiment())) {
            SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
            C12238m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean(WidgetGuildScheduledEventUpsellBottomSheet.GUILD_EVENT_UPSELL_CACHE_KEY, true);
            editorEdit.apply();
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
        return ((previousLeftPanelState instanceof PanelState.C5581d) && (leftPanelState instanceof PanelState.C5580c)) && ((guildId > 0L ? 1 : (guildId == 0L ? 0 : -1)) != 0) && isNewUser && !this.channelOnboardingManager.hasUserSeenChannelOnboarding();
    }

    private final boolean shouldShowGuildEventUpsell(boolean canManageEvents, boolean isInEventsUpsellExperiment) {
        return canManageEvents && !this.sharedPreferences.getBoolean(WidgetGuildScheduledEventUpsellBottomSheet.GUILD_EVENT_UPSELL_CACHE_KEY, false) && isInEventsUpsellExperiment;
    }

    @MainThread
    public final void emitOpenLeftPanelEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.OpenLeftPanel.INSTANCE);
    }

    /* JADX INFO: renamed from: getWidgetHomeModel$app_productionGoogleRelease, reason: from getter */
    public final WidgetHomeModel getWidgetHomeModel() {
        return this.widgetHomeModel;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onEndPanelStateChange(PanelState panelState) {
        C12238m.checkNotNullParameter(panelState, "panelState");
        this.storeNavigation.setRightPanelState(panelState);
    }

    public final void onStartPanelStateChange(PanelState panelState) {
        C12238m.checkNotNullParameter(panelState, "panelState");
        this.storeNavigation.setLeftPanelState(panelState);
    }

    public final void setWidgetHomeModel$app_productionGoogleRelease(WidgetHomeModel widgetHomeModel) {
        this.widgetHomeModel = widgetHomeModel;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHomeViewModel(StoreNavigation storeNavigation, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, Observable<StoreState> observable, Observable<StoreNavigation.PanelAction> observable2, ChannelOnboardingManager channelOnboardingManager, SharedPreferences sharedPreferences, Clock clock) {
        C12238m.checkNotNullParameter(storeNavigation, "storeNavigation");
        C12238m.checkNotNullParameter(storeGuildWelcomeScreens, "storeGuildWelcomeScreens");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        C12238m.checkNotNullParameter(observable2, "navPanelActionObservable");
        C12238m.checkNotNullParameter(channelOnboardingManager, "channelOnboardingManager");
        C12238m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        C12238m.checkNotNullParameter(clock, "clock");
        PanelState.C5578a c5578a = PanelState.C5578a.f18640a;
        super(new ViewState(c5578a, c5578a, false, false, NsfwAllowance.UNKNOWN, 0L));
        this.storeNavigation = storeNavigation;
        this.storeGuildWelcomeScreens = storeGuildWelcomeScreens;
        this.storeExperiments = storeExperiments;
        this.storeUser = storeUser;
        this.channelOnboardingManager = channelOnboardingManager;
        this.sharedPreferences = sharedPreferences;
        this.clock = clock;
        this.eventSubject = PublishSubject.m11133k0();
        this.playstationUpsellManager = new PlaystationUpsellManager(sharedPreferences, storeExperiments, clock);
        this.guildRoleSubscriptionsUpsellManager = new GuildRoleSubscriptionOnboardingUpsellManager(sharedPreferences, storePermissions, storeUser, storeExperiments, storeGuilds);
        Observable<StoreState> observableM11112r = observable.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetHomeViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89791());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable2, this, null, 2, null), (Class<?>) WidgetHomeViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89802());
    }
}
