package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$fetchAuditLogIfNeeded$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$fetchAuditLogIfNeeded$1(StoreAuditLog storeAuditLog, long j) {
        super(0);
        this.this$0 = storeAuditLog;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z2 = this.$guildId != StoreAuditLog.access$getState$p(this.this$0).getGuildId();
        boolean z3 = StoreAuditLog.access$getState$p(this.this$0).getEntries() == null && !StoreAuditLog.access$getState$p(this.this$0).isLoading();
        if (z2) {
            StoreAuditLog.access$clearStateInternal(this.this$0);
        }
        if (z2 || z3) {
            StoreAuditLog storeAuditLog = this.this$0;
            StoreAuditLog.access$fetchAuditLogs(storeAuditLog, this.$guildId, StoreAuditLog.access$getState$p(storeAuditLog).getFilter());
        }
    }
}
