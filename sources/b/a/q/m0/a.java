package b.a.q.m0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: Codec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f266b;
    public final String c;
    public final int d;
    public final Integer e;

    public a(String str, int i, String str2, int i2, Integer num) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "type");
        this.a = str;
        this.f266b = i;
        this.c = str2;
        this.d = i2;
        this.e = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.areEqual(this.a, aVar.a) && this.f266b == aVar.f266b && m.areEqual(this.c, aVar.c) && this.d == aVar.d && m.areEqual(this.e, aVar.e);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f266b) * 31;
        String str2 = this.c;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.d) * 31;
        Integer num = this.e;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Codec(name=");
        sbU.append(this.a);
        sbU.append(", priority=");
        sbU.append(this.f266b);
        sbU.append(", type=");
        sbU.append(this.c);
        sbU.append(", payloadType=");
        sbU.append(this.d);
        sbU.append(", rtxPayloadType=");
        return b.d.b.a.a.F(sbU, this.e, ")");
    }
}
