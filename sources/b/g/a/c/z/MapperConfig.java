package b.g.a.c.z;

import b.g.a.a.JsonFormat;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonSetter;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.MapperFeature;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.c0.BasicClassIntrospector;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.c0.NopAnnotationIntrospector;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.z.l, reason: use source file name */
/* JADX INFO: compiled from: MapperConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MapperConfig<T extends MapperConfig<T>> implements ClassIntrospector.a, Serializable {
    private static final long serialVersionUID = 2;
    public final BaseSettings _base;
    public final int _mapperFeatures;

    static {
        JsonInclude.b bVar = JsonInclude.b.j;
        JsonInclude.b bVar2 = JsonInclude.b.j;
        JsonFormat.d dVar = JsonFormat.d.j;
    }

    public MapperConfig(BaseSettings baseSettings, int i) {
        this._base = baseSettings;
        this._mapperFeatures = i;
    }

    public static <F extends Enum<F> & ConfigFeature> int c(Class<F> cls) {
        int iG = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            ConfigFeature configFeature = (ConfigFeature) obj;
            if (configFeature.f()) {
                iG |= configFeature.g();
            }
        }
        return iG;
    }

    public final boolean b() {
        return q(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public final JavaType d(Class<?> cls) {
        return this._base._typeFactory.b(null, cls, TypeFactory.l);
    }

    public AnnotationIntrospector e() {
        return q(MapperFeature.USE_ANNOTATIONS) ? this._base._annotationIntrospector : NopAnnotationIntrospector.j;
    }

    public abstract ConfigOverride f(Class<?> cls);

    public abstract JsonInclude.b g(Class<?> cls, Class<?> cls2);

    public abstract Boolean h();

    public abstract JsonFormat.d i(Class<?> cls);

    public abstract JsonInclude.b j(Class<?> cls);

    public JsonInclude.b k(Class<?> cls, JsonInclude.b bVar) {
        Objects.requireNonNull(f(cls));
        return bVar;
    }

    public abstract JsonSetter.a l();

    public abstract VisibilityChecker<?> m(Class<?> cls, AnnotatedClass annotatedClass);

    public BeanDescription n(JavaType javaType) {
        BasicClassIntrospector basicClassIntrospector = (BasicClassIntrospector) this._base._classIntrospector;
        BasicBeanDescription basicBeanDescriptionA = basicClassIntrospector.a(this, javaType);
        return basicBeanDescriptionA == null ? BasicBeanDescription.e(this, javaType, basicClassIntrospector.b(this, javaType, this)) : basicBeanDescriptionA;
    }

    public BeanDescription o(Class<?> cls) {
        return n(this._base._typeFactory.b(null, cls, TypeFactory.l));
    }

    public final boolean p() {
        return q(MapperFeature.USE_ANNOTATIONS);
    }

    public final boolean q(MapperFeature mapperFeature) {
        return mapperFeature.h(this._mapperFeatures);
    }

    public MapperConfig(MapperConfig<T> mapperConfig, int i) {
        this._base = mapperConfig._base;
        this._mapperFeatures = i;
    }
}
