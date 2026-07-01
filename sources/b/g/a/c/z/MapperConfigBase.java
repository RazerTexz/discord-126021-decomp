package b.g.a.c.z;

import b.g.a.a.JsonAutoDetect;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonIgnoreProperties;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonSetter;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyName;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.SimpleMixInResolver;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.e0.SubtypeResolver;
import b.g.a.c.i0.RootNameLookup;
import b.g.a.c.z.ConfigFeature;
import b.g.a.c.z.ConfigOverride;
import b.g.a.c.z.ContextAttributes;
import b.g.a.c.z.MapperConfigBase;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.z.m, reason: use source file name */
/* JADX INFO: compiled from: MapperConfigBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {
    public static final int j = MapperConfig.c(MapperFeature.class);
    public static final int k = (((MapperFeature.AUTO_DETECT_FIELDS.g() | MapperFeature.AUTO_DETECT_GETTERS.g()) | MapperFeature.AUTO_DETECT_IS_GETTERS.g()) | MapperFeature.AUTO_DETECT_SETTERS.g()) | MapperFeature.AUTO_DETECT_CREATORS.g();
    public final ContextAttributes _attributes;
    public final ConfigOverrides _configOverrides;
    public final SimpleMixInResolver _mixIns;
    public final PropertyName _rootName;
    public final RootNameLookup _rootNames;
    public final SubtypeResolver _subtypeResolver;
    public final Class<?> _view;

    public MapperConfigBase(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, j);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = subtypeResolver;
        this._rootNames = rootNameLookup;
        this._rootName = null;
        this._view = null;
        this._attributes = ContextAttributes.a.j;
        this._configOverrides = configOverrides;
    }

    @Override // b.g.a.c.c0.ClassIntrospector.a
    public final Class<?> a(Class<?> cls) {
        return this._mixIns.a(cls);
    }

    @Override // b.g.a.c.z.MapperConfig
    public final ConfigOverride f(Class<?> cls) {
        ConfigOverride configOverrideA = this._configOverrides.a(cls);
        return configOverrideA == null ? ConfigOverride.a.a : configOverrideA;
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonInclude.b g(Class<?> cls, Class<?> cls2) {
        this._configOverrides.a(cls2);
        JsonInclude.b bVarJ = j(cls);
        if (bVarJ == null) {
            return null;
        }
        return bVarJ.a(null);
    }

    @Override // b.g.a.c.z.MapperConfig
    public Boolean h() {
        return this._configOverrides._defaultMergeable;
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonFormat.d i(Class<?> cls) {
        ConfigOverrides configOverrides = this._configOverrides;
        Map<Class<?>, ?> map = configOverrides._overrides;
        if (map != null) {
        }
        Boolean bool = configOverrides._defaultLeniency;
        if (bool == null) {
            return JsonFormat.d.j;
        }
        return new JsonFormat.d("", null, null, null, null, JsonFormat.b.a, Boolean.valueOf(bool.booleanValue()));
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonInclude.b j(Class<?> cls) {
        this._configOverrides.a(cls);
        JsonInclude.b bVar = this._configOverrides._defaultInclusion;
        if (bVar == null) {
            return null;
        }
        return bVar.a(null);
    }

    @Override // b.g.a.c.z.MapperConfig
    public final JsonSetter.a l() {
        return this._configOverrides._defaultSetterInfo;
    }

    @Override // b.g.a.c.z.MapperConfig
    public final VisibilityChecker<?> m(Class<?> cls, AnnotatedClass annotatedClass) {
        VisibilityChecker<?> aVar;
        VisibilityChecker.a aVar2;
        VisibilityChecker.a aVar3;
        VisibilityChecker.a aVar4;
        VisibilityChecker.a aVar5;
        VisibilityChecker.a aVar6;
        JsonAutoDetect.a aVar7 = JsonAutoDetect.a.NONE;
        VisibilityChecker<?> visibilityChecker = this._configOverrides._visibilityChecker;
        int i = this._mapperFeatures;
        int i2 = k;
        VisibilityChecker<?> aVar8 = visibilityChecker;
        if ((i & i2) != i2) {
            if (!q(MapperFeature.AUTO_DETECT_FIELDS)) {
                aVar6 = (VisibilityChecker.a) visibilityChecker;
                if (aVar6._fieldMinLevel != aVar7) {
                    aVar = visibilityChecker;
                    aVar = aVar6;
                    aVar = new VisibilityChecker.a(aVar6._getterMinLevel, aVar6._isGetterMinLevel, aVar6._setterMinLevel, aVar6._creatorMinLevel, aVar7);
                }
            }
            aVar = visibilityChecker;
            aVar = aVar6;
            aVar = visibilityChecker;
            VisibilityChecker<?> aVar9 = aVar;
            if (!q(MapperFeature.AUTO_DETECT_GETTERS)) {
                aVar5 = (VisibilityChecker.a) aVar;
                if (aVar5._getterMinLevel != aVar7) {
                    aVar9 = aVar5;
                    aVar9 = new VisibilityChecker.a(aVar7, aVar5._isGetterMinLevel, aVar5._setterMinLevel, aVar5._creatorMinLevel, aVar5._fieldMinLevel);
                }
            }
            aVar9 = aVar5;
            VisibilityChecker<?> aVar10 = aVar9;
            if (!q(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
                aVar4 = (VisibilityChecker.a) aVar9;
                if (aVar4._isGetterMinLevel != aVar7) {
                    aVar10 = aVar4;
                    aVar10 = new VisibilityChecker.a(aVar4._getterMinLevel, aVar7, aVar4._setterMinLevel, aVar4._creatorMinLevel, aVar4._fieldMinLevel);
                }
            }
            aVar10 = aVar4;
            VisibilityChecker<?> aVar11 = aVar10;
            if (!q(MapperFeature.AUTO_DETECT_SETTERS)) {
                aVar3 = (VisibilityChecker.a) aVar10;
                if (aVar3._setterMinLevel != aVar7) {
                    aVar11 = aVar3;
                    aVar11 = new VisibilityChecker.a(aVar3._getterMinLevel, aVar3._isGetterMinLevel, aVar7, aVar3._creatorMinLevel, aVar3._fieldMinLevel);
                }
            }
            aVar11 = aVar3;
            aVar8 = aVar11;
            if (!q(MapperFeature.AUTO_DETECT_CREATORS)) {
                aVar2 = (VisibilityChecker.a) aVar11;
                if (aVar2._creatorMinLevel != aVar7) {
                    aVar8 = aVar2;
                    aVar8 = new VisibilityChecker.a(aVar2._getterMinLevel, aVar2._isGetterMinLevel, aVar2._setterMinLevel, aVar7, aVar2._fieldMinLevel);
                }
            }
        }
        aVar8 = aVar2;
        AnnotationIntrospector annotationIntrospectorE = e();
        VisibilityChecker<?> visibilityCheckerB = aVar8;
        if (annotationIntrospectorE != null) {
            visibilityCheckerB = annotationIntrospectorE.b(annotatedClass, aVar8);
        }
        if (this._configOverrides.a(cls) == null) {
            return visibilityCheckerB;
        }
        VisibilityChecker.a aVar12 = (VisibilityChecker.a) visibilityCheckerB;
        Objects.requireNonNull(aVar12);
        return aVar12;
    }

    public abstract T r(int i);

    public final JsonIgnoreProperties.a s(Class<?> cls, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospectorE = e();
        JsonIgnoreProperties.a aVarX = annotationIntrospectorE == null ? null : annotationIntrospectorE.x(this, annotatedClass);
        this._configOverrides.a(cls);
        JsonIgnoreProperties.a aVar = JsonIgnoreProperties.a.j;
        if (aVarX == null) {
            return null;
        }
        return aVarX;
    }

    public final T t(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mapperFeature : mapperFeatureArr) {
            i &= ~mapperFeature.g();
        }
        return i == this._mapperFeatures ? this : (T) r(i);
    }

    public MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, int i) {
        super(mapperConfigBase, i);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
    }
}
