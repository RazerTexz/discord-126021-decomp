package b.g.a.c.i0;

import b.g.a.a.JsonInclude;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;
import b.g.a.c.c0.AnnotatedField;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.AnnotatedMethod;
import b.g.a.c.c0.AnnotatedParameter;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.z.MapperConfig;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.i0.q, reason: use source file name */
/* JADX INFO: compiled from: SimpleBeanPropertyDefinition.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleBeanPropertyDefinition extends BeanPropertyDefinition {
    public final AnnotationIntrospector k;
    public final AnnotatedMember l;
    public final PropertyMetadata m;
    public final PropertyName n;
    public final JsonInclude.b o;

    public SimpleBeanPropertyDefinition(AnnotationIntrospector annotationIntrospector, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.b bVar) {
        this.k = annotationIntrospector;
        this.l = annotatedMember;
        this.n = propertyName;
        this.m = propertyMetadata == null ? PropertyMetadata.k : propertyMetadata;
        this.o = bVar;
    }

    public static SimpleBeanPropertyDefinition w(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.a aVar) {
        JsonInclude.b bVar;
        JsonInclude.a aVar2;
        if (aVar == null || aVar == (aVar2 = JsonInclude.a.USE_DEFAULTS)) {
            bVar = BeanPropertyDefinition.j;
        } else {
            bVar = aVar != aVar2 ? new JsonInclude.b(aVar, null, null, null) : JsonInclude.b.j;
        }
        return new SimpleBeanPropertyDefinition(mapperConfig.e(), annotatedMember, propertyName, propertyMetadata, bVar);
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public JsonInclude.b g() {
        return this.o;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedParameter k() {
        AnnotatedMember annotatedMember = this.l;
        if (annotatedMember instanceof AnnotatedParameter) {
            return (AnnotatedParameter) annotatedMember;
        }
        return null;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedField l() {
        AnnotatedMember annotatedMember = this.l;
        if (annotatedMember instanceof AnnotatedField) {
            return (AnnotatedField) annotatedMember;
        }
        return null;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public PropertyName m() {
        return this.n;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedMethod n() {
        AnnotatedMember annotatedMember = this.l;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).o() == 0) {
            return (AnnotatedMethod) this.l;
        }
        return null;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public PropertyMetadata o() {
        return this.m;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public String p() {
        return this.n._simpleName;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedMember q() {
        return this.l;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public Class<?> r() {
        AnnotatedMember annotatedMember = this.l;
        return annotatedMember == null ? Object.class : annotatedMember.d();
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedMethod s() {
        AnnotatedMember annotatedMember = this.l;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).o() == 1) {
            return (AnnotatedMethod) this.l;
        }
        return null;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public PropertyName t() {
        AnnotationIntrospector annotationIntrospector = this.k;
        if (annotationIntrospector != null && this.l != null) {
            Objects.requireNonNull(annotationIntrospector);
        }
        return null;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public boolean u() {
        return false;
    }
}
