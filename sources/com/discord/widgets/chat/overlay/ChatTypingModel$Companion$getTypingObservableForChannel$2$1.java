package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.stores.StoreSlowMode$Type$MessageSend;
import com.discord.stores.StoreStream;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingObservableForChannel$2$1<T, R> implements b<GuildVerificationLevel, Observable<? extends ChatTypingModel>> {
    public final /* synthetic */ Channel $channel;

    public ChatTypingModel$Companion$getTypingObservableForChannel$2$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(GuildVerificationLevel guildVerificationLevel) {
        return call2(guildVerificationLevel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(GuildVerificationLevel guildVerificationLevel) {
        return guildVerificationLevel.compareTo(GuildVerificationLevel.NONE) > 0 ? new k(ChatTypingModel$Hide.INSTANCE) : Observable.j(ChatTypingModel$Companion.access$getTypingUsers(ChatTypingModel.Companion, this.$channel), StoreStream.Companion.getSlowMode().observeCooldownSecs(Long.valueOf(this.$channel.getId()), StoreSlowMode$Type$MessageSend.INSTANCE), new ChatTypingModel$Companion$getTypingObservableForChannel$2$1$1(this));
    }
}
