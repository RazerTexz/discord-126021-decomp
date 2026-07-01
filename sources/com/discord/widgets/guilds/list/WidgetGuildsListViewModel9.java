package com.discord.widgets.guilds.list;

import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel9 extends Lambda implements Function1<StoreGuildsSorted.Entry.SingletonGuild, GuildListItem.GuildItem> {
    public final /* synthetic */ HashMap $mentionCountsByGuild;
    public final /* synthetic */ WidgetGuildsListViewModel.StoreState $storeState;
    public final /* synthetic */ WidgetGuildsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel9(WidgetGuildsListViewModel widgetGuildsListViewModel, WidgetGuildsListViewModel.StoreState storeState, HashMap map) {
        super(1);
        this.this$0 = widgetGuildsListViewModel;
        this.$storeState = storeState;
        this.$mentionCountsByGuild = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final GuildListItem.GuildItem invoke(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        Intrinsics3.checkNotNullParameter(singletonGuild, "folder");
        WidgetGuildsListViewModel widgetGuildsListViewModel = this.this$0;
        Guild guild = singletonGuild.getGuild();
        long selectedGuildId = this.$storeState.getSelectedGuildId();
        long selectedVoiceChannelId = this.$storeState.getSelectedVoiceChannelId();
        Set<Long> unreadGuildIds = this.$storeState.getUnreadGuildIds();
        Map<Long, ModelNotificationSettings> guildSettings = this.$storeState.getGuildSettings();
        Integer num = (Integer) this.$mentionCountsByGuild.get(Long.valueOf(singletonGuild.getGuild().getId()));
        if (num == null) {
            num = 0;
        }
        Intrinsics3.checkNotNullExpressionValue(num, "mentionCountsByGuild[folder.guild.id] ?: 0");
        int iIntValue = num.intValue();
        Map<Long, List<Long>> channelIds = this.$storeState.getChannelIds();
        Map<Long, Channel> channels = this.$storeState.getChannels();
        Set<Long> lurkingGuildIds = this.$storeState.getLurkingGuildIds();
        Set<Long> guildIdsWithActiveStageEvents = this.$storeState.getGuildIdsWithActiveStageEvents();
        Set<Long> guildIdsWithActiveScheduledEvents = this.$storeState.getGuildIdsWithActiveScheduledEvents();
        Map<Long, Long> allChannelPermissions = this.$storeState.getAllChannelPermissions();
        GuildJoinRequest guildJoinRequest = this.$storeState.getGuildJoinRequests().get(Long.valueOf(singletonGuild.getGuild().getId()));
        return WidgetGuildsListViewModel.createGuildItem$default(widgetGuildsListViewModel, guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, iIntValue, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, null, null, null, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, false, 65536, null);
    }
}
