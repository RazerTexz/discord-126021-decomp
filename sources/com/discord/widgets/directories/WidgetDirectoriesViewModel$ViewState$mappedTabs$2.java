package com.discord.widgets.directories;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.models.hubs.DirectoryEntryCategory$Companion;
import d0.t.g0;
import d0.t.h0;
import d0.t.i0;
import d0.t.m;
import d0.t.u;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$ViewState$mappedTabs$2 extends o implements Function0<List<? extends Pair<? extends DirectoryEntryCategory, ? extends Integer>>> {
    public final /* synthetic */ WidgetDirectoriesViewModel$ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel$ViewState$mappedTabs$2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        super(0);
        this.this$0 = widgetDirectoriesViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Pair<? extends DirectoryEntryCategory, ? extends Integer>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Pair<? extends DirectoryEntryCategory, ? extends Integer>> invoke2() {
        Map mapEmptyMap;
        List listListOf = m.listOf(d0.o.to(DirectoryEntryCategory.Home, 0));
        Map<Integer, Integer> mapInvoke = this.this$0.getTabs().invoke();
        if (mapInvoke != null) {
            mapEmptyMap = new LinkedHashMap(g0.mapCapacity(mapInvoke.size()));
            Iterator<T> it = mapInvoke.entrySet().iterator();
            while (it.hasNext()) {
                Map$Entry map$Entry = (Map$Entry) it.next();
                DirectoryEntryCategory$Companion directoryEntryCategory$Companion = DirectoryEntryCategory.Companion;
                int iIntValue = ((Number) map$Entry.getKey()).intValue();
                Channel channel = this.this$0.getChannel();
                boolean z2 = true;
                if (channel == null || !ChannelUtils.x(channel)) {
                    z2 = false;
                }
                mapEmptyMap.put(directoryEntryCategory$Companion.findByKey(iIntValue, z2), map$Entry.getValue());
            }
        } else {
            mapEmptyMap = null;
        }
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        return u.plus((Collection) listListOf, (Iterable) i0.toList(mapEmptyMap));
    }
}
