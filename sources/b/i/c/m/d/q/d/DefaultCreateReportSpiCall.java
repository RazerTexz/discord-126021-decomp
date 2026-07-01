package b.i.c.m.d.q.d;

import android.util.Log;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.AbstractSpiCall;
import b.i.c.m.d.n.HttpRequest;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.n.HttpResponse;
import b.i.c.m.d.q.c.CreateReportRequest;
import b.i.c.m.d.q.c.Report2;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public final String f;

    public DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, 2);
        this.f = str3;
    }

    @Override // b.i.c.m.d.q.d.CreateReportSpiCall
    public boolean a(CreateReportRequest createReportRequest, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        HttpRequest httpRequestB = b();
        httpRequestB.e.put("X-CRASHLYTICS-GOOGLE-APP-ID", createReportRequest.f1742b);
        httpRequestB.e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequestB.e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f);
        for (Map.Entry<String, String> entry : createReportRequest.c.b().entrySet()) {
            httpRequestB.e.put(entry.getKey(), entry.getValue());
        }
        Report2 report2 = createReportRequest.c;
        httpRequestB.b("report[identifier]", report2.a());
        if (report2.e().length == 1) {
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("Adding single file ");
            sbU.append(report2.f());
            sbU.append(" to report ");
            sbU.append(report2.a());
            logger3.b(sbU.toString());
            httpRequestB.c("report[file]", report2.f(), "application/octet-stream", report2.c());
        } else {
            int i = 0;
            for (File file : report2.e()) {
                Logger3 logger4 = Logger3.a;
                StringBuilder sbU2 = outline.U("Adding file ");
                sbU2.append(file.getName());
                sbU2.append(" to report ");
                sbU2.append(report2.a());
                logger4.b(sbU2.toString());
                httpRequestB.c("report[file" + i + "]", file.getName(), "application/octet-stream", file);
                i++;
            }
        }
        Logger3 logger5 = Logger3.a;
        StringBuilder sbU3 = outline.U("Sending report to: ");
        sbU3.append(this.f1676b);
        logger5.b(sbU3.toString());
        try {
            HttpResponse httpResponseA = httpRequestB.a();
            int i2 = httpResponseA.a;
            logger5.b("Create report request ID: " + httpResponseA.c.c("X-REQUEST-ID"));
            logger5.b("Result was: " + i2);
            return f.R0(i2) == 0;
        } catch (IOException e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Create report HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
