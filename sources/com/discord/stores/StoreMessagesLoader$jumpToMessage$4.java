package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$4<T, R> implements b<Long, Observable<? extends Message>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessagesLoader this$0;

    public StoreMessagesLoader$jumpToMessage$4(StoreMessagesLoader storeMessagesLoader, long j, long j2) {
        this.this$0 = storeMessagesLoader;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Message> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Message> call2(Long l) {
        return StoreMessagesLoader.access$getStream$p(this.this$0).getMessages().observeMessagesForChannel(this.$channelId, this.$messageId);
    }
}
