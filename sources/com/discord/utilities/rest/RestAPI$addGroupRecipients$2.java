package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import d0.t.u;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$addGroupRecipients$2<T, R> implements b<Channel, Observable<? extends Channel>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ List $recipients;
    public final /* synthetic */ RestAPI this$0;

    public RestAPI$addGroupRecipients$2(RestAPI restAPI, long j, List list) {
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
        return (channel == null || !ChannelUtils.z(channel)) ? RestAPI.access$get_api$p(this.this$0).convertDMToGroup(this.$channelId, ((User) u.first(this.$recipients)).getId()) : new k(channel);
    }
}
