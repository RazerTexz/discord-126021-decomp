package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$addGroupRecipients$3$1<T, R> implements b<User, Observable<Void>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ RestAPI$addGroupRecipients$3 this$0;

    public RestAPI$addGroupRecipients$3$1(RestAPI$addGroupRecipients$3 restAPI$addGroupRecipients$3, Channel channel) {
        this.this$0 = restAPI$addGroupRecipients$3;
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<Void> call(User user) {
        return call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<Void> call2(User user) {
        return RestAPI.access$get_api$p(this.this$0.this$0).addChannelRecipient(this.$channel.getId(), user.getId());
    }
}
