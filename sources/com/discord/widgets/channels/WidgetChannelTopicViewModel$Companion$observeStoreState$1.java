package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetChannelTopicViewModel$StoreState>> {
    public final /* synthetic */ WidgetChannelTopicViewModel$Companion$NavState $navState;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;
    public final /* synthetic */ StoreUser $storeUsers;

    public WidgetChannelTopicViewModel$Companion$observeStoreState$1(WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings, StoreChannels storeChannels, StoreUser storeUser) {
        this.$navState = widgetChannelTopicViewModel$Companion$NavState;
        this.$storeGuilds = storeGuilds;
        this.$storeUserSettings = storeUserSettings;
        this.$storeChannels = storeChannels;
        this.$storeUsers = storeUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelTopicViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelTopicViewModel$StoreState> call2(Channel channel) {
        if (channel == null) {
            return new k(new WidgetChannelTopicViewModel$StoreState$NoChannel(this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab()));
        }
        if (ChannelUtils.B(channel)) {
            return WidgetChannelTopicViewModel$Companion.access$mapChannelToPrivateStoreState(WidgetChannelTopicViewModel.Companion, channel, this.$navState, this.$storeGuilds, this.$storeUserSettings);
        }
        if (channel.getTopic() != null) {
            String topic = channel.getTopic();
            if (!(topic == null || topic.length() == 0)) {
                return WidgetChannelTopicViewModel$Companion.access$mapChannelToGuildStoreState(WidgetChannelTopicViewModel.Companion, channel, this.$navState, this.$storeChannels, this.$storeUsers, this.$storeGuilds, this.$storeUserSettings);
            }
        }
        return new k(new WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic(channel, GuildChannelIconUtilsKt.getChannelType(channel), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab()));
    }
}
