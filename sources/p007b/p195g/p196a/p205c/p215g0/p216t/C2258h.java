package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.t.h */
/* JADX INFO: compiled from: IteratorSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2258h extends AbstractC2274b<Iterator<?>> {
    public C2258h(AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g) {
        super((Class<?>) Iterator.class, abstractC2360j, z2, abstractC2215g, (AbstractC2364n<Object>) null);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return !((Iterator) obj).hasNext();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Iterator<?> it = (Iterator) obj;
        abstractC2108d.mo1646X(it);
        mo2022s(it, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return new C2258h(this, this._property, abstractC2215g, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: q */
    public /* bridge */ /* synthetic */ boolean mo1996q(Object obj) {
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: t */
    public AbstractC2274b<Iterator<?>> mo2023t(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n abstractC2364n, Boolean bool) {
        return new C2258h(this, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo2022s(Iterator<?> it, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        AbstractC2364n<Object> abstractC2364nM2045r;
        if (it.hasNext()) {
            AbstractC2364n<Object> abstractC2364n = this._elementSerializer;
            if (abstractC2364n != null) {
                AbstractC2215g abstractC2215g = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        abstractC2374x.m2248l(abstractC2108d);
                    } else if (abstractC2215g == null) {
                        abstractC2364n.mo1807f(next, abstractC2108d, abstractC2374x);
                    } else {
                        abstractC2364n.mo1808g(next, abstractC2108d, abstractC2374x, abstractC2215g);
                    }
                } while (it.hasNext());
                return;
            }
            AbstractC2215g abstractC2215g2 = this._valueTypeSerializer;
            AbstractC2262l abstractC2262l = this._dynamicSerializers;
            do {
                Object next2 = it.next();
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
            } while (it.hasNext());
        }
    }

    public C2258h(C2258h c2258h, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2258h, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }
}
