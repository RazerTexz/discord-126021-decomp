package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$get$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends ChatTypingModel>> {
    public static final ChatTypingModel$Companion$get$1 INSTANCE = new ChatTypingModel$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        if (storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel) {
            return ChatTypingModel$Companion.access$getTypingObservableForChannel(ChatTypingModel.Companion, ((StoreChannelsSelected$ResolvedSelectedChannel$Channel) storeChannelsSelected$ResolvedSelectedChannel).getChannel());
        }
        return storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft ? ChatTypingModel$Companion.access$getTypingObservableForDraft(ChatTypingModel.Companion, ((StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) storeChannelsSelected$ResolvedSelectedChannel).getParentChannel()) : new k(ChatTypingModel$Hide.INSTANCE);
    }
}
