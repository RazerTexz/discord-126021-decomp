package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeProjectionBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 implements w0 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return isStarProjection() == w0Var.isStarProjection() && getProjectionKind() == w0Var.getProjectionKind() && getType().equals(w0Var.getType());
    }

    public int hashCode() {
        int iHashCode = getProjectionKind().hashCode();
        if (e1.noExpectedType(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (isStarProjection()) {
            return "*";
        }
        if (getProjectionKind() == j1.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }
}
