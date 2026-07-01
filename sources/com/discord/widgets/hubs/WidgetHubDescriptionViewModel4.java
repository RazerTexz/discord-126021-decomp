package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel4 extends Lambda implements Function0<WidgetHubDescriptionViewModel3> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel4(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$channelStore = storeChannels;
        this.$channelId = j;
        this.$guildStore = storeGuilds;
        this.$guildId = j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel3 invoke() {
        Channel channel = this.$channelStore.getChannel(this.$channelId);
        Guild guild = this.$guildStore.getGuild(this.$guildId);
        String name = guild != null ? guild.getName() : null;
        if (name == null) {
            name = "";
        }
        return new WidgetHubDescriptionViewModel3(channel, null, name, null, 10, null);
    }
}
