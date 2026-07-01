package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import rx.functions.Action1;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$createOrFetchDM$1$1<T> implements Action1<Channel> {
    public static final RestAPI$createOrFetchDM$1$1 INSTANCE = new RestAPI$createOrFetchDM$1$1();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Channel channel) {
        call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Channel channel) {
        StoreStream.Companion.getGatewaySocket().getChannelCreateOrUpdate().k.onNext(channel);
    }
}
