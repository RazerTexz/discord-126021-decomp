package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import com.discord.widgets.chat.list.entries.InviteEntry;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$observeModel$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite4 extends Lambda implements Function0<WidgetChatListAdapterItemInvite.Model> {
    public final /* synthetic */ StoreAccessibility $accessibilityStore;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ InviteEntry $item;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite4(StoreUser storeUser, InviteEntry inviteEntry, ModelInvite modelInvite, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreAccessibility storeAccessibility) {
        super(0);
        this.$userStore = storeUser;
        this.$item = inviteEntry;
        this.$invite = modelInvite;
        this.$guildStore = storeGuilds;
        this.$channelStore = storeChannels;
        this.$accessibilityStore = storeAccessibility;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChatListAdapterItemInvite.Model invoke() {
        Guild guild;
        Channel channel;
        long id2 = this.$userStore.getMeSnapshot().getId();
        User user = this.$userStore.getUsers().get(Long.valueOf(this.$item.getUserId()));
        com.discord.api.guild.Guild guild2 = this.$invite.guild;
        if (guild2 != null) {
            guild = this.$guildStore.getGuilds().get(Long.valueOf(guild2.getId()));
        } else {
            guild = null;
        }
        boolean z2 = guild != null;
        Channel channel2 = this.$invite.getChannel();
        if (channel2 != null) {
            channel = this.$channelStore.getChannel(channel2.getId());
        } else {
            channel = null;
        }
        return (this.$invite.getExpirationTime() >= ClockFactory.get().currentTimeMillis() || this.$invite.isRevoked()) ? new WidgetChatListAdapterItemInvite.Model.Invalid(user, id2, channel) : new WidgetChatListAdapterItemInvite.Model.Resolved(this.$invite, id2, user, z2, channel, !this.$accessibilityStore.getReducedMotionEnabled());
    }
}
