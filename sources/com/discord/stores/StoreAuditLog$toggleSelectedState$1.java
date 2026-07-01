package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$toggleSelectedState$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $selectedItemId;
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$toggleSelectedState$1(StoreAuditLog storeAuditLog, long j) {
        super(0);
        this.this$0 = storeAuditLog;
        this.$selectedItemId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAuditLog storeAuditLog = this.this$0;
        long j = this.$selectedItemId;
        Long selectedItemId = StoreAuditLog.access$getState$p(storeAuditLog).getSelectedItemId();
        StoreAuditLog.access$setState$p(storeAuditLog, (selectedItemId != null && j == selectedItemId.longValue()) ? StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(this.this$0), 0L, null, null, null, null, null, null, null, null, null, false, 1919, null) : StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(this.this$0), 0L, null, null, null, null, null, null, Long.valueOf(this.$selectedItemId), null, null, false, 1919, null));
        this.this$0.markChanged();
    }
}
