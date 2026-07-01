package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.h1, reason: use source file name */
/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ErrorType extends ErrorType2 {
    public final String p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorType(String str, TypeConstructor typeConstructor, MemberScope3 memberScope3, List<? extends TypeProjection> list, boolean z2) {
        super(typeConstructor, memberScope3, list, z2, null, 16, null);
        Intrinsics3.checkNotNullParameter(str, "presentableName");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        this.p = str;
    }

    @Override // d0.e0.p.d.m0.n.ErrorType2
    public String getPresentableName() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.n.ErrorType2, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.ErrorType2, d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return new ErrorType(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z2);
    }
}
