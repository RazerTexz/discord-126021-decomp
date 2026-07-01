package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreEmoji$EmojiContext;
import com.discord.stores.StoreEmoji$EmojiContext$Chat;
import j0.k.b;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$getEmojiContextObservable$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, StoreEmoji$EmojiContext> {
    public static final EmojiPickerViewModel$Companion$getEmojiContextObservable$1 INSTANCE = new EmojiPickerViewModel$Companion$getEmojiContextObservable$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreEmoji$EmojiContext call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreEmoji$EmojiContext call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        Channel channelOrParent = storeChannelsSelected$ResolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent == null) {
            return null;
        }
        return new StoreEmoji$EmojiContext$Chat(channelOrParent.getGuildId(), storeChannelsSelected$ResolvedSelectedChannel.getId());
    }
}
