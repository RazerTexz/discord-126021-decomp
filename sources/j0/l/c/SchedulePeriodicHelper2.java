package j0.l.c;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: j0.l.c.i, reason: use source file name */
/* JADX INFO: compiled from: SchedulePeriodicHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchedulePeriodicHelper2 {
    public static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3791b = 0;

    /* JADX INFO: renamed from: j0.l.c.i$a */
    /* JADX INFO: compiled from: SchedulePeriodicHelper.java */
    public interface a {
        long a();
    }
}
