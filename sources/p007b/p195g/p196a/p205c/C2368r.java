package p007b.p195g.p196a.p205c;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2113i;
import p007b.p195g.p196a.p198b.C2106b;
import p007b.p195g.p196a.p198b.C2107c;
import p007b.p195g.p196a.p198b.InterfaceC2114j;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p200p.C2123c;
import p007b.p195g.p196a.p198b.p201q.C2134d;
import p007b.p195g.p196a.p198b.p204t.InterfaceC2143e;
import p007b.p195g.p196a.p205c.p206a0.AbstractC2156d;
import p007b.p195g.p196a.p205c.p206a0.C2154b;
import p007b.p195g.p196a.p205c.p210c0.C2180d0;
import p007b.p195g.p196a.p205c.p210c0.C2197r;
import p007b.p195g.p196a.p205c.p210c0.C2202w;
import p007b.p195g.p196a.p205c.p210c0.C2203x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2212d;
import p007b.p195g.p196a.p205c.p212e0.p213h.C2222g;
import p007b.p195g.p196a.p205c.p212e0.p213h.C2224i;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2241j;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2248q;
import p007b.p195g.p196a.p205c.p215g0.C2237f;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2354p;
import p007b.p195g.p196a.p205c.p219i0.C2356r;
import p007b.p195g.p196a.p205c.p221z.C2383a;
import p007b.p195g.p196a.p205c.p221z.C2386d;
import p007b.p195g.p196a.p205c.p221z.C2389g;

