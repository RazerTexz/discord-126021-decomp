package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.e.a.g0.JavaAnnotationMapper2;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.m.storage4;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.d, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaAnnotations implements Annotations4 {
    public final context4 j;
    public final d0.e0.p.d.m0.e.a.k0.d k;
    public final boolean l;
    public final storage4<d0.e0.p.d.m0.e.a.k0.a, AnnotationDescriptor> m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.d$a */
    /* JADX INFO: compiled from: LazyJavaAnnotations.kt */
    public static final class a extends Lambda implements Function1<d0.e0.p.d.m0.e.a.k0.a, AnnotationDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AnnotationDescriptor invoke(d0.e0.p.d.m0.e.a.k0.a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "annotation");
            return JavaAnnotationMapper2.a.mapOrResolveJavaAnnotation(aVar, LazyJavaAnnotations.this.j, LazyJavaAnnotations.this.l);
        }
    }

    public LazyJavaAnnotations(context4 context4Var, d0.e0.p.d.m0.e.a.k0.d dVar, boolean z2) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(dVar, "annotationOwner");
        this.j = context4Var;
        this.k = dVar;
        this.l = z2;
        this.m = context4Var.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation = this.k.findAnnotation(fqName);
        AnnotationDescriptor annotationDescriptorInvoke = aVarFindAnnotation == null ? null : this.m.invoke(aVarFindAnnotation);
        return annotationDescriptorInvoke == null ? JavaAnnotationMapper2.a.findMappedJavaAnnotation(fqName, this.k, this.j) : annotationDescriptorInvoke;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean isEmpty() {
        return this.k.getAnnotations().isEmpty() && !this.k.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return _Sequences2.filterNotNull(_Sequences2.plus((Sequence<? extends AnnotationDescriptor>) _Sequences2.map(_Collections.asSequence(this.k.getAnnotations()), this.m), JavaAnnotationMapper2.a.findMappedJavaAnnotation(StandardNames.a.u, this.k, this.j))).iterator();
    }

    public /* synthetic */ LazyJavaAnnotations(context4 context4Var, d0.e0.p.d.m0.e.a.k0.d dVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, dVar, (i & 4) != 0 ? false : z2);
    }
}
