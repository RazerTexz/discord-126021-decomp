package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: AutoValue_LogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends m {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f751b;
    public final k c;
    public final Integer d;
    public final String e;
    public final List<l> f;
    public final p g;

    public g(long j, long j2, k kVar, Integer num, String str, List list, p pVar, g$a g_a) {
        this.a = j;
        this.f751b = j2;
        this.c = kVar;
        this.d = num;
        this.e = str;
        this.f = list;
        this.g = pVar;
    }

    @Override // b.i.a.b.i.e.m
    @Nullable
    public k a() {
        return this.c;
    }

    @Override // b.i.a.b.i.e.m
    @Nullable
    public List<l> b() {
        return this.f;
    }

    @Override // b.i.a.b.i.e.m
    @Nullable
    public Integer c() {
        return this.d;
    }

    @Override // b.i.a.b.i.e.m
    @Nullable
    public String d() {
        return this.e;
    }

    @Override // b.i.a.b.i.e.m
    @Nullable
    public p e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.a == mVar.f() && this.f751b == mVar.g() && ((kVar = this.c) != null ? kVar.equals(mVar.a()) : mVar.a() == null) && ((num = this.d) != null ? num.equals(mVar.c()) : mVar.c() == null) && ((str = this.e) != null ? str.equals(mVar.d()) : mVar.d() == null) && ((list = this.f) != null ? list.equals(mVar.b()) : mVar.b() == null)) {
            p pVar = this.g;
            if (pVar == null) {
                if (mVar.e() == null) {
                    return true;
                }
            } else if (pVar.equals(mVar.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.b.i.e.m
    public long f() {
        return this.a;
    }

    @Override // b.i.a.b.i.e.m
    public long g() {
        return this.f751b;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.f751b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        k kVar = this.c;
        int iHashCode = (i ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.g;
        return iHashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("LogRequest{requestTimeMs=");
        sbU.append(this.a);
        sbU.append(", requestUptimeMs=");
        sbU.append(this.f751b);
        sbU.append(", clientInfo=");
        sbU.append(this.c);
        sbU.append(", logSource=");
        sbU.append(this.d);
        sbU.append(", logSourceName=");
        sbU.append(this.e);
        sbU.append(", logEvents=");
        sbU.append(this.f);
        sbU.append(", qosTier=");
        sbU.append(this.g);
        sbU.append("}");
        return sbU.toString();
    }
}
