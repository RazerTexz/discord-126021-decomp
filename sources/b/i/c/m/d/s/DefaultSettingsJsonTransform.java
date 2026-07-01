package b.i.c.m.d.s;

import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.s.h.AppSettingsData;
import b.i.c.m.d.s.h.FeaturesSettingsData;
import b.i.c.m.d.s.h.SessionSettingsData;
import b.i.c.m.d.s.h.SettingsData;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.s.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultSettingsJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    public static long b(SystemCurrentTimeProvider systemCurrentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        Objects.requireNonNull(systemCurrentTimeProvider);
        return (j * 1000) + System.currentTimeMillis();
    }

    @Override // b.i.c.m.d.s.SettingsJsonTransform
    public SettingsData a(SystemCurrentTimeProvider systemCurrentTimeProvider, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("app");
        return new SettingsData(b(systemCurrentTimeProvider, iOptInt2, jSONObject), new AppSettingsData(jSONObject2.getString("status"), jSONObject2.getString("url"), jSONObject2.getString("reports_url"), jSONObject2.getString("ndk_reports_url"), jSONObject2.optBoolean("update_required", false)), new SessionSettingsData(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8), 4), new FeaturesSettingsData(jSONObject.getJSONObject("features").optBoolean("collect_reports", true)), iOptInt, iOptInt2);
    }
}
