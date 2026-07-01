package com.discord.utilities.auditlogs;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils$renderPermissionList$2 extends o implements Function1<Integer, Boolean> {
    public static final AuditLogChangeUtils$renderPermissionList$2 INSTANCE = new AuditLogChangeUtils$renderPermissionList$2();

    public AuditLogChangeUtils$renderPermissionList$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return Boolean.valueOf(invoke(num.intValue()));
    }

    public final boolean invoke(int i) {
        return i != 0;
    }
}
