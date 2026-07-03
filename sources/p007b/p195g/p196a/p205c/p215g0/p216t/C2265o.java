package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Collection;
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

/* JADX INFO: renamed from: b.g.a.c.g0.t.o */
/* JADX INFO: compiled from: StringCollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2265o extends AbstractC2287h0<Collection<String>> {

    /* JADX INFO: renamed from: k */
    public static final C2265o f4844k = new C2265o();

    public C2265o() {
        super(Collection.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Collection<String> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2040r(collection, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1649b0(collection, size);
        m2040r(collection, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2287h0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Collection<String> collection = (Collection) obj;
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(collection, EnumC2112h.START_ARRAY));
        abstractC2108d.mo1654e(collection);
        m2040r(collection, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2287h0
    /* JADX INFO: renamed from: p */
    public AbstractC2364n<?> mo2025p(InterfaceC2206d interfaceC2206d, Boolean bool) {
        return new C2265o(this, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2287h0
    /* JADX INFO: renamed from: q */
    public void mo1808g(Collection<String> collection, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(collection, EnumC2112h.START_ARRAY));
        abstractC2108d.mo1654e(collection);
        m2040r(collection, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    /* JADX INFO: renamed from: r */
    public final void m2040r(Collection<String> collection, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        int i = 0;
        try {
            for (String str : collection) {
                if (str == null) {
                    abstractC2374x.m2248l(abstractC2108d);
                } else {
                    abstractC2108d.mo1658j0(str);
                }
                i++;
            }
        } catch (Exception e) {
            m2076n(abstractC2374x, e, collection, i);
            throw null;
        }
    }

    public C2265o(C2265o c2265o, Boolean bool) {
        super(c2265o, bool);
    }
}
