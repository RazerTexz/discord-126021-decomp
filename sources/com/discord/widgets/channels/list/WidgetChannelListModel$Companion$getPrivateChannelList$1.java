package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.Channel$Companion;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils$getSortByMostRecent$1;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserPresence;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getPrivateChannelList$1<T, R> implements b<Unit, WidgetChannelListModel> {
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreUserConnections $storeConnections;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StoreMentions $storeMentions;
    public final /* synthetic */ StoreMessagesMostRecent $storeMessagesMostRecent;
    public final /* synthetic */ StoreUserPresence $storePresences;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    public WidgetChannelListModel$Companion$getPrivateChannelList$1(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreChannelsSelected storeChannelsSelected, StoreUserPresence storeUserPresence, StoreMentions storeMentions, StoreApplicationStreaming storeApplicationStreaming, StoreUserGuildSettings storeUserGuildSettings, StoreExperiments storeExperiments, StoreUserConnections storeUserConnections) {
        this.$storeChannels = storeChannels;
        this.$storeMessagesMostRecent = storeMessagesMostRecent;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storePresences = storeUserPresence;
        this.$storeMentions = storeMentions;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeExperiments = storeExperiments;
        this.$storeConnections = storeUserConnections;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChannelListModel call(Unit unit) {
        return call2(unit);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelListModel call2(Unit unit) {
        Map<Long, Channel> channelsForGuild = this.$storeChannels.getChannelsForGuild(0L);
        Channel$Companion channel$Companion = Channel.Companion;
        Map<Long, Long> mostRecentIds = this.$storeMessagesMostRecent.getMostRecentIds();
        m.checkNotNullParameter(channel$Companion, "$this$getSortByMostRecent");
        m.checkNotNullParameter(mostRecentIds, "mostRecentMessageIds");
        ChannelUtils$getSortByMostRecent$1 channelUtils$getSortByMostRecent$1 = new ChannelUtils$getSortByMostRecent$1(mostRecentIds);
        long id2 = this.$storeChannelsSelected.getId();
        Map<Long, Presence> mapM19getPresences = this.$storePresences.m19getPresences();
        Map<Long, Integer> mentionCounts = this.$storeMentions.getMentionCounts();
        Map<Long, ModelApplicationStream> streamsByUser = this.$storeApplicationStreaming.getStreamsByUser();
        ModelNotificationSettings modelNotificationSettings = this.$storeUserGuildSettings.getGuildSettings().get(0L);
        if (modelNotificationSettings == null) {
            modelNotificationSettings = new ModelNotificationSettings();
        }
        this.$storeExperiments.getUserExperiment("2021-04_contact_sync_android_main", true);
        this.$storeConnections.getStateSnapshot();
        List listSortedWith = u.sortedWith(channelsForGuild.values(), channelUtils$getSortByMostRecent$1);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listSortedWith, 10));
        Iterator<T> it = listSortedWith.iterator();
        while (true) {
            if (!it.hasNext()) {
                return new WidgetChannelListModel(null, u.plus((Collection<? extends ChannelListBottomNavSpaceItem>) arrayList, new ChannelListBottomNavSpaceItem(0L, 1, null)), false, false, arrayList.isEmpty(), null, 44, null);
            }
            Channel channel = (Channel) it.next();
            User userA = ChannelUtils.a(channel);
            Presence presence = mapM19getPresences.get(userA != null ? Long.valueOf(userA.getId()) : null);
            boolean z2 = channel.getId() == id2;
            Integer num = (Integer) a.d(channel, mentionCounts);
            int iIntValue = num != null ? num.intValue() : 0;
            User userA2 = ChannelUtils.a(channel);
            boolean zContainsKey = streamsByUser.containsKey(userA2 != null ? Long.valueOf(userA2.getId()) : null);
            ModelNotificationSettings$ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getId());
            arrayList.add(new ChannelListItemPrivate(channel, presence, z2, iIntValue, zContainsKey, channelOverride != null ? channelOverride.isMuted() : false));
        }
    }
}
