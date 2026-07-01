package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.Logger3;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.i.c.m.d.i.c, reason: use source file name */
/* JADX INFO: compiled from: BlockingAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    public final CrashlyticsOriginAnalyticsEventLogger a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1675b = new Object();
    public CountDownLatch c;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit) {
        this.a = crashlyticsOriginAnalyticsEventLogger;
    }

    @Override // b.i.c.m.d.i.AnalyticsEventLogger
    public void a(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.f1675b) {
            Logger3 logger3 = Logger3.a;
            logger3.b("Logging Crashlytics event to Firebase");
            this.c = new CountDownLatch(1);
            this.a.a.a("clx", str, bundle);
            logger3.b("Awaiting app exception callback from FA...");
            try {
                if (this.c.await(500, TimeUnit.MILLISECONDS)) {
                    logger3.b("App exception callback received from FA listener.");
                } else {
                    logger3.b("Timeout exceeded while awaiting app exception callback from FA listener.");
                }
            } catch (InterruptedException unused) {
                Logger3.a.b("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.c = null;
        }
    }

    @Override // b.i.c.m.d.i.AnalyticsEventReceiver
    public void b(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.c;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
