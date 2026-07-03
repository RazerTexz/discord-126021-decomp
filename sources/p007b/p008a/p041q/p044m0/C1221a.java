package p007b.p008a.p041q.p044m0;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.a */
/* JADX INFO: compiled from: Codec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1221a {

    /* JADX INFO: renamed from: a */
    public final String f1671a;

    /* JADX INFO: renamed from: b */
    public final int f1672b;

    /* JADX INFO: renamed from: c */
    public final String f1673c;

    /* JADX INFO: renamed from: d */
    public final int f1674d;

    /* JADX INFO: renamed from: e */
    public final Integer f1675e;

    public C1221a(String str, int i, String str2, int i2, Integer num) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "type");
        this.f1671a = str;
        this.f1672b = i;
        this.f1673c = str2;
        this.f1674d = i2;
        this.f1675e = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1221a)) {
            return false;
        }
        C1221a c1221a = (C1221a) obj;
        return C12238m.areEqual(this.f1671a, c1221a.f1671a) && this.f1672b == c1221a.f1672b && C12238m.areEqual(this.f1673c, c1221a.f1673c) && this.f1674d == c1221a.f1674d && C12238m.areEqual(this.f1675e, c1221a.f1675e);
    }

    public int hashCode() {
        String str = this.f1671a;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f1672b) * 31;
        String str2 = this.f1673c;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f1674d) * 31;
        Integer num = this.f1675e;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Codec(name=");
        sbM833U.append(this.f1671a);
        sbM833U.append(", priority=");
        sbM833U.append(this.f1672b);
        sbM833U.append(", type=");
        sbM833U.append(this.f1673c);
        sbM833U.append(", payloadType=");
        sbM833U.append(this.f1674d);
        sbM833U.append(", rtxPayloadType=");
        return C1643a.m818F(sbM833U, this.f1675e, ")");
    }
}
