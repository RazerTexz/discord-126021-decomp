package b.a.q.m0;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.m0.a, reason: use source file name */
/* JADX INFO: compiled from: Codec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Codec2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f266b;
    public final String c;
    public final int d;
    public final Integer e;

    public Codec2(String str, int i, String str2, int i2, Integer num) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "type");
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
        if (!(obj instanceof Codec2)) {
            return false;
        }
        Codec2 codec2 = (Codec2) obj;
        return Intrinsics3.areEqual(this.a, codec2.a) && this.f266b == codec2.f266b && Intrinsics3.areEqual(this.c, codec2.c) && this.d == codec2.d && Intrinsics3.areEqual(this.e, codec2.e);
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
        StringBuilder sbU = outline.U("Codec(name=");
        sbU.append(this.a);
        sbU.append(", priority=");
        sbU.append(this.f266b);
        sbU.append(", type=");
        sbU.append(this.c);
        sbU.append(", payloadType=");
        sbU.append(this.d);
        sbU.append(", rtxPayloadType=");
        return outline.F(sbU, this.e, ")");
    }
}
