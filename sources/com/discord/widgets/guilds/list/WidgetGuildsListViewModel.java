package com.discord.widgets.guilds.list;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.tabs.NavigationTab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func9;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private WidgetGuildListAdapter.Operation.TargetOperation currentTargetOperation;
    private final PublishSubject<Event> eventSubject;
    private boolean wasLeftPanelOpened;
    private boolean wasOnHomeTab;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$1 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87531 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C87531() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetGuildsListViewModel widgetGuildsListViewModel = WidgetGuildsListViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetGuildsListViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final /* data */ class Chunk {
            private final Map<Long, List<Long>> channelIds;
            private final Map<Long, ModelNotificationSettings> guildSettings;
            private final Map<Long, Integer> mentionCounts;
            private final Map<Long, Channel> privateChannels;
            private final long selectedGuildId;
            private final long selectedVoiceChannelId;
            private final List<StoreGuildsSorted.Entry> sortedGuilds;
            private final Set<Long> unavailableGuilds;
            private final Set<Long> unreadGuildIds;

            /* JADX WARN: Multi-variable type inference failed */
            public Chunk(long j, long j2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted.Entry> list) {
                C12238m.checkNotNullParameter(map, "guildSettings");
                C12238m.checkNotNullParameter(set, "unreadGuildIds");
                C12238m.checkNotNullParameter(map2, "mentionCounts");
                C12238m.checkNotNullParameter(map3, "channelIds");
                C12238m.checkNotNullParameter(set2, "unavailableGuilds");
                C12238m.checkNotNullParameter(map4, "privateChannels");
                C12238m.checkNotNullParameter(list, "sortedGuilds");
                this.selectedGuildId = j;
                this.selectedVoiceChannelId = j2;
                this.guildSettings = map;
                this.unreadGuildIds = set;
                this.mentionCounts = map2;
                this.channelIds = map3;
                this.unavailableGuilds = set2;
                this.privateChannels = map4;
                this.sortedGuilds = list;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getSelectedVoiceChannelId() {
                return this.selectedVoiceChannelId;
            }

            public final Map<Long, ModelNotificationSettings> component3() {
                return this.guildSettings;
            }

            public final Set<Long> component4() {
                return this.unreadGuildIds;
            }

            public final Map<Long, Integer> component5() {
                return this.mentionCounts;
            }

            public final Map<Long, List<Long>> component6() {
                return this.channelIds;
            }

            public final Set<Long> component7() {
                return this.unavailableGuilds;
            }

            public final Map<Long, Channel> component8() {
                return this.privateChannels;
            }

            public final List<StoreGuildsSorted.Entry> component9() {
                return this.sortedGuilds;
            }

            public final Chunk copy(long selectedGuildId, long selectedVoiceChannelId, Map<Long, ? extends ModelNotificationSettings> guildSettings, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, ? extends List<Long>> channelIds, Set<Long> unavailableGuilds, Map<Long, Channel> privateChannels, List<? extends StoreGuildsSorted.Entry> sortedGuilds) {
                C12238m.checkNotNullParameter(guildSettings, "guildSettings");
                C12238m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
                C12238m.checkNotNullParameter(mentionCounts, "mentionCounts");
                C12238m.checkNotNullParameter(channelIds, "channelIds");
                C12238m.checkNotNullParameter(unavailableGuilds, "unavailableGuilds");
                C12238m.checkNotNullParameter(privateChannels, "privateChannels");
                C12238m.checkNotNullParameter(sortedGuilds, "sortedGuilds");
                return new Chunk(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chunk)) {
                    return false;
                }
                Chunk chunk = (Chunk) other;
                return this.selectedGuildId == chunk.selectedGuildId && this.selectedVoiceChannelId == chunk.selectedVoiceChannelId && C12238m.areEqual(this.guildSettings, chunk.guildSettings) && C12238m.areEqual(this.unreadGuildIds, chunk.unreadGuildIds) && C12238m.areEqual(this.mentionCounts, chunk.mentionCounts) && C12238m.areEqual(this.channelIds, chunk.channelIds) && C12238m.areEqual(this.unavailableGuilds, chunk.unavailableGuilds) && C12238m.areEqual(this.privateChannels, chunk.privateChannels) && C12238m.areEqual(this.sortedGuilds, chunk.sortedGuilds);
            }

            public final Map<Long, List<Long>> getChannelIds() {
                return this.channelIds;
            }

            public final Map<Long, ModelNotificationSettings> getGuildSettings() {
                return this.guildSettings;
            }

            public final Map<Long, Integer> getMentionCounts() {
                return this.mentionCounts;
            }

            public final Map<Long, Channel> getPrivateChannels() {
                return this.privateChannels;
            }

            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            public final long getSelectedVoiceChannelId() {
                return this.selectedVoiceChannelId;
            }

            public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
                return this.sortedGuilds;
            }

            public final Set<Long> getUnavailableGuilds() {
                return this.unavailableGuilds;
            }

            public final Set<Long> getUnreadGuildIds() {
                return this.unreadGuildIds;
            }

            public int hashCode() {
                int iM3a = (C0002b.m3a(this.selectedVoiceChannelId) + (C0002b.m3a(this.selectedGuildId) * 31)) * 31;
                Map<Long, ModelNotificationSettings> map = this.guildSettings;
                int iHashCode = (iM3a + (map != null ? map.hashCode() : 0)) * 31;
                Set<Long> set = this.unreadGuildIds;
                int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
                Map<Long, Integer> map2 = this.mentionCounts;
                int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, List<Long>> map3 = this.channelIds;
                int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Set<Long> set2 = this.unavailableGuilds;
                int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Map<Long, Channel> map4 = this.privateChannels;
                int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
                return iHashCode6 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Chunk(selectedGuildId=");
                sbM833U.append(this.selectedGuildId);
                sbM833U.append(", selectedVoiceChannelId=");
                sbM833U.append(this.selectedVoiceChannelId);
                sbM833U.append(", guildSettings=");
                sbM833U.append(this.guildSettings);
                sbM833U.append(", unreadGuildIds=");
                sbM833U.append(this.unreadGuildIds);
                sbM833U.append(", mentionCounts=");
                sbM833U.append(this.mentionCounts);
                sbM833U.append(", channelIds=");
                sbM833U.append(this.channelIds);
                sbM833U.append(", unavailableGuilds=");
                sbM833U.append(this.unavailableGuilds);
                sbM833U.append(", privateChannels=");
                sbM833U.append(this.privateChannels);
                sbM833U.append(", sortedGuilds=");
                return C1643a.m824L(sbM833U, this.sortedGuilds, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final /* data */ class SecondChunk {
            private final Map<Long, Channel> channels;
            private final Set<Long> guildIds;
            private final Set<Long> guildIdsWithActiveScheduledEvents;
            private final Set<Long> guildIdsWithActiveStageEvents;
            private final Map<Long, GuildJoinRequest> guildJoinRequests;
            private final List<Guild> pendingGuilds;
            private final boolean showHubSparkle;

            public SecondChunk(Map<Long, GuildJoinRequest> map, List<Guild> list, Set<Long> set, Set<Long> set2, Set<Long> set3, Map<Long, Channel> map2, boolean z2) {
                C12238m.checkNotNullParameter(map, "guildJoinRequests");
                C12238m.checkNotNullParameter(list, "pendingGuilds");
                C12238m.checkNotNullParameter(set, "guildIds");
                C12238m.checkNotNullParameter(set2, "guildIdsWithActiveStageEvents");
                C12238m.checkNotNullParameter(set3, "guildIdsWithActiveScheduledEvents");
                C12238m.checkNotNullParameter(map2, "channels");
                this.guildJoinRequests = map;
                this.pendingGuilds = list;
                this.guildIds = set;
                this.guildIdsWithActiveStageEvents = set2;
                this.guildIdsWithActiveScheduledEvents = set3;
                this.channels = map2;
                this.showHubSparkle = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SecondChunk copy$default(SecondChunk secondChunk, Map map, List list, Set set, Set set2, Set set3, Map map2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = secondChunk.guildJoinRequests;
                }
                if ((i & 2) != 0) {
                    list = secondChunk.pendingGuilds;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    set = secondChunk.guildIds;
                }
                Set set4 = set;
                if ((i & 8) != 0) {
                    set2 = secondChunk.guildIdsWithActiveStageEvents;
                }
                Set set5 = set2;
                if ((i & 16) != 0) {
                    set3 = secondChunk.guildIdsWithActiveScheduledEvents;
                }
                Set set6 = set3;
                if ((i & 32) != 0) {
                    map2 = secondChunk.channels;
                }
                Map map3 = map2;
                if ((i & 64) != 0) {
                    z2 = secondChunk.showHubSparkle;
                }
                return secondChunk.copy(map, list2, set4, set5, set6, map3, z2);
            }

            public final Map<Long, GuildJoinRequest> component1() {
                return this.guildJoinRequests;
            }

            public final List<Guild> component2() {
                return this.pendingGuilds;
            }

            public final Set<Long> component3() {
                return this.guildIds;
            }

            public final Set<Long> component4() {
                return this.guildIdsWithActiveStageEvents;
            }

            public final Set<Long> component5() {
                return this.guildIdsWithActiveScheduledEvents;
            }

            public final Map<Long, Channel> component6() {
                return this.channels;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getShowHubSparkle() {
                return this.showHubSparkle;
            }

            public final SecondChunk copy(Map<Long, GuildJoinRequest> guildJoinRequests, List<Guild> pendingGuilds, Set<Long> guildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, Channel> channels, boolean showHubSparkle) {
                C12238m.checkNotNullParameter(guildJoinRequests, "guildJoinRequests");
                C12238m.checkNotNullParameter(pendingGuilds, "pendingGuilds");
                C12238m.checkNotNullParameter(guildIds, "guildIds");
                C12238m.checkNotNullParameter(guildIdsWithActiveStageEvents, "guildIdsWithActiveStageEvents");
                C12238m.checkNotNullParameter(guildIdsWithActiveScheduledEvents, "guildIdsWithActiveScheduledEvents");
                C12238m.checkNotNullParameter(channels, "channels");
                return new SecondChunk(guildJoinRequests, pendingGuilds, guildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, showHubSparkle);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SecondChunk)) {
                    return false;
                }
                SecondChunk secondChunk = (SecondChunk) other;
                return C12238m.areEqual(this.guildJoinRequests, secondChunk.guildJoinRequests) && C12238m.areEqual(this.pendingGuilds, secondChunk.pendingGuilds) && C12238m.areEqual(this.guildIds, secondChunk.guildIds) && C12238m.areEqual(this.guildIdsWithActiveStageEvents, secondChunk.guildIdsWithActiveStageEvents) && C12238m.areEqual(this.guildIdsWithActiveScheduledEvents, secondChunk.guildIdsWithActiveScheduledEvents) && C12238m.areEqual(this.channels, secondChunk.channels) && this.showHubSparkle == secondChunk.showHubSparkle;
            }

            public final Map<Long, Channel> getChannels() {
                return this.channels;
            }

            public final Set<Long> getGuildIds() {
                return this.guildIds;
            }

            public final Set<Long> getGuildIdsWithActiveScheduledEvents() {
                return this.guildIdsWithActiveScheduledEvents;
            }

            public final Set<Long> getGuildIdsWithActiveStageEvents() {
                return this.guildIdsWithActiveStageEvents;
            }

            public final Map<Long, GuildJoinRequest> getGuildJoinRequests() {
                return this.guildJoinRequests;
            }

            public final List<Guild> getPendingGuilds() {
                return this.pendingGuilds;
            }

            public final boolean getShowHubSparkle() {
                return this.showHubSparkle;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                Map<Long, GuildJoinRequest> map = this.guildJoinRequests;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                List<Guild> list = this.pendingGuilds;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Set<Long> set = this.guildIds;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.guildIdsWithActiveStageEvents;
                int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Set<Long> set3 = this.guildIdsWithActiveScheduledEvents;
                int iHashCode5 = (iHashCode4 + (set3 != null ? set3.hashCode() : 0)) * 31;
                Map<Long, Channel> map2 = this.channels;
                int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
                boolean z2 = this.showHubSparkle;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode6 + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SecondChunk(guildJoinRequests=");
                sbM833U.append(this.guildJoinRequests);
                sbM833U.append(", pendingGuilds=");
                sbM833U.append(this.pendingGuilds);
                sbM833U.append(", guildIds=");
                sbM833U.append(this.guildIds);
                sbM833U.append(", guildIdsWithActiveStageEvents=");
                sbM833U.append(this.guildIdsWithActiveStageEvents);
                sbM833U.append(", guildIdsWithActiveScheduledEvents=");
                sbM833U.append(this.guildIdsWithActiveScheduledEvents);
                sbM833U.append(", channels=");
                sbM833U.append(this.channels);
                sbM833U.append(", showHubSparkle=");
                return C1643a.m827O(sbM833U, this.showHubSparkle, ")");
            }
        }

        private Companion() {
        }

        private final Observable<StoreState> observeStores(final Clock clock) {
            WidgetGuildsListViewModel$Companion$observeStores$1 widgetGuildsListViewModel$Companion$observeStores$1 = WidgetGuildsListViewModel$Companion$observeStores$1.INSTANCE;
            WidgetGuildsListViewModel$Companion$observeStores$2 widgetGuildsListViewModel$Companion$observeStores$2 = WidgetGuildsListViewModel$Companion$observeStores$2.INSTANCE;
            Observable<Chunk> observableInvoke = widgetGuildsListViewModel$Companion$observeStores$1.invoke();
            Observable<SecondChunk> observableInvoke2 = widgetGuildsListViewModel$Companion$observeStores$2.invoke();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableM11066c = Observable.m11066c(observableInvoke, observableInvoke2, companion.getLurking().getLurkingGuildIds(), companion.getExpandedGuildFolders().observeOpenFolderIds(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).m11112r().m11083G(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$3
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(MeUser meUser) {
                    UserUtils userUtils = UserUtils.INSTANCE;
                    C12238m.checkNotNullExpressionValue(meUser, "meUser");
                    return Boolean.valueOf(userUtils.getAgeMs(meUser, clock) < 1209600000);
                }
            }), new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForAllStreamingUsers(), companion.getPermissions().observePermissionsForAllChannels(), companion.getNavigation().observeLeftPanelState().m11083G(new InterfaceC12589b<PanelState, Boolean>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$4
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(PanelState panelState) {
                    return Boolean.valueOf(C12238m.areEqual(panelState, PanelState.C5580c.f18642a));
                }
            }), companion.getTabsNavigation().observeSelectedTab().m11083G(new InterfaceC12589b<NavigationTab, Boolean>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$5
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(NavigationTab navigationTab) {
                    return Boolean.valueOf(navigationTab == NavigationTab.HOME);
                }
            }), new Func9<Chunk, SecondChunk, Set<? extends Long>, Set<? extends Long>, Boolean, Map<Long, ? extends StreamContext>, Map<Long, ? extends Long>, Boolean, Boolean, StoreState>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$6
                @Override // p658rx.functions.Func9
                public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.StoreState call(WidgetGuildsListViewModel.Companion.Chunk chunk, WidgetGuildsListViewModel.Companion.SecondChunk secondChunk, Set<? extends Long> set, Set<? extends Long> set2, Boolean bool, Map<Long, ? extends StreamContext> map, Map<Long, ? extends Long> map2, Boolean bool2, Boolean bool3) {
                    return call2(chunk, secondChunk, (Set<Long>) set, (Set<Long>) set2, bool, (Map<Long, StreamContext>) map, (Map<Long, Long>) map2, bool2, bool3);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetGuildsListViewModel.StoreState call2(WidgetGuildsListViewModel.Companion.Chunk chunk, WidgetGuildsListViewModel.Companion.SecondChunk secondChunk, Set<Long> set, Set<Long> set2, Boolean bool, Map<Long, StreamContext> map, Map<Long, Long> map2, Boolean bool2, Boolean bool3) {
                    long selectedGuildId = chunk.getSelectedGuildId();
                    long selectedVoiceChannelId = chunk.getSelectedVoiceChannelId();
                    Map<Long, ModelNotificationSettings> guildSettings = chunk.getGuildSettings();
                    Set<Long> unreadGuildIds = chunk.getUnreadGuildIds();
                    Map<Long, Integer> mentionCounts = chunk.getMentionCounts();
                    Map<Long, List<Long>> channelIds = chunk.getChannelIds();
                    Set<Long> unavailableGuilds = chunk.getUnavailableGuilds();
                    Map<Long, Channel> privateChannels = chunk.getPrivateChannels();
                    List<StoreGuildsSorted.Entry> sortedGuilds = chunk.getSortedGuilds();
                    Map<Long, GuildJoinRequest> guildJoinRequests = secondChunk.getGuildJoinRequests();
                    List<Guild> pendingGuilds = secondChunk.getPendingGuilds();
                    Set<Long> guildIds = secondChunk.getGuildIds();
                    C12238m.checkNotNullExpressionValue(set, "lurkingGuildIds");
                    Set<Long> guildIdsWithActiveStageEvents = secondChunk.getGuildIdsWithActiveStageEvents();
                    Set<Long> guildIdsWithActiveScheduledEvents = secondChunk.getGuildIdsWithActiveScheduledEvents();
                    Map<Long, Channel> channels = secondChunk.getChannels();
                    C12238m.checkNotNullExpressionValue(set2, "openFolderIds");
                    C12238m.checkNotNullExpressionValue(bool, "isNewUser");
                    boolean zBooleanValue = bool.booleanValue();
                    C12238m.checkNotNullExpressionValue(map, "allApplicationStreamContexts");
                    C12238m.checkNotNullExpressionValue(map2, "allChannelPermissions");
                    C12238m.checkNotNullExpressionValue(bool2, "isLeftPanelOpened");
                    boolean zBooleanValue2 = bool2.booleanValue();
                    C12238m.checkNotNullExpressionValue(bool3, "isOnHomeTab");
                    return new WidgetGuildsListViewModel.StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, set, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, set2, zBooleanValue, map, map2, zBooleanValue2, bool3.booleanValue(), secondChunk.getShowHubSparkle());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11066c, "Observable.combineLatest…Sparkle\n        )\n      }");
            return ObservableExtensionsKt.leadingEdgeThrottle(observableM11066c, 100L, TimeUnit.MILLISECONDS);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final /* data */ class AnnounceFolderToggleForAccessibility extends Event {
            private final GuildListItem.FolderItem item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnnounceFolderToggleForAccessibility(GuildListItem.FolderItem folderItem) {
                super(null);
                C12238m.checkNotNullParameter(folderItem, "item");
                this.item = folderItem;
            }

            public static /* synthetic */ AnnounceFolderToggleForAccessibility copy$default(AnnounceFolderToggleForAccessibility announceFolderToggleForAccessibility, GuildListItem.FolderItem folderItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderItem = announceFolderToggleForAccessibility.item;
                }
                return announceFolderToggleForAccessibility.copy(folderItem);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildListItem.FolderItem getItem() {
                return this.item;
            }

            public final AnnounceFolderToggleForAccessibility copy(GuildListItem.FolderItem item) {
                C12238m.checkNotNullParameter(item, "item");
                return new AnnounceFolderToggleForAccessibility(item);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AnnounceFolderToggleForAccessibility) && C12238m.areEqual(this.item, ((AnnounceFolderToggleForAccessibility) other).item);
                }
                return true;
            }

            public final GuildListItem.FolderItem getItem() {
                return this.item;
            }

            public int hashCode() {
                GuildListItem.FolderItem folderItem = this.item;
                if (folderItem != null) {
                    return folderItem.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("AnnounceFolderToggleForAccessibility(item=");
                sbM833U.append(this.item);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final class FocusFirstElement extends Event {
            public static final FocusFirstElement INSTANCE = new FocusFirstElement();

            private FocusFirstElement() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final /* data */ class ShowChannelActions extends Event {
            private final long channelId;

            public ShowChannelActions(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ ShowChannelActions copy$default(ShowChannelActions showChannelActions, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showChannelActions.channelId;
                }
                return showChannelActions.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final ShowChannelActions copy(long channelId) {
                return new ShowChannelActions(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowChannelActions) && this.channelId == ((ShowChannelActions) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return C0002b.m3a(this.channelId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("ShowChannelActions(channelId="), this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final class ShowCreateGuild extends Event {
            public static final ShowCreateGuild INSTANCE = new ShowCreateGuild();

            private ShowCreateGuild() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final class ShowHelp extends Event {
            public static final ShowHelp INSTANCE = new ShowHelp();

            private ShowHelp() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final class ShowHubVerification extends Event {
            public static final ShowHubVerification INSTANCE = new ShowHubVerification();

            private ShowHubVerification() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final /* data */ class ShowUnavailableGuilds extends Event {
            private final int unavailableGuildCount;

            public ShowUnavailableGuilds(int i) {
                super(null);
                this.unavailableGuildCount = i;
            }

            public static /* synthetic */ ShowUnavailableGuilds copy$default(ShowUnavailableGuilds showUnavailableGuilds, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showUnavailableGuilds.unavailableGuildCount;
                }
                return showUnavailableGuilds.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getUnavailableGuildCount() {
                return this.unavailableGuildCount;
            }

            public final ShowUnavailableGuilds copy(int unavailableGuildCount) {
                return new ShowUnavailableGuilds(unavailableGuildCount);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowUnavailableGuilds) && this.unavailableGuildCount == ((ShowUnavailableGuilds) other).unavailableGuildCount;
                }
                return true;
            }

            public final int getUnavailableGuildCount() {
                return this.unavailableGuildCount;
            }

            public int hashCode() {
                return this.unavailableGuildCount;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ShowUnavailableGuilds(unavailableGuildCount="), this.unavailableGuildCount, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, StreamContext> allApplicationStreamContexts;
        private final Map<Long, Long> allChannelPermissions;
        private final Map<Long, List<Long>> channelIds;
        private final Map<Long, Channel> channels;
        private final Set<Long> guildIds;
        private final Set<Long> guildIdsWithActiveScheduledEvents;
        private final Set<Long> guildIdsWithActiveStageEvents;
        private final Map<Long, GuildJoinRequest> guildJoinRequests;
        private final Map<Long, ModelNotificationSettings> guildSettings;
        private final boolean isLeftPanelOpened;
        private final boolean isNewUser;
        private final boolean isOnHomeTab;
        private final Set<Long> lurkingGuildIds;
        private final Map<Long, Integer> mentionCounts;
        private final Set<Long> openFolderIds;
        private final List<Guild> pendingGuilds;
        private final Map<Long, Channel> privateChannels;
        private final long selectedGuildId;
        private final long selectedVoiceChannelId;
        private final boolean showHubSparkle;
        private final List<StoreGuildsSorted.Entry> sortedGuilds;
        private final Set<Long> unavailableGuilds;
        private final Set<Long> unreadGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(long j, long j2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted.Entry> list, Map<Long, GuildJoinRequest> map5, List<Guild> list2, Set<Long> set3, Set<Long> set4, Set<Long> set5, Set<Long> set6, Map<Long, Channel> map6, Set<Long> set7, boolean z2, Map<Long, StreamContext> map7, Map<Long, Long> map8, boolean z3, boolean z4, boolean z5) {
            C12238m.checkNotNullParameter(map, "guildSettings");
            C12238m.checkNotNullParameter(set, "unreadGuildIds");
            C12238m.checkNotNullParameter(map2, "mentionCounts");
            C12238m.checkNotNullParameter(map3, "channelIds");
            C12238m.checkNotNullParameter(set2, "unavailableGuilds");
            C12238m.checkNotNullParameter(map4, "privateChannels");
            C12238m.checkNotNullParameter(list, "sortedGuilds");
            C12238m.checkNotNullParameter(map5, "guildJoinRequests");
            C12238m.checkNotNullParameter(list2, "pendingGuilds");
            C12238m.checkNotNullParameter(set3, "guildIds");
            C12238m.checkNotNullParameter(set4, "lurkingGuildIds");
            C12238m.checkNotNullParameter(set5, "guildIdsWithActiveStageEvents");
            C12238m.checkNotNullParameter(set6, "guildIdsWithActiveScheduledEvents");
            C12238m.checkNotNullParameter(map6, "channels");
            C12238m.checkNotNullParameter(set7, "openFolderIds");
            C12238m.checkNotNullParameter(map7, "allApplicationStreamContexts");
            C12238m.checkNotNullParameter(map8, "allChannelPermissions");
            this.selectedGuildId = j;
            this.selectedVoiceChannelId = j2;
            this.guildSettings = map;
            this.unreadGuildIds = set;
            this.mentionCounts = map2;
            this.channelIds = map3;
            this.unavailableGuilds = set2;
            this.privateChannels = map4;
            this.sortedGuilds = list;
            this.guildJoinRequests = map5;
            this.pendingGuilds = list2;
            this.guildIds = set3;
            this.lurkingGuildIds = set4;
            this.guildIdsWithActiveStageEvents = set5;
            this.guildIdsWithActiveScheduledEvents = set6;
            this.channels = map6;
            this.openFolderIds = set7;
            this.isNewUser = z2;
            this.allApplicationStreamContexts = map7;
            this.allChannelPermissions = map8;
            this.isLeftPanelOpened = z3;
            this.isOnHomeTab = z4;
            this.showHubSparkle = z5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSelectedGuildId() {
            return this.selectedGuildId;
        }

        public final Map<Long, GuildJoinRequest> component10() {
            return this.guildJoinRequests;
        }

        public final List<Guild> component11() {
            return this.pendingGuilds;
        }

        public final Set<Long> component12() {
            return this.guildIds;
        }

        public final Set<Long> component13() {
            return this.lurkingGuildIds;
        }

        public final Set<Long> component14() {
            return this.guildIdsWithActiveStageEvents;
        }

        public final Set<Long> component15() {
            return this.guildIdsWithActiveScheduledEvents;
        }

        public final Map<Long, Channel> component16() {
            return this.channels;
        }

        public final Set<Long> component17() {
            return this.openFolderIds;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final boolean getIsNewUser() {
            return this.isNewUser;
        }

        public final Map<Long, StreamContext> component19() {
            return this.allApplicationStreamContexts;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Map<Long, Long> component20() {
            return this.allChannelPermissions;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final boolean getIsLeftPanelOpened() {
            return this.isLeftPanelOpened;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final boolean getShowHubSparkle() {
            return this.showHubSparkle;
        }

        public final Map<Long, ModelNotificationSettings> component3() {
            return this.guildSettings;
        }

        public final Set<Long> component4() {
            return this.unreadGuildIds;
        }

        public final Map<Long, Integer> component5() {
            return this.mentionCounts;
        }

        public final Map<Long, List<Long>> component6() {
            return this.channelIds;
        }

        public final Set<Long> component7() {
            return this.unavailableGuilds;
        }

        public final Map<Long, Channel> component8() {
            return this.privateChannels;
        }

        public final List<StoreGuildsSorted.Entry> component9() {
            return this.sortedGuilds;
        }

        public final StoreState copy(long selectedGuildId, long selectedVoiceChannelId, Map<Long, ? extends ModelNotificationSettings> guildSettings, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, ? extends List<Long>> channelIds, Set<Long> unavailableGuilds, Map<Long, Channel> privateChannels, List<? extends StoreGuildsSorted.Entry> sortedGuilds, Map<Long, GuildJoinRequest> guildJoinRequests, List<Guild> pendingGuilds, Set<Long> guildIds, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, Channel> channels, Set<Long> openFolderIds, boolean isNewUser, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions, boolean isLeftPanelOpened, boolean isOnHomeTab, boolean showHubSparkle) {
            C12238m.checkNotNullParameter(guildSettings, "guildSettings");
            C12238m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
            C12238m.checkNotNullParameter(mentionCounts, "mentionCounts");
            C12238m.checkNotNullParameter(channelIds, "channelIds");
            C12238m.checkNotNullParameter(unavailableGuilds, "unavailableGuilds");
            C12238m.checkNotNullParameter(privateChannels, "privateChannels");
            C12238m.checkNotNullParameter(sortedGuilds, "sortedGuilds");
            C12238m.checkNotNullParameter(guildJoinRequests, "guildJoinRequests");
            C12238m.checkNotNullParameter(pendingGuilds, "pendingGuilds");
            C12238m.checkNotNullParameter(guildIds, "guildIds");
            C12238m.checkNotNullParameter(lurkingGuildIds, "lurkingGuildIds");
            C12238m.checkNotNullParameter(guildIdsWithActiveStageEvents, "guildIdsWithActiveStageEvents");
            C12238m.checkNotNullParameter(guildIdsWithActiveScheduledEvents, "guildIdsWithActiveScheduledEvents");
            C12238m.checkNotNullParameter(channels, "channels");
            C12238m.checkNotNullParameter(openFolderIds, "openFolderIds");
            C12238m.checkNotNullParameter(allApplicationStreamContexts, "allApplicationStreamContexts");
            C12238m.checkNotNullParameter(allChannelPermissions, "allChannelPermissions");
            return new StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, openFolderIds, isNewUser, allApplicationStreamContexts, allChannelPermissions, isLeftPanelOpened, isOnHomeTab, showHubSparkle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.selectedGuildId == storeState.selectedGuildId && this.selectedVoiceChannelId == storeState.selectedVoiceChannelId && C12238m.areEqual(this.guildSettings, storeState.guildSettings) && C12238m.areEqual(this.unreadGuildIds, storeState.unreadGuildIds) && C12238m.areEqual(this.mentionCounts, storeState.mentionCounts) && C12238m.areEqual(this.channelIds, storeState.channelIds) && C12238m.areEqual(this.unavailableGuilds, storeState.unavailableGuilds) && C12238m.areEqual(this.privateChannels, storeState.privateChannels) && C12238m.areEqual(this.sortedGuilds, storeState.sortedGuilds) && C12238m.areEqual(this.guildJoinRequests, storeState.guildJoinRequests) && C12238m.areEqual(this.pendingGuilds, storeState.pendingGuilds) && C12238m.areEqual(this.guildIds, storeState.guildIds) && C12238m.areEqual(this.lurkingGuildIds, storeState.lurkingGuildIds) && C12238m.areEqual(this.guildIdsWithActiveStageEvents, storeState.guildIdsWithActiveStageEvents) && C12238m.areEqual(this.guildIdsWithActiveScheduledEvents, storeState.guildIdsWithActiveScheduledEvents) && C12238m.areEqual(this.channels, storeState.channels) && C12238m.areEqual(this.openFolderIds, storeState.openFolderIds) && this.isNewUser == storeState.isNewUser && C12238m.areEqual(this.allApplicationStreamContexts, storeState.allApplicationStreamContexts) && C12238m.areEqual(this.allChannelPermissions, storeState.allChannelPermissions) && this.isLeftPanelOpened == storeState.isLeftPanelOpened && this.isOnHomeTab == storeState.isOnHomeTab && this.showHubSparkle == storeState.showHubSparkle;
        }

        public final Map<Long, StreamContext> getAllApplicationStreamContexts() {
            return this.allApplicationStreamContexts;
        }

        public final Map<Long, Long> getAllChannelPermissions() {
            return this.allChannelPermissions;
        }

        public final Map<Long, List<Long>> getChannelIds() {
            return this.channelIds;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Set<Long> getGuildIds() {
            return this.guildIds;
        }

        public final Set<Long> getGuildIdsWithActiveScheduledEvents() {
            return this.guildIdsWithActiveScheduledEvents;
        }

        public final Set<Long> getGuildIdsWithActiveStageEvents() {
            return this.guildIdsWithActiveStageEvents;
        }

        public final Map<Long, GuildJoinRequest> getGuildJoinRequests() {
            return this.guildJoinRequests;
        }

        public final Map<Long, ModelNotificationSettings> getGuildSettings() {
            return this.guildSettings;
        }

        public final Set<Long> getLurkingGuildIds() {
            return this.lurkingGuildIds;
        }

        public final Map<Long, Integer> getMentionCounts() {
            return this.mentionCounts;
        }

        public final Set<Long> getOpenFolderIds() {
            return this.openFolderIds;
        }

        public final List<Guild> getPendingGuilds() {
            return this.pendingGuilds;
        }

        public final Map<Long, Channel> getPrivateChannels() {
            return this.privateChannels;
        }

        public final long getSelectedGuildId() {
            return this.selectedGuildId;
        }

        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final boolean getShowHubSparkle() {
            return this.showHubSparkle;
        }

        public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
            return this.sortedGuilds;
        }

        public final Set<Long> getUnavailableGuilds() {
            return this.unavailableGuilds;
        }

        public final Set<Long> getUnreadGuildIds() {
            return this.unreadGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v49, types: [int] */
        /* JADX WARN: Type inference failed for: r0v55, types: [int] */
        /* JADX WARN: Type inference failed for: r0v57, types: [int] */
        /* JADX WARN: Type inference failed for: r0v59 */
        /* JADX WARN: Type inference failed for: r0v60 */
        /* JADX WARN: Type inference failed for: r0v62 */
        /* JADX WARN: Type inference failed for: r0v78 */
        /* JADX WARN: Type inference failed for: r0v79 */
        /* JADX WARN: Type inference failed for: r0v80 */
        /* JADX WARN: Type inference failed for: r1v34, types: [int] */
        /* JADX WARN: Type inference failed for: r1v40, types: [int] */
        /* JADX WARN: Type inference failed for: r1v42, types: [int] */
        /* JADX WARN: Type inference failed for: r1v44, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            int iM3a = (C0002b.m3a(this.selectedVoiceChannelId) + (C0002b.m3a(this.selectedGuildId) * 31)) * 31;
            Map<Long, ModelNotificationSettings> map = this.guildSettings;
            int iHashCode = (iM3a + (map != null ? map.hashCode() : 0)) * 31;
            Set<Long> set = this.unreadGuildIds;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.mentionCounts;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, List<Long>> map3 = this.channelIds;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Set<Long> set2 = this.unavailableGuilds;
            int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
            Map<Long, Channel> map4 = this.privateChannels;
            int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
            List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
            int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, GuildJoinRequest> map5 = this.guildJoinRequests;
            int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
            List<Guild> list2 = this.pendingGuilds;
            int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Set<Long> set3 = this.guildIds;
            int iHashCode10 = (iHashCode9 + (set3 != null ? set3.hashCode() : 0)) * 31;
            Set<Long> set4 = this.lurkingGuildIds;
            int iHashCode11 = (iHashCode10 + (set4 != null ? set4.hashCode() : 0)) * 31;
            Set<Long> set5 = this.guildIdsWithActiveStageEvents;
            int iHashCode12 = (iHashCode11 + (set5 != null ? set5.hashCode() : 0)) * 31;
            Set<Long> set6 = this.guildIdsWithActiveScheduledEvents;
            int iHashCode13 = (iHashCode12 + (set6 != null ? set6.hashCode() : 0)) * 31;
            Map<Long, Channel> map6 = this.channels;
            int iHashCode14 = (iHashCode13 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Set<Long> set7 = this.openFolderIds;
            int iHashCode15 = (iHashCode14 + (set7 != null ? set7.hashCode() : 0)) * 31;
            boolean z2 = this.isNewUser;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iHashCode15 + r0) * 31;
            Map<Long, StreamContext> map7 = this.allApplicationStreamContexts;
            int iHashCode16 = (i + (map7 != null ? map7.hashCode() : 0)) * 31;
            Map<Long, Long> map8 = this.allChannelPermissions;
            int iHashCode17 = (iHashCode16 + (map8 != null ? map8.hashCode() : 0)) * 31;
            boolean z3 = this.isLeftPanelOpened;
            ?? r1 = z3;
            if (z3) {
                r1 = 1;
            }
            int i2 = (iHashCode17 + r1) * 31;
            boolean z4 = this.isOnHomeTab;
            ?? r2 = z4;
            if (z4) {
                r2 = 1;
            }
            int i3 = (i2 + r2) * 31;
            boolean z5 = this.showHubSparkle;
            return i3 + (z5 ? 1 : z5);
        }

        public final boolean isLeftPanelOpened() {
            return this.isLeftPanelOpened;
        }

        public final boolean isNewUser() {
            return this.isNewUser;
        }

        public final boolean isOnHomeTab() {
            return this.isOnHomeTab;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(selectedGuildId=");
            sbM833U.append(this.selectedGuildId);
            sbM833U.append(", selectedVoiceChannelId=");
            sbM833U.append(this.selectedVoiceChannelId);
            sbM833U.append(", guildSettings=");
            sbM833U.append(this.guildSettings);
            sbM833U.append(", unreadGuildIds=");
            sbM833U.append(this.unreadGuildIds);
            sbM833U.append(", mentionCounts=");
            sbM833U.append(this.mentionCounts);
            sbM833U.append(", channelIds=");
            sbM833U.append(this.channelIds);
            sbM833U.append(", unavailableGuilds=");
            sbM833U.append(this.unavailableGuilds);
            sbM833U.append(", privateChannels=");
            sbM833U.append(this.privateChannels);
            sbM833U.append(", sortedGuilds=");
            sbM833U.append(this.sortedGuilds);
            sbM833U.append(", guildJoinRequests=");
            sbM833U.append(this.guildJoinRequests);
            sbM833U.append(", pendingGuilds=");
            sbM833U.append(this.pendingGuilds);
            sbM833U.append(", guildIds=");
            sbM833U.append(this.guildIds);
            sbM833U.append(", lurkingGuildIds=");
            sbM833U.append(this.lurkingGuildIds);
            sbM833U.append(", guildIdsWithActiveStageEvents=");
            sbM833U.append(this.guildIdsWithActiveStageEvents);
            sbM833U.append(", guildIdsWithActiveScheduledEvents=");
            sbM833U.append(this.guildIdsWithActiveScheduledEvents);
            sbM833U.append(", channels=");
            sbM833U.append(this.channels);
            sbM833U.append(", openFolderIds=");
            sbM833U.append(this.openFolderIds);
            sbM833U.append(", isNewUser=");
            sbM833U.append(this.isNewUser);
            sbM833U.append(", allApplicationStreamContexts=");
            sbM833U.append(this.allApplicationStreamContexts);
            sbM833U.append(", allChannelPermissions=");
            sbM833U.append(this.allChannelPermissions);
            sbM833U.append(", isLeftPanelOpened=");
            sbM833U.append(this.isLeftPanelOpened);
            sbM833U.append(", isOnHomeTab=");
            sbM833U.append(this.isOnHomeTab);
            sbM833U.append(", showHubSparkle=");
            return C1643a.m827O(sbM833U, this.showHubSparkle, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean hasChannels;
            private final List<GuildListItem> items;
            private final boolean wasDragResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends GuildListItem> list, boolean z2, boolean z3) {
                super(null);
                C12238m.checkNotNullParameter(list, "items");
                this.items = list;
                this.hasChannels = z2;
                this.wasDragResult = z3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.items;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.hasChannels;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.wasDragResult;
                }
                return loaded.copy(list, z2, z3);
            }

            public final List<GuildListItem> component1() {
                return this.items;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getHasChannels() {
                return this.hasChannels;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getWasDragResult() {
                return this.wasDragResult;
            }

            public final Loaded copy(List<? extends GuildListItem> items, boolean hasChannels, boolean wasDragResult) {
                C12238m.checkNotNullParameter(items, "items");
                return new Loaded(items, hasChannels, wasDragResult);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.items, loaded.items) && this.hasChannels == loaded.hasChannels && this.wasDragResult == loaded.wasDragResult;
            }

            public final boolean getHasChannels() {
                return this.hasChannels;
            }

            public final List<GuildListItem> getItems() {
                return this.items;
            }

            public final boolean getWasDragResult() {
                return this.wasDragResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                List<GuildListItem> list = this.items;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                boolean z2 = this.hasChannels;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.wasDragResult;
                return i + (z3 ? 1 : z3);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(items=");
                sbM833U.append(this.items);
                sbM833U.append(", hasChannels=");
                sbM833U.append(this.hasChannels);
                sbM833U.append(", wasDragResult=");
                return C1643a.m827O(sbM833U, this.wasDragResult, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$createDirectMessageItems$1 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87561 extends AbstractC12240o implements Function1<Channel, Boolean> {
        public final /* synthetic */ ModelNotificationSettings $dmSettings;
        public final /* synthetic */ Map $mentionCounts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87561(ModelNotificationSettings modelNotificationSettings, Map map) {
            super(1);
            this.$dmSettings = modelNotificationSettings;
            this.$mentionCounts = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            ModelNotificationSettings modelNotificationSettings;
            ModelNotificationSettings.ChannelOverride channelOverride;
            C12238m.checkNotNullParameter(channel, "channel");
            return this.$mentionCounts.containsKey(Long.valueOf(channel.getId())) && ((modelNotificationSettings = this.$dmSettings) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channel.getId())) == null || !channelOverride.isMuted());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$createDirectMessageItems$2 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87572 extends AbstractC12240o implements Function1<Channel, GuildListItem.PrivateChannelItem> {
        public final /* synthetic */ Map $mentionCounts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87572(Map map) {
            super(1);
            this.$mentionCounts = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildListItem.PrivateChannelItem invoke(Channel channel) {
            C12238m.checkNotNullParameter(channel, "it");
            Integer num = (Integer) C1643a.m845d(channel, this.$mentionCounts);
            return new GuildListItem.PrivateChannelItem(channel, num != null ? num.intValue() : 0);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$2 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87592 extends AbstractC12240o implements Function1<StoreGuildsSorted.Entry, Boolean> {
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87592(StoreState storeState) {
            super(1);
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted.Entry entry) {
            return Boolean.valueOf(invoke2(entry));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(StoreGuildsSorted.Entry entry) {
            C12238m.checkNotNullParameter(entry, "it");
            return ((entry instanceof StoreGuildsSorted.Entry.SingletonGuild) && this.$storeState.getLurkingGuildIds().contains(Long.valueOf(((StoreGuildsSorted.Entry.SingletonGuild) entry).getGuild().getId()))) ? false : true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$onDrop$2 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87602 extends AbstractC12240o implements Function1<ModelUserSettings, Unit> {
        public static final C87602 INSTANCE = new C87602();

        public C87602() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            C12238m.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$onItemClicked$1 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87611 extends AbstractC12240o implements Function0<Unit> {
        public static final C87611 INSTANCE = new C87611();

        public C87611() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildsListViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetGuildsListViewModel(Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        clock = (i & 1) != 0 ? ClockFactory.get() : clock;
        this(clock, (i & 2) != 0 ? INSTANCE.observeStores(clock) : observable);
    }

    private final Sequence<GuildListItem.PrivateChannelItem> createDirectMessageItems(Map<Long, Channel> privateChannels, Map<Long, Integer> mentionCounts, ModelNotificationSettings dmSettings) {
        return C12078q.map(C12078q.sortedWith(C12078q.filter(C12078q.filterNotNull(C12163u.asSequence(privateChannels.values())), new C87561(dmSettings, mentionCounts)), ChannelUtils.m7684h(Channel.INSTANCE)), new C87572(mentionCounts));
    }

    private final GuildListItem.GuildItem createGuildItem(Guild guild, long selectedGuildId, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, ? extends ModelNotificationSettings> guildSettings, int numMentions, Map<Long, ? extends List<Long>> channelIds, Map<Long, Channel> channels, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Long folderId, Boolean isLastGuildInFolder, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions, ApplicationStatus applicationStatus, boolean isPendingGuild) {
        boolean z2;
        long id2 = guild.getId();
        List<Long> list = channelIds.get(Long.valueOf(id2));
        ModelNotificationSettings modelNotificationSettings = guildSettings.get(Long.valueOf(id2));
        boolean zContains = (modelNotificationSettings == null || !modelNotificationSettings.isMuted()) ? unreadGuildIds.contains(Long.valueOf(id2)) : false;
        boolean z3 = id2 == selectedGuildId;
        if (selectedVoiceChannelId > 0 && list != null && !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (selectedVoiceChannelId == ((Number) it.next()).longValue()) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        boolean zShouldDisplayVideoIconOnGuild = shouldDisplayVideoIconOnGuild(id2, modelNotificationSettings, allApplicationStreamContexts, allChannelPermissions);
        boolean zContains2 = lurkingGuildIds.contains(Long.valueOf(guild.getId()));
        boolean zContains3 = guildIdsWithActiveStageEvents.contains(Long.valueOf(guild.getId()));
        Channel channel = channels.get(Long.valueOf(selectedVoiceChannelId));
        return new GuildListItem.GuildItem(guild, numMentions, zContains2, zContains, z3, folderId, z2, zShouldDisplayVideoIconOnGuild, false, isLastGuildInFolder, applicationStatus, isPendingGuild, zContains3, channel != null && ChannelUtils.m7669D(channel), guildIdsWithActiveScheduledEvents.contains(Long.valueOf(guild.getId())), 256, null);
    }

    public static /* synthetic */ GuildListItem.GuildItem createGuildItem$default(WidgetGuildsListViewModel widgetGuildsListViewModel, Guild guild, long j, long j2, Set set, Map map, int i, Map map2, Map map3, Set set2, Set set3, Set set4, Long l, Boolean bool, Map map4, Map map5, ApplicationStatus applicationStatus, boolean z2, int i2, Object obj) {
        return widgetGuildsListViewModel.createGuildItem(guild, j, j2, set, map, i, map2, map3, set2, set3, set4, l, bool, map4, map5, applicationStatus, (i2 & 65536) != 0 ? false : z2);
    }

    private final List<GuildListItem> createPendingGuildsFolder(List<Guild> pendingGuilds, Map<Long, GuildJoinRequest> guildJoinRequests, Set<Long> openFolderIds, long selectedGuildId, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, ? extends List<Long>> channelIds, Map<Long, Channel> channels, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions) {
        ArrayList arrayList = new ArrayList();
        GuildListItem.FolderItem folderItem = new GuildListItem.FolderItem(-7L, null, null, openFolderIds.contains(-7L), pendingGuilds, false, false, false, 0, false, false);
        arrayList.add(folderItem);
        if (folderItem.isOpen()) {
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(pendingGuilds, 10));
            int i = 0;
            for (Object obj : pendingGuilds) {
                int i2 = i + 1;
                if (i < 0) {
                    C12147n.throwIndexOverflow();
                }
                Guild guild = (Guild) obj;
                Long lValueOf = Long.valueOf(folderItem.getFolderId());
                Boolean boolValueOf = Boolean.valueOf(C12147n.getLastIndex(pendingGuilds) == i);
                GuildJoinRequest guildJoinRequest = (GuildJoinRequest) C1643a.m847e(guild, guildJoinRequests);
                arrayList2.add(createGuildItem(guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, 0, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, lValueOf, boolValueOf, allApplicationStreamContexts, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, true));
                i = i2;
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x028d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x022b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0251  */
    /* JADX WARN: Code duplicated, block: B:67:0x0263  */
    /* JADX WARN: Code duplicated, block: B:72:0x0277  */
    /* JADX WARN: Code duplicated, block: B:76:0x028b  */
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        ArrayList arrayList;
        ArrayList arrayList2;
        Sequence sequence;
        HashMap map;
        ArrayList arrayList3;
        HashMap map2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        HashMap map3;
        ArrayList arrayList4;
        boolean z7;
        Integer num;
        ModelNotificationSettings modelNotificationSettings;
        ArrayList arrayList5 = new ArrayList(storeState.getPendingGuilds().size() + storeState.getSortedGuilds().size() + 3);
        arrayList5.add(new GuildListItem.FriendsItem(storeState.getSelectedGuildId() <= 0));
        C12160r.addAll(arrayList5, createDirectMessageItems(storeState.getPrivateChannels(), storeState.getMentionCounts(), storeState.getGuildSettings().get(0L)));
        HashMap map4 = new HashMap();
        for (StoreGuildsSorted.Entry entry : storeState.getSortedGuilds()) {
            if (entry instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                long id2 = ((StoreGuildsSorted.Entry.SingletonGuild) entry).getGuild().getId();
                map4.put(Long.valueOf(id2), Integer.valueOf(sumMentionCountsForGuild(id2, storeState.getChannelIds(), storeState.getMentionCounts())));
            } else if (entry instanceof StoreGuildsSorted.Entry.Folder) {
                Iterator<Guild> it = ((StoreGuildsSorted.Entry.Folder) entry).getGuilds().iterator();
                while (it.hasNext()) {
                    long id3 = it.next().getId();
                    map4.put(Long.valueOf(id3), Integer.valueOf(sumMentionCountsForGuild(id3, storeState.getChannelIds(), storeState.getMentionCounts())));
                }
            }
        }
        Sequence sequenceFilter = C12078q.filter(C12163u.asSequence(storeState.getSortedGuilds()), C8758x8b5dfe77.INSTANCE);
        Objects.requireNonNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        Sequence map5 = C12078q.map(C12078q.filter(sequenceFilter, new WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1(storeState)), new WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$2(this, storeState, map4));
        ArrayList arrayList6 = new ArrayList();
        for (StoreGuildsSorted.Entry entry2 : C12078q.filter(C12163u.asSequence(storeState.getSortedGuilds()), new C87592(storeState))) {
            if (entry2 instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                StoreGuildsSorted.Entry.SingletonGuild singletonGuild = (StoreGuildsSorted.Entry.SingletonGuild) entry2;
                Guild guild = singletonGuild.getGuild();
                long selectedGuildId = storeState.getSelectedGuildId();
                long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
                Set<Long> unreadGuildIds = storeState.getUnreadGuildIds();
                Map<Long, ModelNotificationSettings> guildSettings = storeState.getGuildSettings();
                Integer num2 = (Integer) map4.get(Long.valueOf(singletonGuild.getGuild().getId()));
                if (num2 == null) {
                    num2 = 0;
                }
                C12238m.checkNotNullExpressionValue(num2, "mentionCountsByGuild[folder.guild.id] ?: 0");
                int iIntValue = num2.intValue();
                Map<Long, List<Long>> channelIds = storeState.getChannelIds();
                Map<Long, Channel> channels = storeState.getChannels();
                Set<Long> lurkingGuildIds = storeState.getLurkingGuildIds();
                Set<Long> guildIdsWithActiveStageEvents = storeState.getGuildIdsWithActiveStageEvents();
                Set<Long> guildIdsWithActiveScheduledEvents = storeState.getGuildIdsWithActiveScheduledEvents();
                Map<Long, StreamContext> allApplicationStreamContexts = storeState.getAllApplicationStreamContexts();
                Map<Long, Long> allChannelPermissions = storeState.getAllChannelPermissions();
                ArrayList arrayList7 = arrayList6;
                GuildJoinRequest guildJoinRequest = storeState.getGuildJoinRequests().get(Long.valueOf(singletonGuild.getGuild().getId()));
                sequence = map5;
                map = map4;
                arrayList3 = arrayList5;
                arrayList2 = arrayList7;
                arrayList2.add(createGuildItem$default(this, guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, iIntValue, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, null, null, allApplicationStreamContexts, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, false, 65536, null));
            } else {
                arrayList2 = arrayList6;
                sequence = map5;
                map = map4;
                arrayList3 = arrayList5;
                if (entry2 instanceof StoreGuildsSorted.Entry.Folder) {
                    StoreGuildsSorted.Entry.Folder folder = (StoreGuildsSorted.Entry.Folder) entry2;
                    boolean zContains = storeState.getOpenFolderIds().contains(Long.valueOf(folder.getId()));
                    String str = "mentionCountsByGuild[guild.id] ?: 0";
                    if (zContains) {
                        map2 = map;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i = 0;
                        z6 = false;
                    } else {
                        boolean z8 = false;
                        int iIntValue2 = 0;
                        boolean z9 = false;
                        boolean z10 = false;
                        boolean z11 = false;
                        for (Guild guild2 : folder.getGuilds()) {
                            z9 = z9 || guild2.getId() == storeState.getSelectedGuildId();
                            if (z10) {
                                z10 = true;
                            } else {
                                List list = (List) C1643a.m847e(guild2, storeState.getChannelIds());
                                if (list != null ? list.contains(Long.valueOf(storeState.getSelectedVoiceChannelId())) : false) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                            }
                            if (z11) {
                                z7 = true;
                            } else {
                                Channel channel = storeState.getChannels().get(Long.valueOf(storeState.getSelectedVoiceChannelId()));
                                if (channel != null) {
                                    z7 = true;
                                    if (ChannelUtils.m7669D(channel)) {
                                    }
                                    if (!z8) {
                                        if (storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId())) || ((modelNotificationSettings = (ModelNotificationSettings) C1643a.m847e(guild2, storeState.getGuildSettings())) != null && modelNotificationSettings.isMuted() == z7)) {
                                            z8 = false;
                                        } else {
                                            z8 = true;
                                        }
                                    }
                                    HashMap map6 = map;
                                    num = (Integer) map6.get(Long.valueOf(guild2.getId()));
                                    if (num == null) {
                                        num = 0;
                                    }
                                    C12238m.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                                    iIntValue2 += num.intValue();
                                    map = map6;
                                } else {
                                    z7 = true;
                                }
                                z11 = false;
                                if (!z8) {
                                    if (storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId()))) {
                                        z8 = false;
                                    } else {
                                        z8 = false;
                                    }
                                }
                                HashMap map7 = map;
                                num = (Integer) map7.get(Long.valueOf(guild2.getId()));
                                if (num == null) {
                                    num = 0;
                                }
                                C12238m.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                                iIntValue2 += num.intValue();
                                map = map7;
                            }
                            z11 = true;
                            if (!z8) {
                                if (storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId()))) {
                                    z8 = false;
                                } else {
                                    z8 = false;
                                }
                            }
                            HashMap map8 = map;
                            num = (Integer) map8.get(Long.valueOf(guild2.getId()));
                            if (num == null) {
                                num = 0;
                            }
                            C12238m.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                            iIntValue2 += num.intValue();
                            map = map8;
                        }
                        map2 = map;
                        z6 = z8;
                        i = iIntValue2;
                        z3 = z9;
                        z4 = z10;
                        z5 = z11;
                    }
                    arrayList2.add(new GuildListItem.FolderItem(folder.getId(), folder.getColor(), folder.getName(), zContains, folder.getGuilds(), z3, z4, z5, i, z6, false, 1024, null));
                    if (zContains) {
                        List<Guild> guilds = folder.getGuilds();
                        ArrayList arrayList8 = new ArrayList(C12149o.collectionSizeOrDefault(guilds, 10));
                        int i2 = 0;
                        for (Object obj : guilds) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                C12147n.throwIndexOverflow();
                            }
                            Guild guild3 = (Guild) obj;
                            long selectedGuildId2 = storeState.getSelectedGuildId();
                            long selectedVoiceChannelId2 = storeState.getSelectedVoiceChannelId();
                            Set<Long> unreadGuildIds2 = storeState.getUnreadGuildIds();
                            Map<Long, ModelNotificationSettings> guildSettings2 = storeState.getGuildSettings();
                            Integer num3 = (Integer) map2.get(Long.valueOf(guild3.getId()));
                            if (num3 == null) {
                                num3 = 0;
                            }
                            C12238m.checkNotNullExpressionValue(num3, str);
                            int iIntValue3 = num3.intValue();
                            Map<Long, List<Long>> channelIds2 = storeState.getChannelIds();
                            Map<Long, Channel> channels2 = storeState.getChannels();
                            Set<Long> lurkingGuildIds2 = storeState.getLurkingGuildIds();
                            Set<Long> guildIdsWithActiveStageEvents2 = storeState.getGuildIdsWithActiveStageEvents();
                            Set<Long> guildIdsWithActiveScheduledEvents2 = storeState.getGuildIdsWithActiveScheduledEvents();
                            Long lValueOf = Long.valueOf(folder.getId());
                            ArrayList arrayList9 = arrayList8;
                            Boolean boolValueOf = Boolean.valueOf(C12147n.getLastIndex(folder.getGuilds()) == i2);
                            Map<Long, StreamContext> allApplicationStreamContexts2 = storeState.getAllApplicationStreamContexts();
                            Map<Long, Long> allChannelPermissions2 = storeState.getAllChannelPermissions();
                            GuildJoinRequest guildJoinRequest2 = (GuildJoinRequest) C1643a.m847e(guild3, storeState.getGuildJoinRequests());
                            arrayList9.add(createGuildItem$default(this, guild3, selectedGuildId2, selectedVoiceChannelId2, unreadGuildIds2, guildSettings2, iIntValue3, channelIds2, channels2, lurkingGuildIds2, guildIdsWithActiveStageEvents2, guildIdsWithActiveScheduledEvents2, lValueOf, boolValueOf, allApplicationStreamContexts2, allChannelPermissions2, guildJoinRequest2 != null ? guildJoinRequest2.getApplicationStatus() : null, false, 65536, null));
                            arrayList8 = arrayList9;
                            i2 = i3;
                            map2 = map2;
                            str = str;
                            arrayList2 = arrayList2;
                        }
                        map3 = map2;
                        arrayList4 = arrayList2;
                        arrayList4.addAll(arrayList8);
                    } else {
                        map3 = map2;
                        arrayList4 = arrayList2;
                    }
                }
                arrayList6 = arrayList4;
                map4 = map3;
                map5 = sequence;
                arrayList5 = arrayList3;
            }
            arrayList4 = arrayList2;
            map3 = map;
            arrayList6 = arrayList4;
            map4 = map3;
            map5 = sequence;
            arrayList5 = arrayList3;
        }
        ArrayList arrayList10 = arrayList6;
        Sequence sequence2 = map5;
        ArrayList arrayList11 = arrayList5;
        if (storeState.getOpenFolderIds().contains(-7L)) {
            StoreStream.INSTANCE.getGuildJoinRequests().fetchPendingGuilds();
        }
        Map<Long, GuildJoinRequest> guildJoinRequests = storeState.getGuildJoinRequests();
        if (guildJoinRequests.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator<Map.Entry<Long, GuildJoinRequest>> it2 = guildJoinRequests.entrySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (C12147n.emptyList().contains(it2.next().getKey())) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (z2) {
            arrayList = arrayList11;
            arrayList.addAll(createPendingGuildsFolder(storeState.getPendingGuilds(), storeState.getGuildJoinRequests(), storeState.getOpenFolderIds(), storeState.getSelectedGuildId(), storeState.getSelectedVoiceChannelId(), storeState.getUnreadGuildIds(), storeState.getGuildSettings(), storeState.getChannelIds(), storeState.getChannels(), storeState.getLurkingGuildIds(), storeState.getGuildIdsWithActiveStageEvents(), storeState.getGuildIdsWithActiveScheduledEvents(), storeState.getAllApplicationStreamContexts(), storeState.getAllChannelPermissions()));
        } else {
            arrayList = arrayList11;
        }
        C12160r.addAll(arrayList, sequence2);
        GuildListItem.DividerItem dividerItem = GuildListItem.DividerItem.INSTANCE;
        arrayList.add(dividerItem);
        arrayList.addAll(arrayList10);
        if (!storeState.getUnavailableGuilds().isEmpty()) {
            arrayList.add(new GuildListItem.UnavailableItem(storeState.getUnavailableGuilds().size()));
        }
        arrayList.add(GuildListItem.CreateItem.INSTANCE);
        GrowthTeamFeatures growthTeamFeatures = GrowthTeamFeatures.INSTANCE;
        if (growthTeamFeatures.isHubDiscoveryEnabled()) {
            arrayList.add(new GuildListItem.HubItem(storeState.getShowHubSparkle() && growthTeamFeatures.isHubDiscoverySparkleEnabled()));
        }
        if (storeState.isNewUser()) {
            arrayList.add(dividerItem);
            arrayList.add(GuildListItem.HelpItem.INSTANCE);
        }
        arrayList.add(GuildListItem.SpaceItem.INSTANCE);
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList, !storeState.getChannelIds().isEmpty(), false);
        if (storeState.isLeftPanelOpened() != this.wasLeftPanelOpened || storeState.isOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.isLeftPanelOpened() && storeState.isOnHomeTab()) {
                this.eventSubject.f27650k.onNext(Event.FocusFirstElement.INSTANCE);
            }
            this.wasLeftPanelOpened = storeState.isLeftPanelOpened();
            this.wasOnHomeTab = storeState.isOnHomeTab();
        }
        updateViewState(loaded);
    }

    private final void move(int fromPosition, int toPosition, Long folderId) {
        ArrayList<GuildListItem> arrayList;
        int i = toPosition;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            List<GuildListItem> items = loaded.getItems();
            GuildListItem guildListItem = items.get(fromPosition);
            if (this.currentTargetOperation != null || (fromPosition > i || Math.abs(fromPosition - i) >= 2) || ((guildListItem instanceof GuildListItem.GuildItem) && (C12238m.areEqual(((GuildListItem.GuildItem) guildListItem).getFolderId(), folderId) ^ true))) {
                ArrayList<GuildListItem> arrayList2 = new ArrayList<>(items);
                untargetCurrentTarget(arrayList2);
                if (fromPosition < i) {
                    i--;
                }
                int i2 = i;
                if (!(guildListItem instanceof GuildListItem.FolderItem)) {
                    if (guildListItem instanceof GuildListItem.GuildItem) {
                        arrayList2.remove(fromPosition);
                        GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem;
                        arrayList = arrayList2;
                        arrayList.add(i2, guildItem.copy((32735 & 1) != 0 ? guildItem.guild : null, (32735 & 2) != 0 ? guildItem.getMentionCount() : 0, (32735 & 4) != 0 ? guildItem.isLurkingGuild : false, (32735 & 8) != 0 ? guildItem.getIsUnread() : false, (32735 & 16) != 0 ? guildItem.isSelected : false, (32735 & 32) != 0 ? guildItem.folderId : folderId, (32735 & 64) != 0 ? guildItem.isConnectedToVoice : false, (32735 & 128) != 0 ? guildItem.hasOngoingApplicationStream : false, (32735 & 256) != 0 ? guildItem.isTargetedForFolderCreation : false, (32735 & 512) != 0 ? guildItem.isLastGuildInFolder : null, (32735 & 1024) != 0 ? guildItem.applicationStatus : null, (32735 & 2048) != 0 ? guildItem.isPendingGuild : false, (32735 & 4096) != 0 ? guildItem.hasActiveStageChannel : false, (32735 & 8192) != 0 ? guildItem.isConnectedToStageChannel : false, (32735 & 16384) != 0 ? guildItem.hasActiveScheduledEvent : false));
                        rebuildFolders(arrayList, C12163u.toSet(C12147n.listOfNotNull((Object[]) new Long[]{guildItem.getFolderId(), folderId})));
                    }
                    updateViewState(ViewState.Loaded.copy$default(loaded, arrayList, false, true, 2, null));
                }
                arrayList2.remove(fromPosition);
                arrayList2.add(i2, guildListItem);
                arrayList = arrayList2;
                updateViewState(ViewState.Loaded.copy$default(loaded, arrayList, false, true, 2, null));
            }
        }
    }

    private final void performTargetOperation(ArrayList<GuildListItem> editingList, int fromPosition, int toPosition) {
        GuildListItem guildListItem = editingList.get(fromPosition);
        C12238m.checkNotNullExpressionValue(guildListItem, "editingList[fromPosition]");
        GuildListItem guildListItem2 = guildListItem;
        GuildListItem guildListItem3 = editingList.get(toPosition);
        C12238m.checkNotNullExpressionValue(guildListItem3, "editingList[toPosition]");
        GuildListItem guildListItem4 = guildListItem3;
        boolean z2 = guildListItem2 instanceof GuildListItem.GuildItem;
        if (z2 && (guildListItem4 instanceof GuildListItem.GuildItem)) {
            GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem4;
            GuildListItem.GuildItem guildItem2 = (GuildListItem.GuildItem) guildListItem2;
            editingList.set(toPosition, new GuildListItem.FolderItem(AbstractC11216c.f22272k.nextLong(), null, null, false, C12147n.listOf((Object[]) new Guild[]{guildItem.getGuild(), guildItem2.getGuild()}), guildItem.isSelected() || guildItem2.isSelected(), guildItem.isConnectedToVoice() || guildItem2.isConnectedToVoice(), guildItem.isConnectedToStageChannel() || guildItem2.isConnectedToStageChannel(), guildItem2.getMentionCount() + guildItem.getMentionCount(), guildItem.getIsUnread() || guildItem2.getIsUnread(), false));
            C12238m.checkNotNullExpressionValue(editingList.remove(fromPosition), "editingList.removeAt(fromPosition)");
            return;
        }
        if (z2 && (guildListItem4 instanceof GuildListItem.FolderItem)) {
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem4;
            GuildListItem.GuildItem guildItem3 = (GuildListItem.GuildItem) guildListItem2;
            editingList.set(toPosition, folderItem.copy((399 & 1) != 0 ? folderItem.folderId : 0L, (399 & 2) != 0 ? folderItem.color : null, (399 & 4) != 0 ? folderItem.name : null, (399 & 8) != 0 ? folderItem.isOpen : false, (399 & 16) != 0 ? folderItem.guilds : C12163u.plus((Collection<? extends Guild>) C12163u.toMutableList((Collection) folderItem.getGuilds()), guildItem3.getGuild()), (399 & 32) != 0 ? folderItem.isAnyGuildSelected : folderItem.isAnyGuildSelected() || guildItem3.isSelected(), (399 & 64) != 0 ? folderItem.isAnyGuildConnectedToVoice : folderItem.isAnyGuildConnectedToVoice() || guildItem3.isConnectedToVoice(), (399 & 128) != 0 ? folderItem.isAnyGuildConnectedToStageChannel : false, (399 & 256) != 0 ? folderItem.getMentionCount() : 0, (399 & 512) != 0 ? folderItem.getIsUnread() : folderItem.getIsUnread() || guildItem3.getIsUnread(), (399 & 1024) != 0 ? folderItem.isTargetedForFolderAddition : false));
            editingList.remove(fromPosition);
        }
    }

    private final void rebuildFolders(ArrayList<GuildListItem> editingList, Set<Long> changedFolderIds) {
        if (changedFolderIds.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList<GuildListItem.GuildItem> arrayList = new ArrayList();
        for (Object obj : editingList) {
            if (obj instanceof GuildListItem.GuildItem) {
                arrayList.add(obj);
            }
        }
        for (GuildListItem.GuildItem guildItem : arrayList) {
            Long folderId = guildItem.getFolderId();
            if (folderId != null) {
                long jLongValue = folderId.longValue();
                ArrayList arrayList2 = (ArrayList) map.get(Long.valueOf(jLongValue));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(guildItem.getGuild());
                map.put(Long.valueOf(jLongValue), arrayList2);
            }
        }
        Iterator<T> it = changedFolderIds.iterator();
        while (it.hasNext()) {
            long jLongValue2 = ((Number) it.next()).longValue();
            Iterator<GuildListItem> it2 = editingList.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                GuildListItem next = it2.next();
                if ((next instanceof GuildListItem.FolderItem) && ((GuildListItem.FolderItem) next).getFolderId() == jLongValue2) {
                    break;
                } else {
                    i++;
                }
            }
            GuildListItem guildListItem = editingList.get(i);
            Objects.requireNonNull(guildListItem, "null cannot be cast to non-null type com.discord.widgets.guilds.list.GuildListItem.FolderItem");
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
            ArrayList arrayList3 = (ArrayList) map.get(Long.valueOf(jLongValue2));
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
            }
            editingList.set(i, folderItem.copy((399 & 1) != 0 ? folderItem.folderId : 0L, (399 & 2) != 0 ? folderItem.color : null, (399 & 4) != 0 ? folderItem.name : null, (399 & 8) != 0 ? folderItem.isOpen : false, (399 & 16) != 0 ? folderItem.guilds : arrayList3, (399 & 32) != 0 ? folderItem.isAnyGuildSelected : false, (399 & 64) != 0 ? folderItem.isAnyGuildConnectedToVoice : false, (399 & 128) != 0 ? folderItem.isAnyGuildConnectedToStageChannel : false, (399 & 256) != 0 ? folderItem.getMentionCount() : 0, (399 & 512) != 0 ? folderItem.getIsUnread() : false, (399 & 1024) != 0 ? folderItem.isTargetedForFolderAddition : false));
        }
    }

    private final boolean shouldDisplayVideoIconOnGuild(long guildId, ModelNotificationSettings guildNotificationSettings, Map<Long, StreamContext> streamContexts, Map<Long, Long> permissions) {
        if (streamContexts == null || streamContexts.isEmpty()) {
            return false;
        }
        if (guildNotificationSettings != null && guildNotificationSettings.isMuted()) {
            return false;
        }
        Collection<StreamContext> collectionValues = streamContexts.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            for (StreamContext streamContext : collectionValues) {
                Guild guild = streamContext.getGuild();
                if (guild != null && guild.getId() == guildId && PermissionUtils.can(Permission.VIEW_CHANNEL, permissions.get(Long.valueOf(streamContext.getStream().getChannelId())))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int sumMentionCountsForGuild(long guildId, Map<Long, ? extends Collection<Long>> guildChannels, Map<Long, Integer> mentionCounts) {
        Collection<Long> collection = guildChannels.get(Long.valueOf(guildId));
        if (collection == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Integer num = mentionCounts.get(Long.valueOf(((Number) it.next()).longValue()));
            arrayList.add(Integer.valueOf(num != null ? num.intValue() : 0));
        }
        return C12163u.sumOfInt(arrayList);
    }

    private final void untargetCurrentTarget(ArrayList<GuildListItem> editingList) {
        GuildListItem guildListItemCopy;
        WidgetGuildListAdapter.Operation.TargetOperation targetOperation = this.currentTargetOperation;
        if (targetOperation != null) {
            int targetPosition = targetOperation.getTargetPosition();
            GuildListItem guildListItem = editingList.get(targetPosition);
            C12238m.checkNotNullExpressionValue(guildListItem, "editingList[toPosition]");
            GuildListItem guildListItem2 = guildListItem;
            if (guildListItem2 instanceof GuildListItem.GuildItem) {
                GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem2;
                guildListItemCopy = guildItem.copy((32735 & 1) != 0 ? guildItem.guild : null, (32735 & 2) != 0 ? guildItem.getMentionCount() : 0, (32735 & 4) != 0 ? guildItem.isLurkingGuild : false, (32735 & 8) != 0 ? guildItem.getIsUnread() : false, (32735 & 16) != 0 ? guildItem.isSelected : false, (32735 & 32) != 0 ? guildItem.folderId : null, (32735 & 64) != 0 ? guildItem.isConnectedToVoice : false, (32735 & 128) != 0 ? guildItem.hasOngoingApplicationStream : false, (32735 & 256) != 0 ? guildItem.isTargetedForFolderCreation : false, (32735 & 512) != 0 ? guildItem.isLastGuildInFolder : null, (32735 & 1024) != 0 ? guildItem.applicationStatus : null, (32735 & 2048) != 0 ? guildItem.isPendingGuild : false, (32735 & 4096) != 0 ? guildItem.hasActiveStageChannel : false, (32735 & 8192) != 0 ? guildItem.isConnectedToStageChannel : false, (32735 & 16384) != 0 ? guildItem.hasActiveScheduledEvent : false);
            } else if (guildListItem2 instanceof GuildListItem.FolderItem) {
                GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem2;
                guildListItemCopy = folderItem.copy((399 & 1) != 0 ? folderItem.folderId : 0L, (399 & 2) != 0 ? folderItem.color : null, (399 & 4) != 0 ? folderItem.name : null, (399 & 8) != 0 ? folderItem.isOpen : false, (399 & 16) != 0 ? folderItem.guilds : null, (399 & 32) != 0 ? folderItem.isAnyGuildSelected : false, (399 & 64) != 0 ? folderItem.isAnyGuildConnectedToVoice : false, (399 & 128) != 0 ? folderItem.isAnyGuildConnectedToStageChannel : false, (399 & 256) != 0 ? folderItem.getMentionCount() : 0, (399 & 512) != 0 ? folderItem.getIsUnread() : false, (399 & 1024) != 0 ? folderItem.isTargetedForFolderAddition : false);
            }
            editingList.set(targetPosition, guildListItemCopy);
        }
        this.currentTargetOperation = null;
    }

    public final Observable<Event> listenForEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void moveAbove(int fromPosition, int targetPosition) {
        ViewState viewState = getViewState();
        Long folderId = null;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            GuildListItem guildListItem = loaded.getItems().get(targetPosition);
            if (guildListItem instanceof GuildListItem.GuildItem) {
                folderId = ((GuildListItem.GuildItem) guildListItem).getFolderId();
            } else if (!(guildListItem instanceof GuildListItem.FolderItem) && !(guildListItem instanceof GuildListItem.HelpItem) && !(guildListItem instanceof GuildListItem.CreateItem)) {
                throw new IllegalStateException("invalid target");
            }
            move(fromPosition, targetPosition, folderId);
        }
    }

    public final void moveBelow(int fromPosition, int targetPosition) {
        ViewState viewState = getViewState();
        Long lValueOf = null;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            GuildListItem guildListItem = loaded.getItems().get(targetPosition);
            if (guildListItem instanceof GuildListItem.GuildItem) {
                lValueOf = ((GuildListItem.GuildItem) guildListItem).getFolderId();
            } else {
                if (!(guildListItem instanceof GuildListItem.FolderItem)) {
                    throw new IllegalStateException("invalid target");
                }
                GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
                if (folderItem.isOpen()) {
                    lValueOf = Long.valueOf(folderItem.getFolderId());
                }
            }
            move(fromPosition, targetPosition + 1, lValueOf);
        }
    }

    public final boolean onDrop() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            return false;
        }
        List<GuildListItem> items = loaded.getItems();
        ArrayList arrayList = new ArrayList();
        WidgetGuildListAdapter.Operation.TargetOperation targetOperation = this.currentTargetOperation;
        if (targetOperation != null) {
            ArrayList<GuildListItem> arrayList2 = new ArrayList<>(items);
            untargetCurrentTarget(arrayList2);
            performTargetOperation(arrayList2, targetOperation.getFromPosition(), targetOperation.getTargetPosition());
            items = arrayList2;
        }
        for (GuildListItem guildListItem : items) {
            if (guildListItem instanceof GuildListItem.FolderItem) {
                GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
                arrayList.add(new StoreGuildsSorted.Entry.Folder(folderItem.getFolderId(), folderItem.getGuilds(), folderItem.getColor(), folderItem.getName()));
            } else if (guildListItem instanceof GuildListItem.GuildItem) {
                GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem;
                if (guildItem.getFolderId() == null) {
                    arrayList.add(new StoreGuildsSorted.Entry.SingletonGuild(guildItem.getGuild()));
                }
            }
        }
        StoreStream.INSTANCE.getGuildsSorted().setPositions(arrayList);
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(((StoreGuildsSorted.Entry) it.next()).asModelGuildFolder());
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithGuildFolders(arrayList3)), false, 1, null), (Class<?>) WidgetGuildsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C87602.INSTANCE);
        return targetOperation != null;
    }

    public final void onItemClicked(GuildListItem item, Context context, FragmentManager fragmentManager) {
        C12238m.checkNotNullParameter(item, "item");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        boolean z2 = !GrowthTeamFeatures.INSTANCE.isHubEnabled();
        if (item instanceof GuildListItem.GuildItem) {
            GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) item;
            if (guildItem.isPendingGuild()) {
                MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(context, fragmentManager, guildItem.getGuild().getId(), "Guilds List", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, C87611.INSTANCE);
                return;
            }
            if (guildItem.isSelected()) {
                StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
                return;
            } else if (guildItem.getGuild().isHub() && z2) {
                C0876m.m169g(context, C5419R.string.discord_u_coming_soon_to_mobile, 0, null, 12);
                return;
            } else {
                StoreStream.INSTANCE.getGuildSelected().set(guildItem.getGuild().getId());
                return;
            }
        }
        if (item instanceof GuildListItem.PrivateChannelItem) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, ((GuildListItem.PrivateChannelItem) item).getChannel().getId(), null, null, 12, null);
            return;
        }
        if (item instanceof GuildListItem.UnavailableItem) {
            this.eventSubject.f27650k.onNext(new Event.ShowUnavailableGuilds(((GuildListItem.UnavailableItem) item).getUnavailableGuildCount()));
            return;
        }
        if (item instanceof GuildListItem.FriendsItem) {
            if (((GuildListItem.FriendsItem) item).isSelected()) {
                StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
                return;
            } else {
                StoreStream.INSTANCE.getGuildSelected().set(0L);
                return;
            }
        }
        if (C12238m.areEqual(item, GuildListItem.CreateItem.INSTANCE)) {
            this.eventSubject.f27650k.onNext(Event.ShowCreateGuild.INSTANCE);
            return;
        }
        if (item instanceof GuildListItem.HubItem) {
            StoreStream.INSTANCE.getDirectories().markDiscordHubClicked();
            this.eventSubject.f27650k.onNext(Event.ShowHubVerification.INSTANCE);
            return;
        }
        if (C12238m.areEqual(item, GuildListItem.HelpItem.INSTANCE)) {
            this.eventSubject.f27650k.onNext(Event.ShowHelp.INSTANCE);
        } else if (item instanceof GuildListItem.FolderItem) {
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) item;
            if (folderItem.isOpen()) {
                StoreStream.INSTANCE.getExpandedGuildFolders().closeFolder(item.getItemId());
            } else {
                StoreStream.INSTANCE.getExpandedGuildFolders().openFolder(item.getItemId());
            }
            this.eventSubject.f27650k.onNext(new Event.AnnounceFolderToggleForAccessibility(folderItem));
        }
    }

    public final void onItemLongPressed(GuildListItem item) {
        C12238m.checkNotNullParameter(item, "item");
        if (item instanceof GuildListItem.PrivateChannelItem) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.f27650k.onNext(new Event.ShowChannelActions(((GuildListItem.PrivateChannelItem) item).getChannel().getId()));
        }
    }

    public final void target(int fromPosition, int toPosition) {
        GuildListItem guildListItemCopy;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            throw new IllegalStateException("targeting with no items");
        }
        ArrayList<GuildListItem> arrayList = new ArrayList<>(loaded.getItems());
        untargetCurrentTarget(arrayList);
        GuildListItem guildListItem = arrayList.get(toPosition);
        if (guildListItem instanceof GuildListItem.GuildItem) {
            GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem;
            guildListItemCopy = guildItem.copy((32735 & 1) != 0 ? guildItem.guild : null, (32735 & 2) != 0 ? guildItem.getMentionCount() : 0, (32735 & 4) != 0 ? guildItem.isLurkingGuild : false, (32735 & 8) != 0 ? guildItem.getIsUnread() : false, (32735 & 16) != 0 ? guildItem.isSelected : false, (32735 & 32) != 0 ? guildItem.folderId : null, (32735 & 64) != 0 ? guildItem.isConnectedToVoice : false, (32735 & 128) != 0 ? guildItem.hasOngoingApplicationStream : false, (32735 & 256) != 0 ? guildItem.isTargetedForFolderCreation : true, (32735 & 512) != 0 ? guildItem.isLastGuildInFolder : null, (32735 & 1024) != 0 ? guildItem.applicationStatus : null, (32735 & 2048) != 0 ? guildItem.isPendingGuild : false, (32735 & 4096) != 0 ? guildItem.hasActiveStageChannel : false, (32735 & 8192) != 0 ? guildItem.isConnectedToStageChannel : false, (32735 & 16384) != 0 ? guildItem.hasActiveScheduledEvent : false);
        } else {
            if (!(guildListItem instanceof GuildListItem.FolderItem)) {
                throw new IllegalStateException("invalid target item: " + guildListItem);
            }
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
            guildListItemCopy = folderItem.copy((399 & 1) != 0 ? folderItem.folderId : 0L, (399 & 2) != 0 ? folderItem.color : null, (399 & 4) != 0 ? folderItem.name : null, (399 & 8) != 0 ? folderItem.isOpen : false, (399 & 16) != 0 ? folderItem.guilds : null, (399 & 32) != 0 ? folderItem.isAnyGuildSelected : false, (399 & 64) != 0 ? folderItem.isAnyGuildConnectedToVoice : false, (399 & 128) != 0 ? folderItem.isAnyGuildConnectedToStageChannel : false, (399 & 256) != 0 ? folderItem.getMentionCount() : 0, (399 & 512) != 0 ? folderItem.getIsUnread() : false, (399 & 1024) != 0 ? folderItem.isTargetedForFolderAddition : true);
        }
        arrayList.set(toPosition, guildListItemCopy);
        this.currentTargetOperation = new WidgetGuildListAdapter.Operation.TargetOperation(fromPosition, toPosition);
        updateViewState(ViewState.Loaded.copy$default(loaded, arrayList, false, true, 2, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel(Clock clock, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.clock = clock;
        this.eventSubject = PublishSubject.m11133k0();
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observable).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetGuildsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87531());
    }
}
