package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildsSorted$Entry;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$6<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<WidgetGuildsListViewModel$Companion$Chunk, WidgetGuildsListViewModel$Companion$SecondChunk, Set<? extends Long>, Set<? extends Long>, Boolean, Map<Long, ? extends StreamContext>, Map<Long, ? extends Long>, Boolean, Boolean, WidgetGuildsListViewModel$StoreState> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$6 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$6();

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildsListViewModel$StoreState call(WidgetGuildsListViewModel$Companion$Chunk widgetGuildsListViewModel$Companion$Chunk, WidgetGuildsListViewModel$Companion$SecondChunk widgetGuildsListViewModel$Companion$SecondChunk, Set<? extends Long> set, Set<? extends Long> set2, Boolean bool, Map<Long, ? extends StreamContext> map, Map<Long, ? extends Long> map2, Boolean bool2, Boolean bool3) {
        return call2(widgetGuildsListViewModel$Companion$Chunk, widgetGuildsListViewModel$Companion$SecondChunk, (Set<Long>) set, (Set<Long>) set2, bool, (Map<Long, StreamContext>) map, (Map<Long, Long>) map2, bool2, bool3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListViewModel$StoreState call2(WidgetGuildsListViewModel$Companion$Chunk widgetGuildsListViewModel$Companion$Chunk, WidgetGuildsListViewModel$Companion$SecondChunk widgetGuildsListViewModel$Companion$SecondChunk, Set<Long> set, Set<Long> set2, Boolean bool, Map<Long, StreamContext> map, Map<Long, Long> map2, Boolean bool2, Boolean bool3) {
        long selectedGuildId = widgetGuildsListViewModel$Companion$Chunk.getSelectedGuildId();
        long selectedVoiceChannelId = widgetGuildsListViewModel$Companion$Chunk.getSelectedVoiceChannelId();
        Map<Long, ModelNotificationSettings> guildSettings = widgetGuildsListViewModel$Companion$Chunk.getGuildSettings();
        Set<Long> unreadGuildIds = widgetGuildsListViewModel$Companion$Chunk.getUnreadGuildIds();
        Map<Long, Integer> mentionCounts = widgetGuildsListViewModel$Companion$Chunk.getMentionCounts();
        Map<Long, List<Long>> channelIds = widgetGuildsListViewModel$Companion$Chunk.getChannelIds();
        Set<Long> unavailableGuilds = widgetGuildsListViewModel$Companion$Chunk.getUnavailableGuilds();
        Map<Long, Channel> privateChannels = widgetGuildsListViewModel$Companion$Chunk.getPrivateChannels();
        List<StoreGuildsSorted$Entry> sortedGuilds = widgetGuildsListViewModel$Companion$Chunk.getSortedGuilds();
        Map<Long, GuildJoinRequest> guildJoinRequests = widgetGuildsListViewModel$Companion$SecondChunk.getGuildJoinRequests();
        List<Guild> pendingGuilds = widgetGuildsListViewModel$Companion$SecondChunk.getPendingGuilds();
        Set<Long> guildIds = widgetGuildsListViewModel$Companion$SecondChunk.getGuildIds();
        m.checkNotNullExpressionValue(set, "lurkingGuildIds");
        Set<Long> guildIdsWithActiveStageEvents = widgetGuildsListViewModel$Companion$SecondChunk.getGuildIdsWithActiveStageEvents();
        Set<Long> guildIdsWithActiveScheduledEvents = widgetGuildsListViewModel$Companion$SecondChunk.getGuildIdsWithActiveScheduledEvents();
        Map<Long, Channel> channels = widgetGuildsListViewModel$Companion$SecondChunk.getChannels();
        m.checkNotNullExpressionValue(set2, "openFolderIds");
        m.checkNotNullExpressionValue(bool, "isNewUser");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(map, "allApplicationStreamContexts");
        m.checkNotNullExpressionValue(map2, "allChannelPermissions");
        m.checkNotNullExpressionValue(bool2, "isLeftPanelOpened");
        boolean zBooleanValue2 = bool2.booleanValue();
        m.checkNotNullExpressionValue(bool3, "isOnHomeTab");
        return new WidgetGuildsListViewModel$StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, set, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, set2, zBooleanValue, map, map2, zBooleanValue2, bool3.booleanValue(), widgetGuildsListViewModel$Companion$SecondChunk.getShowHubSparkle());
    }
}
