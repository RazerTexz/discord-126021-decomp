package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessageAck$Ack;
import d0.f0.q;
import d0.t.u;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.sequences.Sequence;
import rx.functions.Func4;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadStateManager$observeForumPostReadStates$1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Channel>, Set<? extends Long>, Set<? extends Long>, StoreMessageAck$Ack, Map<Long, ? extends ForumPostReadState>> {
    public static final ForumPostReadStateManager$observeForumPostReadStates$1 INSTANCE = new ForumPostReadStateManager$observeForumPostReadStates$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Map<Long, ? extends ForumPostReadState> call(Map<Long, ? extends Channel> map, Set<? extends Long> set, Set<? extends Long> set2, StoreMessageAck$Ack storeMessageAck$Ack) {
        return call2((Map<Long, Channel>) map, (Set<Long>) set, (Set<Long>) set2, storeMessageAck$Ack);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, ForumPostReadState> call2(Map<Long, Channel> map, Set<Long> set, Set<Long> set2, StoreMessageAck$Ack storeMessageAck$Ack) {
        Sequence map2 = q.map(u.asSequence(map.keySet()), new ForumPostReadStateManager$observeForumPostReadStates$1$1(storeMessageAck$Ack, set, set2));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : map2) {
            linkedHashMap.put(Long.valueOf(((ForumPostReadState) obj).getChannelId()), obj);
        }
        return linkedHashMap;
    }
}
