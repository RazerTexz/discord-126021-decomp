package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Map;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2241j;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2248q;
import p007b.p195g.p196a.p205c.p215g0.C2247p;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2246o;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2253c;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2263m;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2267q;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2271u;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2312u;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2359u;
import p007b.p195g.p196a.p205c.p221z.AbstractC2391i;

/* JADX INFO: renamed from: b.g.a.c.x */
/* JADX INFO: compiled from: SerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2374x extends AbstractC2208e {

    /* JADX INFO: renamed from: j */
    public static final AbstractC2364n<Object> f5061j = new C2253c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");

    /* JADX INFO: renamed from: k */
    public static final AbstractC2364n<Object> f5062k = new C2267q();
    public final C2372v _config;
    public DateFormat _dateFormat;
    public AbstractC2364n<Object> _keySerializer;
    public final C2263m _knownSerializers;
    public AbstractC2364n<Object> _nullKeySerializer;
    public AbstractC2364n<Object> _nullValueSerializer;
    public final Class<?> _serializationView;
    public final C2247p _serializerCache;
    public final AbstractC2248q _serializerFactory;
    public final boolean _stdNullValueSerializer;
    public AbstractC2364n<Object> _unknownTypeSerializer;

    /* JADX INFO: renamed from: l */
    public transient AbstractC2391i f5063l;

    public AbstractC2374x() {
        this._unknownTypeSerializer = f5062k;
        this._nullValueSerializer = C2312u.f4867k;
        this._nullKeySerializer = f5061j;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new C2247p();
        this._knownSerializers = null;
        this._serializationView = null;
        this.f5063l = null;
        this._stdNullValueSerializer = true;
    }

    /* JADX INFO: renamed from: A */
    public abstract Object mo1998A(AbstractC2198s abstractC2198s, Class<?> cls) throws JsonMappingException;

    /* JADX INFO: renamed from: B */
    public abstract boolean mo1999B(Object obj) throws JsonMappingException;

    /* JADX INFO: renamed from: C */
    public final boolean m2239C(EnumC2366p enumC2366p) {
        return enumC2366p.m2222h(this._config._mapperFeatures);
    }

    /* JADX INFO: renamed from: D */
    public final boolean m2240D(EnumC2373w enumC2373w) {
        return this._config.m2237v(enumC2373w);
    }

    /* JADX INFO: renamed from: E */
    public <T> T m2241E(AbstractC2172c abstractC2172c, AbstractC2198s abstractC2198s, String str, Object... objArr) throws JsonMappingException {
        String str2;
        String strM1937a = m1937a(str, objArr);
        if (abstractC2198s != null) {
            String strMo1858p = abstractC2198s.mo1858p();
            if (strMo1858p == null) {
                str2 = "[N/A]";
            } else {
                Object[] objArr2 = new Object[1];
                if (strMo1858p.length() > 500) {
                    strMo1858p = strMo1858p.substring(0, 500) + "]...[" + strMo1858p.substring(strMo1858p.length() - 500);
                }
                objArr2[0] = strMo1858p;
                str2 = String.format("\"%s\"", objArr2);
            }
        } else {
            str2 = "N/A";
        }
        throw new InvalidDefinitionException(((AbstractC2241j) this).f4808o, String.format("Invalid definition for property %s (of type %s): %s", str2, abstractC2172c != null ? C2342d.m2189u(abstractC2172c.f4626a._class) : "N/A", strM1937a), abstractC2172c, abstractC2198s);
    }

    /* JADX INFO: renamed from: F */
    public <T> T m2242F(AbstractC2172c abstractC2172c, String str, Object... objArr) throws JsonMappingException {
        throw new InvalidDefinitionException(((AbstractC2241j) this).f4808o, String.format("Invalid type definition for type %s: %s", C2342d.m2189u(abstractC2172c.f4626a._class), m1937a(str, objArr)), abstractC2172c, null);
    }

    /* JADX INFO: renamed from: G */
    public void m2243G(String str, Object... objArr) throws JsonMappingException {
        throw new JsonMappingException(((AbstractC2241j) this).f4808o, m1937a(str, objArr), null);
    }

    /* JADX INFO: renamed from: H */
    public abstract AbstractC2364n<Object> mo2000H(AbstractC2175b abstractC2175b, Object obj) throws JsonMappingException;

    @Override // p007b.p195g.p196a.p205c.AbstractC2208e
    /* JADX INFO: renamed from: d */
    public final C2335n mo1940d() {
        return this._config._base._typeFactory;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2208e
    /* JADX INFO: renamed from: f */
    public <T> T mo1942f(AbstractC2360j abstractC2360j, String str) throws JsonMappingException {
        throw new InvalidDefinitionException(((AbstractC2241j) this).f4808o, str, abstractC2360j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: h */
    public AbstractC2364n<Object> m2244h(AbstractC2360j abstractC2360j) throws JsonMappingException {
        try {
            AbstractC2364n<Object> abstractC2364nMo1991b = this._serializerFactory.mo1991b(this, abstractC2360j);
            if (abstractC2364nMo1991b != 0) {
                C2247p c2247p = this._serializerCache;
                synchronized (c2247p) {
                    if (c2247p.f4815a.put(new C2359u(abstractC2360j, false), abstractC2364nMo1991b) == null) {
                        c2247p.f4816b.set(null);
                    }
                    if (abstractC2364nMo1991b instanceof InterfaceC2246o) {
                        ((InterfaceC2246o) abstractC2364nMo1991b).mo2007b(this);
                    }
                }
            }
            return abstractC2364nMo1991b;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((AbstractC2241j) this).f4808o, m1937a(C2342d.m2176h(e), new Object[0]), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: i */
    public AbstractC2364n<Object> m2245i(Class<?> cls) throws JsonMappingException {
        AbstractC2360j abstractC2360jM2160b = this._config._base._typeFactory.m2160b(null, cls, C2335n.f4926l);
        try {
            AbstractC2364n<Object> abstractC2364nMo1991b = this._serializerFactory.mo1991b(this, abstractC2360jM2160b);
            if (abstractC2364nMo1991b != 0) {
                C2247p c2247p = this._serializerCache;
                synchronized (c2247p) {
                    AbstractC2364n<Object> abstractC2364nPut = c2247p.f4815a.put(new C2359u(cls, false), abstractC2364nMo1991b);
                    AbstractC2364n<Object> abstractC2364nPut2 = c2247p.f4815a.put(new C2359u(abstractC2360jM2160b, false), abstractC2364nMo1991b);
                    if (abstractC2364nPut == null || abstractC2364nPut2 == null) {
                        c2247p.f4816b.set(null);
                    }
                    if (abstractC2364nMo1991b instanceof InterfaceC2246o) {
                        ((InterfaceC2246o) abstractC2364nMo1991b).mo2007b(this);
                    }
                }
            }
            return abstractC2364nMo1991b;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((AbstractC2241j) this).f4808o, m1937a(C2342d.m2176h(e), new Object[0]), e);
        }
    }

    /* JADX INFO: renamed from: j */
    public final DateFormat m2246j() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config._base._dateFormat.clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    /* JADX INFO: renamed from: k */
    public AbstractC2360j m2247k(AbstractC2360j abstractC2360j, Class<?> cls) throws IllegalArgumentException {
        return abstractC2360j._class == cls ? abstractC2360j : this._config._base._typeFactory.m2166h(abstractC2360j, cls, true);
    }

    /* JADX INFO: renamed from: l */
    public final void m2248l(AbstractC2108d abstractC2108d) throws IOException {
        if (this._stdNullValueSerializer) {
            abstractC2108d.mo1631A();
        } else {
            this._nullValueSerializer.mo1807f(null, abstractC2108d, this);
        }
    }

    /* JADX INFO: renamed from: m */
    public AbstractC2364n<Object> m2249m(AbstractC2360j abstractC2360j, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2035a = this._knownSerializers.m2035a(abstractC2360j);
        return (abstractC2364nM2035a == null && (abstractC2364nM2035a = this._serializerCache.m2008a(abstractC2360j)) == null && (abstractC2364nM2035a = m2244h(abstractC2360j)) == null) ? m2259x(abstractC2360j._class) : m2261z(abstractC2364nM2035a, interfaceC2206d);
    }

    /* JADX INFO: renamed from: n */
    public AbstractC2364n<Object> m2250n(Class<?> cls, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2036b = this._knownSerializers.m2036b(cls);
        return (abstractC2364nM2036b == null && (abstractC2364nM2036b = this._serializerCache.m2009b(cls)) == null && (abstractC2364nM2036b = this._serializerCache.m2008a(this._config._base._typeFactory.m2160b(null, cls, C2335n.f4926l))) == null && (abstractC2364nM2036b = m2245i(cls)) == null) ? m2259x(cls) : m2261z(abstractC2364nM2036b, interfaceC2206d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: o */
    public AbstractC2364n<Object> m2251o(AbstractC2360j abstractC2360j, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nMo1971a = this._serializerFactory.mo1971a(this, abstractC2360j, this._keySerializer);
        if (abstractC2364nMo1971a instanceof InterfaceC2246o) {
            ((InterfaceC2246o) abstractC2364nMo1971a).mo2007b(this);
        }
        return m2261z(abstractC2364nMo1971a, interfaceC2206d);
    }

    /* JADX INFO: renamed from: p */
    public abstract C2271u mo2005p(Object obj, AbstractC2082i0<?> abstractC2082i0);

    /* JADX INFO: renamed from: q */
    public AbstractC2364n<Object> m2252q(AbstractC2360j abstractC2360j, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2035a = this._knownSerializers.m2035a(abstractC2360j);
        return (abstractC2364nM2035a == null && (abstractC2364nM2035a = this._serializerCache.m2008a(abstractC2360j)) == null && (abstractC2364nM2035a = m2244h(abstractC2360j)) == null) ? m2259x(abstractC2360j._class) : m2260y(abstractC2364nM2035a, interfaceC2206d);
    }

    /* JADX INFO: renamed from: r */
    public AbstractC2364n<Object> m2253r(Class<?> cls, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2036b = this._knownSerializers.m2036b(cls);
        return (abstractC2364nM2036b == null && (abstractC2364nM2036b = this._serializerCache.m2009b(cls)) == null && (abstractC2364nM2036b = this._serializerCache.m2008a(this._config._base._typeFactory.m2160b(null, cls, C2335n.f4926l))) == null && (abstractC2364nM2036b = m2245i(cls)) == null) ? m2259x(cls) : m2260y(abstractC2364nM2036b, interfaceC2206d);
    }

    /* JADX INFO: renamed from: s */
    public AbstractC2364n<Object> m2254s(AbstractC2360j abstractC2360j) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2035a = this._knownSerializers.m2035a(abstractC2360j);
        if (abstractC2364nM2035a != null) {
            return abstractC2364nM2035a;
        }
        AbstractC2364n<Object> abstractC2364nM2008a = this._serializerCache.m2008a(abstractC2360j);
        if (abstractC2364nM2008a != null) {
            return abstractC2364nM2008a;
        }
        AbstractC2364n<Object> abstractC2364nM2244h = m2244h(abstractC2360j);
        return abstractC2364nM2244h == null ? m2259x(abstractC2360j._class) : abstractC2364nM2244h;
    }

    /* JADX INFO: renamed from: t */
    public AbstractC2364n<Object> m2255t(AbstractC2360j abstractC2360j, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        if (abstractC2360j != null) {
            AbstractC2364n<Object> abstractC2364nM2035a = this._knownSerializers.m2035a(abstractC2360j);
            return (abstractC2364nM2035a == null && (abstractC2364nM2035a = this._serializerCache.m2008a(abstractC2360j)) == null && (abstractC2364nM2035a = m2244h(abstractC2360j)) == null) ? m2259x(abstractC2360j._class) : m2261z(abstractC2364nM2035a, interfaceC2206d);
        }
        m2243G("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: u */
    public AbstractC2364n<Object> m2256u(Class<?> cls, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2036b = this._knownSerializers.m2036b(cls);
        return (abstractC2364nM2036b == null && (abstractC2364nM2036b = this._serializerCache.m2009b(cls)) == null && (abstractC2364nM2036b = this._serializerCache.m2008a(this._config._base._typeFactory.m2160b(null, cls, C2335n.f4926l))) == null && (abstractC2364nM2036b = m2245i(cls)) == null) ? m2259x(cls) : m2261z(abstractC2364nM2036b, interfaceC2206d);
    }

    /* JADX INFO: renamed from: v */
    public final AbstractC2165b m2257v() {
        return this._config.m2267e();
    }

    /* JADX INFO: renamed from: w */
    public Object m2258w(Object obj) {
        Object obj2;
        AbstractC2391i.a aVar = (AbstractC2391i.a) this.f5063l;
        Map<Object, Object> map = aVar.f5089l;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return aVar._shared.get(obj);
        }
        if (obj2 == AbstractC2391i.a.f5088k) {
            return null;
        }
        return obj2;
    }

    /* JADX INFO: renamed from: x */
    public AbstractC2364n<Object> m2259x(Class<?> cls) {
        return cls == Object.class ? this._unknownTypeSerializer : new C2267q(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: y */
    public AbstractC2364n<?> m2260y(AbstractC2364n<?> abstractC2364n, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        return (abstractC2364n == 0 || !(abstractC2364n instanceof InterfaceC2240i)) ? abstractC2364n : ((InterfaceC2240i) abstractC2364n).mo1997a(this, interfaceC2206d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: z */
    public AbstractC2364n<?> m2261z(AbstractC2364n<?> abstractC2364n, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        return (abstractC2364n == 0 || !(abstractC2364n instanceof InterfaceC2240i)) ? abstractC2364n : ((InterfaceC2240i) abstractC2364n).mo1997a(this, interfaceC2206d);
    }

    public AbstractC2374x(AbstractC2374x abstractC2374x, C2372v c2372v, AbstractC2248q abstractC2248q) {
        this._unknownTypeSerializer = f5062k;
        this._nullValueSerializer = C2312u.f4867k;
        AbstractC2364n<Object> abstractC2364n = f5061j;
        this._nullKeySerializer = abstractC2364n;
        this._serializerFactory = abstractC2248q;
        this._config = c2372v;
        C2247p c2247p = abstractC2374x._serializerCache;
        this._serializerCache = c2247p;
        this._unknownTypeSerializer = abstractC2374x._unknownTypeSerializer;
        this._keySerializer = abstractC2374x._keySerializer;
        AbstractC2364n<Object> abstractC2364n2 = abstractC2374x._nullValueSerializer;
        this._nullValueSerializer = abstractC2364n2;
        this._nullKeySerializer = abstractC2374x._nullKeySerializer;
        this._stdNullValueSerializer = abstractC2364n2 == abstractC2364n;
        this._serializationView = c2372v._view;
        this.f5063l = c2372v._attributes;
        C2263m c2263m = c2247p.f4816b.get();
        if (c2263m == null) {
            synchronized (c2247p) {
                c2263m = c2247p.f4816b.get();
                if (c2263m == null) {
                    C2263m c2263m2 = new C2263m(c2247p.f4815a);
                    c2247p.f4816b.set(c2263m2);
                    c2263m = c2263m2;
                }
            }
        }
        this._knownSerializers = c2263m;
    }
}
