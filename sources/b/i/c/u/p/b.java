package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1789b;
    public final f$b c;

    public b(String str, long j, f$b f_b, b$a b_a) {
        this.a = str;
        this.f1789b = j;
        this.c = f_b;
    }

    @Override // b.i.c.u.p.f
    @Nullable
    public f$b b() {
        return this.c;
    }

    @Override // b.i.c.u.p.f
    @Nullable
    public String c() {
        return this.a;
    }

    @Override // b.i.c.u.p.f
    @NonNull
    public long d() {
        return this.f1789b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f1789b == fVar.d()) {
                f$b f_b = this.c;
                if (f_b == null) {
                    if (fVar.b() == null) {
                        return true;
                    }
                } else if (f_b.equals(fVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f1789b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        f$b f_b = this.c;
        return i ^ (f_b != null ? f_b.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("TokenResult{token=");
        sbU.append(this.a);
        sbU.append(", tokenExpirationTimestamp=");
        sbU.append(this.f1789b);
        sbU.append(", responseCode=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
