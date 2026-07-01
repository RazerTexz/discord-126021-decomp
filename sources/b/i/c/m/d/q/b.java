package b.i.c.m.d.q;

import androidx.annotation.Nullable;
import b.i.c.m.d.q.c.c;
import java.util.Objects;

/* JADX INFO: compiled from: ReportUploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final short[] a = {10, 20, 30, 60, 120, 300};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.q.d.b f1741b;

    @Nullable
    public final String c;
    public final String d;
    public final int e;
    public final a f;
    public final b$a g;
    public Thread h;

    public b(@Nullable String str, String str2, int i, a aVar, b.i.c.m.d.q.d.b bVar, b$a b_a) {
        if (bVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f1741b = bVar;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = aVar;
        this.g = b_a;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:6:0x0011, B:19:0x0053, B:9:0x001a, B:11:0x0020, B:13:0x0027, B:17:0x0040), top: B:25:0x0001 }] */
    public boolean a(c cVar, boolean z2) {
        boolean zA;
        try {
            b.i.c.m.d.q.c.a aVar = new b.i.c.m.d.q.c.a(this.c, this.d, cVar);
            int i = this.e;
            if (i != 3) {
                if (i == 2 && cVar.d() == 1) {
                    b.i.c.m.d.b.a.b("Report configured to be sent via DataTransport.");
                } else {
                    zA = this.f1741b.a(aVar, z2);
                    b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Crashlytics Reports Endpoint upload ");
                    sb.append(zA ? "complete: " : "FAILED: ");
                    sb.append(cVar.a());
                    bVar.f(sb.toString());
                }
                if (zA) {
                    Objects.requireNonNull(this.f);
                    cVar.remove();
                    return true;
                }
                return false;
            }
            b.i.c.m.d.b.a.b("Report configured to be sent via DataTransport.");
            zA = true;
            if (zA) {
                Objects.requireNonNull(this.f);
                cVar.remove();
                return true;
            }
        } catch (Exception e) {
            b.i.c.m.d.b.a.e("Error occurred sending report " + cVar, e);
        }
        return false;
    }
}
