package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel extends d0<GuildScheduledEventDetailsViewModel$ViewState> {
    public static final GuildScheduledEventDetailsViewModel$Companion Companion = new GuildScheduledEventDetailsViewModel$Companion(null);
    private final GuildScheduledEventDetailsArgs args;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private EventDetailsRsvpUsersFetchState rsvpUsersFetchState;
    private EventDetailsSection section;
    private int segmentControlIndex;
    private final StoreUser userStore;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildScheduledEventDetailsViewModel(GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable observable, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i2 & 2) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreGuildScheduledEvents guildScheduledEvents = (i2 & 4) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreGuilds guilds = (i2 & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreUser users = (i2 & 16) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreChannels channels = (i2 & 32) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StorePermissions permissions = (i2 & 64) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreUserSettings userSettings = (i2 & 128) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i2 & 256) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreDirectories directories = (i2 & 512) != 0 ? StoreStream.Companion.getDirectories() : storeDirectories;
        this(guildScheduledEventDetailsArgs, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories, (i2 & 1024) != 0 ? GuildScheduledEventDetailsViewModel$Companion.access$observeStores(Companion, guildScheduledEventDetailsArgs, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories) : observable, (i2 & 2048) != 0 ? EventDetailsSection.EVENT_INFO : eventDetailsSection, (i2 & 4096) != 0 ? EventDetailsRsvpUsersFetchState.LOADING : eventDetailsRsvpUsersFetchState, (i2 & 8192) != 0 ? 0 : i);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, GuildScheduledEventDetailsViewModel$StoreState guildScheduledEventDetailsViewModel$StoreState) {
        guildScheduledEventDetailsViewModel.handleStoreState(guildScheduledEventDetailsViewModel$StoreState);
    }

    private final EventDetailsRsvpUsersFetchState getRsvpUsersFetchState(GuildScheduledEventDetailsViewModel$StoreState storeState) {
        if (storeState.isRsvpUsersFetching() && storeState.getRsvpUsers().isEmpty()) {
            return EventDetailsRsvpUsersFetchState.LOADING;
        }
        if (storeState.isRsvpUsersError()) {
            return EventDetailsRsvpUsersFetchState.ERROR;
        }
        return storeState.getRsvpUsers().isEmpty() ? EventDetailsRsvpUsersFetchState.EMPTY : EventDetailsRsvpUsersFetchState.SUCCESS;
    }

    private final void handleStoreState(GuildScheduledEventDetailsViewModel$StoreState storeState) {
        GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState$Initialized;
        boolean z2;
        if (storeState.getGuildScheduledEvent() == null || storeState.getGuild() == null) {
            guildScheduledEventDetailsViewModel$ViewState$Initialized = GuildScheduledEventDetailsViewModel$ViewState$Invalid.INSTANCE;
        } else {
            if (getViewState() == null) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUserCounts(storeState.getGuild().getId());
            }
            GuildScheduledEventLocationInfo guildScheduledEventLocationInfoBuildLocationInfo = (this.args.getSource() == GuildScheduledEventDetailsSource.Guild || storeState.getGuildScheduledEvent().getEntityType() == GuildScheduledEventEntityType.EXTERNAL || storeState.isInGuild()) ? GuildScheduledEventLocationInfo.Companion.buildLocationInfo(storeState.getGuildScheduledEvent(), storeState.getChannel()) : null;
            this.rsvpUsersFetchState = getRsvpUsersFetchState(storeState);
            GuildScheduledEvent guildScheduledEvent = storeState.getGuildScheduledEvent();
            Guild guild = storeState.getGuild();
            Channel channel = storeState.getChannel();
            boolean zIsInGuild = storeState.isInGuild();
            boolean zIsRsvped = storeState.isRsvped();
            Long channelId = storeState.getGuildScheduledEvent().getChannelId();
            boolean z3 = false;
            if (channelId != null) {
                long jLongValue = channelId.longValue();
                Long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
                if (selectedVoiceChannelId != null && jLongValue == selectedVoiceChannelId.longValue()) {
                    z3 = true;
                }
                z2 = z3;
            } else {
                z2 = false;
            }
            guildScheduledEventDetailsViewModel$ViewState$Initialized = new GuildScheduledEventDetailsViewModel$ViewState$Initialized(guildScheduledEvent, guildScheduledEventLocationInfoBuildLocationInfo, guild, channel, zIsInGuild, zIsRsvped, storeState.getCanShare(), z2, storeState.getCanStartEvent(), storeState.isDeveloperMode(), storeState.getCanConnect(), storeState.getRsvpUsers(), this.section, this.rsvpUsersFetchState, this.segmentControlIndex, storeState.getCreator());
        }
        updateViewState(guildScheduledEventDetailsViewModel$ViewState$Initialized);
    }

    public final void endEventClicked(Context context, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        GuildScheduledEventDetailsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventDetailsViewModel$ViewState$Initialized != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.endEvent(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getGuildId(), guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getId()), false, 1, null), GuildScheduledEventDetailsViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDetailsViewModel$endEventClicked$$inlined$let$lambda$1(this, context, onSuccess), 60, (Object) null);
        }
    }

    public final void onDeleteButtonClicked(Context context, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        GuildScheduledEventDetailsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventDetailsViewModel$ViewState$Initialized != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteGuildScheduledEvent(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getGuildId(), guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getId()), false, 1, null), GuildScheduledEventDetailsViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDetailsViewModel$onDeleteButtonClicked$$inlined$let$lambda$1(this, context, onSuccess), 60, (Object) null);
        }
    }

    public final void onGuildNameClicked() {
        GuildScheduledEventDetailsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventDetailsViewModel$ViewState$Initialized != null) {
            StoreStream.Companion.getGuildSelected().set(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuild().getId());
        }
    }

    public final void onRsvpButtonClicked() {
        GuildScheduledEventDetailsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventDetailsViewModel$ViewState$Initialized != null) {
            this.guildScheduledEventsStore.toggleMeRsvpForEvent(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent());
        }
    }

    public final void onShareButtonClicked(WeakReference<Fragment> weakFragment) {
        m.checkNotNullParameter(weakFragment, "weakFragment");
        GuildScheduledEventDetailsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventDetailsViewModel$ViewState$Initialized != null) {
            Long channelId = guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getChannelId();
            long guildId = guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getGuildId();
            long id2 = guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getId();
            GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion = GuildScheduledEventUtilities.Companion;
            boolean zCanShareEvent$default = GuildScheduledEventUtilities$Companion.canShareEvent$default(guildScheduledEventUtilities$Companion, channelId, guildId, null, null, null, null, 60, null);
            Fragment fragment = weakFragment.get();
            if (fragment != null) {
                m.checkNotNullExpressionValue(fragment, "weakFragment.get() ?: return");
                guildScheduledEventUtilities$Companion.launchInvite(zCanShareEvent$default, fragment, guildId, guildScheduledEventDetailsViewModel$ViewState$Initialized.getChannel(), id2);
            }
        }
    }

    public final void setSegmentedControlIndex(int index) {
        if (this.segmentControlIndex == index) {
            return;
        }
        GuildScheduledEventDetailsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventDetailsViewModel$ViewState$Initialized != null) {
            this.segmentControlIndex = index;
            EventDetailsSection eventDetailsSection = index == 0 ? EventDetailsSection.EVENT_INFO : EventDetailsSection.RSVP_LIST;
            this.section = eventDetailsSection;
            if (eventDetailsSection == EventDetailsSection.RSVP_LIST) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUsers(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getGuildId(), guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent().getId());
                if (guildScheduledEventDetailsViewModel$ViewState$Initialized.getRsvpUsers().isEmpty()) {
                    this.rsvpUsersFetchState = EventDetailsRsvpUsersFetchState.LOADING;
                }
            }
            updateViewState(GuildScheduledEventDetailsViewModel$ViewState$Initialized.copy$default(guildScheduledEventDetailsViewModel$ViewState$Initialized, null, null, null, null, false, false, false, false, false, false, false, null, this.section, this.rsvpUsersFetchState, this.segmentControlIndex, null, 36863, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel(GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable<GuildScheduledEventDetailsViewModel$StoreState> observable, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i) {
        super(null, 1, null);
        m.checkNotNullParameter(guildScheduledEventDetailsArgs, "args");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(eventDetailsSection, "section");
        m.checkNotNullParameter(eventDetailsRsvpUsersFetchState, "rsvpUsersFetchState");
        this.args = guildScheduledEventDetailsArgs;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.userStore = storeUser;
        this.section = eventDetailsSection;
        this.rsvpUsersFetchState = eventDetailsRsvpUsersFetchState;
        this.segmentControlIndex = i;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildScheduledEventDetailsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDetailsViewModel$1(this), 62, (Object) null);
    }
}
