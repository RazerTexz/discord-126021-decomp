package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotationDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    public final KotlinType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Name, d0.e0.p.d.m0.k.v.g<?>> f3248b;
    public final SourceElement c;

    public AnnotationDescriptorImpl(KotlinType kotlinType, Map<Name, d0.e0.p.d.m0.k.v.g<?>> map, SourceElement sourceElement) {
        if (kotlinType == null) {
            a(0);
            throw null;
        }
        if (map == null) {
            a(1);
            throw null;
        }
        if (sourceElement == null) {
            a(2);
            throw null;
        }
        this.a = kotlinType;
        this.f3248b = map;
        this.c = sourceElement;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        Map<Name, d0.e0.p.d.m0.k.v.g<?>> map = this.f3248b;
        if (map != null) {
            return map;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public FqName getFqName() {
        return AnnotationDescriptor.a.getFqName(this);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement sourceElement = this.c;
        if (sourceElement != null) {
            return sourceElement;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public KotlinType getType() {
        KotlinType kotlinType = this.a;
        if (kotlinType != null) {
            return kotlinType;
        }
        a(3);
        throw null;
    }

    public String toString() {
        return DescriptorRenderer2.f3439b.renderAnnotation(this, null);
    }
}
