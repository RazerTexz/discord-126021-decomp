package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.panels.OverlappingPanelsLayout$LockState;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import rx.functions.Func2;

/* JADX INFO: compiled from: LeftPanelManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeftPanelManager$observeLockState$1<T1, T2, R> implements Func2<StoreChannelsSelected$ResolvedSelectedChannel, Long, OverlappingPanelsLayout$LockState> {
    public static final LeftPanelManager$observeLockState$1 INSTANCE = new LeftPanelManager$observeLockState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ OverlappingPanelsLayout$LockState call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Long l) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel, l);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0028  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final OverlappingPanelsLayout$LockState call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Long l) {
        long id2 = storeChannelsSelected$ResolvedSelectedChannel.getId();
        boolean z2 = false;
        boolean z3 = (id2 == 0 || id2 == -1) ? false : true;
        boolean z4 = l == null || l.longValue() != 0;
        boolean z5 = !z3;
        if (storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) {
            z2 = true;
        } else if (storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel) {
            StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) storeChannelsSelected$ResolvedSelectedChannel;
            if (storeChannelsSelected$ResolvedSelectedChannel$Channel.getPeekParent() != null || ChannelUtils.J(storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel())) {
                z2 = true;
            }
        }
        if (z4 && z2) {
            return OverlappingPanelsLayout$LockState.CLOSE;
        }
        return (z4 || !z5) ? OverlappingPanelsLayout$LockState.UNLOCKED : OverlappingPanelsLayout$LockState.OPEN;
    }
}
