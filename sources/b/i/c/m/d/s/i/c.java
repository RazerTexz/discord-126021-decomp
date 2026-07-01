package b.i.c.m.d.s.i;

import b.i.c.m.d.k.h;
import b.i.c.m.d.k.v0;
import b.i.c.m.d.s.h.g;
import com.discord.restapi.RestAPIBuilder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultSettingsSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends b.i.c.m.d.k.a implements d {
    public b.i.c.m.d.b f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, b.i.c.m.d.n.b bVar) {
        super(str, str2, bVar, 1);
        b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
        this.f = bVar2;
    }

    public final b.i.c.m.d.n.a d(b.i.c.m.d.n.a aVar, g gVar) {
        e(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", gVar.a);
        e(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        e(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", "17.3.0");
        e(aVar, "Accept", RestAPIBuilder.CONTENT_TYPE_JSON);
        e(aVar, "X-CRASHLYTICS-DEVICE-MODEL", gVar.f1751b);
        e(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", gVar.c);
        e(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", gVar.d);
        e(aVar, "X-CRASHLYTICS-INSTALLATION-ID", ((v0) gVar.e).b());
        return aVar;
    }

    public final void e(b.i.c.m.d.n.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.e.put(str, str2);
        }
    }

    public final Map<String, String> f(g gVar) {
        HashMap map = new HashMap();
        map.put("build_version", gVar.h);
        map.put("display_version", gVar.g);
        map.put("source", Integer.toString(gVar.i));
        String str = gVar.f;
        if (!h.t(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(b.i.c.m.d.n.c cVar) {
        int i = cVar.a;
        this.f.b("Settings result was: " + i);
        if (!(i == 200 || i == 201 || i == 202 || i == 203)) {
            b.i.c.m.d.b bVar = this.f;
            StringBuilder sbU = b.d.b.a.a.U("Failed to retrieve settings from ");
            sbU.append(this.f1676b);
            bVar.d(sbU.toString());
            return null;
        }
        String str = cVar.f1737b;
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            b.i.c.m.d.b bVar2 = this.f;
            StringBuilder sbU2 = b.d.b.a.a.U("Failed to parse settings JSON from ");
            sbU2.append(this.f1676b);
            bVar2.c(sbU2.toString(), e);
            b.d.b.a.a.o0("Settings response ", str, this.f);
            return null;
        }
    }
}
