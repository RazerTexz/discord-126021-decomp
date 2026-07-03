package com.discord.widgets.hubs.events;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsViewModel extends AbstractC0859d0<WidgetHubEventsState> {
    private final StoreDirectories directoriesStore;
    private final long directoryChannelId;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$1 */
    /* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
    public static final /* synthetic */ class C90551 extends C12236k implements Function1<WidgetHubEventsState, Unit> {
        public C90551(WidgetHubEventsViewModel widgetHubEventsViewModel) {
            super(1, widgetHubEventsViewModel, WidgetHubEventsViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsState widgetHubEventsState) {
            invoke2(widgetHubEventsState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsState widgetHubEventsState) {
            C12238m.checkNotNullParameter(widgetHubEventsState, "p1");
            ((WidgetHubEventsViewModel) this.receiver).updateViewState(widgetHubEventsState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$getObservableFromStores$1 */
    /* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
    public static final class C90561 extends AbstractC12240o implements Function0<WidgetHubEventsState> {
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ StoreDirectories $directoriesStore;
        public final /* synthetic */ long $directoryChannelId;
        public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ StorePermissions $permissionsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90561(StoreDirectories storeDirectories, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreGuilds storeGuilds) {
            super(0);
            this.$directoriesStore = storeDirectories;
            this.$directoryChannelId = j;
            this.$channelsStore = storeChannels;
            this.$guildScheduledEventsStore = storeGuildScheduledEvents;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$permissionsStore = storePermissions;
            this.$guildsStore = storeGuilds;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:27:0x00c7  */
        @Override // kotlin.jvm.functions.Function0
        public final WidgetHubEventsState invoke() {
            List<HubGuildScheduledEventData> listEmptyList;
            boolean z2;
            RestCallState<List<DirectoryEntryEvent>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(this.$directoryChannelId);
            if (guildScheduledEventsForChannel == null) {
                return WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
            }
            List<DirectoryEntryEvent> listInvoke = guildScheduledEventsForChannel.invoke();
            if (listInvoke != null) {
                listEmptyList = new ArrayList<>(C12149o.collectionSizeOrDefault(listInvoke, 10));
                for (DirectoryEntryEvent directoryEntryEvent : listInvoke) {
                    long guildId = directoryEntryEvent.getGuildScheduledEvent().getGuildId();
                    Long channelId = directoryEntryEvent.getGuildScheduledEvent().getChannelId();
                    long j = this.$directoryChannelId;
                    GuildScheduledEvent guildScheduledEvent = directoryEntryEvent.getGuildScheduledEvent();
                    Channel channel = channelId != null ? this.$channelsStore.getChannel(channelId.longValue()) : null;
                    boolean zContains = this.$guildScheduledEventsStore.getMeGuildScheduledEventIds(guildId).contains(Long.valueOf(directoryEntryEvent.getGuildScheduledEvent().getId()));
                    GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
                    boolean zCanStartEvent$default = GuildScheduledEventUtilities.Companion.canStartEvent$default(companion, guildId, channelId, null, null, 12, null);
                    boolean zCanShareEvent = companion.canShareEvent(channelId, guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null);
                    Long lValueOf = Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId());
                    if (!(lValueOf.longValue() != 0)) {
                        lValueOf = null;
                    }
                    if (lValueOf != null) {
                        long jLongValue = lValueOf.longValue();
                        if (channelId != null && jLongValue == channelId.longValue()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    listEmptyList.add(new HubGuildScheduledEventData(j, guildScheduledEvent, channel, zContains, zCanShareEvent, zCanStartEvent$default, channelId != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue()))) : false, z2, this.$guildsStore.getGuild(guildId) != null));
                }
            } else {
                WidgetHubEventsState widgetHubEventsStateAccess$getViewState$p = WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
                List<HubGuildScheduledEventData> eventsData = widgetHubEventsStateAccess$getViewState$p != null ? widgetHubEventsStateAccess$getViewState$p.getEventsData() : null;
                listEmptyList = eventsData != null ? eventsData : C12147n.emptyList();
            }
            return new WidgetHubEventsState(!this.$directoriesStore.getGuildScheduledEventsHeaderDismissed(), listEmptyList, guildScheduledEventsForChannel);
        }
    }

    public /* synthetic */ WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 128) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 256) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ WidgetHubEventsState access$getViewState$p(WidgetHubEventsViewModel widgetHubEventsViewModel) {
        return widgetHubEventsViewModel.getViewState();
    }

    private final Observable<WidgetHubEventsState> getObservableFromStores(ObservationDeck observationDeck, StoreDirectories directoriesStore, StoreGuilds guildsStore, StoreChannels channelsStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, long directoryChannelId) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{directoriesStore, guildsStore, channelsStore, voiceChannelSelectedStore, guildScheduledEventsStore, permissionsStore}, false, null, null, new C90561(directoriesStore, directoryChannelId, channelsStore, guildScheduledEventsStore, voiceChannelSelectedStore, permissionsStore, guildsStore), 14, null);
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
        C12238m.checkNotNull(viewState);
        updateViewState(WidgetHubEventsState.copy$default(viewState, false, null, Default.INSTANCE, 3, null));
    }

    public final void toggleRsvp(GuildScheduledEvent event) {
        C12238m.checkNotNullParameter(event, "event");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck) {
        super(new WidgetHubEventsState(false, null, null, 7, null));
        C12238m.checkNotNullParameter(storeDirectories, "directoriesStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.directoryChannelId = j2;
        this.directoriesStore = storeDirectories;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        Observable observableM11083G = ObservableExtensionsKt.computationLatest(getObservableFromStores(observationDeck, storeDirectories, storeGuilds, storeChannels, storeVoiceChannelSelected, storeGuildScheduledEvents, storePermissions, j2)).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11083G, this, null, 2, null), (Class<?>) WidgetHubEventsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90551(this));
        fetchGuildScheduledEvents();
    }
}
