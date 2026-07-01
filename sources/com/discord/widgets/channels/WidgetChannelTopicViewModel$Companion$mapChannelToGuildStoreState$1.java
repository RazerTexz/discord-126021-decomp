package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.channel.GuildChannelIconType;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1<T1, T2, T3, T4, T5, R> implements Func5<Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Boolean, WidgetChannelTopicViewModel$StoreState$Guild> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelTopicViewModel$Companion$NavState $navState;

    public WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1(Channel channel, WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState) {
        this.$channel = channel;
        this.$navState = widgetChannelTopicViewModel$Companion$NavState;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel$StoreState$Guild call(Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Boolean bool) {
        return call2((Map<Long, Channel>) map, map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel$StoreState$Guild call2(Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Boolean bool) {
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(map, "channels");
        GuildChannelIconType channelType = GuildChannelIconUtilsKt.getChannelType(this.$channel);
        m.checkNotNullExpressionValue(map2, "users");
        m.checkNotNullExpressionValue(map3, "members");
        m.checkNotNullExpressionValue(map4, "roles");
        m.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return new WidgetChannelTopicViewModel$StoreState$Guild$Topic(channel, map, channelType, map2, map3, map4, bool.booleanValue(), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab());
    }
}
