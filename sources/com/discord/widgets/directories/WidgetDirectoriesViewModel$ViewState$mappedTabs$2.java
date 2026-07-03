package com.discord.widgets.directories;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12138i0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$ViewState$mappedTabs$2 extends AbstractC12240o implements Function0<List<? extends Pair<? extends DirectoryEntryCategory, ? extends Integer>>> {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel$ViewState$mappedTabs$2(WidgetDirectoriesViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Pair<? extends DirectoryEntryCategory, ? extends Integer>> invoke() {
        Map mapEmptyMap;
        List listListOf = C12145m.listOf(C12116o.m10073to(DirectoryEntryCategory.Home, 0));
        Map<Integer, Integer> mapInvoke = this.this$0.getTabs().invoke();
        if (mapInvoke != null) {
            mapEmptyMap = new LinkedHashMap(C12134g0.mapCapacity(mapInvoke.size()));
            Iterator<T> it = mapInvoke.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
                int iIntValue = ((Number) entry.getKey()).intValue();
                Channel channel = this.this$0.getChannel();
                boolean z2 = true;
                if (channel == null || !ChannelUtils.m7700x(channel)) {
                    z2 = false;
                }
                mapEmptyMap.put(companion.findByKey(iIntValue, z2), entry.getValue());
            }
        } else {
            mapEmptyMap = null;
        }
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        return C12163u.plus((Collection) listListOf, (Iterable) C12138i0.toList(mapEmptyMap));
    }
}
