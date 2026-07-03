package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionDirectoryGuildEntryCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12215a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel extends AbstractC0859d0<HubDescriptionState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final boolean isEditing;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$1 */
    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final /* synthetic */ class C90141 extends C12215a implements Function1<HubDescriptionState, Unit> {
        public C90141(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel) {
            super(1, widgetHubDescriptionViewModel, WidgetHubDescriptionViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubDescriptionState;)Lkotlin/Unit;", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubDescriptionState hubDescriptionState) {
            invoke2(hubDescriptionState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubDescriptionState hubDescriptionState) {
            C12238m.checkNotNullParameter(hubDescriptionState, "p1");
            ((WidgetHubDescriptionViewModel) this.receiver).handleStoreUpdate(hubDescriptionState);
        }
    }

    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<HubDescriptionState> observeStores(long channelId, long guildId, ObservationDeck observationDeck, StoreChannels channelStore, StoreGuilds guildStore) {
            C12238m.checkNotNullParameter(observationDeck, "observationDeck");
            C12238m.checkNotNullParameter(channelStore, "channelStore");
            C12238m.checkNotNullParameter(guildStore, "guildStore");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{channelStore, guildStore}, false, null, null, new WidgetHubDescriptionViewModel$Companion$observeStores$1(channelStore, channelId, guildStore, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$addServer$1 */
    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final class C90151 extends AbstractC12240o implements Function1<DirectoryEntryGuild, TrackNetworkMetadataReceiver> {
        public final /* synthetic */ DirectoryEntryCategory $category;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90151(long j, long j2, DirectoryEntryCategory directoryEntryCategory) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
            this.$category = directoryEntryCategory;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(DirectoryEntryGuild directoryEntryGuild) {
            return new TrackNetworkActionDirectoryGuildEntryCreate(Long.valueOf(this.$channelId), Long.valueOf(this.$guildId), Long.valueOf(this.$category.getKey()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$addServer$2 */
    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final class C90162 extends AbstractC12240o implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
        public final /* synthetic */ HubDescriptionState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90162(HubDescriptionState hubDescriptionState) {
            super(1);
            this.$state = hubDescriptionState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
            invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "it");
            WidgetHubDescriptionViewModel.this.updateViewState(HubDescriptionState.copy$default(this.$state, null, null, null, restCallState, 7, null));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(j, j2, observationDeck, companion2.getChannels(), companion2.getGuilds());
        } else {
            observableObserveStores = observable;
        }
        this(j, j2, z2, num, api, observableObserveStores);
    }

    private final Unit handleStoreUpdate(HubDescriptionState state) {
        HubDescriptionState viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(HubDescriptionState.copy$default(viewState, state.getChannel(), null, state.getGuildName(), null, 10, null));
        return Unit.f27425a;
    }

    public final void addServer(long channelId, long guildId, String description) {
        DirectoryEntryCategory selectedCategory;
        C12238m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        HubDescriptionState viewState = getViewState();
        if (viewState == null || (selectedCategory = viewState.getSelectedCategory()) == null) {
            return;
        }
        RestCallStateKt.executeRequest(this.isEditing ? this.restAPI.modifyServerInHub(channelId, guildId, new RestAPIParams.AddServerBody(description, selectedCategory.getKey())) : RestCallStateKt.logNetworkAction(this.restAPI.addServerToHub(channelId, guildId, new RestAPIParams.AddServerBody(description, selectedCategory.getKey())), new C90151(channelId, guildId, selectedCategory)), new C90162(viewState));
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
        return Unit.f27425a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable<HubDescriptionState> observable) {
        super(new HubDescriptionState(null, num, null, null, 13, null));
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.guildId = j2;
        this.isEditing = z2;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetHubDescriptionViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90141(this));
    }
}
