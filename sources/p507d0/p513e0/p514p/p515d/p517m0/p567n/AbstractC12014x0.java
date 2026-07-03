package p507d0.p513e0.p514p.p515d.p517m0.p567n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.x0 */
/* JADX INFO: compiled from: TypeProjectionBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12014x0 implements InterfaceC12012w0 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC12012w0)) {
            return false;
        }
        InterfaceC12012w0 interfaceC12012w0 = (InterfaceC12012w0) obj;
        return isStarProjection() == interfaceC12012w0.isStarProjection() && getProjectionKind() == interfaceC12012w0.getProjectionKind() && getType().equals(interfaceC12012w0.getType());
    }

    public int hashCode() {
        int iHashCode = getProjectionKind().hashCode();
        if (C11920e1.noExpectedType(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (isStarProjection()) {
            return "*";
        }
        if (getProjectionKind() == EnumC11935j1.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }
}
