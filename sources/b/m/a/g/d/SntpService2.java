package b.m.a.g.d;

import b.m.a.Clock5;
import b.m.a.Clock6;
import b.m.a.SyncListener;
import b.m.a.g.d.SntpClient;
import com.lyft.kronos.internal.ntp.NTPSyncException;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.m.a.g.d.i, reason: use source file name */
/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SntpService2 implements SntpService {
    public final AtomicReference<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f1909b;
    public final ExecutorService c;
    public final SntpClient d;
    public final Clock5 e;
    public final SntpResponseCache f;
    public final SyncListener g;
    public final List<String> h;
    public final long i;
    public final long j;
    public final long k;

    /* JADX INFO: renamed from: b.m.a.g.d.i$a */
    /* JADX INFO: compiled from: SntpService.kt */
    public enum a {
        INIT,
        IDLE,
        SYNCING,
        STOPPED
    }

    /* JADX INFO: renamed from: b.m.a.g.d.i$b */
    /* JADX INFO: compiled from: SntpService.kt */
    public static final class b implements ThreadFactory {
        public static final b j = new b();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "kronos-android");
        }
    }

    /* JADX INFO: renamed from: b.m.a.g.d.i$c */
    /* JADX INFO: compiled from: SntpService.kt */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z2;
            SntpService2 sntpService2 = SntpService2.this;
            sntpService2.c();
            Iterator<String> it = sntpService2.h.iterator();
            do {
                z2 = false;
                if (!it.hasNext()) {
                    return;
                }
                String next = it.next();
                a aVar = a.IDLE;
                AtomicReference<a> atomicReference = sntpService2.a;
                a aVar2 = a.SYNCING;
                if (atomicReference.getAndSet(aVar2) != aVar2) {
                    long jB = sntpService2.e.b();
                    SyncListener syncListener = sntpService2.g;
                    if (syncListener != null) {
                        syncListener.a(next);
                    }
                    try {
                        SntpClient.b bVarD = sntpService2.d.d(next, Long.valueOf(sntpService2.i));
                        Intrinsics3.checkExpressionValueIsNotNull(bVarD, "response");
                        if (bVarD.a() < 0) {
                            throw new NTPSyncException("Invalid time " + bVarD.a() + " received from " + next);
                        }
                        sntpService2.f.a(bVarD);
                        long j = bVarD.c;
                        long jB2 = sntpService2.e.b() - jB;
                        SyncListener syncListener2 = sntpService2.g;
                        if (syncListener2 != null) {
                            syncListener2.b(j, jB2);
                        }
                        sntpService2.a.set(aVar);
                        sntpService2.f1909b.set(sntpService2.e.b());
                        z2 = true;
                    } catch (Throwable th) {
                        try {
                            SyncListener syncListener3 = sntpService2.g;
                            if (syncListener3 != null) {
                                syncListener3.c(next, th);
                            }
                            sntpService2.a.set(aVar);
                            sntpService2.f1909b.set(sntpService2.e.b());
                        } catch (Throwable th2) {
                            sntpService2.a.set(aVar);
                            sntpService2.f1909b.set(sntpService2.e.b());
                            throw th2;
                        }
                    }
                }
            } while (!z2);
        }
    }

    public SntpService2(SntpClient sntpClient, Clock5 clock5, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2, long j3) {
        Intrinsics3.checkParameterIsNotNull(sntpClient, "sntpClient");
        Intrinsics3.checkParameterIsNotNull(clock5, "deviceClock");
        Intrinsics3.checkParameterIsNotNull(sntpResponseCache, "responseCache");
        Intrinsics3.checkParameterIsNotNull(list, "ntpHosts");
        this.d = sntpClient;
        this.e = clock5;
        this.f = sntpResponseCache;
        this.g = syncListener;
        this.h = list;
        this.i = j;
        this.j = j2;
        this.k = j3;
        this.a = new AtomicReference<>(a.INIT);
        this.f1909b = new AtomicLong(0L);
        this.c = Executors.newSingleThreadExecutor(b.j);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003c  */
    @Override // b.m.a.g.d.SntpService
    public Clock6 a() {
        boolean z2;
        c();
        SntpClient.b bVar = this.f.get();
        if (this.a.compareAndSet(a.INIT, a.IDLE) && bVar != null) {
            z2 = (Math.abs((bVar.a - bVar.f1907b) - (bVar.d.a() - bVar.d.b())) > 1000L ? 1 : (Math.abs((bVar.a - bVar.f1907b) - (bVar.d.a() - bVar.d.b())) == 1000L ? 0 : -1)) < 0 ? false : true;
        }
        if (z2) {
            this.f.clear();
            bVar = null;
        }
        if (bVar == null) {
            if (this.e.b() - this.f1909b.get() >= this.j) {
                b();
            }
            return null;
        }
        long jB = bVar.d.b() - bVar.f1907b;
        if (jB >= this.k && this.e.b() - this.f1909b.get() >= this.j) {
            b();
        }
        return new Clock6(bVar.a(), Long.valueOf(jB));
    }

    @Override // b.m.a.g.d.SntpService
    public void b() {
        c();
        if (this.a.get() != a.SYNCING) {
            this.c.submit(new c());
        }
    }

    public final void c() {
        if (this.a.get() == a.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }
}
