package p007b.p225i.p361c.p369m.p370d.p371i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.i.c */
/* JADX INFO: compiled from: BlockingAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4601c implements InterfaceC4600b, InterfaceC4599a {

    /* JADX INFO: renamed from: a */
    public final C4603e f12247a;

    /* JADX INFO: renamed from: b */
    public final Object f12248b = new Object();

    /* JADX INFO: renamed from: c */
    public CountDownLatch f12249c;

    public C4601c(@NonNull C4603e c4603e, int i, TimeUnit timeUnit) {
        this.f12247a = c4603e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4599a
    /* JADX INFO: renamed from: a */
    public void mo6386a(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.f12248b) {
            C4592b c4592b = C4592b.f12227a;
            c4592b.m6371b("Logging Crashlytics event to Firebase");
            this.f12249c = new CountDownLatch(1);
            this.f12247a.f12251a.mo6338a("clx", str, bundle);
            c4592b.m6371b("Awaiting app exception callback from FA...");
            try {
                if (this.f12249c.await(500, TimeUnit.MILLISECONDS)) {
                    c4592b.m6371b("App exception callback received from FA listener.");
                } else {
                    c4592b.m6371b("Timeout exceeded while awaiting app exception callback from FA listener.");
                }
            } catch (InterruptedException unused) {
                C4592b.f12227a.m6371b("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.f12249c = null;
        }
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4600b
    /* JADX INFO: renamed from: b */
    public void mo6387b(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f12249c;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
