package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.q, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1731b;
    public final String c;
    public final long d;
    public final int e;

    /* JADX INFO: renamed from: b.i.c.m.d.m.q$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
    public static final class b extends CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a.AbstractC0055a {
        public Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1732b;
        public String c;
        public Long d;
        public Integer e;

        public CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a a() {
            String strW = this.a == null ? " pc" : "";
            if (this.f1732b == null) {
                strW = outline.w(strW, " symbol");
            }
            if (this.d == null) {
                strW = outline.w(strW, " offset");
            }
            if (this.e == null) {
                strW = outline.w(strW, " importance");
            }
            if (strW.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.a.longValue(), this.f1732b, this.c, this.d.longValue(), this.e.intValue(), null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j, String str, String str2, long j2, int i, a aVar) {
        this.a = j;
        this.f1731b = str;
        this.c = str2;
        this.d = j2;
        this.e = i;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a
    @Nullable
    public String a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a
    public int b() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a
    public long c() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a
    public long d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a
    @NonNull
    public String e() {
        return this.f1731b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a abstractC0054a = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a) obj;
        return this.a == abstractC0054a.d() && this.f1731b.equals(abstractC0054a.e()) && ((str = this.c) != null ? str.equals(abstractC0054a.a()) : abstractC0054a.a() == null) && this.d == abstractC0054a.c() && this.e == abstractC0054a.b();
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1731b.hashCode()) * 1000003;
        String str = this.c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j2 = this.d;
        return this.e ^ ((iHashCode2 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Frame{pc=");
        sbU.append(this.a);
        sbU.append(", symbol=");
        sbU.append(this.f1731b);
        sbU.append(", file=");
        sbU.append(this.c);
        sbU.append(", offset=");
        sbU.append(this.d);
        sbU.append(", importance=");
        return outline.B(sbU, this.e, "}");
    }
}
