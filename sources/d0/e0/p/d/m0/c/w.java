package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;

/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final e findClassAcrossModuleDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        h hVarFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(c0Var, aVar);
        if (hVarFindClassifierAcrossModuleDependencies instanceof e) {
            return (e) hVarFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final h findClassifierAcrossModuleDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar) {
        h contributedClassifier;
        d0.e0.p.d.m0.d.b.d dVar = d0.e0.p.d.m0.d.b.d.FROM_DESERIALIZATION;
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        c0 resolutionAnchorIfAny = d0.e0.p.d.m0.k.r.getResolutionAnchorIfAny(c0Var);
        if (resolutionAnchorIfAny == null) {
            d0.e0.p.d.m0.g.b packageFqName = aVar.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            j0 j0Var = c0Var.getPackage(packageFqName);
            List<d0.e0.p.d.m0.g.e> listPathSegments = aVar.getRelativeClassName().pathSegments();
            d0.z.d.m.checkNotNullExpressionValue(listPathSegments, "classId.relativeClassName.pathSegments()");
            d0.e0.p.d.m0.k.a0.i memberScope = j0Var.getMemberScope();
            Object objFirst = d0.t.u.first((List<? extends Object>) listPathSegments);
            d0.z.d.m.checkNotNullExpressionValue(objFirst, "segments.first()");
            contributedClassifier = memberScope.getContributedClassifier((d0.e0.p.d.m0.g.e) objFirst, dVar);
            if (contributedClassifier == null) {
                return null;
            }
            for (d0.e0.p.d.m0.g.e eVar : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(contributedClassifier instanceof e)) {
                    return null;
                }
                d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope = ((e) contributedClassifier).getUnsubstitutedInnerClassesScope();
                d0.z.d.m.checkNotNullExpressionValue(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                h contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(eVar, dVar);
                contributedClassifier = contributedClassifier2 instanceof e ? (e) contributedClassifier2 : null;
                if (contributedClassifier == null) {
                    return null;
                }
            }
        } else {
            d0.e0.p.d.m0.g.b packageFqName2 = aVar.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            j0 j0Var2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<d0.e0.p.d.m0.g.e> listPathSegments2 = aVar.getRelativeClassName().pathSegments();
            d0.z.d.m.checkNotNullExpressionValue(listPathSegments2, "classId.relativeClassName.pathSegments()");
            d0.e0.p.d.m0.k.a0.i memberScope2 = j0Var2.getMemberScope();
            Object objFirst2 = d0.t.u.first((List<? extends Object>) listPathSegments2);
            d0.z.d.m.checkNotNullExpressionValue(objFirst2, "segments.first()");
            h contributedClassifier3 = memberScope2.getContributedClassifier((d0.e0.p.d.m0.g.e) objFirst2, dVar);
            if (contributedClassifier3 == null) {
                contributedClassifier3 = null;
                break;
            }
            for (d0.e0.p.d.m0.g.e eVar2 : listPathSegments2.subList(1, listPathSegments2.size())) {
                if (contributedClassifier3 instanceof e) {
                    d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope2 = ((e) contributedClassifier3).getUnsubstitutedInnerClassesScope();
                    d0.z.d.m.checkNotNullExpressionValue(eVar2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    h contributedClassifier4 = unsubstitutedInnerClassesScope2.getContributedClassifier(eVar2, dVar);
                    contributedClassifier3 = contributedClassifier4 instanceof e ? (e) contributedClassifier4 : null;
                    if (contributedClassifier3 == null) {
                    }
                }
                contributedClassifier3 = null;
            }
            if (contributedClassifier3 != null) {
                return contributedClassifier3;
            }
            d0.e0.p.d.m0.g.b packageFqName3 = aVar.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
            j0 j0Var3 = c0Var.getPackage(packageFqName3);
            List<d0.e0.p.d.m0.g.e> listPathSegments3 = aVar.getRelativeClassName().pathSegments();
            d0.z.d.m.checkNotNullExpressionValue(listPathSegments3, "classId.relativeClassName.pathSegments()");
            d0.e0.p.d.m0.k.a0.i memberScope3 = j0Var3.getMemberScope();
            Object objFirst3 = d0.t.u.first((List<? extends Object>) listPathSegments3);
            d0.z.d.m.checkNotNullExpressionValue(objFirst3, "segments.first()");
            contributedClassifier = memberScope3.getContributedClassifier((d0.e0.p.d.m0.g.e) objFirst3, dVar);
            if (contributedClassifier == null) {
                return null;
            }
            for (d0.e0.p.d.m0.g.e eVar3 : listPathSegments3.subList(1, listPathSegments3.size())) {
                if (!(contributedClassifier instanceof e)) {
                    return null;
                }
                d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope3 = ((e) contributedClassifier).getUnsubstitutedInnerClassesScope();
                d0.z.d.m.checkNotNullExpressionValue(eVar3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                h contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(eVar3, dVar);
                contributedClassifier = contributedClassifier5 instanceof e ? (e) contributedClassifier5 : null;
                if (contributedClassifier == null) {
                    return null;
                }
            }
        }
        return contributedClassifier;
    }

    public static final e findNonGenericClassAcrossDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar, d0 d0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        e eVarFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(c0Var, aVar);
        return eVarFindClassAcrossModuleDependencies != null ? eVarFindClassAcrossModuleDependencies : d0Var.getClass(aVar, d0.f0.q.toList(d0.f0.q.map(d0.f0.n.generateSequence(aVar, w$a.j), w$b.j)));
    }

    public static final y0 findTypeAliasAcrossModuleDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        h hVarFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(c0Var, aVar);
        if (hVarFindClassifierAcrossModuleDependencies instanceof y0) {
            return (y0) hVarFindClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
