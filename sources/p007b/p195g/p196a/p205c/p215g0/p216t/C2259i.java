package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.t.i */
/* JADX INFO: compiled from: MapEntrySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2259i extends AbstractC2239h<Map.Entry<?, ?>> implements InterfaceC2240i {
    public AbstractC2262l _dynamicValueSerializers;
    public final AbstractC2360j _entryType;
    public AbstractC2364n<Object> _keySerializer;
    public final AbstractC2360j _keyType;
    public final InterfaceC2206d _property;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public AbstractC2364n<Object> _valueSerializer;
    public final AbstractC2360j _valueType;
    public final boolean _valueTypeIsStatic;
    public final AbstractC2215g _valueTypeSerializer;

    public C2259i(AbstractC2360j abstractC2360j, AbstractC2360j abstractC2360j2, AbstractC2360j abstractC2360j3, boolean z2, AbstractC2215g abstractC2215g, InterfaceC2206d interfaceC2206d) {
        super(abstractC2360j);
        this._entryType = abstractC2360j;
        this._keyType = abstractC2360j2;
        this._valueType = abstractC2360j3;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = abstractC2215g;
        this._property = interfaceC2206d;
        this._dynamicValueSerializers = AbstractC2262l.b.f4828b;
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nMo2000H;
        AbstractC2364n<?> abstractC2364nMo2000H2;
        Object obj;
        boolean zMo1999B;
        InterfaceC2094p.b bVarMo1929b;
        InterfaceC2094p.a aVar;
        Object objM572t0 = InterfaceC2094p.a.NON_EMPTY;
        AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
        AbstractC2188i member = interfaceC2206d == null ? null : interfaceC2206d.getMember();
        if (member == null || abstractC2165bM2257v == null) {
            abstractC2364nMo2000H = null;
            abstractC2364nMo2000H2 = null;
        } else {
            Object objMo1788l = abstractC2165bM2257v.mo1788l(member);
            abstractC2364nMo2000H2 = objMo1788l != null ? abstractC2374x.mo2000H(member, objMo1788l) : null;
            Object objMo1775c = abstractC2165bM2257v.mo1775c(member);
            abstractC2364nMo2000H = objMo1775c != null ? abstractC2374x.mo2000H(member, objMo1775c) : null;
        }
        if (abstractC2364nMo2000H == null) {
            abstractC2364nMo2000H = this._valueSerializer;
        }
        AbstractC2364n<?> abstractC2364nM2073k = m2073k(abstractC2374x, interfaceC2206d, abstractC2364nMo2000H);
        if (abstractC2364nM2073k == null && this._valueTypeIsStatic && !this._valueType.m2221y()) {
            abstractC2364nM2073k = abstractC2374x.m2249m(this._valueType, interfaceC2206d);
        }
        AbstractC2364n<?> abstractC2364n = abstractC2364nM2073k;
        if (abstractC2364nMo2000H2 == null) {
            abstractC2364nMo2000H2 = this._keySerializer;
        }
        AbstractC2364n<?> abstractC2364nM2251o = abstractC2364nMo2000H2 == null ? abstractC2374x.m2251o(this._keyType, interfaceC2206d) : abstractC2374x.m2261z(abstractC2364nMo2000H2, interfaceC2206d);
        Object obj2 = this._suppressableValue;
        boolean z2 = this._suppressNulls;
        if (interfaceC2206d == null || (bVarMo1929b = interfaceC2206d.mo1929b(abstractC2374x._config, null)) == null || (aVar = bVarMo1929b._contentInclusion) == InterfaceC2094p.a.USE_DEFAULTS) {
            obj = obj2;
            zMo1999B = z2;
        } else {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            objM572t0 = C1460d.m572t0(this._valueType);
                            if (objM572t0 != null && objM572t0.getClass().isArray()) {
                                objM572t0 = C1460d.m560q0(objM572t0);
                            }
                        } else if (iOrdinal != 5) {
                            obj = null;
                            zMo1999B = false;
                        } else {
                            objM572t0 = abstractC2374x.mo1998A(null, bVarMo1929b._contentFilter);
                            if (objM572t0 != null) {
                                zMo1999B = abstractC2374x.mo1999B(objM572t0);
                                obj = objM572t0;
                            }
                        }
                    }
                } else if (!this._valueType.mo1728b()) {
                    objM572t0 = null;
                }
                obj = objM572t0;
            } else {
                obj = null;
            }
            zMo1999B = true;
        }
        return new C2259i(this, abstractC2364nM2251o, abstractC2364n, obj, zMo1999B);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        Object value = ((Map.Entry) obj).getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue != null) {
            AbstractC2364n<Object> abstractC2364n = this._valueSerializer;
            if (abstractC2364n == null) {
                Class<?> cls = value.getClass();
                AbstractC2364n<Object> abstractC2364nMo2034c = this._dynamicValueSerializers.mo2034c(cls);
                if (abstractC2364nMo2034c == null) {
                    try {
                        AbstractC2262l abstractC2262l = this._dynamicValueSerializers;
                        InterfaceC2206d interfaceC2206d = this._property;
                        Objects.requireNonNull(abstractC2262l);
                        AbstractC2364n<Object> abstractC2364nM2250n = abstractC2374x.m2250n(cls, interfaceC2206d);
                        AbstractC2262l abstractC2262lMo2033b = abstractC2262l.mo2033b(cls, abstractC2364nM2250n);
                        if (abstractC2262l != abstractC2262lMo2033b) {
                            this._dynamicValueSerializers = abstractC2262lMo2033b;
                        }
                        abstractC2364n = abstractC2364nM2250n;
                    } catch (JsonMappingException unused) {
                    }
                } else {
                    abstractC2364n = abstractC2364nMo2034c;
                }
            }
            Object obj2 = this._suppressableValue;
            return obj2 == InterfaceC2094p.a.NON_EMPTY ? abstractC2364n.mo2021d(abstractC2374x, value) : obj2.equals(value);
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        abstractC2108d.mo1653d0(entry);
        m2030r(entry, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1664u();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        abstractC2108d.mo1654e(entry);
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(entry, EnumC2112h.START_OBJECT));
        m2030r(entry, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return new C2259i(this, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
    }

    /* JADX INFO: renamed from: r */
    public void m2030r(Map.Entry<?, ?> entry, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        AbstractC2364n<Object> abstractC2364n;
        AbstractC2215g abstractC2215g = this._valueTypeSerializer;
        Object key = entry.getKey();
        AbstractC2364n<Object> abstractC2364n2 = key == null ? abstractC2374x._nullKeySerializer : this._keySerializer;
        Object value = entry.getValue();
        if (value != null) {
            abstractC2364n = this._valueSerializer;
            if (abstractC2364n == null) {
                Class<?> cls = value.getClass();
                AbstractC2364n<Object> abstractC2364nMo2034c = this._dynamicValueSerializers.mo2034c(cls);
                if (abstractC2364nMo2034c != null) {
                    abstractC2364n = abstractC2364nMo2034c;
                } else if (this._valueType.mo2102r()) {
                    AbstractC2262l abstractC2262l = this._dynamicValueSerializers;
                    AbstractC2262l.d dVarM2032a = abstractC2262l.m2032a(abstractC2374x.m2247k(this._valueType, cls), abstractC2374x, this._property);
                    AbstractC2262l abstractC2262l2 = dVarM2032a.f4831b;
                    if (abstractC2262l != abstractC2262l2) {
                        this._dynamicValueSerializers = abstractC2262l2;
                    }
                    abstractC2364n = dVarM2032a.f4830a;
                } else {
                    AbstractC2262l abstractC2262l3 = this._dynamicValueSerializers;
                    InterfaceC2206d interfaceC2206d = this._property;
                    Objects.requireNonNull(abstractC2262l3);
                    AbstractC2364n<Object> abstractC2364nM2250n = abstractC2374x.m2250n(cls, interfaceC2206d);
                    AbstractC2262l abstractC2262lMo2033b = abstractC2262l3.mo2033b(cls, abstractC2364nM2250n);
                    if (abstractC2262l3 != abstractC2262lMo2033b) {
                        this._dynamicValueSerializers = abstractC2262lMo2033b;
                    }
                    abstractC2364n = abstractC2364nM2250n;
                }
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == InterfaceC2094p.a.NON_EMPTY && abstractC2364n.mo2021d(abstractC2374x, value)) || this._suppressableValue.equals(value))) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            abstractC2364n = abstractC2374x._nullValueSerializer;
        }
        abstractC2364n2.mo1807f(key, abstractC2108d, abstractC2374x);
        try {
            if (abstractC2215g == null) {
                abstractC2364n.mo1807f(value, abstractC2108d, abstractC2374x);
            } else {
                abstractC2364n.mo1808g(value, abstractC2108d, abstractC2374x, abstractC2215g);
            }
        } catch (Exception e) {
            m2077o(abstractC2374x, e, entry, C1643a.m881v("", key));
            throw null;
        }
    }

    public C2259i(C2259i c2259i, AbstractC2364n abstractC2364n, AbstractC2364n abstractC2364n2, Object obj, boolean z2) {
        super(Map.class, false);
        this._entryType = c2259i._entryType;
        this._keyType = c2259i._keyType;
        this._valueType = c2259i._valueType;
        this._valueTypeIsStatic = c2259i._valueTypeIsStatic;
        this._valueTypeSerializer = c2259i._valueTypeSerializer;
        this._keySerializer = abstractC2364n;
        this._valueSerializer = abstractC2364n2;
        this._dynamicValueSerializers = AbstractC2262l.b.f4828b;
        this._property = c2259i._property;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
