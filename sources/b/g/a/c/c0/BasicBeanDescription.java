package b.g.a.c.c0;

import b.g.a.a.JsonFormat;
import b.g.a.a.JsonInclude;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.z.MapperConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.c0.q, reason: use source file name */
/* JADX INFO: compiled from: BasicBeanDescription.java */
/* JADX INFO: loaded from: classes3.dex */
public class BasicBeanDescription extends BeanDescription {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f693b = new Class[0];
    public final POJOPropertiesCollector c;
    public final MapperConfig<?> d;
    public final AnnotationIntrospector e;
    public final AnnotatedClass f;
    public Class<?>[] g;
    public boolean h;
    public List<BeanPropertyDefinition> i;
    public ObjectIdInfo j;

    public BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass, List<BeanPropertyDefinition> list) {
        super(javaType);
        this.c = null;
        this.d = mapperConfig;
        if (mapperConfig == null) {
            this.e = null;
        } else {
            this.e = mapperConfig.e();
        }
        this.f = annotatedClass;
        this.i = list;
    }

    public static BasicBeanDescription e(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        return new BasicBeanDescription(mapperConfig, javaType, annotatedClass, Collections.emptyList());
    }

    @Override // b.g.a.c.BeanDescription
    public JsonFormat.d a(JsonFormat.d dVar) {
        JsonFormat.d dVarH;
        AnnotationIntrospector annotationIntrospector = this.e;
        if (annotationIntrospector == null || (dVarH = annotationIntrospector.h(this.f)) == null) {
            dVarH = null;
        }
        JsonFormat.d dVarI = this.d.i(this.f.l);
        if (dVarI != null) {
            return dVarH == null ? dVarI : dVarH.k(dVarI);
        }
        return dVarH;
    }

    @Override // b.g.a.c.BeanDescription
    public AnnotatedMember b() {
        POJOPropertiesCollector pOJOPropertiesCollector = this.c;
        if (pOJOPropertiesCollector == null) {
            return null;
        }
        if (!pOJOPropertiesCollector.i) {
            pOJOPropertiesCollector.h();
        }
        LinkedList<AnnotatedMember> linkedList = pOJOPropertiesCollector.r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return pOJOPropertiesCollector.r.get(0);
        }
        pOJOPropertiesCollector.i("Multiple 'as-value' properties defined (%s vs %s)", pOJOPropertiesCollector.r.get(0), pOJOPropertiesCollector.r.get(1));
        throw null;
    }

    @Override // b.g.a.c.BeanDescription
    public JsonInclude.b c(JsonInclude.b bVar) {
        JsonInclude.b bVarZ;
        AnnotationIntrospector annotationIntrospector = this.e;
        if (annotationIntrospector == null || (bVarZ = annotationIntrospector.z(this.f)) == null) {
            return bVar;
        }
        return bVar == null ? bVarZ : bVar.a(bVarZ);
    }

    public List<BeanPropertyDefinition> d() {
        if (this.i == null) {
            POJOPropertiesCollector pOJOPropertiesCollector = this.c;
            if (!pOJOPropertiesCollector.i) {
                pOJOPropertiesCollector.h();
            }
            this.i = new ArrayList(pOJOPropertiesCollector.j.values());
        }
        return this.i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector) {
        JavaType javaType = pOJOPropertiesCollector.d;
        AnnotatedClass annotatedClass = pOJOPropertiesCollector.e;
        super(javaType);
        this.c = pOJOPropertiesCollector;
        MapperConfig<?> mapperConfig = pOJOPropertiesCollector.a;
        this.d = mapperConfig;
        if (mapperConfig == null) {
            this.e = null;
        } else {
            this.e = mapperConfig.e();
        }
        this.f = annotatedClass;
        ObjectIdInfo objectIdInfoR = pOJOPropertiesCollector.g.r(pOJOPropertiesCollector.e);
        this.j = objectIdInfoR != null ? pOJOPropertiesCollector.g.s(pOJOPropertiesCollector.e, objectIdInfoR) : objectIdInfoR;
    }
}
