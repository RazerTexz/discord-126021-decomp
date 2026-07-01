package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel extends d0<WidgetDirectoriesViewModel$ViewState> {
    public static final WidgetDirectoriesViewModel$Companion Companion = new WidgetDirectoriesViewModel$Companion(null);
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    public WidgetDirectoriesViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        StoreDirectories directories = (i & 1) != 0 ? StoreStream.Companion.getDirectories() : storeDirectories;
        StoreChannelsSelected channelsSelected = (i & 2) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreReadStates readStates = (i & 8) != 0 ? StoreStream.Companion.getReadStates() : storeReadStates;
        RestAPI api = (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 32) != 0) {
            WidgetDirectoriesViewModel$Companion widgetDirectoriesViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStores = WidgetDirectoriesViewModel$Companion.access$observeStores(widgetDirectoriesViewModel$Companion, observationDeck, storeStream$Companion.getGuilds(), storeStream$Companion.getGuildSelected(), storeStream$Companion.getChannelsSelected(), storeStream$Companion.getDirectories(), storeStream$Companion.getPermissions());
        } else {
            observableAccess$observeStores = observable;
        }
        this(directories, channelsSelected, channels, readStates, api, observableAccess$observeStores);
    }

    public static final /* synthetic */ StoreDirectories access$getDirectoriesStore$p(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
        return widgetDirectoriesViewModel.directoriesStore;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetDirectoriesViewModel widgetDirectoriesViewModel, WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        widgetDirectoriesViewModel.updateViewState(widgetDirectoriesViewModel$ViewState);
    }

    public final String getHubName() {
        Guild guild;
        WidgetDirectoriesViewModel$ViewState viewState = getViewState();
        String name = (viewState == null || (guild = viewState.getGuild()) == null) ? null : guild.getName();
        return name != null ? name : "";
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinGuild(Context context, long id2, long directoryChannelId) {
        m.checkNotNullParameter(context, "context");
        GuildJoinHelperKt.joinGuild$default(context, id2, false, null, Long.valueOf(directoryChannelId), this.restAPI.jsonObjectOf(o.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesViewModel.class, null, null, null, WidgetDirectoriesViewModel$joinGuild$1.INSTANCE, 896, null);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable<WidgetDirectoriesViewModel$ViewState> observable) {
        super(null);
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeReadStates, "readStatesStore");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.directoriesStore = storeDirectories;
        this.restAPI = restAPI;
        Observable observableY = ObservableExtensionsKt.computationLatest(observable).y(WidgetDirectoriesViewModel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "storeObservable\n        …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoriesViewModel$2(this), 62, (Object) null);
        Observable<Channel> observableR = storeChannelsSelected.observeSelectedChannel().r();
        m.checkNotNullExpressionValue(observableR, "channelsSelectedStore\n  …  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY2 = observableG.y(WidgetDirectoriesViewModel$3.INSTANCE);
        m.checkNotNullExpressionValue(observableY2, "channelsSelectedStore\n  …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(observableY2, WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoriesViewModel$4(this), 62, (Object) null);
        Observable<Long> observableY3 = storeChannelsSelected.observePreviousId().r().y(new WidgetDirectoriesViewModel$5(storeChannels));
        m.checkNotNullExpressionValue(observableY3, "channelsSelectedStore.ob…?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(observableY3, WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoriesViewModel$6(storeReadStates), 62, (Object) null);
    }
}
