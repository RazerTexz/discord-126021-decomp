package p007b.p445m.p446a.p447g.p448d;

import com.lyft.kronos.internal.ntp.NTPSyncException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p445m.p446a.C5085d;
import p007b.p445m.p446a.InterfaceC5083b;
import p007b.p445m.p446a.InterfaceC5086e;
import p007b.p445m.p446a.p447g.p448d.C5095e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.g.d.i */
/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5099i implements InterfaceC5098h {

    /* JADX INFO: renamed from: a */
    public final AtomicReference<a> f13658a;

    /* JADX INFO: renamed from: b */
    public final AtomicLong f13659b;

    /* JADX INFO: renamed from: c */
    public final ExecutorService f13660c;

    /* JADX INFO: renamed from: d */
    public final C5095e f13661d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC5083b f13662e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC5096f f13663f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC5086e f13664g;

    /* JADX INFO: renamed from: h */
    public final List<String> f13665h;

    /* JADX INFO: renamed from: i */
    public final long f13666i;

    /* JADX INFO: renamed from: j */
    public final long f13667j;

    /* JADX INFO: renamed from: k */
    public final long f13668k;

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

        /* JADX INFO: renamed from: j */
        public static final b f13674j = new b();

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
            C5099i c5099i = C5099i.this;
            c5099i.m7152c();
            Iterator<String> it = c5099i.f13665h.iterator();
            do {
                z2 = false;
                if (!it.hasNext()) {
                    return;
                }
                String next = it.next();
                a aVar = a.IDLE;
                AtomicReference<a> atomicReference = c5099i.f13658a;
                a aVar2 = a.SYNCING;
                if (atomicReference.getAndSet(aVar2) != aVar2) {
                    long jMo7129b = c5099i.f13662e.mo7129b();
                    InterfaceC5086e interfaceC5086e = c5099i.f13664g;
                    if (interfaceC5086e != null) {
                        interfaceC5086e.m7130a(next);
                    }
                    try {
                        C5095e.b bVarM7147d = c5099i.f13661d.m7147d(next, Long.valueOf(c5099i.f13666i));
                        C12238m.checkExpressionValueIsNotNull(bVarM7147d, "response");
                        if (bVarM7147d.m7148a() < 0) {
                            throw new NTPSyncException("Invalid time " + bVarM7147d.m7148a() + " received from " + next);
                        }
                        c5099i.f13663f.mo7149a(bVarM7147d);
                        long j = bVarM7147d.f13654c;
                        long jMo7129b2 = c5099i.f13662e.mo7129b() - jMo7129b;
                        InterfaceC5086e interfaceC5086e2 = c5099i.f13664g;
                        if (interfaceC5086e2 != null) {
                            interfaceC5086e2.m7131b(j, jMo7129b2);
                        }
                        c5099i.f13658a.set(aVar);
                        c5099i.f13659b.set(c5099i.f13662e.mo7129b());
                        z2 = true;
                    } catch (Throwable th) {
                        try {
                            InterfaceC5086e interfaceC5086e3 = c5099i.f13664g;
                            if (interfaceC5086e3 != null) {
                                interfaceC5086e3.m7132c(next, th);
                            }
                            c5099i.f13658a.set(aVar);
                            c5099i.f13659b.set(c5099i.f13662e.mo7129b());
                        } catch (Throwable th2) {
                            c5099i.f13658a.set(aVar);
                            c5099i.f13659b.set(c5099i.f13662e.mo7129b());
                            throw th2;
                        }
                    }
                }
            } while (!z2);
        }
    }

    public C5099i(C5095e c5095e, InterfaceC5083b interfaceC5083b, InterfaceC5096f interfaceC5096f, InterfaceC5086e interfaceC5086e, List<String> list, long j, long j2, long j3) {
        C12238m.checkParameterIsNotNull(c5095e, "sntpClient");
        C12238m.checkParameterIsNotNull(interfaceC5083b, "deviceClock");
        C12238m.checkParameterIsNotNull(interfaceC5096f, "responseCache");
        C12238m.checkParameterIsNotNull(list, "ntpHosts");
        this.f13661d = c5095e;
        this.f13662e = interfaceC5083b;
        this.f13663f = interfaceC5096f;
        this.f13664g = interfaceC5086e;
        this.f13665h = list;
        this.f13666i = j;
        this.f13667j = j2;
        this.f13668k = j3;
        this.f13658a = new AtomicReference<>(a.INIT);
        this.f13659b = new AtomicLong(0L);
        this.f13660c = Executors.newSingleThreadExecutor(b.f13674j);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003c  */
    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5098h
    /* JADX INFO: renamed from: a */
    public C5085d mo7150a() {
        boolean z2;
        m7152c();
        C5095e.b bVar = this.f13663f.get();
        if (this.f13658a.compareAndSet(a.INIT, a.IDLE) && bVar != null) {
            z2 = (Math.abs((bVar.f13652a - bVar.f13653b) - (bVar.f13655d.mo7128a() - bVar.f13655d.mo7129b())) > 1000L ? 1 : (Math.abs((bVar.f13652a - bVar.f13653b) - (bVar.f13655d.mo7128a() - bVar.f13655d.mo7129b())) == 1000L ? 0 : -1)) < 0 ? false : true;
        }
        if (z2) {
            this.f13663f.clear();
            bVar = null;
        }
        if (bVar == null) {
            if (this.f13662e.mo7129b() - this.f13659b.get() >= this.f13667j) {
                mo7151b();
            }
            return null;
        }
        long jMo7129b = bVar.f13655d.mo7129b() - bVar.f13653b;
        if (jMo7129b >= this.f13668k && this.f13662e.mo7129b() - this.f13659b.get() >= this.f13667j) {
            mo7151b();
        }
        return new C5085d(bVar.m7148a(), Long.valueOf(jMo7129b));
    }

    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5098h
    /* JADX INFO: renamed from: b */
    public void mo7151b() {
        m7152c();
        if (this.f13658a.get() != a.SYNCING) {
            this.f13660c.submit(new c());
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m7152c() {
        if (this.f13658a.get() == a.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }
}
