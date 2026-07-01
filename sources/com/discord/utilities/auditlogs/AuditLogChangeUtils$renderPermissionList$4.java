package com.discord.utilities.auditlogs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils$renderPermissionList$4 extends o implements Function1<CharSequence, Boolean> {
    public static final AuditLogChangeUtils$renderPermissionList$4 INSTANCE = new AuditLogChangeUtils$renderPermissionList$4();

    public AuditLogChangeUtils$renderPermissionList$4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence) {
        return Boolean.valueOf(invoke2(charSequence));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(CharSequence charSequence) {
        m.checkNotNullParameter(charSequence, "it");
        return charSequence.length() == 0;
    }
}
