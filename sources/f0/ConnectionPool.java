package f0;

import d0.z.d.Intrinsics3;
import f0.e0.f.TaskRunner;
import f0.e0.g.RealConnectionPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: f0.l, reason: use source file name */
/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionPool {
    public final RealConnectionPool a;

    public ConnectionPool() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        RealConnectionPool realConnectionPool = new RealConnectionPool(TaskRunner.a, 5, 5L, timeUnit);
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "delegate");
        this.a = realConnectionPool;
    }
}
