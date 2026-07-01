package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationDescriptor {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.c$a */
    /* JADX INFO: compiled from: AnnotationDescriptor.kt */
    public static final class a {
        public static FqName getFqName(AnnotationDescriptor annotationDescriptor) {
            Intrinsics3.checkNotNullParameter(annotationDescriptor, "this");
            ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
            if (annotationClass == null) {
                return null;
            }
            if (ErrorUtils.isError(annotationClass)) {
                annotationClass = null;
            }
            if (annotationClass == null) {
                return null;
            }
            return DescriptorUtils2.fqNameOrNull(annotationClass);
        }
    }

    Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments();

    FqName getFqName();

    SourceElement getSource();

    KotlinType getType();
}
