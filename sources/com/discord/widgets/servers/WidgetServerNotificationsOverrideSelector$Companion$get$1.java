package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import d0.g0.w;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector$Companion$get$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, GuildChannelsInfo, String, List<? extends CategoricalDragAndDropAdapter$Payload>> {
    public static final WidgetServerNotificationsOverrideSelector$Companion$get$1 INSTANCE = new WidgetServerNotificationsOverrideSelector$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends CategoricalDragAndDropAdapter$Payload> call(Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
        return call2((Map<Long, Channel>) map, guildChannelsInfo, str);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003c  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<CategoricalDragAndDropAdapter$Payload> call2(Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
        boolean z2;
        m.checkNotNullExpressionValue(map, "channels");
        List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
        ArrayList<Channel> arrayList = new ArrayList();
        for (Object obj : sortedVisibleChannels) {
            Channel channel = (Channel) obj;
            if (ChannelUtils.F(channel) || ChannelUtils.k(channel)) {
                String strC = ChannelUtils.c(channel);
                m.checkNotNullExpressionValue(str, "filter");
                z2 = w.contains((CharSequence) strC, (CharSequence) str, true);
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Channel channel2 : arrayList) {
            DragAndDropAdapter$Payload settingsChannelListAdapter$CategoryItem = ChannelUtils.k(channel2) ? new SettingsChannelListAdapter$CategoryItem(ChannelUtils.c(channel2), channel2.getId(), channel2.getPosition(), false, false, false) : ChannelUtils.F(channel2) ? new SettingsChannelListAdapter$ChannelItem(channel2, false, channel2.getParentId(), false) : null;
            if (settingsChannelListAdapter$CategoryItem != null) {
                arrayList2.add(settingsChannelListAdapter$CategoryItem);
            }
        }
        return arrayList2;
    }
}
