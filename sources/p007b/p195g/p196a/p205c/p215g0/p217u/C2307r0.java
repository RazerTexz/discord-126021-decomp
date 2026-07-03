package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.r0 */
/* JADX INFO: compiled from: StringSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public final class C2307r0 extends AbstractC2303p0<Object> {
    private static final long serialVersionUID = 1;

    public C2307r0() {
        super(String.class, false);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return ((String) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1658j0((String) obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public final void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        abstractC2108d.mo1658j0((String) obj);
    }
}
