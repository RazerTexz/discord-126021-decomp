package com.discord.utilities.system;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: DeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DeviceResourceUsageMonitor$ResourceUsage {
    private final int cpuCoreCount;
    private final int cpuUsagePercent;
    private final long memoryRssBytes;

    public DeviceResourceUsageMonitor$ResourceUsage(int i, long j, int i2) {
        this.cpuUsagePercent = i;
        this.memoryRssBytes = j;
        this.cpuCoreCount = i2;
    }

    public static /* synthetic */ DeviceResourceUsageMonitor$ResourceUsage copy$default(DeviceResourceUsageMonitor$ResourceUsage deviceResourceUsageMonitor$ResourceUsage, int i, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = deviceResourceUsageMonitor$ResourceUsage.cpuUsagePercent;
        }
        if ((i3 & 2) != 0) {
            j = deviceResourceUsageMonitor$ResourceUsage.memoryRssBytes;
        }
        if ((i3 & 4) != 0) {
            i2 = deviceResourceUsageMonitor$ResourceUsage.cpuCoreCount;
        }
        return deviceResourceUsageMonitor$ResourceUsage.copy(i, j, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCpuUsagePercent() {
        return this.cpuUsagePercent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMemoryRssBytes() {
        return this.memoryRssBytes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCpuCoreCount() {
        return this.cpuCoreCount;
    }

    public final DeviceResourceUsageMonitor$ResourceUsage copy(int cpuUsagePercent, long memoryRssBytes, int cpuCoreCount) {
        return new DeviceResourceUsageMonitor$ResourceUsage(cpuUsagePercent, memoryRssBytes, cpuCoreCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceResourceUsageMonitor$ResourceUsage)) {
            return false;
        }
        DeviceResourceUsageMonitor$ResourceUsage deviceResourceUsageMonitor$ResourceUsage = (DeviceResourceUsageMonitor$ResourceUsage) other;
        return this.cpuUsagePercent == deviceResourceUsageMonitor$ResourceUsage.cpuUsagePercent && this.memoryRssBytes == deviceResourceUsageMonitor$ResourceUsage.memoryRssBytes && this.cpuCoreCount == deviceResourceUsageMonitor$ResourceUsage.cpuCoreCount;
    }

    public final int getCpuCoreCount() {
        return this.cpuCoreCount;
    }

    public final int getCpuUsagePercent() {
        return this.cpuUsagePercent;
    }

    public final long getMemoryRssBytes() {
        return this.memoryRssBytes;
    }

    public int hashCode() {
        return ((b.a(this.memoryRssBytes) + (this.cpuUsagePercent * 31)) * 31) + this.cpuCoreCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("ResourceUsage(cpuUsagePercent=");
        sbU.append(this.cpuUsagePercent);
        sbU.append(", memoryRssBytes=");
        sbU.append(this.memoryRssBytes);
        sbU.append(", cpuCoreCount=");
        return a.B(sbU, this.cpuCoreCount, ")");
    }
}
