package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.h, reason: use source file name */
/* JADX INFO: compiled from: AnnotationsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsImpl implements Annotations4 {
    public final List<AnnotationDescriptor> j;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationsImpl(List<? extends AnnotationDescriptor> list) {
        Intrinsics3.checkNotNullParameter(list, "annotations");
        this.j = list;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return Annotations4.b.findAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return this.j.iterator();
    }

    public String toString() {
        return this.j.toString();
    }
}
