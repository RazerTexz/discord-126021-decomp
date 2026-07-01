package com.discord.utilities.auditlogs;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils$renderPermissionList$1 extends o implements Function1<Long, Integer> {
    public final /* synthetic */ ModelAuditLogEntry $auditLogEntry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuditLogChangeUtils$renderPermissionList$1(ModelAuditLogEntry modelAuditLogEntry) {
        super(1);
        this.$auditLogEntry = modelAuditLogEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Integer invoke(long j) {
        return Integer.valueOf(AuditLogChangeUtils.access$getStringForPermission(AuditLogChangeUtils.INSTANCE, j, this.$auditLogEntry));
    }
}
