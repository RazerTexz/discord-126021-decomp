package com.discord.utilities.lazy.subscriptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: GuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptions$serializedRanges$2 extends AbstractC12240o implements Function0<Map<Long, ? extends List<? extends List<? extends Integer>>>> {
    public final /* synthetic */ GuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptions$serializedRanges$2(GuildSubscriptions guildSubscriptions) {
        super(0);
        this.this$0 = guildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<Long, ? extends List<? extends List<? extends Integer>>> invoke() {
        Map<Long, List<IntRange>> channels = this.this$0.getChannels();
        if (channels == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(channels.size()));
        Iterator<T> it = channels.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            List<IntRange> list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            for (IntRange intRange : list) {
                arrayList.add(C12147n.listOf((Object[]) new Integer[]{Integer.valueOf(intRange.getFirst()), Integer.valueOf(intRange.getLast())}));
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }
}
