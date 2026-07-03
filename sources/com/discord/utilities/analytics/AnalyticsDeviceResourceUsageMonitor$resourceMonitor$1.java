package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1 extends AbstractC12240o implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
    public static final AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1 INSTANCE = new AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1();

    public AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        invoke2(resourceUsage);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        C12238m.checkNotNullParameter(resourceUsage, "it");
        AnalyticSuperProperties.INSTANCE.setClientPerformanceProperties(resourceUsage.getCpuUsagePercent(), resourceUsage.getMemoryRssBytes() / ((long) 1024), resourceUsage.getCpuCoreCount());
    }
}
