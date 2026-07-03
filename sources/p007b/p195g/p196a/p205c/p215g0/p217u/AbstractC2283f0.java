package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p218h0.C2330i;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2379e;

/* JADX INFO: renamed from: b.g.a.c.g0.u.f0 */
/* JADX INFO: compiled from: ReferenceTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2283f0<T> extends AbstractC2305q0<T> implements InterfaceC2240i {
    private static final long serialVersionUID = 1;
    public final InterfaceC2206d _property;
    public final AbstractC2360j _referredType;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public final AbstractC2352n _unwrapper;
    public final AbstractC2364n<Object> _valueSerializer;
    public final AbstractC2215g _valueTypeSerializer;

    /* JADX INFO: renamed from: k */
    public transient AbstractC2262l f4852k;

    public AbstractC2283f0(C2330i c2330i, AbstractC2215g abstractC2215g, AbstractC2364n abstractC2364n) {
        super(c2330i);
        this._referredType = c2330i._referencedType;
        this._property = null;
        this._valueTypeSerializer = abstractC2215g;
        this._valueSerializer = abstractC2364n;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this.f4852k = AbstractC2262l.b.f4828b;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nM2260y;
        InterfaceC2094p.b bVarMo1929b;
        InterfaceC2094p.a aVar;
        boolean zM2239C;
        Object objMo1775c;
        Object objM572t0 = InterfaceC2094p.a.NON_EMPTY;
        AbstractC2215g abstractC2215gMo1955a = this._valueTypeSerializer;
        if (abstractC2215gMo1955a != null) {
            abstractC2215gMo1955a = abstractC2215gMo1955a.mo1955a(interfaceC2206d);
        }
        if (interfaceC2206d != null) {
            AbstractC2188i member = interfaceC2206d.getMember();
            AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
            if (member == null || (objMo1775c = abstractC2165bM2257v.mo1775c(member)) == null) {
                abstractC2364nM2260y = null;
            } else {
                abstractC2364nM2260y = abstractC2374x.mo2000H(member, objMo1775c);
            }
        } else {
            abstractC2364nM2260y = null;
        }
        boolean zMo1999B = false;
        if (abstractC2364nM2260y == null) {
            abstractC2364nM2260y = this._valueSerializer;
            if (abstractC2364nM2260y == null) {
                AbstractC2360j abstractC2360j = this._referredType;
                if (abstractC2360j.m2221y()) {
                    zM2239C = false;
                } else if (abstractC2360j.m2220x() || abstractC2360j._asStatic) {
                    zM2239C = true;
                } else {
                    AbstractC2165b abstractC2165bM2257v2 = abstractC2374x.m2257v();
                    if (abstractC2165bM2257v2 != null && interfaceC2206d != null && interfaceC2206d.getMember() != null) {
                        InterfaceC2379e.b bVarMo1755K = abstractC2165bM2257v2.mo1755K(interfaceC2206d.getMember());
                        if (bVarMo1755K == InterfaceC2379e.b.STATIC) {
                            zM2239C = true;
                        } else if (bVarMo1755K == InterfaceC2379e.b.DYNAMIC) {
                            zM2239C = false;
                        }
                    }
                    zM2239C = abstractC2374x.m2239C(EnumC2366p.USE_STATIC_TYPING);
                }
                if (zM2239C) {
                    abstractC2364nM2260y = abstractC2374x.m2252q(this._referredType, interfaceC2206d);
                }
            } else {
                abstractC2364nM2260y = abstractC2374x.m2260y(abstractC2364nM2260y, interfaceC2206d);
            }
        }
        AbstractC2283f0<T> abstractC2283f0Mo2050u = (this._property == interfaceC2206d && this._valueTypeSerializer == abstractC2215gMo1955a && this._valueSerializer == abstractC2364nM2260y) ? this : mo2050u(interfaceC2206d, abstractC2215gMo1955a, abstractC2364nM2260y, this._unwrapper);
        if (interfaceC2206d == null || (bVarMo1929b = interfaceC2206d.mo1929b(abstractC2374x._config, this._handledType)) == null || (aVar = bVarMo1929b._contentInclusion) == InterfaceC2094p.a.USE_DEFAULTS) {
            return abstractC2283f0Mo2050u;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            objM572t0 = null;
            zMo1999B = true;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        objM572t0 = C1460d.m572t0(this._referredType);
                        if (objM572t0 != null && objM572t0.getClass().isArray()) {
                            objM572t0 = C1460d.m560q0(objM572t0);
                        }
                    } else if (iOrdinal != 5) {
                        objM572t0 = null;
                    } else {
                        objM572t0 = abstractC2374x.mo1998A(null, bVarMo1929b._contentFilter);
                        if (objM572t0 != null) {
                            zMo1999B = abstractC2374x.mo1999B(objM572t0);
                        }
                    }
                }
            } else if (!this._referredType.mo1728b()) {
                objM572t0 = null;
            }
            zMo1999B = true;
        }
        return (this._suppressableValue == objM572t0 && this._suppressNulls == zMo1999B) ? abstractC2283f0Mo2050u : abstractC2283f0Mo2050u.mo2049t(objM572t0, zMo1999B);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, T t) {
        if (!mo2048s(t)) {
            return true;
        }
        Object objMo2046q = mo2046q(t);
        if (objMo2046q == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        AbstractC2364n<Object> abstractC2364nM2059p = this._valueSerializer;
        if (abstractC2364nM2059p == null) {
            try {
                abstractC2364nM2059p = m2059p(abstractC2374x, objMo2046q.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        Object obj = this._suppressableValue;
        return obj == InterfaceC2094p.a.NON_EMPTY ? abstractC2364nM2059p.mo2021d(abstractC2374x, objMo2046q) : obj.equals(objMo2046q);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: e */
    public boolean mo2058e() {
        return this._unwrapper != null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Object objMo2047r = mo2047r(t);
        if (objMo2047r == null) {
            if (this._unwrapper == null) {
                abstractC2374x.m2248l(abstractC2108d);
                return;
            }
            return;
        }
        AbstractC2364n<Object> abstractC2364nM2059p = this._valueSerializer;
        if (abstractC2364nM2059p == null) {
            abstractC2364nM2059p = m2059p(abstractC2374x, objMo2047r.getClass());
        }
        AbstractC2215g abstractC2215g = this._valueTypeSerializer;
        if (abstractC2215g != null) {
            abstractC2364nM2059p.mo1808g(objMo2047r, abstractC2108d, abstractC2374x, abstractC2215g);
        } else {
            abstractC2364nM2059p.mo1807f(objMo2047r, abstractC2108d, abstractC2374x);
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Object objMo2047r = mo2047r(t);
        if (objMo2047r == null) {
            if (this._unwrapper == null) {
                abstractC2374x.m2248l(abstractC2108d);
            }
        } else {
            AbstractC2364n<Object> abstractC2364nM2059p = this._valueSerializer;
            if (abstractC2364nM2059p == null) {
                abstractC2364nM2059p = m2059p(abstractC2374x, objMo2047r.getClass());
            }
            abstractC2364nM2059p.mo1808g(objMo2047r, abstractC2108d, abstractC2374x, abstractC2215g);
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: h */
    public AbstractC2364n<T> mo1984h(AbstractC2352n abstractC2352n) {
        AbstractC2364n<?> abstractC2364nMo1984h = this._valueSerializer;
        if (abstractC2364nMo1984h != null && (abstractC2364nMo1984h = abstractC2364nMo1984h.mo1984h(abstractC2352n)) == this._valueSerializer) {
            return this;
        }
        AbstractC2352n abstractC2352n2 = this._unwrapper;
        if (abstractC2352n2 != null) {
            abstractC2352n = new AbstractC2352n.a(abstractC2352n, abstractC2352n2);
        }
        return (this._valueSerializer == abstractC2364nMo1984h && abstractC2352n2 == abstractC2352n) ? this : mo2050u(this._property, this._valueTypeSerializer, abstractC2364nMo1984h, abstractC2352n);
    }

    /* JADX INFO: renamed from: p */
    public final AbstractC2364n<Object> m2059p(AbstractC2374x abstractC2374x, Class<?> cls) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nMo2034c = this.f4852k.mo2034c(cls);
        if (abstractC2364nMo2034c != null) {
            return abstractC2364nMo2034c;
        }
        AbstractC2364n<Object> abstractC2364nM2252q = this._referredType.mo2102r() ? abstractC2374x.m2252q(abstractC2374x.m2247k(this._referredType, cls), this._property) : abstractC2374x.m2253r(cls, this._property);
        AbstractC2352n abstractC2352n = this._unwrapper;
        if (abstractC2352n != null) {
            abstractC2364nM2252q = abstractC2364nM2252q.mo1984h(abstractC2352n);
        }
        AbstractC2364n<Object> abstractC2364n = abstractC2364nM2252q;
        this.f4852k = this.f4852k.mo2033b(cls, abstractC2364n);
        return abstractC2364n;
    }

    /* JADX INFO: renamed from: q */
    public abstract Object mo2046q(T t);

    /* JADX INFO: renamed from: r */
    public abstract Object mo2047r(T t);

    /* JADX INFO: renamed from: s */
    public abstract boolean mo2048s(T t);

    /* JADX INFO: renamed from: t */
    public abstract AbstractC2283f0<T> mo2049t(Object obj, boolean z2);

    /* JADX INFO: renamed from: u */
    public abstract AbstractC2283f0<T> mo2050u(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, AbstractC2352n abstractC2352n);

    public AbstractC2283f0(AbstractC2283f0<?> abstractC2283f0, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, AbstractC2352n abstractC2352n, Object obj, boolean z2) {
        super(abstractC2283f0);
        this._referredType = abstractC2283f0._referredType;
        this.f4852k = AbstractC2262l.b.f4828b;
        this._property = interfaceC2206d;
        this._valueTypeSerializer = abstractC2215g;
        this._valueSerializer = abstractC2364n;
        this._unwrapper = abstractC2352n;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
