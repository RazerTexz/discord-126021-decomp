package com.discord.utilities.system;

import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.AnyThread;
import com.discord.api.permission.Permission;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.k;
import d0.k$a;
import d0.l;
import d0.v.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeviceResourceUsageMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor {
    public static final DeviceResourceUsageMonitor$Companion Companion = new DeviceResourceUsageMonitor$Companion(null);
    private static final long SC_CLK_TCK;
    private static final long SC_PAGE_SIZE;
    private static final int cpuCoreCount;
    private Long activeThreadId;
    private final Function1<DeviceResourceUsageMonitor$ResourceUsage, Unit> callback;
    private final Clock clock;
    private Thread thread;
    private final Object threadSync;
    private final TimeSpan timeSpan;

    static {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        Object objM97constructorimpl3;
        try {
            k$a k_a = k.j;
            objM97constructorimpl = k.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_CLK_TCK)));
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        if (k.m101isFailureimpl(objM97constructorimpl)) {
            objM97constructorimpl = 100L;
        }
        SC_CLK_TCK = ((Number) objM97constructorimpl).longValue();
        try {
            k$a k_a3 = k.j;
            objM97constructorimpl2 = k.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_PAGE_SIZE)));
        } catch (Throwable th2) {
            k$a k_a4 = k.j;
            objM97constructorimpl2 = k.m97constructorimpl(l.createFailure(th2));
        }
        Long lValueOf = Long.valueOf(Permission.SEND_TTS_MESSAGES);
        if (k.m101isFailureimpl(objM97constructorimpl2)) {
            objM97constructorimpl2 = lValueOf;
        }
        SC_PAGE_SIZE = ((Number) objM97constructorimpl2).longValue();
        try {
            k$a k_a5 = k.j;
            objM97constructorimpl3 = k.m97constructorimpl(Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } catch (Throwable th3) {
            k$a k_a6 = k.j;
            objM97constructorimpl3 = k.m97constructorimpl(l.createFailure(th3));
        }
        if (k.m101isFailureimpl(objM97constructorimpl3)) {
            objM97constructorimpl3 = 1;
        }
        cpuCoreCount = ((Number) objM97constructorimpl3).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceResourceUsageMonitor(TimeSpan timeSpan, Clock clock, Function1<? super DeviceResourceUsageMonitor$ResourceUsage, Unit> function1) {
        m.checkNotNullParameter(timeSpan, "timeSpan");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(function1, "callback");
        this.timeSpan = timeSpan;
        this.clock = clock;
        this.callback = function1;
        this.threadSync = new Object();
    }

    public static final /* synthetic */ void access$monitor(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
        deviceResourceUsageMonitor.monitor();
    }

    private final void monitor() throws InterruptedException {
        ProcfsReader$Stat procfsReader$Stat = null;
        Long lValueOf = null;
        while (true) {
            synchronized (this.threadSync) {
                Long l = this.activeThreadId;
                Thread threadCurrentThread = Thread.currentThread();
                m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
                long id2 = threadCurrentThread.getId();
                if (l == null || l.longValue() != id2) {
                    break;
                    break;
                }
                if (Thread.interrupted()) {
                    return;
                }
                ProcfsReader$Stat statFile = ProcfsReader.INSTANCE.readStatFile();
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                if (procfsReader$Stat != null && lValueOf != null) {
                    double totalTime = ((statFile.getTotalTime() - procfsReader$Stat.getTotalTime()) * ((long) 100)) / (SC_CLK_TCK * ((jCurrentTimeMillis - lValueOf.longValue()) / 1000.0d));
                    int i = cpuCoreCount;
                    if (i == 0) {
                        i = 1;
                    }
                    this.callback.invoke(new DeviceResourceUsageMonitor$ResourceUsage((int) (totalTime / ((double) i)), statFile.getRssPages() * SC_PAGE_SIZE, i));
                }
                lValueOf = Long.valueOf(jCurrentTimeMillis);
                Thread.sleep(this.timeSpan.toMillis());
                procfsReader$Stat = statFile;
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
            Thread threadThread$default = a.thread$default(true, true, null, "DeviceResourceUsageMonitor", 2, new DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1(this), 4, null);
            this.activeThreadId = Long.valueOf(threadThread$default.getId());
            this.thread = threadThread$default;
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
