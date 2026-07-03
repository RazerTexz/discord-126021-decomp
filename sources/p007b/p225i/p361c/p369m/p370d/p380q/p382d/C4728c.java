package p007b.p225i.p361c.p369m.p370d.p380q.p382d;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4607a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4705a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p377n.C4707c;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4722a;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.c */
/* JADX INFO: compiled from: DefaultCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4728c extends AbstractC4607a implements InterfaceC4727b {

    /* JADX INFO: renamed from: f */
    public final String f12718f;

    public C4728c(String str, String str2, C4706b c4706b, String str3) {
        super(str, str2, c4706b, 2);
        this.f12718f = str3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p382d.InterfaceC4727b
    /* JADX INFO: renamed from: a */
    public boolean mo6678a(C4722a c4722a, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        C4705a c4705aM6390b = m6390b();
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-GOOGLE-APP-ID", c4722a.f12710b);
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f12718f);
        for (Map.Entry<String, String> entry : c4722a.f12711c.mo6673b().entrySet()) {
            c4705aM6390b.f12661e.put(entry.getKey(), entry.getValue());
        }
        InterfaceC4724c interfaceC4724c = c4722a.f12711c;
        c4705aM6390b.m6622b("report[identifier]", interfaceC4724c.mo6672a());
        if (interfaceC4724c.mo6676e().length == 1) {
            C4592b c4592b = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("Adding single file ");
            sbM833U.append(interfaceC4724c.mo6677f());
            sbM833U.append(" to report ");
            sbM833U.append(interfaceC4724c.mo6672a());
            c4592b.m6371b(sbM833U.toString());
            c4705aM6390b.m6623c("report[file]", interfaceC4724c.mo6677f(), "application/octet-stream", interfaceC4724c.mo6674c());
        } else {
            int i = 0;
            for (File file : interfaceC4724c.mo6676e()) {
                C4592b c4592b2 = C4592b.f12227a;
                StringBuilder sbM833U2 = C1643a.m833U("Adding file ");
                sbM833U2.append(file.getName());
                sbM833U2.append(" to report ");
                sbM833U2.append(interfaceC4724c.mo6672a());
                c4592b2.m6371b(sbM833U2.toString());
                c4705aM6390b.m6623c("report[file" + i + "]", file.getName(), "application/octet-stream", file);
                i++;
            }
        }
        C4592b c4592b3 = C4592b.f12227a;
        StringBuilder sbM833U3 = C1643a.m833U("Sending report to: ");
        sbM833U3.append(this.f12253b);
        c4592b3.m6371b(sbM833U3.toString());
        try {
            C4707c c4707cM6621a = c4705aM6390b.m6621a();
            int i2 = c4707cM6621a.f12663a;
            c4592b3.m6371b("Create report request ID: " + c4707cM6621a.f12665c.m10954c("X-REQUEST-ID"));
            c4592b3.m6371b("Result was: " + i2);
            return C3404f.m4241R0(i2) == 0;
        } catch (IOException e) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Create report HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
