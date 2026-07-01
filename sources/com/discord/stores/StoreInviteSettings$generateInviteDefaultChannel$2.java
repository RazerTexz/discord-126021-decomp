package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$generateInviteDefaultChannel$2<T, R> implements b<Collection<? extends Channel>, List<? extends Channel>> {
    public static final StoreInviteSettings$generateInviteDefaultChannel$2 INSTANCE = new StoreInviteSettings$generateInviteDefaultChannel$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Channel> call(Collection<? extends Channel> collection) {
        return call2((Collection<Channel>) collection);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Channel> call2(Collection<Channel> collection) {
        m.checkNotNullExpressionValue(collection, "it");
        return u.sortedWith(collection, ChannelUtils.h(Channel.Companion));
    }
}
