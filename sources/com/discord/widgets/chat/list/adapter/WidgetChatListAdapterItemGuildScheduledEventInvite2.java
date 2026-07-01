package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion$observe$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite2 extends Lambda implements Function0<WidgetChatListAdapterItemGuildScheduledEventInvite.Model> {
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ GuildScheduledEventInviteEntry $item;
    public final /* synthetic */ StorePermissions $permissionStore;
    public final /* synthetic */ StoreUser $userStore;
    public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildScheduledEventInvite2(GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, StoreGuilds storeGuilds, StoreUser storeUser, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions) {
        super(0);
        this.$item = guildScheduledEventInviteEntry;
        this.$guildStore = storeGuilds;
        this.$userStore = storeUser;
        this.$guildScheduledEventStore = storeGuildScheduledEvents;
        this.$channelStore = storeChannels;
        this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.$permissionStore = storePermissions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChatListAdapterItemGuildScheduledEventInvite.Model invoke() {
        Channel channelA;
        Channel channel;
        boolean zCan;
        GuildScheduledEvent guildScheduledEvent = this.$item.getGuildScheduledEvent();
        Channel channel2 = this.$item.getInvite().getChannel();
        Guild guild = null;
        if (channel2 != null) {
            com.discord.api.guild.Guild guild2 = this.$item.getInvite().guild;
            channelA = Channel.a(channel2, null, 0, guild2 != null ? guild2.getId() : 0L, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5);
        } else {
            channelA = null;
        }
        UserGuildMember creatorUserGuildMember$default = GuildScheduledEventUtilities5.getCreatorUserGuildMember$default(guildScheduledEvent, (StoreGuilds) null, (StoreUser) null, 3, (Object) null);
        ModelInvite invite = this.$item.getInvite();
        boolean z2 = this.$guildStore.getMember(this.$item.getGuildScheduledEvent().getGuildId(), this.$userStore.getMeSnapshot().getId()) != null;
        boolean zIsMeRsvpedToEvent = this.$guildScheduledEventStore.isMeRsvpedToEvent(this.$item.getGuildScheduledEvent().getGuildId(), this.$item.getGuildScheduledEvent().getId());
        if (channelA != null) {
            channel = this.$channelStore.getChannel(channelA.getId());
        } else {
            channel = null;
        }
        Guild guild3 = this.$guildStore.getGuild(this.$item.getGuildScheduledEvent().getGuildId());
        if (guild3 != null) {
            guild = guild3;
        } else {
            com.discord.api.guild.Guild guild4 = this.$item.getInvite().guild;
            if (guild4 != null) {
                Intrinsics3.checkNotNullExpressionValue(guild4, "apiGuild");
                guild = new Guild(guild4);
            }
        }
        Long lValueOf = Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId());
        if (channelA != null) {
            zCan = PermissionUtils.can(Permission.CONNECT, this.$permissionStore.getPermissionsByChannel().get(Long.valueOf(channelA.getId())));
        } else {
            zCan = false;
        }
        return new WidgetChatListAdapterItemGuildScheduledEventInvite.Model(invite, z2, zIsMeRsvpedToEvent, guildScheduledEvent, channel, guild, creatorUserGuildMember$default, lValueOf, zCan, GuildScheduledEventUtilities.INSTANCE.canShareEvent(this.$item.getGuildScheduledEvent().getChannelId(), this.$item.getGuildScheduledEvent().getGuildId(), (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : this.$channelStore, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : this.$guildStore, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null));
    }
}
