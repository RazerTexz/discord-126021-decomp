package com.discord.utilities.systemlog;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SystemLogCapture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogCapture$startThread$1 extends o implements Function0<Unit> {
    public final /* synthetic */ SystemLogCapture this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogCapture$startThread$1(SystemLogCapture systemLogCapture) {
        super(0);
        this.this$0 = systemLogCapture;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SystemLogCapture.access$start(this.this$0);
    }
}
