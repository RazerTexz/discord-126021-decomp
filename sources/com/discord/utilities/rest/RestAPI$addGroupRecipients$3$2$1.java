package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$addGroupRecipients$3$2$1<T, R> implements b<List<Void>, Channel> {
    public final /* synthetic */ RestAPI$addGroupRecipients$3$2 this$0;

    public RestAPI$addGroupRecipients$3$2$1(RestAPI$addGroupRecipients$3$2 restAPI$addGroupRecipients$3$2) {
        this.this$0 = restAPI$addGroupRecipients$3$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Channel call(List<Void> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Channel call2(List<Void> list) {
        return this.this$0.$channel;
    }
}
