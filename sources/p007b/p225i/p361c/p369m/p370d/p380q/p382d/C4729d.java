package p007b.p225i.p361c.p369m.p370d.p380q.p382d;

import java.io.File;
import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4607a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4705a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4722a;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.d */
/* JADX INFO: compiled from: NativeCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4729d extends AbstractC4607a implements InterfaceC4727b {

    /* JADX INFO: renamed from: f */
    public final String f12719f;

    public C4729d(String str, String str2, C4706b c4706b, String str3) {
        super(str, str2, c4706b, 2);
        this.f12719f = str3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p382d.InterfaceC4727b
    /* JADX INFO: renamed from: a */
    public boolean mo6678a(C4722a c4722a, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        C4705a c4705aM6390b = m6390b();
        String str = c4722a.f12710b;
        c4705aM6390b.f12661e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f12719f);
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        String str2 = c4722a.f12709a;
        InterfaceC4724c interfaceC4724c = c4722a.f12711c;
        if (str2 != null) {
            c4705aM6390b.m6622b("org_id", str2);
        }
        c4705aM6390b.m6622b("report_id", interfaceC4724c.mo6672a());
        for (File file : interfaceC4724c.mo6676e()) {
            if (file.getName().equals("minidump")) {
                c4705aM6390b.m6623c("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                c4705aM6390b.m6623c("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                c4705aM6390b.m6623c("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                c4705aM6390b.m6623c("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                c4705aM6390b.m6623c("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                c4705aM6390b.m6623c("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                c4705aM6390b.m6623c("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                c4705aM6390b.m6623c("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                c4705aM6390b.m6623c("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                c4705aM6390b.m6623c("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        C4592b c4592b = C4592b.f12227a;
        StringBuilder sbM833U = C1643a.m833U("Sending report to: ");
        sbM833U.append(this.f12253b);
        c4592b.m6371b(sbM833U.toString());
        try {
            int i = c4705aM6390b.m6621a().f12663a;
            c4592b.m6371b("Result was: " + i);
            return C3404f.m4241R0(i) == 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
