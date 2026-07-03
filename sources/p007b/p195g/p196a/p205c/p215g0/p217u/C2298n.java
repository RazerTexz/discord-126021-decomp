package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;

/* JADX INFO: renamed from: b.g.a.c.g0.u.n */
/* JADX INFO: compiled from: EnumSetSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2298n extends AbstractC2274b<EnumSet<? extends Enum<?>>> {
    public C2298n(AbstractC2360j abstractC2360j) {
        super((Class<?>) EnumSet.class, abstractC2360j, true, (AbstractC2215g) null, (AbstractC2364n<Object>) null);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return ((EnumSet) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        EnumSet<? extends Enum<?>> enumSet = (EnumSet) obj;
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            mo2022s(enumSet, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1649b0(enumSet, size);
        mo2022s(enumSet, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h mo1995p(AbstractC2215g abstractC2215g) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((EnumSet) obj).size() == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: t */
    public AbstractC2274b<EnumSet<? extends Enum<?>>> mo2023t(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n abstractC2364n, Boolean bool) {
        return new C2298n(this, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2274b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo2022s(EnumSet<? extends Enum<?>> enumSet, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        AbstractC2364n<Object> abstractC2364nM2250n = this._elementSerializer;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum r1 = (Enum) it.next();
            if (abstractC2364nM2250n == null) {
                abstractC2364nM2250n = abstractC2374x.m2250n(r1.getDeclaringClass(), this._property);
            }
            abstractC2364nM2250n.mo1807f(r1, abstractC2108d, abstractC2374x);
        }
    }

    public C2298n(C2298n c2298n, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2298n, interfaceC2206d, abstractC2215g, abstractC2364n, bool);
    }
}