/* JADX INFO: renamed from: b.g.a.c.r */
/* JADX INFO: compiled from: ObjectMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2368r extends AbstractC2113i implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final AbstractC2165b f5023j;

    /* JADX INFO: renamed from: k */
    public static final C2383a f5024k;
    private static final long serialVersionUID = 2;
    public final C2386d _coercionConfigs;
    public final C2389g _configOverrides;
    public C2229f _deserializationConfig;
    public AbstractC2156d _deserializationContext;
    public AbstractC2338i _injectableValues;
    public final C2107c _jsonFactory;
    public C2180d0 _mixIns;
    public Set<Object> _registeredModuleTypes;
    public final ConcurrentHashMap<AbstractC2360j, AbstractC2361k<Object>> _rootDeserializers;
    public C2372v _serializationConfig;
    public AbstractC2248q _serializerFactory;
    public AbstractC2241j _serializerProvider;
    public AbstractC2212d _subtypeResolver;
    public C2335n _typeFactory;

    static {
        C2203x c2203x = new C2203x();
        f5023j = c2203x;
        f5024k = new C2383a(null, c2203x, null, C2335n.f4925k, null, C2356r.f4974p, Locale.getDefault(), null, C2106b.f4452b, C2222g.f4772j, new C2202w.b());
    }

    public C2368r() {
        this(null, null, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m2223a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2224b(AbstractC2108d abstractC2108d, Object obj) throws IOException {
        C2372v c2372v = this._serializationConfig;
        if (!c2372v.m2237v(EnumC2373w.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                this._serializerProvider.mo2003K(c2372v, this._serializerFactory).m2004L(abstractC2108d, obj);
                abstractC2108d.close();
                return;
            } catch (Exception e) {
                Annotation[] annotationArr = C2342d.f4944a;
                abstractC2108d.mo1648b(AbstractC2108d.a.AUTO_CLOSE_JSON_CONTENT);
                try {
                    abstractC2108d.close();
                } catch (Exception e2) {
                    e.addSuppressed(e2);
                }
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                C2342d.m2192x(e);
                throw new RuntimeException(e);
            }
        }
        Closeable closeable = (Closeable) obj;
        try {
            this._serializerProvider.mo2003K(c2372v, this._serializerFactory).m2004L(abstractC2108d, obj);
            try {
                closeable.close();
                abstractC2108d.close();
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                C2342d.m2174f(abstractC2108d, closeable, e);
                throw null;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: renamed from: c */
    public AbstractC2108d m2225c(Writer writer) throws IOException {
        m2223a("w", writer);
        C2107c c2107c = this._jsonFactory;
        C2123c c2123c = new C2123c(c2107c.m1626a(), writer, false);
        if (c2107c._outputDecorator != null) {
            throw null;
        }
        C2134d c2134d = new C2134d(c2123c, c2107c._generatorFeatures, c2107c._objectCodec, writer, c2107c._quoteChar);
        int i = c2107c._maximumNonEscapedChar;
        if (i > 0) {
            c2134d.m1705y0(i);
        }
        if (c2107c._characterEscapes != null) {
            throw null;
        }
        InterfaceC2115k interfaceC2115k = c2107c._rootValueSeparator;
        if (interfaceC2115k != C2107c.f4458m) {
            c2134d.f4568v = interfaceC2115k;
        }
        C2372v c2372v = this._serializationConfig;
        Objects.requireNonNull(c2372v);
        if (EnumC2373w.INDENT_OUTPUT.m2238h(c2372v._serFeatures) && c2134d.f4466l == null) {
            InterfaceC2114j interfaceC2114j = c2372v._defaultPrettyPrinter;
            if (interfaceC2114j instanceof InterfaceC2143e) {
                interfaceC2114j = (InterfaceC2114j) ((InterfaceC2143e) interfaceC2114j).mo1732e();
            }
            if (interfaceC2114j != null) {
                c2134d.f4466l = interfaceC2114j;
            }
        }
        boolean zM2238h = EnumC2373w.WRITE_BIGDECIMAL_AS_PLAIN.m2238h(c2372v._serFeatures);
        int i2 = c2372v._generatorFeaturesToChange;
        if (i2 != 0 || zM2238h) {
            int i3 = c2372v._generatorFeatures;
            if (zM2238h) {
                int iM1669h = AbstractC2108d.a.WRITE_BIGDECIMAL_AS_PLAIN.m1669h();
                i3 |= iM1669h;
                i2 |= iM1669h;
            }
            c2134d.m1694w0(i3, i2);
        }
        return c2134d;
    }

    public C2368r(C2107c c2107c, AbstractC2241j abstractC2241j, AbstractC2156d abstractC2156d) {
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (c2107c == null) {
            this._jsonFactory = new C2367q(this);
        } else {
            this._jsonFactory = c2107c;
            if (c2107c.mo1627b() == null) {
                c2107c._objectCodec = this;
            }
        }
        this._subtypeResolver = new C2224i();
        C2354p c2354p = new C2354p();
        this._typeFactory = C2335n.f4925k;
        C2180d0 c2180d0 = new C2180d0(null);
        this._mixIns = c2180d0;
        C2383a c2383a = f5024k;
        C2197r c2197r = new C2197r();
        C2383a c2383a2 = c2383a._classIntrospector == c2197r ? c2383a : new C2383a(c2197r, c2383a._annotationIntrospector, c2383a._propertyNamingStrategy, c2383a._typeFactory, c2383a._typeResolverBuilder, c2383a._dateFormat, c2383a._locale, c2383a._timeZone, c2383a._defaultBase64, c2383a._typeValidator, c2383a._accessorNaming);
        C2389g c2389g = new C2389g();
        this._configOverrides = c2389g;
        C2386d c2386d = new C2386d();
        this._coercionConfigs = c2386d;
        C2383a c2383a3 = c2383a2;
        this._serializationConfig = new C2372v(c2383a3, this._subtypeResolver, c2180d0, c2354p, c2389g);
        this._deserializationConfig = new C2229f(c2383a3, this._subtypeResolver, c2180d0, c2354p, c2389g, c2386d);
        Objects.requireNonNull(this._jsonFactory);
        C2372v c2372v = this._serializationConfig;
        EnumC2366p enumC2366p = EnumC2366p.SORT_PROPERTIES_ALPHABETICALLY;
        if (c2372v.m2279q(enumC2366p)) {
            this._serializationConfig = this._serializationConfig.m2281t(enumC2366p);
            this._deserializationConfig = this._deserializationConfig.m2281t(enumC2366p);
        }
        this._serializerProvider = new AbstractC2241j.a();
        this._deserializationContext = new AbstractC2156d.a(C2154b.f4618j);
        this._serializerFactory = C2237f.f4805l;
    }
}
