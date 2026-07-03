package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.List;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2287h0;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.t.g */
/* JADX INFO: compiled from: IndexedStringListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public final class C2257g extends AbstractC2287h0<List<String>> {

    /* JADX INFO: renamed from: k */
    public static final C2257g f4817k = new C2257g();
    private static final long serialVersionUID = 1;

    public C2257g() {
        super(List.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        List<String> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2027r(list, abstractC2108d, abstractC2374x, 1);
            return;
        }
        abstractC2108d.mo1649b0(list, size);
        m2027r(list, abstractC2108d, abstractC2374x, size);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2287h0
    /* JADX INFO: renamed from: p */
    public AbstractC2364n<?> mo2025p(InterfaceC2206d interfaceC2206d, Boolean bool) {
        return new C2257g(this, bool);
    }

    /* JADX INFO: renamed from: r */
    public final void m2027r(List<String> list, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = list.get(i2);
                if (str == null) {
                    abstractC2374x.m2248l(abstractC2108d);
                } else {
                    abstractC2108d.mo1658j0(str);
                }
            } catch (Exception e) {
                m2076n(abstractC2374x, e, list, i2);
                throw null;
            }
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2287h0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void mo1808g(List<String> list, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(list, EnumC2112h.START_ARRAY));
        abstractC2108d.mo1654e(list);
        m2027r(list, abstractC2108d, abstractC2374x, list.size());
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    public C2257g(C2257g c2257g, Boolean bool) {
        super(c2257g, bool);
    }
}
