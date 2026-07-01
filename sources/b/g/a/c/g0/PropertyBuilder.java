package b.g.a.c.g0;

import b.d.b.a.outline;
import b.g.a.a.JsonInclude;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.SerializationConfig;
import b.g.a.c.c0.Annotated;
import b.g.a.c.y.JsonSerialize;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: renamed from: b.g.a.c.g0.l, reason: use source file name */
/* JADX INFO: compiled from: PropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyBuilder {
    public final SerializationConfig a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BeanDescription f702b;
    public final AnnotationIntrospector c;
    public Object d;
    public final JsonInclude.b e;
    public final boolean f;

    public PropertyBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        this.a = serializationConfig;
        this.f702b = beanDescription;
        JsonInclude.b bVar = JsonInclude.b.j;
        JsonInclude.b bVarA = JsonInclude.b.j;
        JsonInclude.b bVarC = beanDescription.c(bVarA);
        serializationConfig.k(beanDescription.a._class, bVarA);
        bVarA = bVarC != null ? bVarC.a(bVarA) : bVarA;
        JsonInclude.b bVar2 = serializationConfig._configOverrides._defaultInclusion;
        this.e = bVar2 == null ? bVarA : bVar2.a(bVarA);
        this.f = bVarA._valueInclusion == JsonInclude.a.NON_DEFAULT;
        this.c = serializationConfig.e();
    }

    public JavaType a(Annotated annotated, boolean z2, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeE0 = this.c.e0(this.a, annotated, javaType);
        if (javaTypeE0 != javaType) {
            Class<?> cls = javaTypeE0._class;
            Class<?> cls2 = javaType._class;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                StringBuilder sbU = outline.U("Illegal concrete-type annotation for method '");
                sbU.append(annotated.c());
                sbU.append("': class ");
                sbU.append(cls.getName());
                sbU.append(" not a super-type of (declared) class ");
                sbU.append(cls2.getName());
                throw new IllegalArgumentException(sbU.toString());
            }
            z2 = true;
            javaType = javaTypeE0;
        }
        JsonSerialize.b bVarK = this.c.K(annotated);
        if (bVarK != null && bVarK != JsonSerialize.b.DEFAULT_TYPING) {
            z2 = bVarK == JsonSerialize.b.STATIC;
        }
        if (z2) {
            return javaType.M();
        }
        return null;
    }
}
