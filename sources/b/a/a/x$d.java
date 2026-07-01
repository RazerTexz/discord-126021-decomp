package b.a.a;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x$d {
    public final Integer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f50b;

    public x$d(Integer num, boolean z2) {
        this.a = num;
        this.f50b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x$d)) {
            return false;
        }
        x$d x_d = (x$d) obj;
        return d0.z.d.m.areEqual(this.a, x_d.a) && this.f50b == x_d.f50b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Integer num = this.a;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        boolean z2 = this.f50b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(userFlags=");
        sbU.append(this.a);
        sbU.append(", isBusy=");
        return a.O(sbU, this.f50b, ")");
    }
}
