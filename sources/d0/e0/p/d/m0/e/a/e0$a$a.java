package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$a$a {
    public final d0.e0.p.d.m0.g.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3312b;

    public e0$a$a(d0.e0.p.d.m0.g.e eVar, String str) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str, "signature");
        this.a = eVar;
        this.f3312b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0$a$a)) {
            return false;
        }
        e0$a$a e0_a_a = (e0$a$a) obj;
        return d0.z.d.m.areEqual(this.a, e0_a_a.a) && d0.z.d.m.areEqual(this.f3312b, e0_a_a.f3312b);
    }

    public final d0.e0.p.d.m0.g.e getName() {
        return this.a;
    }

    public final String getSignature() {
        return this.f3312b;
    }

    public int hashCode() {
        return this.f3312b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("NameAndSignature(name=");
        sbU.append(this.a);
        sbU.append(", signature=");
        return b.d.b.a.a.H(sbU, this.f3312b, ')');
    }
}
