package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$init$1<T, R> implements b<Long, Observable<? extends Boolean>> {
    public final /* synthetic */ StoreMediaSettings this$0;

    public StoreMediaSettings$init$1(StoreMediaSettings storeMediaSettings) {
        this.this$0 = storeMediaSettings;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Long l) {
        StoreChannels storeChannelsAccess$getStoreChannels$p = StoreMediaSettings.access$getStoreChannels$p(this.this$0);
        m.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
        return storeChannelsAccess$getStoreChannels$p.observeChannel(l.longValue()).Y(new StoreMediaSettings$init$1$1(this, l));
    }
}
