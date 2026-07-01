package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$onStartCommand$1<T, R> implements b<Boolean, Boolean> {
    public static final DiscordOverlayService$onStartCommand$1 INSTANCE = new DiscordOverlayService$onStartCommand$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(m.areEqual(bool, Boolean.TRUE));
    }
}
