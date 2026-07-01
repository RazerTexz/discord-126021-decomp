package com.discord.utilities.auditlogs;

import android.content.Context;
import b.a.k.b;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils$renderPermissionList$3 extends o implements Function1<Integer, CharSequence> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuditLogChangeUtils$renderPermissionList$3(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final CharSequence invoke(int i) {
        return b.h(this.$context, i, new Object[0], null, 4);
    }
}
