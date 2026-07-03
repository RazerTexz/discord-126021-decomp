package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;

/* JADX INFO: renamed from: b.g.a.c.g0.u.j */
/* JADX INFO: compiled from: CollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2290j extends AbstractC2274b<Collection<?>> {
    private static final long serialVersionUID = 1;

    public C2290j(AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<Object> abstractC2364n) {
        super((Class<?>) Collection.class, abstractC2360j, z2, abstractC2215g, abstractC2364n);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Collection<?> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            mo2022s(collection, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1649b0(collection, size);
        mo2022s(collection, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return new C2290j(this, this._property, abstractC2215g, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((Collection) obj).size() == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: t */
    public AbstractC2274b<Collection<?>> mo2023t(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n abstractC2364n, Boolean bool) {
        return new C2290j(this, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo2022s(Collection<?> collection, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        AbstractC2364n<Object> abstractC2364nM2045r;
        abstractC2108d.mo1654e(collection);
        AbstractC2364n<Object> abstractC2364n = this._elementSerializer;
        int i = 0;
        if (abstractC2364n != null) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                AbstractC2215g abstractC2215g = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            abstractC2374x.m2248l(abstractC2108d);
                        } catch (Exception e) {
                            m2076n(abstractC2374x, e, collection, i);
                            throw null;
                        }
                    } else if (abstractC2215g == null) {
                        abstractC2364n.mo1807f(next, abstractC2108d, abstractC2374x);
                    } else {
                        abstractC2364n.mo1808g(next, abstractC2108d, abstractC2374x, abstractC2215g);
                    }
                    i++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator<?> it2 = collection.iterator();
        if (it2.hasNext()) {
            AbstractC2262l abstractC2262l = this._dynamicSerializers;
            AbstractC2215g abstractC2215g2 = this._valueTypeSerializer;
            do {
                try {
                    Object next2 = it2.next();
                    if (next2 == null) {
                        abstractC2374x.m2248l(abstractC2108d);
                    } else {
                        Class<?> cls = next2.getClass();
                        AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
                        if (abstractC2364nMo2034c == null) {
                            if (this._elementType.mo2102r()) {
                                AbstractC2262l.d dVarM2032a = abstractC2262l.m2032a(abstractC2374x.m2247k(this._elementType, cls), abstractC2374x, this._property);
                                AbstractC2262l abstractC2262l2 = dVarM2032a.f4831b;
                                if (abstractC2262l != abstractC2262l2) {
                                    this._dynamicSerializers = abstractC2262l2;
                                }
                                abstractC2364nM2045r = dVarM2032a.f4830a;
                            } else {
                                abstractC2364nM2045r = m2045r(abstractC2262l, cls, abstractC2374x);
                            }
                            abstractC2364nMo2034c = abstractC2364nM2045r;
                            abstractC2262l = this._dynamicSerializers;
                        }
                        if (abstractC2215g2 == null) {
                            abstractC2364nMo2034c.mo1807f(next2, abstractC2108d, abstractC2374x);
                        } else {
                            abstractC2364nMo2034c.mo1808g(next2, abstractC2108d, abstractC2374x, abstractC2215g2);
                        }
                    }
                    i++;
                } catch (Exception e2) {
                    m2076n(abstractC2374x, e2, collection, i);
                    throw null;
                }
            } while (it2.hasNext());
        }
    }

    public C2290j(C2290j c2290j, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2290j, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }
}
