package com.discord.utilities.lazy.subscriptions;

import d0.t.g0;
import d0.t.n;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: GuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptions$serializedRanges$2 extends o implements Function0<Map<Long, ? extends List<? extends List<? extends Integer>>>> {
    public final /* synthetic */ GuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptions$serializedRanges$2(GuildSubscriptions guildSubscriptions) {
        super(0);
        this.this$0 = guildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends List<? extends Integer>>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends List<? extends List<? extends Integer>>> invoke2() {
        Map<Long, List<IntRange>> channels = this.this$0.getChannels();
        if (channels == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(channels.size()));
        Iterator<T> it = channels.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            List<IntRange> list = (List) map$Entry.getValue();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            for (IntRange intRange : list) {
                arrayList.add(n.listOf((Object[]) new Integer[]{Integer.valueOf(intRange.getFirst()), Integer.valueOf(intRange.getLast())}));
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }
}
