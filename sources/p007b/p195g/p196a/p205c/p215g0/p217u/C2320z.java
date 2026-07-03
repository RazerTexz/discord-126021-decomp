package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.z */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2320z extends AbstractC2316w<Object> {

    /* JADX INFO: renamed from: k */
    public static final C2320z f4872k = new C2320z();

    public C2320z() {
        super(Number.class, AbstractC2110f.b.INT, "integer");
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1634H(((Number) obj).intValue());
    }
}
