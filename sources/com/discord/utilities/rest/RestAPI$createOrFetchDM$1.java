package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$CreateChannel;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import j0.l.e.k;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$createOrFetchDM$1<T, R> implements b<Map<Long, ? extends Channel>, Observable<? extends Channel>> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ RestAPI this$0;

    public RestAPI$createOrFetchDM$1(RestAPI restAPI, long j) {
        this.this$0 = restAPI;
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Map<Long, Channel> map) {
        T next;
        User userA;
        Iterator<T> it = map.values().iterator();
        do {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            userA = ChannelUtils.a((Channel) next);
        } while (!(userA != null && userA.getId() == this.$userId));
        Channel channel = next;
        return channel != null ? new k(channel) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.access$get_api$p(this.this$0).userCreateChannel(new RestAPIParams$CreateChannel(this.$userId)), false, 1, null).u(RestAPI$createOrFetchDM$1$1.INSTANCE);
    }
}
