package b.g.a.c;

import b.g.a.b.PrettyPrinter2;
import b.g.a.b.t.DefaultPrettyPrinter;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.c0.BasicClassIntrospector;
import b.g.a.c.c0.DefaultAccessorNamingStrategy;
import b.g.a.c.c0.POJOPropertiesCollector;
import b.g.a.c.c0.SimpleMixInResolver;
import b.g.a.c.e0.SubtypeResolver;
import b.g.a.c.g0.FilterProvider;
import b.g.a.c.h0.ArrayType;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.RootNameLookup;
import b.g.a.c.z.BaseSettings;
import b.g.a.c.z.ConfigOverrides;
import b.g.a.c.z.MapperConfig;
import b.g.a.c.z.MapperConfigBase;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.v, reason: use source file name */
/* JADX INFO: compiled from: SerializationConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SerializationConfig extends MapperConfigBase<SerializationFeature, SerializationConfig> implements Serializable {
    public static final PrettyPrinter2 l = new DefaultPrettyPrinter();
    public static final int m = MapperConfig.c(SerializationFeature.class);
    private static final long serialVersionUID = 1;
    public final PrettyPrinter2 _defaultPrettyPrinter;
    public final FilterProvider _filterProvider;
    public final int _formatWriteFeatures;
    public final int _formatWriteFeaturesToChange;
    public final int _generatorFeatures;
    public final int _generatorFeaturesToChange;
    public final int _serFeatures;

    public SerializationConfig(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this._serFeatures = m;
        this._defaultPrettyPrinter = l;
        this._generatorFeatures = 0;
        this._generatorFeaturesToChange = 0;
        this._formatWriteFeatures = 0;
        this._formatWriteFeaturesToChange = 0;
    }

    @Override // b.g.a.c.z.MapperConfigBase
    public MapperConfigBase r(int i) {
        return new SerializationConfig(this, i, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange, this._formatWriteFeatures, this._formatWriteFeaturesToChange);
    }

    public BeanDescription u(JavaType javaType) {
        DefaultAccessorNamingStrategy defaultAccessorNamingStrategy;
        BasicClassIntrospector basicClassIntrospector = (BasicClassIntrospector) this._base._classIntrospector;
        BasicBeanDescription basicBeanDescriptionA = basicClassIntrospector.a(this, javaType);
        if (basicBeanDescriptionA != null) {
            return basicBeanDescriptionA;
        }
        boolean z2 = false;
        if (javaType.v() && !(javaType instanceof ArrayType)) {
            Class<?> cls = javaType._class;
            if (ClassUtil.r(cls) && (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls))) {
                z2 = true;
            }
        }
        BasicBeanDescription basicBeanDescriptionE = z2 ? BasicBeanDescription.e(this, javaType, basicClassIntrospector.b(this, javaType, this)) : null;
        if (basicBeanDescriptionE != null) {
            return basicBeanDescriptionE;
        }
        AnnotatedClass annotatedClassB = basicClassIntrospector.b(this, javaType, this);
        if (javaType.A()) {
            Objects.requireNonNull((DefaultAccessorNamingStrategy.b) this._base._accessorNaming);
            defaultAccessorNamingStrategy = new DefaultAccessorNamingStrategy.c(this, annotatedClassB);
        } else {
            DefaultAccessorNamingStrategy.b bVar = (DefaultAccessorNamingStrategy.b) this._base._accessorNaming;
            defaultAccessorNamingStrategy = new DefaultAccessorNamingStrategy(this, annotatedClassB, bVar._setterPrefix, bVar._getterPrefix, bVar._isGetterPrefix, bVar._baseNameValidator);
        }
        return new BasicBeanDescription(new POJOPropertiesCollector(this, true, javaType, annotatedClassB, defaultAccessorNamingStrategy));
    }

    public final boolean v(SerializationFeature serializationFeature) {
        return (serializationFeature.g() & this._serFeatures) != 0;
    }

    public SerializationConfig(SerializationConfig serializationConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        super(serializationConfig, i);
        this._serFeatures = i2;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = i3;
        this._generatorFeaturesToChange = i4;
        this._formatWriteFeatures = i5;
        this._formatWriteFeaturesToChange = i6;
    }
}
