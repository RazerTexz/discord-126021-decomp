package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BlockingAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements b, a {
    public final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1675b = new Object();
    public CountDownLatch c;

    public c(@NonNull e eVar, int i, TimeUnit timeUnit) {
        this.a = eVar;
    }

    @Override // b.i.c.m.d.i.a
    public void a(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.f1675b) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            bVar.b("Logging Crashlytics event to Firebase");
            this.c = new CountDownLatch(1);
            this.a.a.a("clx", str, bundle);
            bVar.b("Awaiting app exception callback from FA...");
            try {
                if (this.c.await(500, TimeUnit.MILLISECONDS)) {
                    bVar.b("App exception callback received from FA listener.");
                } else {
                    bVar.b("Timeout exceeded while awaiting app exception callback from FA listener.");
                }
            } catch (InterruptedException unused) {
                b.i.c.m.d.b.a.b("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.c = null;
        }
    }

    @Override // b.i.c.m.d.i.b
    public void b(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.c;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
