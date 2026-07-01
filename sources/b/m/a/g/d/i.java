package b.m.a.g.d;

import d0.z.d.m;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements h {
    public final AtomicReference<i$a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f1909b;
    public final ExecutorService c;
    public final e d;
    public final b.m.a.b e;
    public final f f;
    public final b.m.a.e g;
    public final List<String> h;
    public final long i;
    public final long j;
    public final long k;

    public i(e eVar, b.m.a.b bVar, f fVar, b.m.a.e eVar2, List<String> list, long j, long j2, long j3) {
        m.checkParameterIsNotNull(eVar, "sntpClient");
        m.checkParameterIsNotNull(bVar, "deviceClock");
        m.checkParameterIsNotNull(fVar, "responseCache");
        m.checkParameterIsNotNull(list, "ntpHosts");
        this.d = eVar;
        this.e = bVar;
        this.f = fVar;
        this.g = eVar2;
        this.h = list;
        this.i = j;
        this.j = j2;
        this.k = j3;
        this.a = new AtomicReference<>(i$a.INIT);
        this.f1909b = new AtomicLong(0L);
        this.c = Executors.newSingleThreadExecutor(i$b.j);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003c  */
    @Override // b.m.a.g.d.h
    public b.m.a.d a() {
        boolean z2;
        c();
        e$b e_b = this.f.get();
        if (this.a.compareAndSet(i$a.INIT, i$a.IDLE) && e_b != null) {
            z2 = (Math.abs((e_b.a - e_b.f1907b) - (e_b.d.a() - e_b.d.b())) > 1000L ? 1 : (Math.abs((e_b.a - e_b.f1907b) - (e_b.d.a() - e_b.d.b())) == 1000L ? 0 : -1)) < 0 ? false : true;
        }
        if (z2) {
            this.f.clear();
            e_b = null;
        }
        if (e_b == null) {
            if (this.e.b() - this.f1909b.get() >= this.j) {
                b();
            }
            return null;
        }
        long jB = e_b.d.b() - e_b.f1907b;
        if (jB >= this.k && this.e.b() - this.f1909b.get() >= this.j) {
            b();
        }
        return new b.m.a.d(e_b.a(), Long.valueOf(jB));
    }

    @Override // b.m.a.g.d.h
    public void b() {
        c();
        if (this.a.get() != i$a.SYNCING) {
            this.c.submit(new i$c(this));
        }
    }

    public final void c() {
        if (this.a.get() == i$a.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }
}
