package b.i.c.m.d.q.d;

import b.i.a.f.e.o.f;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: NativeCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b.i.c.m.d.k.a implements b {
    public final String f;

    public d(String str, String str2, b.i.c.m.d.n.b bVar, String str3) {
        super(str, str2, bVar, 2);
        this.f = str3;
    }

    @Override // b.i.c.m.d.q.d.b
    public boolean a(b.i.c.m.d.q.c.a aVar, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        b.i.c.m.d.n.a aVarB = b();
        String str = aVar.f1742b;
        aVarB.e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        aVarB.e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        aVarB.e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f);
        aVarB.e.put("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        String str2 = aVar.a;
        b.i.c.m.d.q.c.c cVar = aVar.c;
        if (str2 != null) {
            aVarB.b("org_id", str2);
        }
        aVarB.b("report_id", cVar.a());
        for (File file : cVar.e()) {
            if (file.getName().equals("minidump")) {
                aVarB.c("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                aVarB.c("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                aVarB.c("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                aVarB.c("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                aVarB.c("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                aVarB.c("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                aVarB.c("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                aVarB.c("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                aVarB.c("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                aVarB.c("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U("Sending report to: ");
        sbU.append(this.f1676b);
        bVar.b(sbU.toString());
        try {
            int i = aVarB.a().a;
            bVar.b("Result was: " + i);
            return f.R0(i) == 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
