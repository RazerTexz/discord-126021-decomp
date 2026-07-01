package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations3;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker5;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c0, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType implements Annotations3, d0.e0.p.d.m0.n.n1.h {
    public int j;

    public KotlinType() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinType)) {
            return false;
        }
        KotlinType kotlinType = (KotlinType) obj;
        return isMarkedNullable() == kotlinType.isMarkedNullable() && NewKotlinTypeChecker5.a.strictEqualTypes(unwrap(), kotlinType.unwrap());
    }

    public abstract List<TypeProjection> getArguments();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope3 getMemberScope();

    public final int hashCode() {
        int iHashCode;
        int i = this.j;
        if (i != 0) {
            return i;
        }
        if (KotlinType2.isError(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (isMarkedNullable() ? 1 : 0) + ((getArguments().hashCode() + (getConstructor().hashCode() * 31)) * 31);
        }
        this.j = iHashCode;
        return iHashCode;
    }

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract KotlinType3 unwrap();

    public KotlinType(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
