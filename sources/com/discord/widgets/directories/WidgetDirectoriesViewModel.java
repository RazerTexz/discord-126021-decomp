package com.discord.widgets.directories;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$2 */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final /* synthetic */ class C82812 extends C12236k implements Function1<ViewState, Unit> {
        public C82812(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
            super(1, widgetDirectoriesViewModel, WidgetDirectoriesViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetDirectoriesViewModel) this.receiver).updateViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$4 */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class C82834 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C82834() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetDirectoriesViewModel.this.directoriesStore.fetchDirectoriesForChannel(channel.getId());
            WidgetDirectoriesViewModel.this.directoriesStore.fetchEntryCountsForChannel(channel.getId());
            WidgetDirectoriesViewModel.this.directoriesStore.fetchGuildScheduledEventsForChannel(channel.getGuildId(), channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$6 */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class C82856 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ StoreReadStates $readStatesStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C82856(StoreReadStates storeReadStates) {
            super(1);
            this.$readStatesStore = storeReadStates;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            this.$readStatesStore.markAsRead(l);
        }
    }

    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<ViewState> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore, StorePermissions permissionsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, directoriesStore, channelsSelectedStore, permissionsStore}, false, null, null, new WidgetDirectoriesViewModel$Companion$observeStores$1(channelsSelectedStore, guildSelectedStore, guildsStore, permissionsStore, directoriesStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$joinGuild$1 */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class C82861 extends AbstractC12240o implements Function1<Guild, Unit> {
        public static final C82861 INSTANCE = new C82861();

        public C82861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
        }
    }

    public WidgetDirectoriesViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        StoreDirectories directories = (i & 1) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        StoreChannelsSelected channelsSelected = (i & 2) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreReadStates readStates = (i & 8) != 0 ? StoreStream.INSTANCE.getReadStates() : storeReadStates;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getChannelsSelected(), companion2.getDirectories(), companion2.getPermissions());
        } else {
            observableObserveStores = observable;
        }
        this(directories, channelsSelected, channels, readStates, api, observableObserveStores);
    }

    public final String getHubName() {
        com.discord.models.guild.Guild guild;
        ViewState viewState = getViewState();
        String name = (viewState == null || (guild = viewState.getGuild()) == null) ? null : guild.getName();
        return name != null ? name : "";
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinGuild(Context context, long id2, long directoryChannelId) {
        C12238m.checkNotNullParameter(context, "context");
        GuildJoinHelperKt.joinGuild(context, id2, false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : Long.valueOf(directoryChannelId), (944 & 32) != 0 ? null : this.restAPI.jsonObjectOf(C12116o.m10073to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesViewModel.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, C82861.INSTANCE);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final /* data */ class ViewState {
        private final Set<Long> adminGuildIds;

        /* JADX INFO: renamed from: allDirectoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy allDirectoryEntryData;
        private final Channel channel;
        private final RestCallState<List<DirectoryEntryGuild>> directories;

        /* JADX INFO: renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy directoryEntryData;
        private final com.discord.models.guild.Guild guild;
        private final boolean hasAddGuildPermissions;
        private final Set<Long> joinedGuildIds;

        /* JADX INFO: renamed from: mappedTabs$delegate, reason: from kotlin metadata */
        private final Lazy mappedTabs;
        private final RestCallState<Map<Integer, Integer>> tabs;

        public ViewState() {
            this(null, null, null, null, false, null, null, Opcodes.LAND, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(com.discord.models.guild.Guild guild, Channel channel, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, RestCallState<? extends Map<Integer, Integer>> restCallState2) {
            C12238m.checkNotNullParameter(set, "joinedGuildIds");
            C12238m.checkNotNullParameter(set2, "adminGuildIds");
            C12238m.checkNotNullParameter(restCallState, "directories");
            C12238m.checkNotNullParameter(restCallState2, "tabs");
            this.guild = guild;
            this.channel = channel;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directories = restCallState;
            this.tabs = restCallState2;
            this.allDirectoryEntryData = C12083g.lazy(new WidgetDirectoriesViewModel$ViewState$allDirectoryEntryData$2(this));
            this.directoryEntryData = C12083g.lazy(new WidgetDirectoriesViewModel$ViewState$directoryEntryData$2(this));
            this.mappedTabs = C12083g.lazy(new WidgetDirectoriesViewModel$ViewState$mappedTabs$2(this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                channel = viewState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                set = viewState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 8) != 0) {
                set2 = viewState.adminGuildIds;
            }
            Set set4 = set2;
            if ((i & 16) != 0) {
                z2 = viewState.hasAddGuildPermissions;
            }
            boolean z3 = z2;
            if ((i & 32) != 0) {
                restCallState = viewState.directories;
            }
            RestCallState restCallState3 = restCallState;
            if ((i & 64) != 0) {
                restCallState2 = viewState.tabs;
            }
            return viewState.copy(guild, channel2, set3, set4, z3, restCallState3, restCallState2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Set<Long> component3() {
            return this.joinedGuildIds;
        }

        public final Set<Long> component4() {
            return this.adminGuildIds;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final RestCallState<List<DirectoryEntryGuild>> component6() {
            return this.directories;
        }

        public final RestCallState<Map<Integer, Integer>> component7() {
            return this.tabs;
        }

        public final ViewState copy(com.discord.models.guild.Guild guild, Channel channel, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directories, RestCallState<? extends Map<Integer, Integer>> tabs) {
            C12238m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            C12238m.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            C12238m.checkNotNullParameter(directories, "directories");
            C12238m.checkNotNullParameter(tabs, "tabs");
            return new ViewState(guild, channel, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directories, tabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.guild, viewState.guild) && C12238m.areEqual(this.channel, viewState.channel) && C12238m.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && C12238m.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && C12238m.areEqual(this.directories, viewState.directories) && C12238m.areEqual(this.tabs, viewState.tabs);
        }

        public final Set<Long> getAdminGuildIds() {
            return this.adminGuildIds;
        }

        public final List<DirectoryEntryData> getAllDirectoryEntryData() {
            return (List) this.allDirectoryEntryData.getValue();
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final RestCallState<List<DirectoryEntryGuild>> getDirectories() {
            return this.directories;
        }

        public final Map<Integer, List<DirectoryEntryData>> getDirectoryEntryData() {
            return (Map) this.directoryEntryData.getValue();
        }

        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final Set<Long> getJoinedGuildIds() {
            return this.joinedGuildIds;
        }

        public final List<Pair<DirectoryEntryCategory, Integer>> getMappedTabs() {
            return (List) this.mappedTabs.getValue();
        }

        public final RestCallState<Map<Integer, Integer>> getTabs() {
            return this.tabs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v20 */
        public int hashCode() {
            com.discord.models.guild.Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.adminGuildIds;
            int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
            boolean z2 = this.hasAddGuildPermissions;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode4 + r2) * 31;
            RestCallState<List<DirectoryEntryGuild>> restCallState = this.directories;
            int iHashCode5 = (i + (restCallState != null ? restCallState.hashCode() : 0)) * 31;
            RestCallState<Map<Integer, Integer>> restCallState2 = this.tabs;
            return iHashCode5 + (restCallState2 != null ? restCallState2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", joinedGuildIds=");
            sbM833U.append(this.joinedGuildIds);
            sbM833U.append(", adminGuildIds=");
            sbM833U.append(this.adminGuildIds);
            sbM833U.append(", hasAddGuildPermissions=");
            sbM833U.append(this.hasAddGuildPermissions);
            sbM833U.append(", directories=");
            sbM833U.append(this.directories);
            sbM833U.append(", tabs=");
            sbM833U.append(this.tabs);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) == 0 ? channel : null, (i & 4) != 0 ? C12148n0.emptySet() : set, (i & 8) != 0 ? C12148n0.emptySet() : set2, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? Default.INSTANCE : restCallState, (i & 64) != 0 ? Default.INSTANCE : restCallState2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, final StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable<ViewState> observable) {
        super(null);
        C12238m.checkNotNullParameter(storeDirectories, "directoriesStore");
        C12238m.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeReadStates, "readStatesStore");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.directoriesStore = storeDirectories;
        this.restAPI = restAPI;
        Observable observableM11118y = ObservableExtensionsKt.computationLatest(observable).m11118y(new InterfaceC12589b<ViewState, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoriesViewModel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(ViewState viewState) {
                Channel channel = viewState.getChannel();
                return Boolean.valueOf(channel != null && ChannelUtils.m7691o(channel));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "storeObservable\n        …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11118y, this, null, 2, null), (Class<?>) WidgetDirectoriesViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82812(this));
        Observable<Channel> observableM11112r = storeChannelsSelected.observeSelectedChannel().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "channelsSelectedStore\n  …  .distinctUntilChanged()");
        Observable<R> observableM11083G = observableM11112r.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11118y2 = observableM11083G.m11118y(new InterfaceC12589b<Channel, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoriesViewModel.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel != null && ChannelUtils.m7691o(channel));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y2, "channelsSelectedStore\n  …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe(observableM11118y2, (Class<?>) WidgetDirectoriesViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82834());
        Observable<Long> observableM11118y3 = storeChannelsSelected.observePreviousId().m11112r().m11118y(new InterfaceC12589b<Long, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoriesViewModel.5
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Long l) {
                StoreChannels storeChannels2 = storeChannels;
                C12238m.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
                Channel channelFindChannelById = storeChannels2.findChannelById(l.longValue());
                return Boolean.valueOf(channelFindChannelById != null && ChannelUtils.m7691o(channelFindChannelById));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y3, "channelsSelectedStore.ob…?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe(observableM11118y3, (Class<?>) WidgetDirectoriesViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82856(storeReadStates));
    }
}
