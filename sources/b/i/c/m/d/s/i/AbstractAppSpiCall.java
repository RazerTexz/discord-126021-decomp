package b.i.c.m.d.s.i;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.AbstractSpiCall;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.n.HttpRequest;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.n.HttpResponse;
import b.i.c.m.d.s.h.AppRequestData;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.c.m.d.s.i.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractAppSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractAppSpiCall extends AbstractSpiCall {
    public final String f;

    public AbstractAppSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, int i, String str3) {
        super(str, str2, httpRequestFactory, i);
        this.f = str3;
    }

    public boolean d(AppRequestData appRequestData, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        HttpRequest httpRequestB = b();
        httpRequestB.e.put("X-CRASHLYTICS-ORG-ID", appRequestData.a);
        httpRequestB.e.put("X-CRASHLYTICS-GOOGLE-APP-ID", appRequestData.f1748b);
        httpRequestB.e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequestB.e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f);
        httpRequestB.b("org_id", appRequestData.a);
        httpRequestB.b("app[identifier]", appRequestData.c);
        httpRequestB.b("app[name]", appRequestData.g);
        httpRequestB.b("app[display_version]", appRequestData.d);
        httpRequestB.b("app[build_version]", appRequestData.e);
        httpRequestB.b("app[source]", Integer.toString(appRequestData.h));
        httpRequestB.b("app[minimum_sdk_version]", appRequestData.i);
        httpRequestB.b("app[built_sdk_version]", "0");
        if (!CommonUtils.t(appRequestData.f)) {
            httpRequestB.b("app[instance_identifier]", appRequestData.f);
        }
        Logger3 logger3 = Logger3.a;
        StringBuilder sbU = outline.U("Sending app info to ");
        sbU.append(this.f1676b);
        logger3.b(sbU.toString());
        try {
            HttpResponse httpResponseA = httpRequestB.a();
            int i = httpResponseA.a;
            logger3.b((ShareTarget.METHOD_POST.equalsIgnoreCase(b.c.a.y.b.n(httpRequestB.f1736b)) ? "Create" : "Update") + " app request ID: " + httpResponseA.c.c("X-REQUEST-ID"));
            StringBuilder sb = new StringBuilder();
            sb.append("Result was ");
            sb.append(i);
            logger3.b(sb.toString());
            return f.R0(i) == 0;
        } catch (IOException e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
