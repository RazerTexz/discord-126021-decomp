package com.discord.utilities.lazy.subscriptions;

import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptions$serializedRanges$2, reason: use source file name */
/* JADX INFO: compiled from: GuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptions2 extends Lambda implements Function0<Map<Long, ? extends List<? extends List<? extends Integer>>>> {
    public final /* synthetic */ GuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptions2(GuildSubscriptions guildSubscriptions) {
        super(0);
        this.this$0 = guildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<Long, ? extends List<? extends List<? extends Integer>>> invoke() {
        Map<Long, List<Ranges2>> channels = this.this$0.getChannels();
        if (channels == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(channels.size()));
        Iterator<T> it = channels.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            List<Ranges2> list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (Ranges2 ranges2 : list) {
                arrayList.add(Collections2.listOf((Object[]) new Integer[]{Integer.valueOf(ranges2.getFirst()), Integer.valueOf(ranges2.getLast())}));
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }
}
