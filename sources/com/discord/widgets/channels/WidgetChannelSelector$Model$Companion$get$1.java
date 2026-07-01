package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.t.m;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Model$Companion$get$1<T, R> implements b<Map<Long, ? extends Channel>, List<? extends WidgetChannelSelector$Model$Item>> {
    public final /* synthetic */ WidgetChannelSelector$FilterFunction $filterFunction;
    public final /* synthetic */ boolean $includeNoChannel;

    public WidgetChannelSelector$Model$Companion$get$1(WidgetChannelSelector$FilterFunction widgetChannelSelector$FilterFunction, boolean z2) {
        this.$filterFunction = widgetChannelSelector$FilterFunction;
        this.$includeNoChannel = z2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends WidgetChannelSelector$Model$Item> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<WidgetChannelSelector$Model$Item> call2(Map<Long, Channel> map) {
        Collection<Channel> collectionValues = map.values();
        WidgetChannelSelector$FilterFunction widgetChannelSelector$FilterFunction = this.$filterFunction;
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (widgetChannelSelector$FilterFunction.includeChannel((Channel) t)) {
                arrayList.add(t);
            }
        }
        List listListOf = this.$includeNoChannel ? m.listOf(new WidgetChannelSelector$Model$Item(null, 0, null, 6, null)) : n.emptyList();
        List listSortedWith = u.sortedWith(arrayList, ChannelUtils.h(Channel.Companion));
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(listSortedWith, 10));
        Iterator<T> it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList2.add(new WidgetChannelSelector$Model$Item((Channel) it.next(), 0, null, 6, null));
        }
        return u.plus((Collection) listListOf, (Iterable) arrayList2);
    }
}
