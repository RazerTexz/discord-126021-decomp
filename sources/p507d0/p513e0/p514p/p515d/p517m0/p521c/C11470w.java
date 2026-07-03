package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11482d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11800r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.w */
/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11470w {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.w$a */
    /* JADX INFO: compiled from: findClassInModule.kt */
    public /* synthetic */ class a extends C12235j implements Function1<C11712a, C11712a> {

        /* JADX INFO: renamed from: j */
        public static final a f23101j = new a();

        public a() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11712a.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11712a invoke(C11712a c11712a) {
            C12238m.checkNotNullParameter(c11712a, "p0");
            return c11712a.getOuterClassId();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.w$b */
    /* JADX INFO: compiled from: findClassInModule.kt */
    public static final class b extends AbstractC12240o implements Function1<C11712a, Integer> {

        /* JADX INFO: renamed from: j */
        public static final b f23102j = new b();

        public b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(C11712a c11712a) {
            C12238m.checkNotNullParameter(c11712a, "it");
            return 0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(C11712a c11712a) {
            return Integer.valueOf(invoke2(c11712a));
        }
    }

    public static final InterfaceC11330e findClassAcrossModuleDependencies(InterfaceC11325c0 interfaceC11325c0, C11712a c11712a) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C12238m.checkNotNullParameter(c11712a, "classId");
        InterfaceC11352h interfaceC11352hFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(interfaceC11325c0, c11712a);
        if (interfaceC11352hFindClassifierAcrossModuleDependencies instanceof InterfaceC11330e) {
            return (InterfaceC11330e) interfaceC11352hFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final InterfaceC11352h findClassifierAcrossModuleDependencies(InterfaceC11325c0 interfaceC11325c0, C11712a c11712a) {
        InterfaceC11352h contributedClassifier;
        EnumC11482d enumC11482d = EnumC11482d.FROM_DESERIALIZATION;
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C12238m.checkNotNullParameter(c11712a, "classId");
        InterfaceC11325c0 resolutionAnchorIfAny = C11800r.getResolutionAnchorIfAny(interfaceC11325c0);
        if (resolutionAnchorIfAny == null) {
            C11713b packageFqName = c11712a.getPackageFqName();
            C12238m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            InterfaceC11402j0 interfaceC11402j0 = interfaceC11325c0.getPackage(packageFqName);
            List<C11716e> listPathSegments = c11712a.getRelativeClassName().pathSegments();
            C12238m.checkNotNullExpressionValue(listPathSegments, "classId.relativeClassName.pathSegments()");
            InterfaceC11770i memberScope = interfaceC11402j0.getMemberScope();
            Object objFirst = C12163u.first((List<? extends Object>) listPathSegments);
            C12238m.checkNotNullExpressionValue(objFirst, "segments.first()");
            contributedClassifier = memberScope.getContributedClassifier((C11716e) objFirst, enumC11482d);
            if (contributedClassifier == null) {
                return null;
            }
            for (C11716e c11716e : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(contributedClassifier instanceof InterfaceC11330e)) {
                    return null;
                }
                InterfaceC11770i unsubstitutedInnerClassesScope = ((InterfaceC11330e) contributedClassifier).getUnsubstitutedInnerClassesScope();
                C12238m.checkNotNullExpressionValue(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
                InterfaceC11352h contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(c11716e, enumC11482d);
                contributedClassifier = contributedClassifier2 instanceof InterfaceC11330e ? (InterfaceC11330e) contributedClassifier2 : null;
                if (contributedClassifier == null) {
                    return null;
                }
            }
        } else {
            C11713b packageFqName2 = c11712a.getPackageFqName();
            C12238m.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            InterfaceC11402j0 interfaceC11402j1 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<C11716e> listPathSegments2 = c11712a.getRelativeClassName().pathSegments();
            C12238m.checkNotNullExpressionValue(listPathSegments2, "classId.relativeClassName.pathSegments()");
            InterfaceC11770i memberScope2 = interfaceC11402j1.getMemberScope();
            Object objFirst2 = C12163u.first((List<? extends Object>) listPathSegments2);
            C12238m.checkNotNullExpressionValue(objFirst2, "segments.first()");
            InterfaceC11352h contributedClassifier3 = memberScope2.getContributedClassifier((C11716e) objFirst2, enumC11482d);
            if (contributedClassifier3 == null) {
                contributedClassifier3 = null;
                break;
            }
            for (C11716e c11716e2 : listPathSegments2.subList(1, listPathSegments2.size())) {
                if (contributedClassifier3 instanceof InterfaceC11330e) {
                    InterfaceC11770i unsubstitutedInnerClassesScope2 = ((InterfaceC11330e) contributedClassifier3).getUnsubstitutedInnerClassesScope();
                    C12238m.checkNotNullExpressionValue(c11716e2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    InterfaceC11352h contributedClassifier4 = unsubstitutedInnerClassesScope2.getContributedClassifier(c11716e2, enumC11482d);
                    contributedClassifier3 = contributedClassifier4 instanceof InterfaceC11330e ? (InterfaceC11330e) contributedClassifier4 : null;
                    if (contributedClassifier3 == null) {
                    }
                }
                contributedClassifier3 = null;
            }
            if (contributedClassifier3 != null) {
                return contributedClassifier3;
            }
            C11713b packageFqName3 = c11712a.getPackageFqName();
            C12238m.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
            InterfaceC11402j0 interfaceC11402j2 = interfaceC11325c0.getPackage(packageFqName3);
            List<C11716e> listPathSegments3 = c11712a.getRelativeClassName().pathSegments();
            C12238m.checkNotNullExpressionValue(listPathSegments3, "classId.relativeClassName.pathSegments()");
            InterfaceC11770i memberScope3 = interfaceC11402j2.getMemberScope();
            Object objFirst3 = C12163u.first((List<? extends Object>) listPathSegments3);
            C12238m.checkNotNullExpressionValue(objFirst3, "segments.first()");
            contributedClassifier = memberScope3.getContributedClassifier((C11716e) objFirst3, enumC11482d);
            if (contributedClassifier == null) {
                return null;
            }
            for (C11716e c11716e3 : listPathSegments3.subList(1, listPathSegments3.size())) {
                if (!(contributedClassifier instanceof InterfaceC11330e)) {
                    return null;
                }
                InterfaceC11770i unsubstitutedInnerClassesScope3 = ((InterfaceC11330e) contributedClassifier).getUnsubstitutedInnerClassesScope();
                C12238m.checkNotNullExpressionValue(c11716e3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                InterfaceC11352h contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(c11716e3, enumC11482d);
                contributedClassifier = contributedClassifier5 instanceof InterfaceC11330e ? (InterfaceC11330e) contributedClassifier5 : null;
                if (contributedClassifier == null) {
                    return null;
                }
            }
        }
        return contributedClassifier;
    }

    public static final InterfaceC11330e findNonGenericClassAcrossDependencies(InterfaceC11325c0 interfaceC11325c0, C11712a c11712a, C11328d0 c11328d0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C12238m.checkNotNullParameter(c11712a, "classId");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(interfaceC11325c0, c11712a);
        return interfaceC11330eFindClassAcrossModuleDependencies != null ? interfaceC11330eFindClassAcrossModuleDependencies : c11328d0.getClass(c11712a, C12078q.toList(C12078q.map(C12075n.generateSequence(c11712a, a.f23101j), b.f23102j)));
    }

    public static final InterfaceC11475y0 findTypeAliasAcrossModuleDependencies(InterfaceC11325c0 interfaceC11325c0, C11712a c11712a) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C12238m.checkNotNullParameter(c11712a, "classId");
        InterfaceC11352h interfaceC11352hFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(interfaceC11325c0, c11712a);
        if (interfaceC11352hFindClassifierAcrossModuleDependencies instanceof InterfaceC11475y0) {
            return (InterfaceC11475y0) interfaceC11352hFindClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
