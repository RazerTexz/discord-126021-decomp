package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.reflect.Method;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.p200p.C2130j;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.C2234c;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.g0.t.s */
/* JADX INFO: compiled from: UnwrappingBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2269s extends C2234c implements Serializable {
    private static final long serialVersionUID = 1;
    public final AbstractC2352n _nameTransformer;

    public C2269s(C2269s c2269s, AbstractC2352n abstractC2352n, C2130j c2130j) {
        super(c2269s, c2130j);
        this._nameTransformer = abstractC2352n;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: c */
    public AbstractC2364n<Object> mo1977c(AbstractC2262l abstractC2262l, Class<?> cls, AbstractC2374x abstractC2374x) throws JsonMappingException {
        AbstractC2360j abstractC2360j = this._nonTrivialBaseType;
        AbstractC2364n<Object> abstractC2364nM2255t = abstractC2360j != null ? abstractC2374x.m2255t(abstractC2374x.m2247k(abstractC2360j, cls), this) : abstractC2374x.m2256u(cls, this);
        AbstractC2352n aVar = this._nameTransformer;
        if (abstractC2364nM2255t.mo2058e() && (abstractC2364nM2255t instanceof C2270t)) {
            aVar = new AbstractC2352n.a(aVar, ((C2270t) abstractC2364nM2255t)._nameTransformer);
        }
        AbstractC2364n<Object> abstractC2364nMo1984h = abstractC2364nM2255t.mo1984h(aVar);
        this.f4794n = this.f4794n.mo2033b(cls, abstractC2364nMo1984h);
        return abstractC2364nMo1984h;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: f */
    public void mo1980f(AbstractC2364n<Object> abstractC2364n) {
        if (abstractC2364n != null) {
            AbstractC2352n aVar = this._nameTransformer;
            if (abstractC2364n.mo2058e() && (abstractC2364n instanceof C2270t)) {
                aVar = new AbstractC2352n.a(aVar, ((C2270t) abstractC2364n)._nameTransformer);
            }
            abstractC2364n = abstractC2364n.mo1984h(aVar);
        }
        super.mo1980f(abstractC2364n);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: g */
    public C2234c mo1981g(AbstractC2352n abstractC2352n) {
        return new C2269s(this, new AbstractC2352n.a(abstractC2352n, this._nameTransformer), new C2130j(abstractC2352n.mo2202a(this._name._value)));
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.C2234c
    /* JADX INFO: renamed from: i */
    public void mo1983i(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        Method method = this.f4792l;
        Object objInvoke = method == null ? this.f4793m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            return;
        }
        AbstractC2364n<Object> abstractC2364nMo1977c = this._serializer;
        if (abstractC2364nMo1977c == null) {
            Class<?> cls = objInvoke.getClass();
            AbstractC2262l abstractC2262l = this.f4794n;
            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
            abstractC2364nMo1977c = abstractC2364nMo2034c == null ? mo1977c(abstractC2262l, cls, abstractC2374x) : abstractC2364nMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (InterfaceC2094p.a.NON_EMPTY == obj2) {
                if (abstractC2364nMo1977c.mo2021d(abstractC2374x, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && m1978d(abstractC2108d, abstractC2374x, abstractC2364nMo1977c)) {
            return;
        }
        if (!abstractC2364nMo1977c.mo2058e()) {
            abstractC2108d.mo1665x(this._name);
        }
        AbstractC2215g abstractC2215g = this._typeSerializer;
        if (abstractC2215g == null) {
            abstractC2364nMo1977c.mo1807f(objInvoke, abstractC2108d, abstractC2374x);
        } else {
            abstractC2364nMo1977c.mo1808g(objInvoke, abstractC2108d, abstractC2374x, abstractC2215g);
        }
    }

    public C2269s(C2234c c2234c, AbstractC2352n abstractC2352n) {
        super(c2234c, c2234c._name);
        this._nameTransformer = abstractC2352n;
    }
}
