package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$fetchMoreAuditLogEntries$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$fetchMoreAuditLogEntries$1(StoreAuditLog storeAuditLog) {
        super(0);
        this.this$0 = storeAuditLog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAuditLog storeAuditLog = this.this$0;
        StoreAuditLog.access$fetchAuditLogs(storeAuditLog, StoreAuditLog.access$getState$p(storeAuditLog).getGuildId(), StoreAuditLog.access$getState$p(this.this$0).getFilter());
    }
}
