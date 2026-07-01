package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$addGroupRecipients$3<T, R> implements b<Channel, Observable<? extends Channel>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ List $recipients;
    public final /* synthetic */ RestAPI this$0;

    public RestAPI$addGroupRecipients$3(RestAPI restAPI, long j, List list) {
        this.this$0 = restAPI;
        this.$channelId = j;
        this.$recipients = list;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Channel channel) {
        List listSubList;
        if (channel.getId() == this.$channelId) {
            listSubList = this.$recipients;
        } else {
            List list = this.$recipients;
            listSubList = list.subList(1, list.size());
        }
        return Observable.B(listSubList).G(new RestAPI$addGroupRecipients$3$1(this, channel)).f0().Y(new RestAPI$addGroupRecipients$3$2(channel));
    }
}
