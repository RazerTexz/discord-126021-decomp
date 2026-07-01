package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.b.i.e.LogEvent;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.b.i.e.f, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_LogEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_LogEvent extends LogEvent {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f749b;
    public final long c;
    public final byte[] d;
    public final String e;
    public final long f;
    public final NetworkConnectionInfo g;

    /* JADX INFO: renamed from: b.i.a.b.i.e.f$b */
    /* JADX INFO: compiled from: AutoValue_LogEvent.java */
    public static final class b extends LogEvent.a {
        public Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f750b;
        public Long c;
        public byte[] d;
        public String e;
        public Long f;
        public NetworkConnectionInfo g;
    }

    public AutoValue_LogEvent(long j, Integer num, long j2, byte[] bArr, String str, long j3, NetworkConnectionInfo networkConnectionInfo, a aVar) {
        this.a = j;
        this.f749b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = networkConnectionInfo;
    }

    @Override // b.i.a.b.i.e.LogEvent
    @Nullable
    public Integer a() {
        return this.f749b;
    }

    @Override // b.i.a.b.i.e.LogEvent
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.i.e.LogEvent
    public long c() {
        return this.c;
    }

    @Override // b.i.a.b.i.e.LogEvent
    @Nullable
    public NetworkConnectionInfo d() {
        return this.g;
    }

    @Override // b.i.a.b.i.e.LogEvent
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
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.a == logEvent.b() && ((num = this.f749b) != null ? num.equals(logEvent.a()) : logEvent.a() == null) && this.c == logEvent.c()) {
            if (Arrays.equals(this.d, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).d : logEvent.e()) && ((str = this.e) != null ? str.equals(logEvent.f()) : logEvent.f() == null) && this.f == logEvent.g()) {
                NetworkConnectionInfo networkConnectionInfo = this.g;
                if (networkConnectionInfo == null) {
                    if (logEvent.d() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.i.a.b.i.e.LogEvent
    @Nullable
    public String f() {
        return this.e;
    }

    @Override // b.i.a.b.i.e.LogEvent
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
        NetworkConnectionInfo networkConnectionInfo = this.g;
        return i2 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LogEvent{eventTimeMs=");
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
