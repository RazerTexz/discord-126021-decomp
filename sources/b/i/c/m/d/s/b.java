package b.i.c.m.d.s;

import b.i.c.m.d.k.e1;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultSettingsJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements f {
    public static long b(e1 e1Var, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        Objects.requireNonNull(e1Var);
        return (j * 1000) + System.currentTimeMillis();
    }

    @Override // b.i.c.m.d.s.f
    public b.i.c.m.d.s.h.f a(e1 e1Var, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("app");
        return new b.i.c.m.d.s.h.f(b(e1Var, iOptInt2, jSONObject), new b.i.c.m.d.s.h.b(jSONObject2.getString("status"), jSONObject2.getString("url"), jSONObject2.getString("reports_url"), jSONObject2.getString("ndk_reports_url"), jSONObject2.optBoolean("update_required", false)), new b.i.c.m.d.s.h.d(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8), 4), new b.i.c.m.d.s.h.c(jSONObject.getJSONObject("features").optBoolean("collect_reports", true)), iOptInt, iOptInt2);
    }
}
