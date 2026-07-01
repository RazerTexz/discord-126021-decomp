package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.b.i.e.g, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_LogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_LogRequest extends LogRequest {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f751b;
    public final ClientInfo2 c;
    public final Integer d;
    public final String e;
    public final List<LogEvent> f;
    public final QosTier g;

    public AutoValue_LogRequest(long j, long j2, ClientInfo2 clientInfo2, Integer num, String str, List list, QosTier qosTier, a aVar) {
        this.a = j;
        this.f751b = j2;
        this.c = clientInfo2;
        this.d = num;
        this.e = str;
        this.f = list;
        this.g = qosTier;
    }

    @Override // b.i.a.b.i.e.LogRequest
    @Nullable
    public ClientInfo2 a() {
        return this.c;
    }

    @Override // b.i.a.b.i.e.LogRequest
    @Nullable
    public List<LogEvent> b() {
        return this.f;
    }

    @Override // b.i.a.b.i.e.LogRequest
    @Nullable
    public Integer c() {
        return this.d;
    }

    @Override // b.i.a.b.i.e.LogRequest
    @Nullable
    public String d() {
        return this.e;
    }

    @Override // b.i.a.b.i.e.LogRequest
    @Nullable
    public QosTier e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        ClientInfo2 clientInfo2;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.a == logRequest.f() && this.f751b == logRequest.g() && ((clientInfo2 = this.c) != null ? clientInfo2.equals(logRequest.a()) : logRequest.a() == null) && ((num = this.d) != null ? num.equals(logRequest.c()) : logRequest.c() == null) && ((str = this.e) != null ? str.equals(logRequest.d()) : logRequest.d() == null) && ((list = this.f) != null ? list.equals(logRequest.b()) : logRequest.b() == null)) {
            QosTier qosTier = this.g;
            if (qosTier == null) {
                if (logRequest.e() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.b.i.e.LogRequest
    public long f() {
        return this.a;
    }

    @Override // b.i.a.b.i.e.LogRequest
    public long g() {
        return this.f751b;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.f751b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        ClientInfo2 clientInfo2 = this.c;
        int iHashCode = (i ^ (clientInfo2 == null ? 0 : clientInfo2.hashCode())) * 1000003;
        Integer num = this.d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LogRequest{requestTimeMs=");
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
