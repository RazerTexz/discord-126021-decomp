package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingObservableForChannel$2<T, R> implements b<Channel, Observable<? extends ChatTypingModel>> {
    public static final ChatTypingModel$Companion$getTypingObservableForChannel$2 INSTANCE = new ChatTypingModel$Companion$getTypingObservableForChannel$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Channel channel) {
        return channel == null ? new k(ChatTypingModel$Hide.INSTANCE) : GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null).Y(new ChatTypingModel$Companion$getTypingObservableForChannel$2$1(channel));
    }
}
