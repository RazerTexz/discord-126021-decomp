package b.g.a.c;

import b.g.a.a.JsonFormat;
import b.g.a.a.JsonInclude;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.d, reason: use source file name */
/* JADX INFO: compiled from: BeanProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public interface BeanProperty {
    public static final JsonFormat.d c = new JsonFormat.d("", JsonFormat.c.ANY, "", "", JsonFormat.b.a, null);

    /* JADX INFO: renamed from: b.g.a.c.d$a */
    /* JADX INFO: compiled from: BeanProperty.java */
    public static class a implements BeanProperty, Serializable {
        private static final long serialVersionUID = 1;
        public final AnnotatedMember _member;
        public final PropertyMetadata _metadata;
        public final PropertyName _name;
        public final JavaType _type;
        public final PropertyName _wrapperName;

        public a(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, AnnotatedMember annotatedMember, PropertyMetadata propertyMetadata) {
            this._name = propertyName;
            this._type = javaType;
            this._wrapperName = propertyName2;
            this._metadata = propertyMetadata;
            this._member = annotatedMember;
        }

        @Override // b.g.a.c.BeanProperty
        public JsonFormat.d a(MapperConfig<?> mapperConfig, Class<?> cls) {
            AnnotatedMember annotatedMember;
            JsonFormat.d dVarH;
            JsonFormat.d dVarI = mapperConfig.i(cls);
            AnnotationIntrospector annotationIntrospectorE = mapperConfig.e();
            return (annotationIntrospectorE == null || (annotatedMember = this._member) == null || (dVarH = annotationIntrospectorE.h(annotatedMember)) == null) ? dVarI : dVarI.k(dVarH);
        }

        @Override // b.g.a.c.BeanProperty
        public JsonInclude.b b(MapperConfig<?> mapperConfig, Class<?> cls) {
            AnnotatedMember annotatedMember;
            JsonInclude.b bVarZ;
            JsonInclude.b bVarG = mapperConfig.g(cls, this._type._class);
            AnnotationIntrospector annotationIntrospectorE = mapperConfig.e();
            return (annotationIntrospectorE == null || (annotatedMember = this._member) == null || (bVarZ = annotationIntrospectorE.z(annotatedMember)) == null) ? bVarG : bVarG.a(bVarZ);
        }

        @Override // b.g.a.c.BeanProperty
        public AnnotatedMember getMember() {
            return this._member;
        }

        @Override // b.g.a.c.BeanProperty
        public JavaType getType() {
            return this._type;
        }
    }

    static {
        JsonInclude.b bVar = JsonInclude.b.j;
        JsonInclude.b bVar2 = JsonInclude.b.j;
    }

    JsonFormat.d a(MapperConfig<?> mapperConfig, Class<?> cls);

    JsonInclude.b b(MapperConfig<?> mapperConfig, Class<?> cls);

    AnnotatedMember getMember();

    JavaType getType();
}
