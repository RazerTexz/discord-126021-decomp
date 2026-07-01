package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$createGroupDM$1<T> implements Action1<Channel> {
    public static final RestAPI$createGroupDM$1 INSTANCE = new RestAPI$createGroupDM$1();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Channel channel) {
        call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Channel channel) {
        StoreChannels channels = StoreStream.Companion.getChannels();
        m.checkNotNullExpressionValue(channel, "channel");
        channels.onGroupCreated(channel);
    }
}
