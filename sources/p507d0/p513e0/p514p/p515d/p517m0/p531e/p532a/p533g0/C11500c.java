package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Map;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11486a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11538e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.c */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11500c {

    /* JADX INFO: renamed from: a */
    public static final C11500c f23230a = new C11500c();

    /* JADX INFO: renamed from: b */
    public static final C11716e f23231b;

    /* JADX INFO: renamed from: c */
    public static final C11716e f23232c;

    /* JADX INFO: renamed from: d */
    public static final C11716e f23233d;

    /* JADX INFO: renamed from: e */
    public static final Map<C11713b, C11713b> f23234e;

    /* JADX INFO: renamed from: f */
    public static final Map<C11713b, C11713b> f23235f;

    static {
        C11716e c11716eIdentifier = C11716e.identifier("message");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(\"message\")");
        f23231b = c11716eIdentifier;
        C11716e c11716eIdentifier2 = C11716e.identifier("allowedTargets");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier2, "identifier(\"allowedTargets\")");
        f23232c = c11716eIdentifier2;
        C11716e c11716eIdentifier3 = C11716e.identifier("value");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier3, "identifier(\"value\")");
        f23233d = c11716eIdentifier3;
        C11713b c11713b = C11291k.a.f22504A;
        C11713b c11713b2 = C11486a0.f23149c;
        C11713b c11713b3 = C11291k.a.f22507D;
        C11713b c11713b4 = C11486a0.f23150d;
        C11713b c11713b5 = C11291k.a.f22508E;
        C11713b c11713b6 = C11486a0.f23153g;
        C11713b c11713b7 = C11291k.a.f22509F;
        C11713b c11713b8 = C11486a0.f23152f;
        f23234e = C12136h0.mapOf(C12116o.m10073to(c11713b, c11713b2), C12116o.m10073to(c11713b3, c11713b4), C12116o.m10073to(c11713b5, c11713b6), C12116o.m10073to(c11713b7, c11713b8));
        f23235f = C12136h0.mapOf(C12116o.m10073to(c11713b2, c11713b), C12116o.m10073to(c11713b4, c11713b3), C12116o.m10073to(C11486a0.f23151e, C11291k.a.f22566u), C12116o.m10073to(c11713b6, c11713b5), C12116o.m10073to(c11713b8, c11713b7));
    }

    public static /* synthetic */ InterfaceC11340c mapOrResolveJavaAnnotation$default(C11500c c11500c, InterfaceC11564a interfaceC11564a, C11529g c11529g, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return c11500c.mapOrResolveJavaAnnotation(interfaceC11564a, c11529g, z2);
    }

    public final InterfaceC11340c findMappedJavaAnnotation(C11713b c11713b, InterfaceC11570d interfaceC11570d, C11529g c11529g) {
        InterfaceC11564a interfaceC11564aFindAnnotation;
        C12238m.checkNotNullParameter(c11713b, "kotlinName");
        C12238m.checkNotNullParameter(interfaceC11570d, "annotationOwner");
        C12238m.checkNotNullParameter(c11529g, "c");
        if (C12238m.areEqual(c11713b, C11291k.a.f22566u)) {
            C11713b c11713b2 = C11486a0.f23151e;
            C12238m.checkNotNullExpressionValue(c11713b2, "DEPRECATED_ANNOTATION");
            InterfaceC11564a interfaceC11564aFindAnnotation2 = interfaceC11570d.findAnnotation(c11713b2);
            if (interfaceC11564aFindAnnotation2 != null || interfaceC11570d.isDeprecatedInJavaDoc()) {
                return new C11502e(interfaceC11564aFindAnnotation2, c11529g);
            }
        }
        C11713b c11713b3 = f23234e.get(c11713b);
        if (c11713b3 == null || (interfaceC11564aFindAnnotation = interfaceC11570d.findAnnotation(c11713b3)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(this, interfaceC11564aFindAnnotation, c11529g, false, 4, null);
    }

    public final C11716e getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return f23231b;
    }

    public final C11716e getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return f23233d;
    }

    public final C11716e getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return f23232c;
    }

    public final InterfaceC11340c mapOrResolveJavaAnnotation(InterfaceC11564a interfaceC11564a, C11529g c11529g, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11564a, "annotation");
        C12238m.checkNotNullParameter(c11529g, "c");
        C11712a classId = interfaceC11564a.getClassId();
        if (C12238m.areEqual(classId, C11712a.topLevel(C11486a0.f23149c))) {
            return new C11506i(interfaceC11564a, c11529g);
        }
        if (C12238m.areEqual(classId, C11712a.topLevel(C11486a0.f23150d))) {
            return new C11505h(interfaceC11564a, c11529g);
        }
        if (C12238m.areEqual(classId, C11712a.topLevel(C11486a0.f23153g))) {
            return new C11499b(c11529g, interfaceC11564a, C11291k.a.f22508E);
        }
        if (C12238m.areEqual(classId, C11712a.topLevel(C11486a0.f23152f))) {
            return new C11499b(c11529g, interfaceC11564a, C11291k.a.f22509F);
        }
        if (C12238m.areEqual(classId, C11712a.topLevel(C11486a0.f23151e))) {
            return null;
        }
        return new C11538e(c11529g, interfaceC11564a, z2);
    }
}
