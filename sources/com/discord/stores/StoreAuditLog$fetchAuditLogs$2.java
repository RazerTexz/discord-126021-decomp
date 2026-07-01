package com.discord.stores;

import com.discord.models.domain.ModelAuditLog;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$fetchAuditLogs$2 extends o implements Function1<ModelAuditLog, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$fetchAuditLogs$2(StoreAuditLog storeAuditLog, long j) {
        super(1);
        this.this$0 = storeAuditLog;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelAuditLog modelAuditLog) {
        invoke2(modelAuditLog);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelAuditLog modelAuditLog) {
        m.checkNotNullParameter(modelAuditLog, "newAuditLog");
        StoreAuditLog.access$handleFetchSuccess(this.this$0, this.$guildId, modelAuditLog);
    }
}
