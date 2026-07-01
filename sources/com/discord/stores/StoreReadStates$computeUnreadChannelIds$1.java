package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function9;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreReadStates$computeUnreadChannelIds$1 extends k implements Function9<Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends ModelNotificationSettings>, Map<Long, ? extends StoreMessageAck$Ack>, Map<Long, ? extends Long>, Long, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>, Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
    public StoreReadStates$computeUnreadChannelIds$1(StoreReadStates storeReadStates) {
        super(9, storeReadStates, StoreReadStates.class, "computeUnreadIds", "computeUnreadIds(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Ljava/util/Map;)Lkotlin/Pair;", 0);
    }

    @Override // kotlin.jvm.functions.Function9
    public /* bridge */ /* synthetic */ Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> invoke(Map<Long, ? extends Long> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, ? extends StoreMessageAck$Ack> map5, Map<Long, ? extends Long> map6, Long l, Map<Long, ? extends Channel> map7, Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> map8) {
        return invoke((Map<Long, Long>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3, map4, (Map<Long, StoreMessageAck$Ack>) map5, (Map<Long, Long>) map6, l.longValue(), (Map<Long, Channel>) map7, (Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>) map8);
    }

    public final Pair<Set<Long>, Set<Long>> invoke(Map<Long, Long> map, Map<Long, Channel> map2, Map<Long, Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, StoreMessageAck$Ack> map5, Map<Long, Long> map6, long j, Map<Long, Channel> map7, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> map8) {
        m.checkNotNullParameter(map, "p1");
        m.checkNotNullParameter(map2, "p2");
        m.checkNotNullParameter(map3, "p3");
        m.checkNotNullParameter(map4, "p4");
        m.checkNotNullParameter(map5, "p5");
        m.checkNotNullParameter(map6, "p6");
        m.checkNotNullParameter(map7, "p8");
        m.checkNotNullParameter(map8, "p9");
        return StoreReadStates.access$computeUnreadIds((StoreReadStates) this.receiver, map, map2, map3, map4, map5, map6, j, map7, map8);
    }
}
