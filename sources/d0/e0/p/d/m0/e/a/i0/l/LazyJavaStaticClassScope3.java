package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.p.DFS;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.p, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaStaticClassScope3 implements DFS.c<ClassDescriptor> {
    public static final LazyJavaStaticClassScope3 a = new LazyJavaStaticClassScope3();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.p$a */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class a extends Lambda implements Function1<KotlinType, ClassDescriptor> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClassDescriptor invoke(KotlinType kotlinType) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                return (ClassDescriptor) declarationDescriptor;
            }
            return null;
        }
    }

    @Override // d0.e0.p.d.m0.p.DFS.c
    public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        return _Sequences2.asIterable(_Sequences2.mapNotNull(_Collections.asSequence(supertypes), a.j));
    }
}
