package b.g.a.c;

import b.g.a.a.JacksonInject;
import b.g.a.a.JsonCreator;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonIgnoreProperties;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonIncludeProperties;
import b.g.a.a.JsonProperty;
import b.g.a.a.JsonSetter;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.AnnotatedField;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.AnnotatedMethod;
import b.g.a.c.c0.ObjectIdInfo;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.e0.NamedType;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.i0.NameTransformer4;
import b.g.a.c.y.JsonSerialize;
import b.g.a.c.z.MapperConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.b, reason: use source file name */
/* JADX INFO: compiled from: AnnotationIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AnnotationIntrospector implements Serializable {

    /* JADX INFO: renamed from: b.g.a.c.b$a */
    /* JADX INFO: compiled from: AnnotationIntrospector.java */
    public static class a {
        public final int a;

        public a(int i, String str) {
            this.a = i;
        }
    }

    public JsonIncludeProperties.a A(MapperConfig<?> mapperConfig, Annotated annotated) {
        return JsonIncludeProperties.a.j;
    }

    public Integer B(Annotated annotated) {
        return null;
    }

    public TypeResolverBuilder<?> C(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public a D(AnnotatedMember annotatedMember) {
        return null;
    }

    public PropertyName E(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        return null;
    }

    public PropertyName F(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object G(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object H(Annotated annotated) {
        return null;
    }

    public String[] I(AnnotatedClass annotatedClass) {
        return null;
    }

    public Boolean J(Annotated annotated) {
        return null;
    }

    public JsonSerialize.b K(Annotated annotated) {
        return null;
    }

    public Object L(Annotated annotated) {
        return null;
    }

    public JsonSetter.a M(Annotated annotated) {
        return JsonSetter.a.j;
    }

    public List<NamedType> N(Annotated annotated) {
        return null;
    }

    public String O(AnnotatedClass annotatedClass) {
        return null;
    }

    public TypeResolverBuilder<?> P(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    public NameTransformer4 Q(AnnotatedMember annotatedMember) {
        return null;
    }

    public Class<?>[] R(Annotated annotated) {
        return null;
    }

    public Boolean S(Annotated annotated) {
        if ((annotated instanceof AnnotatedMethod) && T((AnnotatedMethod) annotated)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Deprecated
    public boolean T(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public Boolean U(Annotated annotated) {
        return null;
    }

    public Boolean V(MapperConfig<?> mapperConfig, Annotated annotated) {
        return null;
    }

    public Boolean W(Annotated annotated) {
        if ((annotated instanceof AnnotatedMethod) && X((AnnotatedMethod) annotated)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Deprecated
    public boolean X(AnnotatedMethod annotatedMethod) {
        return false;
    }

    @Deprecated
    public boolean Y(Annotated annotated) {
        return false;
    }

    public boolean Z(AnnotatedMember annotatedMember) {
        return false;
    }

    public void a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<BeanPropertyWriter> list) {
    }

    public Boolean a0(AnnotatedMember annotatedMember) {
        return null;
    }

    public VisibilityChecker<?> b(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public boolean b0(Annotation annotation) {
        return false;
    }

    public Object c(Annotated annotated) {
        return null;
    }

    public Boolean c0(AnnotatedClass annotatedClass) {
        return null;
    }

    public JsonCreator.a d(MapperConfig<?> mapperConfig, Annotated annotated) {
        if (!Y(annotated)) {
            return null;
        }
        JsonCreator.a aVarE = e(annotated);
        return aVarE == null ? JsonCreator.a.DEFAULT : aVarE;
    }

    public Boolean d0(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public JsonCreator.a e(Annotated annotated) {
        return null;
    }

    public JavaType e0(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        return javaType;
    }

    public String[] f(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        return strArr;
    }

    public AnnotatedMethod f0(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        return null;
    }

    public Object g(Annotated annotated) {
        return null;
    }

    public JsonFormat.d h(Annotated annotated) {
        return JsonFormat.d.j;
    }

    public String i(AnnotatedMember annotatedMember) {
        return null;
    }

    public JacksonInject.a j(AnnotatedMember annotatedMember) {
        Object objK = k(annotatedMember);
        if (objK != null) {
            return JacksonInject.a.a(objK, null);
        }
        return null;
    }

    @Deprecated
    public Object k(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object l(Annotated annotated) {
        return null;
    }

    public Boolean m(Annotated annotated) {
        return null;
    }

    public PropertyName n(Annotated annotated) {
        return null;
    }

    public PropertyName o(Annotated annotated) {
        return null;
    }

    public Object p(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object q(Annotated annotated) {
        return null;
    }

    public ObjectIdInfo r(Annotated annotated) {
        return null;
    }

    public ObjectIdInfo s(Annotated annotated, ObjectIdInfo objectIdInfo) {
        return objectIdInfo;
    }

    public JsonProperty.a t(Annotated annotated) {
        return null;
    }

    public TypeResolverBuilder<?> u(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public String v(Annotated annotated) {
        return null;
    }

    public String w(Annotated annotated) {
        return null;
    }

    public JsonIgnoreProperties.a x(MapperConfig<?> mapperConfig, Annotated annotated) {
        return y(annotated);
    }

    @Deprecated
    public JsonIgnoreProperties.a y(Annotated annotated) {
        return JsonIgnoreProperties.a.j;
    }

    public JsonInclude.b z(Annotated annotated) {
        JsonInclude.b bVar = JsonInclude.b.j;
        return JsonInclude.b.j;
    }
}
