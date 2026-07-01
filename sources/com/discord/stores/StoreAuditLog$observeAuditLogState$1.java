package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$observeAuditLogState$1 extends o implements Function0<StoreAuditLog$AuditLogState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$observeAuditLogState$1(StoreAuditLog storeAuditLog, long j) {
        super(0);
        this.this$0 = storeAuditLog;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreAuditLog$AuditLogState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreAuditLog$AuditLogState invoke() {
        return this.this$0.getAuditLogState(this.$guildId);
    }
}
