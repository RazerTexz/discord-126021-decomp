package p007b.p225i.p361c.p369m.p370d.p380q;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractRunnableC4616d;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4722a;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.InterfaceC4727b;

/* JADX INFO: renamed from: b.i.c.m.d.q.b */
/* JADX INFO: compiled from: ReportUploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4721b {

    /* JADX INFO: renamed from: a */
    public static final short[] f12697a = {10, 20, 30, 60, 120, 300};

    /* JADX INFO: renamed from: b */
    public final InterfaceC4727b f12698b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f12699c;

    /* JADX INFO: renamed from: d */
    public final String f12700d;

    /* JADX INFO: renamed from: e */
    public final int f12701e;

    /* JADX INFO: renamed from: f */
    public final C4720a f12702f;

    /* JADX INFO: renamed from: g */
    public final a f12703g;

    /* JADX INFO: renamed from: h */
    public Thread f12704h;

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$a */
    /* JADX INFO: compiled from: ReportUploader.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$b */
    /* JADX INFO: compiled from: ReportUploader.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$c */
    /* JADX INFO: compiled from: ReportUploader.java */
    public interface c {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$d */
    /* JADX INFO: compiled from: ReportUploader.java */
    public class d extends AbstractRunnableC4616d {

        /* JADX INFO: renamed from: j */
        public final List<InterfaceC4724c> f12705j;

        /* JADX INFO: renamed from: k */
        public final boolean f12706k;

        /* JADX INFO: renamed from: l */
        public final float f12707l;

        public d(List<InterfaceC4724c> list, boolean z2, float f) {
            this.f12705j = list;
            this.f12706k = z2;
            this.f12707l = f;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p373k.AbstractRunnableC4616d
        /* JADX INFO: renamed from: a */
        public void mo6398a() {
            try {
                m6671b(this.f12705j, this.f12706k);
            } catch (Exception e) {
                if (C4592b.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "An unexpected error occurred while attempting to upload crash reports.", e);
                }
            }
            C4721b.this.f12704h = null;
        }

        /* JADX INFO: renamed from: b */
        public final void m6671b(List<InterfaceC4724c> list, boolean z2) {
            C4592b c4592b = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("Starting report processing in ");
            sbM833U.append(this.f12707l);
            sbM833U.append(" second(s)...");
            c4592b.m6371b(sbM833U.toString());
            float f = this.f12707l;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (C4663x.this.m6479p()) {
                return;
            }
            int i = 0;
            while (list.size() > 0 && !C4663x.this.m6479p()) {
                C4592b c4592b2 = C4592b.f12227a;
                StringBuilder sbM833U2 = C1643a.m833U("Attempting to send ");
                sbM833U2.append(list.size());
                sbM833U2.append(" report(s)");
                c4592b2.m6371b(sbM833U2.toString());
                ArrayList arrayList = new ArrayList();
                for (InterfaceC4724c interfaceC4724c : list) {
                    if (!C4721b.this.m6670a(interfaceC4724c, z2)) {
                        arrayList.add(interfaceC4724c);
                    }
                }
                if (arrayList.size() > 0) {
                    short[] sArr = C4721b.f12697a;
                    int i2 = i + 1;
                    long j = sArr[Math.min(i, sArr.length - 1)];
                    C4592b.f12227a.m6371b("Report submission: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }
    }

    public C4721b(@Nullable String str, String str2, int i, C4720a c4720a, InterfaceC4727b interfaceC4727b, a aVar) {
        if (interfaceC4727b == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f12698b = interfaceC4727b;
        this.f12699c = str;
        this.f12700d = str2;
        this.f12701e = i;
        this.f12702f = c4720a;
        this.f12703g = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:6:0x0011, B:19:0x0053, B:9:0x001a, B:11:0x0020, B:13:0x0027, B:17:0x0040), top: B:25:0x0001 }] */
    /* JADX INFO: renamed from: a */
    public boolean m6670a(InterfaceC4724c interfaceC4724c, boolean z2) {
        boolean zMo6678a;
        try {
            C4722a c4722a = new C4722a(this.f12699c, this.f12700d, interfaceC4724c);
            int i = this.f12701e;
            if (i != 3) {
                if (i == 2 && interfaceC4724c.mo6675d() == 1) {
                    C4592b.f12227a.m6371b("Report configured to be sent via DataTransport.");
                } else {
                    zMo6678a = this.f12698b.mo6678a(c4722a, z2);
                    C4592b c4592b = C4592b.f12227a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Crashlytics Reports Endpoint upload ");
                    sb.append(zMo6678a ? "complete: " : "FAILED: ");
                    sb.append(interfaceC4724c.mo6672a());
                    c4592b.m6375f(sb.toString());
                }
                if (zMo6678a) {
                    Objects.requireNonNull(this.f12702f);
                    interfaceC4724c.remove();
                    return true;
                }
                return false;
            }
            C4592b.f12227a.m6371b("Report configured to be sent via DataTransport.");
            zMo6678a = true;
            if (zMo6678a) {
                Objects.requireNonNull(this.f12702f);
                interfaceC4724c.remove();
                return true;
            }
        } catch (Exception e) {
            C4592b.f12227a.m6374e("Error occurred sending report " + interfaceC4724c, e);
        }
        return false;
    }
}
