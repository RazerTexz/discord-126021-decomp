package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.f */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11495f {
    public static final boolean access$isAnnotatedWithTypeQualifier(InterfaceC11330e interfaceC11330e) {
        return C11487b.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES().contains(C11836a.getFqNameSafe(interfaceC11330e)) || interfaceC11330e.getAnnotations().hasAnnotation(C11487b.getTYPE_QUALIFIER_FQNAME());
    }
}
