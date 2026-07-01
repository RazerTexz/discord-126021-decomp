package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.l, reason: use source file name */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Annotations7 implements Annotations4 {
    public final Annotations4 j;
    public final boolean k;
    public final Function1<FqName, Boolean> l;

    /* JADX WARN: Multi-variable type inference failed */
    public Annotations7(Annotations4 annotations4, boolean z2, Function1<? super FqName, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(annotations4, "delegate");
        Intrinsics3.checkNotNullParameter(function1, "fqNameFilter");
        this.j = annotations4;
        this.k = z2;
        this.l = function1;
    }

    public final boolean c(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && this.l.invoke(fqName).booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (this.l.invoke(fqName).booleanValue()) {
            return this.j.findAnnotation(fqName);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (this.l.invoke(fqName).booleanValue()) {
            return this.j.hasAnnotation(fqName);
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean isEmpty() {
        boolean z2;
        Annotations4 annotations4 = this.j;
        if (!(annotations4 instanceof Collection) || !((Collection) annotations4).isEmpty()) {
            Iterator<AnnotationDescriptor> it = annotations4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (c(it.next())) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (this.k) {
            return !z2;
        }
        return z2;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations4 annotations4 = this.j;
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations4) {
            if (c(annotationDescriptor)) {
                arrayList.add(annotationDescriptor);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Annotations7(Annotations4 annotations4, Function1<? super FqName, Boolean> function1) {
        this(annotations4, false, function1);
        Intrinsics3.checkNotNullParameter(annotations4, "delegate");
        Intrinsics3.checkNotNullParameter(function1, "fqNameFilter");
    }
}
