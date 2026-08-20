package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.List;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.t.f */
/* JADX INFO: compiled from: IndexedListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public final class C2256f extends AbstractC2274b<List<?>> {
    private static final long serialVersionUID = 1;

    public C2256f(AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<Object> abstractC2364n) {
        super((Class<?>) List.class, abstractC2360j, z2, abstractC2215g, abstractC2364n);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return ((List) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        List<?> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            mo2022s(list, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1649b0(list, size);
        mo2022s(list, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return new C2256f(this, this._property, abstractC2215g, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((List) obj).size() == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: t */
    public AbstractC2274b<List<?>> mo2023t(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n abstractC2364n, Boolean bool) {
        return new C2256f(this, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo2022s(List<?> list, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        AbstractC2364n<Object> abstractC2364nM2045r;
        AbstractC2364n<Object> abstractC2364nM2045r2;
        AbstractC2364n<Object> abstractC2364n = this._elementSerializer;
        int i = 0;
        if (abstractC2364n != null) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            AbstractC2215g abstractC2215g = this._valueTypeSerializer;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        abstractC2374x.m2248l(abstractC2108d);
                    } catch (Exception e) {
                        m2076n(abstractC2374x, e, list, i);
                        throw null;
                    }
                } else if (abstractC2215g == null) {
                    abstractC2364n.mo1807f(obj, abstractC2108d, abstractC2374x);
                } else {
                    abstractC2364n.mo1808g(obj, abstractC2108d, abstractC2374x, abstractC2215g);
                }
                i++;
            }
            return;
        }
        if (this._valueTypeSerializer == null) {
            int size2 = list.size();
            if (size2 == 0) {
                return;
            }
            try {
                AbstractC2262l abstractC2262l = this._dynamicSerializers;
                while (i < size2) {
                    Object obj2 = list.get(i);
                    if (obj2 == null) {
                        abstractC2374x.m2248l(abstractC2108d);
                    } else {
                        Class<?> cls = obj2.getClass();
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
                        abstractC2364nMo2034c.mo1807f(obj2, abstractC2108d, abstractC2374x);
                    }
                    i++;
                }
                return;
            } catch (Exception e2) {
                m2076n(abstractC2374x, e2, list, i);
                throw null;
            }
        }
        int size3 = list.size();
        if (size3 == 0) {
            return;
        }
        try {
            AbstractC2215g abstractC2215g2 = this._valueTypeSerializer;
            AbstractC2262l abstractC2262l3 = this._dynamicSerializers;
            while (i < size3) {
                Object obj3 = list.get(i);
                if (obj3 == null) {
                    abstractC2374x.m2248l(abstractC2108d);
                } else {
                    Class<?> cls2 = obj3.getClass();
                    AbstractC2364n<Object> abstractC2364nMo2034c2 = abstractC2262l3.mo2034c(cls2);
                    if (abstractC2364nMo2034c2 == null) {
                        if (this._elementType.mo2102r()) {
                            AbstractC2262l.d dVarM2032a2 = abstractC2262l3.m2032a(abstractC2374x.m2247k(this._elementType, cls2), abstractC2374x, this._property);
                            AbstractC2262l abstractC2262l4 = dVarM2032a2.f4831b;
                            if (abstractC2262l3 != abstractC2262l4) {
                                this._dynamicSerializers = abstractC2262l4;
                            }
                            abstractC2364nM2045r2 = dVarM2032a2.f4830a;
                        } else {
                            abstractC2364nM2045r2 = m2045r(abstractC2262l3, cls2, abstractC2374x);
                        }
                        abstractC2364nMo2034c2 = abstractC2364nM2045r2;
                        abstractC2262l3 = this._dynamicSerializers;
                    }
                    abstractC2364nMo2034c2.mo1808g(obj3, abstractC2108d, abstractC2374x, abstractC2215g2);
                }
                i++;
            }
        } catch (Exception e3) {
            m2076n(abstractC2374x, e3, list, i);
            throw null;
        }
    }

    public C2256f(C2256f c2256f, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2256f, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }
}
