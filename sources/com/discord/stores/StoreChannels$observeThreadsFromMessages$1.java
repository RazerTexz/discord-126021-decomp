package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import d0.d0.f;
import d0.t.g0;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeThreadsFromMessages$1 extends o implements Function0<Map<Long, ? extends Channel>> {
    public final /* synthetic */ List $messages;
    public final /* synthetic */ StoreChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannels$observeThreadsFromMessages$1(StoreChannels storeChannels, List list) {
        super(0);
        this.this$0 = storeChannels;
        this.$messages = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Channel> invoke2() {
        List list = this.$messages;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Message) obj).hasThread()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Channel channel = this.this$0.getChannel(((Message) it.next()).getId());
            if (channel != null) {
                arrayList2.add(channel);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(Long.valueOf(((Channel) obj2).getId()), obj2);
        }
        return linkedHashMap;
    }
}
