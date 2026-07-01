package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
            super(1, widgetDirectoriesViewModel, WidgetDirectoriesViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetDirectoriesViewModel) this.receiver).updateViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetDirectoriesViewModel.this.directoriesStore.fetchDirectoriesForChannel(channel.getId());
            WidgetDirectoriesViewModel.this.directoriesStore.fetchEntryCountsForChannel(channel.getId());
            WidgetDirectoriesViewModel.this.directoriesStore.fetchGuildScheduledEventsForChannel(channel.getGuildId(), channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ StoreReadStates $readStatesStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(StoreReadStates storeReadStates) {
            super(1);
            this.$readStatesStore = storeReadStates;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
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
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, directoriesStore, channelsSelectedStore, permissionsStore}, false, null, null, new WidgetDirectoriesViewModel2(channelsSelectedStore, guildSelectedStore, guildsStore, permissionsStore, directoriesStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$joinGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
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
            ObservationDeck observationDeck = ObservationDeck4.get();
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
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildJoinHelper.joinGuild(context, id2, false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : Long.valueOf(directoryChannelId), (944 & 32) != 0 ? null : this.restAPI.jsonObjectOf(Tuples.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesViewModel.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, AnonymousClass1.INSTANCE);
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
            Intrinsics3.checkNotNullParameter(set, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(set2, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(restCallState, "directories");
            Intrinsics3.checkNotNullParameter(restCallState2, "tabs");
            this.guild = guild;
            this.channel = channel;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directories = restCallState;
            this.tabs = restCallState2;
            this.allDirectoryEntryData = LazyJVM.lazy(new WidgetDirectoriesViewModel3(this));
            this.directoryEntryData = LazyJVM.lazy(new WidgetDirectoriesViewModel4(this));
            this.mappedTabs = LazyJVM.lazy(new WidgetDirectoriesViewModel5(this));
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
            Intrinsics3.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(directories, "directories");
            Intrinsics3.checkNotNullParameter(tabs, "tabs");
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
            return Intrinsics3.areEqual(this.guild, viewState.guild) && Intrinsics3.areEqual(this.channel, viewState.channel) && Intrinsics3.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && Intrinsics3.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && Intrinsics3.areEqual(this.directories, viewState.directories) && Intrinsics3.areEqual(this.tabs, viewState.tabs);
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

        public final List<Tuples2<DirectoryEntryCategory, Integer>> getMappedTabs() {
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
            StringBuilder sbU = outline.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", adminGuildIds=");
            sbU.append(this.adminGuildIds);
            sbU.append(", hasAddGuildPermissions=");
            sbU.append(this.hasAddGuildPermissions);
            sbU.append(", directories=");
            sbU.append(this.directories);
            sbU.append(", tabs=");
            sbU.append(this.tabs);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) == 0 ? channel : null, (i & 4) != 0 ? Sets5.emptySet() : set, (i & 8) != 0 ? Sets5.emptySet() : set2, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? RestCallState2.INSTANCE : restCallState, (i & 64) != 0 ? RestCallState2.INSTANCE : restCallState2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, final StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable<ViewState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeReadStates, "readStatesStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.directoriesStore = storeDirectories;
        this.restAPI = restAPI;
        Observable observableY = ObservableExtensionsKt.computationLatest(observable).y(new Func1<ViewState, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoriesViewModel.1
            @Override // j0.k.Func1
            public final Boolean call(ViewState viewState) {
                Channel channel = viewState.getChannel();
                return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeObservable\n        …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), (Class<?>) WidgetDirectoriesViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        Observable<Channel> observableR = storeChannelsSelected.observeSelectedChannel().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelsSelectedStore\n  …  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY2 = observableG.y(new Func1<Channel, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoriesViewModel.3
            @Override // j0.k.Func1
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY2, "channelsSelectedStore\n  …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe(observableY2, (Class<?>) WidgetDirectoriesViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        Observable<Long> observableY3 = storeChannelsSelected.observePreviousId().r().y(new Func1<Long, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoriesViewModel.5
            @Override // j0.k.Func1
            public final Boolean call(Long l) {
                StoreChannels storeChannels2 = storeChannels;
                Intrinsics3.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
                Channel channelFindChannelById = storeChannels2.findChannelById(l.longValue());
                return Boolean.valueOf(channelFindChannelById != null && ChannelUtils.o(channelFindChannelById));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY3, "channelsSelectedStore.ob…?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe(observableY3, (Class<?>) WidgetDirectoriesViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass6(storeReadStates));
    }
}
