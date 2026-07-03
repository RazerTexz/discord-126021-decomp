package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2246o;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;

/* JADX INFO: renamed from: b.g.a.c.g0.u.j0 */
/* JADX INFO: compiled from: StdDelegatingSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2291j0 extends AbstractC2305q0<Object> implements InterfaceC2240i, InterfaceC2246o {
    public final InterfaceC2343e<Object, ?> _converter;
    public final AbstractC2364n<Object> _delegateSerializer;
    public final AbstractC2360j _delegateType;

    public C2291j0(InterfaceC2343e<Object, ?> interfaceC2343e, AbstractC2360j abstractC2360j, AbstractC2364n<?> abstractC2364n) {
        super(abstractC2360j);
        this._converter = interfaceC2343e;
        this._delegateType = abstractC2360j;
        this._delegateSerializer = abstractC2364n;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nM2261z = this._delegateSerializer;
        AbstractC2360j abstractC2360jM2197a = this._delegateType;
        if (abstractC2364nM2261z == null) {
            if (abstractC2360jM2197a == null) {
                abstractC2360jM2197a = this._converter.m2197a(abstractC2374x.mo1940d());
            }
            if (!abstractC2360jM2197a.m2221y()) {
                abstractC2364nM2261z = abstractC2374x.m2254s(abstractC2360jM2197a);
            }
        }
        if (abstractC2364nM2261z instanceof InterfaceC2240i) {
            abstractC2364nM2261z = abstractC2374x.m2261z(abstractC2364nM2261z, interfaceC2206d);
        }
        if (abstractC2364nM2261z == this._delegateSerializer && abstractC2360jM2197a == this._delegateType) {
            return this;
        }
        InterfaceC2343e<Object, ?> interfaceC2343e = this._converter;
        C2342d.m2194z(C2291j0.class, this, "withDelegate");
        return new C2291j0(interfaceC2343e, abstractC2360jM2197a, abstractC2364nM2261z);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2246o
    /* JADX INFO: renamed from: b */
    public void mo2007b(AbstractC2374x abstractC2374x) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        if (obj == null || !(obj instanceof InterfaceC2246o)) {
            return;
        }
        ((InterfaceC2246o) obj).mo2007b(abstractC2374x);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            return true;
        }
        AbstractC2364n<Object> abstractC2364n = this._delegateSerializer;
        if (abstractC2364n == null) {
            return obj == null;
        }
        return abstractC2364n.mo2021d(abstractC2374x, objConvert);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            abstractC2374x.m2248l(abstractC2108d);
            return;
        }
        AbstractC2364n<Object> abstractC2364nM2065p = this._delegateSerializer;
        if (abstractC2364nM2065p == null) {
            abstractC2364nM2065p = m2065p(objConvert, abstractC2374x);
        }
        abstractC2364nM2065p.mo1807f(objConvert, abstractC2108d, abstractC2374x);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Object objConvert = this._converter.convert(obj);
        AbstractC2364n<Object> abstractC2364nM2065p = this._delegateSerializer;
        if (abstractC2364nM2065p == null) {
            abstractC2364nM2065p = m2065p(obj, abstractC2374x);
        }
        abstractC2364nM2065p.mo1808g(objConvert, abstractC2108d, abstractC2374x, abstractC2215g);
    }

    /* JADX INFO: renamed from: p */
    public AbstractC2364n<Object> m2065p(Object obj, AbstractC2374x abstractC2374x) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        AbstractC2364n<Object> abstractC2364nM2036b = abstractC2374x._knownSerializers.m2036b(cls);
        if (abstractC2364nM2036b != null) {
            return abstractC2364nM2036b;
        }
        AbstractC2364n<Object> abstractC2364nM2009b = abstractC2374x._serializerCache.m2009b(cls);
        if (abstractC2364nM2009b != null) {
            return abstractC2364nM2009b;
        }
        AbstractC2364n<Object> abstractC2364nM2008a = abstractC2374x._serializerCache.m2008a(abstractC2374x._config._base._typeFactory.m2160b(null, cls, C2335n.f4926l));
        if (abstractC2364nM2008a != null) {
            return abstractC2364nM2008a;
        }
        AbstractC2364n<Object> abstractC2364nM2245i = abstractC2374x.m2245i(cls);
        return abstractC2364nM2245i == null ? abstractC2374x.m2259x(cls) : abstractC2364nM2245i;
    }
}
