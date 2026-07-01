package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel$Companion$observeStores$1 extends o implements Function0<HubDescriptionState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel$Companion$observeStores$1(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$channelStore = storeChannels;
        this.$channelId = j;
        this.$guildStore = storeGuilds;
        this.$guildId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HubDescriptionState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HubDescriptionState invoke() {
        Channel channel = this.$channelStore.getChannel(this.$channelId);
        Guild guild = this.$guildStore.getGuild(this.$guildId);
        String name = guild != null ? guild.getName() : null;
        if (name == null) {
            name = "";
        }
        return new HubDescriptionState(channel, null, name, null, 10, null);
    }
}
