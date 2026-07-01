package b.i.c.m.d.s.i;

import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.AbstractSpiCall;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.IdManager;
import b.i.c.m.d.n.HttpRequest;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.n.HttpResponse;
import b.i.c.m.d.s.h.SettingsRequest;
import com.discord.restapi.RestAPIBuilder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.s.i.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultSettingsSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public Logger3 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSettingsSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(str, str2, httpRequestFactory, 1);
        Logger3 logger3 = Logger3.a;
        this.f = logger3;
    }

    public final HttpRequest d(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        e(httpRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.a);
        e(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        e(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", "17.3.0");
        e(httpRequest, "Accept", RestAPIBuilder.CONTENT_TYPE_JSON);
        e(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f1751b);
        e(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.c);
        e(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.d);
        e(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", ((IdManager) settingsRequest.e).b());
        return httpRequest;
    }

    public final void e(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.e.put(str, str2);
        }
    }

    public final Map<String, String> f(SettingsRequest settingsRequest) {
        HashMap map = new HashMap();
        map.put("build_version", settingsRequest.h);
        map.put("display_version", settingsRequest.g);
        map.put("source", Integer.toString(settingsRequest.i));
        String str = settingsRequest.f;
        if (!CommonUtils.t(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(HttpResponse httpResponse) {
        int i = httpResponse.a;
        this.f.b("Settings result was: " + i);
        if (!(i == 200 || i == 201 || i == 202 || i == 203)) {
            Logger3 logger3 = this.f;
            StringBuilder sbU = outline.U("Failed to retrieve settings from ");
            sbU.append(this.f1676b);
            logger3.d(sbU.toString());
            return null;
        }
        String str = httpResponse.f1737b;
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Logger3 logger4 = this.f;
            StringBuilder sbU2 = outline.U("Failed to parse settings JSON from ");
            sbU2.append(this.f1676b);
            logger4.c(sbU2.toString(), e);
            outline.o0("Settings response ", str, this.f);
            return null;
        }
    }
}
