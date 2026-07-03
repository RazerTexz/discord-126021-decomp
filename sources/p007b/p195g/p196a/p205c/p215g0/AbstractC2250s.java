package p007b.p195g.p196a.p205c.p215g0;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.g0.s */
/* JADX INFO: compiled from: VirtualBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2250s extends C2234c implements Serializable {
    private static final long serialVersionUID = 1;

    public AbstractC2250s() {
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: h */
    public void mo1982h(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        Object objMo2017j = mo2017j(obj, abstractC2108d, abstractC2374x);
        if (objMo2017j == null) {
            AbstractC2364n<Object> abstractC2364n = this._nullSerializer;
            if (abstractC2364n != null) {
                abstractC2364n.mo1807f(null, abstractC2108d, abstractC2374x);
                return;
            } else {
                abstractC2108d.mo1631A();
                return;
            }
        }
        AbstractC2364n<Object> abstractC2364nMo1977c = this._serializer;
        if (abstractC2364nMo1977c == null) {
            Class<?> cls = objMo2017j.getClass();
            AbstractC2262l abstractC2262l = this.f4794n;
            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
            abstractC2364nMo1977c = abstractC2364nMo2034c == null ? mo1977c(abstractC2262l, cls, abstractC2374x) : abstractC2364nMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (InterfaceC2094p.a.NON_EMPTY == obj2) {
                if (abstractC2364nMo1977c.mo2021d(abstractC2374x, objMo2017j)) {
                    AbstractC2364n<Object> abstractC2364n2 = this._nullSerializer;
                    if (abstractC2364n2 != null) {
                        abstractC2364n2.mo1807f(null, abstractC2108d, abstractC2374x);
                        return;
                    } else {
                        abstractC2108d.mo1631A();
                        return;
                    }
                }
            } else if (obj2.equals(objMo2017j)) {
                AbstractC2364n<Object> abstractC2364n3 = this._nullSerializer;
                if (abstractC2364n3 != null) {
                    abstractC2364n3.mo1807f(null, abstractC2108d, abstractC2374x);
                    return;
                } else {
                    abstractC2108d.mo1631A();
                    return;
                }
            }
        }
        if (objMo2017j == obj && m1978d(abstractC2108d, abstractC2374x, abstractC2364nMo1977c)) {
            return;
        }
        AbstractC2215g abstractC2215g = this._typeSerializer;
        if (abstractC2215g == null) {
            abstractC2364nMo1977c.mo1807f(objMo2017j, abstractC2108d, abstractC2374x);
        } else {
            abstractC2364nMo1977c.mo1808g(objMo2017j, abstractC2108d, abstractC2374x, abstractC2215g);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: i */
    public void mo1983i(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        Object objMo2017j = mo2017j(obj, abstractC2108d, abstractC2374x);
        if (objMo2017j == null) {
            if (this._nullSerializer != null) {
                abstractC2108d.mo1665x(this._name);
                this._nullSerializer.mo1807f(null, abstractC2108d, abstractC2374x);
                return;
            }
            return;
        }
        AbstractC2364n<Object> abstractC2364nMo1977c = this._serializer;
        if (abstractC2364nMo1977c == null) {
            Class<?> cls = objMo2017j.getClass();
            AbstractC2262l abstractC2262l = this.f4794n;
            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
            abstractC2364nMo1977c = abstractC2364nMo2034c == null ? mo1977c(abstractC2262l, cls, abstractC2374x) : abstractC2364nMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (InterfaceC2094p.a.NON_EMPTY == obj2) {
                if (abstractC2364nMo1977c.mo2021d(abstractC2374x, objMo2017j)) {
                    return;
                }
            } else if (obj2.equals(objMo2017j)) {
                return;
            }
        }
        if (objMo2017j == obj && m1978d(abstractC2108d, abstractC2374x, abstractC2364nMo1977c)) {
            return;
        }
        abstractC2108d.mo1665x(this._name);
        AbstractC2215g abstractC2215g = this._typeSerializer;
        if (abstractC2215g == null) {
            abstractC2364nMo1977c.mo1807f(objMo2017j, abstractC2108d, abstractC2374x);
        } else {
            abstractC2364nMo1977c.mo1808g(objMo2017j, abstractC2108d, abstractC2374x, abstractC2215g);
        }
    }

    /* JADX INFO: renamed from: j */
    public abstract Object mo2017j(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception;

    /* JADX INFO: renamed from: k */
    public abstract AbstractC2250s mo2018k(AbstractC2394l<?> abstractC2394l, C2177c c2177c, AbstractC2198s abstractC2198s, AbstractC2360j abstractC2360j);

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC2250s(AbstractC2198s abstractC2198s, InterfaceC2339a interfaceC2339a, AbstractC2360j abstractC2360j, AbstractC2364n<?> abstractC2364n, AbstractC2215g abstractC2215g, AbstractC2360j abstractC2360j2, InterfaceC2094p.b bVar, Class<?>[] clsArr) {
        boolean z2;
        Object obj;
        InterfaceC2094p.a aVar = InterfaceC2094p.a.USE_DEFAULTS;
        InterfaceC2094p.a aVar2 = InterfaceC2094p.a.ALWAYS;
        AbstractC2188i abstractC2188iMo1859q = abstractC2198s.mo1859q();
        boolean z3 = false;
        if (bVar == null) {
            z2 = false;
        } else {
            InterfaceC2094p.a aVar3 = bVar._valueInclusion;
            if (aVar3 != aVar2 && aVar3 != aVar) {
                z3 = true;
            }
            z2 = z3;
        }
        if (bVar == null) {
            obj = Boolean.FALSE;
        } else {
            InterfaceC2094p.a aVar4 = bVar._valueInclusion;
            obj = (aVar4 == aVar2 || aVar4 == InterfaceC2094p.a.NON_NULL || aVar4 == aVar) ? null : InterfaceC2094p.a.NON_EMPTY;
        }
        super(abstractC2198s, abstractC2188iMo1859q, interfaceC2339a, abstractC2360j, null, null, null, z2, obj, null);
    }
}
