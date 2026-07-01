package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$setAuditLogFilterActionId$1 extends o implements Function0<Unit> {
    public final /* synthetic */ int $actionId;
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$setAuditLogFilterActionId$1(StoreAuditLog storeAuditLog, int i) {
        super(0);
        this.this$0 = storeAuditLog;
        this.$actionId = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$actionId != StoreAuditLog.access$getState$p(this.this$0).getFilter().getActionFilter()) {
            StoreAuditLog storeAuditLog = this.this$0;
            StoreAuditLog.access$setState$p(storeAuditLog, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, null, null, null, null, null, null, null, null, null, false, 2043, null));
        }
        StoreAuditLog storeAuditLog2 = this.this$0;
        StoreAuditLog.access$setState$p(storeAuditLog2, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog2), 0L, null, null, null, null, null, null, null, StoreAuditLog$AuditLogFilter.copy$default(StoreAuditLog.access$getState$p(this.this$0).getFilter(), 0L, this.$actionId, 1, null), null, false, 1791, null));
        this.this$0.markChanged();
    }
}
