package p007b.p225i.p361c.p369m.p370d.p384s.p386i;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4607a;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p377n.C4705a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p377n.C4707c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4740a;

/* JADX INFO: renamed from: b.i.c.m.d.s.i.a */
/* JADX INFO: compiled from: AbstractAppSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4747a extends AbstractC4607a {

    /* JADX INFO: renamed from: f */
    public final String f12772f;

    public AbstractC4747a(String str, String str2, C4706b c4706b, int i, String str3) {
        super(str, str2, c4706b, i);
        this.f12772f = str3;
    }

    /* JADX INFO: renamed from: d */
    public boolean m6691d(C4740a c4740a, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        C4705a c4705aM6390b = m6390b();
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-ORG-ID", c4740a.f12740a);
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-GOOGLE-APP-ID", c4740a.f12741b);
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c4705aM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f12772f);
        c4705aM6390b.m6622b("org_id", c4740a.f12740a);
        c4705aM6390b.m6622b("app[identifier]", c4740a.f12742c);
        c4705aM6390b.m6622b("app[name]", c4740a.f12746g);
        c4705aM6390b.m6622b("app[display_version]", c4740a.f12743d);
        c4705aM6390b.m6622b("app[build_version]", c4740a.f12744e);
        c4705aM6390b.m6622b("app[source]", Integer.toString(c4740a.f12747h));
        c4705aM6390b.m6622b("app[minimum_sdk_version]", c4740a.f12748i);
        c4705aM6390b.m6622b("app[built_sdk_version]", "0");
        if (!C4628h.m6426t(c4740a.f12745f)) {
            c4705aM6390b.m6622b("app[instance_identifier]", c4740a.f12745f);
        }
        C4592b c4592b = C4592b.f12227a;
        StringBuilder sbM833U = C1643a.m833U("Sending app info to ");
        sbM833U.append(this.f12253b);
        c4592b.m6371b(sbM833U.toString());
        try {
            C4707c c4707cM6621a = c4705aM6390b.m6621a();
            int i = c4707cM6621a.f12663a;
            c4592b.m6371b((ShareTarget.METHOD_POST.equalsIgnoreCase(C1563b.m764n(c4705aM6390b.f12658b)) ? "Create" : "Update") + " app request ID: " + c4707cM6621a.f12665c.m10954c("X-REQUEST-ID"));
            StringBuilder sb = new StringBuilder();
            sb.append("Result was ");
            sb.append(i);
            c4592b.m6371b(sb.toString());
            return C3404f.m4241R0(i) == 0;
        } catch (IOException e) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
