package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$generateInviteDefaultChannel$1<T, R> implements b<Map<Long, ? extends Channel>, Collection<? extends Channel>> {
    public static final StoreInviteSettings$generateInviteDefaultChannel$1 INSTANCE = new StoreInviteSettings$generateInviteDefaultChannel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Collection<? extends Channel> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Collection<Channel> call2(Map<Long, Channel> map) {
        return map.values();
    }
}
