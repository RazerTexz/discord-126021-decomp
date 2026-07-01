package f0.e0.f;

import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f3610b;
    public final List<a> c;
    public boolean d;
    public final d e;
    public final String f;

    public c(d dVar, String str) {
        m.checkParameterIsNotNull(dVar, "taskRunner");
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.e = dVar;
        this.f = str;
        this.c = new ArrayList();
    }

    public static /* synthetic */ void d(c cVar, a aVar, long j, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        cVar.c(aVar, j);
    }

    public final void a() {
        byte[] bArr = f0.e0.c.a;
        synchronized (this.e) {
            if (b()) {
                this.e.e(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.f3610b;
        if (aVar != null) {
            if (aVar == null) {
                m.throwNpe();
            }
            if (aVar.d) {
                this.d = true;
            }
        }
        boolean z2 = false;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (this.c.get(size).d) {
                a aVar2 = this.c.get(size);
                Objects.requireNonNull(d.c);
                if (d.f3611b.isLoggable(Level.FINE)) {
                    f.e(aVar2, this, "canceled");
                }
                this.c.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void c(a aVar, long j) {
        m.checkParameterIsNotNull(aVar, "task");
        synchronized (this.e) {
            if (!this.a) {
                if (e(aVar, j, false)) {
                    this.e.e(this);
                }
            } else if (aVar.d) {
                Objects.requireNonNull(d.c);
                if (d.f3611b.isLoggable(Level.FINE)) {
                    f.e(aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Objects.requireNonNull(d.c);
                if (d.f3611b.isLoggable(Level.FINE)) {
                    f.e(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean e(a aVar, long j, boolean z2) {
        String string;
        m.checkParameterIsNotNull(aVar, "task");
        Objects.requireNonNull(aVar);
        m.checkParameterIsNotNull(this, "queue");
        c cVar = aVar.a;
        if (cVar != this) {
            if (!(cVar == null)) {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
            aVar.a = this;
        }
        long jC = this.e.j.c();
        long j2 = jC + j;
        int iIndexOf = this.c.indexOf(aVar);
        if (iIndexOf != -1) {
            if (aVar.f3609b <= j2) {
                d$b d_b = d.c;
                if (d.f3611b.isLoggable(Level.FINE)) {
                    f.e(aVar, this, "already scheduled");
                }
                return false;
            }
            this.c.remove(iIndexOf);
        }
        aVar.f3609b = j2;
        d$b d_b2 = d.c;
        if (d.f3611b.isLoggable(Level.FINE)) {
            if (z2) {
                StringBuilder sbU = b.d.b.a.a.U("run again after ");
                sbU.append(f.a0(j2 - jC));
                string = sbU.toString();
            } else {
                StringBuilder sbU2 = b.d.b.a.a.U("scheduled after ");
                sbU2.append(f.a0(j2 - jC));
                string = sbU2.toString();
            }
            f.e(aVar, this, string);
        }
        Iterator<a> it = this.c.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().f3609b - jC > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.c.size();
        }
        this.c.add(size, aVar);
        return size == 0;
    }

    public final void f() {
        byte[] bArr = f0.e0.c.a;
        synchronized (this.e) {
            this.a = true;
            if (b()) {
                this.e.e(this);
            }
        }
    }

    public String toString() {
        return this.f;
    }
}
