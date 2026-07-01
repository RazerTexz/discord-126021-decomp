package com.discord.utilities.system;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.system.DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: DeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DeviceResourceUsageMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceResourceUsageMonitor2(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
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
            this.this$0.monitor();
        } catch (InterruptedException unused) {
        }
    }
}
