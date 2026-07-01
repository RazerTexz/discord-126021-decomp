package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor$ResourceUsage;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1 extends o implements Function1<DeviceResourceUsageMonitor$ResourceUsage, Unit> {
    public static final AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1 INSTANCE = new AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1();

    public AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceResourceUsageMonitor$ResourceUsage deviceResourceUsageMonitor$ResourceUsage) {
        invoke2(deviceResourceUsageMonitor$ResourceUsage);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceResourceUsageMonitor$ResourceUsage deviceResourceUsageMonitor$ResourceUsage) {
        m.checkNotNullParameter(deviceResourceUsageMonitor$ResourceUsage, "it");
        AnalyticSuperProperties.INSTANCE.setClientPerformanceProperties(deviceResourceUsageMonitor$ResourceUsage.getCpuUsagePercent(), deviceResourceUsageMonitor$ResourceUsage.getMemoryRssBytes() / ((long) 1024), deviceResourceUsageMonitor$ResourceUsage.getCpuCoreCount());
    }
}
