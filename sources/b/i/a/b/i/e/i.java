package b.i.a.b.i.e;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends o {
    public final o$b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o$a f752b;

    public i(o$b o_b, o$a o_a, i$a i_a) {
        this.a = o_b;
        this.f752b = o_a;
    }

    @Override // b.i.a.b.i.e.o
    @Nullable
    public o$a a() {
        return this.f752b;
    }

    @Override // b.i.a.b.i.e.o
    @Nullable
    public o$b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o$b o_b = this.a;
        if (o_b != null ? o_b.equals(oVar.b()) : oVar.b() == null) {
            o$a o_a = this.f752b;
            if (o_a == null) {
                if (oVar.a() == null) {
                    return true;
                }
            } else if (o_a.equals(oVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o$b o_b = this.a;
        int iHashCode = ((o_b == null ? 0 : o_b.hashCode()) ^ 1000003) * 1000003;
        o$a o_a = this.f752b;
        return iHashCode ^ (o_a != null ? o_a.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("NetworkConnectionInfo{networkType=");
        sbU.append(this.a);
        sbU.append(", mobileSubtype=");
        sbU.append(this.f752b);
        sbU.append("}");
        return sbU.toString();
    }
}
