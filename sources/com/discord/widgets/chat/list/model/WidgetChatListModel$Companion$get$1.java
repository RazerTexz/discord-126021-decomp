package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$Companion$get$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends WidgetChatListModel>> {
    public static final WidgetChatListModel$Companion$get$1 INSTANCE = new WidgetChatListModel$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModel> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        if (storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel) {
            StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) storeChannelsSelected$ResolvedSelectedChannel;
            return ChannelUtils.o(storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel()) ? new k(null) : WidgetChatListModel$Companion.access$getChannel(WidgetChatListModel.Companion, storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel());
        }
        if (!(storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft)) {
            return new k(null);
        }
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = (StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) storeChannelsSelected$ResolvedSelectedChannel;
        return WidgetChatListModel$Companion.access$getThreadDraft(WidgetChatListModel.Companion, storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.getParentChannel(), storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.getStarterMessageId());
    }
}
