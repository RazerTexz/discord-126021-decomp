package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreMessageAck$Ack;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import rx.functions.Func3;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadStateManager$initialize$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreMessageAck$Ack>, StoreChannelsSelected$ResolvedSelectedChannel, Set<? extends Long>, ForumPostReadStateManager$ManagerInitializeState> {
    public static final ForumPostReadStateManager$initialize$1 INSTANCE = new ForumPostReadStateManager$initialize$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ ForumPostReadStateManager$ManagerInitializeState call(Map<Long, ? extends StoreMessageAck$Ack> map, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Set<? extends Long> set) {
        return call2((Map<Long, StoreMessageAck$Ack>) map, storeChannelsSelected$ResolvedSelectedChannel, (Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ForumPostReadStateManager$ManagerInitializeState call2(Map<Long, StoreMessageAck$Ack> map, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Set<Long> set) {
        m.checkNotNullExpressionValue(map, "messageAcks");
        m.checkNotNullExpressionValue(storeChannelsSelected$ResolvedSelectedChannel, "resolvedSelectedChannel");
        m.checkNotNullExpressionValue(set, "threadSyncedGuilds");
        return new ForumPostReadStateManager$ManagerInitializeState(map, storeChannelsSelected$ResolvedSelectedChannel, set);
    }
}
