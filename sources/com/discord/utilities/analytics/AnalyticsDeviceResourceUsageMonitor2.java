package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor2 extends Lambda implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
    public static final AnalyticsDeviceResourceUsageMonitor2 INSTANCE = new AnalyticsDeviceResourceUsageMonitor2();

    public AnalyticsDeviceResourceUsageMonitor2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        invoke2(resourceUsage);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        Intrinsics3.checkNotNullParameter(resourceUsage, "it");
        AnalyticSuperProperties.INSTANCE.setClientPerformanceProperties(resourceUsage.getCpuUsagePercent(), resourceUsage.getMemoryRssBytes() / ((long) 1024), resourceUsage.getCpuCoreCount());
    }
}
