package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.g0.t;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel extends d0<WidgetDirectoriesSearchViewModel$ViewState> {
    public static final WidgetDirectoriesSearchViewModel$Companion Companion = new WidgetDirectoriesSearchViewModel$Companion(null);
    private final long channelId;
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        RestAPI api = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreDirectories directories = (i & 4) != 0 ? StoreStream.Companion.getDirectories() : storeDirectories;
        if ((i & 8) != 0) {
            WidgetDirectoriesSearchViewModel$Companion widgetDirectoriesSearchViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStores = WidgetDirectoriesSearchViewModel$Companion.access$observeStores(widgetDirectoriesSearchViewModel$Companion, j, observationDeck, storeStream$Companion.getGuilds(), storeStream$Companion.getGuildSelected(), storeStream$Companion.getChannels(), storeStream$Companion.getPermissions());
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, api, directories, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$handleNewState(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        widgetDirectoriesSearchViewModel.handleNewState(widgetDirectoriesSearchViewModel$ViewState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        widgetDirectoriesSearchViewModel.updateViewState(widgetDirectoriesSearchViewModel$ViewState);
    }

    private final void handleNewState(WidgetDirectoriesSearchViewModel$ViewState state) {
        WidgetDirectoriesSearchViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetDirectoriesSearchViewModel$ViewState.copy$default(viewState, state.getGuild(), null, null, state.getJoinedGuildIds(), state.getAdminGuildIds(), state.getHasAddGuildPermissions(), null, 70, null));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final StoreDirectories getDirectoriesStore() {
        return this.directoriesStore;
    }

    public final String getHubName() {
        Guild guild;
        WidgetDirectoriesSearchViewModel$ViewState viewState = getViewState();
        String name = (viewState == null || (guild = viewState.getGuild()) == null) ? null : guild.getName();
        return name != null ? name : "";
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinGuild(Context context, long id2, long directoryChannelId) {
        m.checkNotNullParameter(context, "context");
        GuildJoinHelperKt.joinGuild$default(context, id2, false, null, Long.valueOf(directoryChannelId), this.restAPI.jsonObjectOf(o.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesSearchViewModel.class, null, null, null, WidgetDirectoriesSearchViewModel$joinGuild$1.INSTANCE, 896, null);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void searchForDirectories(long channelId, CharSequence query) {
        m.checkNotNullParameter(query, "query");
        WidgetDirectoriesSearchViewModel$ViewState viewState = getViewState();
        if (viewState == null || shouldNotSearch(query)) {
            return;
        }
        RestCallStateKt.executeRequest(this.restAPI.searchServers(channelId, query.toString()), new WidgetDirectoriesSearchViewModel$searchForDirectories$1(this, viewState, query));
    }

    public final boolean shouldNotSearch(CharSequence searchTerm) {
        m.checkNotNullParameter(searchTerm, "searchTerm");
        if (!t.isBlank(searchTerm)) {
            WidgetDirectoriesSearchViewModel$ViewState viewState = getViewState();
            if (!m.areEqual(viewState != null ? viewState.getCurrentSearchTerm() : null, searchTerm.toString())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable<WidgetDirectoriesSearchViewModel$ViewState> observable) {
        super(new WidgetDirectoriesSearchViewModel$ViewState(null, null, null, null, null, false, null, Opcodes.LAND, null));
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.restAPI = restAPI;
        this.directoriesStore = storeDirectories;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetDirectoriesSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoriesSearchViewModel$1(this), 62, (Object) null);
    }
}
