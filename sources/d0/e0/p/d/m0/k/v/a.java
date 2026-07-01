package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends g<AnnotationDescriptor> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AnnotationDescriptor annotationDescriptor) {
        super(annotationDescriptor);
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "value");
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        return getValue().getType();
    }
}
