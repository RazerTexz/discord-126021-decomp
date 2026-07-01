package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.s, reason: use source file name */
/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorType2 extends KotlinType4 {
    public final TypeConstructor k;
    public final MemberScope3 l;
    public final List<TypeProjection> m;
    public final boolean n;
    public final String o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3) {
        this(typeConstructor, memberScope3, null, false, null, 28, null);
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3, List<? extends TypeProjection> list, boolean z2) {
        this(typeConstructor, memberScope3, list, z2, null, 16, null);
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(list, "arguments");
    }

    public /* synthetic */ ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3, List list, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope3, (i & 4) != 0 ? Collections2.emptyList() : list, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? "???" : str);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return Annotations4.f.getEMPTY();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public TypeConstructor getConstructor() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        return this.l;
    }

    public String getPresentableName() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public ErrorType2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor());
        sb.append(getArguments().isEmpty() ? "" : _Collections.joinToString(getArguments(), ", ", "<", ">", -1, "...", null));
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return new ErrorType2(getConstructor(), getMemberScope(), getArguments(), z2, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3, List<? extends TypeProjection> list, boolean z2, String str) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(str, "presentableName");
        this.k = typeConstructor;
        this.l = memberScope3;
        this.m = list;
        this.n = z2;
        this.o = str;
    }
}
