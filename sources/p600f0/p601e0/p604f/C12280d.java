package p600f0.p601e0.p604f;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.ThreadFactoryC12271b;

/* JADX INFO: renamed from: f0.e0.f.d */
/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12280d {

    /* JADX INFO: renamed from: a */
    public static final C12280d f25420a;

    /* JADX INFO: renamed from: b */
    public static final Logger f25421b;

    /* JADX INFO: renamed from: c */
    public static final b f25422c = new b(null);

    /* JADX INFO: renamed from: d */
    public int f25423d;

    /* JADX INFO: renamed from: e */
    public boolean f25424e;

    /* JADX INFO: renamed from: f */
    public long f25425f;

    /* JADX INFO: renamed from: g */
    public final List<C12279c> f25426g;

    /* JADX INFO: renamed from: h */
    public final List<C12279c> f25427h;

    /* JADX INFO: renamed from: i */
    public final Runnable f25428i;

    /* JADX INFO: renamed from: j */
    public final a f25429j;

    /* JADX INFO: renamed from: f0.e0.f.d$a */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo10163a(C12280d c12280d);

        /* JADX INFO: renamed from: b */
        void mo10164b(C12280d c12280d, long j);

        /* JADX INFO: renamed from: c */
        long mo10165c();

        void execute(Runnable runnable);
    }

    /* JADX INFO: renamed from: f0.e0.f.d$b */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: f0.e0.f.d$c */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class c implements a {

        /* JADX INFO: renamed from: a */
        public final ThreadPoolExecutor f25430a;

        public c(ThreadFactory threadFactory) {
            C12238m.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.f25430a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // p600f0.p601e0.p604f.C12280d.a
        /* JADX INFO: renamed from: a */
        public void mo10163a(C12280d c12280d) {
            C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
            c12280d.notify();
        }

        @Override // p600f0.p601e0.p604f.C12280d.a
        /* JADX INFO: renamed from: b */
        public void mo10164b(C12280d c12280d, long j) throws InterruptedException {
            C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                c12280d.wait(j2, (int) j3);
            }
        }

        @Override // p600f0.p601e0.p604f.C12280d.a
        /* JADX INFO: renamed from: c */
        public long mo10165c() {
            return System.nanoTime();
        }

        @Override // p600f0.p601e0.p604f.C12280d.a
        public void execute(Runnable runnable) {
            C12238m.checkParameterIsNotNull(runnable, "runnable");
            this.f25430a.execute(runnable);
        }
    }

    /* JADX INFO: renamed from: f0.e0.f.d$d */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC12277a abstractC12277aM10159c;
            while (true) {
                synchronized (C12280d.this) {
                    abstractC12277aM10159c = C12280d.this.m10159c();
                }
                if (abstractC12277aM10159c == null) {
                    return;
                }
                C12279c c12279c = abstractC12277aM10159c.f25409a;
                if (c12279c == null) {
                    C12238m.throwNpe();
                }
                long jMo10165c = -1;
                b bVar = C12280d.f25422c;
                boolean zIsLoggable = C12280d.f25421b.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jMo10165c = c12279c.f25418e.f25429j.mo10165c();
                    C3404f.m4283e(abstractC12277aM10159c, c12279c, "starting");
                }
                try {
                    C12280d.m10157a(C12280d.this, abstractC12277aM10159c);
                    if (zIsLoggable) {
                        long jMo10165c2 = c12279c.f25418e.f25429j.mo10165c() - jMo10165c;
                        StringBuilder sbM833U = C1643a.m833U("finished run in ");
                        sbM833U.append(C3404f.m4268a0(jMo10165c2));
                        C3404f.m4283e(abstractC12277aM10159c, c12279c, sbM833U.toString());
                    }
                } catch (Throwable th) {
                    try {
                        C12280d.this.f25429j.execute(this);
                        throw th;
                    } catch (Throwable th2) {
                        if (zIsLoggable) {
                            long jMo10165c3 = c12279c.f25418e.f25429j.mo10165c() - jMo10165c;
                            StringBuilder sbM833U2 = C1643a.m833U("failed a run in ");
                            sbM833U2.append(C3404f.m4268a0(jMo10165c3));
                            C3404f.m4283e(abstractC12277aM10159c, c12279c, sbM833U2.toString());
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    static {
        String str = C12272c.f25403g + " TaskRunner";
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        f25420a = new C12280d(new c(new ThreadFactoryC12271b(str, true)));
        Logger logger = Logger.getLogger(C12280d.class.getName());
        C12238m.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f25421b = logger;
    }

    public C12280d(a aVar) {
        C12238m.checkParameterIsNotNull(aVar, "backend");
        this.f25429j = aVar;
        this.f25423d = 10000;
        this.f25426g = new ArrayList();
        this.f25427h = new ArrayList();
        this.f25428i = new d();
    }

    /* JADX INFO: renamed from: a */
    public static final void m10157a(C12280d c12280d, AbstractC12277a abstractC12277a) {
        Objects.requireNonNull(c12280d);
        byte[] bArr = C12272c.f25397a;
        Thread threadCurrentThread = Thread.currentThread();
        C12238m.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(abstractC12277a.f25411c);
        try {
            long jMo10150a = abstractC12277a.mo10150a();
            synchronized (c12280d) {
                c12280d.m10158b(abstractC12277a, jMo10150a);
            }
        } finally {
            synchronized (c12280d) {
                c12280d.m10158b(abstractC12277a, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10158b(AbstractC12277a abstractC12277a, long j) {
        byte[] bArr = C12272c.f25397a;
        C12279c c12279c = abstractC12277a.f25409a;
        if (c12279c == null) {
            C12238m.throwNpe();
        }
        if (!(c12279c.f25415b == abstractC12277a)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean z2 = c12279c.f25417d;
        c12279c.f25417d = false;
        c12279c.f25415b = null;
        this.f25426g.remove(c12279c);
        if (j != -1 && !z2 && !c12279c.f25414a) {
            c12279c.m10155e(abstractC12277a, j, true);
        }
        if (!c12279c.f25416c.isEmpty()) {
            this.f25427h.add(c12279c);
        }
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC12277a m10159c() {
        boolean z2;
        byte[] bArr = C12272c.f25397a;
        while (!this.f25427h.isEmpty()) {
            long jMo10165c = this.f25429j.mo10165c();
            long jMin = RecyclerView.FOREVER_NS;
            Iterator<C12279c> it = this.f25427h.iterator();
            AbstractC12277a abstractC12277a = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                AbstractC12277a abstractC12277a2 = it.next().f25416c.get(0);
                long jMax = Math.max(0L, abstractC12277a2.f25410b - jMo10165c);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (abstractC12277a != null) {
                        z2 = true;
                        break;
                    }
                    abstractC12277a = abstractC12277a2;
                }
            }
            if (abstractC12277a != null) {
                byte[] bArr2 = C12272c.f25397a;
                abstractC12277a.f25410b = -1L;
                C12279c c12279c = abstractC12277a.f25409a;
                if (c12279c == null) {
                    C12238m.throwNpe();
                }
                c12279c.f25416c.remove(abstractC12277a);
                this.f25427h.remove(c12279c);
                c12279c.f25415b = abstractC12277a;
                this.f25426g.add(c12279c);
                if (z2 || (!this.f25424e && (!this.f25427h.isEmpty()))) {
                    this.f25429j.execute(this.f25428i);
                }
                return abstractC12277a;
            }
            if (this.f25424e) {
                if (jMin < this.f25425f - jMo10165c) {
                    this.f25429j.mo10163a(this);
                }
                return null;
            }
            this.f25424e = true;
            this.f25425f = jMo10165c + jMin;
            try {
                try {
                    this.f25429j.mo10164b(this, jMin);
                } catch (InterruptedException unused) {
                    m10160d();
                }
                this.f25424e = false;
            } catch (Throwable th) {
                this.f25424e = false;
                throw th;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final void m10160d() {
        for (int size = this.f25426g.size() - 1; size >= 0; size--) {
            this.f25426g.get(size).m10153b();
        }
        for (int size2 = this.f25427h.size() - 1; size2 >= 0; size2--) {
            C12279c c12279c = this.f25427h.get(size2);
            c12279c.m10153b();
            if (c12279c.f25416c.isEmpty()) {
                this.f25427h.remove(size2);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m10161e(C12279c c12279c) {
        C12238m.checkParameterIsNotNull(c12279c, "taskQueue");
        byte[] bArr = C12272c.f25397a;
        if (c12279c.f25415b == null) {
            if (!c12279c.f25416c.isEmpty()) {
                List<C12279c> list = this.f25427h;
                C12238m.checkParameterIsNotNull(list, "$this$addIfAbsent");
                if (!list.contains(c12279c)) {
                    list.add(c12279c);
                }
            } else {
                this.f25427h.remove(c12279c);
            }
        }
        if (this.f25424e) {
            this.f25429j.mo10163a(this);
        } else {
            this.f25429j.execute(this.f25428i);
        }
    }

    /* JADX INFO: renamed from: f */
    public final C12279c m10162f() {
        int i;
        synchronized (this) {
            i = this.f25423d;
            this.f25423d = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new C12279c(this, sb.toString());
    }
}
