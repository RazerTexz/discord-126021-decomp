package com.discord.stores;

import androidx.media.AudioAttributesCompat;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$handleFetchFailure$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$handleFetchFailure$1(StoreAuditLog storeAuditLog) {
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
        StoreAuditLog.access$setState$p(storeAuditLog, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, null, null, null, null, null, null, null, null, null, false, AudioAttributesCompat.FLAG_ALL, null));
        this.this$0.markChanged();
    }
}
