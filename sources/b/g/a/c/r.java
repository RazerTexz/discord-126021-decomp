package b.g.a.c;

import b.g.a.c.c0.d0;
import b.g.a.c.c0.w$b;
import b.g.a.c.g0.j$a;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ObjectMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends b.g.a.b.i implements Serializable {
    public static final b j;
    public static final b.g.a.c.z.a k;
    private static final long serialVersionUID = 2;
    public final b.g.a.c.z.d _coercionConfigs;
    public final b.g.a.c.z.g _configOverrides;
    public f _deserializationConfig;
    public b.g.a.c.a0.d _deserializationContext;
    public i _injectableValues;
    public final b.g.a.b.c _jsonFactory;
    public d0 _mixIns;
    public Set<Object> _registeredModuleTypes;
    public final ConcurrentHashMap<j, k<Object>> _rootDeserializers;
    public v _serializationConfig;
    public b.g.a.c.g0.q _serializerFactory;
    public b.g.a.c.g0.j _serializerProvider;
    public b.g.a.c.e0.d _subtypeResolver;
    public b.g.a.c.h0.n _typeFactory;

    static {
        b.g.a.c.c0.x xVar = new b.g.a.c.c0.x();
        j = xVar;
        k = new b.g.a.c.z.a(null, xVar, null, b.g.a.c.h0.n.k, null, b.g.a.c.i0.r.p, Locale.getDefault(), null, b.g.a.b.b.f656b, b.g.a.c.e0.h.g.j, new w$b());
    }

    public r() {
        this(null, null, null);
    }

    public final void a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    public final void b(b.g.a.b.d dVar, Object obj) throws IOException {
        v vVar = this._serializationConfig;
        if (!vVar.v(w.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                this._serializerProvider.K(vVar, this._serializerFactory).L(dVar, obj);
                dVar.close();
                return;
            } catch (Exception e) {
                Annotation[] annotationArr = b.g.a.c.i0.d.a;
                dVar.b(b.g.a.b.d$a.AUTO_CLOSE_JSON_CONTENT);
                try {
                    dVar.close();
                } catch (Exception e2) {
                    e.addSuppressed(e2);
                }
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                b.g.a.c.i0.d.x(e);
                throw new RuntimeException(e);
            }
        }
        Closeable closeable = (Closeable) obj;
        try {
            this._serializerProvider.K(vVar, this._serializerFactory).L(dVar, obj);
            try {
                closeable.close();
                dVar.close();
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                b.g.a.c.i0.d.f(dVar, closeable, e);
                throw null;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public b.g.a.b.d c(Writer writer) throws IOException {
        a("w", writer);
        b.g.a.b.c cVar = this._jsonFactory;
        b.g.a.b.p.c cVar2 = new b.g.a.b.p.c(cVar.a(), writer, false);
        if (cVar._outputDecorator != null) {
            throw null;
        }
        b.g.a.b.q.d dVar = new b.g.a.b.q.d(cVar2, cVar._generatorFeatures, cVar._objectCodec, writer, cVar._quoteChar);
        int i = cVar._maximumNonEscapedChar;
        if (i > 0) {
            dVar.y0(i);
        }
        if (cVar._characterEscapes != null) {
            throw null;
        }
        b.g.a.b.k kVar = cVar._rootValueSeparator;
        if (kVar != b.g.a.b.c.m) {
            dVar.v = kVar;
        }
        v vVar = this._serializationConfig;
        Objects.requireNonNull(vVar);
        if (w.INDENT_OUTPUT.h(vVar._serFeatures) && dVar.l == null) {
            b.g.a.b.j jVar = vVar._defaultPrettyPrinter;
            if (jVar instanceof b.g.a.b.t.e) {
                jVar = (b.g.a.b.j) ((b.g.a.b.t.e) jVar).e();
            }
            if (jVar != null) {
                dVar.l = jVar;
            }
        }
        boolean zH = w.WRITE_BIGDECIMAL_AS_PLAIN.h(vVar._serFeatures);
        int i2 = vVar._generatorFeaturesToChange;
        if (i2 != 0 || zH) {
            int i3 = vVar._generatorFeatures;
            if (zH) {
                int iH = b.g.a.b.d$a.WRITE_BIGDECIMAL_AS_PLAIN.h();
                i3 |= iH;
                i2 |= iH;
            }
            dVar.w0(i3, i2);
        }
        return dVar;
    }

    public r(b.g.a.b.c cVar, b.g.a.c.g0.j jVar, b.g.a.c.a0.d dVar) {
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (cVar == null) {
            this._jsonFactory = new q(this);
        } else {
            this._jsonFactory = cVar;
            if (cVar.b() == null) {
                cVar._objectCodec = this;
            }
        }
        this._subtypeResolver = new b.g.a.c.e0.h.i();
        b.g.a.c.i0.p pVar = new b.g.a.c.i0.p();
        this._typeFactory = b.g.a.c.h0.n.k;
        d0 d0Var = new d0(null);
        this._mixIns = d0Var;
        b.g.a.c.z.a aVar = k;
        b.g.a.c.c0.r rVar = new b.g.a.c.c0.r();
        b.g.a.c.z.a aVar2 = aVar._classIntrospector == rVar ? aVar : new b.g.a.c.z.a(rVar, aVar._annotationIntrospector, aVar._propertyNamingStrategy, aVar._typeFactory, aVar._typeResolverBuilder, aVar._dateFormat, aVar._locale, aVar._timeZone, aVar._defaultBase64, aVar._typeValidator, aVar._accessorNaming);
        b.g.a.c.z.g gVar = new b.g.a.c.z.g();
        this._configOverrides = gVar;
        b.g.a.c.z.d dVar2 = new b.g.a.c.z.d();
        this._coercionConfigs = dVar2;
        b.g.a.c.z.a aVar3 = aVar2;
        this._serializationConfig = new v(aVar3, this._subtypeResolver, d0Var, pVar, gVar);
        this._deserializationConfig = new f(aVar3, this._subtypeResolver, d0Var, pVar, gVar, dVar2);
        Objects.requireNonNull(this._jsonFactory);
        v vVar = this._serializationConfig;
        p pVar2 = p.SORT_PROPERTIES_ALPHABETICALLY;
        if (vVar.q(pVar2)) {
            this._serializationConfig = this._serializationConfig.t(pVar2);
            this._deserializationConfig = this._deserializationConfig.t(pVar2);
        }
        this._serializerProvider = new j$a();
        this._deserializationContext = new b.g.a.c.a0.d$a(b.g.a.c.a0.b.j);
        this._serializerFactory = b.g.a.c.g0.f.l;
    }
}
