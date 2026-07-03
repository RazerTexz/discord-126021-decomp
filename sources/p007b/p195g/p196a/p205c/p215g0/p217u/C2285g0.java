package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2363m;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.g0 */
/* JADX INFO: compiled from: SerializableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2285g0 extends AbstractC2305q0<InterfaceC2363m> {

    /* JADX INFO: renamed from: k */
    public static final C2285g0 f4853k = new C2285g0();

    public C2285g0() {
        super(InterfaceC2363m.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        InterfaceC2363m interfaceC2363m = (InterfaceC2363m) obj;
        if (!(interfaceC2363m instanceof InterfaceC2363m.a)) {
            return false;
        }
        Objects.requireNonNull((InterfaceC2363m.a) interfaceC2363m);
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        ((InterfaceC2363m) obj).mo2140c(abstractC2108d, abstractC2374x);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        ((InterfaceC2363m) obj).mo2141d(abstractC2108d, abstractC2374x, abstractC2215g);
    }
}
