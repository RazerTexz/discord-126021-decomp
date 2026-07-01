package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.widgets.forums.ForumUtils;
import d0.t.h0;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostReadStates$requestForumUnreads$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreForumPostReadStates this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostReadStates$requestForumUnreads$1(StoreForumPostReadStates storeForumPostReadStates, long j, long j2) {
        super(0);
        this.this$0 = storeForumPostReadStates;
        this.$guildId = j;
        this.$channelId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, this.$guildId, null, 2, null) || StoreForumPostReadStates.access$getProcessedForumUnreadRequests$p(this.this$0).contains(Long.valueOf(this.$channelId))) {
            return;
        }
        StoreForumPostReadStates.access$getProcessedForumUnreadRequests$p(this.this$0).add(Long.valueOf(this.$channelId));
        Map<Long, Channel> mapEmptyMap = StoreForumPostReadStates.access$getStoreThreadsActive$p(this.this$0).getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(this.$guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : mapEmptyMap.entrySet()) {
            if (map$Entry.getValue().getParentId() == this.$channelId) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        Map<Long, StoreMessageAck$Ack> all = StoreForumPostReadStates.access$getStoreMessageAck$p(this.this$0).getAll();
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            StoreMessageAck$Ack storeMessageAck$Ack = all.get(Long.valueOf(jLongValue));
            Pair pair = storeMessageAck$Ack != null ? d0.o.to(Long.valueOf(jLongValue), Long.valueOf(storeMessageAck$Ack.getMessageId())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        StoreForumPostReadStates.access$getStoreGatewayConnection$p(this.this$0).requestForumUnreads(this.$guildId, this.$channelId, arrayList);
    }
}
