package com.discord.utilities.systemlog;

import b.d.b.a.a;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils$hashString$1 extends o implements Function1<Byte, CharSequence> {
    public static final SystemLogUtils$hashString$1 INSTANCE = new SystemLogUtils$hashString$1();

    public SystemLogUtils$hashString$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
        return invoke(b2.byteValue());
    }

    public final CharSequence invoke(byte b2) {
        return a.P(new Object[]{Byte.valueOf(b2)}, 1, "%02X", "java.lang.String.format(this, *args)");
    }
}
