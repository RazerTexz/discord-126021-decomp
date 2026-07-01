package com.discord.utilities.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.voice.model.CallModel;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUtilities$Companion {
    private GuildScheduledEventUtilities$Companion() {
    }

    public static /* synthetic */ boolean canCreateAnyEvent$default(GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion, long j, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        if ((i & 4) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        return guildScheduledEventUtilities$Companion.canCreateAnyEvent(j, storeChannels, storePermissions);
    }

    public static /* synthetic */ boolean canShareEvent$default(GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion, Long l, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, int i, Object obj) {
        return guildScheduledEventUtilities$Companion.canShareEvent(l, j, (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.Companion.getPermissions() : storePermissions);
    }

    public static /* synthetic */ boolean canStartEvent$default(GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion, long j, Long l, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
        if ((i & 4) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 8) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        return guildScheduledEventUtilities$Companion.canStartEvent(j, l, storeChannels2, storePermissions);
    }

    private final List<Channel> getGuildScheduledEventCreatableChannelsForGuild(long guildId, StoreChannels channelsStore, StorePermissions permissionsStore) {
        Map<Long, Channel> channelsForGuild = channelsStore.getChannelsForGuild(guildId);
        Map<Long, Long> permissionsByChannel = permissionsStore.getPermissionsByChannel();
        Collection<Channel> collectionValues = channelsForGuild.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Channel channel = (Channel) obj;
            if (GuildScheduledEventUtilities.Companion.canStartEventInChannel(channel, (Long) a.d(channel, permissionsByChannel))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List getGuildScheduledEventCreatableChannelsForGuild$default(GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion, long j, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        if ((i & 4) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        return guildScheduledEventUtilities$Companion.getGuildScheduledEventCreatableChannelsForGuild(j, storeChannels, storePermissions);
    }

    public static /* synthetic */ GuildScheduledEvent getGuildScheduledEventToEndForCall$default(GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion, CallModel callModel, Long l, StoreGuilds storeGuilds, int i, Object obj) {
        if ((i & 4) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        return guildScheduledEventUtilities$Companion.getGuildScheduledEventToEndForCall(callModel, l, storeGuilds);
    }

    public static /* synthetic */ Observable observeCanCreateAnyEvent$default(GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
        if ((i & 2) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        ObservationDeck observationDeck2 = observationDeck;
        if ((i & 4) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 8) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        return guildScheduledEventUtilities$Companion.observeCanCreateAnyEvent(j, observationDeck2, storeChannels2, storePermissions);
    }

    public final boolean canCreateAnyEvent(long guildId, StoreChannels channelsStore, StorePermissions permissionsStore) {
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(permissionsStore, "permissionsStore");
        Long l = permissionsStore.getGuildPermissions().get(Long.valueOf(guildId));
        if (l == null) {
            return false;
        }
        if (PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue()))) {
            return true;
        }
        return !getGuildScheduledEventCreatableChannelsForGuild(guildId, channelsStore, permissionsStore).isEmpty();
    }

    public final boolean canCreateExternalEvent(Long guildPermissions) {
        return PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions);
    }

    public final boolean canShareEvent(Long channelId, long guildId, StoreChannels channelsStore, StoreGuilds guildsStore, StoreUser usersStore, StorePermissions permissionsStore) {
        GuildMember member;
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(guildsStore, "guildsStore");
        m.checkNotNullParameter(usersStore, "usersStore");
        m.checkNotNullParameter(permissionsStore, "permissionsStore");
        if (channelId == null) {
            return PermissionUtils.can(1L, permissionsStore.getGuildPermissions().get(Long.valueOf(guildId)));
        }
        Channel channel = channelsStore.getChannel(channelId.longValue());
        if (channel == null || !PermissionUtils.can(1L, permissionsStore.getPermissionsByChannel().get(channelId))) {
            return false;
        }
        PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
        Map<Long, GuildRole> mapEmptyMap = (Map) a.c(channel, guildsStore.getRoles());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        return (!permissionUtils.canEveryoneRole(Permission.VIEW_CHANNEL, channel, mapEmptyMap) || (member = guildsStore.getMember(channel.getGuildId(), usersStore.getMeSnapshot().getId())) == null || member.getPending()) ? false : true;
    }

    public final boolean canStartEvent(long guildId, Long channelId, StoreChannels channelsStore, StorePermissions permissionsStore) {
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(permissionsStore, "permissionsStore");
        if (channelId == null) {
            Long l = permissionsStore.getGuildPermissions().get(Long.valueOf(guildId));
            if (l != null) {
                return PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue()));
            }
            return false;
        }
        Channel channel = channelsStore.getChannel(channelId.longValue());
        Long l2 = permissionsStore.getPermissionsByChannel().get(channelId);
        if (channel == null) {
            return false;
        }
        return canStartEventInChannel(channel, l2);
    }

    public final boolean canStartEventInChannel(Channel channel, Long channelPermissions) {
        m.checkNotNullParameter(channel, "channel");
        if (!PermissionUtils.can(8589935616L, channelPermissions)) {
            return false;
        }
        if (ChannelUtils.D(channel)) {
            return PermissionUtils.can(Permission.START_STAGE_EVENT, channelPermissions);
        }
        if (ChannelUtils.J(channel)) {
            return PermissionUtils.can(Permission.START_VOICE_EVENT, channelPermissions);
        }
        return false;
    }

    public final GuildScheduledEvent getGuildScheduledEventToEndForCall(CallModel callModel, Long myPermissions, StoreGuilds guildsStore) {
        GuildScheduledEvent liveEvent;
        m.checkNotNullParameter(callModel, "callModel");
        m.checkNotNullParameter(guildsStore, "guildsStore");
        Channel channel = callModel.getChannel();
        Guild guild = guildsStore.getGuild(channel.getGuildId());
        if (guild == null || (liveEvent = GuildScheduledEventUtilitiesKt.getLiveEvent(callModel.getGuildScheduledEvents())) == null || !canStartEventInChannel(channel, myPermissions)) {
            return null;
        }
        Map map = (Map) a.e(guild, guildsStore.getRoles());
        for (Map$Entry<Long, StoreVoiceParticipants$VoiceUser> map$Entry : callModel.getParticipants().entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            if (!map$Entry.getValue().isMe() && !canStartEventInChannel(channel, Long.valueOf(PermissionUtils.computeNonThreadPermissions(jLongValue, guild.getId(), guild.getOwnerId(), map$Entry.getValue().getGuildMember(), map, channel.v())))) {
                return null;
            }
        }
        return liveEvent;
    }

    public final boolean isEventViewableByEveryone(Long channelId) {
        if (channelId == null) {
            return true;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Channel channel = storeStream$Companion.getChannels().getChannel(channelId.longValue());
        if (channel != null) {
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Map<Long, GuildRole> mapEmptyMap = (Map) a.c(channel, storeStream$Companion.getGuilds().getRoles());
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
            }
            if (permissionUtils.canEveryoneRole(Permission.VIEW_CHANNEL, channel, mapEmptyMap)) {
                return true;
            }
        }
        return false;
    }

    public final void launchInvite(boolean canShare, Fragment fragment, long guildId, Channel channel, long guildEventId) {
        m.checkNotNullParameter(fragment, "fragment");
        if (canShare) {
            Observable<Channel> observableZ = StoreStream.Companion.getChannels().observeDefaultChannel(guildId).z();
            m.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…dId)\n            .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, fragment.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventUtilities$Companion$launchInvite$1(fragment, channel, guildEventId), 62, (Object) null);
        } else {
            Context context = fragment.getContext();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, guildEventId);
                m.checkNotNullExpressionValue(context, "context");
                b.a.d.m.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    public final Observable<Boolean> observeCanCreateAnyEvent(long guildId, ObservationDeck observationDeck, StoreChannels channelsStore, StorePermissions permissionsStore) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(permissionsStore, "permissionsStore");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{channelsStore, permissionsStore}, false, null, null, new GuildScheduledEventUtilities$Companion$observeCanCreateAnyEvent$1(guildId, channelsStore, permissionsStore), 14, null);
    }

    public /* synthetic */ GuildScheduledEventUtilities$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
