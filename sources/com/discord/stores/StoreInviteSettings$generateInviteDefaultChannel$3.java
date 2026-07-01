package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$generateInviteDefaultChannel$3<T, R> implements b<List<? extends Channel>, Long> {
    public static final StoreInviteSettings$generateInviteDefaultChannel$3 INSTANCE = new StoreInviteSettings$generateInviteDefaultChannel$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(List<? extends Channel> list) {
        return call2((List<Channel>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(List<Channel> list) {
        m.checkNotNullExpressionValue(list, "it");
        Channel channel = (Channel) u.firstOrNull((List) list);
        if (channel != null) {
            return Long.valueOf(channel.getId());
        }
        return null;
    }
}
