package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.permissions.PermissionUtils;
import d0.f0.q;
import d0.t.u;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel$Companion$observeStores$1 extends o implements Function0<GuildScheduledEventDetailsViewModel$StoreState> {
    public final /* synthetic */ GuildScheduledEventDetailsArgs $args;
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ StoreDirectories $directoriesStore;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceChannelSelected $selectedVoiceChannelStore;
    public final /* synthetic */ StoreUserSettings $userSettingsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel$Companion$observeStores$1(GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, StoreDirectories storeDirectories, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreUserSettings storeUserSettings) {
        super(0);
        this.$args = guildScheduledEventDetailsArgs;
        this.$directoriesStore = storeDirectories;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$guildsStore = storeGuilds;
        this.$channelsStore = storeChannels;
        this.$selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.$permissionsStore = storePermissions;
        this.$userSettingsStore = storeUserSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDetailsViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:37:0x0099  */
    /* JADX WARN: Code duplicated, block: B:38:0x009b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:54:0x0149  */
    /* JADX WARN: Code duplicated, block: B:55:0x0167  */
    /* JADX WARN: Code duplicated, block: B:58:0x0182  */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDetailsViewModel$StoreState invoke() {
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default;
        GuildScheduledEvent guildScheduledEvent;
        int iOrdinal;
        Guild guild;
        boolean z2;
        UserGuildMember creatorUserGuildMember$default;
        UserGuildMember userGuildMember;
        Long channelId;
        boolean zCan;
        com.discord.api.guild.Guild guild2;
        List<DirectoryEntryEvent> listInvoke;
        Object next;
        int iOrdinal2 = this.$args.getSource().ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            Long channelId2 = this.$args.getChannelId();
            if (channelId2 != null) {
                RestCallState<List<DirectoryEntryEvent>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(channelId2.longValue());
                if (guildScheduledEventsForChannel == null || (listInvoke = guildScheduledEventsForChannel.invoke()) == null) {
                    guildScheduledEventFindEventFromStore$default = null;
                } else {
                    Iterator<T> it = listInvoke.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!(((DirectoryEntryEvent) next).getGuildScheduledEvent().getId() == this.$args.getEventId()));
                    DirectoryEntryEvent directoryEntryEvent = (DirectoryEntryEvent) next;
                    if (directoryEntryEvent != null) {
                        guildScheduledEventFindEventFromStore$default = directoryEntryEvent.getGuildScheduledEvent();
                    } else {
                        guildScheduledEventFindEventFromStore$default = null;
                    }
                }
            } else {
                guildScheduledEvent = null;
            }
            if (guildScheduledEvent != null) {
                return new GuildScheduledEventDetailsViewModel$StoreState(null, null, null, null, false, false, false, false, false, null, false, null, false, false, 16383, null);
            }
            iOrdinal = this.$args.getSource().ordinal();
            if (iOrdinal != 0) {
                guild = this.$guildsStore.getGuild(guildScheduledEvent.getGuildId());
            } else {
                if (iOrdinal == 1) {
                    throw new NoWhenBranchMatchedException();
                }
                guild2 = guildScheduledEvent.getGuild();
                if (guild2 != null) {
                    guild = new Guild(guild2);
                } else {
                    guild = null;
                }
            }
            if (this.$guildsStore.getGuild(guildScheduledEvent.getGuildId()) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            creatorUserGuildMember$default = GuildScheduledEventUtilitiesKt.getCreatorUserGuildMember$default(guildScheduledEvent, (StoreGuilds) null, (StoreUser) null, 3, (Object) null);
            if (z2) {
                userGuildMember = creatorUserGuildMember$default;
            } else {
                userGuildMember = null;
            }
            List list = q.toList(q.map(u.asSequence(this.$guildScheduledEventsStore.getGuildScheduledEventUsers(guildScheduledEvent.getId()).values()), new GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1(guildScheduledEvent)));
            Long channelId3 = guildScheduledEvent.getChannelId();
            Channel channel = channelId3 != null ? this.$channelsStore.getChannel(channelId3.longValue()) : null;
            Long lValueOf = Long.valueOf(this.$selectedVoiceChannelStore.getSelectedVoiceChannelId());
            boolean zIsMeRsvpedToEvent = this.$guildScheduledEventsStore.isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), this.$args.getEventId());
            GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion = GuildScheduledEventUtilities.Companion;
            boolean zCanShareEvent$default = GuildScheduledEventUtilities$Companion.canShareEvent$default(guildScheduledEventUtilities$Companion, guildScheduledEvent.getChannelId(), guildScheduledEvent.getGuildId(), this.$channelsStore, this.$guildsStore, null, null, 48, null);
            boolean zCanStartEvent = guildScheduledEventUtilities$Companion.canStartEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getChannelId(), this.$channelsStore, this.$permissionsStore);
            channelId = guildScheduledEvent.getChannelId();
            if (channelId != null) {
                zCan = PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue())));
            } else {
                zCan = false;
            }
            return new GuildScheduledEventDetailsViewModel$StoreState(guildScheduledEvent, channel, guild, userGuildMember, z2, zIsMeRsvpedToEvent, zCanShareEvent$default, zCanStartEvent, this.$userSettingsStore.getIsDeveloperMode(), lValueOf, zCan, list, this.$guildScheduledEventsStore.getIsFetchingGuildScheduledEventUsers(), this.$guildScheduledEventsStore.getIsGuildScheduledEventUsersError());
        }
        guildScheduledEventFindEventFromStore$default = StoreGuildScheduledEvents.findEventFromStore$default(this.$guildScheduledEventsStore, this.$args.getEventId(), null, 2, null);
        guildScheduledEvent = guildScheduledEventFindEventFromStore$default;
        if (guildScheduledEvent != null) {
            return new GuildScheduledEventDetailsViewModel$StoreState(null, null, null, null, false, false, false, false, false, null, false, null, false, false, 16383, null);
        }
        iOrdinal = this.$args.getSource().ordinal();
        if (iOrdinal != 0) {
            guild = this.$guildsStore.getGuild(guildScheduledEvent.getGuildId());
        } else {
            if (iOrdinal == 1) {
                throw new NoWhenBranchMatchedException();
            }
            guild2 = guildScheduledEvent.getGuild();
            if (guild2 != null) {
                guild = new Guild(guild2);
            } else {
                guild = null;
            }
        }
        if (this.$guildsStore.getGuild(guildScheduledEvent.getGuildId()) != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        creatorUserGuildMember$default = GuildScheduledEventUtilitiesKt.getCreatorUserGuildMember$default(guildScheduledEvent, (StoreGuilds) null, (StoreUser) null, 3, (Object) null);
        if (z2) {
            userGuildMember = creatorUserGuildMember$default;
        } else {
            userGuildMember = null;
        }
        List list2 = q.toList(q.map(u.asSequence(this.$guildScheduledEventsStore.getGuildScheduledEventUsers(guildScheduledEvent.getId()).values()), new GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1(guildScheduledEvent)));
        Long channelId4 = guildScheduledEvent.getChannelId();
        Channel channel2 = channelId4 != null ? this.$channelsStore.getChannel(channelId4.longValue()) : null;
        Long lValueOf2 = Long.valueOf(this.$selectedVoiceChannelStore.getSelectedVoiceChannelId());
        boolean zIsMeRsvpedToEvent2 = this.$guildScheduledEventsStore.isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), this.$args.getEventId());
        GuildScheduledEventUtilities$Companion guildScheduledEventUtilities$Companion2 = GuildScheduledEventUtilities.Companion;
        boolean zCanShareEvent$default2 = GuildScheduledEventUtilities$Companion.canShareEvent$default(guildScheduledEventUtilities$Companion2, guildScheduledEvent.getChannelId(), guildScheduledEvent.getGuildId(), this.$channelsStore, this.$guildsStore, null, null, 48, null);
        boolean zCanStartEvent2 = guildScheduledEventUtilities$Companion2.canStartEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getChannelId(), this.$channelsStore, this.$permissionsStore);
        channelId = guildScheduledEvent.getChannelId();
        if (channelId != null) {
            zCan = PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue())));
        } else {
            zCan = false;
        }
        return new GuildScheduledEventDetailsViewModel$StoreState(guildScheduledEvent, channel2, guild, userGuildMember, z2, zIsMeRsvpedToEvent2, zCanShareEvent$default2, zCanStartEvent2, this.$userSettingsStore.getIsDeveloperMode(), lValueOf2, zCan, list2, this.$guildScheduledEventsStore.getIsFetchingGuildScheduledEventUsers(), this.$guildScheduledEventsStore.getIsGuildScheduledEventUsersError());
    }
}
