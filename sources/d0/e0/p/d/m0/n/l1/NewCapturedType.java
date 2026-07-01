package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.i, reason: use source file name */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedType extends KotlinType4 implements d0.e0.p.d.m0.n.n1.c {
    public final d0.e0.p.d.m0.n.n1.b k;
    public final NewCapturedType2 l;
    public final KotlinType3 m;
    public final Annotations4 n;
    public final boolean o;
    public final boolean p;

    public /* synthetic */ NewCapturedType(d0.e0.p.d.m0.n.n1.b bVar, NewCapturedType2 newCapturedType2, KotlinType3 kotlinType3, Annotations4 annotations4, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, newCapturedType2, kotlinType3, (i & 8) != 0 ? Annotations4.f.getEMPTY() : annotations4, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return Collections2.emptyList();
    }

    public final d0.e0.p.d.m0.n.n1.b getCaptureStatus() {
        return this.k;
    }

    public final KotlinType3 getLowerType() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
        Intrinsics3.checkNotNullExpressionValue(memberScope3CreateErrorScope, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return memberScope3CreateErrorScope;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return this.o;
    }

    public final boolean isProjectionNotNull() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public NewCapturedType2 getConstructor() {
        return this.l;
    }

    public NewCapturedType(d0.e0.p.d.m0.n.n1.b bVar, NewCapturedType2 newCapturedType2, KotlinType3 kotlinType3, Annotations4 annotations4, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(bVar, "captureStatus");
        Intrinsics3.checkNotNullParameter(newCapturedType2, "constructor");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        this.k = bVar;
        this.l = newCapturedType2;
        this.m = kotlinType3;
        this.n = annotations4;
        this.o = z2;
        this.p = z3;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public NewCapturedType makeNullableAsSpecified(boolean z2) {
        return new NewCapturedType(this.k, getConstructor(), this.m, getAnnotations(), z2, false, 32, null);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public NewCapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        d0.e0.p.d.m0.n.n1.b bVar = this.k;
        NewCapturedType2 newCapturedType2Refine = getConstructor().refine(kotlinTypeRefiner);
        KotlinType3 kotlinType3 = this.m;
        return new NewCapturedType(bVar, newCapturedType2Refine, kotlinType3 == null ? null : kotlinTypeRefiner.refineType(kotlinType3).unwrap(), getAnnotations(), isMarkedNullable(), false, 32, null);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public NewCapturedType replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new NewCapturedType(this.k, getConstructor(), this.m, annotations4, isMarkedNullable(), false, 32, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedType(d0.e0.p.d.m0.n.n1.b bVar, KotlinType3 kotlinType3, TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        this(bVar, new NewCapturedType2(typeProjection, null, null, typeParameterDescriptor, 6, null), kotlinType3, null, false, false, 56, null);
        Intrinsics3.checkNotNullParameter(bVar, "captureStatus");
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
    }
}
