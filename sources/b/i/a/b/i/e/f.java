package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_LogEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends l {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f749b;
    public final long c;
    public final byte[] d;
    public final String e;
    public final long f;
    public final o g;

    public f(long j, Integer num, long j2, byte[] bArr, String str, long j3, o oVar, f$a f_a) {
        this.a = j;
        this.f749b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = oVar;
    }

    @Override // b.i.a.b.i.e.l
    @Nullable
    public Integer a() {
        return this.f749b;
    }

    @Override // b.i.a.b.i.e.l
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.i.e.l
    public long c() {
        return this.c;
    }

    @Override // b.i.a.b.i.e.l
    @Nullable
    public o d() {
        return this.g;
    }

    @Override // b.i.a.b.i.e.l
    @Nullable
    public byte[] e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.a == lVar.b() && ((num = this.f749b) != null ? num.equals(lVar.a()) : lVar.a() == null) && this.c == lVar.c()) {
            if (Arrays.equals(this.d, lVar instanceof f ? ((f) lVar).d : lVar.e()) && ((str = this.e) != null ? str.equals(lVar.f()) : lVar.f() == null) && this.f == lVar.g()) {
                o oVar = this.g;
                if (oVar == null) {
                    if (lVar.d() == null) {
                        return true;
                    }
                } else if (oVar.equals(lVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.i.a.b.i.e.l
    @Nullable
    public String f() {
        return this.e;
    }

    @Override // b.i.a.b.i.e.l
    public long g() {
        return this.f;
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f749b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j2 = this.c;
        int iHashCode2 = (((((i ^ iHashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f;
        int i2 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        o oVar = this.g;
        return i2 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("LogEvent{eventTimeMs=");
        sbU.append(this.a);
        sbU.append(", eventCode=");
        sbU.append(this.f749b);
        sbU.append(", eventUptimeMs=");
        sbU.append(this.c);
        sbU.append(", sourceExtension=");
        sbU.append(Arrays.toString(this.d));
        sbU.append(", sourceExtensionJsonProto3=");
        sbU.append(this.e);
        sbU.append(", timezoneOffsetSeconds=");
        sbU.append(this.f);
        sbU.append(", networkConnectionInfo=");
        sbU.append(this.g);
        sbU.append("}");
        return sbU.toString();
    }
}
