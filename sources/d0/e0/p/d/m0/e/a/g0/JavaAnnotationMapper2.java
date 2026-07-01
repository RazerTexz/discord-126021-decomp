package d0.e0.p.d.m0.e.a.g0;

import d0.Tuples;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaAnnotationDescriptor;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.c, reason: use source file name */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaAnnotationMapper2 {
    public static final JavaAnnotationMapper2 a = new JavaAnnotationMapper2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Name f3315b;
    public static final Name c;
    public static final Name d;
    public static final Map<FqName, FqName> e;
    public static final Map<FqName, FqName> f;

    static {
        Name nameIdentifier = Name.identifier("message");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"message\")");
        f3315b = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("allowedTargets");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"allowedTargets\")");
        c = nameIdentifier2;
        Name nameIdentifier3 = Name.identifier("value");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier3, "identifier(\"value\")");
        d = nameIdentifier3;
        FqName fqName = StandardNames.a.A;
        FqName fqName2 = JvmAnnotationNames.c;
        FqName fqName3 = StandardNames.a.D;
        FqName fqName4 = JvmAnnotationNames.d;
        FqName fqName5 = StandardNames.a.E;
        FqName fqName6 = JvmAnnotationNames.g;
        FqName fqName7 = StandardNames.a.F;
        FqName fqName8 = JvmAnnotationNames.f;
        e = Maps6.mapOf(Tuples.to(fqName, fqName2), Tuples.to(fqName3, fqName4), Tuples.to(fqName5, fqName6), Tuples.to(fqName7, fqName8));
        f = Maps6.mapOf(Tuples.to(fqName2, fqName), Tuples.to(fqName4, fqName3), Tuples.to(JvmAnnotationNames.e, StandardNames.a.u), Tuples.to(fqName6, fqName5), Tuples.to(fqName8, fqName7));
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper2 javaAnnotationMapper2, d0.e0.p.d.m0.e.a.k0.a aVar, context4 context4Var, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return javaAnnotationMapper2.mapOrResolveJavaAnnotation(aVar, context4Var, z2);
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName fqName, d0.e0.p.d.m0.e.a.k0.d dVar, context4 context4Var) {
        d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation;
        Intrinsics3.checkNotNullParameter(fqName, "kotlinName");
        Intrinsics3.checkNotNullParameter(dVar, "annotationOwner");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        if (Intrinsics3.areEqual(fqName, StandardNames.a.u)) {
            FqName fqName2 = JvmAnnotationNames.e;
            Intrinsics3.checkNotNullExpressionValue(fqName2, "DEPRECATED_ANNOTATION");
            d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation2 = dVar.findAnnotation(fqName2);
            if (aVarFindAnnotation2 != null || dVar.isDeprecatedInJavaDoc()) {
                return new JavaAnnotationMapper4(aVarFindAnnotation2, context4Var);
            }
        }
        FqName fqName3 = e.get(fqName);
        if (fqName3 == null || (aVarFindAnnotation = dVar.findAnnotation(fqName3)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(this, aVarFindAnnotation, context4Var, false, 4, null);
    }

    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return f3315b;
    }

    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return d;
    }

    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return c;
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(d0.e0.p.d.m0.e.a.k0.a aVar, context4 context4Var, boolean z2) {
        Intrinsics3.checkNotNullParameter(aVar, "annotation");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        ClassId classId = aVar.getClassId();
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.c))) {
            return new JavaAnnotationMapper6(aVar, context4Var);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.d))) {
            return new JavaAnnotationMapper5(aVar, context4Var);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.g))) {
            return new JavaAnnotationMapper(context4Var, aVar, StandardNames.a.E);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.f))) {
            return new JavaAnnotationMapper(context4Var, aVar, StandardNames.a.F);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.e))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(context4Var, aVar, z2);
    }
}
