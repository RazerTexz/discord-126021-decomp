package com.discord.utilities.auditlogs;

import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AuditLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogUtils$ALL_ACTION_TYPES$2 extends o implements Function0<List<? extends Integer>> {
    public static final AuditLogUtils$ALL_ACTION_TYPES$2 INSTANCE = new AuditLogUtils$ALL_ACTION_TYPES$2();

    public AuditLogUtils$ALL_ACTION_TYPES$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Integer> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Integer> invoke2() {
        return n.listOf((Object[]) new Integer[]{0, 1, 10, 11, 12, 13, 14, 15, 20, 21, 22, 23, 24, 25, 26, 27, 28, 110, 111, 112, 30, 31, 32, 40, 41, 42, 50, 51, 52, 60, 61, 62, 72, 73, 74, 75, 80, 81, 82, 83, 84, 85, 90, 91, 92, 100, 101, 102});
    }
}
