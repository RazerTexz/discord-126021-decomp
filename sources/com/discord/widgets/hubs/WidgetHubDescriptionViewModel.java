package com.discord.widgets.hubs;

import b.a.d.AppViewModel;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionDirectoryGuildEntryCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.AdaptedFunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel extends AppViewModel<WidgetHubDescriptionViewModel3> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final boolean isEditing;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<WidgetHubDescriptionViewModel3, Unit> {
        public AnonymousClass1(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel) {
            super(1, widgetHubDescriptionViewModel, WidgetHubDescriptionViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubDescriptionState;)Lkotlin/Unit;", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            invoke2(widgetHubDescriptionViewModel3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "p1");
            ((WidgetHubDescriptionViewModel) this.receiver).handleStoreUpdate(widgetHubDescriptionViewModel3);
        }
    }

    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<WidgetHubDescriptionViewModel3> observeStores(long channelId, long guildId, ObservationDeck observationDeck, StoreChannels channelStore, StoreGuilds guildStore) {
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Intrinsics3.checkNotNullParameter(channelStore, "channelStore");
            Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{channelStore, guildStore}, false, null, null, new WidgetHubDescriptionViewModel4(channelStore, channelId, guildStore, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$addServer$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<DirectoryEntryGuild, TrackNetworkMetadata2> {
        public final /* synthetic */ DirectoryEntryCategory $category;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, DirectoryEntryCategory directoryEntryCategory) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
            this.$category = directoryEntryCategory;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(DirectoryEntryGuild directoryEntryGuild) {
            return new TrackNetworkActionDirectoryGuildEntryCreate(Long.valueOf(this.$channelId), Long.valueOf(this.$guildId), Long.valueOf(this.$category.getKey()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$addServer$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
        public final /* synthetic */ WidgetHubDescriptionViewModel3 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            super(1);
            this.$state = widgetHubDescriptionViewModel3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
            invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "it");
            WidgetHubDescriptionViewModel.this.updateViewState(WidgetHubDescriptionViewModel3.copy$default(this.$state, null, null, null, restCallState, 7, null));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(j, j2, observationDeck, companion2.getChannels(), companion2.getGuilds());
        } else {
            observableObserveStores = observable;
        }
        this(j, j2, z2, num, api, observableObserveStores);
    }

    private final Unit handleStoreUpdate(WidgetHubDescriptionViewModel3 state) {
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(WidgetHubDescriptionViewModel3.copy$default(viewState, state.getChannel(), null, state.getGuildName(), null, 10, null));
        return Unit.a;
    }

    public final void addServer(long channelId, long guildId, String description) {
        DirectoryEntryCategory selectedCategory;
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState == null || (selectedCategory = viewState.getSelectedCategory()) == null) {
            return;
        }
        RestCallState5.executeRequest(this.isEditing ? this.restAPI.modifyServerInHub(channelId, guildId, new RestAPIParams.AddServerBody(description, selectedCategory.getKey())) : RestCallState5.logNetworkAction(this.restAPI.addServerToHub(channelId, guildId, new RestAPIParams.AddServerBody(description, selectedCategory.getKey())), new AnonymousClass1(channelId, guildId, selectedCategory)), new AnonymousClass2(viewState));
    }

    public final DirectoryEntryCategory getCategory() {
        WidgetHubDescriptionViewModel3 viewState = getViewState();
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
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(WidgetHubDescriptionViewModel3.copy$default(viewState, null, Integer.valueOf(key), null, null, 13, null));
        return Unit.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable<WidgetHubDescriptionViewModel3> observable) {
        super(new WidgetHubDescriptionViewModel3(null, num, null, null, 13, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.guildId = j2;
        this.isEditing = z2;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetHubDescriptionViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
