package com.discord.widgets.hubs;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerViewModel extends d0<HubAddServerState> {
    public static final WidgetHubAddServerViewModel$Companion Companion = new WidgetHubAddServerViewModel$Companion(null);

    public WidgetHubAddServerViewModel() {
        this(null, 1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubAddServerViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            WidgetHubAddServerViewModel$Companion widgetHubAddServerViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = WidgetHubAddServerViewModel$Companion.access$observeStores(widgetHubAddServerViewModel$Companion, observationDeck, storeStream$Companion.getGuilds(), storeStream$Companion.getGuildSelected(), storeStream$Companion.getPermissions(), storeStream$Companion.getChannels(), storeStream$Companion.getChannelsSelected(), storeStream$Companion.getDirectories());
        }
        this(observable);
    }

    public static final /* synthetic */ void access$handleStoreUpdate(WidgetHubAddServerViewModel widgetHubAddServerViewModel, HubAddServerState hubAddServerState) {
        widgetHubAddServerViewModel.handleStoreUpdate(hubAddServerState);
    }

    private final void handleStoreUpdate(HubAddServerState state) {
        updateViewState(HubAddServerState.copy$default(requireViewState(), state.getHubName(), state.getDirectoryChannelId(), 0, state.getSelectableGuilds(), state.getAddedGuilds(), state.getAddedDirectories(), 4, null));
    }

    public final Long getChannelId() {
        HubAddServerState viewState = getViewState();
        if (viewState != null) {
            return viewState.getDirectoryChannelId();
        }
        return null;
    }

    public final String getHubName() {
        HubAddServerState viewState = getViewState();
        String hubName = viewState != null ? viewState.getHubName() : null;
        return hubName != null ? hubName : "";
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        StoreStream.Companion.getDirectories().removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void setIndex(int index) {
        updateViewState(HubAddServerState.copy$default(requireViewState(), null, null, index, null, null, null, 59, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServerViewModel(Observable<HubAddServerState> observable) {
        super(new HubAddServerState(null, null, 0, null, null, null, 63, null));
        m.checkNotNullParameter(observable, "storeObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetHubAddServerViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubAddServerViewModel$1(this), 62, (Object) null);
    }
}
