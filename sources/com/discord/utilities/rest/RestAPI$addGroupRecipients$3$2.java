package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import j0.l.a.q;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$addGroupRecipients$3$2<T, R> implements b<List<Observable<Void>>, Observable<? extends Channel>> {
    public final /* synthetic */ Channel $channel;

    public RestAPI$addGroupRecipients$3$2(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(List<Observable<Void>> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(List<Observable<Void>> list) {
        return Observable.H(Observable.h0(new q(list))).f0().G(new RestAPI$addGroupRecipients$3$2$1(this));
    }
}
