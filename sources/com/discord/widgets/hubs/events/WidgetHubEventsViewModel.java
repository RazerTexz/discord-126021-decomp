package com.discord.widgets.hubs.events;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Default;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsViewModel extends d0<WidgetHubEventsState> {
    private final StoreDirectories directoriesStore;
    private final long directoryChannelId;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;

    public /* synthetic */ WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.Companion.getDirectories() : storeDirectories, (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 128) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 256) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ WidgetHubEventsState access$getViewState$p(WidgetHubEventsViewModel widgetHubEventsViewModel) {
        return widgetHubEventsViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubEventsViewModel widgetHubEventsViewModel, WidgetHubEventsState widgetHubEventsState) {
        widgetHubEventsViewModel.updateViewState(widgetHubEventsState);
    }

    private final Observable<WidgetHubEventsState> getObservableFromStores(ObservationDeck observationDeck, StoreDirectories directoriesStore, StoreGuilds guildsStore, StoreChannels channelsStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, long directoryChannelId) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{directoriesStore, guildsStore, channelsStore, voiceChannelSelectedStore, guildScheduledEventsStore, permissionsStore}, false, null, null, new WidgetHubEventsViewModel$getObservableFromStores$1(this, directoriesStore, directoryChannelId, channelsStore, guildScheduledEventsStore, voiceChannelSelectedStore, permissionsStore, guildsStore), 14, null);
    }

    public final void dismissHeader() {
        WidgetHubEventsState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetHubEventsState.copy$default(viewState, false, null, null, 6, null));
        }
        this.directoriesStore.markGuildScheduledEventsHeaderDismissed();
    }

    public final void fetchGuildScheduledEvents() {
        this.directoriesStore.fetchGuildScheduledEventsForChannel(this.guildId, this.directoryChannelId);
    }

    public final StoreGuildScheduledEvents getGuildScheduledEventsStore() {
        return this.guildScheduledEventsStore;
    }

    public final void reset() {
        WidgetHubEventsState viewState = getViewState();
        m.checkNotNull(viewState);
        updateViewState(WidgetHubEventsState.copy$default(viewState, false, null, Default.INSTANCE, 3, null));
    }

    public final void toggleRsvp(GuildScheduledEvent event) {
        m.checkNotNullParameter(event, "event");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck) {
        super(new WidgetHubEventsState(false, null, null, 7, null));
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.directoryChannelId = j2;
        this.directoriesStore = storeDirectories;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        Observable observableG = ObservableExtensionsKt.computationLatest(getObservableFromStores(observationDeck, storeDirectories, storeGuilds, storeChannels, storeVoiceChannelSelected, storeGuildScheduledEvents, storePermissions, j2)).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetHubEventsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubEventsViewModel$1(this), 62, (Object) null);
        fetchGuildScheduledEvents();
    }
}
