package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.b, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement2 implements Annotations4 {
    public final FqName j;

    public typeEnhancement2(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqNameToMatch");
        this.j = fqName;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return Collections2.emptyList().iterator();
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public typeEnhancement findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (Intrinsics3.areEqual(fqName, this.j)) {
            return typeEnhancement.a;
        }
        return null;
    }
}
