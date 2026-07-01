package com.discord.utilities.system;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1 extends o implements Function0<Unit> {
    public final /* synthetic */ DeviceResourceUsageMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
        super(0);
        this.this$0 = deviceResourceUsageMonitor;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            DeviceResourceUsageMonitor.access$monitor(this.this$0);
        } catch (InterruptedException unused) {
        }
    }
}
