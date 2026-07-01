package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreUserSettings;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends GuildMember>>, WidgetChannelTopicViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelTopicViewModel$Companion$NavState $navState;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    public WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1(Channel channel, StoreUserSettings storeUserSettings, WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState) {
        this.$channel = channel;
        this.$storeUserSettings = storeUserSettings;
        this.$navState = widgetChannelTopicViewModel$Companion$NavState;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel$StoreState call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
        return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel$StoreState call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
        return new WidgetChannelTopicViewModel$StoreState$DM(this.$channel, map.values(), this.$storeUserSettings.getIsDeveloperMode(), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab());
    }
}
