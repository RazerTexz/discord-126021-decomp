package com.discord.widgets.announcements;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.t.o;
import d0.t.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$observeViewStateFromStores$3<T1, T2, T3, T4, T5, R> implements Func5<Guild, Channel, Map<Long, ? extends List<? extends Channel>>, Guild, Channel, WidgetChannelFollowSheetViewModel$ViewState$Loaded> {
    public static final WidgetChannelFollowSheetViewModel$observeViewStateFromStores$3 INSTANCE = new WidgetChannelFollowSheetViewModel$observeViewStateFromStores$3();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChannelFollowSheetViewModel$ViewState$Loaded call(Guild guild, Channel channel, Map<Long, ? extends List<? extends Channel>> map, Guild guild2, Channel channel2) {
        return call2(guild, channel, (Map<Long, ? extends List<Channel>>) map, guild2, channel2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelFollowSheetViewModel$ViewState$Loaded call2(Guild guild, Channel channel, Map<Long, ? extends List<Channel>> map, Guild guild2, Channel channel2) {
        Set<Long> setKeySet = map.keySet();
        List listFlatten = o.flatten(map.values());
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listFlatten, 10));
        Iterator it = listFlatten.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
        }
        return new WidgetChannelFollowSheetViewModel$ViewState$Loaded(channel, guild, guild2, channel2, setKeySet, u.toSet(arrayList), null, 64, null);
    }
}
