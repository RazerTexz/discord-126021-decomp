package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingObservableForChannel$1<T, R> implements b<Channel, Object[]> {
    public static final ChatTypingModel$Companion$getTypingObservableForChannel$1 INSTANCE = new ChatTypingModel$Companion$getTypingObservableForChannel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object[] call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Object[] call2(Channel channel) {
        return channel != null ? new Object[]{Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()), Integer.valueOf(channel.getRateLimitPerUser())} : new Object[0];
    }
}
