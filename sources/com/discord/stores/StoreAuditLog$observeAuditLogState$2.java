package com.discord.stores;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$observeAuditLogState$2<T> implements Action1<StoreAuditLog$AuditLogState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreAuditLog this$0;

    public StoreAuditLog$observeAuditLogState$2(StoreAuditLog storeAuditLog, long j) {
        this.this$0 = storeAuditLog;
        this.$guildId = j;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState) {
        call2(storeAuditLog$AuditLogState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState) {
        this.this$0.fetchAuditLogIfNeeded(this.$guildId);
    }
}
