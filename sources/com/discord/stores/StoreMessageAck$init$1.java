package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$init$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends Long>> {
    public final /* synthetic */ StoreMessageAck this$0;

    public StoreMessageAck$init$1(StoreMessageAck storeMessageAck) {
        this.this$0 = storeMessageAck;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return Observable.h(StoreMessageAck.access$getStream$p(this.this$0).getMessages().getAllDetached().p(50L, TimeUnit.MILLISECONDS), StoreMessageAck.access$getStream$p(this.this$0).getMessagesLoader().getMessagesLoadedState(storeChannelsSelected$ResolvedSelectedChannel.getId()).G(StoreMessageAck$init$1$1.INSTANCE).r(), StoreMessageAck.access$getStream$p(this.this$0).getChat().observeInteractionState().y(new StoreMessageAck$init$1$2(storeChannelsSelected$ResolvedSelectedChannel)), StoreMessageAck.access$getStream$p(this.this$0).getMessageAck().observeForChannel(storeChannelsSelected$ResolvedSelectedChannel.getId()), new StoreMessageAck$init$1$3(storeChannelsSelected$ResolvedSelectedChannel));
    }
}
