package b.i.c.m.d.q.d;

import android.util.Log;
import b.i.a.f.e.o.f;
import java.io.File;
import java.io.IOException;
import java.util.Map$Entry;

/* JADX INFO: compiled from: DefaultCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends b.i.c.m.d.k.a implements b {
    public final String f;

    public c(String str, String str2, b.i.c.m.d.n.b bVar, String str3) {
        super(str, str2, bVar, 2);
        this.f = str3;
    }

    @Override // b.i.c.m.d.q.d.b
    public boolean a(b.i.c.m.d.q.c.a aVar, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        b.i.c.m.d.n.a aVarB = b();
        aVarB.e.put("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f1742b);
        aVarB.e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        aVarB.e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f);
        for (Map$Entry<String, String> map$Entry : aVar.c.b().entrySet()) {
            aVarB.e.put(map$Entry.getKey(), map$Entry.getValue());
        }
        b.i.c.m.d.q.c.c cVar = aVar.c;
        aVarB.b("report[identifier]", cVar.a());
        if (cVar.e().length == 1) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Adding single file ");
            sbU.append(cVar.f());
            sbU.append(" to report ");
            sbU.append(cVar.a());
            bVar.b(sbU.toString());
            aVarB.c("report[file]", cVar.f(), "application/octet-stream", cVar.c());
        } else {
            int i = 0;
            for (File file : cVar.e()) {
                b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
                StringBuilder sbU2 = b.d.b.a.a.U("Adding file ");
                sbU2.append(file.getName());
                sbU2.append(" to report ");
                sbU2.append(cVar.a());
                bVar2.b(sbU2.toString());
                aVarB.c("report[file" + i + "]", file.getName(), "application/octet-stream", file);
                i++;
            }
        }
        b.i.c.m.d.b bVar3 = b.i.c.m.d.b.a;
        StringBuilder sbU3 = b.d.b.a.a.U("Sending report to: ");
        sbU3.append(this.f1676b);
        bVar3.b(sbU3.toString());
        try {
            b.i.c.m.d.n.c cVarA = aVarB.a();
            int i2 = cVarA.a;
            bVar3.b("Create report request ID: " + cVarA.c.c("X-REQUEST-ID"));
            bVar3.b("Result was: " + i2);
            return f.R0(i2) == 0;
        } catch (IOException e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Create report HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
