package com.discord.widgets.hubs.events;

import b.a.d.AppViewModel;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild2;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsViewModel extends AppViewModel<WidgetHubEventsViewModel3> {
    private final StoreDirectories directoriesStore;
    private final long directoryChannelId;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubEventsViewModel3, Unit> {
        public AnonymousClass1(WidgetHubEventsViewModel widgetHubEventsViewModel) {
            super(1, widgetHubEventsViewModel, WidgetHubEventsViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            invoke2(widgetHubEventsViewModel3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel3, "p1");
            ((WidgetHubEventsViewModel) this.receiver).updateViewState(widgetHubEventsViewModel3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$getObservableFromStores$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<WidgetHubEventsViewModel3> {
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ StoreDirectories $directoriesStore;
        public final /* synthetic */ long $directoryChannelId;
        public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ StorePermissions $permissionsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreDirectories storeDirectories, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreGuilds storeGuilds) {
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
        public final WidgetHubEventsViewModel3 invoke() {
            List<WidgetHubEventsViewModel2> listEmptyList;
            boolean z2;
            RestCallState<List<DirectoryEntryGuild2>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(this.$directoryChannelId);
            if (guildScheduledEventsForChannel == null) {
                return WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
            }
            List<DirectoryEntryGuild2> listInvoke = guildScheduledEventsForChannel.invoke();
            if (listInvoke != null) {
                listEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listInvoke, 10));
                for (DirectoryEntryGuild2 directoryEntryGuild2 : listInvoke) {
                    long guildId = directoryEntryGuild2.getGuildScheduledEvent().getGuildId();
                    Long channelId = directoryEntryGuild2.getGuildScheduledEvent().getChannelId();
                    long j = this.$directoryChannelId;
                    GuildScheduledEvent guildScheduledEvent = directoryEntryGuild2.getGuildScheduledEvent();
                    Channel channel = channelId != null ? this.$channelsStore.getChannel(channelId.longValue()) : null;
                    boolean zContains = this.$guildScheduledEventsStore.getMeGuildScheduledEventIds(guildId).contains(Long.valueOf(directoryEntryGuild2.getGuildScheduledEvent().getId()));
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
                    listEmptyList.add(new WidgetHubEventsViewModel2(j, guildScheduledEvent, channel, zContains, zCanShareEvent, zCanStartEvent$default, channelId != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue()))) : false, z2, this.$guildsStore.getGuild(guildId) != null));
                }
            } else {
                WidgetHubEventsViewModel3 widgetHubEventsViewModel3Access$getViewState$p = WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
                List<WidgetHubEventsViewModel2> eventsData = widgetHubEventsViewModel3Access$getViewState$p != null ? widgetHubEventsViewModel3Access$getViewState$p.getEventsData() : null;
                listEmptyList = eventsData != null ? eventsData : Collections2.emptyList();
            }
            return new WidgetHubEventsViewModel3(!this.$directoriesStore.getGuildScheduledEventsHeaderDismissed(), listEmptyList, guildScheduledEventsForChannel);
        }
    }

    public /* synthetic */ WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 128) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 256) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ WidgetHubEventsViewModel3 access$getViewState$p(WidgetHubEventsViewModel widgetHubEventsViewModel) {
        return widgetHubEventsViewModel.getViewState();
    }

    private final Observable<WidgetHubEventsViewModel3> getObservableFromStores(ObservationDeck observationDeck, StoreDirectories directoriesStore, StoreGuilds guildsStore, StoreChannels channelsStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, long directoryChannelId) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{directoriesStore, guildsStore, channelsStore, voiceChannelSelectedStore, guildScheduledEventsStore, permissionsStore}, false, null, null, new AnonymousClass1(directoriesStore, directoryChannelId, channelsStore, guildScheduledEventsStore, voiceChannelSelectedStore, permissionsStore, guildsStore), 14, null);
    }

    public final void dismissHeader() {
        WidgetHubEventsViewModel3 viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetHubEventsViewModel3.copy$default(viewState, false, null, null, 6, null));
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
        WidgetHubEventsViewModel3 viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        updateViewState(WidgetHubEventsViewModel3.copy$default(viewState, false, null, RestCallState2.INSTANCE, 3, null));
    }

    public final void toggleRsvp(GuildScheduledEvent event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck) {
        super(new WidgetHubEventsViewModel3(false, null, null, 7, null));
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.directoryChannelId = j2;
        this.directoriesStore = storeDirectories;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        Observable observableG = ObservableExtensionsKt.computationLatest(getObservableFromStores(observationDeck, storeDirectories, storeGuilds, storeChannels, storeVoiceChannelSelected, storeGuildScheduledEvents, storePermissions, j2)).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), (Class<?>) WidgetHubEventsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        fetchGuildScheduledEvents();
    }
}
