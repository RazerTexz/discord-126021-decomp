package com.discord.widgets.channels;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.panels.PanelState;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelIconUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import com.discord.widgets.tabs.NavigationTab;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func5;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private Long previousChannelId;
    private Set<Integer> revealedIndices;
    private Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> topicParser;
    private boolean wasOnHomeTab;
    private boolean wasRightPanelOpened;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
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
            WidgetChannelTopicViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class NavState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NavState(boolean z2, boolean z3) {
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NavState copy$default(NavState navState, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = navState.isRightPanelOpened;
                }
                if ((i & 2) != 0) {
                    z3 = navState.isOnHomeTab;
                }
                return navState.copy(z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            public final NavState copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NavState(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavState)) {
                    return false;
                }
                NavState navState = (NavState) other;
                return this.isRightPanelOpened == navState.isRightPanelOpened && this.isOnHomeTab == navState.isOnHomeTab;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean z2 = this.isRightPanelOpened;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.isOnHomeTab;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isOnHomeTab() {
                return this.isOnHomeTab;
            }

            public final boolean isRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NavState(isRightPanelOpened=");
                sbU.append(this.isRightPanelOpened);
                sbU.append(", isOnHomeTab=");
                return outline.O(sbU, this.isOnHomeTab, ")");
            }
        }

        private Companion() {
        }

        private final Observable<StoreState.Guild> mapChannelToGuildStoreState(final Channel channel, final NavState navState, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            long guildId = channel.getGuildId();
            Observable<StoreState.Guild> observableG = Observable.g(StoreChannels.observeChannelsForGuild$default(storeChannels, guildId, null, 2, null), storeUsers.observeAllUsers(), storeGuilds.observeComputed(guildId), storeGuilds.observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeUserSettings, false, 1, null), new Func5<Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Boolean, StoreState.Guild>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1
                @Override // rx.functions.Func5
                public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.StoreState.Guild call(Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Boolean bool) {
                    return call2((Map<Long, Channel>) map, map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, bool);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChannelTopicViewModel.StoreState.Guild call2(Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Boolean bool) {
                    Channel channel2 = channel;
                    Intrinsics3.checkNotNullExpressionValue(map, "channels");
                    GuildChannelIconUtils channelType = GuildChannelIconUtils2.getChannelType(channel);
                    Intrinsics3.checkNotNullExpressionValue(map2, "users");
                    Intrinsics3.checkNotNullExpressionValue(map3, "members");
                    Intrinsics3.checkNotNullExpressionValue(map4, "roles");
                    Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
                    return new WidgetChannelTopicViewModel.StoreState.Guild.Topic(channel2, map, channelType, map2, map3, map4, bool.booleanValue(), navState.isRightPanelOpened(), navState.isOnHomeTab());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…HomeTab\n        )\n      }");
            return observableG;
        }

        private final Observable<StoreState> mapChannelToPrivateStoreState(final Channel channel, final NavState navState, StoreGuilds storeGuilds, final StoreUserSettings storeUserSettings) {
            if (ChannelUtils.p(channel)) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new StoreState.GDM(channel, storeUserSettings.getIsDeveloperMode(), navState.isRightPanelOpened(), navState.isOnHomeTab()));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(\n       …            )\n          )");
                return scalarSynchronousObservable;
            }
            Observable observableG = storeGuilds.observeComputed().G(new Func1<Map<Long, ? extends Map<Long, ? extends GuildMember>>, StoreState>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.StoreState call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
                    return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChannelTopicViewModel.StoreState call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
                    return new WidgetChannelTopicViewModel.StoreState.DM(channel, map.values(), storeUserSettings.getIsDeveloperMode(), navState.isRightPanelOpened(), navState.isOnHomeTab());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeGuilds.observeCompu…            )\n          }");
            return observableG;
        }

        private final Observable<NavState> observeNavState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation) {
            Observable<NavState> observableJ = Observable.j(storeNavigation.observeRightPanelState().G(new Func1<PanelState, Boolean>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$1
                @Override // j0.k.Func1
                public final Boolean call(PanelState panelState) {
                    return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.c.a));
                }
            }), storeTabsNavigation.observeSelectedTab().G(new Func1<NavigationTab, Boolean>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$2
                @Override // j0.k.Func1
                public final Boolean call(NavigationTab navigationTab) {
                    return Boolean.valueOf(navigationTab == NavigationTab.HOME);
                }
            }), new Func2<Boolean, Boolean, NavState>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$3
                @Override // rx.functions.Func2
                public final WidgetChannelTopicViewModel.Companion.NavState call(Boolean bool, Boolean bool2) {
                    Intrinsics3.checkNotNullExpressionValue(bool, "isOpen");
                    boolean zBooleanValue = bool.booleanValue();
                    Intrinsics3.checkNotNullExpressionValue(bool2, "isOnHomeTab");
                    return new WidgetChannelTopicViewModel.Companion.NavState(zBooleanValue, bool2.booleanValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…sOpen, isOnHomeTab)\n    }");
            return observableJ;
        }

        public static /* synthetic */ Observable observeNavState$default(Companion companion, StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, int i, Object obj) {
            if ((i & 1) != 0) {
                storeNavigation = StoreStream.INSTANCE.getNavigation();
            }
            if ((i & 2) != 0) {
                storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
            }
            return companion.observeNavState(storeNavigation, storeTabsNavigation);
        }

        private final Observable<StoreState> observeStoreState(final NavState navState, StoreChannelsSelected storeChannelsSelected, final StoreChannels storeChannels, final StoreUser storeUsers, final StoreGuilds storeGuilds, final StoreUserSettings storeUserSettings) {
            Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new Func1<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChannelTopicViewModel.StoreState> call(Channel channel) {
                    if (channel == null) {
                        return new ScalarSynchronousObservable(new WidgetChannelTopicViewModel.StoreState.NoChannel(navState.isRightPanelOpened(), navState.isOnHomeTab()));
                    }
                    if (ChannelUtils.B(channel)) {
                        return WidgetChannelTopicViewModel.INSTANCE.mapChannelToPrivateStoreState(channel, navState, storeGuilds, storeUserSettings);
                    }
                    if (channel.getTopic() != null) {
                        String topic = channel.getTopic();
                        if (!(topic == null || topic.length() == 0)) {
                            return WidgetChannelTopicViewModel.INSTANCE.mapChannelToGuildStoreState(channel, navState, storeChannels, storeUsers, storeGuilds, storeUserSettings);
                        }
                    }
                    return new ScalarSynchronousObservable(new WidgetChannelTopicViewModel.StoreState.Guild.DefaultTopic(channel, GuildChannelIconUtils2.getChannelType(channel), navState.isRightPanelOpened(), navState.isOnHomeTab()));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, NavState navState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            StoreUser storeUser2 = storeUser;
            if ((i & 16) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 32) != 0) {
                storeUserSettings = StoreStream.INSTANCE.getUserSettings();
            }
            return companion.observeStoreState(navState, storeChannelsSelected2, storeChannels2, storeUser2, storeGuilds2, storeUserSettings);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final class FocusFirstElement extends Event {
            public static final FocusFirstElement INSTANCE = new FocusFirstElement();

            private FocusFirstElement() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
    public static abstract class StoreState {
        private final boolean isOnHomeTab;
        private final boolean isRightPanelOpened;

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class DM extends StoreState {
            private final Channel channel;
            private final boolean developerModeEnabled;
            private final Collection<Map<Long, GuildMember>> guildMembers;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ DM(Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, collection, (i & 4) != 0 ? false : z2, z3, z4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DM copy$default(DM dm, Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = dm.channel;
                }
                if ((i & 2) != 0) {
                    collection = dm.guildMembers;
                }
                Collection collection2 = collection;
                if ((i & 4) != 0) {
                    z2 = dm.developerModeEnabled;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    z3 = dm.getIsRightPanelOpened();
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = dm.getIsOnHomeTab();
                }
                return dm.copy(channel, collection2, z5, z6, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Collection<Map<Long, GuildMember>> component2() {
                return this.guildMembers;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component4() {
                return getIsRightPanelOpened();
            }

            public final boolean component5() {
                return getIsOnHomeTab();
            }

            public final DM copy(Channel channel, Collection<? extends Map<Long, GuildMember>> guildMembers, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                return new DM(channel, guildMembers, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DM)) {
                    return false;
                }
                DM dm = (DM) other;
                return Intrinsics3.areEqual(this.channel, dm.channel) && Intrinsics3.areEqual(this.guildMembers, dm.guildMembers) && this.developerModeEnabled == dm.developerModeEnabled && getIsRightPanelOpened() == dm.getIsRightPanelOpened() && getIsOnHomeTab() == dm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final Collection<Map<Long, GuildMember>> getGuildMembers() {
                return this.guildMembers;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Collection<Map<Long, GuildMember>> collection = this.guildMembers;
                int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
                boolean z2 = this.developerModeEnabled;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r2 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("DM(channel=");
                sbU.append(this.channel);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public DM(Channel channel, Collection<? extends Map<Long, GuildMember>> collection, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(collection, "guildMembers");
                this.channel = channel;
                this.guildMembers = collection;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class GDM extends StoreState {
            private final Channel channel;
            private final boolean developerModeEnabled;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ GDM(Channel channel, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, (i & 2) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ GDM copy$default(GDM gdm, Channel channel, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = gdm.channel;
                }
                if ((i & 2) != 0) {
                    z2 = gdm.developerModeEnabled;
                }
                if ((i & 4) != 0) {
                    z3 = gdm.getIsRightPanelOpened();
                }
                if ((i & 8) != 0) {
                    z4 = gdm.getIsOnHomeTab();
                }
                return gdm.copy(channel, z2, z3, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component3() {
                return getIsRightPanelOpened();
            }

            public final boolean component4() {
                return getIsOnHomeTab();
            }

            public final GDM copy(Channel channel, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new GDM(channel, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GDM)) {
                    return false;
                }
                GDM gdm = (GDM) other;
                return Intrinsics3.areEqual(this.channel, gdm.channel) && this.developerModeEnabled == gdm.developerModeEnabled && getIsRightPanelOpened() == gdm.getIsRightPanelOpened() && getIsOnHomeTab() == gdm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                boolean z2 = this.developerModeEnabled;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r2 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GDM(channel=");
                sbU.append(this.channel);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GDM(Channel channel, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static abstract class Guild extends StoreState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class DefaultTopic extends Guild {
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultTopic(Channel channel, GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3) {
                    super(z2, z3, null);
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    this.channel = channel;
                    this.channelIconType = guildChannelIconUtils;
                    this.isRightPanelOpened = z2;
                    this.isOnHomeTab = z3;
                }

                public static /* synthetic */ DefaultTopic copy$default(DefaultTopic defaultTopic, Channel channel, GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        channel = defaultTopic.channel;
                    }
                    if ((i & 2) != 0) {
                        guildChannelIconUtils = defaultTopic.channelIconType;
                    }
                    if ((i & 4) != 0) {
                        z2 = defaultTopic.getIsRightPanelOpened();
                    }
                    if ((i & 8) != 0) {
                        z3 = defaultTopic.getIsOnHomeTab();
                    }
                    return defaultTopic.copy(channel, guildChannelIconUtils, z2, z3);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final boolean component3() {
                    return getIsRightPanelOpened();
                }

                public final boolean component4() {
                    return getIsOnHomeTab();
                }

                public final DefaultTopic copy(Channel channel, GuildChannelIconUtils channelIconType, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    return new DefaultTopic(channel, channelIconType, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof DefaultTopic)) {
                        return false;
                    }
                    DefaultTopic defaultTopic = (DefaultTopic) other;
                    return Intrinsics3.areEqual(this.channel, defaultTopic.channel) && Intrinsics3.areEqual(this.channelIconType, defaultTopic.channelIconType) && getIsRightPanelOpened() == defaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == defaultTopic.getIsOnHomeTab();
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v6, types: [int] */
                /* JADX WARN: Type inference failed for: r0v8, types: [int] */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v1 */
                /* JADX WARN: Type inference failed for: r2v2, types: [int] */
                /* JADX WARN: Type inference failed for: r2v3 */
                public int hashCode() {
                    Channel channel = this.channel;
                    int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                    GuildChannelIconUtils guildChannelIconUtils = this.channelIconType;
                    int iHashCode2 = (iHashCode + (guildChannelIconUtils != null ? guildChannelIconUtils.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r1 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r1 = 1;
                    }
                    int i = (iHashCode2 + r1) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("DefaultTopic(channel=");
                    sbU.append(this.channel);
                    sbU.append(", channelIconType=");
                    sbU.append(this.channelIconType);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class Topic extends Guild {
                private final boolean allowAnimatedEmojis;
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final Map<Long, Channel> channels;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;
                private final Map<Long, GuildMember> members;
                private final Map<Long, GuildRole> roles;
                private final Map<Long, User> users;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public Topic(Channel channel, Map<Long, Channel> map, GuildChannelIconUtils guildChannelIconUtils, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, boolean z2, boolean z3, boolean z4) {
                    super(z3, z4, null);
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(map, "channels");
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    Intrinsics3.checkNotNullParameter(map2, "users");
                    Intrinsics3.checkNotNullParameter(map3, "members");
                    Intrinsics3.checkNotNullParameter(map4, "roles");
                    this.channel = channel;
                    this.channels = map;
                    this.channelIconType = guildChannelIconUtils;
                    this.users = map2;
                    this.members = map3;
                    this.roles = map4;
                    this.allowAnimatedEmojis = z2;
                    this.isRightPanelOpened = z3;
                    this.isOnHomeTab = z4;
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final Map<Long, Channel> component2() {
                    return this.channels;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, User> component4() {
                    return this.users;
                }

                public final Map<Long, GuildMember> component5() {
                    return this.members;
                }

                public final Map<Long, GuildRole> component6() {
                    return this.roles;
                }

                /* JADX INFO: renamed from: component7, reason: from getter */
                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final boolean component8() {
                    return getIsRightPanelOpened();
                }

                public final boolean component9() {
                    return getIsOnHomeTab();
                }

                public final Topic copy(Channel channel, Map<Long, Channel> channels, GuildChannelIconUtils channelIconType, Map<Long, ? extends User> users, Map<Long, GuildMember> members, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(channels, "channels");
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    Intrinsics3.checkNotNullParameter(users, "users");
                    Intrinsics3.checkNotNullParameter(members, "members");
                    Intrinsics3.checkNotNullParameter(roles, "roles");
                    return new Topic(channel, channels, channelIconType, users, members, roles, allowAnimatedEmojis, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Topic)) {
                        return false;
                    }
                    Topic topic = (Topic) other;
                    return Intrinsics3.areEqual(this.channel, topic.channel) && Intrinsics3.areEqual(this.channels, topic.channels) && Intrinsics3.areEqual(this.channelIconType, topic.channelIconType) && Intrinsics3.areEqual(this.users, topic.users) && Intrinsics3.areEqual(this.members, topic.members) && Intrinsics3.areEqual(this.roles, topic.roles) && this.allowAnimatedEmojis == topic.allowAnimatedEmojis && getIsRightPanelOpened() == topic.getIsRightPanelOpened() && getIsOnHomeTab() == topic.getIsOnHomeTab();
                }

                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, Channel> getChannels() {
                    return this.channels;
                }

                public final Map<Long, GuildMember> getMembers() {
                    return this.members;
                }

                public final Map<Long, GuildRole> getRoles() {
                    return this.roles;
                }

                public final Map<Long, User> getUsers() {
                    return this.users;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v14, types: [int] */
                /* JADX WARN: Type inference failed for: r0v16, types: [int] */
                /* JADX WARN: Type inference failed for: r0v18, types: [int] */
                /* JADX WARN: Type inference failed for: r1v10 */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5, types: [int] */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r1v8 */
                /* JADX WARN: Type inference failed for: r2v13 */
                /* JADX WARN: Type inference failed for: r2v14, types: [int] */
                /* JADX WARN: Type inference failed for: r2v15 */
                public int hashCode() {
                    Channel channel = this.channel;
                    int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                    Map<Long, Channel> map = this.channels;
                    int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                    GuildChannelIconUtils guildChannelIconUtils = this.channelIconType;
                    int iHashCode3 = (iHashCode2 + (guildChannelIconUtils != null ? guildChannelIconUtils.hashCode() : 0)) * 31;
                    Map<Long, User> map2 = this.users;
                    int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                    Map<Long, GuildMember> map3 = this.members;
                    int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                    Map<Long, GuildRole> map4 = this.roles;
                    int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                    boolean z2 = this.allowAnimatedEmojis;
                    ?? r1 = z2;
                    if (z2) {
                        r1 = 1;
                    }
                    int i = (iHashCode6 + r1) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r2 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r2 = 1;
                    }
                    int i2 = (i + r2) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Topic(channel=");
                    sbU.append(this.channel);
                    sbU.append(", channels=");
                    sbU.append(this.channels);
                    sbU.append(", channelIconType=");
                    sbU.append(this.channelIconType);
                    sbU.append(", users=");
                    sbU.append(this.users);
                    sbU.append(", members=");
                    sbU.append(this.members);
                    sbU.append(", roles=");
                    sbU.append(this.roles);
                    sbU.append(", allowAnimatedEmojis=");
                    sbU.append(this.allowAnimatedEmojis);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            public /* synthetic */ Guild(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
                this(z2, z3);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            private Guild(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class NoChannel extends StoreState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NoChannel(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NoChannel copy$default(NoChannel noChannel, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = noChannel.getIsRightPanelOpened();
                }
                if ((i & 2) != 0) {
                    z3 = noChannel.getIsOnHomeTab();
                }
                return noChannel.copy(z2, z3);
            }

            public final boolean component1() {
                return getIsRightPanelOpened();
            }

            public final boolean component2() {
                return getIsOnHomeTab();
            }

            public final NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NoChannel(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoChannel)) {
                    return false;
                }
                NoChannel noChannel = (NoChannel) other;
                return getIsRightPanelOpened() == noChannel.getIsRightPanelOpened() && getIsOnHomeTab() == noChannel.getIsOnHomeTab();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r0 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NoChannel(isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState(boolean z2, boolean z3) {
            this.isRightPanelOpened = z2;
            this.isOnHomeTab = z3;
        }

        /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
        public boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
        public boolean getIsRightPanelOpened() {
            return this.isRightPanelOpened;
        }

        public /* synthetic */ StoreState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
    public static abstract class ViewState {
        private final boolean isOnHomeTab;
        private final boolean isRightPanelOpened;

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class DM extends ViewState {
            private final long channelId;
            private final boolean developerModeEnabled;
            private final List<GuildMember> guildMembers;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;
            private final String recipientName;
            private final Set<String> recipientNicknames;
            private final Long recipientUserId;

            public /* synthetic */ DM(String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, l, set, list, j, (i & 32) != 0 ? false : z2, z3, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getRecipientName() {
                return this.recipientName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getRecipientUserId() {
                return this.recipientUserId;
            }

            public final Set<String> component3() {
                return this.recipientNicknames;
            }

            public final List<GuildMember> component4() {
                return this.guildMembers;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component7() {
                return getIsRightPanelOpened();
            }

            public final boolean component8() {
                return getIsOnHomeTab();
            }

            public final DM copy(String recipientName, Long recipientUserId, Set<String> recipientNicknames, List<GuildMember> guildMembers, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(recipientNicknames, "recipientNicknames");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                return new DM(recipientName, recipientUserId, recipientNicknames, guildMembers, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DM)) {
                    return false;
                }
                DM dm = (DM) other;
                return Intrinsics3.areEqual(this.recipientName, dm.recipientName) && Intrinsics3.areEqual(this.recipientUserId, dm.recipientUserId) && Intrinsics3.areEqual(this.recipientNicknames, dm.recipientNicknames) && Intrinsics3.areEqual(this.guildMembers, dm.guildMembers) && this.channelId == dm.channelId && this.developerModeEnabled == dm.developerModeEnabled && getIsRightPanelOpened() == dm.getIsRightPanelOpened() && getIsOnHomeTab() == dm.getIsOnHomeTab();
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final List<GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final String getRecipientName() {
                return this.recipientName;
            }

            public final Set<String> getRecipientNicknames() {
                return this.recipientNicknames;
            }

            public final Long getRecipientUserId() {
                return this.recipientUserId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v11, types: [int] */
            /* JADX WARN: Type inference failed for: r0v13, types: [int] */
            /* JADX WARN: Type inference failed for: r0v15 */
            /* JADX WARN: Type inference failed for: r0v16 */
            /* JADX WARN: Type inference failed for: r0v18 */
            /* JADX WARN: Type inference failed for: r0v19 */
            /* JADX WARN: Type inference failed for: r1v10, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v9 */
            public int hashCode() {
                String str = this.recipientName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Long l = this.recipientUserId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                Set<String> set = this.recipientNicknames;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                List<GuildMember> list = this.guildMembers;
                int iA = (b.a(this.channelId) + ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31)) * 31;
                boolean z2 = this.developerModeEnabled;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = (iA + r0) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r1 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("DM(recipientName=");
                sbU.append(this.recipientName);
                sbU.append(", recipientUserId=");
                sbU.append(this.recipientUserId);
                sbU.append(", recipientNicknames=");
                sbU.append(this.recipientNicknames);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DM(String str, Long l, Set<String> set, List<GuildMember> list, long j, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(set, "recipientNicknames");
                Intrinsics3.checkNotNullParameter(list, "guildMembers");
                this.recipientName = str;
                this.recipientUserId = l;
                this.recipientNicknames = set;
                this.guildMembers = list;
                this.channelId = j;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class GDM extends ViewState {
            private final Channel channel;
            private final long channelId;
            private final boolean developerModeEnabled;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, j, (i & 4) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ GDM copy$default(GDM gdm, Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = gdm.channel;
                }
                if ((i & 2) != 0) {
                    j = gdm.channelId;
                }
                long j2 = j;
                if ((i & 4) != 0) {
                    z2 = gdm.developerModeEnabled;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    z3 = gdm.getIsRightPanelOpened();
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = gdm.getIsOnHomeTab();
                }
                return gdm.copy(channel, j2, z5, z6, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component4() {
                return getIsRightPanelOpened();
            }

            public final boolean component5() {
                return getIsOnHomeTab();
            }

            public final GDM copy(Channel channel, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new GDM(channel, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GDM)) {
                    return false;
                }
                GDM gdm = (GDM) other;
                return Intrinsics3.areEqual(this.channel, gdm.channel) && this.channelId == gdm.channelId && this.developerModeEnabled == gdm.developerModeEnabled && getIsRightPanelOpened() == gdm.getIsRightPanelOpened() && getIsOnHomeTab() == gdm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10 */
            /* JADX WARN: Type inference failed for: r0v12 */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r1v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iA = (b.a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                boolean z2 = this.developerModeEnabled;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = (iA + r0) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r1 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GDM(channel=");
                sbU.append(this.channel);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.channelId = j;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static abstract class Guild extends ViewState {
            private final GuildChannelIconUtils channelIconType;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class DefaultTopic extends Guild {
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultTopic(GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z2, boolean z3) {
                    super(guildChannelIconUtils, z2, z3, null);
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    this.channelIconType = guildChannelIconUtils;
                    this.channel = channel;
                    this.isRightPanelOpened = z2;
                    this.isOnHomeTab = z3;
                }

                public static /* synthetic */ DefaultTopic copy$default(DefaultTopic defaultTopic, GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z2, boolean z3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guildChannelIconUtils = defaultTopic.getChannelIconType();
                    }
                    if ((i & 2) != 0) {
                        channel = defaultTopic.channel;
                    }
                    if ((i & 4) != 0) {
                        z2 = defaultTopic.getIsRightPanelOpened();
                    }
                    if ((i & 8) != 0) {
                        z3 = defaultTopic.getIsOnHomeTab();
                    }
                    return defaultTopic.copy(guildChannelIconUtils, channel, z2, z3);
                }

                public final GuildChannelIconUtils component1() {
                    return getChannelIconType();
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final boolean component3() {
                    return getIsRightPanelOpened();
                }

                public final boolean component4() {
                    return getIsOnHomeTab();
                }

                public final DefaultTopic copy(GuildChannelIconUtils channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    return new DefaultTopic(channelIconType, channel, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof DefaultTopic)) {
                        return false;
                    }
                    DefaultTopic defaultTopic = (DefaultTopic) other;
                    return Intrinsics3.areEqual(getChannelIconType(), defaultTopic.getChannelIconType()) && Intrinsics3.areEqual(this.channel, defaultTopic.channel) && getIsRightPanelOpened() == defaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == defaultTopic.getIsOnHomeTab();
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild
                public GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v6, types: [int] */
                /* JADX WARN: Type inference failed for: r0v8, types: [int] */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v1 */
                /* JADX WARN: Type inference failed for: r2v2, types: [int] */
                /* JADX WARN: Type inference failed for: r2v3 */
                public int hashCode() {
                    GuildChannelIconUtils channelIconType = getChannelIconType();
                    int iHashCode = (channelIconType != null ? channelIconType.hashCode() : 0) * 31;
                    Channel channel = this.channel;
                    int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r1 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r1 = 1;
                    }
                    int i = (iHashCode2 + r1) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("DefaultTopic(channelIconType=");
                    sbU.append(getChannelIconType());
                    sbU.append(", channel=");
                    sbU.append(this.channel);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class Topic extends Guild {
                private final boolean allowAnimatedEmojis;
                private final List<Node<MessageRenderContext>> ast;
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final Map<Long, String> channelNames;
                private final boolean isLinkifyConflicting;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;
                private final String rawTopicString;
                private final Map<Long, GuildRole> roles;
                private final Map<Long, String> userNames;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Topic(String str, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, boolean z2, List<Node<MessageRenderContext>> list, boolean z3, GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z4, boolean z5) {
                    super(guildChannelIconUtils, z4, z5, null);
                    Intrinsics3.checkNotNullParameter(str, "rawTopicString");
                    Intrinsics3.checkNotNullParameter(map, "channelNames");
                    Intrinsics3.checkNotNullParameter(map2, "userNames");
                    Intrinsics3.checkNotNullParameter(map3, "roles");
                    Intrinsics3.checkNotNullParameter(list, "ast");
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    this.rawTopicString = str;
                    this.channelNames = map;
                    this.userNames = map2;
                    this.roles = map3;
                    this.allowAnimatedEmojis = z2;
                    this.ast = list;
                    this.isLinkifyConflicting = z3;
                    this.channelIconType = guildChannelIconUtils;
                    this.channel = channel;
                    this.isRightPanelOpened = z4;
                    this.isOnHomeTab = z5;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Topic copy$default(Topic topic, String str, Map map, Map map2, Map map3, boolean z2, List list, boolean z3, GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z4, boolean z5, int i, Object obj) {
                    return topic.copy((i & 1) != 0 ? topic.rawTopicString : str, (i & 2) != 0 ? topic.channelNames : map, (i & 4) != 0 ? topic.userNames : map2, (i & 8) != 0 ? topic.roles : map3, (i & 16) != 0 ? topic.allowAnimatedEmojis : z2, (i & 32) != 0 ? topic.ast : list, (i & 64) != 0 ? topic.isLinkifyConflicting : z3, (i & 128) != 0 ? topic.getChannelIconType() : guildChannelIconUtils, (i & 256) != 0 ? topic.channel : channel, (i & 512) != 0 ? topic.getIsRightPanelOpened() : z4, (i & 1024) != 0 ? topic.getIsOnHomeTab() : z5);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getRawTopicString() {
                    return this.rawTopicString;
                }

                public final boolean component10() {
                    return getIsRightPanelOpened();
                }

                public final boolean component11() {
                    return getIsOnHomeTab();
                }

                public final Map<Long, String> component2() {
                    return this.channelNames;
                }

                public final Map<Long, String> component3() {
                    return this.userNames;
                }

                public final Map<Long, GuildRole> component4() {
                    return this.roles;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final List<Node<MessageRenderContext>> component6() {
                    return this.ast;
                }

                /* JADX INFO: renamed from: component7, reason: from getter */
                public final boolean getIsLinkifyConflicting() {
                    return this.isLinkifyConflicting;
                }

                public final GuildChannelIconUtils component8() {
                    return getChannelIconType();
                }

                /* JADX INFO: renamed from: component9, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final Topic copy(String rawTopicString, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, List<Node<MessageRenderContext>> ast, boolean isLinkifyConflicting, GuildChannelIconUtils channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(rawTopicString, "rawTopicString");
                    Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                    Intrinsics3.checkNotNullParameter(userNames, "userNames");
                    Intrinsics3.checkNotNullParameter(roles, "roles");
                    Intrinsics3.checkNotNullParameter(ast, "ast");
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    return new Topic(rawTopicString, channelNames, userNames, roles, allowAnimatedEmojis, ast, isLinkifyConflicting, channelIconType, channel, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Topic)) {
                        return false;
                    }
                    Topic topic = (Topic) other;
                    return Intrinsics3.areEqual(this.rawTopicString, topic.rawTopicString) && Intrinsics3.areEqual(this.channelNames, topic.channelNames) && Intrinsics3.areEqual(this.userNames, topic.userNames) && Intrinsics3.areEqual(this.roles, topic.roles) && this.allowAnimatedEmojis == topic.allowAnimatedEmojis && Intrinsics3.areEqual(this.ast, topic.ast) && this.isLinkifyConflicting == topic.isLinkifyConflicting && Intrinsics3.areEqual(getChannelIconType(), topic.getChannelIconType()) && Intrinsics3.areEqual(this.channel, topic.channel) && getIsRightPanelOpened() == topic.getIsRightPanelOpened() && getIsOnHomeTab() == topic.getIsOnHomeTab();
                }

                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final List<Node<MessageRenderContext>> getAst() {
                    return this.ast;
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild
                public GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, String> getChannelNames() {
                    return this.channelNames;
                }

                public final String getRawTopicString() {
                    return this.rawTopicString;
                }

                public final Map<Long, GuildRole> getRoles() {
                    return this.roles;
                }

                public final Map<Long, String> getUserNames() {
                    return this.userNames;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v20, types: [int] */
                /* JADX WARN: Type inference failed for: r0v22, types: [int] */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v10, types: [int] */
                /* JADX WARN: Type inference failed for: r2v15, types: [int] */
                /* JADX WARN: Type inference failed for: r2v21 */
                /* JADX WARN: Type inference failed for: r2v23 */
                /* JADX WARN: Type inference failed for: r2v27 */
                /* JADX WARN: Type inference failed for: r2v28 */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v1, types: [int] */
                /* JADX WARN: Type inference failed for: r3v2 */
                public int hashCode() {
                    String str = this.rawTopicString;
                    int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                    Map<Long, String> map = this.channelNames;
                    int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                    Map<Long, String> map2 = this.userNames;
                    int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                    Map<Long, GuildRole> map3 = this.roles;
                    int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                    boolean z2 = this.allowAnimatedEmojis;
                    ?? r2 = z2;
                    if (z2) {
                        r2 = 1;
                    }
                    int i = (iHashCode4 + r2) * 31;
                    List<Node<MessageRenderContext>> list = this.ast;
                    int iHashCode5 = (i + (list != null ? list.hashCode() : 0)) * 31;
                    boolean z3 = this.isLinkifyConflicting;
                    ?? r3 = z3;
                    if (z3) {
                        r3 = 1;
                    }
                    int i2 = (iHashCode5 + r3) * 31;
                    GuildChannelIconUtils channelIconType = getChannelIconType();
                    int iHashCode6 = (i2 + (channelIconType != null ? channelIconType.hashCode() : 0)) * 31;
                    Channel channel = this.channel;
                    int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r1 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r1 = 1;
                    }
                    int i3 = (iHashCode7 + r1) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                public final boolean isLinkifyConflicting() {
                    return this.isLinkifyConflicting;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Topic(rawTopicString=");
                    sbU.append(this.rawTopicString);
                    sbU.append(", channelNames=");
                    sbU.append(this.channelNames);
                    sbU.append(", userNames=");
                    sbU.append(this.userNames);
                    sbU.append(", roles=");
                    sbU.append(this.roles);
                    sbU.append(", allowAnimatedEmojis=");
                    sbU.append(this.allowAnimatedEmojis);
                    sbU.append(", ast=");
                    sbU.append(this.ast);
                    sbU.append(", isLinkifyConflicting=");
                    sbU.append(this.isLinkifyConflicting);
                    sbU.append(", channelIconType=");
                    sbU.append(getChannelIconType());
                    sbU.append(", channel=");
                    sbU.append(this.channel);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            public /* synthetic */ Guild(GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
                this(guildChannelIconUtils, z2, z3);
            }

            public GuildChannelIconUtils getChannelIconType() {
                return this.channelIconType;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            private Guild(GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3) {
                super(z2, z3, null);
                this.channelIconType = guildChannelIconUtils;
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class NoChannel extends ViewState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NoChannel(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NoChannel copy$default(NoChannel noChannel, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = noChannel.getIsRightPanelOpened();
                }
                if ((i & 2) != 0) {
                    z3 = noChannel.getIsOnHomeTab();
                }
                return noChannel.copy(z2, z3);
            }

            public final boolean component1() {
                return getIsRightPanelOpened();
            }

            public final boolean component2() {
                return getIsOnHomeTab();
            }

            public final NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NoChannel(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoChannel)) {
                    return false;
                }
                NoChannel noChannel = (NoChannel) other;
                return getIsRightPanelOpened() == noChannel.getIsRightPanelOpened() && getIsOnHomeTab() == noChannel.getIsOnHomeTab();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r0 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NoChannel(isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState(boolean z2, boolean z3) {
            this.isRightPanelOpened = z2;
            this.isOnHomeTab = z3;
        }

        /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
        public boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
        public boolean getIsRightPanelOpened() {
            return this.isRightPanelOpened;
        }

        public /* synthetic */ ViewState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelTopicViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelTopicViewModel(Observable observable, Parser parser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            observable = Companion.observeNavState$default(INSTANCE, null, null, 3, null).Y(new Func1<Companion.NavState, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.WidgetChannelTopicViewModel.1
                @Override // j0.k.Func1
                public final Observable<? extends StoreState> call(Companion.NavState navState) {
                    if (navState.isRightPanelOpened()) {
                        Companion companion = WidgetChannelTopicViewModel.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(navState, "navState");
                        return Companion.observeStoreState$default(companion, navState, null, null, null, null, null, 62, null);
                    }
                    Companion companion2 = WidgetChannelTopicViewModel.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(navState, "navState");
                    return Companion.observeStoreState$default(companion2, navState, null, null, null, null, null, 62, null).Z(1);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observable, "observeNavState().switch…avState\n    ).take(1)\n  }");
        }
        this(observable, (i & 2) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser);
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawTopicString) {
        return Parser.parse$default(this.topicParser, rawTopicString, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    private final void handleGuildStoreState(StoreState.Guild storeState) {
        String username;
        if (storeState instanceof StoreState.Guild.DefaultTopic) {
            StoreState.Guild.DefaultTopic defaultTopic = (StoreState.Guild.DefaultTopic) storeState;
            updateViewState(new ViewState.Guild.DefaultTopic(defaultTopic.getChannelIconType(), defaultTopic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
            return;
        }
        if (!(storeState instanceof StoreState.Guild.Topic)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreState.Guild.Topic topic = (StoreState.Guild.Topic) storeState;
        String topic2 = topic.getChannel().getTopic();
        List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic2 != null ? topic2 : "");
        MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
        messagePreprocessor.process(listGenerateAST);
        Map<Long, User> users = topic.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(users.size()));
        Iterator<T> it = users.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            long jLongValue = ((Number) entry.getKey()).longValue();
            User user = (User) entry.getValue();
            GuildMember guildMember = topic.getMembers().get(Long.valueOf(jLongValue));
            if (guildMember == null || (username = guildMember.getNick()) == null) {
                username = user.getUsername();
            }
            linkedHashMap.put(key, username);
        }
        String str = topic2 != null ? topic2 : "";
        Map<Long, Channel> channels = topic.getChannels();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(channels.size()));
        Iterator<T> it2 = channels.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), ChannelUtils.c((Channel) entry2.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            if (((String) entry3.getValue()).length() > 0) {
                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        updateViewState(new ViewState.Guild.Topic(str, linkedHashMap3, linkedHashMap, topic.getRoles(), topic.getAllowAnimatedEmojis(), listGenerateAST, messagePreprocessor.isLinkifyConflicting(), topic.getChannelIconType(), topic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    private final void handlePrivateStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.DM)) {
            if (storeState instanceof StoreState.GDM) {
                StoreState.GDM gdm = (StoreState.GDM) storeState;
                updateViewState(new ViewState.GDM(gdm.getChannel(), gdm.getChannel().getId(), gdm.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
                return;
            }
            return;
        }
        StoreState.DM dm = (StoreState.DM) storeState;
        User userA = ChannelUtils.a(dm.getChannel());
        String nickOrUsername$default = userA != null ? GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, userA, null, dm.getChannel(), null, 8, null) : null;
        User userA2 = ChannelUtils.a(dm.getChannel());
        Long lValueOf = userA2 != null ? Long.valueOf(userA2.getId()) : null;
        long id2 = dm.getChannel().getId();
        Collection<Map<Long, GuildMember>> guildMembers = dm.getGuildMembers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildMembers.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            User userA3 = ChannelUtils.a(dm.getChannel());
            GuildMember guildMember = (GuildMember) map.get(userA3 != null ? Long.valueOf(userA3.getId()) : null);
            String nick = guildMember != null ? guildMember.getNick() : null;
            if (nick != null) {
                arrayList.add(nick);
            }
        }
        Set set = _Collections.toSet(arrayList);
        Collection<Map<Long, GuildMember>> guildMembers2 = dm.getGuildMembers();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = guildMembers2.iterator();
        while (it2.hasNext()) {
            Map map2 = (Map) it2.next();
            User userA4 = ChannelUtils.a(dm.getChannel());
            GuildMember guildMember2 = (GuildMember) map2.get(userA4 != null ? Long.valueOf(userA4.getId()) : null);
            if (guildMember2 != null) {
                arrayList2.add(guildMember2);
            }
        }
        updateViewState(new ViewState.DM(nickOrUsername$default, lValueOf, set, _Collections.toList(arrayList2), id2, dm.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Long lValueOf;
        if (storeState instanceof StoreState.Guild.Topic) {
            long id2 = ((StoreState.Guild.Topic) storeState).getChannel().getId();
            Long l = this.previousChannelId;
            this.revealedIndices = (l != null && id2 == l.longValue()) ? this.revealedIndices : Sets5.emptySet();
            lValueOf = Long.valueOf(id2);
        } else if (storeState instanceof StoreState.Guild.DefaultTopic) {
            lValueOf = Long.valueOf(((StoreState.Guild.DefaultTopic) storeState).getChannel().getId());
        } else if (storeState instanceof StoreState.DM) {
            lValueOf = Long.valueOf(((StoreState.DM) storeState).getChannel().getId());
        } else {
            lValueOf = storeState instanceof StoreState.GDM ? Long.valueOf(((StoreState.GDM) storeState).getChannel().getId()) : null;
        }
        this.previousChannelId = lValueOf;
        if (storeState.getIsRightPanelOpened() != this.wasRightPanelOpened || storeState.getIsOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.getIsRightPanelOpened() && storeState.getIsOnHomeTab()) {
                this.eventSubject.k.onNext(Event.FocusFirstElement.INSTANCE);
            }
            this.wasRightPanelOpened = storeState.getIsRightPanelOpened();
            this.wasOnHomeTab = storeState.getIsOnHomeTab();
        }
        if (storeState instanceof StoreState.NoChannel) {
            updateViewState(new ViewState.NoChannel(storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
        } else if (storeState instanceof StoreState.Guild) {
            handleGuildStoreState((StoreState.Guild) storeState);
        } else {
            handlePrivateStoreState(storeState);
        }
    }

    public final Unit handleClosePrivateChannel(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Long l = this.previousChannelId;
        if (l == null) {
            return null;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(l.longValue()), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : context, "javaClass", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new WidgetChannelTopicViewModel8(this, context), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
        return Unit.a;
    }

    @MainThread
    public final void handleOnIndexClicked(SpoilerNode<?> spoilerNode) {
        Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Guild.Topic)) {
            viewState = null;
        }
        ViewState.Guild.Topic topic = (ViewState.Guild.Topic) viewState;
        if (topic != null) {
            List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic.getRawTopicString());
            this.revealedIndices = _Sets.plus(this.revealedIndices, Integer.valueOf(spoilerNode.getId()));
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
            messagePreprocessor.process(listGenerateAST);
            updateViewState(ViewState.Guild.Topic.copy$default(topic, null, null, null, null, false, listGenerateAST, messagePreprocessor.isLinkifyConflicting(), null, null, false, false, 1951, null));
        }
    }

    public final Observable<Event> listenForEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel(Observable<StoreState> observable, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser) {
        super(new ViewState.NoChannel(false, false));
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(parser, "topicParser");
        this.topicParser = parser;
        this.revealedIndices = Sets5.emptySet();
        this.previousChannelId = 0L;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetChannelTopicViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
