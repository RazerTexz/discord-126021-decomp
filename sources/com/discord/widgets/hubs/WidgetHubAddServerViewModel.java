package com.discord.widgets.hubs;

import b.a.d.AppViewModel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerViewModel extends AppViewModel<WidgetHubAddServerViewModel2> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServerViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubAddServerViewModel2, Unit> {
        public AnonymousClass1(WidgetHubAddServerViewModel widgetHubAddServerViewModel) {
            super(1, widgetHubAddServerViewModel, WidgetHubAddServerViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubAddServerState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            invoke2(widgetHubAddServerViewModel2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            Intrinsics3.checkNotNullParameter(widgetHubAddServerViewModel2, "p1");
            ((WidgetHubAddServerViewModel) this.receiver).handleStoreUpdate(widgetHubAddServerViewModel2);
        }
    }

    /* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<WidgetHubAddServerViewModel2> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildsSelected, StorePermissions permissionsStore, StoreChannels channelsStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildsSelected, permissionsStore, channelsStore, channelsSelectedStore, directoriesStore}, false, null, null, new WidgetHubAddServerViewModel3(guildsStore, guildsSelected, permissionsStore, channelsSelectedStore, channelsStore, directoriesStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubAddServerViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubAddServerViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStores(observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getPermissions(), companion2.getChannels(), companion2.getChannelsSelected(), companion2.getDirectories());
        }
        this(observable);
    }

    private final void handleStoreUpdate(WidgetHubAddServerViewModel2 state) {
        updateViewState(WidgetHubAddServerViewModel2.copy$default(requireViewState(), state.getHubName(), state.getDirectoryChannelId(), 0, state.getSelectableGuilds(), state.getAddedGuilds(), state.getAddedDirectories(), 4, null));
    }

    public final Long getChannelId() {
        WidgetHubAddServerViewModel2 viewState = getViewState();
        if (viewState != null) {
            return viewState.getDirectoryChannelId();
        }
        return null;
    }

    public final String getHubName() {
        WidgetHubAddServerViewModel2 viewState = getViewState();
        String hubName = viewState != null ? viewState.getHubName() : null;
        return hubName != null ? hubName : "";
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        StoreStream.INSTANCE.getDirectories().removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void setIndex(int index) {
        updateViewState(WidgetHubAddServerViewModel2.copy$default(requireViewState(), null, null, index, null, null, null, 59, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServerViewModel(Observable<WidgetHubAddServerViewModel2> observable) {
        super(new WidgetHubAddServerViewModel2(null, null, 0, null, null, null, 63, null));
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetHubAddServerViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
