package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.a, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement implements AnnotationDescriptor {
    public static final typeEnhancement a = new typeEnhancement();

    public final Void a() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        a();
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public FqName getFqName() {
        return AnnotationDescriptor.a.getFqName(this);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public SourceElement getSource() {
        a();
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public KotlinType getType() {
        a();
        throw null;
    }

    public String toString() {
        return "[EnhancedType]";
    }
}
