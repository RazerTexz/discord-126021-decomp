package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$2<T, R> implements b<Channel, Long> {
    public static final PrivateCallLaunchUtilsKt$callAndLaunch$1$2 INSTANCE = new PrivateCallLaunchUtilsKt$callAndLaunch$1$2();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Channel channel) {
        return Long.valueOf(channel != null ? channel.getId() : -1L);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Channel channel) {
        return call2(channel);
    }
}
