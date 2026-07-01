package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListViewModel extends d0<GuildScheduledEventListViewModel$ViewState> {
    public static final GuildScheduledEventListViewModel$Companion Companion = new GuildScheduledEventListViewModel$Companion(null);
    private final Long channelId;
    private final StoreChannels channelsStore;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildScheduledEventListViewModel(long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreChannels channels = (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 64) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUser users = (i & 128) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        this(j, l, guildScheduledEvents, channels, permissions, guilds, voiceChannelSelected, users, (i & 256) != 0 ? GuildScheduledEventListViewModel$Companion.access$observeStores(Companion, j, l, guildScheduledEvents, channels, permissions, guilds, voiceChannelSelected, users) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildScheduledEventListViewModel guildScheduledEventListViewModel, GuildScheduledEventListViewModel$StoreState guildScheduledEventListViewModel$StoreState) {
        guildScheduledEventListViewModel.handleStoreState(guildScheduledEventListViewModel$StoreState);
    }

    private final void handleStoreState(GuildScheduledEventListViewModel$StoreState storeState) {
        boolean z2;
        if (!(getViewState() instanceof GuildScheduledEventListViewModel$ViewState$Loaded)) {
            AnalyticsTracker.INSTANCE.openGuildScheduledEventSheet(this.guildId, storeState.getGuildScheduledEvents().size());
        }
        List<GuildScheduledEvent> guildScheduledEvents = storeState.getGuildScheduledEvents();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(guildScheduledEvents, 10));
        for (GuildScheduledEvent guildScheduledEvent : guildScheduledEvents) {
            Long channelId = guildScheduledEvent.getChannelId();
            Channel channel = channelId != null ? storeState.getGuildChannels().get(Long.valueOf(channelId.longValue())) : null;
            Long creatorId = guildScheduledEvent.getCreatorId();
            UserGuildMember userGuildMember = creatorId != null ? storeState.getCreators().get(Long.valueOf(creatorId.longValue())) : null;
            boolean zContains = storeState.getUserGuildScheduledEventIds().contains(Long.valueOf(guildScheduledEvent.getId()));
            GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion = GuildScheduledEventUtilities.Companion;
            boolean zCanStartEvent$default = GuildScheduledEventUtilities$Companion.canStartEvent$default(guildScheduledEventUtilities$Companion, this.guildId, channel != null ? Long.valueOf(channel.getId()) : null, null, null, 12, null);
            boolean zCanShareEvent$default = GuildScheduledEventUtilities$Companion.canShareEvent$default(guildScheduledEventUtilities$Companion, channel != null ? Long.valueOf(channel.getId()) : null, this.guildId, null, null, null, null, 60, null);
            Long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
            if (selectedVoiceChannelId != null) {
                long jLongValue = selectedVoiceChannelId.longValue();
                Long channelId2 = guildScheduledEvent.getChannelId();
                z2 = channelId2 != null && jLongValue == channelId2.longValue();
            } else {
                z2 = false;
            }
            Long channelId3 = guildScheduledEvent.getChannelId();
            arrayList.add(new GuildScheduledEventListItem$Event(guildScheduledEvent, channel, userGuildMember, zContains, zCanStartEvent$default, zCanShareEvent$default, z2, channelId3 != null ? PermissionUtils.can(Permission.CONNECT, storeState.getChannelPermissions().get(Long.valueOf(channelId3.longValue()))) : false));
        }
        updateViewState(new GuildScheduledEventListViewModel$ViewState$Loaded(arrayList, storeState.getCanCreateEvents()));
    }

    public final void onShareClicked(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<Fragment> weakFragment) {
        Channel channel;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(weakContext, "weakContext");
        m.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent$default = GuildScheduledEventUtilities$Companion.canShareEvent$default(GuildScheduledEventUtilities.Companion, channelId, guildId, null, null, null, null, 60, null);
        if (channelId != null) {
            channel = this.channelsStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent$default) {
            Observable<Channel> observableZ = StoreStream.Companion.getChannels().observeDefaultChannel(guildId).z();
            m.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, GuildScheduledEventListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventListViewModel$onShareClicked$1(weakFragment, channel, id2), 62, (Object) null);
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                m.checkNotNullExpressionValue(context, "context");
                b.a.d.m.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    public final void toggleRsvp(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(guildScheduledEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventListViewModel(long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser, Observable<GuildScheduledEventListViewModel$StoreState> observable) {
        super(GuildScheduledEventListViewModel$ViewState$Initial.INSTANCE);
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = l;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.channelsStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.guildsStore = storeGuilds;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.userStore = storeUser;
        storeGuildScheduledEvents.fetchGuildScheduledEventUserCounts(j);
        storeGuildScheduledEvents.fetchMeGuildScheduledEvents(j);
        storeGuildScheduledEvents.ackGuildEvents(j);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildScheduledEventListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventListViewModel$1(this), 62, (Object) null);
    }
}
