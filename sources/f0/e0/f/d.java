package f0.e0.f;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3611b;
    public static final d$b c = new d$b(null);
    public int d;
    public boolean e;
    public long f;
    public final List<c> g;
    public final List<c> h;
    public final Runnable i;
    public final d$a j;

    static {
        String str = f0.e0.c.g + " TaskRunner";
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        a = new d(new d$c(new f0.e0.b(str, true)));
        Logger logger = Logger.getLogger(d.class.getName());
        m.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f3611b = logger;
    }

    public d(d$a d_a) {
        m.checkParameterIsNotNull(d_a, "backend");
        this.j = d_a;
        this.d = 10000;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new d$d(this);
    }

    public static final void a(d dVar, a aVar) {
        Objects.requireNonNull(dVar);
        byte[] bArr = f0.e0.c.a;
        Thread threadCurrentThread = Thread.currentThread();
        m.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.c);
        try {
            long jA = aVar.a();
            synchronized (dVar) {
                dVar.b(aVar, jA);
            }
        } finally {
            synchronized (dVar) {
                dVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void b(a aVar, long j) {
        byte[] bArr = f0.e0.c.a;
        c cVar = aVar.a;
        if (cVar == null) {
            m.throwNpe();
        }
        if (!(cVar.f3610b == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean z2 = cVar.d;
        cVar.d = false;
        cVar.f3610b = null;
        this.g.remove(cVar);
        if (j != -1 && !z2 && !cVar.a) {
            cVar.e(aVar, j, true);
        }
        if (!cVar.c.isEmpty()) {
            this.h.add(cVar);
        }
    }

    public final a c() {
        boolean z2;
        byte[] bArr = f0.e0.c.a;
        while (!this.h.isEmpty()) {
            long jC = this.j.c();
            long jMin = RecyclerView.FOREVER_NS;
            Iterator<c> it = this.h.iterator();
            a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                a aVar2 = it.next().c.get(0);
                long jMax = Math.max(0L, aVar2.f3609b - jC);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z2 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                byte[] bArr2 = f0.e0.c.a;
                aVar.f3609b = -1L;
                c cVar = aVar.a;
                if (cVar == null) {
                    m.throwNpe();
                }
                cVar.c.remove(aVar);
                this.h.remove(cVar);
                cVar.f3610b = aVar;
                this.g.add(cVar);
                if (z2 || (!this.e && (!this.h.isEmpty()))) {
                    this.j.execute(this.i);
                }
                return aVar;
            }
            if (this.e) {
                if (jMin < this.f - jC) {
                    this.j.a(this);
                }
                return null;
            }
            this.e = true;
            this.f = jC + jMin;
            try {
                try {
                    this.j.b(this, jMin);
                } catch (InterruptedException unused) {
                    d();
                }
                this.e = false;
            } catch (Throwable th) {
                this.e = false;
                throw th;
            }
        }
        return null;
    }

    public final void d() {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            this.g.get(size).b();
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            c cVar = this.h.get(size2);
            cVar.b();
            if (cVar.c.isEmpty()) {
                this.h.remove(size2);
            }
        }
    }

    public final void e(c cVar) {
        m.checkParameterIsNotNull(cVar, "taskQueue");
        byte[] bArr = f0.e0.c.a;
        if (cVar.f3610b == null) {
            if (!cVar.c.isEmpty()) {
                List<c> list = this.h;
                m.checkParameterIsNotNull(list, "$this$addIfAbsent");
                if (!list.contains(cVar)) {
                    list.add(cVar);
                }
            } else {
                this.h.remove(cVar);
            }
        }
        if (this.e) {
            this.j.a(this);
        } else {
            this.j.execute(this.i);
        }
    }

    public final c f() {
        int i;
        synchronized (this) {
            i = this.d;
            this.d = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new c(this, sb.toString());
    }
}
