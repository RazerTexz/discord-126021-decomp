package b.g.a.c;

import b.g.a.b.Base64Variants;
import b.g.a.b.JsonFactory;
import b.g.a.b.JsonGenerator;
import b.g.a.b.ObjectCodec;
import b.g.a.b.PrettyPrinter2;
import b.g.a.b.SerializableString;
import b.g.a.b.p.IOContext;
import b.g.a.b.q.WriterBasedJsonGenerator;
import b.g.a.b.t.Instantiatable;
import b.g.a.c.a0.BeanDeserializerFactory;
import b.g.a.c.a0.DefaultDeserializationContext;
import b.g.a.c.c0.BasicClassIntrospector;
import b.g.a.c.c0.DefaultAccessorNamingStrategy;
import b.g.a.c.c0.JacksonAnnotationIntrospector;
import b.g.a.c.c0.SimpleMixInResolver;
import b.g.a.c.e0.SubtypeResolver;
import b.g.a.c.e0.h.LaissezFaireSubTypeValidator;
import b.g.a.c.e0.h.StdSubtypeResolver;
import b.g.a.c.g0.BeanSerializerFactory;
import b.g.a.c.g0.DefaultSerializerProvider;
import b.g.a.c.g0.SerializerFactory2;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.RootNameLookup;
import b.g.a.c.i0.StdDateFormat;
import b.g.a.c.z.BaseSettings;
import b.g.a.c.z.CoercionConfigs;
import b.g.a.c.z.ConfigOverrides;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.c.r, reason: use source file name */
/* JADX INFO: compiled from: ObjectMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectMapper extends ObjectCodec implements Serializable {
    public static final AnnotationIntrospector j;
    public static final BaseSettings k;
    private static final long serialVersionUID = 2;
    public final CoercionConfigs _coercionConfigs;
    public final ConfigOverrides _configOverrides;
    public DeserializationConfig _deserializationConfig;
    public DefaultDeserializationContext _deserializationContext;
    public InjectableValues _injectableValues;
    public final JsonFactory _jsonFactory;
    public SimpleMixInResolver _mixIns;
    public Set<Object> _registeredModuleTypes;
    public final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    public SerializationConfig _serializationConfig;
    public SerializerFactory2 _serializerFactory;
    public DefaultSerializerProvider _serializerProvider;
    public SubtypeResolver _subtypeResolver;
    public TypeFactory _typeFactory;

    static {
        JacksonAnnotationIntrospector jacksonAnnotationIntrospector = new JacksonAnnotationIntrospector();
        j = jacksonAnnotationIntrospector;
        k = new BaseSettings(null, jacksonAnnotationIntrospector, null, TypeFactory.k, null, StdDateFormat.p, Locale.getDefault(), null, Base64Variants.f656b, LaissezFaireSubTypeValidator.j, new DefaultAccessorNamingStrategy.b());
    }

    public ObjectMapper() {
        this(null, null, null);
    }

    public final void a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    public final void b(JsonGenerator jsonGenerator, Object obj) throws IOException {
        SerializationConfig serializationConfig = this._serializationConfig;
        if (!serializationConfig.v(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                this._serializerProvider.K(serializationConfig, this._serializerFactory).L(jsonGenerator, obj);
                jsonGenerator.close();
                return;
            } catch (Exception e) {
                Annotation[] annotationArr = ClassUtil.a;
                jsonGenerator.b(JsonGenerator.a.AUTO_CLOSE_JSON_CONTENT);
                try {
                    jsonGenerator.close();
                } catch (Exception e2) {
                    e.addSuppressed(e2);
                }
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                ClassUtil.x(e);
                throw new RuntimeException(e);
            }
        }
        Closeable closeable = (Closeable) obj;
        try {
            this._serializerProvider.K(serializationConfig, this._serializerFactory).L(jsonGenerator, obj);
            try {
                closeable.close();
                jsonGenerator.close();
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                ClassUtil.f(jsonGenerator, closeable, e);
                throw null;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public JsonGenerator c(Writer writer) throws IOException {
        a("w", writer);
        JsonFactory jsonFactory = this._jsonFactory;
        IOContext iOContext = new IOContext(jsonFactory.a(), writer, false);
        if (jsonFactory._outputDecorator != null) {
            throw null;
        }
        WriterBasedJsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, jsonFactory._generatorFeatures, jsonFactory._objectCodec, writer, jsonFactory._quoteChar);
        int i = jsonFactory._maximumNonEscapedChar;
        if (i > 0) {
            writerBasedJsonGenerator.y0(i);
        }
        if (jsonFactory._characterEscapes != null) {
            throw null;
        }
        SerializableString serializableString = jsonFactory._rootValueSeparator;
        if (serializableString != JsonFactory.m) {
            writerBasedJsonGenerator.v = serializableString;
        }
        SerializationConfig serializationConfig = this._serializationConfig;
        Objects.requireNonNull(serializationConfig);
        if (SerializationFeature.INDENT_OUTPUT.h(serializationConfig._serFeatures) && writerBasedJsonGenerator.l == null) {
            PrettyPrinter2 prettyPrinter2 = serializationConfig._defaultPrettyPrinter;
            if (prettyPrinter2 instanceof Instantiatable) {
                prettyPrinter2 = (PrettyPrinter2) ((Instantiatable) prettyPrinter2).e();
            }
            if (prettyPrinter2 != null) {
                writerBasedJsonGenerator.l = prettyPrinter2;
            }
        }
        boolean zH = SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN.h(serializationConfig._serFeatures);
        int i2 = serializationConfig._generatorFeaturesToChange;
        if (i2 != 0 || zH) {
            int i3 = serializationConfig._generatorFeatures;
            if (zH) {
                int iH = JsonGenerator.a.WRITE_BIGDECIMAL_AS_PLAIN.h();
                i3 |= iH;
                i2 |= iH;
            }
            writerBasedJsonGenerator.w0(i3, i2);
        }
        return writerBasedJsonGenerator;
    }

    public ObjectMapper(JsonFactory jsonFactory, DefaultSerializerProvider defaultSerializerProvider, DefaultDeserializationContext defaultDeserializationContext) {
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (jsonFactory == null) {
            this._jsonFactory = new MappingJsonFactory(this);
        } else {
            this._jsonFactory = jsonFactory;
            if (jsonFactory.b() == null) {
                jsonFactory._objectCodec = this;
            }
        }
        this._subtypeResolver = new StdSubtypeResolver();
        RootNameLookup rootNameLookup = new RootNameLookup();
        this._typeFactory = TypeFactory.k;
        SimpleMixInResolver simpleMixInResolver = new SimpleMixInResolver(null);
        this._mixIns = simpleMixInResolver;
        BaseSettings baseSettings = k;
        BasicClassIntrospector basicClassIntrospector = new BasicClassIntrospector();
        BaseSettings baseSettings2 = baseSettings._classIntrospector == basicClassIntrospector ? baseSettings : new BaseSettings(basicClassIntrospector, baseSettings._annotationIntrospector, baseSettings._propertyNamingStrategy, baseSettings._typeFactory, baseSettings._typeResolverBuilder, baseSettings._dateFormat, baseSettings._locale, baseSettings._timeZone, baseSettings._defaultBase64, baseSettings._typeValidator, baseSettings._accessorNaming);
        ConfigOverrides configOverrides = new ConfigOverrides();
        this._configOverrides = configOverrides;
        CoercionConfigs coercionConfigs = new CoercionConfigs();
        this._coercionConfigs = coercionConfigs;
        BaseSettings baseSettings3 = baseSettings2;
        this._serializationConfig = new SerializationConfig(baseSettings3, this._subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this._deserializationConfig = new DeserializationConfig(baseSettings3, this._subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides, coercionConfigs);
        Objects.requireNonNull(this._jsonFactory);
        SerializationConfig serializationConfig = this._serializationConfig;
        MapperFeature mapperFeature = MapperFeature.SORT_PROPERTIES_ALPHABETICALLY;
        if (serializationConfig.q(mapperFeature)) {
            this._serializationConfig = this._serializationConfig.t(mapperFeature);
            this._deserializationConfig = this._deserializationConfig.t(mapperFeature);
        }
        this._serializerProvider = new DefaultSerializerProvider.a();
        this._deserializationContext = new DefaultDeserializationContext.a(BeanDeserializerFactory.j);
        this._serializerFactory = BeanSerializerFactory.l;
    }
}
