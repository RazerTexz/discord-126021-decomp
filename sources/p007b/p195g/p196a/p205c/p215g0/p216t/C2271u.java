package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2374x;

/* JADX INFO: renamed from: b.g.a.c.g0.t.u */
/* JADX INFO: compiled from: WritableObjectId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2271u {

    /* JADX INFO: renamed from: a */
    public final AbstractC2082i0<?> f4847a;

    /* JADX INFO: renamed from: b */
    public Object f4848b;

    /* JADX INFO: renamed from: c */
    public boolean f4849c = false;

    public C2271u(AbstractC2082i0<?> abstractC2082i0) {
        this.f4847a = abstractC2082i0;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2043a(AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, C2260j c2260j) throws IOException {
        if (this.f4848b == null) {
            return false;
        }
        if (!this.f4849c && !c2260j.f4822e) {
            return false;
        }
        Objects.requireNonNull(abstractC2108d);
        c2260j.f4821d.mo1807f(this.f4848b, abstractC2108d, abstractC2374x);
        return true;
    }
}
