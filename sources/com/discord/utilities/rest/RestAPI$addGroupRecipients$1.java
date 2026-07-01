package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$addGroupRecipients$1<T, R> implements b<Channel, Boolean> {
    public static final RestAPI$addGroupRecipients$1 INSTANCE = new RestAPI$addGroupRecipients$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Channel channel) {
        return Boolean.valueOf(channel != null);
    }
}
