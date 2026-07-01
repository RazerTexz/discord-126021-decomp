package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: descriptorUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static final e resolveClassByFqName(c0 c0Var, d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.d.b.b bVar2) {
        d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope;
        h contributedClassifier;
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(bVar2, "lookupLocation");
        if (bVar.isRoot()) {
            return null;
        }
        d0.e0.p.d.m0.g.b bVarParent = bVar.parent();
        d0.z.d.m.checkNotNullExpressionValue(bVarParent, "fqName.parent()");
        d0.e0.p.d.m0.k.a0.i memberScope = c0Var.getPackage(bVarParent).getMemberScope();
        d0.e0.p.d.m0.g.e eVarShortName = bVar.shortName();
        d0.z.d.m.checkNotNullExpressionValue(eVarShortName, "fqName.shortName()");
        h contributedClassifier2 = memberScope.getContributedClassifier(eVarShortName, bVar2);
        e eVar = contributedClassifier2 instanceof e ? (e) contributedClassifier2 : null;
        if (eVar != null) {
            return eVar;
        }
        d0.e0.p.d.m0.g.b bVarParent2 = bVar.parent();
        d0.z.d.m.checkNotNullExpressionValue(bVarParent2, "fqName.parent()");
        e eVarResolveClassByFqName = resolveClassByFqName(c0Var, bVarParent2, bVar2);
        if (eVarResolveClassByFqName == null || (unsubstitutedInnerClassesScope = eVarResolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) {
            contributedClassifier = null;
        } else {
            d0.e0.p.d.m0.g.e eVarShortName2 = bVar.shortName();
            d0.z.d.m.checkNotNullExpressionValue(eVarShortName2, "fqName.shortName()");
            contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(eVarShortName2, bVar2);
        }
        if (contributedClassifier instanceof e) {
            return (e) contributedClassifier;
        }
        return null;
    }
}
