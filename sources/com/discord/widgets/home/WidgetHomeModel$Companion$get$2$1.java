package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func8;

/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeModel$Companion$get$2$1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<MeUser, Map<Long, ? extends Presence>, Channel, Integer, Map<Long, ? extends Integer>, Map<Long, ? extends Channel>, Channel, Boolean, WidgetHomeModel> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel $selectedChannel;

    public WidgetHomeModel$Companion$get$2$1(Channel channel, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        this.$channel = channel;
        this.$selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ WidgetHomeModel call(MeUser meUser, Map<Long, ? extends Presence> map, Channel channel, Integer num, Map<Long, ? extends Integer> map2, Map<Long, ? extends Channel> map3, Channel channel2, Boolean bool) {
        return call2(meUser, (Map<Long, Presence>) map, channel, num, (Map<Long, Integer>) map2, (Map<Long, Channel>) map3, channel2, bool);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0038  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetHomeModel call2(MeUser meUser, Map<Long, Presence> map, Channel channel, Integer num, Map<Long, Integer> map2, Map<Long, Channel> map3, Channel channel2, Boolean bool) {
        boolean z2;
        User userA;
        User userA2;
        Channel channel3 = this.$channel;
        if (channel3 != null && ChannelUtils.B(channel3)) {
            Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
            Channel channel4 = this.$channel;
            if (m.areEqual(lValueOf, channel4 != null ? Long.valueOf(channel4.getId()) : null)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.$selectedChannel;
        m.checkNotNullExpressionValue(storeChannelsSelected$ResolvedSelectedChannel, "selectedChannel");
        Channel channel5 = this.$channel;
        Presence presence = (channel5 == null || (userA2 = ChannelUtils.a(channel5)) == null) ? null : (Presence) a.f(userA2, map);
        m.checkNotNullExpressionValue(num, "unreadCount");
        int iIntValue = num.intValue();
        m.checkNotNullExpressionValue(map2, "userRelationships");
        Channel channel6 = this.$channel;
        boolean zIsType = ModelUserRelationship.isType(map2.get((channel6 == null || (userA = ChannelUtils.a(channel6)) == null) ? null : Long.valueOf(userA.getId())), 1);
        NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
        int size = map3.size();
        m.checkNotNullExpressionValue(bool, "threadExperimentEnabled");
        return new WidgetHomeModel(storeChannelsSelected$ResolvedSelectedChannel, channel, channel2, presence, iIntValue, zIsType, z2, nsfwAllowance, size, bool.booleanValue());
    }
}
