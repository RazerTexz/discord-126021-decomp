package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.r */
/* JADX INFO: compiled from: IterableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2306r extends AbstractC2274b<Iterable<?>> {
    public C2306r(AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g) {
        super((Class<?>) Iterable.class, abstractC2360j, z2, abstractC2215g, (AbstractC2364n<Object>) null);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return !((Iterable) obj).iterator().hasNext();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Iterable<?> iterable = (Iterable) obj;
        if (((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && mo1996q(iterable)) {
            mo2022s(iterable, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1646X(iterable);
        mo2022s(iterable, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return new C2306r(this, this._property, abstractC2215g, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: t */
    public AbstractC2274b<Iterable<?>> mo2023t(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n abstractC2364n, Boolean bool) {
        return new C2306r(this, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public boolean mo1996q(Iterable<?> iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void mo2022s(Iterable<?> iterable, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        AbstractC2364n<Object> abstractC2364n;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            AbstractC2215g abstractC2215g = this._valueTypeSerializer;
            Class<?> cls = null;
            AbstractC2364n<Object> abstractC2364nM2256u = null;
            do {
                Object next = it.next();
                if (next == null) {
                    abstractC2374x.m2248l(abstractC2108d);
                } else {
                    AbstractC2364n<Object> abstractC2364n2 = this._elementSerializer;
                    if (abstractC2364n2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            abstractC2364nM2256u = abstractC2374x.m2256u(cls2, this._property);
                            cls = cls2;
                        }
                        abstractC2364n = abstractC2364nM2256u;
                    } else {
                        abstractC2364n = abstractC2364nM2256u;
                        abstractC2364nM2256u = abstractC2364n2;
                    }
                    if (abstractC2215g == null) {
                        abstractC2364nM2256u.mo1807f(next, abstractC2108d, abstractC2374x);
                    } else {
                        abstractC2364nM2256u.mo1808g(next, abstractC2108d, abstractC2374x, abstractC2215g);
                    }
                    abstractC2364nM2256u = abstractC2364n;
                }
            } while (it.hasNext());
        }
    }

    public C2306r(C2306r c2306r, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2306r, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }
}
