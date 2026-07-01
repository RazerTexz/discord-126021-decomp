package com.discord.utilities;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$3<T, R> implements b<Map<Long, ? extends Channel>, Boolean> {
    public static final ShareUtils$updateDirectShareTargets$3 INSTANCE = new ShareUtils$updateDirectShareTargets$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Map<Long, Channel> map) {
        m.checkNotNullExpressionValue(map, "it");
        return Boolean.valueOf(!map.isEmpty());
    }
}
