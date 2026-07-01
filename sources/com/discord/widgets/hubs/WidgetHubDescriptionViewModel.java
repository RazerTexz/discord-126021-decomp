package com.discord.widgets.hubs;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.restapi.RestAPIParams$AddServerBody;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel extends d0<HubDescriptionState> {
    public static final WidgetHubDescriptionViewModel$Companion Companion = new WidgetHubDescriptionViewModel$Companion(null);
    private final long channelId;
    private final long guildId;
    private final boolean isEditing;
    private final RestAPI restAPI;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        RestAPI api = (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 32) != 0) {
            WidgetHubDescriptionViewModel$Companion widgetHubDescriptionViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableObserveStores = widgetHubDescriptionViewModel$Companion.observeStores(j, j2, observationDeck, storeStream$Companion.getChannels(), storeStream$Companion.getGuilds());
        } else {
            observableObserveStores = observable;
        }
        this(j, j2, z2, num, api, observableObserveStores);
    }

    public static final /* synthetic */ Unit access$handleStoreUpdate(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel, HubDescriptionState hubDescriptionState) {
        return widgetHubDescriptionViewModel.handleStoreUpdate(hubDescriptionState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel, HubDescriptionState hubDescriptionState) {
        widgetHubDescriptionViewModel.updateViewState(hubDescriptionState);
    }

    private final Unit handleStoreUpdate(HubDescriptionState state) {
        HubDescriptionState viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(HubDescriptionState.copy$default(viewState, state.getChannel(), null, state.getGuildName(), null, 10, null));
        return Unit.a;
    }

    public final void addServer(long channelId, long guildId, String description) {
        DirectoryEntryCategory selectedCategory;
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        HubDescriptionState viewState = getViewState();
        if (viewState == null || (selectedCategory = viewState.getSelectedCategory()) == null) {
            return;
        }
        RestCallStateKt.executeRequest(this.isEditing ? this.restAPI.modifyServerInHub(channelId, guildId, new RestAPIParams$AddServerBody(description, selectedCategory.getKey())) : RestCallStateKt.logNetworkAction(this.restAPI.addServerToHub(channelId, guildId, new RestAPIParams$AddServerBody(description, selectedCategory.getKey())), new WidgetHubDescriptionViewModel$addServer$1(channelId, guildId, selectedCategory)), new WidgetHubDescriptionViewModel$addServer$2(this, viewState));
    }

    public final DirectoryEntryCategory getCategory() {
        HubDescriptionState viewState = getViewState();
        if (viewState != null) {
            return viewState.getSelectedCategory();
        }
        return null;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    /* JADX INFO: renamed from: isEditing, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    public final Unit setCategory(int key) {
        HubDescriptionState viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(HubDescriptionState.copy$default(viewState, null, Integer.valueOf(key), null, null, 13, null));
        return Unit.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable<HubDescriptionState> observable) {
        super(new HubDescriptionState(null, num, null, null, 13, null));
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.guildId = j2;
        this.isEditing = z2;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetHubDescriptionViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubDescriptionViewModel$1(this), 62, (Object) null);
    }
}
