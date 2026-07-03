package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2305q0;

/* JADX INFO: renamed from: b.g.a.c.g0.t.r */
/* JADX INFO: compiled from: UnsupportedTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2268r extends AbstractC2305q0<Object> {
    private static final long serialVersionUID = 1;
    public final String _message;
    public final AbstractC2360j _type;

    public C2268r(AbstractC2360j abstractC2360j, String str) {
        super(Object.class);
        this._type = abstractC2360j;
        this._message = str;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2374x.mo1942f(this._type, this._message);
        throw null;
    }
}
