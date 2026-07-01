package b.i.c.m.d.q.d;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.AbstractSpiCall;
import b.i.c.m.d.n.HttpRequest;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.q.c.CreateReportRequest;
import b.i.c.m.d.q.c.Report2;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.d, reason: use source file name */
/* JADX INFO: compiled from: NativeCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class NativeCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public final String f;

    public NativeCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, 2);
        this.f = str3;
    }

    @Override // b.i.c.m.d.q.d.CreateReportSpiCall
    public boolean a(CreateReportRequest createReportRequest, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        HttpRequest httpRequestB = b();
        String str = createReportRequest.f1742b;
        httpRequestB.e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        httpRequestB.e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequestB.e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f);
        httpRequestB.e.put("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        String str2 = createReportRequest.a;
        Report2 report2 = createReportRequest.c;
        if (str2 != null) {
            httpRequestB.b("org_id", str2);
        }
        httpRequestB.b("report_id", report2.a());
        for (File file : report2.e()) {
            if (file.getName().equals("minidump")) {
                httpRequestB.c("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                httpRequestB.c("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequestB.c("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                httpRequestB.c("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                httpRequestB.c("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                httpRequestB.c("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                httpRequestB.c("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                httpRequestB.c("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                httpRequestB.c("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                httpRequestB.c("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        Logger3 logger3 = Logger3.a;
        StringBuilder sbU = outline.U("Sending report to: ");
        sbU.append(this.f1676b);
        logger3.b(sbU.toString());
        try {
            int i = httpRequestB.a().a;
            logger3.b("Result was: " + i);
            return f.R0(i) == 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
