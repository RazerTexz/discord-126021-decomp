package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.d0 */
/* JADX INFO: compiled from: ObjectArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2279d0 extends AbstractC2272a<Object[]> implements InterfaceC2240i {
    public AbstractC2262l _dynamicSerializers;
    public AbstractC2364n<Object> _elementSerializer;
    public final AbstractC2360j _elementType;
    public final boolean _staticTyping;
    public final AbstractC2215g _valueTypeSerializer;

    public C2279d0(AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<Object> abstractC2364n) {
        super(Object[].class);
        this._elementType = abstractC2360j;
        this._staticTyping = z2;
        this._valueTypeSerializer = abstractC2215g;
        this._dynamicSerializers = AbstractC2262l.b.f4828b;
        this._elementSerializer = abstractC2364n;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nMo2000H;
        AbstractC2360j abstractC2360j;
        Object objMo1775c;
        AbstractC2215g abstractC2215gMo1955a = this._valueTypeSerializer;
        if (abstractC2215gMo1955a != null) {
            abstractC2215gMo1955a = abstractC2215gMo1955a.mo1955a(interfaceC2206d);
        }
        AbstractC2215g abstractC2215g = abstractC2215gMo1955a;
        if (interfaceC2206d != null) {
            AbstractC2188i member = interfaceC2206d.getMember();
            AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
            if (member == null || (objMo1775c = abstractC2165bM2257v.mo1775c(member)) == null) {
                abstractC2364nMo2000H = null;
            } else {
                abstractC2364nMo2000H = abstractC2374x.mo2000H(member, objMo1775c);
            }
        } else {
            abstractC2364nMo2000H = null;
        }
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(InterfaceC2081i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (abstractC2364nMo2000H == null) {
            abstractC2364nMo2000H = this._elementSerializer;
        }
        AbstractC2364n<?> abstractC2364nM2073k = m2073k(abstractC2374x, interfaceC2206d, abstractC2364nMo2000H);
        AbstractC2364n<?> abstractC2364nM2249m = (abstractC2364nM2073k != null || (abstractC2360j = this._elementType) == null || !this._staticTyping || abstractC2360j.m2221y()) ? abstractC2364nM2073k : abstractC2374x.m2249m(this._elementType, interfaceC2206d);
        return (this._property == interfaceC2206d && abstractC2364nM2249m == this._elementSerializer && this._valueTypeSerializer == abstractC2215g && Objects.equals(this._unwrapSingle, boolM1598b)) ? this : new C2279d0(this, interfaceC2206d, abstractC2215g, abstractC2364nM2249m, boolM1598b);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            mo2038t(objArr, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1649b0(objArr, length);
        mo2038t(objArr, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return new C2279d0(this._elementType, this._staticTyping, abstractC2215g, this._elementSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((Object[]) obj).length == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
    /* JADX INFO: renamed from: s */
    public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
        return new C2279d0(this, interfaceC2206d, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo2038t(Object[] objArr, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Object obj;
        Object obj2;
        AbstractC2262l abstractC2262lMo2033b;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        AbstractC2364n<Object> abstractC2364n = this._elementSerializer;
        int i = 0;
        if (abstractC2364n != null) {
            int length2 = objArr.length;
            AbstractC2215g abstractC2215g = this._valueTypeSerializer;
            Object obj3 = null;
            while (i < length2) {
                try {
                    obj3 = objArr[i];
                    if (obj3 == null) {
                        abstractC2374x.m2248l(abstractC2108d);
                    } else if (abstractC2215g == null) {
                        abstractC2364n.mo1807f(obj3, abstractC2108d, abstractC2374x);
                    } else {
                        abstractC2364n.mo1808g(obj3, abstractC2108d, abstractC2374x, abstractC2215g);
                    }
                    i++;
                } catch (Exception e) {
                    m2076n(abstractC2374x, e, obj3, i);
                    throw null;
                }
            }
            return;
        }
        AbstractC2215g abstractC2215g2 = this._valueTypeSerializer;
        if (abstractC2215g2 != null) {
            int length3 = objArr.length;
            try {
                AbstractC2262l abstractC2262l = this._dynamicSerializers;
                obj2 = null;
                while (i < length3) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            abstractC2374x.m2248l(abstractC2108d);
                        } else {
                            Class<?> cls = obj2.getClass();
                            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
                            if (abstractC2364nMo2034c == null && abstractC2262l != (abstractC2262lMo2033b = abstractC2262l.mo2033b(cls, (abstractC2364nMo2034c = abstractC2374x.m2250n(cls, this._property))))) {
                                this._dynamicSerializers = abstractC2262lMo2033b;
                            }
                            abstractC2364nMo2034c.mo1808g(obj2, abstractC2108d, abstractC2374x, abstractC2215g2);
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        m2076n(abstractC2374x, e, obj2, i);
                        throw null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                obj2 = null;
            }
        } else {
            try {
                AbstractC2262l abstractC2262l2 = this._dynamicSerializers;
                obj = null;
                while (i < length) {
                    try {
                        obj = objArr[i];
                        if (obj == null) {
                            abstractC2374x.m2248l(abstractC2108d);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            AbstractC2364n<Object> abstractC2364nMo2034c2 = abstractC2262l2.mo2034c(cls2);
                            if (abstractC2364nMo2034c2 == null) {
                                if (this._elementType.mo2102r()) {
                                    AbstractC2262l.d dVarM2032a = abstractC2262l2.m2032a(abstractC2374x.m2247k(this._elementType, cls2), abstractC2374x, this._property);
                                    AbstractC2262l abstractC2262l3 = dVarM2032a.f4831b;
                                    if (abstractC2262l2 != abstractC2262l3) {
                                        this._dynamicSerializers = abstractC2262l3;
                                    }
                                    abstractC2364nMo2034c2 = dVarM2032a.f4830a;
                                } else {
                                    abstractC2364nMo2034c2 = abstractC2374x.m2250n(cls2, this._property);
                                    AbstractC2262l abstractC2262lMo2033b2 = abstractC2262l2.mo2033b(cls2, abstractC2364nMo2034c2);
                                    if (abstractC2262l2 != abstractC2262lMo2033b2) {
                                        this._dynamicSerializers = abstractC2262lMo2033b2;
                                    }
                                }
                            }
                            abstractC2364nMo2034c2.mo1807f(obj, abstractC2108d, abstractC2374x);
                        }
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        m2076n(abstractC2374x, e, obj, i);
                        throw null;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                obj = null;
            }
        }
    }

    public C2279d0(C2279d0 c2279d0, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2279d0, interfaceC2206d, bool);
        this._elementType = c2279d0._elementType;
        this._valueTypeSerializer = abstractC2215g;
        this._staticTyping = c2279d0._staticTyping;
        this._dynamicSerializers = AbstractC2262l.b.f4828b;
        this._elementSerializer = abstractC2364n;
    }
}
