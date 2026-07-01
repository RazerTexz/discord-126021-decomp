package d0.e0.p.d.m0.n;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k0, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeFactory5 extends KotlinType4 {
    public final TypeConstructor k;
    public final List<TypeProjection> l;
    public final boolean m;
    public final MemberScope3 n;
    public final Function1<KotlinTypeRefiner, KotlinType4> o;

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinTypeFactory5(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, MemberScope3 memberScope3, Function1<? super KotlinTypeRefiner, ? extends KotlinType4> function1) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(function1, "refinedTypeFactory");
        this.k = typeConstructor;
        this.l = list;
        this.m = z2;
        this.n = memberScope3;
        this.o = function1;
        if (getMemberScope() instanceof ErrorUtils.d) {
            StringBuilder sbU = outline.U("SimpleTypeImpl should not be created for error type: ");
            sbU.append(getMemberScope());
            sbU.append('\n');
            sbU.append(getConstructor());
            throw new IllegalStateException(sbU.toString());
        }
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return Annotations4.f.getEMPTY();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public TypeConstructor getConstructor() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        if (z2 == isMarkedNullable()) {
            return this;
        }
        return z2 ? new KotlinTypeFactory4(this) : new KotlinTypeFactory2(this);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return annotations4.isEmpty() ? this : new KotlinTypeFactory3(this, annotations4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public KotlinType4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType4 kotlinType4Invoke = this.o.invoke(kotlinTypeRefiner);
        return kotlinType4Invoke == null ? this : kotlinType4Invoke;
    }
}
