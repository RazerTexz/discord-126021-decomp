package p007b.p225i.p361c.p369m.p370d.p384s.p386i;

import com.discord.restapi.RestAPIBuilder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4607a;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p373k.C4660v0;
import p007b.p225i.p361c.p369m.p370d.p377n.C4705a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p377n.C4707c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4746g;

/* JADX INFO: renamed from: b.i.c.m.d.s.i.c */
/* JADX INFO: compiled from: DefaultSettingsSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4749c extends AbstractC4607a implements InterfaceC4750d {

    /* JADX INFO: renamed from: f */
    public C4592b f12773f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4749c(String str, String str2, C4706b c4706b) {
        super(str, str2, c4706b, 1);
        C4592b c4592b = C4592b.f12227a;
        this.f12773f = c4592b;
    }

    /* JADX INFO: renamed from: d */
    public final C4705a m6692d(C4705a c4705a, C4746g c4746g) {
        m6693e(c4705a, "X-CRASHLYTICS-GOOGLE-APP-ID", c4746g.f12763a);
        m6693e(c4705a, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m6693e(c4705a, "X-CRASHLYTICS-API-CLIENT-VERSION", "17.3.0");
        m6693e(c4705a, "Accept", RestAPIBuilder.CONTENT_TYPE_JSON);
        m6693e(c4705a, "X-CRASHLYTICS-DEVICE-MODEL", c4746g.f12764b);
        m6693e(c4705a, "X-CRASHLYTICS-OS-BUILD-VERSION", c4746g.f12765c);
        m6693e(c4705a, "X-CRASHLYTICS-OS-DISPLAY-VERSION", c4746g.f12766d);
        m6693e(c4705a, "X-CRASHLYTICS-INSTALLATION-ID", ((C4660v0) c4746g.f12767e).m6456b());
        return c4705a;
    }

    /* JADX INFO: renamed from: e */
    public final void m6693e(C4705a c4705a, String str, String str2) {
        if (str2 != null) {
            c4705a.f12661e.put(str, str2);
        }
    }

    /* JADX INFO: renamed from: f */
    public final Map<String, String> m6694f(C4746g c4746g) {
        HashMap map = new HashMap();
        map.put("build_version", c4746g.f12770h);
        map.put("display_version", c4746g.f12769g);
        map.put("source", Integer.toString(c4746g.f12771i));
        String str = c4746g.f12768f;
        if (!C4628h.m6426t(str)) {
            map.put("instance", str);
        }
        return map;
    }

    /* JADX INFO: renamed from: g */
    public JSONObject m6695g(C4707c c4707c) {
        int i = c4707c.f12663a;
        this.f12773f.m6371b("Settings result was: " + i);
        if (!(i == 200 || i == 201 || i == 202 || i == 203)) {
            C4592b c4592b = this.f12773f;
            StringBuilder sbM833U = C1643a.m833U("Failed to retrieve settings from ");
            sbM833U.append(this.f12253b);
            c4592b.m6373d(sbM833U.toString());
            return null;
        }
        String str = c4707c.f12664b;
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            C4592b c4592b2 = this.f12773f;
            StringBuilder sbM833U2 = C1643a.m833U("Failed to parse settings JSON from ");
            sbM833U2.append(this.f12253b);
            c4592b2.m6372c(sbM833U2.toString(), e);
            C1643a.m868o0("Settings response ", str, this.f12773f);
            return null;
        }
    }
}
