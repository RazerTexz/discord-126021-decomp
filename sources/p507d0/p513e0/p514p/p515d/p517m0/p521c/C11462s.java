package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.s */
/* JADX INFO: compiled from: descriptorUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11462s {
    public static final InterfaceC11330e resolveClassByFqName(InterfaceC11325c0 interfaceC11325c0, C11713b c11713b, InterfaceC11480b interfaceC11480b) {
        InterfaceC11770i unsubstitutedInnerClassesScope;
        InterfaceC11352h contributedClassifier;
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(interfaceC11480b, "lookupLocation");
        if (c11713b.isRoot()) {
            return null;
        }
        C11713b c11713bParent = c11713b.parent();
        C12238m.checkNotNullExpressionValue(c11713bParent, "fqName.parent()");
        InterfaceC11770i memberScope = interfaceC11325c0.getPackage(c11713bParent).getMemberScope();
        C11716e c11716eShortName = c11713b.shortName();
        C12238m.checkNotNullExpressionValue(c11716eShortName, "fqName.shortName()");
        InterfaceC11352h contributedClassifier2 = memberScope.getContributedClassifier(c11716eShortName, interfaceC11480b);
        InterfaceC11330e interfaceC11330e = contributedClassifier2 instanceof InterfaceC11330e ? (InterfaceC11330e) contributedClassifier2 : null;
        if (interfaceC11330e != null) {
            return interfaceC11330e;
        }
        C11713b c11713bParent2 = c11713b.parent();
        C12238m.checkNotNullExpressionValue(c11713bParent2, "fqName.parent()");
        InterfaceC11330e interfaceC11330eResolveClassByFqName = resolveClassByFqName(interfaceC11325c0, c11713bParent2, interfaceC11480b);
        if (interfaceC11330eResolveClassByFqName == null || (unsubstitutedInnerClassesScope = interfaceC11330eResolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) {
            contributedClassifier = null;
        } else {
            C11716e c11716eShortName2 = c11713b.shortName();
            C12238m.checkNotNullExpressionValue(c11716eShortName2, "fqName.shortName()");
            contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(c11716eShortName2, interfaceC11480b);
        }
        if (contributedClassifier instanceof InterfaceC11330e) {
            return (InterfaceC11330e) contributedClassifier;
        }
        return null;
    }
}
