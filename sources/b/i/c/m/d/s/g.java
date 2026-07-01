package b.i.c.m.d.s;

import b.i.c.m.d.k.e1;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsV3JsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements f {
    @Override // b.i.c.m.d.s.f
    public b.i.c.m.d.s.h.f a(e1 e1Var, JSONObject jSONObject) throws JSONException {
        long jCurrentTimeMillis;
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("fabric");
        JSONObject jSONObject3 = jSONObject.getJSONObject("app");
        String string = jSONObject3.getString("status");
        boolean zEquals = "new".equals(string);
        String string2 = jSONObject2.getString("bundle_id");
        String string3 = jSONObject2.getString("org_id");
        String str = zEquals ? "https://update.crashlytics.com/spi/v1/platforms/android/apps" : String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", string2);
        Locale locale = Locale.US;
        b.i.c.m.d.s.h.b bVar = new b.i.c.m.d.s.h.b(string, str, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject3.optBoolean("update_required", false), jSONObject3.optInt("report_upload_variant", 0), jSONObject3.optInt("native_report_upload_variant", 0));
        b.i.c.m.d.s.h.d dVar = new b.i.c.m.d.s.h.d(8, 4);
        b.i.c.m.d.s.h.c cVar = new b.i.c.m.d.s.h.c(jSONObject.getJSONObject("features").optBoolean("collect_reports", true));
        long j = iOptInt2;
        if (jSONObject.has("expires_at")) {
            jCurrentTimeMillis = jSONObject.optLong("expires_at");
        } else {
            Objects.requireNonNull(e1Var);
            jCurrentTimeMillis = (j * 1000) + System.currentTimeMillis();
        }
        return new b.i.c.m.d.s.h.f(jCurrentTimeMillis, bVar, dVar, cVar, iOptInt, iOptInt2);
    }
}
