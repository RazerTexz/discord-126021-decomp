package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import java.util.Set;
import rx.functions.Func4;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$init$1$3<T1, T2, T3, T4, R> implements Func4<Set<? extends Long>, Boolean, StoreChat$InteractionState, StoreMessageAck$Ack, Long> {
    public final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel $selectedChannel;

    public StoreMessageAck$init$1$3(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        this.$selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Long call(Set<? extends Long> set, Boolean bool, StoreChat$InteractionState storeChat$InteractionState, StoreMessageAck$Ack storeMessageAck$Ack) {
        return call2((Set<Long>) set, bool, storeChat$InteractionState, storeMessageAck$Ack);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Set<Long> set, Boolean bool, StoreChat$InteractionState storeChat$InteractionState, StoreMessageAck$Ack storeMessageAck$Ack) {
        long channelId;
        Channel maybeChannel = this.$selectedChannel.getMaybeChannel();
        boolean z2 = maybeChannel != null && ChannelUtils.o(maybeChannel);
        if (storeChat$InteractionState.isAtBottomIgnoringTouch()) {
            m.checkNotNullExpressionValue(bool, "isLoadingSettled");
            if (!bool.booleanValue() || set.contains(Long.valueOf(storeChat$InteractionState.getChannelId())) || z2 || (storeMessageAck$Ack != null && storeMessageAck$Ack.isLockedAck())) {
                channelId = 0;
            } else {
                channelId = storeChat$InteractionState.getChannelId();
            }
        } else {
            channelId = 0;
        }
        return Long.valueOf(channelId);
    }
}
