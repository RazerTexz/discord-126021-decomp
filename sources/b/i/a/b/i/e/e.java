package b.i.a.b.i.e;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends k {
    public final k$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f748b;

    public e(k$a k_a, a aVar, e$a e_a) {
        this.a = k_a;
        this.f748b = aVar;
    }

    @Override // b.i.a.b.i.e.k
    @Nullable
    public a a() {
        return this.f748b;
    }

    @Override // b.i.a.b.i.e.k
    @Nullable
    public k$a b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k$a k_a = this.a;
        if (k_a != null ? k_a.equals(kVar.b()) : kVar.b() == null) {
            a aVar = this.f748b;
            if (aVar == null) {
                if (kVar.a() == null) {
                    return true;
                }
            } else if (aVar.equals(kVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k$a k_a = this.a;
        int iHashCode = ((k_a == null ? 0 : k_a.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.f748b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ClientInfo{clientType=");
        sbU.append(this.a);
        sbU.append(", androidClientInfo=");
        sbU.append(this.f748b);
        sbU.append("}");
        return sbU.toString();
    }
}
