package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeSpan;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor {
    public static final AnalyticsDeviceResourceUsageMonitor INSTANCE = new AnalyticsDeviceResourceUsageMonitor();
    private static final DeviceResourceUsageMonitor resourceMonitor = new DeviceResourceUsageMonitor(new TimeSpan(1, TimeUnit.SECONDS), ClockFactory.get(), AnalyticsDeviceResourceUsageMonitor2.INSTANCE);

    private AnalyticsDeviceResourceUsageMonitor() {
    }

    public final void start() {
        resourceMonitor.start();
    }
}
