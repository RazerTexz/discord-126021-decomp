package p600f0.p601e0.p604f;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.e0.f.c */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12279c {

    /* JADX INFO: renamed from: a */
    public boolean f25414a;

    /* JADX INFO: renamed from: b */
    public AbstractC12277a f25415b;

    /* JADX INFO: renamed from: c */
    public final List<AbstractC12277a> f25416c;

    /* JADX INFO: renamed from: d */
    public boolean f25417d;

    /* JADX INFO: renamed from: e */
    public final C12280d f25418e;

    /* JADX INFO: renamed from: f */
    public final String f25419f;

    public C12279c(C12280d c12280d, String str) {
        C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f25418e = c12280d;
        this.f25419f = str;
        this.f25416c = new ArrayList();
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ void m10151d(C12279c c12279c, AbstractC12277a abstractC12277a, long j, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        c12279c.m10154c(abstractC12277a, j);
    }

    /* JADX INFO: renamed from: a */
    public final void m10152a() {
        byte[] bArr = C12272c.f25397a;
        synchronized (this.f25418e) {
            if (m10153b()) {
                this.f25418e.m10161e(this);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10153b() {
        AbstractC12277a abstractC12277a = this.f25415b;
        if (abstractC12277a != null) {
            if (abstractC12277a == null) {
                C12238m.throwNpe();
            }
            if (abstractC12277a.f25412d) {
                this.f25417d = true;
            }
        }
        boolean z2 = false;
        for (int size = this.f25416c.size() - 1; size >= 0; size--) {
            if (this.f25416c.get(size).f25412d) {
                AbstractC12277a abstractC12277a2 = this.f25416c.get(size);
                Objects.requireNonNull(C12280d.f25422c);
                if (C12280d.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(abstractC12277a2, this, "canceled");
                }
                this.f25416c.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: c */
    public final void m10154c(AbstractC12277a abstractC12277a, long j) {
        C12238m.checkParameterIsNotNull(abstractC12277a, "task");
        synchronized (this.f25418e) {
            if (!this.f25414a) {
                if (m10155e(abstractC12277a, j, false)) {
                    this.f25418e.m10161e(this);
                }
            } else if (abstractC12277a.f25412d) {
                Objects.requireNonNull(C12280d.f25422c);
                if (C12280d.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(abstractC12277a, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Objects.requireNonNull(C12280d.f25422c);
                if (C12280d.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(abstractC12277a, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m10155e(AbstractC12277a abstractC12277a, long j, boolean z2) {
        String string;
        C12238m.checkParameterIsNotNull(abstractC12277a, "task");
        Objects.requireNonNull(abstractC12277a);
        C12238m.checkParameterIsNotNull(this, "queue");
        C12279c c12279c = abstractC12277a.f25409a;
        if (c12279c != this) {
            if (!(c12279c == null)) {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
            abstractC12277a.f25409a = this;
        }
        long jMo10165c = this.f25418e.f25429j.mo10165c();
        long j2 = jMo10165c + j;
        int iIndexOf = this.f25416c.indexOf(abstractC12277a);
        if (iIndexOf != -1) {
            if (abstractC12277a.f25410b <= j2) {
                C12280d.b bVar = C12280d.f25422c;
                if (C12280d.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(abstractC12277a, this, "already scheduled");
                }
                return false;
            }
            this.f25416c.remove(iIndexOf);
        }
        abstractC12277a.f25410b = j2;
        C12280d.b bVar2 = C12280d.f25422c;
        if (C12280d.f25421b.isLoggable(Level.FINE)) {
            if (z2) {
                StringBuilder sbM833U = C1643a.m833U("run again after ");
                sbM833U.append(C3404f.m4268a0(j2 - jMo10165c));
                string = sbM833U.toString();
            } else {
                StringBuilder sbM833U2 = C1643a.m833U("scheduled after ");
                sbM833U2.append(C3404f.m4268a0(j2 - jMo10165c));
                string = sbM833U2.toString();
            }
            C3404f.m4283e(abstractC12277a, this, string);
        }
        Iterator<AbstractC12277a> it = this.f25416c.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().f25410b - jMo10165c > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f25416c.size();
        }
        this.f25416c.add(size, abstractC12277a);
        return size == 0;
    }

    /* JADX INFO: renamed from: f */
    public final void m10156f() {
        byte[] bArr = C12272c.f25397a;
        synchronized (this.f25418e) {
            this.f25414a = true;
            if (m10153b()) {
                this.f25418e.m10161e(this);
            }
        }
    }

    public String toString() {
        return this.f25419f;
    }
}
