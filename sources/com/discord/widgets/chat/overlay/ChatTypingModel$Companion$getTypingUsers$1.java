package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingUsers$1<T, R> implements b<Set<? extends Long>, Observable<? extends List<? extends String>>> {
    public final /* synthetic */ Channel $channel;

    public ChatTypingModel$Companion$getTypingUsers$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends String>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<String>> call2(Set<Long> set) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreUser users = storeStream$Companion.getUsers();
        m.checkNotNullExpressionValue(set, "userIds");
        return Observable.j(users.observeUsers(set), storeStream$Companion.getGuilds().observeComputed(this.$channel.getGuildId(), set), ChatTypingModel$Companion$getTypingUsers$1$1.INSTANCE);
    }
}
