package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11957q;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c0 */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11913c0 implements InterfaceC11338a, InterfaceC11979h {

    /* JADX INFO: renamed from: j */
    public int f24744j;

    public AbstractC11913c0() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC11913c0)) {
            return false;
        }
        AbstractC11913c0 abstractC11913c0 = (AbstractC11913c0) obj;
        return isMarkedNullable() == abstractC11913c0.isMarkedNullable() && C11957q.f24828a.strictEqualTypes(unwrap(), abstractC11913c0.unwrap());
    }

    public abstract List<InterfaceC12012w0> getArguments();

    public abstract InterfaceC12008u0 getConstructor();

    public abstract InterfaceC11770i getMemberScope();

    public final int hashCode() {
        int iHashCode;
        int i = this.f24744j;
        if (i != 0) {
            return i;
        }
        if (C11919e0.isError(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (isMarkedNullable() ? 1 : 0) + ((getArguments().hashCode() + (getConstructor().hashCode() * 31)) * 31);
        }
        this.f24744j = iHashCode;
        return iHashCode;
    }

    public abstract boolean isMarkedNullable();

    public abstract AbstractC11913c0 refine(AbstractC11947g abstractC11947g);

    public abstract AbstractC11932i1 unwrap();

    public AbstractC11913c0(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
