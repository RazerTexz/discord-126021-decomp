package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$init$1$1<T, R> implements b<Channel, Observable<? extends Boolean>> {
    public final /* synthetic */ Long $id;
    public final /* synthetic */ StoreMediaSettings$init$1 this$0;

    public StoreMediaSettings$init$1$1(StoreMediaSettings$init$1 storeMediaSettings$init$1, Long l) {
        this.this$0 = storeMediaSettings$init$1;
        this.$id = l;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Channel channel) {
        if (channel == null || ChannelUtils.B(channel) || ChannelUtils.D(channel)) {
            return new k(Boolean.TRUE);
        }
        StorePermissions storePermissionsAccess$getStorePermissions$p = StoreMediaSettings.access$getStorePermissions$p(this.this$0.this$0);
        Long l = this.$id;
        m.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
        return storePermissionsAccess$getStorePermissions$p.observePermissionsForChannel(l.longValue()).G(StoreMediaSettings$init$1$1$1.INSTANCE);
    }
}
