package b.g.a.c.c0;

import b.g.a.a.JsonFormat;
import b.g.a.a.JsonInclude;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.c0.v, reason: use source file name */
/* JADX INFO: compiled from: ConcreteBeanPropertyBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ConcreteBeanPropertyBase implements BeanProperty, Serializable {
    private static final long serialVersionUID = 1;
    public final PropertyMetadata _metadata;

    public ConcreteBeanPropertyBase(PropertyMetadata propertyMetadata) {
        this._metadata = propertyMetadata == null ? PropertyMetadata.l : propertyMetadata;
    }

    @Override // b.g.a.c.BeanProperty
    public JsonFormat.d a(MapperConfig<?> mapperConfig, Class<?> cls) {
        AnnotatedMember member;
        JsonFormat.d dVarI = mapperConfig.i(cls);
        AnnotationIntrospector annotationIntrospectorE = mapperConfig.e();
        JsonFormat.d dVarH = (annotationIntrospectorE == null || (member = getMember()) == null) ? null : annotationIntrospectorE.h(member);
        if (dVarI == null) {
            return dVarH == null ? BeanProperty.c : dVarH;
        }
        return dVarH == null ? dVarI : dVarI.k(dVarH);
    }

    @Override // b.g.a.c.BeanProperty
    public JsonInclude.b b(MapperConfig<?> mapperConfig, Class<?> cls) {
        AnnotationIntrospector annotationIntrospectorE = mapperConfig.e();
        AnnotatedMember member = getMember();
        if (member == null) {
            return mapperConfig.j(cls);
        }
        JsonInclude.b bVarG = mapperConfig.g(cls, member.d());
        if (annotationIntrospectorE == null) {
            return bVarG;
        }
        JsonInclude.b bVarZ = annotationIntrospectorE.z(member);
        return bVarG == null ? bVarZ : bVarG.a(bVarZ);
    }

    public ConcreteBeanPropertyBase(ConcreteBeanPropertyBase concreteBeanPropertyBase) {
        this._metadata = concreteBeanPropertyBase._metadata;
    }
}
