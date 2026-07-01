package b.i.c.m.d.s.i;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import b.i.a.f.e.o.f;
import b.i.c.m.d.k.h;
import java.io.IOException;

/* JADX INFO: compiled from: AbstractAppSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b.i.c.m.d.k.a {
    public final String f;

    public a(String str, String str2, b.i.c.m.d.n.b bVar, int i, String str3) {
        super(str, str2, bVar, i);
        this.f = str3;
    }

    public boolean d(b.i.c.m.d.s.h.a aVar, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        b.i.c.m.d.n.a aVarB = b();
        aVarB.e.put("X-CRASHLYTICS-ORG-ID", aVar.a);
        aVarB.e.put("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f1748b);
        aVarB.e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        aVarB.e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f);
        aVarB.b("org_id", aVar.a);
        aVarB.b("app[identifier]", aVar.c);
        aVarB.b("app[name]", aVar.g);
        aVarB.b("app[display_version]", aVar.d);
        aVarB.b("app[build_version]", aVar.e);
        aVarB.b("app[source]", Integer.toString(aVar.h));
        aVarB.b("app[minimum_sdk_version]", aVar.i);
        aVarB.b("app[built_sdk_version]", "0");
        if (!h.t(aVar.f)) {
            aVarB.b("app[instance_identifier]", aVar.f);
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U("Sending app info to ");
        sbU.append(this.f1676b);
        bVar.b(sbU.toString());
        try {
            b.i.c.m.d.n.c cVarA = aVarB.a();
            int i = cVarA.a;
            bVar.b((ShareTarget.METHOD_POST.equalsIgnoreCase(b.c.a.y.b.n(aVarB.f1736b)) ? "Create" : "Update") + " app request ID: " + cVarA.c.c("X-REQUEST-ID"));
            StringBuilder sb = new StringBuilder();
            sb.append("Result was ");
            sb.append(i);
            bVar.b(sb.toString());
            return f.R0(i) == 0;
        } catch (IOException e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
