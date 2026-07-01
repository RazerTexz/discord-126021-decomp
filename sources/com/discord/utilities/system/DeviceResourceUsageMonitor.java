package com.discord.utilities.system;

import a0.a.a.b;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.AnyThread;
import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import com.discord.utilities.system.ProcfsReader;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.Result2;
import d0.Result3;
import d0.v.Thread2;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor {
    private static final long SC_CLK_TCK;
    private static final long SC_PAGE_SIZE;
    private static final int cpuCoreCount;
    private Long activeThreadId;
    private final Function1<ResourceUsage, Unit> callback;
    private final Clock clock;
    private Thread thread;
    private final Object threadSync;
    private final TimeSpan timeSpan;

    /* JADX INFO: compiled from: DeviceResourceUsageMonitor.kt */
    public static final /* data */ class ResourceUsage {
        private final int cpuCoreCount;
        private final int cpuUsagePercent;
        private final long memoryRssBytes;

        public ResourceUsage(int i, long j, int i2) {
            this.cpuUsagePercent = i;
            this.memoryRssBytes = j;
            this.cpuCoreCount = i2;
        }

        public static /* synthetic */ ResourceUsage copy$default(ResourceUsage resourceUsage, int i, long j, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = resourceUsage.cpuUsagePercent;
            }
            if ((i3 & 2) != 0) {
                j = resourceUsage.memoryRssBytes;
            }
            if ((i3 & 4) != 0) {
                i2 = resourceUsage.cpuCoreCount;
            }
            return resourceUsage.copy(i, j, i2);
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

        public final ResourceUsage copy(int cpuUsagePercent, long memoryRssBytes, int cpuCoreCount) {
            return new ResourceUsage(cpuUsagePercent, memoryRssBytes, cpuCoreCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceUsage)) {
                return false;
            }
            ResourceUsage resourceUsage = (ResourceUsage) other;
            return this.cpuUsagePercent == resourceUsage.cpuUsagePercent && this.memoryRssBytes == resourceUsage.memoryRssBytes && this.cpuCoreCount == resourceUsage.cpuCoreCount;
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
            StringBuilder sbU = outline.U("ResourceUsage(cpuUsagePercent=");
            sbU.append(this.cpuUsagePercent);
            sbU.append(", memoryRssBytes=");
            sbU.append(this.memoryRssBytes);
            sbU.append(", cpuCoreCount=");
            return outline.B(sbU, this.cpuCoreCount, ")");
        }
    }

    static {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        Object objM97constructorimpl3;
        try {
            Result2.a aVar = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_CLK_TCK)));
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        if (Result2.m101isFailureimpl(objM97constructorimpl)) {
            objM97constructorimpl = 100L;
        }
        SC_CLK_TCK = ((Number) objM97constructorimpl).longValue();
        try {
            Result2.a aVar3 = Result2.j;
            objM97constructorimpl2 = Result2.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_PAGE_SIZE)));
        } catch (Throwable th2) {
            Result2.a aVar4 = Result2.j;
            objM97constructorimpl2 = Result2.m97constructorimpl(Result3.createFailure(th2));
        }
        Long lValueOf = Long.valueOf(Permission.SEND_TTS_MESSAGES);
        if (Result2.m101isFailureimpl(objM97constructorimpl2)) {
            objM97constructorimpl2 = lValueOf;
        }
        SC_PAGE_SIZE = ((Number) objM97constructorimpl2).longValue();
        try {
            Result2.a aVar5 = Result2.j;
            objM97constructorimpl3 = Result2.m97constructorimpl(Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } catch (Throwable th3) {
            Result2.a aVar6 = Result2.j;
            objM97constructorimpl3 = Result2.m97constructorimpl(Result3.createFailure(th3));
        }
        if (Result2.m101isFailureimpl(objM97constructorimpl3)) {
            objM97constructorimpl3 = 1;
        }
        cpuCoreCount = ((Number) objM97constructorimpl3).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceResourceUsageMonitor(TimeSpan timeSpan, Clock clock, Function1<? super ResourceUsage, Unit> function1) {
        Intrinsics3.checkNotNullParameter(timeSpan, "timeSpan");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        this.timeSpan = timeSpan;
        this.clock = clock;
        this.callback = function1;
        this.threadSync = new Object();
    }

    private final void monitor() throws InterruptedException {
        ProcfsReader.Stat stat = null;
        Long lValueOf = null;
        while (true) {
            synchronized (this.threadSync) {
                Long l = this.activeThreadId;
                Thread threadCurrentThread = Thread.currentThread();
                Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
                long id2 = threadCurrentThread.getId();
                if (l == null || l.longValue() != id2) {
                    break;
                    break;
                }
                if (Thread.interrupted()) {
                    return;
                }
                ProcfsReader.Stat statFile = ProcfsReader.INSTANCE.readStatFile();
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                if (stat != null && lValueOf != null) {
                    double totalTime = ((statFile.getTotalTime() - stat.getTotalTime()) * ((long) 100)) / (SC_CLK_TCK * ((jCurrentTimeMillis - lValueOf.longValue()) / 1000.0d));
                    int i = cpuCoreCount;
                    if (i == 0) {
                        i = 1;
                    }
                    this.callback.invoke(new ResourceUsage((int) (totalTime / ((double) i)), statFile.getRssPages() * SC_PAGE_SIZE, i));
                }
                lValueOf = Long.valueOf(jCurrentTimeMillis);
                Thread.sleep(this.timeSpan.toMillis());
                stat = statFile;
            }
        }
    }

    @AnyThread
    public final void finalize() {
        stop();
    }

    @AnyThread
    public final void start() {
        Thread thread;
        synchronized (this.threadSync) {
            thread = this.thread;
            Thread thread2 = Thread2.thread((4 & 1) != 0 ? true : true, (4 & 2) != 0 ? false : true, (4 & 4) != 0 ? null : null, (4 & 8) != 0 ? null : "DeviceResourceUsageMonitor", (4 & 16) != 0 ? -1 : 2, new DeviceResourceUsageMonitor2(this));
            this.activeThreadId = Long.valueOf(thread2.getId());
            this.thread = thread2;
        }
        if (thread != null) {
            thread.interrupt();
        }
    }

    @AnyThread
    public final void stop() {
        Thread thread;
        synchronized (this.threadSync) {
            thread = this.thread;
            this.thread = null;
            this.activeThreadId = null;
        }
        if (thread != null) {
            thread.interrupt();
        }
    }
}
