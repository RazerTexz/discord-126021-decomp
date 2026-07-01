package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$Companion$getNotificationOverrides$2<T1, T2, T3, R> implements Func3<List<ModelNotificationSettings$ChannelOverride>, Map<Long, ? extends Channel>, GuildChannelsInfo, List<? extends NotificationsOverridesAdapter$Item>> {
    public static final WidgetServerNotifications$Companion$getNotificationOverrides$2 INSTANCE = new WidgetServerNotifications$Companion$getNotificationOverrides$2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends NotificationsOverridesAdapter$Item> call(List<ModelNotificationSettings$ChannelOverride> list, Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo) {
        return call2(list, (Map<Long, Channel>) map, guildChannelsInfo);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<NotificationsOverridesAdapter$Item> call2(List<ModelNotificationSettings$ChannelOverride> list, Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo) {
        m.checkNotNullExpressionValue(map, "guildChannels");
        List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
        m.checkNotNullExpressionValue(list, "channelOverrides");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride = (ModelNotificationSettings$ChannelOverride) next;
            m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride, "it");
            if (modelNotificationSettings$ChannelOverride.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET || modelNotificationSettings$ChannelOverride.isMuted()) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride2 = (ModelNotificationSettings$ChannelOverride) obj;
            m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride2, "override");
            linkedHashMap.put(Long.valueOf(modelNotificationSettings$ChannelOverride2.getChannelId()), obj);
        }
        ArrayList<Channel> arrayList2 = new ArrayList();
        for (Object obj2 : sortedVisibleChannels) {
            Channel channel = (Channel) obj2;
            if (ChannelUtils.k(channel) || ChannelUtils.F(channel)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Channel channel2 : arrayList2) {
            ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride3 = (ModelNotificationSettings$ChannelOverride) linkedHashMap.get(Long.valueOf(channel2.getId()));
            NotificationsOverridesAdapter$Item notificationsOverridesAdapter$Item = modelNotificationSettings$ChannelOverride3 != null ? new NotificationsOverridesAdapter$Item(channel2, map.get(Long.valueOf(channel2.getParentId())), modelNotificationSettings$ChannelOverride3) : null;
            if (notificationsOverridesAdapter$Item != null) {
                arrayList3.add(notificationsOverridesAdapter$Item);
            }
        }
        return arrayList3;
    }
}
