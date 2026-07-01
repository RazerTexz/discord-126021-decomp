package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.LazyJVM;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass1(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel) {
            super(1, widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel.class, "handleNewState", "handleNewState(Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetDirectoriesSearchViewModel) this.receiver).handleNewState(viewState);
        }
    }

    /* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<ViewState> observeStores(long channelId, ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannels channelsStore, StorePermissions permissionsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, channelsStore, permissionsStore}, false, null, null, new WidgetDirectoriesSearchViewModel2(permissionsStore, guildsStore, guildSelectedStore, channelId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$joinGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$searchForDirectories$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
        public final /* synthetic */ CharSequence $query;
        public final /* synthetic */ ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState viewState, CharSequence charSequence) {
            super(1);
            this.$viewState = viewState;
            this.$query = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "entriesState");
            WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel = WidgetDirectoriesSearchViewModel.this;
            ViewState viewState = this.$viewState;
            String string = this.$query.toString();
            List<DirectoryEntryGuild> listInvoke = restCallState.invoke();
            if (listInvoke == null) {
                listInvoke = this.$viewState.getDirectories();
            }
            widgetDirectoriesSearchViewModel.updateViewState(ViewState.copy$default(viewState, null, string, listInvoke, null, null, false, restCallState, 57, null));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreDirectories directories = (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(j, observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getChannels(), companion2.getPermissions());
        } else {
            observableObserveStores = observable;
        }
        this(j, api, directories, observableObserveStores);
    }

    private final void handleNewState(ViewState state) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, state.getGuild(), null, null, state.getJoinedGuildIds(), state.getAdminGuildIds(), state.getHasAddGuildPermissions(), null, 70, null));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final StoreDirectories getDirectoriesStore() {
        return this.directoriesStore;
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
        GuildJoinHelper.joinGuild(context, id2, false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : Long.valueOf(directoryChannelId), (944 & 32) != 0 ? null : this.restAPI.jsonObjectOf(Tuples.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesSearchViewModel.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, AnonymousClass1.INSTANCE);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void searchForDirectories(long channelId, CharSequence query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        ViewState viewState = getViewState();
        if (viewState == null || shouldNotSearch(query)) {
            return;
        }
        RestCallState5.executeRequest(this.restAPI.searchServers(channelId, query.toString()), new AnonymousClass1(viewState, query));
    }

    public final boolean shouldNotSearch(CharSequence searchTerm) {
        Intrinsics3.checkNotNullParameter(searchTerm, "searchTerm");
        if (!StringsJVM.isBlank(searchTerm)) {
            ViewState viewState = getViewState();
            if (!Intrinsics3.areEqual(viewState != null ? viewState.getCurrentSearchTerm() : null, searchTerm.toString())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
    public static final /* data */ class ViewState {
        private final Set<Long> adminGuildIds;
        private final String currentSearchTerm;
        private final List<DirectoryEntryGuild> directories;
        private final RestCallState<List<DirectoryEntryGuild>> directoriesState;

        /* JADX INFO: renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy directoryEntryData;
        private final com.discord.models.guild.Guild guild;
        private final boolean hasAddGuildPermissions;
        private final Set<Long> joinedGuildIds;

        public ViewState() {
            this(null, null, null, null, null, false, null, Opcodes.LAND, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(com.discord.models.guild.Guild guild, String str, List<DirectoryEntryGuild> list, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            Intrinsics3.checkNotNullParameter(str, "currentSearchTerm");
            Intrinsics3.checkNotNullParameter(list, "directories");
            Intrinsics3.checkNotNullParameter(set, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(set2, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(restCallState, "directoriesState");
            this.guild = guild;
            this.currentSearchTerm = str;
            this.directories = list;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directoriesState = restCallState;
            this.directoryEntryData = LazyJVM.lazy(new WidgetDirectoriesSearchViewModel3(this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, com.discord.models.guild.Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                str = viewState.currentSearchTerm;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = viewState.directories;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                set = viewState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 16) != 0) {
                set2 = viewState.adminGuildIds;
            }
            Set set4 = set2;
            if ((i & 32) != 0) {
                z2 = viewState.hasAddGuildPermissions;
            }
            boolean z3 = z2;
            if ((i & 64) != 0) {
                restCallState = viewState.directoriesState;
            }
            return viewState.copy(guild, str2, list2, set3, set4, z3, restCallState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrentSearchTerm() {
            return this.currentSearchTerm;
        }

        public final List<DirectoryEntryGuild> component3() {
            return this.directories;
        }

        public final Set<Long> component4() {
            return this.joinedGuildIds;
        }

        public final Set<Long> component5() {
            return this.adminGuildIds;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final RestCallState<List<DirectoryEntryGuild>> component7() {
            return this.directoriesState;
        }

        public final ViewState copy(com.discord.models.guild.Guild guild, String currentSearchTerm, List<DirectoryEntryGuild> directories, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directoriesState) {
            Intrinsics3.checkNotNullParameter(currentSearchTerm, "currentSearchTerm");
            Intrinsics3.checkNotNullParameter(directories, "directories");
            Intrinsics3.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(directoriesState, "directoriesState");
            return new ViewState(guild, currentSearchTerm, directories, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directoriesState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.guild, viewState.guild) && Intrinsics3.areEqual(this.currentSearchTerm, viewState.currentSearchTerm) && Intrinsics3.areEqual(this.directories, viewState.directories) && Intrinsics3.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && Intrinsics3.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && Intrinsics3.areEqual(this.directoriesState, viewState.directoriesState);
        }

        public final Set<Long> getAdminGuildIds() {
            return this.adminGuildIds;
        }

        public final String getCurrentSearchTerm() {
            return this.currentSearchTerm;
        }

        public final List<DirectoryEntryGuild> getDirectories() {
            return this.directories;
        }

        public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesState() {
            return this.directoriesState;
        }

        public final List<DirectoryEntryData> getDirectoryEntryData() {
            return (List) this.directoryEntryData.getValue();
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v20 */
        public int hashCode() {
            com.discord.models.guild.Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            String str = this.currentSearchTerm;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<DirectoryEntryGuild> list = this.directories;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.adminGuildIds;
            int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
            boolean z2 = this.hasAddGuildPermissions;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode5 + r2) * 31;
            RestCallState<List<DirectoryEntryGuild>> restCallState = this.directoriesState;
            return i + (restCallState != null ? restCallState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", currentSearchTerm=");
            sbU.append(this.currentSearchTerm);
            sbU.append(", directories=");
            sbU.append(this.directories);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", adminGuildIds=");
            sbU.append(this.adminGuildIds);
            sbU.append(", hasAddGuildPermissions=");
            sbU.append(this.hasAddGuildPermissions);
            sbU.append(", directoriesState=");
            sbU.append(this.directoriesState);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? Collections2.emptyList() : list, (i & 8) != 0 ? Sets5.emptySet() : set, (i & 16) != 0 ? Sets5.emptySet() : set2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? RestCallState2.INSTANCE : restCallState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable<ViewState> observable) {
        super(new ViewState(null, null, null, null, null, false, null, Opcodes.LAND, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.restAPI = restAPI;
        this.directoriesStore = storeDirectories;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetDirectoriesSearchViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
